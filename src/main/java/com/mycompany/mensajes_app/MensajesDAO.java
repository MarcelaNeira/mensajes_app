/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marta
 */
public class MensajesDAO {
    
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion dbConnect = new Conexion();
        try(Connection  conexion = dbConnect.getConnection()){
            PreparedStatement ps = null;
            try{
               String query = "INSERT INTO `mensajes` (mensaje, autor_mensaje) VALUES (?,?)";
               ps=conexion.prepareStatement(query);
               ps.setString(1, mensaje.getMensaje());
               ps.setString(2, mensaje.getAutorMensaje());
               ps.executeUpdate();
               System.out.println("Mensaje creado");
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void leerMesajesDB(){
        Conexion dbConnect = new Conexion();
        try(Connection  conexion = dbConnect.getConnection()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            String query = "SELECT * FROM mensajes";
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();
            
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("-------------------------------------");
           }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void borrarMensajesDB(int idMensaje){
        Conexion dbConnect = new Conexion();
        try(Connection  conexion = dbConnect.getConnection()){
            PreparedStatement ps = null;
            try{
               String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
               ps=conexion.prepareStatement(query);
               ps.setInt(1, idMensaje);               
               ps.executeUpdate();
               System.out.println("Mensaje Eliminado");
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void actualizarMensajesDB(Mensajes mensaje){
        Conexion dbConnect = new Conexion();
        try(Connection  conexion = dbConnect.getConnection()){
            PreparedStatement ps = null;
            try{
               String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
               ps=conexion.prepareStatement(query);
               ps.setString(1, mensaje.getMensaje());  
               ps.setInt(2, mensaje.getIdMensaje());                              
               ps.executeUpdate();
               System.out.println("Mensaje Actualizado");
            }catch(SQLException ex){
                System.out.println(ex);
                System.out.println("No se pudo actualizar mensaje");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
