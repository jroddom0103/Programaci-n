package UD8.proyectoMiniCalculadora;

import UD8.proyectoMiniCalculadora.ui.FrameCalculadoraI;

import javax.swing.*;

public class MiniCalculadoraI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                FrameCalculadoraI fc = new FrameCalculadoraI();
            }
        });
    }
}
