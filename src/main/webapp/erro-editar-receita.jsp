<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Erro ao Editar</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="d-flex align-items-center justify-content-center bg-light vh-100">
<div class="text-center">
  <h1 class="display-1 text-danger font-weight-bold">ERRO</h1>
  <h2 class="h4 text-dark">Erro ao editar a receita</h2>
  <p class="text-muted">Por favor, verifique se os dados estavam preenchidos e tente novamente.</p>
  <a href="receita?acao=listarReceita" class="btn btn-danger">Receitas</a>
</div>
</body>

</html>

