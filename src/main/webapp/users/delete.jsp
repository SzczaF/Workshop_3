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
        <a href="<c:url value="/user/list"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-list fa-sm text-white-50"></i> Lista użytkowników</a>
    </div>

    <!-- Content Row -->
    <!-- Basic Card Example -->
    <div class="card shadow mb-4">
        <div class="card-header">
            <h6 class="m-0 font-weight-bold text-primary">Usuwanie użytkownika</h6>
        </div>
        <div class="card-body">
            <%@ include file="userDetail.jsp" %>

            <h6 class="text-danger font-weight-bold">Czy chcesz, aby użytkownik
                <span class="font-weight-bolder text-primary">${user.userName}</span> został usunięty?
            </h6>

            <div class="d-sm-flex">
                <a href="<c:url value="/user/list"/>"><button class="btn btn-primary mr-2">Anuluj</button></a>
                <form method="post">
                    <input type="hidden" name="Id" class="form-control" id="Id" value="${user.id}">
                    <button type="submit" class="btn btn-danger">Usuń</button>
                </form>
            </div>

        </div>
    </div>


</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>