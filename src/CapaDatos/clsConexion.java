package CapaDatos;
import javax.xml.transform.Result;
import java.sql.*;

public class clsConexion { //En esta clase crearemos la conexion con la base de datos Postgres y nos comunicaremos con ella.

    //Atributos de la clase.
    public String usuario; // Usuario Postgres.
    public String contrasena; // Contraseña al instalar Postgres.
    public String url; // Ruta de la base de datos.
    public String driver; // Controlador JDBC (añadido a la librería).
    public Connection conexion; // Objeto que funciona de receptor de la conexion entre Java y PostgreSQL.
    public PreparedStatement pt; // Objeto a través del cual se preparan las consultas SQL.

    //Constructor para crear objetos tipo conexión.
    public clsConexion(){ // Objeto en el que predefinimos los datos necesarios para establecer la conexión.
        usuario = "postgres"; // Usuario por defecto en PostgreSQL
        contrasena = "adrian"; // Contraseña para acceder a PostgreSQL
        url = "jdbc:postgresql://localhost:5432/Escuela"; //Ruta para conectarnos a nuestra BD "Escuala".
        driver = "org.postgresql.Driver";
        conexion = null;
    }

    //Método para conectarnos a la BD.
    public void conectarBD(){
        try {
            //Generamos la conexion usando la interfaz Connection y la clase DriverManager donde le damos los datos necesario para la conexión.
            //En este caso url, usuario y contraseña ya definidas en el constructor clsConexion.
            conexion = DriverManager.getConnection(url,usuario,contrasena); //DriverManager nos permitirá la conexión meidante el Driver JDBC.
            System.out.println("Conexion realizada con éxito");
        }catch (Exception e){
            System.out.println("Error de conexión con la base de datos PostgreSQL");
            System.out.println("Revisa el método conectarBD");
        }
    }

    //Método para desconectarse de la BD.
    public void desconectarBD(){
        try{
            conexion.close(); // Usamos el metodo .close() de la clase Connection en nuestro objeto "conexion" para desconectarnos de la BD.
            System.out.println("Desconexión efectuada con éxito");
        } catch (Exception e){
            System.out.println("Error en el método desconectarBD"); // Mostramos un mensaje en caso de que algo no funcione.
        }
    }

    //Método para consultarle a la BD.
    public ResultSet consultarBD(String sentencia) throws Exception {//La Interfaz ResultSet nos permite movernos por las tablas de la BD.
        try { //throws Exception: indica que este método debe manejar errores de la clase Exception.
            conectarBD(); // Nos conectamos a la base de datos para poder hacer la consulta con el método que hemos creado.
            pt = conexion.prepareStatement(sentencia); // Usamos el Objeto de la interfaz PreparedStatement para realizar la consulta.
            System.out.println(pt); // Mostramos la consulta por pantalla para poder checkearla.
            return pt.executeQuery();//Usamos este método para que ejecute la consulta.
        }catch (Exception e){
            throw new Exception("Error al ejecutar la consulta");
        }finally { // Este bloque de código "finally" se ejecutará siempre pase lo que pase.
            conexion.close(); // Cerramos la conexión en PostgreSQL.(Optimizamos los recursos del sitema).
        }
    }

    //Método para operaciones CRUD de la BD.
    public void ejecutarBD(String sentencia) throws Exception { // Hacemos este método void ya que no necesitamos retornar nada, solo queremos manipular la BD.
        try{ //throws Exception: indica que este método debe manejar errores de la clase Exception.
            conectarBD(); // Nos conectamos a la base de datos para poder hacer la consulta con el método que hemos creado.
            pt = conexion.prepareStatement(sentencia);// Usamos el Objeto de la interfaz PreparedStatement para realizar la consulta.
            pt.executeUpdate();//Este método es el que nos permite ejecutar ordenes CRUD en la base de datos.
        } catch (Exception e){
            throw new Exception("Error al ejecutar la Base de datos");
        } finally { // Este bloque de código "finally" se ejecutará siempre pase lo que pase.
            conexion.close(); // Cerramos la conexión en PostgreSQL.(Optimizamos los recursos del sitema).
        }
    }










}
