<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Visão Geral</title>

    <link rel="shortcut icon" href="resources/images/logo_money_icon.svg" type="image/x-icon">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="resources/css/style.css">
</head>

<body class="container body-dashboard">
<header class="bg bg-header">
    <nav class="navbar navbar-expand-md navbar-dark m-3 p-2 header-container">
        <a href="#" class="navbar-brand d-flex align-items-center">
            <img src="resources/images/logo_home_light.svg" alt="Logo" style="height: 40px;">
        </a>
        <%
            String nomeUsuario = (String) session.getAttribute("primeiroNome");
//            if (nomeUsuario == null) {
//                nomeUsuario = "Visitante";
//            }
        %>
        <span class="text-white ms-3 fs-5">Bem-vindo, <strong><%= nomeUsuario %></strong></span>
        </strong>
        </span>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse fs-6" id="navbarContent">
            <ul class="navbar-nav mx-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="index">Visão Geral</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="receita?acao=listarReceita">Receitas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="despesa?acao=listarDespesa">Despesas</a>
                </li>
            </ul>
            <div class="d-flex align-items-center">
                <a href="#" class="text-white me-3">
                    <i class="bi bi-bell" style="font-size: 1.5rem"></i>
                </a>
                <div class="flex-shrink-0 dropdown">
                    <a href="#" class="d-block link-body-emphasis text-decoration-none dropdown-toggle bi bi-person-circle text-white"
                       data-bs-toggle="dropdown" aria-expanded="false" style="font-size: 1.5rem">
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end text-small shadow" style="position: absolute;">
                        <li><a class="dropdown-item" href="cadastro?acao=editarUsuario">Editar usuário</a></li>
                        <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#excluirUsuarioModal">Excluir usuário</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="login.jsp">Sair</a></li>
                    </ul>
                </div>
            </div>
        </div>


        <div class="modal fade" id="excluirUsuarioModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Confirmar Exclusão</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <h4>Você confirma a exclusão deste usuário?</h4>
                        <p><strong>Atenção!</strong> Esta ação é irreversível.</p>
                    </div>
                    <div class="modal-footer">

                        <form action="cadastro?acao=excluirUsuario" method="post">
                            <input type="hidden" name="acao" value="excluirUsuario">
                            <input type="hidden" name="codigoUsuarioExcluir" id="codigoUsuarioExcluir">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Não</button>
                            <button type="submit" class="btn btn-danger">Sim</button>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>