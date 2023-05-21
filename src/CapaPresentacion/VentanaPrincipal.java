package CapaPresentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame{
    //Componentes de la interfaz gráfica de usuario (GUI).
    private JPanel panelPrincipal;//Panel que contiene los componentes de la ventana.
    private JButton calificacionesButton; //Botón que nos dá acceso a la ventana de calificaciones.
    private JButton registrosButton; //Botón que nos dá acceso a la ventana de pasar lista.
    private JButton tutoríaButton; //Botón que nos dá acceso a la ventana de tutoría.
    private JButton justificarButton; //Botón que nos dá acceso a la ventana de justificar.
    private JButton informesButton; //Botón que nos dá acceso a la ventana de informes.
    private JButton Salir; //Botón que nos permite salir del programa.
    private JLabel LogoUsuario;
    private JComboBox comboBox1; //Desplegable con datos personales.
    private JComboBox comboBox2; //Desplegable con mensajes.
    private JButton pasarListaButton;
    private JLabel titulo;
    private JFrame framePrincipal;



    public VentanaPrincipal(){
        framePrincipal = new JFrame("Menú principal"); //Creamos un objeto JFrame (una ventana genérica vacía) con el título "Menú principal".
        framePrincipal.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //Se establece la operación de cierre cuando se cierre la ventana.
        framePrincipal.setPreferredSize(new Dimension(300,550)); //Definimos el tamaño de la vetana
        framePrincipal.setResizable(false); //Definimos que sea fijo su tamaño.
        framePrincipal.add(panelPrincipal); //Añadimos el panelPrincipal al frame.
        framePrincipal.pack(); //Se empaqueta la ventana para asegurar que todos los componentes tengan el tamaño adecuado.
        framePrincipal.setLocationRelativeTo(null); // Se establece ubicación de la ventana en el centro de la pantalla.
        framePrincipal.setVisible(true); // Hacemos visible la ventana en la pantalla.




        //BOTÓN SALIR. (Lógica).
        Salir.addActionListener(new ActionListener() { //Le damos vida al botón salir.
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); //Hacmos que una vez presionado el botón salgamos del programa.
            }
        });

        //BOTÓN CALIFICACIONES. (Lógica).
        calificacionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaCalificaciones();
            }
        });

        //BOTÓN REGISTROS. (Lógica).
        registrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaRegistros();
            }
        });
    }

    //Método para generar una ventana principal
    public Object getVentanaPrincipal(){
        return new VentanaPrincipal();
    }



    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}
