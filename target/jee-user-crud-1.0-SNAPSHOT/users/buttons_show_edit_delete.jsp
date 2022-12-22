<%--
  Created by IntelliJ IDEA.
  User: szczaf
  Date: 22.12.2022
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<a href="<c:url value="/user/show?id=${user.id}"/>" class="btn-sm btn-info btn-icon-split">
    <span class="icon text-white-50">
        <i class="fas fa-info-circle"></i>
    </span>
    <span class="text">Show</span>
</a>
<a href="<c:url value="/user/edit?id=${user.id}"/>" class="btn-sm btn-warning btn-icon-split">
    <span class="icon text-white-50">
        <i class="fas fa-edit"></i>
    </span>
    <span class="text">Edit</span>
</a>
<a href="<c:url value="/user/delete?id=${user.id}"/>" class="btn-sm btn-danger btn-icon-split">
    <span class="icon text-white-50">
        <i class="fas fa-trash"></i>
    </span>
    <span class="text">Delete</span>
</a>