package UD8.teoriaTema.teoriaLayouts.layoutFlow;

import javax.swing.*;

import java.awt.*;

public class FrameFlow extends JFrame{


    public FrameFlow(){
        this.setSize(800,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("UbriWeb");

        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new BorderLayout());

        panelTitulo.setPreferredSize(new Dimension(800,100));
        panelTitulo.setBackground(new Color(255,0,0));

        JLabel labelTitulo = new JLabel("UBRIWEB");
        labelTitulo.setFont(new Font("consolas",Font.BOLD,32));

        labelTitulo.setHorizontalAlignment(JLabel.CENTER);

        JPanel panelCuerpo = new JPanel();
        panelCuerpo.setBackground(new Color(241,241,241));
        this.add(panelCuerpo);

        panelCuerpo.setLayout(new GridLayout(2,4));
        JLabel usuario = new JLabel("Usuario:");
        JTextField usuario1 = new JTextField();
        JLabel contrasena = new JLabel("Contraseña:");
        JTextField contrasena1 = new JTextField();
        JButton enviar = new JButton("Enviar");

        panelCuerpo.add(usuario);
        panelCuerpo.add(usuario1);
        panelCuerpo.add(new JLabel());
        panelCuerpo.add(new JLabel());
        panelCuerpo.add(contrasena);
        panelCuerpo.add(contrasena1);
        panelCuerpo.add(new JLabel());
        panelCuerpo.add(enviar);

        this.setCursor(Cursor.HAND_CURSOR);

        panelTitulo.add(labelTitulo);
        this.add(panelTitulo, BorderLayout.NORTH);
        this.setVisible(true);

    }

}
