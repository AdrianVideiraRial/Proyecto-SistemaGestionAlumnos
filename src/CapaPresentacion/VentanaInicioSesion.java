package CapaPresentacion;

import CapaLogica.InicioSesion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicioSesion {
    //Componentes de la interfaz gráfica de usuario (GUI).
    private JPanel panel1; //Panel que contiene los componentes de la ventana.
    public JTextField textUsuario; //Campo de texto para que el usuario ingrese su nombre de usuario.
    private JPasswordField PasswordUsuario; //Campo para que se ingrese la contraseña.
    private JButton ingresarButton; //Botón de inicio de sesión.
    private JButton salirButton;
    private JFrame frame; // Objeto de tipo JFrame que representa la ventana principal de la aplicación.
    InicioSesion objInicioSesion = new InicioSesion(); // Creamos un objeto de la clase Inicio sesión fuera de los métodos para que podamos usarlo...
    //...si necesidad de tener que estar intanciandolo en cada método. Desde aquí usando este objeeto podremos llamar a los métodos que necesitemos en el futuro.


    //Constructor del objeto de la ventana inicio de sesión.
    public VentanaInicioSesion() {
        frame = new JFrame("Inicio sesión"); //Creamos un objeto JFrame (una ventana genérica vacía) con el título "Inicio sesión".
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); //Se establece la operación de cierre cuando se cierre la ventana.
        frame.setPreferredSize(new Dimension(250, 200)); // Se establece un tamaño.
        frame.setResizable(false); // Se deshabilita la posibilidad de redimensionar la ventana.
        frame.add(panel1); //Se añade el panel donde estan todos los elementos de la ventana al objeto frame (JFrame).
        frame.pack(); // Se empaqueta la ventana para asegurar que todos los componentes tengan el tamaño adecuado.
        frame.setLocationRelativeTo(null); // Se establece ubicación de la ventana en el centro de la pantalla.
        frame.setVisible(true); // Hacemos visible la ventana en la pantalla.


        //Boton INGRESAR. (Lógica).
        ingresarButton.addActionListener(new ActionListener() { // Le damos vida al boton del panel de inicio de sesión.
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textUsuario.getText().isEmpty()) { //Verificamos que el usuario ha introducido algo en la casilla usuario.
                    JOptionPane.showMessageDialog(textUsuario, "Por favor, ingrese un usuario válido");
                } else {
                    if (PasswordUsuario.getPassword().length == 0) { //Verificamos que el usuario ha introducido algo en la casilla contraseña.
                        JOptionPane.showMessageDialog(PasswordUsuario, "Introduce una contraseña");
                    } else {//USUARIO.**************************************************************************
                        String usuario = textUsuario.getText(); //Capturamos lo que escriba el usuario en la interfaz en la variable "usuario" para validar.
                        try {
                            boolean resultado1 = objInicioSesion.validarUsuario(usuario); // Creamos una variable boolean y usamos el método validarUsuario...
                            //...que se encargará de buscar en la tabla ese usuario y si nos dirá si el estado es "true o false".
                            if (resultado1 == true) { // Si el resultado es true, estaremos validados para entrar
                                System.out.println("Usuario correcto");
                            } else { // Si es false, el usuario no estará autorizado o no estará registrado en la base de datos
                                JOptionPane.showMessageDialog(textUsuario, "El usuario no está autorizado");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(textUsuario, "Error " + ex.getMessage());
                        }//CONTRASEÑA.**************************************************************************
                        String contraseña = String.valueOf(PasswordUsuario.getPassword()); //Capturamos la contraseña escrita en la interfaz en la variable "contraseña"
                        //Como el método .getPassword devuelve un array de caracteres, necesitamos usar String.valueOf que genera un objeto String "contraseña" con los caracteres del array del método .getPassword().
                        try {
                            boolean resultado2 = objInicioSesion.validarContraseña(contraseña); //Creamos una variable boolean y usamos el método validarContraseña...
                            //...que se encargará de buscar en la tabla esa contraseña y nos dirá si la columna estado es true o false.
                            if (resultado2 == true) {// Si coincide irá a ver la columna estado y si es (true), mostrara este mensaje por consola.
                                System.out.println("Contraseña correcta");
                            } else {// Si no coincide (false), la contraseña no será la correcta.
                                JOptionPane.showMessageDialog(PasswordUsuario, "Contraseña incorrecta");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(PasswordUsuario, "Error Contraseña incorrecta");
                        }
                        try {
                            boolean resultado1 = objInicioSesion.validarUsuario(usuario);
                            boolean resultado2 = objInicioSesion.validarContraseña(contraseña);
                            if(resultado1==true && resultado2 ==true){ //Si uruaio y contraseña OK.
                                new VentanaPrincipal(); //Creamos un objeto de Ventana Principal
                                frame.setVisible(false); //Ocultamos la ventana una vez se ejecute porque ya ha cumplido su funcíón.
                            }
                        }catch (Exception ex){

                        }
                    }

                }
            }
        });

        //Boton SALIR. (Lógica).
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    //Main para testar la ventana.
    public static void main(String[] args) {
        new VentanaInicioSesion();
    }
}


