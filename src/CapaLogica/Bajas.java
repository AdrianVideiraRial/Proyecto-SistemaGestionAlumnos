package CapaLogica;

import CapaDatos.clsConexion;
public class Bajas {

    /**
     * Atributos.
     * @author Adrian Videira
     */
    clsConexion conexion = new clsConexion();


    /**
     * @use Método que se usará para dar de baja a un alumno en la tabla alumnos de la base de datos.
     * @use Ejecuta una sentencia en la tabla alumnos de la base de datos.
     * @param dni
     * @author Adrian Videira
     */
    public String ejecutarBaja(String dni) {
        String query = "DELETE FROM public.alumnos\n" +
                "WHERE dni ='"+dni+"'";
        try
        {
            conexion.ejecutarBD(query);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return"";
    }

}
