package CapaLogica;

import CapaDatos.clsConexion;
import CapaPresentacion.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Calificaciones {
    /**
     * Atributos
     * @author Adrian Videira
     */
    clsConexion conexion = new clsConexion(); //Creamos un objeo para conectarnos con la base de datos.
    private ResultSet resultado = null; // Este atributo recibira el resultado de la consulta que vamos a hacer a la base de datos...
    private ResultSet resultado2 = null;
    private ResultSet resultado3 = null;
    private ResultSet resultado4 = null;
    private VentanaCalificaciones objVentanaCalificaciones; //Creamos un objeto VentanaCalificaciones para poder acceder a sus atributos y métodos.
    private Object[] fila = new Object[8];

     /**
     * Constructor que recibe un parámetro de tipo objeto VentanaCalificaciones
     * y asigna el parámetro de tipo objeto al campo objVentanaCalificaciones.
     * @param ventanaCalificaciones
     * @author Adrian Videira
     */
    public Calificaciones(VentanaCalificaciones ventanaCalificaciones){
        objVentanaCalificaciones = ventanaCalificaciones;
    }


    /**
     * @use Método para realizar el filtrado de la tabla en la columna Curos.
     * @param clase
     * @return
     * @throws Exception
     * @author Adrian Videira
     */
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

    /**
     * @use Método para realizar el filtrado de la tabla en la columna materias.
     * @param clase
     * @param materia
     * @return
     * @throws Exception
     * @author Adrian Videira
     */
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
                //Object[] fila = new Object[8];
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


     /**
     * @use Método para realizar rellenar la tabla informacion_general con las notas de los alumnos
     * escritas por el profesor en la ventana Calificaciones después de haber filtrado por clase y materia.
     * (NO FUNCIONA).
     * @author Adrian Videira
     */
    public void actualizarNotas(){
        int fila = objVentanaCalificaciones.miTabla.getSelectedRow(); //Obtenemos el número de la fila seleccionada.

        int id = Integer.parseInt(this.objVentanaCalificaciones.miTabla.getValueAt(fila,3).toString());
        String examen1 = objVentanaCalificaciones.miTabla.getValueAt(fila,3).toString();
        String examen2 = objVentanaCalificaciones.miTabla.getValueAt(fila,4).toString();
        String examen3 = objVentanaCalificaciones.miTabla.getValueAt(fila,5).toString();

        String query = "INSERT INTO informacion_general VALUES(examen_1 ='"+examen1+"', examen_2='"+examen2+"', examen_3='"+examen3+"' WHERE id = identificador_general)";
        try {
            conexion.ejecutarBD(query);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo actualizar");
        }

    }

}
