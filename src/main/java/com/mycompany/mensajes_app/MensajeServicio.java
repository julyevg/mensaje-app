/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author jass
 */
public class MensajeServicio {

    public static void crearMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String texto = sc.nextLine();
        System.out.println("Escribe el autor de mensaje");
        String autor = sc.nextLine();

        Mensajes mensaje = new Mensajes();

        mensaje.setMensaje(texto);
        mensaje.setAutor_mensaje(autor);

        MensajeDAO.crearMensajeDB(mensaje);

    }

    public static void listarMensajes() {
        MensajeDAO.leerMensajesDB();
    }

    public static void borrarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indicar el Id del mensaj a borrar");
        int id_mensaje = sc.nextInt();
        MensajeDAO.borrarMensajeDB(id_mensaje);

    }

    public static void editarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribir nuevo mensaje");
        String mensajeTexto = sc.nextLine();
        System.out.println("Escribir id mensaje");
        int id_mensaje = sc.nextInt();
        Mensajes mensaje_actualizacion = new Mensajes();

        mensaje_actualizacion.setMensaje(mensajeTexto);
        mensaje_actualizacion.setId_mensaje(id_mensaje);
        MensajeDAO.actualizarMensajeDB(mensaje_actualizacion);
    }
}
