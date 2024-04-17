package UD8.Calculadora;

import javax.swing.*;

public class FramePrincipalCalculadora extends JFrame{

    public FramePrincipalCalculadora(){
        this.setSize(600,600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imagen = new ImageIcon("C:\\Users\\jroddom0103\\Downloads\\spain_330557.png");

        

        this.setIconImage(imagen.getImage());
        this.setVisible(true);

    }

}
