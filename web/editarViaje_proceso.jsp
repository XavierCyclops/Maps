<%@page import="controlador.Ruta;"%>
<%@page import="controlador.Usuario;"%>

<%
    
    String destino = request.getParameter("destino");
    String salida = request.getParameter("salida");
    String horas = request.getParameter("horas");
    String minutos = request.getParameter("minutos");
    String fecha = request.getParameter("fecha");
    int cupo = Integer.parseInt(request.getParameter("cupo"));
    int precio = Integer.parseInt(request.getParameter("precio"));
    int id = Integer.parseInt(request.getParameter("idViaje"));
    
    Ruta ruta = new Ruta();
    Usuario user = (Usuario) session.getAttribute("usuario");
    System.out.println("Usuario!!!" + user.getIdusuario());
    boolean estado = false;

    ruta.conecta();
    estado = ruta.actualizaRuta(id, destino, salida, fecha, horas + ":" + minutos, cupo, user.getIdusuario(), precio);
    ruta.desconecta();

    if (estado) {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Se registró el viaje correctamente!');");
        out.println("location='paginaUsuario.jsp';");
        out.println("</script>");
    } else {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Hubo un error registrando el viaje.');");
        out.println("location='paginaUsuario.jsp';");
        out.println("</script>");
    }
%>