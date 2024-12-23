<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@include file="header.jsp" %>

<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header fs-5 fw-bold">
                EDIÇÃO DE DESPESAS
            </div>
            <div class="card-body">
                <form action="despesa?acao=editarDespesas" method="post" class="fs-6 fw-bold">
                    <input type="hidden" value="${despesaEditar.idTransacao}" name="codigo">
                    <div class="form-group">
                        <label for="valorDespesa">Valor</label>
                        <input type="text" name="valorDespesa" id="valorDespesa" class="form-control" value="${despesaEditar.valor}">
                    </div>
                    <div class="form-group">
                        <label for="dataDespesa">Data</label>
                        <input type="date" name="dataDespesa" id="dataDespesa" class="form-control" value="${despesaEditar.date}">
                    </div>
                    <div class="form-group">
                        <label for="categoriaDespesa">Categoria</label>
                        <select name="categoriaDespesa" id="categoriaDespesa" class="form-control">
                            <option value="0">Selecione</option>
                            <c:forEach items="${listaCategorias}" var="c">
                                <option value="${c.codigo}">${c.nome}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="d-flex gap-2">
                        <input type="submit" value="Salvar" class="btn btn-success mt-3 fw-bold">
                        <a href="despesa?acao=listarDespesa" class="btn btn-secondary mt-3 fw-bold">Cancelar</a>
                    </div>
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
