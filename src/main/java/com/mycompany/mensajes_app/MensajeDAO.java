/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jass
 */
public class MensajeDAO {

    public static void crearMensajeDB(Mensajes mensaje) {
        Conexion db_conexion = new Conexion();

        try ( Connection conexion = db_conexion.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes_app.mensajes\n"
                        + "( mensaje, autor_mensaje, fecha)\n"
                        + "VALUES(?, ?, CURRENT_TIMESTAMP)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();

                System.out.println("Mensaje creado");

            } catch (SQLException e) {

                System.out.println(e);

            }

        } catch (Exception e) {

            System.out.println(e);

        }
    }

    public static void leerMensajesDB() {
        Conexion db_conexion = new Conexion();

        try ( Connection conexion = db_conexion.get_connection()) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "select * from mensajes";
                ps = conexion.prepareStatement(query);
                rs = ps.executeQuery();

                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id_mensaje"));
                    System.out.println("Mensaje : " + rs.getString("mensaje"));
                    System.out.println("Autor: " + rs.getString("autor_mensaje"));
                    System.out.println("fecha: " + rs.getString("fecha"));
                    System.out.println(" ");

                }

            } catch (SQLException e) {
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static void borrarMensajeDB(int id_mensaje) {
        Conexion db_conexion = new Conexion();
        try ( Connection conexion = db_conexion.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "delete from mensajes where id_mensaje =?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();

                System.out.println("mensaje borrado");

            } catch (SQLException e) {
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static void actualizarMensajeDB(Mensajes mensaje) {
        
          Conexion db_conexion = new Conexion();
        try ( Connection conexion = db_conexion.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "update mensajes set mensaje =? where id_mensaje =?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();

                System.out.println("mensaje actualizado");

            } catch (SQLException e) {
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
