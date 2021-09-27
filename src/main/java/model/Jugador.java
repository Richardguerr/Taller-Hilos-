package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;


public class Jugador {
    private int id;
    private String name;
    private int nPartidas;
    private int nLanzamientos;
    private int totalScore;
    private int posGeneral;
    //private DateFormat hora;
    private String country;

    public static Comparator<Jugador> compTotalScore = new Comparator<Jugador>() {
        @Override
        public int compare(Jugador o1, Jugador o2) {
            String totalScore = String.valueOf(o1.getTotalScore());
            return totalScore.compareTo(String.valueOf(o2.getTotalScore()));
        }
    };


    public Jugador(){
        id = 0;
        name = "";
        nPartidas = 0;
        nLanzamientos = 0;
        totalScore = 0;
        posGeneral = 0;
        //hora = new SimpleDateFormat();
        country = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nPartidas=" + nPartidas +
                ", nLanzamientos=" + nLanzamientos +
                ", totalScore=" + totalScore +
                ", posGeneral=" + posGeneral +
                ", country='" + country + '\'' +
                '}';
    }
}