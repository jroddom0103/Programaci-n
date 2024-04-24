package UD8.proyectoLoginUI.ui;

import javax.swing.*;

public class FrameLogin extends JFrame{

    private int width = 600;
    private int height = 600;
    public FrameLogin(){
        this.setSize(width, height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Proyecto UI");
        ImageIcon image = new ImageIcon("C:\\Users\\jroddom0103\\Desktop\\1-DAW\\Programacion_Bien\\src\\resources\\imagenes\\spain_330557.png");
        this.setIconImage(image.getImage());
        this.setResizable(false);

        PanelLogin p = new PanelLogin();
        this.add(p);

        this.setVisible(true);
    }

}
