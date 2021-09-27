package Gestion;

import Interfaz.RankingInterfaz;
import Interfaz.Start;

import javax.swing.*;

public class Gestion_Ranking implements Runnable{

    private JPanel lbl;
    private JFrame exit_ranking;
    private JButton back;
    private RankingInterfaz r = new RankingInterfaz();

    public Gestion_Ranking(JPanel lbl, JButton back,JFrame exit_rankingranking) {
        this.lbl=lbl;
        this.exit_ranking = exit_rankingranking;
        this.back=back;

    }

    @Override
    public void run() {
        try {

            lbl.setVisible(true);
            back.setVisible(false);
            Thread.sleep(0);
            lbl.setVisible(false);
            exit_ranking.dispose();
            r.setVisible(true);



        } catch (InterruptedException e) {

        }

    }
}
