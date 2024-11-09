<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<%@include file="header.jsp" %>
<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                EDIÇÃO DO USUÁRIO
            </div>

            <c:if test="${not empty msg }">
                <div class="alert alert-success">${msg}</div>
            </c:if>
            <c:if test="${not empty erro }">
                <div class="alert alert-danger">${erro}</div>
            </c:if>

            <div class="card-body">
                <form action="cadastro?acao=editarUsuario" method="post">
                    <input type="hidden" value="${usuarioEditar.idUsuario}" name="codigo">
                    <div class="form-group">
                        <label for="nomeUsuario">Nome completo</label>
                        <input type="text" name="nomeUsuario" id="nomeUsuario" class="form-control" value="${usuarioEditar.nome}">
                    </div>
                    <div class="form-group">
                        <label for="senhaUsuario">Senha</label>
                        <input type="text" name="senhaUsuario" id="senhaUsuario" class="form-control" value="${usuarioEditar.senha}">
                    </div>
                    <input type="submit" value="Salvar" class="btn btn-success mt-3">
                    <a href="index" class="btn btn-secondary mt-3">Cancelar</a>
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

