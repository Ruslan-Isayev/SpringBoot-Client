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
                <th>Surname</th>
                <th>Dob</th>
                <th>Phone</th>
                <th>Cif</th>
            </tr>
            <c:forEach items="${result}" var="r">
                <tr>
                    <td>${r.customerId}</td>
                    <td>${r.name}</td>
                    <td>${r.surname}</td>
                    <td>${r.dob}</td>
                    <td>${r.phone}</td>
                    <td>${r.cif}</td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>

</c:choose>
</body>
</html>
