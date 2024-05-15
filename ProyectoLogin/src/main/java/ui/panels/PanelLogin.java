package ui.panels;

import model.classes.User;
import services.UserService;
import ui.frames.FrameLogin;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelLogin extends JPanel {
    private JTextField user;
    private JTextField pass;
    private  JLabel labelError;
    private JButton bEnviar;
    private JButton bAlta;

    // Este es el FramePadre de este panel
    private FrameLogin framePadre;

    private UserService serviceUser = new UserService();

    private MouseListener listenerMouseCambiarAspecto = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(135, 206, 250)); // Fondo azul claro
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(208, 223, 232)); // Fondo azul medio
        }

        @Override
        public void mousePressed(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBorder(new LineBorder(new Color(50, 50, 50), 3));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBorder(new LineBorder(new Color(0,0,0), 2));
        }
    };

    private MouseListener listenerMouseEnviar = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            // Comprueba si el usuario ha introducido correctamente sus credenciales
            if (serviceUser.checkUserExists(new User(user.getText(),pass.getText(),user.getText(),true))){
                // Si se han introducido correctamente, se procede a cargar el panelOpciones
                cargarPanelMainMenu();
            } else {
                labelError.setVisible(true);

            }
        }
    };


    public PanelLogin(FrameLogin framePadre) {

        // Vinculamos this.framePadre con el framePadre que viene por parámetros -> Este framePadre es la instancia de la clase FrameLogin
        this.framePadre = framePadre;
        this.setBackground(new Color(0xDFDCDC));
        this.setLayout(null);

        JLabel usuario = new JLabel("Usuario: ");
        usuario.setLocation(new Point(200, 135));
        usuario.setSize(new Dimension(152, 32));
        // usuario.setFont(new Font("Consolas", Font.BOLD, 22));
        this.add(usuario);

        user = new JTextField("Introduzca su usuario");
        user.setLocation(new Point(260, 135));
        user.setSize(new Dimension(152, 32));
        this.add(user);

        JLabel passwd = new JLabel("Passwd: ");
        passwd.setLocation(new Point(200, 200));
        passwd.setSize(new Dimension(152, 32));
        this.add(passwd);

        pass = new JPasswordField();
        pass.setLocation(new Point(260, 200));
        pass.setSize(new Dimension(152, 32));
        this.add(pass);

        bEnviar = new JButton("Enviar");
        bEnviar.setLocation(new Point(120, 321));
        bEnviar.setSize(new Dimension(152, 32));
        bEnviar.setBackground(new Color(208, 223, 232)); // Fondo azul medio
        bEnviar.setBorder(new LineBorder(new Color(0,0,0), 2));
        bEnviar.addMouseListener(listenerMouseEnviar);
        bEnviar.addMouseListener(listenerMouseCambiarAspecto);
        this.add(bEnviar);

        labelError = new JLabel("Usuario o contraseña incorrectos");
        labelError.setFont(new Font("Consolas", Font.ITALIC, 10));
        labelError.setForeground(new Color(255,0,0));
        labelError.setBounds(230, 250, 200,32);
        labelError.setVisible(false);
        this.add(labelError);

    }

    public void cargarPanelMainMenu(){
    }
}
