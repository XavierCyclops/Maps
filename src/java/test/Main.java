/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import controlador.*;
import java.util.ArrayList;
/**
 *
 * @author ReneGL
 */
public class Main {
    public static void main(String[] args) throws Exception {
        
        //Prueba conexion
        ArrayList l = new ArrayList();
        Conexion con = new Conexion();
        con.conectar();
        l = con.getUsuarios();
        con.desconectar();
        Usuario s = (Usuario) l.get(0);
        assert s != null;
        
        boolean estado = false; 
        
        //Prueba usuario guarda uno y maximoID
        /*Usuario user = new Usuario();
        user.conecta();
        int id = user.getMaximoId();
        id += 1;
        estado = user.guarda(id, "Otro", "MArtinez", "lol@ciecnias", "Rene8523");
        user.desconecta();
        assert estado;*/
        
        //Prueba iniciar sesion 
        ArrayList usuarios = new ArrayList();
        Usuario user = new Usuario();
        user.conecta();
        usuarios = user.getUsuarios();
        user.desconecta();
        
        System.out.println(usuarios.size());
    }
}
