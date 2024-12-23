<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<%@include file="header.jsp"%>

<!-- Saldo Geral -->
<div class="container-fluid">
    <div class="row g-2 m-0">

        <div class="col-md-6">
            <div
                    class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Saldo Geral</p>
                    <p class="fs-5 fw-bold text-center">
                        <fmt:formatNumber value="${saldoTotal}"
                                          type="currency"
                                          currencySymbol="R$"
                                          maxFractionDigits="2"
                                          minFractionDigits="2" />
                    </p>
                </div>
                <img src="resources/images/eye_on.svg" width="36" height="36" alt="Olho aberto">
            </div>
        </div>

        <div class="col-md-6">
            <div class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Despesas</p>
                    <p class="fs-5 fw-bold text-center">
                        <fmt:formatNumber value="${totalDespesa}"
                                          type="currency"
                                          currencySymbol="R$"
                                          maxFractionDigits="2"
                                          minFractionDigits="2" />
                    </p>
                </div>
                <img src="resources/images/down_line.svg" width="36" height="36" alt="Linha verde decrescente">
            </div>
        </div>

        <div class="row g-2 py-1">
            <div class="col-md-6 d-flex justify-content-around">
                <a class="btn btn-outline-success w-100 fs-6 fw-bold" style="background-color: #B5EFC9;" href="receita?acao=formCadastroReceita">Adicionar Receita</a>
            </div>
            <div class="col-md-6 d-flex justify-content-around">
                <a class="btn btn-outline-danger w-100 fs-6 fw-bold" style="background-color: #eba1a7;" href="despesa?acao=formCadastroDespesa">Adicionar Despesa</a>
            </div>
        </div>

        <!-- Tabela -->
        <div class="bg-white rounded col-md-12">
            <div class="p-2">
                <p class="fs-5 fw-bold">Registro de Despesas</p>
                <div class="justify-content-between align-items-center">
                    <div class="table-container mt-4">
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
                                <c:forEach items="${despesas}" var="despesa">
                                    <tr>
                                        <td><fmt:formatNumber
                                                value="${despesa.valor}" type="currency" currencySymbol="R$"
                                                              groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" />
                                        </td>
                                        <td>
                                            <fmt:parseDate
                                                    value="${despesa.date}"
                                                    pattern="yyyy-MM-dd"
                                                    var="dateFmt"/>
                                            <fmt:formatDate
                                                    value="${dateFmt}"
                                                    pattern="dd/MM/yyyy"/>
                                        </td>
                                        <td>${despesa.categoria.nome}</td>
                                        <td>
                                            <c:url value="despesa" var="link">
                                                <c:param name="acao" value="formEditarDespesa"/>
                                                <c:param name="codigo" value="${despesa.idTransacao}"/>
                                            </c:url>
                                            <a href="${link}" class="btn btn-sm btn-outline-success fs-6 fw-bold border-2 rounded-1">Editar</a>

                                            <button type="button" class="btn btn-sm btn-outline-danger fs-6 fw-bold border-2 rounded-1"
                                                    data-bs-toggle="modal"
                                                    data-bs-target="#excluirModal"
                                                    onclick="codigoDespesaExcluir.value = ${despesa.idTransacao}">Excluir
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
                <h4>Você confirma a exclusão desta despesa?</h4>
                <p><strong>Atenção!</strong> Esta ação é irreversível.</p>
            </div>
            <div class="modal-footer">

                <form action="despesa?acao=excluirDespesas" method="post">
                    <input type="hidden" name="acao" value="excluir">
                    <input type="hidden" name="codigoDespesaExcluir" id="codigoDespesaExcluir">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Não</button>
                    <button type="submit" class="btn btn-danger">Sim</button>
                </form>

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
