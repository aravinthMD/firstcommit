<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<body>
                            DISPLAY DETAILS:
                            ${listStudent}
    <c:forEach var="lang" items="${listStudent}">
            <font color="#00CC00"><c:out value="${lang}"/>,</font>
       </c:forEach>
</body>

</html>