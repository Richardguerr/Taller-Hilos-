package model;

import javax.swing.JLabel;

import Interfaz.Game;



public class Crear_Jugador implements Runnable {

    private JLabel etiqueta;
    private Game game;
    private JLabel img_d1_p,img_d2_p;
    private JLabel lbl_res_p, lbl_res_pa_p;
    private int numuno , numdos;
    private double segundos;
    private int contador;



    public Crear_Jugador(JLabel img_dado_uno,JLabel img_dado_dos,JLabel resultado_p , JLabel resultado_pa_p,double segundos,int numuno,int numdos,
                         int contador, JLabel etiqueta , Game game ) {

        this.img_d1_p=img_dado_uno;
        this.img_d2_p=img_dado_dos;
        this.lbl_res_p=resultado_p;
        this.lbl_res_pa_p=resultado_pa_p;
        this.numuno=numuno;
        this.numdos=numdos;
        this.segundos=segundos;
        this.contador=contador;
        this.etiqueta=etiqueta;
        this.game=game;



    }

    @Override
    public void run() {

        run_Hilo();
    }



    private void run_Hilo() {

        int auto1=0;
        int auto2=0;
        int auto3=0;
        int auto4=0;
        int auto5=0;
        int meta=0;


        while (true){

            Dados.dadosRandom(img_d1_p, img_d2_p, lbl_res_p, lbl_res_pa_p,segundos,numuno,numdos,contador);
            Game.btn_New_Game.setEnabled(false);
            Game.btn_NextGame.setEnabled(false);
            Game.btn_Home.setEnabled(false);
            auto1=game.getFirstCar().getLocation().x;
            auto2=game.getSecondCar().getLocation().x;
            auto3=game.getThirdCar().getLocation().x;
            auto4=game.getFourthCar().getLocation().x;
            auto5=game.getFifthCar().getLocation().x;
            meta=game.getMeta().getLocation().x-160;

            if(auto1 < meta && auto2 < meta && auto3 < meta && auto4 < meta && auto5 < meta) {
                etiqueta.setLocation(etiqueta.getLocation().x+(Dados.contador_pn*10), etiqueta.getLocation().y);
                game.repaint();

            }else {

                Game.btn_New_Game.setEnabled(true);
                Game.btn_NextGame.setEnabled(true);
                Game.btn_Home.setEnabled(true);
                break;
            }
        }

        if (etiqueta.getLocation().x>=meta) {

            Dados.Posiciones();
            Dados.winner();

        }

    }

}