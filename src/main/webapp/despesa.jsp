<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Visão Geral | Money It Easy</title>

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
        <div class="col-md-4">
            <div
                    class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Total de Despesas</p>
                    <p class="fs-5 fw-bold text-center">R$ 9.100,00</p>
                </div>
                <img src="resources/images/eye_on.svg" width="36" height="36" alt="Olho aberto">
            </div>
        </div>

        <div class="col-md-4">
            <div
                    class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Despesas</p>
                    <p class="fs-5 fw-bold text-center">R$ 8.400,00</p>
                </div>
                <img src="resources/images/down_line.svg" width="36" height="36" alt="Linha verde decrescente">
            </div>
        </div>

        <div class="col-md-4">
            <div
                    class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Investimentos</p>
                    <p class="fs-5 fw-bold text-center">R$ 600,00</p>
                </div>
                <img src="resources/images/active_line.svg" width="36" height="36" alt="Linha verde decrescente">
            </div>
        </div>

        <!-- Tabela -->
        <div class="bg-white rounded col-md-12">
            <div class="p-2">
                <p class="fs-5 fw-bold">Registro de Despesas</p>
                <div class="justify-content-between align-items-center">
                    <div class="table-container mt-4">
                        <input type="text" class="form-control mb-3" id="searchInput" placeholder="Buscar por">
                        <div class="table-responsive">
                            <table class="table table-striped text-center">
                                <thead>
                                <tr>
                                    <th>Valor Gasto</th>
                                    <th>Data</th>
                                    <th>Categoria</th>
                                </tr>
                                </thead>
                                <tbody id="transactionTable">
                                <tr>
                                    <td>R$ 500,00</td>
                                    <td>17/11/2024</td>
                                    <td>Mercado</td>
                                </tr>
                                <tr>
                                    <td>R$ 4.000,00</td>
                                    <td>16/11/2024</td>
                                    <td>Aluguel</td>
                                </tr>
                                <tr>
                                    <td>R$ 500,00</td>
                                    <td>11/11/2024</td>
                                    <td>Presente</td>
                                </tr>
                                <tr>
                                    <td>R$ 500,00</td>
                                    <td>08/11/2024</td>
                                    <td>Roupas</td>
                                </tr>
                                <tr>
                                    <td>R$ 3.000,00</td>
                                    <td>30/10/2024</td>
                                    <td>Carro</td>
                                </tr>
                                <tr>
                                    <td>R$ 600,00</td>
                                    <td>17/10/2024</td>
                                    <td>Investimento</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
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
