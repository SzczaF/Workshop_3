<%--
  Created by IntelliJ IDEA.
  User: szczaf
  Date: 18.12.2022
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>


<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
        <a href="<c:url value="/user/add"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-user-plus fa-sm text-white-50"></i> Dodaj użytkownika</a>
    </div>

    <!-- Content Row -->
    <!-- Basic Card Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Lista użytkowników</h6>
        </div>
        <div class="card-body">

            <table class="table table-hover">
                <tr>
                    <th>ID</th>
                    <th>Nazwa Użytkownika</th>
                    <th>E-mail</th>
                    <th>Akcja</th>
                </tr>

                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.userName}</td>
                        <td>${user.email}</td>
                        <td>
                            <%@include file="buttons_show_edit_delete.jsp" %>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>


</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>