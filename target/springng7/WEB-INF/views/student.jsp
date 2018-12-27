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
    <form:form action="/students/add"  method="POST">
        ROLLNO: <input type="number" name="rollno" id="rollno"><br>
        Name: <input type="text" name="name" id="name"><br>
        Branch : <input type="text" name="branch" id="branch"><br>
        Phone: <input type="text" name="phone" id="phone"><br>
        <input type="submit" value="add">
    </form:form>
    ${student}
    DISPLAY DETAILS:
    
    <a href="/students/add">Students</a>
    <c:forEach var="lang" items="${listStudent}">
            <font color="#00CC00"><c:out value="${lang}"/>,</font>
       </c:forEach>
</body>

</html>