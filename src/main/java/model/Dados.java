package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Interfaz.Game;
import control.Control;



public class Dados {

    private static int contador_dado_uno;
    private static int contador_dado_dos;
    public static int acumuladop1;
    public static int acumuladop2;
    public static int acumuladop3;
    public static int acumuladop4;
    public static int acumuladop5;

    private static Random random = new Random();
    private static ArrayList<Integer> winner = new ArrayList<>();
    private static ArrayList<Integer> posiciones = new ArrayList<>();
    private static Icon icono = new ImageIcon(Game.class.getResource("/imagenes/winner.png"));
    public static List<Jugador> jugadores = Control.r.rankingJsonToArrayList();

    public static int contador_tirosp1=1;
    public static int contador_tirosp2=1;
    public static int contador_tirosp3=1;
    public static int contador_tirosp4=1;
    public static int contador_tirosp5=1;
    public static int contador_pn=0;






    public static void dadosRandom(JLabel p_dado_uno, JLabel p_dado_dos, JLabel p_re, JLabel p_pa, double segundos, int num_dado_1, int num_dado_2, int contadorp) {



        if (contadorp==1) {


            segundos= (random.nextDouble()*3);

            //System.out.println("Segundos p1: " + segundos);
            detener(segundos);

            Game.lbl_tiro_p1.setText("Tiro # " + contador_tirosp1++);

            num_dado_1=(int) (random.nextDouble()*6 + 1);
            num_dado_2=(int) (random.nextDouble()*6 + 1);


            //System.out.println("Dado uno: " + num_dado_1 + " Dado dos: " + num_dado_2);

            contadorp=comprobarDadoUno(num_dado_1,p_dado_uno) + comprobarDadoDos(num_dado_2,p_dado_dos);
            contador_pn=contadorp;

            //
            //System.out.println("Contador==1: " + contadorp);

            acumuladop1+=contadorp;
            p_re.setText("Puntaje: " + contadorp);
            p_pa.setText("<html>Puntaje<br>Acumulado: " + acumuladop1);
            jugadores.get(0).setTotalScore(acumuladop1);
            jugadores.get(0).setnLanzamientos(contador_tirosp1);
            jugadores.get(0).setnPartidas(Game.getI());

        }else if (contadorp==2) {



            segundos = (random.nextDouble() * 3);
            //
            //System.out.println("Segundos p2: " + segundos);


            detener(segundos);

            Game.lbl_tiro_p2.setText("Tiro # " + contador_tirosp2++);

            num_dado_1 = (int) (random.nextDouble() * 6 + 1);
            num_dado_2 = (int) (random.nextDouble() * 6 + 1);

            //
            //System.out.println("Dado uno p2: " + num_dado_1 + " Dado dos p2: " + num_dado_2);

            contadorp = comprobarDadoUno(num_dado_1, p_dado_uno) + comprobarDadoDos(num_dado_2, p_dado_dos);
            contador_pn=contadorp;

            //
            //System.out.println("Contador ==0: " + contadorp);
            acumuladop2 += contadorp;

            p_re.setText("Puntaje: " + contadorp);
            p_pa.setText("<html>Puntaje<br>Acumulado: " + acumuladop2);
            jugadores.get(1).setTotalScore(acumuladop2);
            jugadores.get(1).setnLanzamientos(contador_tirosp2);
            jugadores.get(1).setnPartidas(Game.getI());

        }
        else if (contadorp==3) {



            segundos = (random.nextDouble() * 3);
            detener(segundos);

            Game.lbl_tiro_p3.setText("Tiro # " + contador_tirosp3++);

            num_dado_1 = (int) (random.nextDouble() * 6 + 1);
            num_dado_2 = (int) (random.nextDouble() * 6 + 1);

            contadorp = comprobarDadoUno(num_dado_1, p_dado_uno) + comprobarDadoDos(num_dado_2, p_dado_dos);
            contador_pn=contadorp;
            acumuladop3 += contadorp;

            p_re.setText("Puntaje: " + contadorp);
            p_pa.setText("<html>Puntaje<br>Acumulado: " + acumuladop3);

            jugadores.get(2).setTotalScore(acumuladop3);
            jugadores.get(2).setnLanzamientos(contador_tirosp3);
            jugadores.get(2).setnPartidas(Game.getI());

        }else if (contadorp==4) {



            segundos = (random.nextDouble() * 3);
            detener(segundos);

            Game.lbl_tiro_p4.setText("Tiro # " + contador_tirosp4++);

            num_dado_1 = (int) (random.nextDouble() * 6 + 1);
            num_dado_2 = (int) (random.nextDouble() * 6 + 1);

            contadorp = comprobarDadoUno(num_dado_1, p_dado_uno) + comprobarDadoDos(num_dado_2, p_dado_dos);
            contador_pn=contadorp;
            acumuladop4 += contadorp;

            p_re.setText("Puntaje: " + contadorp);
            p_pa.setText("<html>Puntaje<br>Acumulado: " + acumuladop4);

            jugadores.get(3).setTotalScore(acumuladop4);
            jugadores.get(3).setnLanzamientos(contador_tirosp4);
            jugadores.get(3).setnPartidas(Game.getI());

        }else if (contadorp==5) {



            segundos = (random.nextDouble() * 3);
            detener(segundos);

            Game.lbl_tiro_p5.setText("Tiro # " + contador_tirosp5++);

            num_dado_1 = (int) (random.nextDouble() * 6 + 1);
            num_dado_2 = (int) (random.nextDouble() * 6 + 1);

            contadorp = comprobarDadoUno(num_dado_1, p_dado_uno) + comprobarDadoDos(num_dado_2, p_dado_dos);
            contador_pn=contadorp;
            acumuladop5 += contadorp;

            p_re.setText("Puntaje: " + contadorp);
            p_pa.setText("<html>Puntaje<br>Acumulado: " + acumuladop5);

            jugadores.get(4).setTotalScore(acumuladop5);
            jugadores.get(4).setnLanzamientos(contador_tirosp5);
            jugadores.get(4).setnPartidas(Game.getI());

        }



    }


