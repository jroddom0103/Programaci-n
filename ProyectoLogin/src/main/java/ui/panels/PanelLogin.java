package ui.panels;

import model.db.ConectarDB;
import services.ServiceLogger;
import services.UserService;
import ui.frames.FrameLogin;
import utils.DBUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PanelLogin extends JPanel {
    private JTextField id;
    private JTextField pass;
    private JButton bEnviar;

    // Este es el FramePadre de este panel
    private FrameLogin framePadre;

    private UserService serviceUser = new UserService();
    private ServiceLogger serviceLogger = new ServiceLogger();

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
            b.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        }
    };

    private MouseListener listenerMouseEnviar = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            String idString = id.getText();
            String passString = pass.getText();

            if (serviceUser.checkLogin(idString,passString)==true){
                serviceLogger.registrarLog(idString,"LOGIN","Correcta");
                cargarPanelMainMenu();
            }else{
                serviceLogger.registrarLog(idString,"LOGIN","Incorrecta");
                JOptionPane.showMessageDialog(framePadre, "Correo o pass equivocado.");
            }
        }
    };


    public PanelLogin(FrameLogin framePadre) {

        // Vinculamos this.framePadre con el framePadre que viene por parámetros -> Este framePadre es la instancia de la clase FrameLogin
        this.framePadre = framePadre;
        this.setBackground(new Color(0xDFDCDC));
        this.setLayout(null);

        JLabel correoLabel = new JLabel("Id: ");
        correoLabel.setLocation(new Point(160, 200));
        correoLabel.setSize(new Dimension(152, 32));
        this.add(correoLabel);

        id = new JTextField("");
        id.setLocation(new Point(220, 200));
        id.setSize(new Dimension(152, 32));
        this.add(id);

        JLabel passwdLabel = new JLabel("Passwd: ");
        passwdLabel.setLocation(new Point(160, 250));
        passwdLabel.setSize(new Dimension(152, 32));
        this.add(passwdLabel);

        pass = new JPasswordField();
        pass.setLocation(new Point(220, 250));
        pass.setSize(new Dimension(152, 32));
        this.add(pass);

        bEnviar = new JButton("Enviar");
        bEnviar.setLocation(new Point(190, 350));
        bEnviar.setSize(new Dimension(152, 32));
        bEnviar.setBackground(new Color(208, 223, 232)); // Fondo azul medio
        bEnviar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        bEnviar.addMouseListener(listenerMouseEnviar);
        bEnviar.addMouseListener(listenerMouseCambiarAspecto);
        this.add(bEnviar);

    }

    public void cargarPanelMainMenu() {
        // ELIMINAMOS THIS PanelLogin
        framePadre.remove(this);

        // Añadimos el panel Opciones
        PanelOpciones panelOpciones = new PanelOpciones(framePadre);
        framePadre.add(panelOpciones);

        // ULTIMO: REPINTAR EL FRAME
        framePadre.repaint();
        framePadre.revalidate();
    }
}

