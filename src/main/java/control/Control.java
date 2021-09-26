package control;

import model.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Control {
    public static Ranking r;
    public static List<Jugador> jugadores;
    public static List<String> nombresJugadores;

    public Control(){
        r = new Ranking();
        jugadores = r.rankingJsonToArrayList();
        nombresJugadores = new ArrayList<>();
        asignarNombreJugadores();
    }

    private void asignarNombreJugadores(){
        for (Jugador j: jugadores) {
            nombresJugadores.add(j.getName());
        }
    }


}