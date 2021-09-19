package model;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Crear_Jugador implements Runnable {
	
	private JLabel etiqueta;
	private Game game;
	private JLabel img_d1_p,img_d2_p;
	private JLabel lbl_res_p, lbl_res_pa_p;
	private int numuno , numdos;
	private double segundos;
	private int contador;
	
	
	
	public Crear_Jugador(JLabel img_dado_uno,JLabel img_dado_dos,JLabel resultado_p , JLabel resultado_pa_p,double segundos,int numuno,int numdos,
			int contador, JLabel etiqueta , Game game ) {
		
		this.img_d1_p=img_dado_uno;
		this.img_d2_p=img_dado_dos;
		this.lbl_res_p=resultado_p;
		this.lbl_res_pa_p=resultado_pa_p;
		this.numuno=numuno;
		this.numdos=numdos;
		this.segundos=segundos;
		this.contador=contador;
		this.etiqueta=etiqueta;
		this.game=game;
		
		
		
	}
	
	@Override
	public void run() {
		int auto1=0;
		int auto2=0;
		

		while (true){
			
			Dados.dadosRandom(img_d1_p, img_d2_p, lbl_res_p, lbl_res_pa_p,segundos,numuno,numdos,contador);
			
			try {
				
			auto1=game.getFirstCar().getLocation().x;
			auto2=game.getSecondCar().getLocation().x;
			
			if(auto1 < game.getMeta().getLocation().x-200 && auto2 < game.getMeta().getLocation().x-200) {
				etiqueta.setLocation(etiqueta.getLocation().x+(Dados.contador_pn*3), etiqueta.getLocation().y);
				game.repaint();
				
			}else {
				
				break;
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
			
		}
		
		if (etiqueta.getLocation().x>=game.getMeta().getLocation().x-200) {
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
