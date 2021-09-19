package model;

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
		
		int auto1=0;
		int auto2=0;
		while(true) {
			
			
			try {
				
				
				Thread.sleep((int)(Math.random()*1000));
				auto1=autos.getFirstCar().getLocation().x;
				auto2=autos.getSecondCar().getLocation().x;
				
				if(auto1 < autos.getMeta().getLocation().x-100 && auto2 < autos.getMeta().getLocation().x-100) {
					etiqueta.setLocation(etiqueta.getLocation().x+10, etiqueta.getLocation().y);
					
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
