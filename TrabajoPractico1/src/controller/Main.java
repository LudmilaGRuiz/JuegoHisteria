package controller;

import model.Presentador;
import view.PantallaInicio;
import java.awt.EventQueue;


public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Presentador presenter = new Presentador();
                    PantallaInicio inicio = new PantallaInicio(presenter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
