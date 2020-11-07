/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;

/**
 *
 * @author marta
 */
public class Inicio {
    
    public static void main(String[] args){
        Conexion conexion = new Conexion();
        try(Connection cnx = conexion.getConnection()){
            
        }catch(Exception e){
            System.out.print(e);
        }
    }
}
