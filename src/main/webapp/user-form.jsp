<%--
  Created by IntelliJ IDEA.
  User: lhuth
  Date: 29/07/2022
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>

<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato;">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand">
                APP - Gerenciamento de Usuários
            </a>
        </div>
        <ul class="navbar-nav">
            <li>
                <a href="<%=request.getContextPath()%>/list" class="nav-link">
                    Usuários
                </a>
            </li>
        </ul>
    </nav>
</header>
<br>

<div class="container col-md-5">
    <div class="card">
        <div class="card-body">

            <c:if test="${user != null}">
            <form action="update" method="post">
                </c:if>

            <c:if test="${user == null}">
            <form action="insert" method="post">
                </c:if>

                <caption>
                    <h2>
                        <c:if test="${user != null}">
                            Editar Usuário
                        </c:if>
                        <c:if test="${user == null}">
                            Adicionar Novo Usuário
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${user != null}">
                    <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
                </c:if>

                <fieldset class="form-group">
                    <label>Nome de Usuário
                        <input type="text" value="<c:out value='${user.nome}' />"
                               class="form-control" name="nome" required="required">
                    </label>
                </fieldset>

                <fieldset>
                    <label>E-mail
                        <input type="email" value="<c:out value='${user.email}' />"
                               class="form-control" name="email" required="required">
                    </label>
                </fieldset>

                <fieldset>
                    <label>País
                        <input type="text" value="<c:out value='${user.country}' />"
                               class="form-control" name="country">
                    </label>
                </fieldset>

                <button type="submit" class="btn btn-success">Salvar</button>
            </form>

        </div>
    </div>
</div>

</body>
</html>
