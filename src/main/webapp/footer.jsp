<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
    /* Garante que o footer fique colado ao final da página */
    body {
        display: flex;
        flex-direction: column;
        min-height: 100vh;
        margin: 0;
    }
    footer {
        margin-top: auto; /* Empurra o footer para o final */
    }
</style>

<body>
<!-- Seu conteúdo principal aqui -->

<footer class="border-top bg-body-tertiary">
    <div class="d-flex flex-wrap justify-content-between align-items-center py-3 ms-4 me-4">
        <div class="col-md-4 d-flex align-items-center">
            <a class="mb-3 me-2 mb-md-0 text-body-secondary text-decoration-none lh-1" href="login.jsp">
                <img src="resources/images/logo_money_icon.svg" alt="Logo money it easy">
            </a>
            <span class="fs-6">© 2024, FIAP | 1TDSOE - Grupo 08</span>
        </div>
        <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
            <li class="ms-3">
                <a class="social-icons bi bi-linkedin" href="https://www.linkedin.com/in/joao-fazzolo"></a>
            </li>
            <li class="ms-3">
                <a class="social-icons bi bi-instagram" href="https://www.linkedin.com/in/osmarjosefacinjr"></a>
            </li>
            <li class="ms-3">
                <a class="social-icons bi bi-github" href="https://github.com/JoaoPedroFazzolo/moneyiteasy"></a>
            </li>
        </ul>
    </div>
</footer>
</body>
