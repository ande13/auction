<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Auction</title>
</head>
<body>

<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <th>Product name</th>
    </tr>

    <c:forEach var="item" items="${productsModel.productsItems}">
        <tr>
            <td>${item.name}</td>
        </tr>
    </c:forEach>
</table>

<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <c:forEach begin="1" end="${productsModel.pageCount}" var="i">
            <c:choose>
                <c:when test="${productsModel.pageNumber eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="/auction/products/page/${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>

</body>
</html>