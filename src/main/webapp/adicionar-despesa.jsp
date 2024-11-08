<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de despesas</title>

    <link rel="shortcut icon" href="resources/images/logo_money_icon.svg" type="image/x-icon">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>

<%@include file="header.jsp" %>

<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                ADICIONAR DESPESA
            </div>
            <c:if test="${not empty mensagem}">
                <div class="alert alert-success ms-2 me-2 m-auto mt-2">${mensagem}</div>
            </c:if>
            <c:if test="${not empty erro}">
                <div class="alert alert-danger ms-2 me-2 m-auto mt-2">${erro}</div>
            </c:if>
            <div class="card-body">
                <form action="despesa?acao=cadastrarDespesas" method="post">
                    <div class="form-group">
                        <label for="valorDespesa">Valor</label>
                        <input type="text" name="valorDespesa" id="valorDespesa" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="dataDespesa">Data</label>
                        <input type="date" name="dataDespesa" id="dataDespesa" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="categoriaDespesa">Categoria</label>
                        <select name="categoriaDespesa" id="categoriaDespesa" class="form-control">
                            <option value="0">Selecione</option>
                            <c:forEach items="${listaCategorias}" var="c">
                            <option value="${c.codigo}"> ${c.codigo} - ${c.nome}</option>
                            </c:forEach>
                    </div>
                    <input type="submit" value="Salvar" class="btn btn-warning mt-3">
                    <a href="index.jsp" class="btn btn-secondary mt-3">Voltar a tela inicial</a>
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
