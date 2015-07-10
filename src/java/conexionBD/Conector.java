/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Patripon
 */
public class Conector {
Connection conexion = null;
        String error;
    

    public Connection getConnection() {
         conexion = null;
         
        try {
            /*Creamos una asociacion entre nuestra aplicacion y la clase
             Driver que esta empaquetada en el jar de conexion
             */
            Class.forName("com.mysql.jdbc.Driver");
            /*La conexion se obtiene con una cadena que usa los 
             parametros que recibe el constructor
             */
            conexion = DriverManager.getConnection("jdbc:mysql://" + "localhost:3306" + "/" + "usuarios", "root", "root");
        } //Si no se encuentra el Driver se lanza la excepcion:
        catch (ClassNotFoundException e) {
            System.out.println("No se ha podido crear asociacion");
            System.out.println("Error" + e.getMessage());
            error=e.getMessage();
        } //Si no se puede crear la conexion se lanza la excepcion:
        catch (SQLException e) {
            System.out.println("No se ha podido crear conexion");
            System.out.println("Error" + e.getMessage());
            error=e.getMessage();
        }
        return conexion;

    }
    
     //Metodo que cierra la conexion
    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }
}
