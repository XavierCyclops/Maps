/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author Xavier
 */
public class Viaje {

    private int idusuario;
    private int idruta; 
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

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdruta() {
        return idruta;
    }

    public void setIdruta(int idruta) {
        this.idruta = idruta;
    }

    public ArrayList getViajes() {
       ArrayList a = new ArrayList();
        try {
            a = conexionBD.getViajes();
        } catch (Exception ex) {
            System.out.println("Error desde Usuario " + ex.getMessage());
        }
        return a;
    }

    public boolean guarda(int iduser, int idruta ) {
        boolean b = false;
        try {
            b = conexionBD.guardaViaje(iduser, idruta);
        } catch (Exception ex) {
            System.out.println("Error al registrar producto " + ex.getMessage());
        }
        return b;
    }
    
    public boolean actualiza(int iduser, int idruta) {
        boolean b = false;
        try {
            b = conexionBD.actualizaViaje(iduser,idruta);
        } catch (Exception ex) {
            System.out.println("Error al registrar producto " + ex.getMessage());
        }
       
        this.idusuario = iduser;
        this.idruta = idruta;
        return b;
        
    }

    
    public boolean elimina(int id) {
        boolean b = false;
        try {
            b = conexionBD.eliminaViaje(id);
        } catch (Exception ex) {
            System.out.println("Error al registrar producto " + ex.getMessage());
        }
        return b;
    }

    @Override
    public String toString() {
        return "Viaje{" + "idusuario=" + idusuario + ", idruta=" + idruta + ", conexionBD=" + conexionBD + '}';
    }    
/*
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Viaje other = (Viaje) obj;
        if (this.idusuario != other.idusuario) {
            return false;
        }
        if (this.idruta != other.idruta) {
            return false;
        }
        if (!Objects.equals(this.conexionBD, other.conexionBD)) {
            return false;
        }
        return true;
    }
    
    
}
