package UD8.Calculadora;

import UD8.teoriaTema.teoriaLayouts.layoutFlow.FrameFlow;

import javax.swing.*;

public class AppCalculadora {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FramePrincipalCalculadora f = new FramePrincipalCalculadora();
            }
        });
    }
}
