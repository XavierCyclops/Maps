<%@page import="controlador.Usuario;"%>

<%
    Usuario user = (Usuario) session.getAttribute("usuario");
    
    boolean estado = false;

    user.conecta();
    estado = user.elimina(user.getIdusuario());
    user.desconecta();
    
    
    if (estado) {
        out.println("<script type=\"text/javascript\">");
        out.println("location='usuarioEliminado.html';");
        out.println("</script>");
    } else {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Hubo un error al eliminar.');");
        out.println("location='editarPerfil.jsp';");
        out.println("</script>");
    }
%>

<a href="index.html">Volver a Inicio</a>