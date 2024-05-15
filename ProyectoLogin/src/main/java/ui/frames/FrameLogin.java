package ui.frames;

import ui.panels.PanelLogin;

import javax.swing.*;

public class FrameLogin extends JFrame {

    public FrameLogin() {
        this.setSize(600, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Proyecto Login");
        ImageIcon image = new ImageIcon("C:\\Users\\jroddom0103\\Desktop\\ProyectoLogin\\src\\main\\resources\\images\\icono.png");
        this.setIconImage(image.getImage());
        this.setResizable(false);

        PanelLogin p = new PanelLogin(this);
        this.add(p);

        this.setVisible(true);
    }

    private void add(PanelLogin p) {


    }


}