package Gestion;

import Interfaz.Game;
import control.Ranking;
import model.Crear_Jugador;

public class Gestion_Hilos {

    private int contadorp = 1;
    private int contadorp2 = 2;
    private int contadorp3 = 3;
    private int contadorp4 = 4;
    private int contadorp5 = 5;
    private double segundos;
    private int numone, numtwo;
    private Game game = new Game();

    public void Player() {

        Thread player_one = new Thread(new Crear_Jugador(Game.img_dado_1, Game.img_dado_2, Game.lbl_suma_res_p1,
                Game.lbl_suma_res_pa_p1, segundos, numone, numtwo, contadorp, Game.lbl_Car_1, game));

        Thread player_two = new Thread(new Crear_Jugador(Game.img_dado_1_p2, Game.img_dado_2_p2, Game.lbl_suma_res_p2,
                Game.lbl_suma_res_pa_p2, segundos, numone, numtwo, contadorp2, Game.lbl_Car_2, game));

        Thread player_three = new Thread(new Crear_Jugador(Game.img_dado_1_p3, Game.img_dado_2_p3, Game.lbl_suma_res_p3,
                Game.lbl_suma_res_pa_p3, segundos, numone, numtwo, contadorp3, Game.lbl_Car_3, game));

        Thread player_four = new Thread(new Crear_Jugador(Game.img_dado_1_p4, Game.img_dado_2_p4, Game.lbl_suma_res_p4,
                Game.lbl_suma_res_pa_p4, segundos, numone, numtwo, contadorp4, Game.lbl_Car_4, game));

        Thread player_Five = new Thread(new Crear_Jugador(Game.img_dado_1_p5, Game.img_dado_2_p5, Game.lbl_suma_res_p5,
                Game.lbl_suma_res_pa_p5, segundos, numone, numtwo, contadorp5, Game.lbl_Car_5, game));

        player_one.start();
        player_two.start();
        player_three.start();
        player_four.start();
        player_Five.start();

    }
}