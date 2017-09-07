const selectedProduct = {};

function init(products) {
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
        $('#product-bets-list').pagination({
            dataSource: done => {
                $.ajax({
                    type: 'GET',
                    data: {
                        "productId": selectedProduct.id
                    },
                    url: window.location.origin + '/product/bets',
                    success: response => {
                        done(JSON.parse(response));
                    },
                    error: err => {
                        const e = JSON.parse(err.responseText);
                        console.log(e.error);
                    }
                });
            },
            locator: 'items',
            pageSize: 10,
            className: 'paginationjs-theme-blue',
            callback: data => {
                dataContainer.loadTemplate($("#product-bet-template"), data);
                const bets = $('#product-bets-list');
                if (bets.is(':hidden')) {
                    bets.show()
                }
            }
        });
    });

    $('#addBetButton').click(() => {
        const modalWindow = $('#addBetModal');
        modalWindow.find('#addBetModalLabel').text('Add bet for product: ' + selectedProduct.id);
        modalWindow.modal('show');
    });

    $('#submitBet').click(() => {
        const price = $('#betValue').val();
        if (!isNormalInteger(price)) {
            return;
        }
        $.ajax({
            type: 'POST',
            data: {
                "productId": selectedProduct.id,
                "price": parseInt(price)
            },
            url: window.location.origin + '/product/bets/submit',
            success: () => {
                $("#success-container").text('Bet successfully added').fadeIn().delay(2000).fadeOut();
                $('#addBetModal').modal('hide');
            },
            error: err => {
                const e = JSON.parse(err.responseText);
                $("#error-container").text(e.error).fadeIn().delay(2000).fadeOut();
            }
        })
    });
}

function isNormalInteger(str) {
    return /^\+?(0|[1-9]\d*)$/.test(str);
}