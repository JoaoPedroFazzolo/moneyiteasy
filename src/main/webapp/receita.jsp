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

<%@include file="header.jsp" %>


<!-- Saldo Geral -->
<div class="container-fluid">
    <div class="row g-2 m-0">
        <div class="col-md-4">
            <div
                    class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Total de Receitas</p>
                    <p class="fs-5 fw-bold text-center">${saldoTotal}</p>
                </div>
                <img src="resources/images/eye_on.svg" width="36" height="36" alt="Olho aberto">
            </div>
        </div>

        <div class="col-md-4">
            <div
                    class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Receitas</p>
                    <p class="fs-5 fw-bold text-center">${totalReceita}</p>
                </div>
                <img src="resources/images/up_line.svg" width="36" height="36" alt="Linha verde crescente">
            </div>
        </div>

        <div class="col-md-4">
            <div
                    class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Investimentos</p>
                    <p class="fs-5 fw-bold text-center">${totalInvestimento}</p>
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
                                <c:forEach items="${receitas}" var="receita">
                                    <tr>
                                        <td>${receita.valor}</td>
                                        <td>${receita.date}</td>
                                        <td>${receita.categoria.nome}</td>
                                        <td>
                                            <c:url value="receitas" var="link">
                                                <c:param name="acao" value="editar-receita"/>
                                                <c:param name="codigo" value="${receita.idTransacao}"/>
                                            </c:url>
                                            <a href="${link}" class="btn btn-primary">Editar</a>

                                            <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                                    data-bs-target="#excluirModal"
                                                    onclick="codigoExcluir.value = ${receita.idTransacao}">Excluir
                                            </button>

                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="excluirModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Confirmar Exclusão</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <h4>Você confirma a exclusão desta receita?</h4>
                <p><strong>Atenção!</strong> Esta ação é irreversível.</p>
            </div>
            <div class="modal-footer">

                <form action="receita" method="post">
                    <input type="hidden" name="acao" value="excluir">
                    <input type="hidden" name="codigoExcluir" id="codigoExcluir">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Não</button>
                    <button type="submit" class="btn btn-danger">Sim</button>
                </form>

            </div>
        </div>
    </div>
</div>

    <%@include file="footer.jsp" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
</body>

</html>
