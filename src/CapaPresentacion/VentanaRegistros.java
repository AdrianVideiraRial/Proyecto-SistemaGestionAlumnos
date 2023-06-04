package CapaPresentacion;

import CapaLogica.Registros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VentanaRegistros {
    /**
     * Componentes de la ventan.
     * @author Adrian Videira
     */
    private JPanel panelSuperior;
    private JPanel panelCentral;
    private JPanel panelInferior;
    private JLabel titulo;
    private JLabel Imagen;
    private JTextField textDNI;
    private JTextField textNombre;
    private JTextField textApellido;
    private JTextField textFechaNacimiento;
    private JTextField textDireccion;
    private JTextField textTelefono;
    private JButton registrarButton;
    private JButton salirButton;
    private JPanel panelGeneral;
    private JButton cancelarButton;
    private JFrame framePrincipal;
    Registros objRegistros = new Registros();

    /**
     * Constructor
     * @author Adrian Videira
     */
    public VentanaRegistros(){
        framePrincipal = new JFrame("Registro alumnos"); //Creamos un objeto JFrame (una ventana genérica vacía) con el título "Registro alumnos".
        framePrincipal.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); //Se establece la operación de cierre cuando se cierre la ventana.
        framePrincipal.setPreferredSize(new Dimension(500,500)); //Definimos el tamaño de la vetana
        framePrincipal.setResizable(false); //Definimos que sea fijo su tamaño.
        framePrincipal.add(panelGeneral); //Añadimos el panelPrincipal al frame.
        framePrincipal.pack(); //Se empaqueta la ventana para asegurar que todos los componentes tengan el tamaño adecuado.
        framePrincipal.setLocationRelativeTo(null); // Se establece ubicación de la ventana en el centro de la pantalla.
        framePrincipal.setVisible(true); // Hacemos visible la ventana en la pantalla.

        //BOTÓN registrar. (Lógica).
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1º- Verificamos que los campos están cubiertos.
                if(textDNI.getText().isEmpty()){
                    JOptionPane.showMessageDialog(textDNI, "Por favor, ingrese DNI");
                }
                if(textNombre.getText().isEmpty()){
                    JOptionPane.showMessageDialog(textNombre, "Por favor, ingrese nombre");
                }
                if(textApellido.getText().isEmpty()){
                    JOptionPane.showMessageDialog(textApellido, "Por favor, ingrese apellido");
                }
                if(textFechaNacimiento.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(textFechaNacimiento, "Por favor, ingrese una fecha de nacimiento");
                }
                if(textDireccion.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(textDireccion, "Por favor, ingrese una dirección");
                }
                if(textTelefono.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(textTelefono, "Por favor, ingrese un teléfono");
                }
                else{
                    String patronDNI = ("\\d{8}"); //Creamos un patrón con el formato que queremos que tenga el DNI
                    if(!textDNI.getText().matches(patronDNI)){ //En caso de que no se cumpla, enviamos un mensaje al usuario.
                        JOptionPane.showMessageDialog(textDNI,"El DNI debe tener 8 digitos");
                    }
                    String patronFecha = ("\\d{4}-\\d{2}-\\d{2}"); //Creamos un patrón con el formato que queremos que tenga el DNI
                    if(!textFechaNacimiento.getText().matches(patronFecha)){ //En caso de que no se cumpla, enviamos un mensaje al usuario.
                        JOptionPane.showMessageDialog(textFechaNacimiento,"La fecha debe tener el formato correcto: AAAA-MM-dd");
                    }
                    String patronTelefono = ("\\d{9}"); //Creamos un patrón con el formato que queremos que tenga el DNI
                    if(!textTelefono.getText().matches(patronTelefono)){ //En caso de que no se cumpla, enviamos un mensaje al usuario.
                        JOptionPane.showMessageDialog(textTelefono,"El telefono debe tener 9 digitos");
                    }
                    /**
                     * @author Adrian Videira.
                     * @date 2023/06/04.
                     * @revision 0.1
                     * Mejora realizada en el if, para que solo muestre el mensaje de "Registro realizado con éxito" si se cumplen los formatos de los textos declarados previamente.
                     */
                    if (textFechaNacimiento.getText().matches(patronFecha) && textDNI.getText().matches(patronDNI) && textTelefono.getText().matches(patronTelefono)) {
                        try{
                            //Obtenemos los datos introducidos por el ususario para luego darselos al método ejecutarRegistro.
                            String dni = textDNI.getText();
                            String nombre = textNombre.getText();
                            String apellido = textApellido.getText();
                            String fechaNacimiento = textFechaNacimiento.getText();
                            String direccion = textDireccion.getText();
                            String telefono = textTelefono.getText();

                            //Ejecutamos la orden.
                            objRegistros.ejecutarRegistro(dni,nombre,apellido,fechaNacimiento,direccion,telefono);

                            //Mensaje que confirma que la inserción ha sido correcta.
                            JOptionPane.showMessageDialog(registrarButton,"Registro realizado con éxito");

                        }catch (Exception ex){
                            System.out.println(ex.getMessage());
                        }

                    }

                }

            }
        });

        //BOTÓN cancelar (Lógica).
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textDNI.setText("");
                textNombre.setText("");
                textApellido.setText("");
                textFechaNacimiento.setText("");
                textDireccion.setText("");
                textTelefono.setText("");
            }
        });

        //BOTÓN salir (Lógica).
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framePrincipal.setVisible(false);
            }
        });
    }

    /**
     * Main para testar ventana.
     */
    public static void main(String[] args) {
        new VentanaRegistros();
    }

}
