package CapaPresentacion;

import CapaLogica.Bajas;
import CapaLogica.Registros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBajas {
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
    Bajas objBajas = new Bajas();

    public VentanaBajas() {
        framePrincipal = new JFrame("Bajas alumnos"); //Creamos un objeto JFrame (una ventana genérica vacía) con el título "Menú principal".
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
                        try{
                            //Obtenemos los datos introducidos por el ususario para luego darselos al método ejecutarBaja.
                            String dni = textDNI.getText();

                            //Ejecutamos la orden.
                            objBajas.ejecutarBaja(dni);

                            //Mensaje que confirma que el borrado ha sido realizado.
                            JOptionPane.showMessageDialog(eliminarButton,"Registro realizado con éxito");

                        }catch (Exception ex){
                            System.out.println(ex.getMessage());
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
                textNombre.setText("");
                textApellido.setText("");
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

    public static void main(String[] args) {
        new VentanaBajas();
    }
}