    public static int comprobarDadoUno(int name_Dado, JLabel p_d1) {

        if (name_Dado==1) {

            p_d1.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_1.png")));
            contador_dado_uno=1;

        }else if (name_Dado==2) {

            p_d1.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_2.png")));
            contador_dado_uno=2;


        }else if(name_Dado==3) {

            p_d1.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_3.png")));
            contador_dado_uno=3;

        }else if(name_Dado==4) {

            p_d1.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_4.png")));
            contador_dado_uno=4;

        }else if(name_Dado==5) {

            p_d1.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_5.png")));
            contador_dado_uno=5;

        }else if(name_Dado==6) {

            p_d1.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_6.png")));
            contador_dado_uno=6;

        }

        return contador_dado_uno;

    }

    public static int comprobarDadoDos(int name_Dado, JLabel p_d2) {

        if (name_Dado==1) {

            p_d2.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_1.png")));
            contador_dado_dos=1;

        }else if (name_Dado==2) {

            p_d2.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_2.png")));
            contador_dado_dos=2;

        }else if(name_Dado==3) {

            p_d2.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_3.png")));
            contador_dado_dos=3;

        }else if(name_Dado==4) {

            p_d2.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_4.png")));
            contador_dado_dos=4;

        }else if(name_Dado==5) {

            p_d2.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_5.png")));
            contador_dado_dos=5;

        }else if(name_Dado==6) {

            p_d2.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_6.png")));
            contador_dado_dos=6;

        }

        return contador_dado_dos;
    }

