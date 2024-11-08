<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">

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
            <img src="resources/images/logo_home_light.svg" alt="Logo" style="height: 30px;">
        </a>
        <span class="text-white">Boa tarde, <strong>
            <%String nomeUsuario = (String) session.getAttribute("nomeUsuario");%>

             <p>Bem-vindo, <%= nomeUsuario %>!</p>
        </strong></span>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarContent">
            <ul class="navbar-nav mx-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="index">Visão Geral</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="receita?acao=listarReceita">Receitas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="despesa?acao=listarDespesa">Despesas</a>
                </li>
            </ul>
            <div class="d-flex align-items-center">
                <a href="#" class="text-white me-3">
                    <i class="bi bi-bell" style="font-size: 1.5rem"></i>
                </a>
                <div class="dropdown">
                    <a href="login.jsp" class="text-white">
                        <i class="bi bi-person-circle" style="font-size: 1.5rem"></i>
                    </a>
                </div>
            </div>
        </div>
    </nav>
</header>