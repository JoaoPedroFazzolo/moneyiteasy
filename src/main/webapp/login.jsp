<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="light">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="shortcut icon" href="resources/images/logo_money_icon.svg" type="image/x-icon">

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <link rel="stylesheet" href="resources/css/style.css">
</head>

<body class="d-flex flex-column min-vh-100">
<div class="d-flex align-items-center justify-content-center flex-grow-1 py-4 bg-body-tertiary">
    <main class="w-100 m-auto form-container">

        <c:if test="${not empty erroLogin}">
            <div class="alert alert-danger text-center" role="alert">
                    ${erroLogin}
            </div>
        </c:if>

        <form action="login?acao" method="post">
            <img src="resources/images/logo_home_dark.svg" class="img-login mb-4" alt="Logo money-it-easy">
            <h1 class="h4 mb-3 fw-normal text-login">Por favor, faça o login</h1>
            <div class="form-floating">
                <input type="email" class="form-control" name="email" id="email" placeholder="email@example.com">
                <label for="email">E-mail</label>
            </div>
            <div class="form-floating mt-2">
                <input type="password" class="form-control" name="senha" id="senha" placeholder="password">
                <label for="senha">Senha</label>
            </div>
<%--            <div class="form-check text-star my-4">--%>
<%--                <input type="checkbox" class="form-check-input" value="lembre-se" name="lembrar" id="lembrar">--%>
<%--                <label for="lembrar">Manter-se conectado</label>--%>
<%--            </div>--%>
            <div class="d-grid gap-2 w-100 mt-3">
                <input type="submit" class="btn btn-success fw-bold" value="Entrar"></input>
                <a class="btn btn-outline-secondary fw-bold" href="cadastro.jsp" role="button">Cadastre-se</a>
            </div>
        </form>
    </main>
</div>

<%@include file="footer.jsp"%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>

</html>
