package ui.panels;

import model.classes.User;
import services.ServiceLogger;
import services.UserService;
import ui.frames.FrameLogin;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class PanelAlta extends JPanel implements ItemListener {

    JTextField textFieldId;
    JTextField textFieldCorreo;
    JTextField textFieldPass;
    JTextField textFieldPass2;
    boolean esAdmin;
    private JComboBox<String> comboAdmin;
    JButton b;
    JButton bAtras;
    private ServiceLogger serviceLogger = new ServiceLogger();

    // Este es el FramePadre de este panel
    private FrameLogin framePadre;
    UserService serviceUser = new UserService();
    JTextField mensaje = new JTextField("Las contrasenas no coinciden.");

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==comboAdmin) {
            String seleccionado=(String)comboAdmin.getSelectedItem();
            if (seleccionado.equals("Si")){
                this.esAdmin = true;
            }else{
                this.esAdmin = false;
            }
        }
    }

    MouseListener listenerAlta = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (serviceUser.agregarUser(textFieldId.getText(),textFieldCorreo.getText(),textFieldPass.getText(), textFieldPass2.getText(),comboAdmin.getSelectedItem().toString())){
                JOptionPane.showMessageDialog(framePadre, "Usuario introducido.");
                serviceLogger.registrarLog(textFieldId.getText(),"ALTA","Correcta");
            }else if (textFieldId.getText().length()>20 || textFieldCorreo.getText().length()>20 || textFieldPass.getText().length()>20){
                JOptionPane.showMessageDialog(framePadre, "No se puden poner mas de 20 caracteres en los campos.");
                serviceLogger.registrarLog(textFieldId.getText(),"ALTA","Incorrecta");
            }else if (!textFieldCorreo.getText().matches("[a-zA-Z0-9._%+-]+@gmail\\.(es|com)")){
                JOptionPane.showMessageDialog(framePadre, "El formato del correo no es correcto");
                serviceLogger.registrarLog(textFieldId.getText(),"ALTA","Incorrecta");
            }else if (textFieldCorreo.equals("") || textFieldPass.equals("")){
                JOptionPane.showMessageDialog(framePadre, "Todos los campos deben estar rellenados.");
                serviceLogger.registrarLog(textFieldId.getText(),"ALTA","Incorrecta");
            }else if (!textFieldPass.equals(textFieldPass2)){
                JOptionPane.showMessageDialog(framePadre, "Las contrasenas no coinciden.");
                serviceLogger.registrarLog(textFieldId.getText(),"ALTA","Incorrecta");
            }else {
                JOptionPane.showMessageDialog(framePadre, "Ya hay un usuario con esa id.");
                serviceLogger.registrarLog(textFieldId.getText(),"ALTA","Incorrecta");
            }
        }
    };
    MouseListener listenerMouse = new MouseAdapter() {

        @Override
        public void mouseEntered(MouseEvent e) {
            bAtras = (JButton) e.getSource();
            bAtras.setBackground(new Color(135, 206, 250)); // Fondo azul claro
            bAtras.setBorder(new LineBorder(new Color(0, 115, 183), 3)); // Borde azul oscuro

            b = (JButton) e.getSource();
            b.setBackground(new Color(135, 206, 250)); // Fondo azul claro
            b.setBorder(new LineBorder(new Color(0, 115, 183), 3)); // Borde azul oscuro
        }

        @Override
        public void mouseExited(MouseEvent e) {
            bAtras = (JButton) e.getSource();
            bAtras.setBackground(new Color(102, 153, 204)); // Fondo azul medio
            bAtras.setBorder(new LineBorder(new Color(135, 206, 250), 3)); // Borde azul claro

            b = (JButton) e.getSource();
            b.setBackground(new Color(102, 153, 204)); // Fondo azul medio
            b.setBorder(new LineBorder(new Color(135, 206, 250), 3)); // Borde azul claro
        }
    };

    private MouseListener listenerMouseOpciones = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            cargarPanelOpciones();
        }
    };

    public PanelAlta(FrameLogin framePadre){

        this.framePadre = framePadre;
        this.setBackground(new Color(174, 139, 225));
        this.setLayout(null);

        JLabel idusuario = new JLabel("ID: ");
        idusuario.setLocation(new Point(230,130));
        idusuario.setSize(new Dimension(152,32));
        this.add(idusuario);

        textFieldId = new JTextField("");
        textFieldId.setLocation(new Point(260,130));
        textFieldId.setSize(new Dimension(152,32));
        this.add(textFieldId);

        JLabel nombre = new JLabel("Correo: ");
        nombre.setLocation(new Point(200,170));
        nombre.setSize(new Dimension(152,32));
        this.add(nombre);

        textFieldCorreo = new JTextField("");
        textFieldCorreo.setLocation(new Point(260,170));
        textFieldCorreo.setSize(new Dimension(152,32));
        this.add(textFieldCorreo);

        JLabel contrasena = new JLabel("Contrasena: ");
        contrasena.setLocation(new Point(180,210));
        contrasena.setSize(new Dimension(152,32));
        this.add(contrasena);

        textFieldPass = new JTextField("");
        textFieldPass.setLocation(new Point(260,210));
        textFieldPass.setSize(new Dimension(152,32));
        this.add(textFieldPass);

        JLabel contrasena2 = new JLabel("Confirmar contrasena:");
        contrasena2.setLocation(new Point(120,250));
        contrasena2.setSize(new Dimension(152,32));
        this.add(contrasena2);

        textFieldPass2 = new JTextField("");
        textFieldPass2.setLocation(new Point(260,250));
        textFieldPass2.setSize(new Dimension(152,32));
        this.add(textFieldPass2);

        JLabel esAdmin = new JLabel("Ser administrador");
        esAdmin.setLocation(new Point(150,300));
        esAdmin.setSize(new Dimension(152,32));
        this.add(esAdmin);

        setLayout(null);
        comboAdmin = new JComboBox<String>();
        comboAdmin.setBounds(270,300,100,32);
        add(comboAdmin);
        comboAdmin.addItem("Si");
        comboAdmin.addItem("No");

        b = new JButton("Enviar");
        b.setLocation(new Point(220,400));
        b.setSize(new Dimension(152,32));
        b.addMouseListener(listenerMouse);
        b.addMouseListener(listenerAlta);
        this.add(b);

        bAtras = new JButton("Atras");
        bAtras.setBounds(40, 500, 100, 50);
        bAtras.setBackground(new Color(208, 223, 232));
        bAtras.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        bAtras.addMouseListener(listenerMouse);
        bAtras.addMouseListener(listenerMouseOpciones);
        this.add(bAtras);
    }

    private void cargarPanelOpciones() {
        // ELIMINAMOS THIS PanelLogin
        framePadre.remove(this);

        // AÑADIMOS UN PANEL ALTA AL ¡¡¡FRAME!!!
        PanelOpciones panelOpciones = new PanelOpciones(framePadre);
        framePadre.add(panelOpciones);

        // ULTIMO: REPINTAR EL FRAME
        framePadre.repaint();
        framePadre.revalidate();
    }

}

