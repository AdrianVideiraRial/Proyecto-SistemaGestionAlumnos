package CapaLogica;

import CapaDatos.clsConexion;


public class Registros {

    /**
     * Atributos.
     * @author Adrian Videira
     */
    clsConexion conexion = new clsConexion();


    /**
     * @use Método que se usará para hacer un insert en la tabla alumnos.
     * @param dni
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @param direccion
     * @param telefono
     * @author Adrian Videira
     */
    public String ejecutarRegistro(String dni, String nombre, String apellido, String fechaNacimiento, String direccion, String telefono){
        //Generamos la petición para insertar los datos que hay escrito el usuario.
        //Los datos se guardaran en cada una de las variables.(Estas instrucciónes se harán dentro del botonRegistrar.
        String query = "INSERT INTO alumnos (dni, nombre_alumno, apellido_alumno, fecha_nacimiento, direccion, telefono)\n" +
                "VALUES('"+dni+"', '"+nombre+"', '"+apellido+"','"+fechaNacimiento+"','"+direccion+"', '"+telefono+"')"
        ;
       try {
           conexion.ejecutarBD(query);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
       return "";
    }










}


