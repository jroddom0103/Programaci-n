package UD8.proyectoLoginUI.ui;

import UD8.proyectoLoginUI.services.ServiceUser;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelLogin extends JPanel{


    JTextField user = new JTextField();
    JTextField pass = new JTextField();
    ServiceUser serviceUser = new ServiceUser();
    JLabel registrado = new JLabel();
    JTextField textoUsuario = new JTextField("");
    MouseListener listener = new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {

            if (serviceUser.loginUI(user.getText(),pass.getText())){
                System.out.println("Está registrado.");
                registrado.setText("Está registrado.");
            }else{
                System.out.println("Pa tu casa.");
                registrado.setText("Pa tu casa.");
            }

            if (textoUsuario.equals("")){
                textoUsuario.setBackground(new Color(255, 108, 108));
            }

        }
        @Override
        public void mouseEntered(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(193, 224, 255));
            b.setBorder(new BevelBorder(1));
            b.setBorder(new LineBorder(new Color(0,0,0),2));
            b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(0xB8B8EC));
            b.setBorder(new LineBorder(new Color(0,0,0),1));
        }
    };

    public PanelLogin(){


        this.setBackground(new Color(210, 103, 255));
        this.setLayout(null);

        JLabel usuario = new JLabel("Usuario:");
        usuario.setBounds(180,200,150,32);

        textoUsuario.setBounds(240,200,150,32);

        JLabel contrasena = new JLabel("Contraseña:");
        contrasena.setBounds(160,250,150,32);

        JTextField textocontrasena = new JTextField("");
        textocontrasena.setBounds(240,250,150,32);

        JButton bEnviar = new JButton("Enviar");
        bEnviar.setBounds(230,375,150,32);

        bEnviar.addMouseListener(listener);

        registrado.setBounds(270,450,150,32);

        this.add(usuario);
        this.add(textoUsuario);
        this.add(contrasena);
        this.add(textocontrasena);
        this.add(bEnviar);
        this.add(registrado);

    }
}
