package model;

import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cronometro {
	private int segundos = 0;
	private Timer timer;

	public Cronometro(JLabel etiquetaTiempo) {
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				segundos++;
				int horas = segundos / 3600;
				int minutos = (segundos % 3600) / 60;
				int seg = segundos % 60;
				etiquetaTiempo.setText(String.format("%02d:%02d:%02d", horas, minutos, seg));
			}
		});
	}

	public void iniciar() {
		timer.start();
	}

	public void detener() {
		timer.stop();
	}
}
