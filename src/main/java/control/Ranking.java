package control;

import model.Jugador;

import javax.json.*;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;



public class Ranking {
    private static final String RUTA = "src/main/resources/persistencia/ranking.json";
    private List<Jugador> ranking;

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

    public void updateRankingJSON(List<Jugador> jugadores){

    }

}
