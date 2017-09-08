const selectedProduct = {};
const Products = {
    count: 0
};

function init(products) {

    const socket = new WebSocket("ws://" + location.host + "/myHandler");
    socket.onopen = function () {
        console.log("connected");
        setInterval(() => {
            socket.send('CHECK-DATA');
        }, 1000);
    };

    socket.onclose = function (event) {
        if (event.wasClean) {
            console.log('connection closed');
        } else {
            console.log('connection terminated');
        }
        console.log('Code: ' + event.code + ' reason: ' + event.reason);
    };

    socket.onmessage = function (event) {
        const response = JSON.parse(event.data);
        if (response.count !== Products.count) {
            Products.count = response.count;
            const dataContainer = $('.products-data-container');
            let pageNum = 1;
            try {
                pageNum = $('#products-list').pagination('getSelectedPageNum');
            } catch (err){
                console.log('pagination is not init');
            }
            $('#products-list').pagination({
                dataSource: window.location.href + '/data',
                locator: 'items',
                totalNumber: response.count,
                pageSize: 10,
                className: 'paginationjs-theme-blue',
                callback: data => {
                    dataContainer.loadTemplate($("#product-template"), data);
                    initEvents();
                }
            });
            $('#products-list').addHook('afterRender', function(isForced) {
                $('#products-list').pagination('go', pageNum);
            });
        }
    };

    socket.onerror = function (error) {
        console.log("Error " + error.message);
    };
}

function initProducts(products) {
    const dataContainer = $('.products-data-container');
    $('#products-list').pagination({
        dataSource: window.location.href + '/data',
        locator: 'items',
        totalNumber: products.totalNumber,
        pageSize: products.pageSize,
        className: 'paginationjs-theme-blue',
        callback: data => {
            dataContainer.loadTemplate($("#product-template"), data);
            initEvents();
        }
    });
}

function initEvents() {
    const dataContainer = $('.product-bets-data-container');
    $('.product-button').click(event => {
        selectedProduct.id = $(event.currentTarget).attr('id');
        new Promise((resolve, reject) => {
            $.ajax({
                type: 'GET',
                data: {
                    "productId": selectedProduct.id
                },
                url: window.location.origin + '/product/bets/count',
                success: response => {
                    return resolve(response);
                },
                error: err => {
                    const e = JSON.parse(err.responseText);
                    return reject(e.error);
                }
            });
        }).then(count => {
            return new Promise(resolve => {
                $('#product-bets-list').pagination({
                    dataSource: window.location.origin + '/product/bets',
                    locator: 'items',
                    totalNumber: parseInt(count),
                    pageSize: 10,
                    className: 'paginationjs-theme-blue',
                    ajax: {
                        data: {
                            "productId": selectedProduct.id
                        }
                    },
                    callback: data => {
                        return resolve(data);
                    }
                });
            });
        }).then(data => {
            dataContainer.loadTemplate($("#product-bet-template"), data);
            const bets = $('#product-bets-list');
            if (bets.is(':hidden')) {
                bets.show()
            }
        }).catch(err => {
            $(".alert-danger").text(err).fadeIn().delay(2000).fadeOut();
        });
    });


    $('#addBetButton').click(() => {
        const modalWindow = $('#addBetModal');
        modalWindow.find('#addBetModalLabel').text('Add bet for product: ' + selectedProduct.id);
        modalWindow.modal('show');
    });

    $('#submitBet').click(() => {
        const price = $('#betValue').val();
        new Promise((resolve, reject) => {
            return isNormalInteger(price) && price > 0 ? resolve() : reject('Please enter normal price');
        }).then(() => {
            return new Promise((resolve, reject) => {
                $.ajax({
                    type: 'POST',
                    data: {
                        "productId": selectedProduct.id,
                        "price": parseInt(price)
                    },
                    url: window.location.origin + '/product/bets/submit',
                    success: () => {
                        return resolve();
                    },
                    error: err => {
                        const e = JSON.parse(err.responseText);
                        return reject(e.error);
                    }
                })
            })
        }).then(() => {
            $('#addBetModal').modal('hide');
            $("#success-container").text('Bet successfully added').fadeIn().delay(4000).fadeOut();
        }).catch(err => {
            $(".alert-danger").text(err).fadeIn().delay(4000).fadeOut();
        });
    });
}

function isNormalInteger(str) {
    return /^\+?(0|[1-9]\d*)$/.test(str);
}