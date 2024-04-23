package UD8.proyectoMiniCalculadora.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelCalculadoraI extends JPanel{

    JTextField textFieldvalor1;
    JTextField textFieldvalor2;
    JButton botonSuma;
    JButton botonResta;
    JButton botonMultiplicacion;
    JButton botonDivision;
    JLabel labelResultado;

    // EVENTOS
    MouseListener listenerMouse = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            JButton b = (JButton) e.getSource();

            // 1º Obtenemos los valores de los TextFields
            String valorTexto1 = textFieldvalor1.getText();
            String valorTexto2 = textFieldvalor2.getText();

            if (b.getText().equalsIgnoreCase("+")){
                // SE REALIZA LA SUMA


                // 2º Para sumar, los valores deben ser enteros (try/catch para evitar errores)
                try {
                    int valorEnteroTexto1 = Integer.parseInt(valorTexto1);
                    int valorEnteroTexto2 = Integer.parseInt(valorTexto2);

                    //3º Realizamos la suma de los valores
                    int resultadoSuma = valorEnteroTexto1 + valorEnteroTexto2;

                    //4º Por úlitmo, ponemos ese resultado en el JLabel (labelResultado)
                    labelResultado.setText(resultadoSuma+"");

                }catch (NumberFormatException ex){
                    //TODO poner mensaje de error
                    labelResultado.setText("ERROR");
                }
            }else if(b.getText().equalsIgnoreCase("-")){
                // 2º Para restar, los valores deben ser enteros (try/catch para evitar errores)
                try {
                    int valorEnteroTexto1 = Integer.parseInt(valorTexto1);
                    int valorEnteroTexto2 = Integer.parseInt(valorTexto2);

                    //3º Realizamos la resta de los valores
                    int resultadoResta = valorEnteroTexto1 - valorEnteroTexto2;

                    //4º Por úlitmo, ponemos ese resultado en el JLabel (labelResultado)
                    labelResultado.setText(resultadoResta+"");

                }catch (NumberFormatException ex){
                    //TODO poner mensaje de error
                    labelResultado.setText("ERROR");
                }
            }else if(b.getText().equalsIgnoreCase("x")){
                // 2º Para multiplicar, los valores deben ser enteros (try/catch para evitar errores)
                try {
                    int valorEnteroTexto1 = Integer.parseInt(valorTexto1);
                    int valorEnteroTexto2 = Integer.parseInt(valorTexto2);

                    //3º Realizamos la multiplicación de los valores
                    int resultadoMultiplicacion = valorEnteroTexto1 * valorEnteroTexto2;

                    //4º Por úlitmo, ponemos ese resultado en el JLabel (labelResultado)
                    labelResultado.setText(resultadoMultiplicacion+"");

                }catch (NumberFormatException ex){
                    //TODO poner mensaje de error
                    labelResultado.setText("ERROR");
                }
            }else if(b.getText().equalsIgnoreCase("/")){
                // 2º Para dividir, los valores deben ser enteros (try/catch para evitar errores)
                try {
                    int valorEnteroTexto1 = Integer.parseInt(valorTexto1);
                    int valorEnteroTexto2 = Integer.parseInt(valorTexto2);

                    if (valorEnteroTexto2 == 0){
                        labelResultado.setText("No se puede dividir entre 0");
                    }else{
                        //3º Realizamos la división de los valores
                        int resultadoDivision = valorEnteroTexto1 / valorEnteroTexto2;

                        //4º Por úlitmo, ponemos ese resultado en el JLabel (labelResultado)
                        labelResultado.setText(resultadoDivision+"");
                    }

                }catch (NumberFormatException ex){
                    //TODO poner mensaje de error
                    labelResultado.setText("ERROR");
                }
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(193, 224, 255));
            b.setBorder(new BevelBorder(1));
            b.setBorder(new LineBorder(new Color(0,0,0),3));
            b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(0xB8B8EC));
            b.setBorder(new LineBorder(new Color(0,0,0),1));
        }
    };

    public PanelCalculadoraI(){

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(200,200,200));

        //Inicializamos los elementos
        textFieldvalor1 = new JTextField("Introduzca valor 1.");
        textFieldvalor2 = new JTextField("Introduzca valor 2.");
        botonSuma = new JButton("+");
        botonResta = new JButton("-");
        botonMultiplicacion = new JButton("x");
        botonDivision = new JButton("/");
        labelResultado = new JLabel();

        JPanel panelNorte = new JPanel(new GridLayout(1,2));
        JPanel panelCentro = new JPanel(new GridLayout(1,4));

        //Modificamos los atributos/valores/aspecto de los elementos
        textFieldvalor1.setPreferredSize(new Dimension(300,200));
        textFieldvalor2.setPreferredSize(new Dimension(300,200));
        botonSuma.setPreferredSize(new Dimension(150,200));
        botonResta.setPreferredSize(new Dimension(150,200));
        botonMultiplicacion.setPreferredSize(new Dimension(150,200));
        botonDivision.setPreferredSize(new Dimension(150,200));
        labelResultado.setPreferredSize(new Dimension(200,200));

        //Otras modificaciones de aspecto
        labelResultado.setFont(new Font("Consolas",Font.BOLD,32));
        labelResultado.setHorizontalAlignment(JLabel.CENTER);

        //Añadimos los eventos
        botonSuma.addMouseListener(listenerMouse);
        botonResta.addMouseListener(listenerMouse);
        botonMultiplicacion.addMouseListener(listenerMouse);
        botonDivision.addMouseListener(listenerMouse);

        //Añadimos al JPanel
        panelNorte.add(textFieldvalor1);
        panelNorte.add(textFieldvalor2);
        panelCentro.add(botonSuma);
        panelCentro.add(botonResta);
        panelCentro.add(botonMultiplicacion);
        panelCentro.add(botonDivision);
        this.add(panelNorte, BorderLayout.NORTH);
        this.add(panelCentro, BorderLayout.CENTER);
        this.add(labelResultado, BorderLayout.SOUTH);

    }

}
