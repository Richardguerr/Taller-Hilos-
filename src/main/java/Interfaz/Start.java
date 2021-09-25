package Interfaz;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Gestion.Gestion_Start;
import control.Ranking;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Font;

import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Start extends JFrame {

    /**
     *
     */

    private JPanel contentPane;
    public static JLabel lbl_loading;
    private JFrame exitFrame;
    private JButton btn_Start;


    public Start() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Start.class.getResource("/imagenes/logo_game.png")));
        setResizable(false);
        setTitle("Fast & Furios");
        initComponents();
    }

    private void initComponents() {


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 675);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        exitFrame=this;


        btn_Start = new JButton("");
        btn_Start.setRolloverIcon(new ImageIcon(Start.class.getResource("/imagenes/button_Start_2.png")));
        btn_Start.setPressedIcon(new ImageIcon(Start.class.getResource("/imagenes/button_Start_press_1.png")));
        btn_Start.setIcon(new ImageIcon(Start.class.getResource("/imagenes/button_Start_1.png")));
        btn_Start.setContentAreaFilled(false);
        btn_Start.setBorder(null);
        btn_Start.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_Start.setRequestFocusEnabled(false);
        btn_Start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Thread start =new Thread(new Gestion_Start(lbl_loading,btn_Start,exitFrame));
                start.start();

            }
        });
        btn_Start.setBounds(212, 190, 150, 150);
        contentPane.add(btn_Start);

        lbl_loading = new JLabel("");
        lbl_loading.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_loading.setVisible(false);
        lbl_loading.setIcon(new ImageIcon(Start.class.getResource("/imagenes/loading_2.gif")));
        lbl_loading.setBounds(-2, 220, 585, 92);
        contentPane.add(lbl_loading);

        JLabel lbl_title = new JLabel("");
        lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_title.setIcon(new ImageIcon(Start.class.getResource("/imagenes/fast_furios.png")));
        lbl_title.setBounds(-1, 11, 585, 170);
        contentPane.add(lbl_title);

        JLabel lbl_logo = new JLabel("");
        lbl_logo.setFont(new Font("Brush Script MT", Font.PLAIN, 16));
        lbl_logo.setIcon(new ImageIcon(Start.class.getResource("/imagenes/logo_png.png")));
        lbl_logo.setBounds(-7, 258, 595, 378);
        contentPane.add(lbl_logo);

    }
}
