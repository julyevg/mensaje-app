/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author jass
 */
public class Mensajes_app {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("______________");
            System.out.println("Aplicacion de Mensaje");
            System.out.println("1. crear mensaje");
            System.out.println("2. listar mensaje");
            System.out.println("3. eliminar mensaje");
            System.out.println("4. editar mensaje");
            System.out.println("5. salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    MensajeServicio.crearMensaje();
                    break;
                case 2:
                    MensajeServicio.listarMensajes();
                    break;
                case 3:
                    MensajeServicio.borrarMensaje();
                    break;
                case 4:
                    MensajeServicio.editarMensaje();
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        } while (opcion != 5);
        
    }
}
