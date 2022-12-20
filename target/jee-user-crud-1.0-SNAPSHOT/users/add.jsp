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
        <a href="<c:url value="/user/list"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i>Lista użytkowników</a>
    </div>

    <!-- Content Row -->
    <!-- Basic Card Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Dodaj użytkownika</h6>
        </div>
        <div class="card-body">
            <form method="post">

                <div class="form-group">
                    <label for="inputUser">Nazwa</label>
                    <input type="text" name ="inputUser" class="form-control" id="inputUser" placeholder="Nazwa użytkownika...">

                </div>
                <div class="form-group">
                    <label for="inputEmail">Email</label>
                    <input type="email" name ="inputEmail"class="form-control" id="inputEmail" placeholder="user@example.com">

                </div>
                <div class="form-group">
                    <label for="inputPassword">Password</label>
                    <input type="password" name ="inputPassword" class="form-control" id="inputPassword" placeholder="Hasło użytkownika...">
                </div>

                <button type="submit" class="btn btn-primary">Zapisz</button>
            </form>

        </div>
    </div>


</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>