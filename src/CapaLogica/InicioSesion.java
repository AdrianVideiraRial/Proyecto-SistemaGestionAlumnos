package CapaLogica;
import CapaDatos.*;
import java.sql.ResultSet;

public class InicioSesion {
    clsConexion conexion = new clsConexion(); //Creamos un objeto para generar la conexión de la clase clsConexion.
    ResultSet resultado = null; // Este atributo recibira el resultado de la consulta que vamos a hacer a la base de datos...
    // ...para verificar las credenciales del usuario.

    public boolean validarUsuario (String usuario) throws Exception{ // Método por el cual vamos a veriricar las credenciales introducidas por el ususario.
        String query = "SELECT estado FROM usuarios WHERE nombre_usuario = '"+usuario+"'";
        try{
            resultado = conexion.consultarBD(query);//Le damos al objeto conexion la consulta a través del método consultar de la clase cslConexion.
            // y este resultado se lo asignamos a la variables "resultado".
            while(resultado.next()){ //Recorremos la tabla usuarios en busca de la credencial introducida por el usuario. Para esto usamos...
                // ...un bucle WHILE y el método .next() que irá registo por registro de la tabla buscando el nombre escrito por el usuario.
                return resultado.getBoolean("estado");//Retornamos el resultado de la consulta que buscará en la columna que es de tipo Booleano.
            }
        }catch (Exception e){
            throw new Exception(e.getMessage()); //Con esto lo que conseguimos es que si nos dá un error el método .consultarBD(query), irá a ese método y nos...
            //...mostrará el error del try-catch de ese método.
        }
        return false;
    }

    public boolean validarContraseña (String contraseña) throws Exception{ // Método por el cual vamos a veriricar las credenciales introducidas por el ususario.
        String query = "SELECT estado FROM usuarios WHERE contraseña = '"+contraseña+"'";
        try{
            resultado = conexion.consultarBD(query);//Le damos al objeto conexion la consulta a través del método consultar de la clase cslConexion.
            // y este resultado se lo asignamos a la variables "resultado".
            while(resultado.next()){ //Recorremos la tabla usuarios en busca de la credencial introducida por el usuario. Para esto usamos...
                // ...un bucle WHILE y el método .next() que irá registo por registro de la tabla buscando el nombre escrito por el usuario.
                return resultado.getBoolean("estado");//Retornamos el resultado de la consulta que buscará en la columna que es de tipo Booleano.
            }
        }catch (Exception e){
            throw new Exception(e.getMessage()); //Con esto lo que conseguimos es que si nos dá un error el método .consultarBD(query), irá a ese método y nos...
            //...mostrará el error del try-catch de ese método.
        }
        return false;
    }






}
