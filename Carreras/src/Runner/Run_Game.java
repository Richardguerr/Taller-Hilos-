package Runner;

import javax.swing.JOptionPane;

import model.Crear_Jugador;
import model.Dados;
import model.Game;

public class Run_Game {
	
	 private static int contadorp=1;
	 public static int porcentajep;
	 private static int contadorp2=2;
	 public static int porcentajep2;
	private static double segundos;
	private static int numone,numtwo;
	
	private static Game game = new Game(); 
	
	 
	public static void main(String[] args) {
		Game game = new Game(); 
		game.setVisible(true);
		
		menu();

			//Players();



	}
	
	public static void Players() {
		
		
		
		Thread player_one = new Thread(new Crear_Jugador(Game.img_dado_1, Game.img_dado_2, Game.lbl_suma_res_p1, Game.lbl_suma_res_pa_p1,
				segundos,numone,numtwo,contadorp,Game.lbl_Car_1,game));

			

		Thread player_two = new Thread(new Crear_Jugador(Game.img_dado_1_p2, Game.img_dado_2_p2, Game.lbl_suma_res_p2, Game.lbl_suma_res_pa_p2,
				segundos,numone,numtwo,contadorp2,Game.lbl_Car_2,game));
		
		

		player_one.start();
		player_two.start();

	
		try {
			player_one.join();
			player_two.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Dados.posiciones(Game.lbl_p1_p,Game.lbl_p2_p);
		
	}
	
	public static  void menu() {
		
		String caso="";
		String jugar="";
		int i=1;
		
		while(caso.compareTo("5")!=0) {
			
			caso=JOptionPane.showInputDialog("1. Jugar\n" + "5. Salir\n");
			
			switch (caso)
			{
			case "1": 

				jugar=JOptionPane.showInputDialog("1. Siguiente Partida\n" + "2. Nueva Partida\n");

				switch (jugar){

					case "1":
						Game.lbl_Car_1.setLocation(0, Game.lbl_Car_1.getLocation().y);
						Game.lbl_Car_2.setLocation(0, Game.lbl_Car_2.getLocation().y);
						Game.lbl_partida.setText("Partida # " + i++);
						Players();
						break;

					case "2":
						i=1;
						Game.lbl_Car_1.setLocation(0, Game.lbl_Car_1.getLocation().y);
						Game.lbl_Car_2.setLocation(0, Game.lbl_Car_2.getLocation().y);
						Game.lbl_partida.setText("Partida # " + i++);
						Dados.contador_tirosp1=1;
						Dados.contador_tirosp2=1;
						Dados.acumuladop1=0;
						Dados.acumuladop2=0;
						Players();
						break;
				}

			break;
				
			case "5":
				
				JOptionPane.showMessageDialog(null, "El programa ha finalizado correctamente!!");
			break;
				
			
			default:
				
			break;
			}
			
		}
		
		
		
	}
	
	

}
