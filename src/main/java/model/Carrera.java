package model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Carrera implements Runnable {

    private JLabel etiqueta;
    private Pistas autos;

    public Carrera(JLabel eqtiqueta , Pistas autos) {

        this.etiqueta=eqtiqueta;
        this.autos=autos;

    }


    @Override
    public void run() {

        Runhilos();



    }

    public void Runhilos() {

        int auto1=0;
        int auto2=0;
        while(true) {


            try {


                Thread.sleep((int)(Math.random()*1000));
                auto1=Pistas.lbl_Car_1.getLocation().x;
                auto2=Pistas.lbl_Car_2.getLocation().x;

                if(auto1 < autos.getMeta().getLocation().x-100 && auto2 < autos.getMeta().getLocation().x-100) {
                    etiqueta.setIcon(new ImageIcon(getClass().getResource("/imagenes/dado_4.png")));
                    etiqueta.setLocation(etiqueta.getLocation().x+10, etiqueta.getLocation().y);
                    etiqueta.setText("HOLAAAA");
                }else {

                    break;

                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        if (etiqueta.getLocation().x >=autos.getMeta().getLocation().x-100) {
            if(auto1>auto2) {
                JOptionPane.showMessageDialog(null, "Gano el carro uno!!");
            }else if(auto2>auto1){

                JOptionPane.showMessageDialog(null, "Gano el carro dos!!");
            }else {

                JOptionPane.showMessageDialog(null, "Empate!!");
            }


        }



    }



}