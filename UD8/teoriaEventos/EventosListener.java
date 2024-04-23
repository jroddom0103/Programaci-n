package UD8.teoriaEventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.InputMismatchException;

public class EventosListener extends JFrame {

    private int width = 600;
    private int height = 600;

    // Atributos de clase
    JButton botonEnviar;
    JTextField campoTexto;
    JLabel resultado;

    // Creamos los eventos
    MouseListener listenerDeBotonEnviar = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Boton pulsado");
            String texto = campoTexto.getText();

            // Debe salir un mensaje de si el numero es par o impar
            try {
                long num = Integer.parseInt(texto);
                if (num%2 == 0) {
                    System.out.println("Es par");
                    resultado.setText("Es Par");
                } else {
                    System.out.println("Es impar");
                    resultado.setText("Es Impar");
                }
                campoTexto.setBackground(new Color(0, 0, 0));

            } catch (NumberFormatException ex) {
                campoTexto.setBackground(new Color(255, 0, 0));
                resultado.setText("Error!");
            }

            System.out.println(texto);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //System.out.println("Entra el raton");
            botonEnviar.setBackground(new Color(252, 143, 136));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //System.out.println("Sale el raton");
            botonEnviar.setBackground(new Color(200,200,200));
        }
    };

    KeyListener listenerTeclado = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) { //
            if(e.getKeyChar() == KeyEvent.VK_ENTER) {
                System.out.println("Intro pulsado");
            }

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };


    // Constructor de clase
    public EventosListener() {

        this.setSize(width, height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Primera Ventana");
        ImageIcon image = new ImageIcon("src/main/resources/pokemonMedia/images/dratini.png");
        this.setIconImage(image.getImage());

        // JFrame tiene un layout por defecto de BorderLayout (CENTER, NORTH, SOUTH, WEST, EAST)
        JLabel titulo = new JLabel("EVENTOS");
        titulo.setPreferredSize(new Dimension(100,100));
        titulo.setFont(new Font("Consolas", Font.BOLD, 32));
        titulo.setHorizontalAlignment(JLabel.CENTER);

        JPanel panelCentro = new JPanel();

        campoTexto = new JTextField();
        campoTexto.setPreferredSize(new Dimension(100, 32));
        campoTexto.setBackground(new Color(0,0,0));
        campoTexto.setForeground(new Color(255,255,255));
        campoTexto.setFont(new Font("Consolas", Font.BOLD, 16));
        campoTexto.addKeyListener(listenerTeclado);

        botonEnviar = new JButton("Enviar");
        botonEnviar.setPreferredSize(new Dimension(100,32));
        // Anadimos el evento al botonEnviar
        botonEnviar.addMouseListener(listenerDeBotonEnviar);

        resultado = new JLabel();
        resultado.setFont(new Font("Consolas", Font.BOLD, 32));



        // Anadimos elementos al JPanel (panelCentro)
        panelCentro.add(campoTexto);
        panelCentro.add(botonEnviar);
        panelCentro.add(resultado);

        // Anadimos elementos al JFrame
        this.add(panelCentro, BorderLayout.CENTER);
        this.add(titulo, BorderLayout.NORTH);
        this.setVisible(true);
    }
}