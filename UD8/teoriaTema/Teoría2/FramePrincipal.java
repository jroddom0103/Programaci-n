package UD8.teoriaTema.Teoría2;

import javax.swing.*;
import java.awt.*;

public class FramePrincipal extends JFrame {

    public FramePrincipal(){

        this.setSize(700,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Programa1");
        this.setResizable(false);
        ImageIcon imagen = new ImageIcon("C:\\Users\\jroddom0103\\Downloads\\images14241.png");
        this.setIconImage(imagen.getImage());

        Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
        this.setCursor(cursor);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(new Color(138, 200, 222, 255));

        JLabel jlabel = new JLabel("Usuario");
        JTextField texto1 = new JTextField("");
        texto1.setPreferredSize(new Dimension(100,20));

        JLabel jlabel2 = new JLabel("Contraseña");
        JPasswordField texto2 = new JPasswordField("");
        texto2.setPreferredSize(new Dimension(100,20));
        texto2.setEchoChar('@');

        JButton botonEnviar = new JButton();
        //botonEnviar.setText("Enviar");
        botonEnviar.setBackground(new Color(255,35,120));

        Icon imagen2 = new ImageIcon("C:\\Users\\jroddom0103\\Downloads\\spain_330557 (1).png");
        botonEnviar.setIcon(imagen2);
        botonEnviar.setBackground(null);
        botonEnviar.setBorder(null);
        botonEnviar.setHorizontalAlignment(JButton.CENTER);
        botonEnviar.setVerticalAlignment(JButton.CENTER);

        JToggleButton botonActivar = new JToggleButton("Activar");
        botonActivar.setPreferredSize(new Dimension(70,70));
        botonActivar.setFont(new Font("Arial",Font.PLAIN,10));
        botonActivar.setSelected(true);
        //botonActivar.setBounds(100,100,70,70);

        JCheckBox opciones1 = new JCheckBox("Prueba");
        JCheckBox opciones2 = new JCheckBox("Prueba2");
        JCheckBox opciones3 = new JCheckBox("Prueba3");

        JSeparator separator = new JSeparator();
        separator.setPreferredSize(new Dimension(100,100));

        JRadioButton boton1 = new JRadioButton("Botón1");
        JRadioButton boton2 = new JRadioButton("Botón2");
        JRadioButton boton3 = new JRadioButton("Botón3");

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(boton1);
        btnGroup.add(boton2);
        btnGroup.add(boton3);

        panelPrincipal.add(jlabel);
        panelPrincipal.add(texto1);
        panelPrincipal.add(jlabel2);
        panelPrincipal.add(texto2);
        panelPrincipal.add(botonEnviar);
        panelPrincipal.add(botonActivar);

        panelPrincipal.add(opciones1);
        panelPrincipal.add(opciones2);
        panelPrincipal.add(opciones3);
        panelPrincipal.add(separator);
        panelPrincipal.add(boton1);
        panelPrincipal.add(boton2);
        panelPrincipal.add(boton3);



        this.add(panelPrincipal);
        this.setVisible(true);


    }
}
