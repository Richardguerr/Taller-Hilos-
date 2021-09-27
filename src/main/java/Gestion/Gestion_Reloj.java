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

public class Gestion_Reloj implements Runnable{
    private Thread hilo;
    public JLabel lblHora;
    private String hora;
    private String minutos;
    private String segundos;


    public JLabel getLblHora() {
        return lblHora;
    }


    public Gestion_Reloj(JFrame frame, JLabel hora) {
        hilo = new Thread(this);
        hilo.start();
        lblHora = new JLabel("00:00:00");
        lblHora.setFont(new Font("Papyrus", Font.ITALIC, 19));
        lblHora.setForeground(Color.ORANGE);
        lblHora.setBounds(135, 44, 111, 30);
        frame.add(lblHora);
    }


    public static String Fecha() {

        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");

        return formatofecha.format(fecha);

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

        Thread current = Thread.currentThread();

        while (current == hilo) {

            if(lblHora!=null){
                hora();
                lblHora.setText(hora + ":" + minutos + ":" + segundos);
            }

        }

    }

}
