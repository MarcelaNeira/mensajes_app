/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author marta
 */
public class MensajesService {
    
    
    public static void crearMensaje(){
       Scanner sc =new Scanner(System.in);
       System.out.println("Escribe tu mensaje");
       String mensaje = sc.nextLine();
       
       System.out.println("Nombre: ");
       String nombre = sc.nextLine();
       
       Mensajes registro = new Mensajes();
       registro.setMensaje(mensaje);
       registro.setAutorMensaje(nombre);
       MensajesDAO.crearMensajeDB(registro);
     }
    public static void listarMensaje(){
        MensajesDAO.leerMesajesDB();
    }
    public static void borrarMensaje(){
       Scanner sc = new Scanner(System.in);
       System.out.println("Indica el ID del mensaje a borrar");
       int id_mensaje = sc.nextInt();
       MensajesDAO.borrarMensajesDB(id_mensaje);
    }
    public static void editarMensaje(){
       Scanner sc = new Scanner(System.in);
       System.out.println("Indica el ID del mensaje que quieres actualizar");
       int id_mensaje = sc.nextInt();
       sc.nextLine();
       System.out.println("Escribe tu mensaje para actualizar");
       String sms = sc.nextLine();      
       Mensajes actualizado = new Mensajes();
       actualizado.setIdMensaje(id_mensaje);
       actualizado.setMensaje(sms);
       MensajesDAO.actualizarMensajesDB(actualizado);
    }
}
