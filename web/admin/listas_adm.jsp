<%-- 
    Document   : principal
    Created on : 14/11/2017, 08:42:24
    Author     : 11151505692
--%>

<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>IFruit</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        .w3-sidebar a {font-family: "Roboto", sans-serif}
        body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
    </style>
    <body class="w3-content" style="max-width:1200px">

        <!-- Sidebar/menu -->
        <nav class="w3-sidebar w3-bar-block w3-light-grey w3-collapse w3-top" style="z-index:3;width:250px" id="mySidebar">
            <div class="w3-container w3-display-container w3-padding-16">
                <i onclick="w3_close()" class="fa fa-remove w3-hide-large w3-button w3-display-topright"></i>
                <a href="home.html" class="w3-wide"> <h3><b>IFruit</b></h3> </a>
            </div>
            <div class="w3-padding-64 w3-large w3-text-grey" style="font-weight:bold">
                <a onclick="myAccFunc()" href="javascript:void(0)" class="w3-button w3-block w3-light-grey w3-left-align" id="myBtn">
                    Opções <i class="fa fa-caret-down"></i>
                </a>
                <div id="demoAcc" class="w3-bar-block w3-hide w3-padding-large w3-medium">
                    <a href="cadastro_adm.jsp" class="w3-bar-item w3-button">Cadastros</a>
                    <a href="#" class="w3-bar-item w3-button">Listas</a>
                    <a href="#" class="w3-bar-item w3-button"></a>
                </div>
            </div>
            <a href="#footer" class="w3-bar-item w3-button w3-padding">Contato</a> 

        </nav>

        <!-- Top menu on small screens -->
        <header class="w3-bar w3-top w3-hide-large w3-black w3-xlarge">
            <div class="w3-bar-item w3-padding-24 w3-wide">IFruit</div>
            <a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding-24 w3-right" onclick="w3_open()"><i class="fa fa-bars"></i></a>
        </header>

        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:250px">

            <!-- Push down content on small screens -->
            <div class="w3-hide-large" style="margin-top:83px"></div>



            <!-- Image header -->




            <header class="w3-container w3-xlarge w3-black"></br>
                <center>Menu administrativo</center>
                <p class="w3-right">
                </p>
            </header>

            <%
                String msg = (String) request.getAttribute("msg");
                if (msg != null) {
            %>
            <font color="blue"><%=msg%></font>
            <%}%>
            </br>
            <%
                //recupera o usuario da sessao
                Usuario usuario = (Usuario) session.getAttribute("usuarioAutenticado");
                if (usuario != null) {
            %>
            <center>
                <h2><b>Bem-vindo(a), <%=usuario.getLogin()%></b></h2>
                <%}%>
            </center>

            </br>   
            <center>
                <a href="./listaPessoa.jsp" class="w3-bar-item w3-button">Lista de clientes</a>   
                <a href="./listaUsuario.jsp" class="w3-bar-item w3-button">Lista de usuários</a>               
                <a href="./listaProduto.jsp" class="w3-bar-item w3-button">Lista de produtos</a></br> 
            </center>
            </br> </br> 
            <a href="autenticado_adm.jsp" class="w3-bar-item w3-button"> Voltar </a><br/>

            </br>


            <!-- Footer -->
            <footer class="w3-padding-64 w3-light-grey w3-small w3-center" id="footer">
                <div class="w3-row-padding">
                    <div class="w3-col s4">


                    </div>
            </footer>

            <div class="w3-black w3-center w3-padding-24">Feito por <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-opacity">Grupo Ifruit</a></div>

            <!-- End page content -->
        </div>



        <script>
            // Accordion 
            function myAccFunc() {
                var x = document.getElementById("demoAcc");
                if (x.className.indexOf("w3-show") == -1) {
                    x.className += " w3-show";
                } else {
                    x.className = x.className.replace(" w3-show", "");
                }
            }

            // Click on the "Jeans" link on page load to open the accordion for demo purposes
            document.getElementById("myBtn").click();


            // Script to open and close sidebar
            function w3_open() {
                document.getElementById("mySidebar").style.display = "block";
                document.getElementById("myOverlay").style.display = "block";
            }

            function w3_close() {
                document.getElementById("mySidebar").style.display = "none";
                document.getElementById("myOverlay").style.display = "none";
            }
        </script>

    </body>
</html>
