<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Auction</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/pagination.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap/4.0.0-beta/bootstrap.min.css">
    <script src="/resources/js/jquery/jquery-3.2.1.min.js"></script>
    <script src="/resources/js/jquery/jquery.loadTemplate-1.4.4.js"></script>
    <script src="/resources/js/bootstrap/popper.min.js"></script>
    <script src="/resources/js/bootstrap/4.0.0-beta/bootstrap.min.js"></script>
    <script src="/resources/js/pagination.js"></script>
    <script src="/resources/js/main.js"></script>
    <script>
        $(document).ready(function () {
            init({
                totalNumber: ${productsModel.countOfAllRecords},
                pageSize: ${productsModel.itemsPerPage}
            });
        });
    </script>
    <script type="text/html" id="product-template">
        <div class="card col-2">
            <div class="card-body">
                <h4 class="card-title" data-content="name"></h4>
                <h6 class="card-subtitle mb-2 text-muted" data-content="name"></h6>
                <p class="card-text">Some information about product</p>
                <button type="button" class="btn btn-info product-button" data-id="id">Show bets</button>
            </div>
        </div>
    </script>
</head>
<body>

<div class="content-container">
    <div id="products-list" class="jumbotron">
        <div class="products-data-container row">
            <div class="jumbotron">
                <h1 class="display-3">Downloading data ...</h1>
            </div>
        </div>
    </div>
    <div class="product-bets-list"></div>
</div>

</body>
</html>