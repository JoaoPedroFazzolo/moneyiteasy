<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="light">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="shortcut icon" href="./resources/images/logo_money_icon.svg" type="image/x-icon">

    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
    <link rel="stylesheet" href="./resources/css/login.css">
</head>

<body class="d-flex flex-column min-vh-100">
<div class="d-flex align-items-center justify-content-center flex-grow-1 py-4 bg-body-tertiary">
    <main class="w-100 m-auto form-container">
        <form>
            <img src="./resources/images/logo_home_dark.svg" class="img-login mb-4" alt="Logo money-it-easy">
            <h1 class="h4 mb-3 fw-normal text-login">Por favor, faça o login</h1>
        </form>
        <div class="form-floating">
            <input type="email" class="form-control" id="email" placeholder="name@example.com">
            <label for="email">E-mail</label>
        </div>
        <div class="form-floating mt-2">
            <input type="password" class="form-control" id="password" placeholder="password">
            <label for="password">Senha</label>
        </div>
        <div class="form-check text-star my-4">
            <input type="checkbox" class="form-check-input" value="lembre-se" id="flexCheckDefault">
            <label for="flexCheckDefault">Manter-se conectado</label>
        </div>
        <div class="d-grid gap-2 col-6 mx-auto">
            <a class="btn btn-success fw-bold" href="./index.html" role="button">Login</a>
            <a class="btn btn-outline-secondary fw-bold" href="#" role="button">Cadastre-se</a>
        </div>
    </main>
</div>

<footer class="border-top bg-body-tertiary">
    <div class="d-flex flex-wrap justify-content-between align-items-center py-3 ms-4 me-4">
        <div class="col-md-4 d-flex align-items-center">
            <a class="mb-3 me-2 mb-md-0 text-body-secondary text-decoration-none lh-1" href="/login.html">
                <img src="./resources/images/logo_money_icon.svg" alt="Logo money it easy">
            </a>
            <span>© 2024, FIAP | 1TDSOE - Grupo 08</span>
        </div>
        <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
            <li class="ms-3">
                <a class="social-icons bi bi-linkedin" href="https://https://www.linkedin.com/in/joao-fazzolo">
                </a>
            </li>
            <li class="ms-3">
                <a class="social-icons bi bi-instagram" href="https://www.linkedin.com/in/osmarjosefacinjr">
                </a>
            </li>
            <li class="ms-3">
                <a class="social-icons bi bi-github" href="https://https://github.com/JoaoPedroFazzolo/moneyiteasy">
                </a>
            </li>
        </ul>
    </div>
</footer>
</body>

</html>
