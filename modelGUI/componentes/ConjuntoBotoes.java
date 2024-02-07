package modelGUI.componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import modelGUI.listeners.ActionHandler;

class ConjuntoBotoes extends JPanel {
    public ConjuntoBotoes() {
        setLayout(new GridLayout(1,3));
        setBackground(new Color(70,70,70));
        setPreferredSize(new Dimension(170,0));
        init();
    }

    public void init() {
        add(new modelGUI.componentes.Botao("Mi") {
            @Override
            public void listeners() {
                addActionListener(new ActionHandler() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Minimizar a tela
                    }
                });
            }
        });
        add(new modelGUI.componentes.Botao("Ma") {
            @Override
            public void listeners() {
                addActionListener(new ActionHandler() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Maximizar a tela
                    }
                });
            }
        });
        add(new modelGUI.componentes.Botao("Ex") {
            @Override
            public void listeners() {
                addActionListener(new ActionHandler() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        System.exit(0); // Fecha a aplicação
                    }
                });
            }
        });
    }
}
