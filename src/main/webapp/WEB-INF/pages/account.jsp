<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>

    <c:when test="${not empty message}">
        <label style="color: red">${message}</label>
    </c:when>

    <c:otherwise>
        <table style="width: 100%" border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>AccountNo</th>
                <th>Iban</th>
                <th>Currency</th>
                <th>BranchCode</th>
                <th>CustomerFullName</th>
            </tr>
            <c:forEach items="${result}" var="r">
                <tr>
                    <td>${r.id}</td>
                    <td>${r.name}</td>
                    <td>${r.accountNo}</td>
                    <td>${r.iban}</td>
                    <td>${r.currency}</td>
                    <td>${r.branchCode}</td>
                    <td>${r.customer.name} ${r.customer.surname}</td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>

</c:choose>
</body>
</html>
