<%--
  Created by IntelliJ IDEA.
  User: lucaspadua
  Date: 28/07/2022
  Time: 07:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
      <title>Title</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous">
  </head>

    <body>

      <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato;">
          <div>
            <a href="https://www.javaguides.net" class="navbar-brand">
              Aplicação de Gerenciamento de Usuário
            </a>
          </div>
          <ul class="navbar-nav">
            <li>
              <a href="<%=request.getContextPath()%>/list" class="nav-link">
                Users
              </a>
            </li>
          </ul>
        </nav>
      </header>
      <br>

      <div class="row">
        <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

        <div class="container">
          
          <h3 class="textcenter">
            List of Users
          </h3>
          <hr>

          <div class="container text-left">
            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">
              Adicionar Novo Usuário
            </a>
          </div>
          <br>

          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>País</th>
                <th>Ações</th>
              </tr>
            </thead>

            <tbody>
              <!--   for (Todo todo: todos) {  -->

                <c:forEach var="user" items="${listUser}">

                <tr>
                  <td>
                    <c:out value="${user.id}"/>
                  </td>
                  <td>
                    
                  </td>
                </tr>
                </c:forEach>
            </tbody>
          </table>
        </div>
      </div>

    </body>
</html>
