package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Jugador {
    private String name;
    private int nPartidas;
    private int nLanzamientos;
    private int totalScore;
    private int posGeneral;
    private DateFormat hora;

    public Jugador(String name){
        this.name = name;
        nPartidas = 0;
        nLanzamientos = 0;
        totalScore = 0;
        posGeneral = 0;
        hora = new SimpleDateFormat();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getnPartidas() {
        return nPartidas;
    }

    public void setnPartidas(int nPartidas) {
        this.nPartidas = nPartidas;
    }

    public int getnLanzamientos() {
        return nLanzamientos;
    }

    public void setnLanzamientos(int nLanzamientos) {
        this.nLanzamientos = nLanzamientos;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getPosGeneral() {
        return posGeneral;
    }

    public void setPosGeneral(int posGeneral) {
        this.posGeneral = posGeneral;
    }

    public DateFormat getHora() {
        return hora;
    }

    public void setHora(DateFormat hora) {
        this.hora = hora;
    }
}