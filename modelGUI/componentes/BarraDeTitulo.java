package modelGUI.componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import modelGUI.listeners.ActionHandler;

public class BarraDeTitulo extends JPanel {
    public BarraDeTitulo() {
        setBackground(new Color(20,20,20));
        setPreferredSize(new Dimension(0,50));
        setLayout(new BorderLayout());
        init();
    }
    
    private void init() {
        add(new ConjuntoBotoes(),BorderLayout.EAST);
    }
}
