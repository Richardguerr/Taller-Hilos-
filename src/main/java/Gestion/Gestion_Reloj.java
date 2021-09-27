package Gestion;

import Interfaz.RankingInterfaz;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Gestion_Reloj extends Thread{
    public JLabel lblHora;
    private String hora;
    private String minutos;
    private String country;
    private String segundos;

    public Gestion_Reloj() {

    }


    public JLabel getLblHora() {
        return lblHora;
    }


    public Gestion_Reloj(JLabel Labelhora, String country) {
        this.country=country;
        this.lblHora=Labelhora;


    }


    public void hora() {

        Calendar calendario = new GregorianCalendar();
        Date horaactual = new Date();
        calendario.setTime(horaactual);
        hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY)
                : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE)
                : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND)
                : "0" + calendario.get(Calendar.SECOND);

    }

    @Override
    public void run() {



        while (true) {


            hora();
            int hour=Integer.parseInt(hora);
            int minute = Integer.parseInt(minutos);
            if (country.equals("USA")){

                if(hour>=23 && minute>0){
                    hour = 0;
                    hora = String.valueOf(hour);
                    lblHora.setText(hora + ":" + minutos + ":" + segundos);
                }else if(hour<23){

                    hour=hour+1;
                    hora = String.valueOf(hour);
                    lblHora.setText(hora + ":" + minutos + ":" + segundos);
                }



                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            else if (country.equals("BRZ")){

                if(hour>=22 && minute>0 && hour<=23){
                    if (hour==23){

                        hour = 1;
                        hora = String.valueOf(hour);
                        lblHora.setText(hora + ":" + minutos + ":" + segundos);
                    }else if (hour==22){

                        hour = 0;
                        hora = String.valueOf(hour);
                        lblHora.setText(hora + ":" + minutos + ":" + segundos);

                    }
                }else if(hour<22 ){

                    hour=hour+2;
                    hora = String.valueOf(hour);
                    lblHora.setText(hora + ":" + minutos + ":" + segundos);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else if (country.equals("CRC")){


                if(hour==0 && minute>0 ){
                    hour=23;
                    hora = String.valueOf(hour);
                    lblHora.setText(hora + ":" + minutos + ":" + segundos);

                }else if(hour>0 ){

                    hour=hour-1;
                    hora = String.valueOf(hour);
                    lblHora.setText(hora + ":" + minutos + ":" + segundos);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }





        }


    }

    private void zona_horario(){





    }




}