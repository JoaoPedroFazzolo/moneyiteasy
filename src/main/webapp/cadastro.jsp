<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="light">

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

</head>

<body class="d-flex flex-column">
<div class="d-flex align-items-center justify-content-center flex-grow-1 bg-body-tertiary">
    <main class="w-100 m-auto form-container">
        <form>
            <img class="img-login mb-4" src="resources/images/logo_home_dark.svg" alt="">
            <h1 class="h4 mb-3 fw-normal text-login">É novo? Cadastre-se!</h1>
            <p class="h6 mb-3 fw-normal text-login">Todos os campos são obrigatórios</p>
        </form>
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com">
            <label for="floatingInput">Nome completo</label>
        </div>

        <div class="form-floating mt-2">
            <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com">
            <label for="floatingInput">CPF</label>
        </div>

        <div class="form-floating mt-2">
            <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
            <label for="floatingInput">E-mail</label>
        </div>

        <div class="form-floating mt-2">
            <input type="password" class="form-control" id="floatingInput" placeholder="Username">
            <label for="floatingInput">Senha</label>
        </div>

        <div class="form-check text-star my-4">
            <input type="checkbox" class="form-check-input" value="lembre-se" id="flexCheckDefault">
            <label for="flexCheckDefault">Eu concordo com os Termos de Uso e a Política de Privacidade.</label>
        </div>

        <div class="d-grid gap-2">
            <a class="btn btn-success fw-bold" href="login.jsp" role="button">Criar conta</a>
            <a class="btn btn-outline-secondary fw-bold" href="login.jsp" role="button">Voltar</a>

        </div>
    </main>
</div>

<%@include file="footer.jsp"%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

</body>

</html>