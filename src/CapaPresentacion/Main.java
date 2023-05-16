package CapaPresentacion;
import CapaDatos.*; //Importamos el paqueta CapaDatos para acceder a todas las clases y métodos.
import javax.swing.*;
import java.sql.ResultSet;

public class Main { //Clase Main, desde donde vamos a ejecutar el programa paso a paso.
    public static void main(String[] args) {
        new VentanaInicioSesion();
        clsConexion objConexion = new clsConexion(); //Creamos un objeto de la clase clsConexion
        try{ // Al trabajar con bases de datos necesitamos rodear nuestro código de un bloque try-catch.
            objConexion.conectarBD();// Llamamos al método la clase clsConexion para generar la conexión.
            ResultSet rs; //Creamos un objeto ResultSet que se encargará de almacenar los resultados de la consulta...
            //...esto lo debemos hacer ANTES de realizar la consulta funcionará a modo de "Scanner" sin ser exactamente lo mismo.
            String query = "SELECT * FROM prueba"; // Creamos una variable "query" conde realizamos la consulta.
            rs = objConexion.consultarBD(query); // Agregamos dentro del objeto "rs" ResultSet la consulta para que se guarde...
            // ...dentro de este y así poder trabajar con ella con los métodos propios de la interfaz ResultSet.
            while (rs.next()) { // Usamos bucle while para iterar dentro de la tabla y el método .next() que es un puntero...
                // que apunta a las filas de dicha tabla empezando por la primera.
                System.out.println(rs.getInt("id") + " | " + (rs.getString("descr"))); // Mostramos en pantalla la info.
                //usamos el método .getXXX según el tipo de valor a obtener para extraer la información de la BD.
            }
            String query2 = "INSERT INTO prueba (descr) VALUES ('Hola mundo')";
            objConexion.ejecutarBD(query2);

            /*
            String descrp = "Comestibles";
            String img = "C:/Desktop/Adrian";
            String sql = "INSERT INTO prueba(descripcion, img) VALUES ('@descr', '@img')"; // @ se usa como marcador de posiciones
            sql = sql.replace("@descr", descrp);  //Se usa el método replace de la Clase String para reemplazar los marcadores por los valores reales...
            sql = sql.replace("@img", img); //...reemplazame el marcador X por el valor Y.
            objConexion.ejecutarBD(sql);*/


            objConexion.desconectarBD();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}