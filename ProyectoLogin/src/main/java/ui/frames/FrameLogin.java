package ui.frames;

import ui.panels.PanelLogin;

import javax.swing.*;

public class FrameLogin extends JFrame {

    public FrameLogin() {
        this.setSize(600, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Proyecto Login");
        ImageIcon image = new ImageIcon("ProyectoLogin\\src\\main\\resources\\images\\icono.png");
        this.setIconImage(image.getImage());
        this.setResizable(false);

        PanelLogin p = new PanelLogin(this);
        this.add(p);
        this.setVisible(true);
    }
}