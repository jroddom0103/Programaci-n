package ui.panels;


import model.classes.User;
import services.UserService;

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
    MouseListener listenerMouse = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            if (textFieldPass.getText().equals(textFieldPass2.getText())){

                User usuarioRegistrado = new User(textFieldId.getText(),textFieldCorreo.getText(),textFieldPass.getText(),esAdmin);
                if (serviceUser.altaUsuario(usuarioRegistrado)){
                    System.out.println("Te has registrado correctamente.");
                    mensaje.setVisible(true);
                }
            }else{
                System.out.println("Las contraseñas no coinciden.");
                mensaje.setBounds(200,350,50,50);
                mensaje.setFont(new Font("Arial",Font.ITALIC,10));
                mensaje.setVisible(true);
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(135, 206, 250)); // Fondo azul claro
            b.setBorder(new LineBorder(new Color(0, 115, 183), 3)); // Borde azul oscuro
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(102, 153, 204)); // Fondo azul medio
            b.setBorder(new LineBorder(new Color(135, 206, 250), 3)); // Borde azul claro
        }
    };

    public PanelAlta(){
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
        this.add(b);
        b.addMouseListener(listenerMouse);

    }

}

