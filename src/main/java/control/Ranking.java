package control;

import com.sun.tools.javac.Main;
import model.Dados;
import model.Jugador;

import javax.json.*;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class Ranking {
    //"src/main/resources/persistencia/ranking.json"
    //Ranking.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    private static final String RUTA = "persistencia/ranking.json";
    private List<Jugador> dadosJugadores;
    private List<Jugador> datosJSON;
    private List<Jugador> lista;

    public Ranking(){

        dadosJugadores = new ArrayList<>();
        datosJSON = new ArrayList<>();
        lista = new ArrayList<>();
    }

    public File getResourceAsFile(String resourcePath) {
        try {
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(resourcePath);
            if (in == null) {
                return null;
            }

            File tempFile = File.createTempFile(String.valueOf(in.hashCode()), ".tmp");
            tempFile.deleteOnExit();

            try (FileOutputStream out = new FileOutputStream(tempFile)) {
                //copy stream
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Jugador> rankingJsonToArrayList() {
        datosJSON = new ArrayList<>();
        //File data = new File(RUTA);
        File data = getResourceAsFile(RUTA);
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
                                datosJSON.add(j);
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
        return datosJSON;
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
        try{
            //PrintWriter writer = new PrintWriter(RUTA);
            File file = getResourceAsFile(RUTA);
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            //FileWriter fw = new FileWriter(RUTA);
            FileWriter fw = new FileWriter(file);

            JsonWriter jsonWriter = Json.createWriter(fw);
            jsonWriter.writeArray(data);
            jsonWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Jugador> calcularRanking() {
        List<Jugador> updatePlayers = rankingJsonToArrayList();

        dadosJugadores = Dados.jugadores;


        for (int i = 0; i < updatePlayers.size();i++) {

            Jugador juData = updatePlayers.get(i);
            Jugador juUpdate = dadosJugadores.get(i);

            updatePlayers.get(i).setnPartidas(juUpdate.getnPartidas()+juData.getnPartidas());
            updatePlayers.get(i).setTotalScore(juUpdate.getTotalScore()+juData.getTotalScore());
            updatePlayers.get(i).setnLanzamientos(juUpdate.getnLanzamientos()+juData.getnLanzamientos()-1);


        }
        updatePlayers = calcularRanking(updatePlayers);
        return updatePlayers;

    }

    private List<Jugador> calcularRanking(List<Jugador> lista){
        List<Jugador> updatePlayers = new ArrayList<>();
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


        return updatePlayers;
    }

}
