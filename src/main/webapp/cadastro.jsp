<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="light">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro</title>
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

        <c:if test="${not empty erroCadastro}">
            <div class="alert alert-danger text-center" role="alert">
                    ${erroCadastro}
            </div>
        </c:if>

        <form action="cadastro?acao=cadastroUsuario" method="post">
            <img class="img-login mb-4" src="resources/images/logo_home_dark.svg" alt="">
            <h1 class="h4 mb-3 fw-normal text-login">É novo? Cadastre-se!</h1>
            <p class="h6 mb-3 fw-normal text-login">Todos os campos são obrigatórios</p>
        <div class="form-floating">
            <input type="text" class="form-control" name="nomeUsuario" id="nomeUsuario" placeholder="name@example.com">
            <label for="nomeUsuario">Nome completo</label>
        </div>

        <div class="form-floating mt-2">
            <input type="text" class="form-control" name="cpfUsuario" id="cpfUsuario" placeholder="name@example.com">
            <label for="cpfUsuario">CPF</label>
        </div>

        <div class="form-floating mt-2">
            <input type="email" class="form-control" name="emailusuario" id="emailusuario" placeholder="name@example.com">
            <label for="emailusuario">E-mail</label>
        </div>

        <div class="form-floating mt-2">
            <input type="password" class="form-control" name="senhaUsuario" id="senhaUsuario" placeholder="Username">
            <label for="senhaUsuario">Senha</label>
        </div>

<%--        <div class="form-check text-star my-4">--%>
<%--            <input type="checkbox" class="form-check-input" value="lembre-se" id="flexCheckDefault">--%>
<%--            <label for="flexCheckDefault">Eu concordo com os Termos de Uso e a Política de Privacidade.</label>--%>
<%--        </div>--%>

        <div class="d-grid gap-2 mt-3">
            <input type="submit" class="btn btn-success fw-bold" value="Criar conta">
            <a class="btn btn-outline-secondary fw-bold" href="login.jsp" role="button">Voltar</a>

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