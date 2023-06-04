package CapaLogica;

import CapaDatos.clsConexion;

import java.sql.ResultSet;

public class Bajas {

    /**
     * Atributos.
     * @author Adrian Videira
     */
    clsConexion conexion = new clsConexion();
    public ResultSet resultado = null;


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

    /**
     * @use Método que se usará para verificar que el dni introducido por el usuarío existe en la base de datos..
     * @param dni
     * @return ""
     * @throws Exception
     * @author Adrian Videira
     */
    public String validarDNI (String dni) throws Exception{ // Método por el cual vamos a veriricar las credenciales introducidas por el ususario.
        String query = "SELECT dni FROM alumnos WHERE dni = '"+dni+"'";
        try{
            resultado = conexion.consultarBD(query);//Le damos al objeto conexion la consulta a través del método consultar de la clase cslConexion.
            // y este resultado se lo asignamos a la variables "resultado".
            while(resultado.next()){ //Recorremos la tabla alumnos en busca del dni introducido por el usuario. Para esto usamos...
                // ...un bucle WHILE y el método .next() que irá registo por registro de la tabla buscando el nombre escrito por el usuario.
                return resultado.getString("dni");//Retornamos el resultado de la consulta que buscará en la columna que es de tipo Booleano.
            }

        }catch (Exception e){
            throw new Exception(e.getMessage()); //Con esto lo que conseguimos es que si nos dá un error el método .consultarBD(query), irá a ese método y nos...
            //...mostrará el error del try-catch de ese método.
        }
       return "";

    }

}
