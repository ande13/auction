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
    $('.product-button').click(function () {
        console.log(this);
    });
}