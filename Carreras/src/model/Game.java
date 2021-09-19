package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Game extends JFrame {


	private  JPanel contentPane,panel_game;
	public static JLabel img_dado_1, img_dado_2,img_dado_1_p2,img_dado_2_p2;
	public static JLabel lbl_suma_res_pa_p1,lbl_suma_res_pa_p2;
	public static JLabel lbl_suma_res_p1,lbl_suma_res_p2;
	private JLabel lbl_p1;
	private JLabel lbl_p2;
	public static JLabel lbl_p1_p;
	public static JLabel lbl_p2_p;
	public static JLabel lbl_partida;
	public static JLabel lbl_tiro_p1;
	public static JLabel lbl_tiro_p2;
	private JPanel panel_carrera;
	public static JLabel lbl_Car_1;
	public static JLabel lbl_Car_2;
	public static JLabel lbl_Meta;
	
	/**
	 * Create the frame.
	 */
	public Game() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 759);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		panel_game = new JPanel();
		panel_game.setBackground(Color.LIGHT_GRAY);
		panel_game.setBounds(10, 11, 901, 396);
		contentPane.add(panel_game);
		panel_game.setLayout(null);
		

		
		img_dado_1 = new JLabel("");
		img_dado_1.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_1.png")));
		img_dado_1.setBounds(30, 225, 105, 101);
		panel_game.add(img_dado_1);
		
		img_dado_2 = new JLabel("");
		img_dado_2.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_2.png")));
		img_dado_2.setBounds(148, 225, 100, 101);
		panel_game.add(img_dado_2);
		
		lbl_suma_res_p1 = new JLabel("Puntaje:");
		lbl_suma_res_p1.setFont(new Font("Ravie", Font.PLAIN, 16));
		lbl_suma_res_p1.setBounds(90, 108, 207, 53);
		panel_game.add(lbl_suma_res_p1);

		img_dado_1_p2 = new JLabel("");
		img_dado_1_p2.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_5.png")));
		img_dado_1_p2.setBounds(433, 225, 105, 101);
		panel_game.add(img_dado_1_p2);
		
		img_dado_2_p2 = new JLabel("");
		img_dado_2_p2.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_2.png")));
		img_dado_2_p2.setBounds(559, 225, 100, 101);
		panel_game.add(img_dado_2_p2);
		
		lbl_suma_res_pa_p1 = new JLabel("Puntaje Acumulado:");
		lbl_suma_res_pa_p1.setFont(new Font("Ravie", Font.PLAIN, 16));
		lbl_suma_res_pa_p1.setBounds(22, 161, 340, 53);
		panel_game.add(lbl_suma_res_pa_p1);
		
		lbl_suma_res_p2 = new JLabel("Puntaje:");
		lbl_suma_res_p2.setFont(new Font("Ravie", Font.PLAIN, 16));
		lbl_suma_res_p2.setBounds(484, 108, 199, 53);
		panel_game.add(lbl_suma_res_p2);
		
		lbl_suma_res_pa_p2 = new JLabel("Puntaje Acumulado:");
		lbl_suma_res_pa_p2.setFont(new Font("Ravie", Font.PLAIN, 16));
		lbl_suma_res_pa_p2.setBounds(385, 161, 330, 53);
		panel_game.add(lbl_suma_res_pa_p2);
		
		lbl_p1 = new JLabel("Player One");
		lbl_p1.setFont(new Font("Ravie", Font.PLAIN, 16));
		lbl_p1.setBounds(72, 347, 145, 53);
		panel_game.add(lbl_p1);
		
		lbl_p2 = new JLabel("Player Two");
		lbl_p2.setFont(new Font("Ravie", Font.PLAIN, 16));
		lbl_p2.setBounds(460, 347, 145, 53);
		panel_game.add(lbl_p2);
		
		lbl_p1_p = new JLabel("Posici\u00F3n ");
		lbl_p1_p.setFont(new Font("Ravie", Font.PLAIN, 16));
		lbl_p1_p.setBounds(41, 411, 207, 53);
		panel_game.add(lbl_p1_p);
		
		lbl_p2_p = new JLabel("Posici\u00F3n ");
		lbl_p2_p.setFont(new Font("Ravie", Font.PLAIN, 16));
		lbl_p2_p.setBounds(433, 411, 191, 53);
		panel_game.add(lbl_p2_p);
		
		lbl_partida = new JLabel("Partida # 0");
		lbl_partida.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_partida.setFont(new Font("Ravie", Font.BOLD, 42));
		lbl_partida.setBounds(148, 11, 378, 64);
		panel_game.add(lbl_partida);
		
		lbl_tiro_p1 = new JLabel("Tiro #");
		lbl_tiro_p1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tiro_p1.setFont(new Font("Ravie", Font.PLAIN, 16));
		lbl_tiro_p1.setBounds(41, 61, 207, 53);
		panel_game.add(lbl_tiro_p1);
		
		lbl_tiro_p2 = new JLabel("Tiro #");
		lbl_tiro_p2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tiro_p2.setFont(new Font("Ravie", Font.PLAIN, 16));
		lbl_tiro_p2.setBounds(440, 61, 207, 53);
		panel_game.add(lbl_tiro_p2);
		
		panel_carrera = new JPanel();
		panel_carrera.setBackground(new Color(85, 107, 47));
		panel_carrera.setBounds(10, 418, 901, 302);
		contentPane.add(panel_carrera);
		panel_carrera.setLayout(null);
		
		lbl_Car_1 = new JLabel("");
		lbl_Car_1.setIcon(new ImageIcon(Game.class.getResource("/imagenes/carro_1.png")));
		lbl_Car_1.setBounds(24, 23, 209, 86);
		panel_carrera.add(lbl_Car_1);
		
		lbl_Car_2 = new JLabel("");
		lbl_Car_2.setIcon(new ImageIcon(Game.class.getResource("/imagenes/carro_2.png")));
		lbl_Car_2.setBounds(24, 166, 209, 86);
		panel_carrera.add(lbl_Car_2);
		
		lbl_Meta = new JLabel("");
		lbl_Meta.setIcon(new ImageIcon(Game.class.getResource("/imagenes/meta_car.jpg")));
		lbl_Meta.setBounds(806, 0, 95, 302);
		panel_carrera.add(lbl_Meta);
		
			


			
			
		
	}
	
	public JLabel getFirstCar() {
		
		
		return lbl_Car_1;
	}
	public JLabel getSecondCar() {
		
		
		return lbl_Car_2;
	}
	public JLabel getMeta() {
		
		
		return lbl_Meta;
	}


}
