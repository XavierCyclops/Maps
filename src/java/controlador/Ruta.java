/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author Xavier
 */
public class Ruta {

    Conexion conexionBD = new Conexion();

    public void conecta() throws Exception {
        try {
            conexionBD.conectar();
        } catch (Exception ex) {
            System.out.println("Falló conecta " + ex.getMessage());
        }
    }

    public void desconecta() throws Exception {
        try {
            conexionBD.desconectar();
        } catch (Exception ex) {
            System.out.println("Falló desconecta " + ex.getMessage());
        }
    }
    
    private int id;
    private String destino;
    private String salida;
    private String fecha;
    private String hora;
    private int cupo;
    private String idUsuario;
    private int precio;
    
    public Ruta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public int getMaximoId() throws Exception {
        int maximo = 0;
        try {
            maximo = conexionBD.getMaximoIdRuta();
        } catch (Exception ex) {
            System.out.println("Error al recuperar máximo de tabla " + ex.getMessage());
        }
        return maximo;
    }
    
    public boolean guardaRuta(int id, String destino, String salida, String fecha, String hora, 
            int cupo, int idUsuario, int precio) {
        
        boolean b = false;
        try {
            b = conexionBD.guardaRuta(id, destino, salida, fecha, hora, cupo, idUsuario, precio);
        } catch (Exception ex) {
            System.out.println("Error al registrar producto " + ex.getMessage());
        }
        return b;
    }
    
    public boolean actualizaRuta(int id, String destino, String salida, String fecha, String hora, 
            int cupo, int idUsuario, int precio) {
        
        boolean b = false;
        try {
            b = conexionBD.actualizaRuta(id, destino, salida, fecha, hora, cupo, idUsuario, precio);
        } catch (Exception ex) {
            System.out.println("Error al registrar producto " + ex.getMessage());
        }
        return b;
    }
    
    public boolean elimina(int id) {
        boolean b = false;
        try {
            b = conexionBD.eliminaRuta(id);
        } catch (Exception ex) {
            System.out.println("Error al registrar producto " + ex.getMessage());
        }
        return b;
    }
    
}
