package model;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Runner.Run_Game;
import model.Game;

public class Dados {
	
	private static int contador_dado_uno;
	private static int contador_dado_dos;
	public static int acumuladop1;
	public static int acumuladop2;
	private static Random random = new Random();
	private static Run_Game run_Game = new Run_Game();
	public static int contador_tirosp1=1;
	public static int contador_tirosp2=1;
	public static int contador_pn=0;
	





	public static boolean dadosRandom(JLabel p_dado_uno, JLabel p_dado_dos, JLabel p_re, JLabel p_pa, double segundos, int num_dado_1, int num_dado_2, int contadorp1) {

			
		
			if (contadorp1==1) {


				segundos= (random.nextDouble()*3);
				//
				System.out.println("Segundos p1: " + segundos);
				detener(segundos);

				Game.lbl_tiro_p1.setText("Tiro # " + contador_tirosp1++);

				num_dado_1=(int) (random.nextDouble()*6 + 1);
				num_dado_2=(int) (random.nextDouble()*6 + 1);

				//
				System.out.println("Dado uno: " + num_dado_1 + " Dado dos: " + num_dado_2);

				contadorp1=comprobarDadoUno(num_dado_1,p_dado_uno) + comprobarDadoDos(num_dado_2,p_dado_dos);
				contador_pn=contadorp1;
				//
				System.out.println("Contador==1: " + contadorp1);

				acumuladop1+=contadorp1;
				p_re.setText("El resultado es: " + contadorp1);
				p_pa.setText("Porcentaje Acumulado es: " + acumuladop1);
				

			}else if (contadorp1==2) {



				segundos = (random.nextDouble() * 3);
				//
				System.out.println("Segundos p2: " + segundos);


				detener(segundos);

				Game.lbl_tiro_p2.setText("Tiro # " + contador_tirosp2++);

				num_dado_1 = (int) (random.nextDouble() * 6 + 1);
				num_dado_2 = (int) (random.nextDouble() * 6 + 1);

				//
				System.out.println("Dado uno p2: " + num_dado_1 + " Dado dos p2: " + num_dado_2);

				contadorp1 = comprobarDadoUno(num_dado_1, p_dado_uno) + comprobarDadoDos(num_dado_2, p_dado_dos);
				contador_pn=contadorp1;
				//
				System.out.println("Contador ==0: " + contadorp1);
				acumuladop2 += contadorp1;

				p_re.setText("El resultado es: " + contadorp1);
				p_pa.setText("Porcentaje Acumulado es: " + acumuladop2);

			}


			
			
		return true;
		
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

	public static void posiciones(JLabel p1 , JLabel p2){

		if (acumuladop1 < acumuladop2){

			p1.setText("Posición 2");
			p2.setText("Posición 1");
			
		}else {
			p1.setText("Posición 1");
			p2.setText("Posición 2");
		}

	}

}
