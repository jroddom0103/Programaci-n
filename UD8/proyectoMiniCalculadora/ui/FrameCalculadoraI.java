package UD8.proyectoMiniCalculadora.ui;

import javax.swing.*;

public class FrameCalculadoraI extends JFrame{

    private static int width = 600;
    private static int height = 600;

    private PanelCalculadoraI panelCalculadoraI;

    public FrameCalculadoraI(){
        this.setSize(width, height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Calculadora");
        ImageIcon image = new ImageIcon("C:\\Users\\jroddom0103\\Downloads\\spain_330557.png");
        this.setIconImage(image.getImage());

        //Aquí añadimos el panel
        panelCalculadoraI = new PanelCalculadoraI();
        this.add(panelCalculadoraI);


        this.setVisible(true);
    }
}
