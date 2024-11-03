<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Money It Easy</title>
    <link rel="shortcut icon" href="./resources/images/logo_money_icon.svg" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css" />
    <link rel="stylesheet" href="./resources/css/style.css" />
    <link rel="stylesheet" href="./resources/css/bootstrap.css" />
</head>

<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-md bg-black navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="./login.jsp">
            <img src="./resources/images/logo_home_light.svg" alt="Logo do Money It Easy" />
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Dashboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Receitas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Despesas</a>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2 rounded-0" type="search" placeholder="Digite a categoria"
                       aria-label="Pesquisar" />
                <button class="btn btn-outline-light rounded-0" type="submit">Buscar</button>
            </form>
        </div>
    </div>
</nav>

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

<footer class="text-center bg-black text-bg-dark mt-4">
    <p class="card-text py-3">
        2024 <i class="bi bi-c-circle"></i> Desenvolvido por Junior F. | Projeto: Fintech - FIAP </p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>

</html>