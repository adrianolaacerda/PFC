<!DOCTYPE html>
<html>
    <title>IFruit</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
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
                <a href="index.jsp" class="w3-bar-item w3-button"> Login </a>
                <a onclick="myAccFunc()" href="javascript:void(0)" class="w3-button w3-block w3-light-grey w3-left-align" id="myBtn">
                    Categorias <i class="fa fa-caret-down"></i>
                </a>
                <div id="demoAcc" class="w3-bar-block w3-hide w3-padding-large w3-medium">
                    <a href="#" class="w3-bar-item w3-button">Legumes</a>
                    <a href="#" class="w3-bar-item w3-button">Verduras</a>
                    <a href="#" class="w3-bar-item w3-button">Frutas</a>
                    <a href="#" class="w3-bar-item w3-button">Listar</a>
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



            <!-- Image header -->






            <div class="container">    
                <div id="loginbox" style="margin-top:50px; margin-left: 230px " class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
                    <div class="panel panel-info" >
                        <div class="panel-heading">
                            <div class="panel-title">    
                            </div>
                            <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Esqueceu a senha?</a></div>
                        </div>     

                        <div style="padding-top:30px" class="panel-body" >

                            <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                            <form action="ControleAcesso" target="POST" class="form-horizontal" role="form">

                                <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input  type="text" class="form-control"   name="txtLogin" placeholder="usuário">                
                                </div>

                                <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                    <input type="password" name="txtSenha"  class="form-control" placeholder="senha">
                                </div>



                                <div class="input-group">
                                    <div class="checkbox">
                                        <label>
                                            <input id="login-remember" type="checkbox" name="lembrar" value="1"> Lembrar-me
                                        </label>
                                    </div>
                                </div>


                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                        <button type="submit" class="w3-button w3-black " class="btn btn-success" value="Entrar" name="acao">Enviar</button>
                                        <a id="btn-fblogin" href="https://www.facebook.com/" class="btn btn-primary">Login com Facebook</a>

                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                            Não tem uma conta?
                                            <a href="./cadastro_cliente.jsp" onClick="$('#loginbox').hide(); $('#signupbox').show()"> Cadastra-se </a>
                                        </div>
                                    </div>
                                </div>    
                            </form>     



                        </div>                     
                    </div>  
                </div>
            </div>

            </br>
            </br>
            </br>
            </br>
             </br>
            </br>
            </br>
            </br>
             </br>
            </br>
 
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
