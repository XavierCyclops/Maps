<%@page import="java.util.ArrayList;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Terminus</title>
        <link rel="stylesheet" href="resources/css/style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    </head>
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
        
        $( document ).ready(function() {
            $('#msg').hide();
          });
    </script>
    <body>
        <div class="container">
            <h1>Entrar</h1> <br>
            <h4>
                <% 
                    
                    
                %>
            </h4>

            <form action="entrar_proceso.jsp" method="post">
                <label for="correo">Correo </label> 
                <input type="text" name="correo" required/> <br>
                <label for="password">Contraseña </label> 
                <input id="pass1" type="password" name="password" required/> <br>
                <span id="msg"><p>Favor de verrificar tus datos.</p></span><br>
                
                
                <input type="submit" value="Entrar"/>
            </form>
        </div>
    </body>
</html>
