<%-- 
    Document   : Formulario
    Created on : 14/05/2016, 08:54:30 PM
    Author     : Xavier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario</title>
    </head>
    <body>
        <h1>Guardar Imagenes</h1>
        <img src="resources/img/default_user.png" width="120" height="40" onclick="guardarImagenFichero(this)">
        <form action="upload" method="post" enctype="multipart/form-data">
            <input type="file" name="file">
            <input type="submit">
            
        </form>
        <form action="subir_imagenes_con_ruta2.php" method="post" enctype="multipart/form-data"> 
            <input name="fichero" type="file"> 
    <input name="submit" type="submit" value="Upload!">  
</form>
    </body>
</html>
