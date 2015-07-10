package conexionBD;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Patripon
 */
public class AsientoDAO {

    Connection conActual = null;

    public void accion(String accion, String seatmapL, String dni) {
        String consulta = "";
        Statement stmt = null;

        if (accion.equals("comprar")) {
            consulta = "update asientos set dni='" + dni + "' where cAsiento='" + seatmapL + "' and dni is null";

        } 
        if (accion.equals("borrar")) {
            consulta = "update asientos set dni=null where dni='" + dni + "' and cAsiento='" + seatmapL + "'";
        }

        //Creo conexion y la guardo en currentCon
        Conector conector = new Conector();
        conActual = conector.getConnection();
        //Ejecuto la consulta 
        Consultas consultas = new Consultas(conActual);
        consultas.consultar(consulta);
        conector.cerrarConexion();

    }
}
