package CapaPresentacion;

import CapaLogica.Calificaciones;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCalificaciones extends JFrame{
    //Componentes de la interfaz gráfica de usuario (GUI).
    private JPanel panelCalificaciones;
    public JComboBox comboClases;
    public JComboBox comboMaterias;
    private JLabel materias;
    private JButton guardarButton;
    private JButton cancelarButton;
    public JTable miTabla;
    private JPanel PanelTabla;
    public JScrollPane scrollPane;
    private JLabel clases;
    private JPanel panelFiltros;
    private JFrame frameCalificaciones;
    //Creamos un Objeto modelo Tabla que nos servirá para darle formato e interactuar con la tabla.
    public DefaultTableModel modeloTabla = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            // Hacemos las columnas "Curso", "Nombre" y "Media" como no editables
            return !(column == 0 || column == 1 || column == 2  ||  column == 6);
        }
    };
    Calificaciones objCalificaciones = new Calificaciones(this);//Creamos un objeto de la clase Calificaciones para poder operar con los métodos de esta clase
    // y poder generar la lógica para implementar en los JComboBox.

    //Constructor del objeto de la ventana Calificaciones.
    public VentanaCalificaciones(){
        frameCalificaciones = new JFrame("Calificaciones");
        frameCalificaciones.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frameCalificaciones.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); //Se establece la operación de cierre cuando se cierre la ventana.
        //frameCalificaciones.setPreferredSize(new Dimension(1000, 1000)); // Se establece un tamaño.
        //frameCalificaciones.setResizable(true); // Se deshabilita la posibilidad de redimensionar la ventana.

        //Agregamos las columnas que queremos que tenga la tabla al modelo creado en nuestra Clase.
        modeloTabla.addColumn("Curso");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Examen1");
        modeloTabla.addColumn("Examen2");
        modeloTabla.addColumn("Examen3");
        modeloTabla.addColumn("Media");

        //Agregamos los Items de filtrado.
        comboClases.addItem("Selecciona el curso");
        comboClases.addItem("1ESO");
        comboClases.addItem("2ESO");
        comboClases.addItem("3ESO");

        comboMaterias.addItem("Selecciona la asignatura");
        comboMaterias.addItem("Matemáticas");
        comboMaterias.addItem("Lengua y Literatura");
        comboMaterias.addItem("Ciencias Naturales");
        comboMaterias.addItem("Geografía e Historia");
        comboMaterias.addItem("Inglés");
        comboMaterias.addItem("Educación Física");

        miTabla.setModel(modeloTabla); //Añadimos en nuestra tabla el modelo con el formato creado.
        frameCalificaciones.add(panelCalificaciones); //Se añade el panel donde estan todos los elementos de la ventana al objeto frame (JFrame).
        frameCalificaciones.pack(); // Se empaqueta la ventana para asegurar que todos los componentes tengan el tamaño adecuado.
        frameCalificaciones.setLocationRelativeTo(null); // Se establece ubicación de la ventana en el centro de la pantalla.
        frameCalificaciones.setVisible(true); // Hacemos visible la ventana en la pantalla.

        //FILTRO ComboBox "CLASE". (Lógica).
        comboClases.addActionListener(new ActionListener() { //Establecemos un escuchador en el boton comboClases, espera eventos en el botón.
            @Override
            public void actionPerformed(ActionEvent e) { //Este método se ejecutará cuando se produzca algún evento en el JComboBox y lo almacenará en la variable "e".

                int seleccionIndice = comboClases.getSelectedIndex();// Obtenemos el indice al que identifica al elemento seleccionado del comboClases.
                String elementoSeleccionado = (String) comboClases.getItemAt(seleccionIndice);//Creamos una variable tipo String...
                //...le asignamos para que obtenga el elemento seleccionado utilizando el método .getSelectedItem de la posición (selectionIndice)...
                //...y este elemento se guarda en la variable "elemento seleccionado" tras hacerle un "casting" para extraer el String que contiene la posición del elemento en el comboBox.
                try {
                    objCalificaciones.filtradoClase(elementoSeleccionado); //Instanciamos el objetoCalificaciones y usamos el método filtradoClase....
                    //...al cual le pasamos por parámetro elementoSeleccionado que es nuestro String extraido del "seleccionIndice", el cual se usará como condición para realizar la consulta...
                    //...a la BD.
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //FILTRO ComboBox "Nombre". (Lógica).
        comboMaterias.addActionListener(new ActionListener() { //Establecemos un escuchador en el boton comboClases, espera eventos en el botón.
            @Override
            public void actionPerformed(ActionEvent e) { //Este método se ejecutará cuando se produzca algún evento en el JComboBox y lo almacenará en la variable "e".
                int seleccionIndice = comboClases.getSelectedIndex();// Obtenemos el indice al que identifica al elemento seleccionado del comboClases.
                String claseSeleccionada = (String) comboClases.getSelectedItem();// Obtener el valor seleccionado del comboClases.
                int seleccionIndice2 = comboMaterias.getSelectedIndex();// Obtenemos el indice al que identifica al elemento seleccionado del comboMaterias.
                String materiaSeleccionada = (String) comboMaterias.getSelectedItem();

                try {
                    objCalificaciones.filtrarMateriasPorClase(claseSeleccionada, materiaSeleccionada);
                    //objCalificaciones.mostrarNotas(materiaSeleccionada);//error en el programa.
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCalificaciones.setVisible(false);
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objCalificaciones.actualizarNotas();
            }
        });
    }


    public static void main(String[] args) {
        new VentanaCalificaciones();
    }


}
