<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR" data-bs-theme="light">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Visão Geral | Money It Easy</title>

    <link rel="shortcut icon" href="./resources/images/logo_money_icon.svg" type="image/x-icon">
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="./resources/css/header.css" />
    <link rel="stylesheet" href="./resources/css/style.css">
    <link rel="stylesheet" href="./resources/css/login.css">
</head>

<body>
<!-- Navbar -->
<header class="bg-success">
    <nav class="navbar navbar-expand-md navbar-dark m-3 p-2 header-container">
        <a href="#" class="navbar-brand d-flex align-items-center">
            <img src="./resources/images/logo_home_light.svg" alt="Logo" style="height: 30px;">
        </a>
        <span class="text-white ms-3">Boa tarde, <strong>Junior</strong></span>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarContent">
            <ul class="navbar-nav mx-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Visão Geral</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Receitas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Despesas</a>
                </li>
            </ul>
            <div class="d-flex align-items-center">
                <a href="#" class="text-white me-3">
                    <i class="bi bi-bell" style="font-size: 1.5rem"></i>
                </a>
                <a href="#" class="text-white">
                    <i class="bi bi-person-circle" style="font-size: 1.5rem"></i>
                </a>
            </div>
        </div>
    </nav>
</header>


<!-- Saldo Geral -->
<div class="container-fluid px-4">
    <div class="row g-3 my-2 align-items-stretch">
        <div class="col-md-3">
            <div class="p-3 bg-white shadow-sm d-flex flex-column justify-content-between align-items-center rounded h-100">
                <div>
                    <p class="fs-5">Saldo Geral</p>
                    <h3 class="fs-2">R$ 990,00</h3>
                </div>
                <img class="fas fa-gift fs-1 rounded-full p-3" src="./resources/images/eye_on.svg" alt="Ícone de Olho" />
            </div>
        </div>

        <div class="col-md-3">
            <div class="p-3 bg-white shadow-sm d-flex flex-column justify-content-between align-items-center rounded h-100">
                <div>
                    <p class="fs-5">Receita Mensal</p>
                    <h4 class="fs-2">R$ 1.000,00</h4>
                </div>
                <img src="./resources/images/up_line.svg" alt="Linha verde crescente">
            </div>
        </div>

        <div class="col-md-3">
            <div class="p-3 bg-white shadow-sm d-flex flex-column justify-content-between align-items-center rounded h-100">
                <div>
                    <p class="fs-5">Despesa Mensal</p>
                    <h4 class="fs-2">R$ 1.000,00</h4>
                </div>
                <img src="./resources/images/down_line.svg" alt="Linha verde decrescente">
            </div>
        </div>

        <div class="col-md-3">
            <div class="p-3 bg-white shadow-sm d-flex flex-column justify-content-between align-items-center rounded h-100">
                <div>
                    <h4 class="fs-2">Relatório</h4>
                </div>
                <img src="./resources/images/active_line.svg" alt="Linha de atividade preta">
            </div>
        </div>
    </div>
</div>


<!-- Adicionar Receita e Despesa -->
<div class="row g-3 my-2">
    <div class="col-md-6 d-flex justify-content-around">
        <button id="btnAdicionarReceita" class="btn btn-success btn-lg w-100 mx-1">Adicionar Receita</button>
    </div>
    <div class="col-md-6 d-flex justify-content-around">
        <button id="btnAdicionarDespesa" class="btn btn-danger btn-lg w-100 mx-1">Adicionar Despesa</button>
    </div>
</div>

<!-- Minhas Contas -->
<div class="row g-3 my-2">
    <div class="col-md-12">
        <div class="custom-card">
            <p class="custom-card-title">Minhas contas</p>
            <div class="d-flex justify-content-between align-items-center mt-3">
                <div class="d-flex align-items-center">
                    <img src="./resources/images/bank.svg" alt="Nubank">
                    <div>
                        <p class="custom-card-subtitle">Nubank</p>
                        <p class="custom-card-subtitle">Conta Corrente</p>
                    </div>
                </div>
                <p class="account-balance">R$ 500,00</p>
            </div>
            <div class="d-flex justify-content-between align-items-center mt-3">
                <div class="d-flex align-items-center">
                    <img src="./resources/images/bank.svg" alt="C6 Bank">
                    <div>
                        <p class="custom-card-subtitle">C6 Bank</p>
                        <p class="custom-card-subtitle">Conta Corrente</p>
                    </div>
                </div>
                <p class="account-balance">R$ 500,00</p>
            </div>
            <div class="new-account">
                <span class="fs-4">Nova Conta</span>
            </div>
        </div>
    </div>
</div>

<!-- Filtro de Transações -->
<div class="row g-3 my-2">
    <div class="col-md-12">
        <div class="custom-card">
            <ul class="nav nav-tabs transaction-filter">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Todos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Receita</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Despesa</a>
                </li>
            </ul>
            <div class="mt-3">
                <input class="form-control" type="search" placeholder="Buscar por" aria-label="Buscar">
            </div>
            <div class="transaction-item d-flex justify-content-between align-items-center mt-3">
                <div>
                    <p class="transaction-title">Nubank</p>
                    <p class="transaction-date">Data da despesa 18/04/2024</p>
                </div>
                <div class="d-flex align-items-center">
                    <span class="transaction-type despesa">Despesa</span>
                    <p class="transaction-amount ms-3">R$ 10,00</p>
                </div>
            </div>
            <div class="transaction-item d-flex justify-content-between align-items-center mt-3">
                <div>
                    <p class="transaction-title">C6 Bank</p>
                    <p class="transaction-date">Data da despesa 18/04/2024</p>
                </div>
                <div class="d-flex align-items-center">
                    <span class="transaction-type receita">Receita</span>
                    <p class="transaction-amount ms-3">R$ 500,00</p>
                </div>
            </div>
            <div class="transaction-item d-flex justify-content-between align-items-center mt-3">
                <div>
                    <p class="transaction-title">Nubank</p>
                    <p class="transaction-date">Data da despesa 18/04/2024</p>
                </div>
                <div class="d-flex align-items-center">
                    <span class="transaction-type receita">Receita</span>
                    <p class="transaction-amount ms-3">R$ 500,00</p>
                </div>
            </div>
        </div>
    </div>
</div>
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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>

</html>
