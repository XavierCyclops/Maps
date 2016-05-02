/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Xavier
 */
public class Conexion {
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    
    
    public Conexion() {
        con = null;
        stmt = null;
        rs = null;
    }

    public void conectar() throws Exception{
        String driver = "org.postgresql.Driver";
        String dir = "jdbc:postgresql://localhost:5432/RideCiencias";
        //String dir = "jdbc:oracle:thin:@localhost:5432:RideCiencias";
        String user = "postgres";
        String password = "Rene8523";
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(dir, user, password);
        } catch(ClassNotFoundException | SQLException ex){
            System.out.println("SQLException! desde conectar: " + ex.getMessage());   
        }        
    }
    
    public void desconectar() throws Exception{
        try{
            con.close();
        }catch(Exception ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
    }
    
    //Empieza modificacion de datos
        public ArrayList getUsuarios() throws Exception {
            ArrayList usuarios = new ArrayList();
            try{
                stmt = con.createStatement();
                rs = stmt.executeQuery("select idusuario, correo, nombre, apellido, passwrd from usuario");
                while(rs.next()){
                    Usuario p = new Usuario();
                    p.setIdusuario(rs.getInt(1));
                    p.setCorreo(rs.getString(2));
                    p.setNombre(rs.getString(3));
                    p.setApellido(rs.getString(4));
                    p.setPassword(rs.getString(5));
                    usuarios.add(p);
                }
            } catch(Exception ex) {
                System.out.println("SQLException!! desde conexion: " + ex.getMessage());
            }
            return usuarios;
        } 
        
    /*public ArrayList getRutas() throws Exception {
        ArrayList rutas = new ArrayList();
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT idruta, destino, fecha, hora, cupo, idusuario FROM ruta");
            while(rs.next()){
                Ruta p = new Ruta();
                p.setIdruta(rs.getInt(1));
                p.setDestino(rs.getString(2));
                p.setFecha(rs.getDate(3));
                p.setHora(rs.getDate(4));
                p.setCupo(rs.getInt(5));
                p.setIdusuario(rs.getInt(5));                
                rutas.add(p);
            }
        }catch(Exception ex){
            System.out.println("SQLException!: " + ex.getMessage());
        }
        return rutas;
    } */
    
    /*
    ** AQUI EMPIEZAN LOS METODOS DE GUARDA
    *
    */       
    public boolean guardaUsuario(int id, String nombre, String apellido, String correo, 
            String passwrd) throws Exception {
        
        boolean b = false;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO usuario (idusuario, correo, nombre, apellido, passwrd)"
                    + "VALUES (" + id +",'" + correo + "', '" + nombre + "' , '" + apellido + "','" + passwrd + "')");
            b = true;
        } catch(Exception ex){
            System.out.println("SQLException!!!: " + ex.getMessage());
        }
        return b;
    }
    
    
    public boolean guardaViaje(int idRuta, int idUsuario) throws Exception {
        
        boolean b = false;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("insert into viaje (idruta, idusuario)\n" +
                                "values("+idRuta+", "+idUsuario+")");
            b = true;
        } catch(Exception ex){
            System.out.println("SQLException!!!: " + ex.getMessage());
        }
        return b;
    }
    
    public boolean actualizaUsuario(int id, String nombre, String apellido, String correo, String password) {
        boolean b = false;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("update usuario\n" +
                                "set correo = '"+correo+"', nombre='"+nombre+"', apellido = '"+apellido+"', passwrd = '"+password+"'\n" +
                                "where idusuario = "+id+" ");
            b = true;
        } catch(Exception ex){
            System.out.println("SQLException!!!: " + ex.getMessage());
        }
        return b;
    }
    
    public boolean actualizaRuta(int id, String destino, String salida, String fecha, String hora, 
            int cupo, int idUsuario, int precio) {
        
         boolean b = false;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("update ruta \n" +
                                "set destino='"+destino+"', fecha='"+fecha+"', hora='"+hora+"', cupo="+cupo+", salida='"+salida+"', precio="+precio+"\n" +
                                "where idruta="+id+"");
            b = true;
        } catch(Exception ex){
            System.out.println("SQLException!!!: " + ex.getMessage());
        }
        return b;
       
    }
    
    public boolean guardaRuta(int id, String destino, String salida, String fecha, String hora, 
            int cupo, int idUsuario, int precio) {
        
        boolean b = false;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("insert into ruta (idruta, destino, fecha, hora, cupo, idUsuario, salida, precio)\n" +
                                "values("+id+", '"+destino+"', '"+fecha+"', '"+hora+"', "+cupo+", "+idUsuario+", '"+salida+"', "+precio+")");
            b = true;
        } catch(Exception ex){
            System.out.println("SQLException!!!: " + ex.getMessage());
        }
        return b;
        
    }
    
    public boolean eliminaUsuario(int id) {
        boolean b = false;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("delete from usuario\n" +
                                    "where idusuario ="+id+"");
            stmt.executeUpdate("delete from viaje\n" +
                                    "where idruta = (select idruta from ruta where idusuario = "+id+")");
            stmt.executeUpdate("delete from ruta\n" +
                                    "where idusuario ="+id+"");
             
            b = true;
        } catch(Exception ex){
            System.out.println("SQLException!!!: " + ex.getMessage());
        }
        return b;
    }
    
    public boolean eliminaRuta(int id) {
        boolean b = false;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("delete from viaje\n" +
                                    "where idruta ="+id+" ");
            
            stmt.executeUpdate("delete from ruta\n" +
                                    "where idruta ="+id+" ");
            
            b = true;
        } catch(Exception ex){
            System.out.println("SQLException!!!: " + ex.getMessage());
        }
        return b;
    }
    
        public boolean setCreacion(int idcrea,String pago,int iduser, int idrut,int calif) throws Exception{
        boolean b = false;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("INSERT INTO creacion (idcrea,pago,iduser,idrut,calif)"
                    + "VALUES (" + idcrea +",'" + pago + "'," + iduser + "," + idrut + "," + calif  +")");
            b = true;
        }catch(Exception ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
        return b;
    }
        
     
        
    /*
    ** MAXIMOS
    *
    */ 
        
    public int getMaximoIdUsuario() throws Exception{
        int max = 0;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("select max(idUsuario) from usuario");
            while(rs.next()){
                max = rs.getInt(1);                
            }
        }catch(Exception ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
        return max;
    }
    
    public int getMaximoIdRuta() throws Exception {
        int max = 0;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("select max(idruta) from ruta");
            while(rs.next()){
                max = rs.getInt(1);                
            }
        }catch(Exception ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
        return max;
    }
}

