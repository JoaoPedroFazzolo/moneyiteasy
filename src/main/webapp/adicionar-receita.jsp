<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@include file="header.jsp" %>

<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                ADICIONAR RECEITA
            </div>
            <c:if test="${not empty mensagem}">
                <div class="alert alert-success ms-2 me-2 m-auto mt-2">${mensagem}</div>
            </c:if>
            <c:if test="${not empty erro}">
                <div class="alert alert-danger ms-2 me-2 m-auto mt-2">${erro}</div>
            </c:if>
            <div class="card-body">
                <form action="receita?acao=cadastrarReceitas" method="post">
                    <div class="form-group">
                        <label for="valorReceita">Valor</label>
                        <input type="text" name="valorReceita" id="valorReceita" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="dataReceita">Data</label>
                        <input type="date" name="dataReceita" id="dataReceita" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="categoriaReceita">Categoria</label>
                        <select name="categoriaReceita" id="categoriaReceita" class="form-control">
                            <option value="0">Selecione</option>
                            <c:forEach items="${listaCategorias}" var="c">
                            <option value="${c.codigo}">${c.nome}</option>
                            </c:forEach>
                    </div>
                    <input type="submit" value="Salvar" class="btn btn-success mt-3">
                    <a href="index" class="btn btn-secondary mt-3">Voltar a tela inicial</a>
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
