<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@include file="header.jsp"%>

<!-- Saldo Geral -->
<div class="container-fluid">
    <div class="row g-2 m-0">

        <div class="col-md-4">
            <div class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Saldo Geral</p>
                    <p class="fs-5 fw-bold text-center">
                        <fmt:formatNumber value="${saldoTotal}" type="currency" currencySymbol="R$" maxFractionDigits="2" minFractionDigits="2" />
                    </p>
                </div>
                <img src="resources/images/eye_on.svg" width="36" height="36" alt="Olho aberto">
            </div>
        </div>

        <div class="col-md-4">
            <div class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Receitas</p>
                    <p class="fs-5 fw-bold text-center">
                        <fmt:formatNumber value="${totalReceita}" type="currency" currencySymbol="R$" maxFractionDigits="2" minFractionDigits="2" />
                    </p>
                </div>
                <img src="resources/images/up_line.svg" width="36" height="36" alt="Linha verde crescente">
            </div>
        </div>

        <div class="col-md-4">
            <div class="p-3 bg-white shadow-sm d-flex flex-column justify-content-center align-items-center rounded h-100">
                <div>
                    <p class="fs-6 p-3 text-center">Despesas</p>
                    <p class="fs-5 fw-bold text-center">
                        <fmt:formatNumber value="${totalDespesa}" type="currency" currencySymbol="R$" maxFractionDigits="2" minFractionDigits="2" />
                    </p>
                </div>
                <img src="resources/images/down_line.svg" width="36" height="36" alt="Linha verde decrescente">
            </div>
        </div>

        <!-- Adicionar Receita e Despesa-->
        <div class="row g-2 py-1">
            <div class="col-md-6 d-flex justify-content-around">
                <a class="btn btn-outline-success w-100 fs-6 fw-bold" style="background-color: #B5EFC9;" href="receita?acao=formCadastroReceita">Adicionar Receita</a>
            </div>
            <div class="col-md-6 d-flex justify-content-around">
                <a class="btn btn-outline-danger w-100 fs-6 fw-bold" style="background-color: #eba1a7;" href="despesa?acao=formCadastroDespesa">Adicionar Despesa</a>
            </div>
        </div>
    </div>


    <div id="carouselExampleFade" class="carousel slide carousel-fade">
        <div class="carousel-inner">
            <div class="carousel-item active">
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
                            <td><fmt:formatNumber
                                    value="${receita.valor}" type="currency" currencySymbol="R$"
                                    groupingUsed="true"
                                    minFractionDigits="2" maxFractionDigits="2"/>
                            </td>
                            <td>
                                <fmt:parseDate
                                        value="${receita.date}"
                                        pattern="yyyy-MM-dd"
                                        var="dateFmt"/>
                                <fmt:formatDate
                                        value="${dateFmt}"
                                        pattern="dd/MM/yyyy"/>
                            </td>
                            <td>${receita.categoria.nome}</td>
                            <td>
                                <c:url value="receita" var="link">
                                    <c:param name="acao" value="formEditarReceita"/>
                                    <c:param name="codigo" value="${receita.idTransacao}"/>
                                </c:url>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="carousel-item">
                <img src="..." class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="..." class="d-block w-100" alt="...">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

</div> <!-- Fechando o container-fluid antes de incluir o footer -->

<%@include file="footer.jsp"%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>

</body>
</html>
