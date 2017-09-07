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
    <script type="text/html" id="product-bet-template">
        <div class="card col-2">
            <div class="card-body">
                <h4 class="card-title" data-content="price"></h4>
                <h6 class="card-subtitle mb-2 text-muted" data-content="productId"></h6>
                <p class="card-text" data-content-append="creationDate">Some price for product. Date: </p>
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
    <div id="product-bets-list" class="jumbotron">
        <div class="product-bets-buttons-wrapper row">
            <button id="addBetButton" type="button" class="btn btn-success col-1" data-toggle="modal" data-target="#addBetModal">Add bet</button>
        </div>
        <div class="product-bets-data-container row"></div>
    </div>
</div>

<div class="modal fade" id="addBetModal" tabindex="-1" role="dialog" aria-labelledby="addBetModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addBetModalLabel"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="input-group">
                    <span class="input-group-addon">$</span>
                    <span class="input-group-addon">1234</span>
                    <input id="betValue" type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
                </div>
                <div id="success-container" class="alert alert-success" role="alert">
                </div>
                <div id="error-container" class="alert alert-danger" role="alert">
                </div>
            </div>
            <div class="modal-footer">
                <button id="submitBet" type="button" class="btn btn-primary">Add</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>