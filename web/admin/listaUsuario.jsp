<%-- 
    Document   : listaUsuario
    Created on : 13/03/2018, 14:21:34
    Author     : PC
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
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
                <a  class="w3-wide"> <h3><b>IFruit</b></h3> </a>
            </div>
            <div class="w3-padding-64 w3-large w3-text-grey" style="font-weight:bold">
                <a href="../home.html" class="w3-bar-item w3-button"> IFruit </a>
                <a onclick="myAccFunc()" href="javascript:void(0)" class="w3-button w3-block w3-light-grey w3-left-align" id="myBtn">
                    Categorias <i class="fa fa-caret-down"></i>
                </a>
                <div id="demoAcc" class="w3-bar-block w3-hide w3-padding-large w3-medium">
                    <a href="#" class="w3-bar-item w3-button">Legumes</a>
                    <a href="#" class="w3-bar-item w3-button">Verduras</a>
                    <a href="#" class="w3-bar-item w3-button">Frutas</a>
                </div>
            </div>
            <a href="#footer" class="w3-bar-item w3-button w3-padding">Contato</a> 
            <a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding" onclick="document.getElementById('newsletter').style.display = 'block'">Promoções</a> 

        </nav>

        <!-- Top menu on small screens -->
        <header class="w3-bar w3-top w3-hide-large w3-black w3-xlarge">
            <div class="w3-bar-item w3-padding-24 w3-wide">LOGO</div>
            <a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding-24 w3-right" onclick="w3_open()"><i class="fa fa-bars"></i></a>
        </header>

        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:250px">

            <!-- Push down content on small screens -->
            <div class="w3-hide-large" style="margin-top:83px"></div>



            <!-- Image header -->




            <%
                //recupera a lista do request
                ArrayList<Usuario> listaUsuario = (ArrayList<Usuario>) session.getAttribute("listaUsuario");

            %>
            <table width="100%" border="1">
                <header class="w3-container w3-xlarge w3-black">
                    <p class="w3-left">Dados de usuário</p>
                    <p class="w3-right">
                    </p>
                </header>
                </br></br>

                <center>
                    <align>
                        <td> ID </td> 
                        <td>Login </td>
                        <td>Senha</td>
                        <td>Tipo de Perfil</td>
                        <td>ID Pessoa</td>
                        <td>Alterar </td>
                        <td>Excluir </td>
                    </align>                    
                </center>


                </thead>            
                <tbody>
                    <%                    for (Usuario u : listaUsuario) {

                    %>
                    <tr>
                        <td> <%= u.getId()%></td>
                        <td> <%= u.getLogin()%></td>
                        <td> <%= u.getSenha()%> </td>
                        <td> <%= u.getPerfil()%> </td>
                        <td> <%= u.getPessoa().getId()%>  </td>


                        <td> <a href="ControleUsuario?acao=AlterarUsuario&id=<%=u.getId()%>"class="w3-bar-item w3-button"> * </a> </td>
                        <td> <a href="ControleUsuario?acao=Excluir&id=<%=u.getId()%>"class="w3-bar-item w3-button"> ✖ </a> </td>
                    </tr>
                    <%
                        } // fim do for
                    %> 
                </tbody>    
            </table>

            </br></br>
            <center>
                <td><a href="listas_adm.jsp" class="w3-bar-item w3-button"> Voltar </a></td>
            </center>
            <!-- Footer -->
            <footer class="w3-padding-64 w3-light-grey w3-small w3-center" id="footer">
                <div class="w3-row-padding">
                    <div class="w3-col s4">

                        <h4>Contato</h4>
                        <p>Perguntas? Continue.</p>
                        <form action="/action_page.php" target="_blank">
                            <p><input class="w3-input w3-border" type="text" placeholder="Nome" name="Nome" required></p>
                            <p><input class="w3-input w3-border" type="text" placeholder="Email" name="Email" required></p>
                            <p><input class="w3-input w3-border" type="text" placeholder="Assunto" name="Assunto" required></p>
                            <p><input class="w3-input w3-border" type="text" placeholder="Mensagem" name="Mensagem" required></p>
                            <button type="submit" class="w3-button w3-block w3-black">Enviar</button>

                        </form>
                    </div>

                    <div class="w3-col s4">
                        <h4>Sobre</h4>
                        <p><a href="#">Sobre nós</a></p>
                        <p><a href="#">Encontre sua loja</a></p>
                        <p><a href="#">Envio</a></p>
                        <p><a href="#">Pagamentos</a></p>
                        <p><a href="#">Ajuda</a></p>
                    </div>

                    <div class="w3-col s4 w3-justify">
                        <h4>Loja</h4>
                        <p><i class="fa fa-fw fa-map-marker"></i><p><a href="encontre_loja.jsp"> Companhia IFruit</a></p>
                        <p><i class="fa fa-fw fa-phone"></i> (011) 4728-6594</p>
                        <p><i class="fa fa-fw fa-envelope"></i> ifruit@gmail.com</p>
                        <h4>Aceitamos</h4>
                        <p><i class="fa fa-fw fa-cc-amex"></i> Cartões de Debíto</p>
                        <p><i class="fa fa-fw fa-credit-card"></i> Cartões de Crédito</p>
                        <br>
                        <i class="fa fa-facebook-official w3-hover-opacity w3-large"></i>
                        <i class="fa fa-instagram w3-hover-opacity w3-large"></i>
                        <i class="fa fa-snapchat w3-hover-opacity w3-large"></i>
                        <i class="fa fa-pinterest-p w3-hover-opacity w3-large"></i>
                        <i class="fa fa-twitter w3-hover-opacity w3-large"></i>
                        <i class="fa fa-linkedin w3-hover-opacity w3-large"></i>
                    </div>
                </div>
            </footer>

            <div class="w3-black w3-center w3-padding-24">Feito por <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-opacity">Grupo Ifruit</a></div>

            <!-- End page content -->
        </div>

        <!-- Newsletter Modal -->
        <div id="newsletter" class="w3-modal">
            <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
                <div class="w3-container w3-white w3-center">
                    <i onclick="document.getElementById('newsletter').style.display = 'none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
                    <h2 class="w3-wide">Promoções</h2>
                    <p>Junte-se à nossa lista de correspondência para receber atualizações sobre novos produtos e ofertas especiais.</p>
                    <p><input class="w3-input w3-border" type="text" placeholder="Entre com o e-mail"></p>
                    <button type="button" class="w3-button w3-padding-large w3-red w3-margin-bottom" onclick="document.getElementById('newsletter').style.display = 'none'">Enviar</button>
                </div>
            </div>
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