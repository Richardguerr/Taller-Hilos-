package Gestion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Interfaz.Game;



public class Gestion_Start implements Runnable{



    private Game game = new Game();

    private JLabel lbl;
    private JFrame start;
    private JButton button;



    public Gestion_Start(JLabel lbl, JButton button,JFrame start) {
        this.lbl=lbl;
        this.start=start;
        this.button=button;

    }

    @Override
    public void run() {

        try {

            lbl.setVisible(true);
            button.setVisible(false);
            Thread.sleep(6000);
            lbl.setVisible(false);
            start.dispose();
            game.setVisible(true);



        } catch (InterruptedException e) {

        }

    }






}