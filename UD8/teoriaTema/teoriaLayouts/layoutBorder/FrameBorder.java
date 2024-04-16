package UD8.teoriaTema.teoriaLayouts.layoutBorder;

import javax.swing.*;
import java.awt.*;

public class FrameBorder extends JFrame {
    //Los JFrame se inicializan por defecto con un BorderLayout

    public FrameBorder(){
        this.setSize(700,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Programa1");
        this.setResizable(false);
        ImageIcon imagen = new ImageIcon("C:\\Users\\jroddom0103\\Downloads\\images14241.png");
        this.setIconImage(imagen.getImage());

        // Vamos a crear 4 JPanel y a añadirlos en posiciones del BorderLayout

        BorderLayout layout = new BorderLayout();
        layout.setHgap(5);
        layout.setVgap(5);

        JPanel panelCentro = new JPanel();
        panelCentro.setBackground(new Color(255,100,100));
        panelCentro.setPreferredSize(new Dimension(50,50));
        panelCentro.setLayout(layout);

        JPanel panelCentroCentro = new JPanel();
        panelCentroCentro.setBackground(new Color(200,100,40));
        JPanel panelCentroNorte = new JPanel();
        panelCentroNorte.setBackground(new Color(40, 200, 171));
        JPanel panelCentroSur = new JPanel();
        panelCentroSur.setBackground(new Color(40, 85, 200));
        JPanel panelCentroEste = new JPanel();
        panelCentroEste.setBackground(new Color(120, 180, 64));
        JPanel panelCentroOeste = new JPanel();
        panelCentroOeste.setBackground(new Color(190, 159, 35));

        panelCentro.add(panelCentroCentro,BorderLayout.CENTER);
        panelCentro.add(panelCentroNorte,BorderLayout.NORTH);
        panelCentro.add(panelCentroSur,BorderLayout.SOUTH);
        panelCentro.add(panelCentroOeste,BorderLayout.WEST);
        panelCentro.add(panelCentroEste,BorderLayout.EAST);

        JPanel panelNorte = new JPanel();
        panelNorte.setBackground(new Color(100,0,255));
        panelNorte.setPreferredSize(new Dimension(100,120));

        JPanel panelSur = new JPanel();
        panelSur.setBackground(new Color(255,255,0));
        panelSur.setPreferredSize(new Dimension(100,120));

        JPanel panelOeste = new JPanel();
        panelOeste.setBackground(new Color(255, 0, 183));
        panelOeste.setPreferredSize(new Dimension(100,20));

        JPanel panelEste = new JPanel();
        panelEste.setBackground(new Color(131, 250, 3));
        panelEste.setPreferredSize(new Dimension(100,20));

        this.add(panelCentro, BorderLayout.CENTER);
        this.add(panelNorte,BorderLayout.NORTH);
        this.add(panelSur,BorderLayout.SOUTH);
        this.add(panelOeste,BorderLayout.WEST);
        this.add(panelEste,BorderLayout.EAST);

        this.setVisible(true);
    }


}
