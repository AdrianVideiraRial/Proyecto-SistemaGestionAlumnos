package CapaPresentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JFrame{
    private JPanel LoginWindow;
    private JFormattedTextField formattedTextField1;
    private JPasswordField passwordField1;
    private JButton Login;
    private JLabel IconoUser;
    private JLabel IconoLock;


    /**
     * CONSTRUCTOR LoginPanel
     * al instanciar un objeto LoginPanel, se crea una ventana para introducir el nombre y la contraseña
     * del usuario.
     */

    public LoginPanel(){
        setTitle("Inicio sesión");//Nombre de la ventan
        setContentPane(LoginWindow);//Establecemos el JPanel principal
        setBounds(600,250,350,180);//Posición en la pantalla y dimensiones
        setResizable(false);//Omitimos opcion de modificar dimensiones de la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//El programa se detiene al pulsar el boton de cerrar.

        //Boton <<Login>>
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Prueba: El boton funciona");
            }
        });

        setVisible(true);
    }

}
