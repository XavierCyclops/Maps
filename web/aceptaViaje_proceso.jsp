<%@page import="controlador.Usuario;"%>
<%@page import="controlador.Conexion;"%>

<%
    int idRuta = Integer.parseInt(request.getParameter("viajeId"));
    Usuario user = (Usuario) session.getAttribute("usuario");
    Conexion con = new Conexion();
    boolean estado = false;

    con.conectar();
    estado = con.guardaViaje(idRuta, user.getIdusuario());
    con.desconectar();
    
    
    if (estado) {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Has tomado un Viaje!!');");
        out.println("location='paginaUsuario.jsp';");
        out.println("</script>");
    } else {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Hubo un error al tomar el viaje.');");
        out.println("location='paginaUsuario.jsp';");
        out.println("</script>");
    }
%>

<a href="index.html">Volver a Inicio</a>