<%-- 
    Document   : cadastro_pessoa
    Created on : 12/04/2018, 23:19:02
    Author     : PC
--%>

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
                <a href="../home.html" class="w3-bar-item w3-button"> Login </a>
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
            <div class="w3-bar-item w3-padding-24 w3-wide">IFruit</div>
            <a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding-24 w3-right" onclick="w3_open()"><i class="fa fa-bars"></i></a>
        </header>

        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:250px">

            <!-- Push down content on small screens -->
            <div class="w3-hide-large" style="margin-top:83px"></div>


            <header class="w3-container w3-xlarge w3-black">
                <p class="w3-left">Alterar</p>
                <p class="w3-right">
                </p>
            </header>
             <%
                String msg = (String) request.getAttribute("msg");
                if (msg != null) {
            %>
            <font color="blue"><%=msg%></font>
            <%}%>
            
            <!-- FORM CADASTRO -->
             <form action="../ControlePessoa" method="POST">
                 <fieldset>
                    <legend>Dados Pessoais</legend>
                    <table cellspacing="4">
                        <tr>
                            <td>
                                <label for="nome">Nome </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNome">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="cpf">CPF </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtCPF" size="13" maxlength="15"> 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="rg">RG</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtRG" size="10" maxlength="15"> 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Data de Nascimento </label>
                            </td>
                            <td align="left">
                                <input type="date" name="txtdataNasc">
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <label>E-mail</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtEmail" size="40" maxlength="40"> 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Telefone</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtTelefone" size="30" maxlength="20"> 
                            </td>
                        </tr>
                        
                        <legend>Dados de Endereço</legend>
                    <table cellspacing="10">
                        <tr>
                            <td>
                                <label for="Logradouro">Logradouro</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtLogradouro">
                            </td>
                            <td>
                                <label for="numero">Número</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNumero" size="5">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="cep">CEP </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtCEP" size="10" maxlength="10"> 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="bairro">Bairro </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtBairro">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="cidade">Cidade </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtCidade">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="estado">Estado</label>
                            </td>
                            <td align="left">
                                <select name="txtEstado"> 
                                    <option value="ac">Selecionar</option> 
                                    <option value="ac">Acre</option> 
                                    <option value="al">Alagoas</option> 
                                    <option value="am">Amazonas</option> 
                                    <option value="ap">Amapá</option> 
                                    <option value="ba">Bahia</option> 
                                    <option value="ce">Ceará</option> 
                                    <option value="df">Distrito Federal</option> 
                                    <option value="es">Espírito Santo</option> 
                                    <option value="go">Goiás</option> 
                                    <option value="ma">Maranhão</option> 
                                    <option value="mt">Mato Grosso</option> 
                                    <option value="ms">Mato Grosso do Sul</option> 
                                    <option value="mg">Minas Gerais</option> 
                                    <option value="pa">Pará</option> 
                                    <option value="pb">Paraíba</option> 
                                    <option value="pr">Paraná</option> 
                                    <option value="pe">Pernambuco</option> 
                                    <option value="pi">Piauí</option> 
                                    <option value="rj">Rio de Janeiro</option> 
                                    <option value="rn">Rio Grande do Norte</option> 
                                    <option value="ro">Rondônia</option> 
                                    <option value="rs">Rio Grande do Sul</option> 
                                    <option value="rr">Roraima</option> 
                                    <option value="sc">Santa Catarina</option> 
                                    <option value="se">Sergipe</option> 
                                    <option value="sp">São Paulo</option> 
                                    <option value="to">Tocantins</option> 
                                </select>
                            </td>
                        </tr>
                    </table>

                </fieldset>
                 
                  <center>
                   
                 <button type="submit" class="w3-button w3-black " value="Alterar" name="acao">Enviar</button>
                 <button type="submit" class="w3-button w3-black " value="Excluir" name="acao">Enviar</button>
                
                </form></br></br>
                 <td><a href="../principal.jsp" class="w3-bar-item w3-button"> Voltar </a></td>
                </body>
            </center>
            </br>


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

            
            
            
</html>
