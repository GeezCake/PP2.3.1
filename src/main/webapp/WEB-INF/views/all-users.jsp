<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Users</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .delete-form { display: inline; margin: 0; padding: 0; }
        .delete-btn {
            background: none;
            border: none;
            color: red;
            text-decoration: underline;
            cursor: pointer;
            padding: 0;
            font: inherit;
        }
    </style>
</head>
<body>
<h2>Users List</h2>

<c:if test="${not empty users}">
    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>
                    <a href="/update?id=${user.id}">Edit</a>
                    &nbsp;|&nbsp;
                    <!-- Форма для DELETE с использованием _method -->
                    <form class="delete-form" action="/delete" method="POST">
                        <input type="hidden" name="_method" value="DELETE">
                        <input type="hidden" name="id" value="${user.id}">
                        <button type="submit" class="delete-btn"
                                onclick="return confirm('Delete user ${user.firstName} ${user.lastName}?')">
                            Delete
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${empty users}">
    <p>No users found. <a href="/add">Add the first user</a></p>
</c:if>

<br/>
<a href="/add">Add New User</a>

</body>
</html>