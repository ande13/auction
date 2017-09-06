function init(products) {
    const dataContainer = $('.data-container');
    $('#demo').pagination({
        dataSource: window.location.href + '/data',
        locator: 'items',
        totalNumber: products.totalNumber,
        pageSize: products.pageSize,
        className: 'paginationjs-theme-blue',
        ajax: {
            beforeSend: function () {
                dataContainer.html('Loading data from server ...');
            }
        },
        callback: function (data, pagination) {
            // template method of yourself
            // var html = template(data);
            // dataContainer.html(html);

            console.log(data);
        }
    });
}