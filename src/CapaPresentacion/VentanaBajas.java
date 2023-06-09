package CapaPresentacion;

import CapaLogica.Bajas;
import CapaLogica.Registros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBajas {
    /**
     * Componentes de la ventana.
     * @author Adrian Videira
     */
    private JPanel panelSuperior;
    private JPanel panelInferior;
    private JLabel DNI;
    private JTextField textDNI;
    private JTextField textNombre;
    private JTextField textApellido;
    private JButton eliminarButton;
    private JButton candelarButton;
    private JButton salirButton;
    private JPanel panelGeneral;
    private JFrame framePrincipal;
    Bajas objBajas = new Bajas(); // Creamos objeto de la clase Bajas para acceder a sus métodos.

    /**
     * Constructores
     * @author Adrian Videira
     */
    public VentanaBajas() {
        framePrincipal = new JFrame("Bajas alumnos"); //Creamos un objeto JFrame (una ventana genérica vacía) con el título "Baja Alumnos".
        framePrincipal.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); //Se establece la operación de cierre cuando se cierre la ventana.
        framePrincipal.setPreferredSize(new Dimension(300,300)); //Definimos el tamaño de la vetana
        framePrincipal.setResizable(false); //Definimos que sea fijo su tamaño.
        framePrincipal.add(panelGeneral); //Añadimos el panelPrincipal al frame.
        framePrincipal.pack(); //Se empaqueta la ventana para asegurar que todos los componentes tengan el tamaño adecuado.
        framePrincipal.setLocationRelativeTo(null); // Se establece ubicación de la ventana en el centro de la pantalla.
        framePrincipal.setVisible(true); // Hacemos visible la ventana en la pantalla.

        //BOTÓN ELIMINAR (Lógica).
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1º- Verificamos que los campos están cubiertos.
                if(textDNI.getText().isEmpty()){
                    JOptionPane.showMessageDialog(textDNI, "Por favor, ingrese DNI");
                }else{
                    String patronDNI = ("\\d{8}"); //Creamos un patrón con el formato que queremos que tenga el DNI
                    if(!textDNI.getText().matches(patronDNI)) { //En caso de que no se cumpla, enviamos un mensaje al usuario.
                        JOptionPane.showMessageDialog(textDNI, "El DNI debe tener 8 digitos");
                    }
                    else{
                        /**
                         * @author Adrian Videira.
                         * @date 2023/06/04.
                         * @revision 0.1
                         * Se incorpora el uso del método para verifica que el DNI introducido existe.
                         */
                        try{
                            //Obtenemos los datos introducidos por el ususario para luego darselos al método ejecutarBaja.
                            String dni = textDNI.getText();
                            //Verificamos que ese DNI existe en la base de datos.
                            if(!objBajas.validarDNI(dni).matches(textDNI.getText())){
                                JOptionPane.showMessageDialog(eliminarButton,"No existe ese DNI en la base de datos");
                            }else{
                                //Ejecutamos la orden.
                                objBajas.ejecutarBaja(dni);
                                //Mensaje que confirma que el borrado ha sido realizado.
                                JOptionPane.showMessageDialog(eliminarButton,"Baja realizada con éxito");
                            }

                        }catch (Exception ex){
                            System.out.println(ex.getMessage());
                            JOptionPane.showMessageDialog(eliminarButton, "Ha ocurrido un error");
                        }
                    }
                }


            }
        });
        //BOTÓN CANCELAR (Lógica).
        candelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textDNI.setText("");
            }
        });
        //BOTÓN SALIR (Lógica).
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
        new VentanaBajas();
    }
}
