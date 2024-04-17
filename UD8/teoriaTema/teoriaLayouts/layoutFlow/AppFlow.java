package UD8.teoriaTema.teoriaLayouts.layoutFlow;
import javax.swing.SwingUtilities;

public class AppFlow {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FrameFlow f = new FrameFlow();
            }
        });
    }
}

