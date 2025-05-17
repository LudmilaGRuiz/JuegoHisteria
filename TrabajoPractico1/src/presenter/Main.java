package presenter;

import java.awt.EventQueue;

public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Controller controller = new Controller();
					controller.abrirPantallaInicio();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
