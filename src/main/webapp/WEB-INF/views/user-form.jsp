<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
<h2>User Form</h2>

<form action="/save" method="post">
    <input type="hidden" name="id" value="${user.id}">

    First Name: <input type="text" name="firstName" value="${user.firstName}" required><br/>
    Last Name: <input type="text" name="lastName" value="${user.lastName}" required><br/>
    Email: <input type="email" name="email" value="${user.email}" required><br/>

    <input type="submit" value="Save">
</form>
<br/>
<a href="/">Back to List</a>

</body>
</html>