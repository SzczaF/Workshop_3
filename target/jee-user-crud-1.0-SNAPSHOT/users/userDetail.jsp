<%--
  Created by IntelliJ IDEA.
  User: szczaf
  Date: 22.12.2022
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="table">
    <tr>
        <td class="font-weight-bold">ID</td>
        <td>${user.id}</td>
    </tr>
    <tr>
        <td class="font-weight-bold">Nazwa Użytkownika</td>
        <td>${user.userName}</td>
    </tr>
    <tr>
        <td class="font-weight-bold">E-mail</td>
        <td>${user.email}</td>
    </tr>
</table>
