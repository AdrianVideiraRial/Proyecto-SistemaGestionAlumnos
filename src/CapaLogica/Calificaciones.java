package CapaLogica;

import CapaDatos.clsConexion;
import CapaPresentacion.*;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Calificaciones {
    clsConexion conexion = new clsConexion(); //Creamos un objeo para conectarnos con la base de datos.
    private ResultSet resultado = null; // Este atributo recibira el resultado de la consulta que vamos a hacer a la base de datos...
    private ResultSet resultado2 = null;
    private ResultSet resultado3 = null;
    private ResultSet resultado4 = null;
    private VentanaCalificaciones objVentanaCalificaciones; //Creamos un objeto VentanaCalificaciones para poder acceder a sus atributos y métodos.
    private Object[] fila = new Object[8];

    //Constructor que recibe un parámetro de tipo objeto VentanaCalificaciones
    // y asigna el parámetro de tipo objeto al campo objVentanaCalificaciones.
    public Calificaciones(VentanaCalificaciones ventanaCalificaciones){
        objVentanaCalificaciones = ventanaCalificaciones;
    }


    //Método para realizar el filtrado de la tabla en la columna Curos.
    public Object filtradoClase(String clase) throws Exception { //Método para usar en el botón "ComboClasesButton".
        String query = "SELECT nombre_clase FROM informacion_general WHERE nombre_clase = '"+clase+"'"; //Consulta con nuestro criterio de filtrado.
        try { //Uso try-catch porque estamos trabajando con BD.
            resultado = conexion.consultarBD(query);
            while (resultado.next()) {//Recorremos la tabla usuarios en busca de la credencial introducida por el usuario. Para esto usamos...
                // ...un bucle WHILE y el método .next() que irá registo por registro de la tabla buscando el nombre escrito por el usuario.
                //Object[] fila = new Object[1];
                fila[0] = resultado.getString("nombre_clase");
                objVentanaCalificaciones.modeloTabla.addRow(fila);
            }
        } catch (Exception e) {
            throw new Exception(e);//Con esto lo que conseguimos es que si nos dá un error el método .consultarBD(query), irá a ese método y nos...
            //...mostrará el error del try-catch de ese método.
        }
        return "";
    }

    public Object filtrarMateriasPorClase(String clase, String materia) throws Exception{
        //Consulta con nuestro criterio de filtrado.
        String query = "SELECT nombre_clase FROM informacion_general WHERE nombre_clase = '"+clase+"'";
        String query2 = "SELECT nombre_alumno FROM informacion_general WHERE nombre_clase = '"+clase+"'"+"AND nombre_materia = '"+materia+"'"; //Consulta con nuestro criterio de filtrado.
        String query3 = "SELECT apellido_alumno FROM informacion_general WHERE nombre_clase = '"+clase+"'"+"AND nombre_materia = '"+materia+"'"; //Consulta con nuestro criterio de filtrado.
        //String query4 = "SELECT examen_1 FROM informacion_general WHERE nombre_alumno = '"+resultado2.getString("nombre_alumno")+"' AND apellido_alumno = '"+resultado3.getString("apellido_alumno")+"'"+"AND nombre_materia = '"+materia+"'";
        try { //Uso try-catch porque estamos trabajando con BD.
            objVentanaCalificaciones.modeloTabla.setRowCount(0); //Eliminamos todas las filas de la tabla antes de insertar nuevos datos.
            resultado = conexion.consultarBD(query);
            resultado2 = conexion.consultarBD(query2);
            resultado3 = conexion.consultarBD(query3);
            //resultado4 = conexion.consultarBD(query4);

            while (resultado.next() && resultado2.next() && resultado3.next()) {//Recorremos la tabla usuarios en busca de la credencial introducida por el usuario. Para esto usamos...
                // ...un bucle WHILE y el método .next() que irá registo por registro de la tabla buscando el nombre escrito por el usuario.
                //Object[] fila = new Object[12];
                fila[0] = resultado.getString("nombre_clase");
                fila[1] = resultado2.getString("nombre_alumno");
                fila[2] = resultado3.getString("apellido_alumno");

                objVentanaCalificaciones.modeloTabla.addRow(fila);
            }
        } catch (Exception e) {
            throw new Exception(e);//Con esto lo que conseguimos es que si nos dá un error el método .consultarBD(query), irá a ese método y nos...
            //...mostrará el error del try-catch de ese método.
        }
        return "";
    }

    public Object mostrarNotas(String materia) throws Exception {
        //Consulta con nuestro criterio de filtrado.
        //String query = "SELECT nombre_clase FROM informacion_general WHERE nombre_clase = '"+clase+"'";
        //String query2 = "SELECT nombre_alumno FROM informacion_general WHERE nombre_clase = '"+clase+"'"+"AND nombre_materia = '"+materia+"'"; //Consulta con nuestro criterio de filtrado.
        //String query3 = "SELECT apellido_alumno FROM informacion_general WHERE nombre_clase = '"+clase+"'"+"AND nombre_materia = '"+materia+"'"; //Consulta con nuestro criterio de filtrado.
        String query4 = "SELECT examen_1 FROM informacion_general WHERE nombre_alumno = '"+resultado2.getString("nombre_alumno")+"' AND apellido_alumno = '"+resultado3.getString("apellido_alumno")+"'"+"AND nombre_materia = '"+materia+"'";
        //String query4 = "SELECT examen_1, examen_2, examen_3 FROM informacion_general WHERE nombre_materia = '" + materia + "'";
        //resultado2 = conexion.consultarBD(query2);
        //resultado3 = conexion.consultarBD(query3);
        //resultado4 = conexion.consultarBD(query4);
        try {
            objVentanaCalificaciones.modeloTabla.setRowCount(0);
            resultado4 = conexion.consultarBD(query4);
            while (resultado.next() && resultado2.next() && resultado3.next() & resultado4.next()) {//Recorremos la tabla usuarios en busca de la credencial introducida por el usuario. Para esto usamos...
                // ...un bucle WHILE y el método .next() que irá registo por registro de la tabla buscando el nombre escrito por el usuario.
                //Object[] fila = new Object[4];
                fila[0] = resultado.getString("nombre_clase");
                fila[1] = resultado2.getString("nombre_alumno");
                fila[2] = resultado3.getString("apellido_alumno");
                fila[3] = resultado4.getInt("examen_1");
                fila[4] = resultado4.getInt("examen_2");
                fila[5] = resultado4.getInt("examen_3");

                objVentanaCalificaciones.modeloTabla.addRow(fila);
            }
        } catch (Exception ex) {
            throw new Exception(ex);//Con esto lo que conseguimos es que si nos dá un error el método .consultarBD(query), irá a ese método y nos...
            //...mostrará el error del try-catch de ese método.
        }
        return "";
    }

}
