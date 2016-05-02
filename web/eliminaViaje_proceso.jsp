<%@page import="controlador.Usuario;"%>
<%@page import="controlador.Ruta;"%>
<%
    Usuario user = (Usuario) session.getAttribute("usuario");
    int id = Integer.parseInt(request.getParameter("containerId"));
    Ruta ruta = new Ruta();
    boolean estado = false;

    ruta.conecta();
    estado = ruta.elimina(id);
    ruta.desconecta();
    
    
    if (estado) {
        out.println("<script type=\"text/javascript\">");
         out.println("alert('Se eliminó exitosamente!!.');");
        out.println("location='administrarRuta.jsp';");
        out.println("</script>");
    } else {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Hubo un error al eliminar.');");
        out.println("location='administrarRuta.jsp';");
        out.println("</script>");
    }
%>