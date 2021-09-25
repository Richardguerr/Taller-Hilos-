package control;

import model.Dados;
import model.Jugador;

import javax.json.*;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;

import java.util.*;


public class Ranking {
    private static final String RUTA = "src/main/resources/persistencia/ranking.json";
    private List<Jugador> ranking;
    private List<Jugador> data;

    public Ranking(){
        ranking = new ArrayList<>();
    }

    public List<Jugador> rankingJsonToArrayList() {
        File data = new File(RUTA);
        int i = 1;

        try{
            var is = new FileInputStream(data);
            JsonParserFactory factory = Json.createParserFactory(null);
            JsonParser parser = factory.createParser(is, StandardCharsets.UTF_8);

            if(!parser.hasNext() && parser.next() != JsonParser.Event.START_ARRAY){
                return null;
            }
            while(parser.hasNext()){
                var event = parser.next();
                Jugador j = new Jugador();
                if(event == JsonParser.Event.START_OBJECT){
                    while (parser.hasNext()) {
                        event = parser.next();
                        if (event == JsonParser.Event.KEY_NAME) {
                            var key = parser.getString();
                            switch (key) {
                                case "id":
                                    parser.next();
                                    j.setId(Integer.parseInt(parser.getString()));
                                    //System.out.printf("Id: %s%n", parser.getString());
                                    break;

                                case "name":
                                    parser.next();
                                    j.setName(parser.getString());
                                    //System.out.printf("Name: %s%n", parser.getString());
                                    break;

                                case "nPartidas":
                                    parser.next();
                                    j.setnPartidas(Integer.parseInt(parser.getString()));
                                    //System.out.printf("nPartidas: %s%n", parser.getString());

                                    break;

                                case "nLanzamientos":
                                    parser.next();
                                    j.setnLanzamientos(Integer.parseInt(parser.getString()));
                                    //System.out.printf("nLanzamientos: %s%n%n", parser.getString());
                                    break;
                                case "totalScore":
                                    parser.next();
                                    j.setTotalScore(Integer.parseInt(parser.getString()));
                                    //System.out.printf("totalScore: %s%n%n", parser.getString());
                                    break;
                                case "posGeneral":
                                    parser.next();
                                    j.setPosGeneral(Integer.parseInt(parser.getString()));
                                    //System.out.printf("posGeneral: %s%n%n", parser.getString());
                                    break;
                                case "country":
                                    parser.next();
                                    j.setCountry(parser.getString());
                                    //System.out.printf("Country: %s%n%n", parser.getString());
                                    break;
                            }
                            if(i == 7){
                                ranking.add(j);
                                j = new Jugador();
                                i = 1;
                            }else {
                                i++;
                            }
                        }
                    }
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return ranking;
    }

    public JsonArray updateRankingJSON(List<Jugador> jugadores){

        JsonArray value = Json.createArrayBuilder().add(
                Json.createObjectBuilder()
                        .add("id", jugadores.get(0).getId())
                        .add("name", jugadores.get(0).getName())
                        .add("nPartidas", jugadores.get(0).getnPartidas())
                        .add("nLanzamientos", jugadores.get(0).getnLanzamientos())
                        .add("totalScore", jugadores.get(0).getTotalScore())
                        .add("posGeneral", jugadores.get(0).getPosGeneral())
                        .add("country", jugadores.get(0).getCountry())
        ).add(
                Json.createObjectBuilder()
                        .add("id", jugadores.get(1).getId())
                        .add("name", jugadores.get(1).getName())
                        .add("nPartidas", jugadores.get(1).getnPartidas())
                        .add("nLanzamientos", jugadores.get(1).getnLanzamientos())
                        .add("totalScore", jugadores.get(1).getTotalScore())
                        .add("posGeneral", jugadores.get(1).getPosGeneral())
                        .add("country", jugadores.get(1).getCountry())
        ).add(
                Json.createObjectBuilder()
                        .add("id", jugadores.get(2).getId())
                        .add("name", jugadores.get(2).getName())
                        .add("nPartidas", jugadores.get(2).getnPartidas())
                        .add("nLanzamientos", jugadores.get(2).getnLanzamientos())
                        .add("totalScore", jugadores.get(2).getTotalScore())
                        .add("posGeneral", jugadores.get(2).getPosGeneral())
                        .add("country", jugadores.get(2).getCountry())
        ).add(
                Json.createObjectBuilder()
                        .add("id", jugadores.get(3).getId())
                        .add("name", jugadores.get(3).getName())
                        .add("nPartidas", jugadores.get(3).getnPartidas())
                        .add("nLanzamientos", jugadores.get(3).getnLanzamientos())
                        .add("totalScore", jugadores.get(3).getTotalScore())
                        .add("posGeneral", jugadores.get(3).getPosGeneral())
                        .add("country", jugadores.get(3).getCountry())
        ).add(
                Json.createObjectBuilder()
                        .add("id", jugadores.get(4).getId())
                        .add("name", jugadores.get(4).getName())
                        .add("nPartidas", jugadores.get(4).getnPartidas())
                        .add("nLanzamientos", jugadores.get(4).getnLanzamientos())
                        .add("totalScore", jugadores.get(4).getTotalScore())
                        .add("posGeneral", jugadores.get(4).getPosGeneral())
                        .add("country", jugadores.get(4).getCountry())
        ).build();

        return value;
    }

    public void updateJsonFile(JsonArray data){
        try(
            FileWriter fw = new FileWriter(RUTA);

            JsonWriter jsonWriter = Json.createWriter(fw);) {


            jsonWriter.writeArray(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Jugador> calcularRanking() {
        data = rankingJsonToArrayList();
        List<Jugador> updatePlayers = data;
        ranking = Dados.jugadores;


        for (int i = 0; ranking.size()>i;i++) {
            Jugador juData = data.get(i);
            Jugador juUpdate = ranking.get(i);

            updatePlayers.get(i).setnPartidas(juUpdate.getnPartidas()+juData.getnPartidas());
            updatePlayers.get(i).setTotalScore(juUpdate.getTotalScore()+juData.getTotalScore());
            updatePlayers.get(i).setnLanzamientos(juUpdate.getnLanzamientos()+juData.getnLanzamientos());


        }
        System.out.println("TORETO SOCORE "+ updatePlayers.get(0).getTotalScore());
        updatePlayers = calcularRanking(updatePlayers);
        return updatePlayers;

    }

    private List<Jugador> calcularRanking(List<Jugador> lista){
        List<Jugador> updatePlayers = new ArrayList<>();
        System.out.println("listaaaaaa "+lista.size());
        int[] score = new int[5];
        int i = 0;
        for (Jugador j : lista) {
            score[i] = j.getTotalScore();
            updatePlayers.add(j);
            updatePlayers.get(i).setId(i);
            i++;
        }
        Arrays.sort(score);

        int[] scoreOrdenado = new int[5];
        i = 4;
        for (int d = 0; d < score.length; d++) {
            scoreOrdenado[d] = score[i];
            i--;
        }
        i = 0;
        int j = 0;
        while (updatePlayers.size() > i) {
            if (updatePlayers.get(i).getTotalScore() == scoreOrdenado[j]) {
                updatePlayers.get(i).setPosGeneral(j + 1);
                j = 0;
                i++;
            } else {
                j++;
            }
        }

        for (Jugador jd: updatePlayers) {
            System.out.println(jd.toString());
        }
        return updatePlayers;
    }

}
