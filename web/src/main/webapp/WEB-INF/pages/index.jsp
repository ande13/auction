<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Auction</title>
    <script src="/resources/js/jquery-3.2.1.min.js"></script>
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
</head>
<body>

<div id="demo">
    <div class="data-container"></div>
</div>

<%--<table border="1" cellpadding="5" cellspacing="5">--%>
    <%--<tr>--%>
        <%--<th>Product name</th>--%>
    <%--</tr>--%>

    <%--<c:forEach var="item" items="${productsModel.productsItems}">--%>
        <%--<tr>--%>
            <%--<td>${item.name}</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>

<%--<table border="1" cellpadding="5" cellspacing="5">--%>
    <%--<tr>--%>
        <%--<c:forEach begin="1" end="${productsModel.pageCount}" var="i">--%>
            <%--<c:choose>--%>
                <%--<c:when test="${productsModel.pageNumber eq i}">--%>
                    <%--<td>${i}</td>--%>
                <%--</c:when>--%>
                <%--<c:otherwise>--%>
                    <%--<td><a href="/auction/products/page/${i}">${i}</a></td>--%>
                <%--</c:otherwise>--%>
            <%--</c:choose>--%>
        <%--</c:forEach>--%>
    <%--</tr>--%>
<%--</table>--%>

</body>
</html>