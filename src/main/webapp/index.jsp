<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Visão Geral</title>

    <link rel="shortcut icon" href="resources/images/logo_money_icon.svg" type="image/x-icon">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="resources/css/style.css">
</head>

<body class="container body-dashboard">
<%@include file="header.jsp"%>
<!-- Saldo Geral -->
<div class="container-fluid">
    <div class="row g-2 m-0">
        <div class="col-md-3">
            <div class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Saldo Geral</p>
                    <p class="fs-5 fw-bold text-center">R$ 800,00</p>
                </div>
                <img src="resources/images/eye_on.svg" width="36" height="36" alt="Olho aberto">
            </div>
        </div>

        <div class="col-md-3">
            <div class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Receitas</p>
                    <p class="fs-5 fw-bold text-center">R$ 9.900,00</p>
                </div>
                <img src="resources/images/up_line.svg" width="36" height="36" alt="Linha verde crescente">
            </div>
        </div>

        <div class="col-md-3">
            <div class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Despesas</p>
                    <p class="fs-5 fw-bold text-center">R$ 9.100,00</p>
                </div>
                <img src="resources/images/down_line.svg" width="36" height="36" alt="Linha verde decrescente">
            </div>
        </div>

        <div class="col-md-3">
            <div class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Investimentos</p>
                    <p class="fs-5 fw-bold text-center">R$ 900,00</p>
                </div>
                <img src="resources/images/active_line.svg" width="36" height="36" alt="Linha verde decrescente">
            </div>
        </div>


        <!-- Adicionar Receita, Despesa, Investimento-->
        <div class="row g-2 py-1">
            <div class="col-md-4 d-flex justify-content-around">
                <button class="btn btn-outline-success w-100 fs-6 fw-bold" style="background-color: #B5EFC9;"
                        data-bs-toggle="modal" data-bs-target="#addIncomeModal">Adicionar Receita</button>
            </div>
            <div class="col-md-4 d-flex justify-content-around">
                <button class="btn btn-outline-danger w-100 fs-6 fw-bold" style="background-color: #eba1a7;"
                        data-bs-toggle="modal" data-bs-target="#addExpenseModal">Adicionar Despesa</button>
            </div>
            <div class="col-md-4 d-flex justify-content-around">
                <button class="btn btn-outline-primary w-100 fs-6 fw-bold" style="background-color: #BBE8F2;"
                        data-bs-toggle="modal" data-bs-target="#addInvestmentModal">Adicionar Investimento</button>
            </div>
        </div>

        <!-- Modal para Adicionar Receita -->
        <div class="modal fade" id="addIncomeModal" tabindex="-1" aria-labelledby="addIncomeModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title fw-bold" id="addIncomeModalLabel">Adicionar Receita</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="receita" method="post">
                            <div class="mb-3">
                                <label for="incomeValue" class="form-label">Valor</label>
                                <input type="number" class="form-control input-green" id="incomeValue" required>
                            </div>
                            <div class="mb-3">
                                <label for="incomeDate" class="form-label">Data</label>
                                <input type="date" class="form-control input-green" id="incomeDate" required>
                            </div>
                            <div class="mb-3">
                                <label for="incomeCategory" class="form-label">Categoria</label>
                                <input type="text" class="form-control input-green" id="incomeCategory" required>
                            </div>
                        </form>
                    </div>
                    <div class=" col-md-12 modal-footer">
                        <button type="submit" value="Salvar" class="btn btn-modal-salvar fw-bold w-100" data-bs-dismiss="modal">Adicionar
                            Receita</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal para Adicionar Despesa -->
        <div class="modal fade" id="addExpenseModal" tabindex="-1" aria-labelledby="addExpenseModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title fw-bold" id="addExpenseModalLabel">Adicionar Despesa</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="despesa" method="post">
                            <div class="mb-3">
                                <label for="expenseValue" class="form-label">Valor</label>
                                <input type="number" class="form-control input-green" id="expenseValue" required>
                            </div>
                            <div class="mb-3">
                                <label for="expenseDate" class="form-label">Data</label>
                                <input type="date" class="form-control input-green" id="expenseDate" required>
                            </div>
                            <div class="mb-3">
                                <label for="expenseCategory" class="form-label">Categoria</label>
                                <input type="text" class="form-control input-green" id="expenseCategory" required>
                            </div>
                        </form>
                    </div>
                    <div class=" col-md-12 modal-footer">
                        <button type="button" class="btn btn-modal-salvar fw-bold w-100" data-bs-dimiss="modal">Adicionar
                            Despesa</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal para Adicionar Investimento -->
        <div class="modal fade" id="addInvestmentModal" tabindex="-1" aria-labelledby="addInvestmentModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title fw-bold" id="addInvestmentModalLabel">Adicionar Investimento</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="investimento" method="post">
                            <div class="mb-3">
                                <label for="InvestmentValue" class="form-label">Valor</label>
                                <input type="number" class="form-control input-green" id="InvestmentValue" required>
                            </div>
                            <div class="mb-3">
                                <label for="InvestmentDate" class="form-label">Data</label>
                                <input type="date" class="form-control input-green" id="InvestmentDate" required>
                            </div>
                            <div class="mb-3">
                                <label for="InvestmentCategory" class="form-label">Categoria</label>
                                <input type="text" class="form-control input-green" id="InvestmentCategory" required>
                            </div>
                        </form>
                    </div>
                    <div class=" col-md-12 modal-footer">
                        <button type="button" class="btn btn-modal-salvar fw-bold w-100" data-bs-dimiss="modal">Adicionar
                            Investimento</button>
                    </div>
                </div>
            </div>
        </div>


        <!-- Minhas Contas -->
        <div class="bg-white rounded col-md-12">
            <div class="p-2">
                <p class="fs-5 fw-bold">Minhas contas</p>
                <div class="d-flex justify-content-between align-items-center">
                    <div class="d-flex align-items-center">
                        <img class="me-2" src="resources/images/bank.svg" width="32" height="32" alt="Nubank">
                        <div>
                            <p class="custom-card-subtitle">Nubank</p>
                            <p class="custom-card-subtitle">Conta Corrente</p>
                        </div>
                    </div>
                    <p class="pe-2 fs-6 fw-bold">R$ 500,00</p>
                </div>
                <div class="d-flex justify-content-between align-items-center mt-3">
                    <div class="d-flex align-items-center">
                        <img class="me-2" src="resources/images/bank.svg" width="32" height="32" alt="C6 Bank">
                        <div>
                            <p class="custom-card-subtitle">C6 Bank</p>
                            <p class="custom-card-subtitle">Conta Corrente</p>
                        </div>
                    </div>
                    <p class="pe-2 fs-6 fw-bold">R$ 500,00</p>
                </div>
                <button class="btn btn-lg btn-outline-success w-100 fs-6 fw-bold" style="background-color: #B5EFC9;">Nova
                    Conta</button>
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

<%@include file="footer.jsp"%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>

</html>