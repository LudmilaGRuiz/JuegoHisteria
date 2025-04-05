package view;

import javax.swing.JButton;

public class BotonConID extends JButton {
    private int id;

    public BotonConID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }
}
