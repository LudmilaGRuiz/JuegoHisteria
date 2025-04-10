package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaGanaste {

    private JFrame pantallaGanaste;
    private String tiempoDeJuego;
    private String nombreUsuario;

    public PantallaGanaste(String nombreUsuario,String tiempo) {
    	this.nombreUsuario = nombreUsuario;
    	this.tiempoDeJuego = tiempo;
        initialize();
    }

    private void initialize() {
        pantallaGanaste = new JFrame();
        pantallaGanaste.setResizable(false);
        pantallaGanaste.setSize(1200, 800);
        pantallaGanaste.setLocationRelativeTo(null);
        pantallaGanaste.getContentPane().setLayout(null);
        pantallaGanaste.getContentPane().setBackground(SystemColor.textHighlight);
        pantallaGanaste.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblMensaje = new JLabel("Felicitaciones, "+ nombreUsuario +" !Ganaste!");
        lblMensaje.setBounds(201, 155, 800, 123);
        lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
        lblMensaje.setForeground(Color.WHITE);
        lblMensaje.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.BOLD, 50));
        pantallaGanaste.getContentPane().add(lblMensaje);
        
        JLabel lblTiempoDeJuego = new JLabel("Tiempo: " + tiempoDeJuego);
        lblTiempoDeJuego.setBounds(188, 303, 800, 72);
        lblTiempoDeJuego.setHorizontalAlignment(SwingConstants.CENTER);
        lblTiempoDeJuego.setForeground(Color.WHITE);
        lblTiempoDeJuego.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.BOLD, 50));
        pantallaGanaste.getContentPane().add(lblTiempoDeJuego);

        // Botón centrado dinámicamente
        JButton btnCerrar = new JButton("Salir");
        btnCerrar.setBounds(501, 437, 200, 50);
        btnCerrar.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pantallaGanaste.dispose();
            }
        });
        pantallaGanaste.getContentPane().add(btnCerrar);

        pantallaGanaste.setVisible(true);
    }
}