package model;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Pistas extends JFrame {

	private JPanel contentPane;
	public static JLabel lbl_Car_1,lbl_Car_2,lbl_Meta;
	private static Pistas panelPistas = new Pistas();
	
	
	/*
	
	 */
	public Pistas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Carrera de Autos");
		lblNewLabel.setFont(new Font("Magneto", Font.PLAIN, 31));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(182, 11, 371, 87);
		contentPane.add(lblNewLabel);
		
		JPanel pista = new JPanel();
		pista.setBounds(26, 97, 731, 383);
		contentPane.add(pista);
		pista.setLayout(null);
		
		lbl_Car_1 = new JLabel("");
		lbl_Car_1.setIcon(new ImageIcon(Pistas.class.getResource("/imagenes/carro_1.png")));
		lbl_Car_1.setBounds(19, 35, 319, 165);
		pista.add(lbl_Car_1);
		
		lbl_Car_2 = new JLabel("");
		lbl_Car_2.setIcon(new ImageIcon(Pistas.class.getResource("/imagenes/carro_2.png")));
		lbl_Car_2.setBounds(22, 224, 344, 148);
		pista.add(lbl_Car_2);
		
		lbl_Meta = new JLabel("");
		lbl_Meta.setIcon(new ImageIcon(Pistas.class.getResource("/imagenes/meta_car.jpg")));
		lbl_Meta.setForeground(Color.RED);
		lbl_Meta.setBackground(Color.MAGENTA);
		lbl_Meta.setBounds(623, 0, 100, 383);
		pista.add(lbl_Meta);
		
		JButton btnNewButton = new JButton("Iniciar Carrera");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Run();
				
			}
		});
		btnNewButton.setBounds(337, 491, 122, 40);
		contentPane.add(btnNewButton);
	}
	
	public void Run() {
		

		lbl_Car_1.setLocation(0,lbl_Car_1.getLocation().y);
		lbl_Car_2.setLocation(0,lbl_Car_2.getLocation().y);
		
		Thread car_one = new Thread(new Carrera(lbl_Car_1, panelPistas));
		Thread car_two = new Thread(new Carrera(lbl_Car_2, panelPistas));
		
		car_one.start();
		car_two.start();
		
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
