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

        <!-- Carrossel Bootstrap -->
        <div id="carouselExample" class="carousel slide bg-white shadow-sm rounded h-100" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div class="container">
                        <p class="fs-5 fw-bold text-success mt-2">Receitas</p>
                        <table class="table text-center align-middle border border-success">
                            <thead class="table-success">
                            <tr>
                                <th>Valor Recebido</th>
                                <th>Data</th>
                                <th>Categoria</th>
                            </tr>
                            </thead>
                            <tbody>
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
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

                <!-- Slide Despesas -->
                <div class="carousel-item">
                    <div class="container">
                        <p class="fs-5 fw-bold text-danger mt-2">Despesas</p>
                        <table class="table text-center align-middle border border-danger">
                            <thead class="table-danger">
                            <tr>
                                <th>Valor Gasto</th>
                                <th>Data</th>
                                <th>Categoria</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${despesas}" var="despesa">
                                <tr>
                                    <td><fmt:formatNumber
                                            value="${despesa.valor}" type="currency" currencySymbol="R$"
                                            groupingUsed="true"
                                            minFractionDigits="2" maxFractionDigits="2"/>
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
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <!-- Controles do Carrossel -->
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Anterior</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Próximo</span>
            </button>
        </div>



    </div>

</div> <!-- Fechando o container-fluid antes de incluir o footer -->

<%@include file="footer.jsp"%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>

</body>
</html>
