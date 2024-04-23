package UD8.teoriaEventos;

import javax.swing.*;

public class AppEventos {

    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                EventosListener e = new EventosListener();
            }
        });

    }
}