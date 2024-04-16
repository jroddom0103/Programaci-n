package UD8.teoriaTema.Teoría1;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Main {

    public static void main(String[] args) {

        JFrame marcoPpal = new JFrame();
        marcoPpal.setVisible(true);
        marcoPpal.setSize(700,500);
        marcoPpal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoPpal.setTitle("Programa1");
        marcoPpal.setResizable(false);

        ImageIcon imagen = new ImageIcon("C:\\Users\\jroddom0103\\Downloads\\images14241.png");
        marcoPpal.setIconImage(imagen.getImage());

    }

}
