package conexionBD;

import beans.Persona;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Patripon
 */
public class PersonaDAO {

    Connection conActual = null;
    ResultSet rs = null;

    public Persona login(Persona bean) {
        
        Statement stmt = null;
        String dni = bean.getDni();
        String password = bean.getPass();

        String consulta = "select * from personas where dni='"+dni+"' AND pass='"+ password +"'";
        try {
            //Creo conexion y la guardo en conActual
            Conector conector = new Conector();
            conActual = conector.getConnection();
            //Ejecuto la consulta 
            Consultas consultas = new Consultas(conActual);
            rs = consultas.consultaSelect(consulta);
            
            boolean existe = rs.next();
            // Si el usuario no existe la variable isValid se pone en false
            if (!existe) {
                System.out.println("No estas registrado");
                bean.setValido(false);
            } //Si el usuario existe la variable isValidse pone en false
            else if (existe) {
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");

                System.out.println("Bienvenido " + nombre);
                bean.setNombre(nombre);
                bean.setApellidos(apellidos);
                bean.setValido(true);
            }
            conector.cerrarConexion();
        } catch (Exception ex) {

            System.out.println("Ocurrio un error en el logueo " + ex);

        } 
        
        return bean;
    }

}
