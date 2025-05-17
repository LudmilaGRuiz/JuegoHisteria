package presenter;

import model.Juego;
import view.PantallaInicio;
import java.awt.EventQueue;


public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Juego presenter = new Juego();
                    PantallaInicio inicio = new PantallaInicio(presenter);
                    inicio.getPantallaInicio().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
