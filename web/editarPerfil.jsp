<%-- 
    Document   : editarPerfil
    Created on : 2/05/2016, 01:50:08 AM
    Author     : ReneGL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controlador.Usuario;"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css"/>
        <!-- Custom Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'/>
        <link href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'/>
        <link rel="stylesheet" href="resources/font-awesome/css/font-awesome.min.css" type="text/css"/>

        <!-- Plugin CSS -->
        <link rel="stylesheet" href="resources/css/animate.min.css" type="text/css"/>
        
        <!-- Custom CSS -->
        <link rel="stylesheet" href="resources/css/creative.css" type="text/css"/>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css' />
        <link href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css' />
        <link rel="stylesheet" href="resources/css/editarPerfil.css" type="text/css"/>
        <link rel="stylesheet" href="resources/css/jquery-ui.min.css" type="text/css"/>
        <script src="http://maps.google.com/maps/api/js"></script>
        <script src="resources/js/jquery.js"></script>
        <script src="resources/js/jquery-ui.min.js"></script>
        <script>
        function checkForm() {
            var pass1 = $('#pass1').val();
            var pass2 = $('#pass2').val();
            
            //alert("pass1: " + pass1 + " pass2: " + pass2);
            if (pass1 !== pass2) {
                 $('#msg').show("fast");
                 return false;
            }
             else
                 return true;
        };
        
        function ask() {
            var res = confirm("Estas seguro de eliminar???");
            return res;
        }
        $( document ).ready(function() {
            $('#msg').hide();
          });
    </script>
    </head>
    
    <body>
        <nav id="mainNav" >
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand page-scroll" href="./paginaUsuario.xhtml">RideCiencias</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a class="page-scroll" href="#about" id="publicar" onclick="PF('dlg').show();">Publica Viaje</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="#services">Editar Perfil</a>
                        </li>
                         <li>
                            <a class="page-scroll" href="administrarRuta.xhtml">Administrar Rutas</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="./salir.html">Salir</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
        
        <header>
            <% 
                Usuario user = (Usuario) session.getAttribute("usuario");
                String nombre = user.getNombre();
                String apellidos = user.getApellido();
                String correo = user.getCorreo();
                String password = user.getPassword();
            %>
            <div class="container">
		<div class="col1">
			<img src="resources/img/default_user.png" style="height: 160px; width: 150px;">
                        <img src="resources/img/5-stars-icon.png" alt="" style="height: 15px; width: 80px;">
		</div>
                <div class="col2" >
                    <form action="editarPerfil_proceso.jsp" method="post" onSubmit="return checkForm()">
                        <label for="nombre">Nombre </label> 
                        <input type="text" name="nombre" value="<%= nombre%>" required/> <br>
                        <label for="apellidos">Apellidos </label> 
                        <input type="text" name="apellidos" value="<%= apellidos%>" required/> <br>
                        <label for="correo">Correo </label> 
                        <input type="text" name="correo" value="<%= correo%>" required/> <br>
                        <label for="password">Contraseña </label> 
                        <input id="pass1" type="password" name="password" value="<%= password%>" required/> <br>
                        <label for="password1">Repite contraseña </label> 
                        <input id="pass2" type="password" name="password1"  value="<%= password%>" required/><br><br>
                        <span id="msg"><p>Las contraseñas no coinciden</p></span><br>


                        <input type="submit" value="Guardar"/>                        
                    </form>
                        <br>
                        <form action="eliminarPerfil_proceso.jsp" onsubmit="return ask()">
                        <button type="submit" id="eliminar">Eliminar Perfil</button>
                    </form>
                </div>
                
            </div>
        </header>
    </body>
</html>
