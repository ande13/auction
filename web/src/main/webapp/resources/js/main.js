function init(products) {
    const dataContainer = $('.products-data-container');
    $('#products-list').pagination({
        dataSource: window.location.href + '/data',
        locator: 'items',
        totalNumber: products.totalNumber,
        pageSize: products.pageSize,
        className: 'paginationjs-theme-blue',
        callback: function (data) {
            dataContainer.loadTemplate($("#product-template"), data);
            initEvents();
        }
    });
}

function initEvents() {
    const dataContainer = $('.product-bets-data-container');
    $('.product-button').click(function () {
        const id = $(this).attr('id');
        $('#product-bets-list').pagination({
            dataSource: function (done) {
                $.ajax({
                    type: 'GET',
                    data: {
                        "productId": id
                    },
                    url: window.location.origin + '/product/bets',
                    success: function (response) {
                        done(JSON.parse(response));
                    }
                });
            },
            locator: 'items',
            pageSize: 10,
            className: 'paginationjs-theme-blue',
            callback: function (data) {
                dataContainer.loadTemplate($("#product-bet-template"), data);
            }
        });
    });
}