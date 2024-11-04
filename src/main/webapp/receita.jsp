<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Receitas</title>

    <link rel="shortcut icon" href="resources/images/logo_money_icon.svg" type="image/x-icon">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="resources/css/style.css">
</head>

<body class="container body-dashboard">

<!-- Navbar -->
<header class="bg bg-header">
    <nav class="navbar navbar-expand-md navbar-dark m-3 p-2 header-container">
        <a href="#" class="navbar-brand d-flex align-items-center">
            <img src="resources/images/logo_home_light.svg" alt="Logo" style="height: 30px;">
        </a>
        <span class="text-white">Boa tarde, <strong>Junior</strong></span>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarContent">
            <ul class="navbar-nav mx-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Visão Geral</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="receita.jsp">Receitas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="despesa.jsp">Despesas</a>
                </li>
            </ul>
            <div class="d-flex align-items-center">
                <a href="#" class="text-white me-3">
                    <i class="bi bi-bell" style="font-size: 1.5rem"></i>
                </a>
                <div class="dropdown">
                    <a href="login.jsp" class="text-white">
                        <i class="bi bi-person-circle" style="font-size: 1.5rem"></i>
                    </a>
                </div>
            </div>
        </div>
    </nav>
</header>


<!-- Saldo Geral -->
<div class="container-fluid">
    <div class="row g-2 m-0">
        <div class="col-md-4">
            <div
                    class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Total de Receitas</p>
                    <p class="fs-5 fw-bold text-center">R$ 9.900,00</p>
                </div>
                <img src="resources/images/eye_on.svg" width="36" height="36" alt="Olho aberto">
            </div>
        </div>

        <div class="col-md-4">
            <div
                    class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Receitas</p>
                    <p class="fs-5 fw-bold text-center">R$ 9.400,00</p>
                </div>
                <img src="resources/images/up_line.svg" width="36" height="36" alt="Linha verde crescente">
            </div>
        </div>

        <div class="col-md-4">
            <div
                    class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Investimentos</p>
                    <p class="fs-5 fw-bold text-center">R$ 500,00</p>
                </div>
                <img src="resources/images/active_line.svg" width="36" height="36" alt="Linha verde decrescente">
            </div>
        </div>

        <!-- Tabela -->
        <div class="bg-white rounded col-md-12">
            <div class="p-2">
                <p class="fs-5 fw-bold">Registro de Receitas</p>
                <div class="justify-content-between align-items-center">
                    <div class="table-container mt-4">
                        <input type="text" class="form-control mb-3" id="searchInput" placeholder="Buscar por">
                        <div class="table-responsive">
                            <table class="table table-striped text-center">
                                <thead>
                                <tr>
                                    <th>Valor Recebido</th>
                                    <th>Data</th>
                                    <th>Categoria</th>
                                </tr>
                                </thead>
                                <tbody id="transactionTable">
                                <tr>
                                    <td>R$ 400,00</td>
                                    <td>16/11/2024</td>
                                    <td>Pix</td>
                                </tr>
                                <tr>
                                    <td>R$ 4.400,00</td>
                                    <td>15/11/2024</td>
                                    <td>Salário</td>
                                </tr>
                                <tr>
                                    <td>R$ 200,00</td>
                                    <td>12/11/2024</td>
                                    <td>Presente</td>
                                </tr>
                                <tr>
                                    <td>R$ 500,00</td>
                                    <td>10/11/2024</td>
                                    <td>Reembolso</td>
                                </tr>
                                <tr>
                                    <td>R$ 4.400,00</td>
                                    <td>30/10/2024</td>
                                    <td>Salário</td>
                                </tr>
                                <tr>
                                    <td>R$ 500,00</td>
                                    <td>19/10/2024</td>
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
