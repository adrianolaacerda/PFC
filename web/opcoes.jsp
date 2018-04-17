<%-- 
    Document   : principal
    Created on : 30/10/2017, 08:55:27
    Author     : 11151102481
--%>

<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Principal</title>
    </head>
    <body>
        <%
            //recupera o usuario da sessao
            Usuario usuario = (Usuario)session.getAttribute("usuarioAutenticado");
            
            if(usuario !=null){
        %>
        <h1>Bem vindo, <%=usuario.getLogin() %> !</h1>
        <%}%>
        <a href="cadastroCliente.html"> Cadastro </a></br>
        <a href="cadastro_usuario.jsp"> Área restrita </a></br>
        <a href="ControleAcesso?acao=Sair">Logout</a>
    </body>
</html>
