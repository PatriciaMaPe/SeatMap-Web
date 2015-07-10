package conexionBD;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Consultas {

    private Connection conexion;
    private ResultSet resultadoConsulta;
    private ResultSetMetaData metaDatos;
    private String consulta;
    private String error;

    //Creamos dos arrays para los datos devueltos de la consulta y para la cabecera
    private String[][] datosDevueltos;
    private String[] nombresColumnas;

    //En el constructor recibimos la conexion que hemos establecido
    public Consultas(Connection conexionRecibida) {
        this.conexion = conexionRecibida;

    }

    

    //Metodo para hacer consultas que devuelven datos
    public ResultSet consultaSelect(String consulta) {
        try {
            //Se crea una instancia para mandar sentencias al servidor MySQL
            Statement sentencia = conexion.createStatement();
            //Se ejecuta la consulta y devuelve el ResultSet
            resultadoConsulta = sentencia.executeQuery(consulta);
            //Se obtienen los metadatos de ResultSet
            metaDatos = resultadoConsulta.getMetaData();
            error=null;
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
            error=e.getMessage();
        }
        return resultadoConsulta;
    }

    //Metodo que devuelve los datos generados por la consulta
    public String[][] getDatosDevueltos() {
        int filas = 0, columnas = 0;
            try {
                //Se devuelve el numero de columnas del resultset
                columnas = metaDatos.getColumnCount();
                //Se lleva el cursor a la ultima fila del resultset
                resultadoConsulta.last();
                //Obtiene el numero de fila actual(la ultima, que es donde estamos)
                filas = resultadoConsulta.getRow();
                //Se dimensiona el array datosDevueltos con los enteros obtenidos
                datosDevueltos = new String[filas][columnas];
                //Se ubica el cursor antes de la primera fila
                resultadoConsulta.beforeFirst();
                for (int i = 0; i < filas; i++) {
                    //Va a la siguiente fila
                    resultadoConsulta.next();
                    for (int j = 0; j < columnas; j++) {
                        //Obtiene el valor de cada una de las columnas en la fila actual
                        datosDevueltos[i][j] = resultadoConsulta.getString(j + 1);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        return datosDevueltos;
    }

    //Metodo que devuelve los nombres de los campos de la consulta
    public String[] getNombresColumnas() {
            try {
                //Devuelve el numero de columnas
                int columnas = metaDatos.getColumnCount();
                nombresColumnas = new String[columnas];
                for (int i = 0; i < columnas; i++) {
                    //Obtiene el nombre de cada una de las columnas
                    nombresColumnas[i] = metaDatos.getColumnLabel(i + 1);
                }
            } catch (SQLException ex) {
                System.out.println("Error" + ex.getMessage());
            }
        return nombresColumnas;
    }

    //Metodo para hacer consultas que NO devuelven datos
    public void consultar(String consulta) {
        try {
            //Se crea una instancia para mandar sentencias al servidor MySQL
            Statement statement = conexion.createStatement();
            //Se ejecuta la consulta
            statement.execute(consulta);

        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }

    }
    
    public String getMensajeError(){
        return error;
    }
}