    public static void detener(Double segundos) {

        try {
            Thread.sleep((long) (segundos*1000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public static void winner(){

        winner.clear();

        int auto1 = Game.lbl_Car_1.getLocation().x;
        int auto2 = Game.lbl_Car_2.getLocation().x;
        int auto3 = Game.lbl_Car_3.getLocation().x;
        int auto4 = Game.lbl_Car_4.getLocation().x;
        int auto5 = Game.lbl_Car_5.getLocation().x;

        winner.add(auto1);
        winner.add(auto2);
        winner.add(auto3);
        winner.add(auto4);
        winner.add(auto5);

        winner.sort((o1,o2)->Integer.compare(o1, o2));

        if (winner.get(4)==auto1) {
            JOptionPane.showMessageDialog(null, jugadores.get(0).getName()+" es el ganador !!",
                    "Winner...", JOptionPane.QUESTION_MESSAGE, icono);
        }
        else if (winner.get(4)==auto2) {
            JOptionPane.showMessageDialog(null, jugadores.get(1).getName()+" es el ganador !!",
                    "Winner...", JOptionPane.QUESTION_MESSAGE, icono);
        }
        else if (winner.get(4)==auto3) {
            JOptionPane.showMessageDialog(null, jugadores.get(2).getName()+" es el ganador !!",
                    "Winner...", JOptionPane.QUESTION_MESSAGE, icono);
        }
        else if (winner.get(4)==auto4) {
            JOptionPane.showMessageDialog(null, jugadores.get(3).getName()+" es el ganador !!",
                    "Winner...", JOptionPane.QUESTION_MESSAGE, icono);
        }
        else if (winner.get(4)==auto5) {
            JOptionPane.showMessageDialog(null, jugadores.get(4).getName()+" es el ganador !!",
                    "Winner...", JOptionPane.QUESTION_MESSAGE, icono);
        }

    }

    public static void Posiciones(){

        posiciones.clear();

        posiciones.add(acumuladop1);
        posiciones.add(acumuladop2);
        posiciones.add(acumuladop3);
        posiciones.add(acumuladop4);
        posiciones.add(acumuladop5);

        posiciones.sort((o1,o2)->Integer.compare(o1, o2));

        for (int i=0;i<5;i++) {

            if(posiciones.get(i)==acumuladop1) {

                if (i==0) {
                    Game.lbl_p1_p.setText("Posicion 5");
                }else if(i==1) {
                    Game.lbl_p1_p.setText("Posicion 4");
                }else if(i==2) {
                    Game.lbl_p1_p.setText("Posicion 3");
                }else if(i==3) {
                    Game.lbl_p1_p.setText("Posicion 2");
                }else if(i==4) {
                    Game.lbl_p1_p.setText("Posicion 1");
                }
            }
            else if(posiciones.get(i)==acumuladop2) {

                if (i==0) {
                    Game.lbl_p2_p.setText("Posicion 5");
                }else if(i==1) {
                    Game.lbl_p2_p.setText("Posicion 4");
                }else if(i==2) {
                    Game.lbl_p2_p.setText("Posicion 3");
                }else if(i==3) {
                    Game.lbl_p2_p.setText("Posicion 2");
                }else if(i==4) {
                    Game.lbl_p2_p.setText("Posicion 1");
                }
            }
            else if(posiciones.get(i)==acumuladop3) {

                if (i==0) {
                    Game.lbl_p3_p.setText("Posicion 5");
                }else if(i==1) {
                    Game.lbl_p3_p.setText("Posicion 4");
                }else if(i==2) {
                    Game.lbl_p3_p.setText("Posicion 3");
                }else if(i==3) {
                    Game.lbl_p3_p.setText("Posicion 2");
                }else if(i==4) {
                    Game.lbl_p3_p.setText("Posicion 1");
                }
            }
            else if(posiciones.get(i)==acumuladop4) {

                if (i==0) {
                    Game.lbl_p4_p.setText("Posicion 5");
                }else if(i==1) {
                    Game.lbl_p4_p.setText("Posicion 4");
                }else if(i==2) {
                    Game.lbl_p4_p.setText("Posicion 3");
                }else if(i==3) {
                    Game.lbl_p4_p.setText("Posicion 2");
                }else if(i==4) {
                    Game.lbl_p4_p.setText("Posicion 1");
                }
            }
            else if(posiciones.get(i)==acumuladop5) {

                if (i==0) {
                    Game.lbl_p5_p.setText("Posicion 5");
                }else if(i==1) {
                    Game.lbl_p5_p.setText("Posicion 4");
                }else if(i==2) {
                    Game.lbl_p5_p.setText("Posicion 3");
                }else if(i==3) {
                    Game.lbl_p5_p.setText("Posicion 2");
                }else if(i==4) {
                    Game.lbl_p5_p.setText("Posicion 1");
                }
            }



        }

    }

}