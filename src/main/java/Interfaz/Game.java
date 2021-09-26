package Interfaz;



import java.awt.*;




import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Gestion.Gestion_Hilos;
import control.Control;
import control.Ranking;
import model.Dados;
import model.Jugador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;


@SuppressWarnings("serial")
public class Game extends JFrame {


    private  JPanel contentPane,panel_game;
    private JPanel panel_carrera;
    public static JLabel lbl_partida;

    private static JLabel lbl_p1;
    public static JLabel lbl_tiro_p1;
    public static JLabel lbl_suma_res_p1;
    public static JLabel lbl_suma_res_pa_p1;
    public static JLabel img_dado_1;
    public static JLabel img_dado_2;
    public static JLabel lbl_p1_p;

    private static JLabel lbl_p2;
    public static JLabel img_dado_1_p2;
    public static JLabel img_dado_2_p2;
    public static JLabel lbl_suma_res_pa_p2;
    public static JLabel lbl_suma_res_p2;
    public static JLabel lbl_tiro_p2;
    public static JLabel lbl_p2_p;

    private static  JLabel lbl_p3;
    public static JLabel lbl_tiro_p3;
    public static JLabel lbl_suma_res_p3;
    public static JLabel lbl_suma_res_pa_p3;
    public static JLabel img_dado_1_p3;
    public static JLabel img_dado_2_p3;
    public static JLabel lbl_p3_p;

    private static  JLabel lbl_p4;
    public static JLabel lbl_tiro_p4;
    public static JLabel lbl_suma_res_p4;
    public static JLabel lbl_suma_res_pa_p4;
    public static JLabel img_dado_1_p4;
    public static JLabel img_dado_2_p4;
    public static JLabel lbl_p4_p;

    private static JLabel lbl_p5;
    public static JLabel lbl_tiro_p5;
    public static JLabel lbl_suma_res_p5;
    public static JLabel lbl_suma_res_pa_p5;
    public static JLabel img_dado_1_p5;
    public static JLabel img_dado_2_p5;
    public static JLabel lbl_p5_p;


    public static JLabel lbl_Car_1;
    public static JLabel lbl_Car_2;
    public static JLabel lbl_Car_4;
    public static JLabel lbl_Car_3;
    public static JLabel lbl_Car_5;
    private static JLabel pista;

    public static JLabel lbl_Meta;
    public static JButton btn_New_Game;
    private JButton btn_Exit;
    public static JButton btn_NextGame;
    public static JButton btn_Home;
    private static 	int i=0;
    private static Gestion_Hilos gestion_Hilos = new Gestion_Hilos();
    private JLabel lbl_border_1;
    private JLabel lbl_border_4;
    private JLabel lbl_borde_pista;
    private JLabel lbl_borde_pista_1;
    private JLabel lbl_table_1;
    private JButton btn_New_Game_1;


    /**
     * Create the frame.
     */
    public Game() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Game.class.getResource("/imagenes/logo_game.png")));
        setTitle("Fast & Furios UPTC");
        setResizable(false);


        initJFrame();
        InitComponents();
        button_NewGame();
        button_NextGame();
        button_Exit();


    }

    public JLabel getFirstCar() {
        return lbl_Car_1;
    }
    public JLabel getSecondCar() {
        return lbl_Car_2;
    }
    public JLabel getThirdCar() {
        return lbl_Car_3;
    }
    public JLabel getFourthCar() {
        return lbl_Car_4;
    }
    public JLabel getFifthCar() {
        return lbl_Car_5;
    }
    public JLabel getMeta() {
        return lbl_Meta;
    }

    public static int getI(){
        return i-1;
    }

    private void button_NextGame() {

        btn_NextGame = new JButton("");
        btn_NextGame.setContentAreaFilled(false);
        btn_NextGame.setBorderPainted(false);
        btn_NextGame.setRequestFocusEnabled(false);
        btn_NextGame.setRolloverIcon(new ImageIcon(Game.class.getResource("/imagenes/next_level_2.png")));
        btn_NextGame.setPressedIcon(new ImageIcon(Game.class.getResource("/imagenes/next_level_1_press.png")));
        btn_NextGame.setIcon(new ImageIcon(Game.class.getResource("/imagenes/next_level_1.png")));
        btn_NextGame.setBorder(null);
        btn_NextGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_NextGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                Game.lbl_Car_1.setLocation(0, Game.lbl_Car_1.getLocation().y);
                Game.lbl_Car_2.setLocation(0, Game.lbl_Car_2.getLocation().y);
                Game.lbl_Car_3.setLocation(0, Game.lbl_Car_3.getLocation().y);
                Game.lbl_Car_4.setLocation(0, Game.lbl_Car_4.getLocation().y);
                Game.lbl_Car_5.setLocation(0, Game.lbl_Car_5.getLocation().y);
                Game.lbl_partida.setText("Partida # " + i++);
                gestion_Hilos.Player();

            }
        });
        btn_NextGame.setBounds(201, 575, 140, 81);
        contentPane.add(btn_NextGame);

    }
    private void button_NewGame() {

        btn_New_Game = new JButton("");
        btn_New_Game.setRequestFocusEnabled(false);
        btn_New_Game.setRolloverIcon(new ImageIcon(Game.class.getResource("/imagenes/newGame_2.png")));
        btn_New_Game.setPressedIcon(new ImageIcon(Game.class.getResource("/imagenes/newGame_1_press.png")));
        btn_New_Game.setIcon(new ImageIcon(Game.class.getResource("/imagenes/newGame_1.png")));
        btn_New_Game.setBorder(null);
        btn_New_Game.setContentAreaFilled(false);
        btn_New_Game.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_New_Game.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                i=1;

                Game.lbl_Car_1.setLocation(0, Game.lbl_Car_1.getLocation().y);
                Game.lbl_Car_2.setLocation(0, Game.lbl_Car_2.getLocation().y);
                Game.lbl_Car_3.setLocation(0, Game.lbl_Car_3.getLocation().y);
                Game.lbl_Car_4.setLocation(0, Game.lbl_Car_4.getLocation().y);
                Game.lbl_Car_5.setLocation(0, Game.lbl_Car_5.getLocation().y);

                Game.lbl_partida.setText("Partida # " + i++);
                Dados.contador_tirosp1=1;
                Dados.contador_tirosp2=1;
                Dados.contador_tirosp3=1;
                Dados.contador_tirosp4=1;
                Dados.contador_tirosp5=1;
                Dados.acumuladop1=0;
                Dados.acumuladop2=0;
                Dados.acumuladop3=0;
                Dados.acumuladop4=0;
                Dados.acumuladop5=0;
                gestion_Hilos.Player();



            }
        });
        btn_New_Game.setBounds(365, 575, 140, 81);
        contentPane.add(btn_New_Game);

    }

    private void button_Exit() {

        btn_Exit = new JButton("");
        btn_Exit.setRequestFocusEnabled(false);
        btn_Exit.setRolloverIcon(new ImageIcon(Game.class.getResource("/imagenes/exit_2.png")));
        btn_Exit.setPressedIcon(new ImageIcon(Game.class.getResource("/imagenes/exit_1_press.png")));
        btn_Exit.setIcon(new ImageIcon(Game.class.getResource("/imagenes/exit_1.png")));
        btn_Exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_Exit.setContentAreaFilled(false);
        btn_Exit.setBorder(null);
        btn_Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "El programa ha finalizado correctamente!!");
                System.exit(0);
            }
        });
        btn_Exit.setBounds(638, 575, 140, 81);
        contentPane.add(btn_Exit);


        lbl_borde_pista = new JLabel("");
        lbl_borde_pista.setIcon(new ImageIcon(Game.class.getResource("/imagenes/borde_pista.png")));
        lbl_borde_pista.setBounds(21, 325, 14, 522);
        contentPane.add(lbl_borde_pista);

        lbl_borde_pista_1 = new JLabel("");
        lbl_borde_pista_1.setIcon(new ImageIcon(Game.class.getResource("/imagenes/borde_pista.png")));
        lbl_borde_pista_1.setBounds(935, 326, 14, 522);
        contentPane.add(lbl_borde_pista_1);

        JLabel lbl_pasto = new JLabel("");
        lbl_pasto.setIcon(new ImageIcon(Game.class.getResource("/imagenes/arena.jpg")));
        lbl_pasto.setBounds(0, 0, 971, 949);
        contentPane.add(lbl_pasto);

        btn_New_Game_1 = new JButton("");
        btn_New_Game_1.setIcon(new ImageIcon(Game.class.getResource("/imagenes/next_level_1.png")));
        btn_New_Game_1.setRequestFocusEnabled(false);
        btn_New_Game_1.setContentAreaFilled(false);
        btn_New_Game_1.setBorder(null);
        btn_New_Game_1.setBounds(4, 857, 140, 81);
        contentPane.add(btn_New_Game_1);
    }
    private void initJFrame() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1320, 700);
        setLocationRelativeTo(null);



    }

    public void btnHome(){
        btn_Home = new JButton("");
        btn_Home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Start start = new Start();
                dispose();
                start.setVisible(true);
                Control.r.updateJsonFile(Control.r.updateRankingJSON(Control.r.calcularRanking()));
            }
        });

        btn_Home.setRolloverIcon(new ImageIcon(Game.class.getResource("/imagenes/home_2.png")));
        btn_Home.setPressedIcon(new ImageIcon(Game.class.getResource("/imagenes/home_press.png")));
        btn_Home.setRequestFocusEnabled(false);
        btn_Home.setContentAreaFilled(false);
        btn_Home.setIcon(new ImageIcon(Game.class.getResource("/imagenes/home_1.png")));
        btn_Home.setBorder(null);
        btn_Home.setBounds(529, 575, 85, 85);
        contentPane.add(btn_Home);
    }

    public void panelNpartida(){

        lbl_partida = new JLabel("Partida # 0");
        lbl_partida.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_partida.setHorizontalTextPosition(SwingConstants.CENTER);
        lbl_partida.setFont(new Font("Ravie", Font.BOLD, 38));
        lbl_partida.setBounds(0, 5, 901, 30);
        contentPane.add(lbl_partida);
    }

    public void panelPuntajes(){
        //PANEL DE PUNTAJES
        panel_game = new JPanel();
        panel_game.setBorder(null);
        panel_game.setBackground(Color.WHITE);
        panel_game.setBounds(930, 0, 390, 700);
        contentPane.add(panel_game);
        panel_game.setLayout(null);

        lbl_border_4 = new JLabel("");
        lbl_border_4.setIcon(new ImageIcon(Game.class.getResource("/imagenes/border_1.png")));
        lbl_border_4.setBounds(896, 0, 22, 315);
        panel_game.add(lbl_border_4);


        //NOMBRES DE LOS JUGADORES
        List<String> nombres = Control.nombresJugadores;

        //JUGADOR 1
        lbl_p1 = new JLabel(nombres.get(0));
        lbl_p1.setForeground(new Color(0, 0, 0));
        lbl_p1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p1.setFont(new Font("Ravie", Font.BOLD, 16));
        lbl_p1.setBounds(28, 15, 163, 22);
        panel_game.add(lbl_p1);

        lbl_tiro_p1 = new JLabel("Tiro #");
        lbl_tiro_p1.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_tiro_p1.setFont(new Font("Ravie", Font.PLAIN, 16));
        lbl_tiro_p1.setBounds(51, 40, 131, 22);
        panel_game.add(lbl_tiro_p1);


        lbl_suma_res_p1 = new JLabel("Puntaje:");
        lbl_suma_res_p1.setFont(new Font("Ravie", Font.PLAIN, 16));
        lbl_suma_res_p1.setBounds(51, 65, 163, 23);
        panel_game.add(lbl_suma_res_p1);

        lbl_suma_res_pa_p1 = new JLabel("<html>Puntaje<br>Acumulado:");
        lbl_suma_res_pa_p1.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_suma_res_pa_p1.setFont(new Font("Ravie", Font.PLAIN, 14));
        lbl_suma_res_pa_p1.setBounds(51, 90, 172, 48);
        panel_game.add(lbl_suma_res_pa_p1);

        img_dado_1 = new JLabel("");
        img_dado_1.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_1.png")));
        img_dado_1.setBounds(55, 150, 50, 52);
        panel_game.add(img_dado_1);

        img_dado_2 = new JLabel("");
        img_dado_2.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_2.png")));
        img_dado_2.setBounds(111, 150, 50, 52);
        panel_game.add(img_dado_2);

        lbl_p1_p = new JLabel("Posici\u00F3n ");
        lbl_p1_p.setFont(new Font("Ravie", Font.PLAIN, 16));
        lbl_p1_p.setBounds(55, 210, 131, 28);
        panel_game.add(lbl_p1_p);


        //JUGADOR 2
        lbl_p2 = new JLabel(nombres.get(1));
        lbl_p2.setForeground(Color.BLACK);
        lbl_p2.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p2.setFont(new Font("Ravie", Font.BOLD, 16));
        lbl_p2.setBounds(206, 15, 163, 22);
        panel_game.add(lbl_p2);

        lbl_tiro_p2 = new JLabel("Tiro #");
        lbl_tiro_p2.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_tiro_p2.setFont(new Font("Ravie", Font.PLAIN, 16));
        lbl_tiro_p2.setBounds(227, 40, 131, 22);
        panel_game.add(lbl_tiro_p2);

        lbl_suma_res_p2 = new JLabel("Puntaje:");
        lbl_suma_res_p2.setFont(new Font("Ravie", Font.PLAIN, 16));
        lbl_suma_res_p2.setBounds(227, 65, 163, 23);
        panel_game.add(lbl_suma_res_p2);

        lbl_suma_res_pa_p2 = new JLabel("<html>Puntaje<br>Acumulado:");
        lbl_suma_res_pa_p2.setFont(new Font("Ravie", Font.PLAIN, 14));
        lbl_suma_res_pa_p2.setBounds(227, 90, 172, 48);
        panel_game.add(lbl_suma_res_pa_p2);

        img_dado_1_p2 = new JLabel("");
        img_dado_1_p2.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_5.png")));
        img_dado_1_p2.setBounds(237, 150, 50, 52);
        panel_game.add(img_dado_1_p2);

        img_dado_2_p2 = new JLabel("");
        img_dado_2_p2.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_2.png")));
        img_dado_2_p2.setBounds(293, 150, 50, 52);
        panel_game.add(img_dado_2_p2);

        lbl_p2_p = new JLabel("Posici\u00F3n ");
        lbl_p2_p.setFont(new Font("Ravie", Font.PLAIN, 16));
        lbl_p2_p.setBounds(231, 210, 131, 28);
        panel_game.add(lbl_p2_p);

        //JUGADOR 3
        lbl_p3 = new JLabel(nombres.get(2));
        lbl_p3.setForeground(Color.BLACK);
        lbl_p3.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p3.setFont(new Font("Ravie", Font.BOLD, 16));
        lbl_p3.setBounds(28, 260, 163, 22);
        panel_game.add(lbl_p3);

        lbl_tiro_p3 = new JLabel("Tiro #");
        lbl_tiro_p3.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_tiro_p3.setFont(new Font("Ravie", Font.PLAIN, 16));
        lbl_tiro_p3.setBounds(51, 285, 131, 22);
        panel_game.add(lbl_tiro_p3);

        lbl_suma_res_p3 = new JLabel("Puntaje:");
        lbl_suma_res_p3.setFont(new Font("Ravie", Font.PLAIN, 16));
        lbl_suma_res_p3.setBounds(51, 310, 163, 23);
        panel_game.add(lbl_suma_res_p3);

        lbl_suma_res_pa_p3 = new JLabel("<html>Puntaje<br>Acumulado:");
        lbl_suma_res_pa_p3.setFont(new Font("Ravie", Font.PLAIN, 14));
        lbl_suma_res_pa_p3.setBounds(51, 335, 172, 48);
        panel_game.add(lbl_suma_res_pa_p3);

        img_dado_1_p3 = new JLabel("");
        img_dado_1_p3.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_3.png")));
        img_dado_1_p3.setBounds(55, 395, 50, 52);
        panel_game.add(img_dado_1_p3);

        img_dado_2_p3 = new JLabel("");
        img_dado_2_p3.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_4.png")));
        img_dado_2_p3.setBounds(111, 395, 50, 52);
        panel_game.add(img_dado_2_p3);

        lbl_p3_p = new JLabel("Posici\u00F3n ");
        lbl_p3_p.setFont(new Font("Ravie", Font.PLAIN, 16));
        lbl_p3_p.setBounds(55, 455, 131, 28);
        panel_game.add(lbl_p3_p);


        //JUGADOR 4
        lbl_p4 = new JLabel(nombres.get(3));
        lbl_p4.setForeground(Color.BLACK);
        lbl_p4.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p4.setFont(new Font("Ravie", Font.BOLD, 16));
        lbl_p4.setBounds(206, 260, 163, 22);
        panel_game.add(lbl_p4);

        lbl_tiro_p4 = new JLabel("Tiro #");
        lbl_tiro_p4.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_tiro_p4.setFont(new Font("Ravie", Font.PLAIN, 16));
        lbl_tiro_p4.setBounds(227, 285, 131, 22);
        panel_game.add(lbl_tiro_p4);

        lbl_suma_res_p4 = new JLabel("Puntaje:");
        lbl_suma_res_p4.setFont(new Font("Ravie", Font.PLAIN, 16));
        lbl_suma_res_p4.setBounds(227, 310, 163, 23);
        panel_game.add(lbl_suma_res_p4);

        lbl_suma_res_pa_p4 = new JLabel("<html>Puntaje<br>Acumulado:");
        lbl_suma_res_pa_p4.setFont(new Font("Ravie", Font.PLAIN, 14));
        lbl_suma_res_pa_p4.setBounds(227, 335, 172, 48);
        panel_game.add(lbl_suma_res_pa_p4);

        img_dado_1_p4 = new JLabel("");
        img_dado_1_p4.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_1.png")));
        img_dado_1_p4.setBounds(237, 395, 50, 52);
        panel_game.add(img_dado_1_p4);

        img_dado_2_p4 = new JLabel("");
        img_dado_2_p4.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_1.png")));
        img_dado_2_p4.setBounds(293, 395, 50, 52);
        panel_game.add(img_dado_2_p4);

        lbl_p4_p = new JLabel("Posici\u00F3n ");
        lbl_p4_p.setFont(new Font("Ravie", Font.PLAIN, 16));
        lbl_p4_p.setBounds(231, 455, 131, 28);
        panel_game.add(lbl_p4_p);

        //JUGADOR 5
        lbl_p5 = new JLabel(nombres.get(4));
        lbl_p5.setForeground(Color.BLACK);
        lbl_p5.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p5.setFont(new Font("Ravie", Font.BOLD, 16));
        lbl_p5.setBounds(28, 505, 163, 22);
        panel_game.add(lbl_p5);

        lbl_tiro_p5 = new JLabel("Tiro #");
        lbl_tiro_p5.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_tiro_p5.setFont(new Font("Ravie", Font.PLAIN, 16));
        lbl_tiro_p5.setBounds(51, 540, 131, 22);
        panel_game.add(lbl_tiro_p5);

        lbl_suma_res_p5 = new JLabel("Puntaje:");
        lbl_suma_res_p5.setFont(new Font("Ravie", Font.PLAIN, 16));
        lbl_suma_res_p5.setBounds(51, 570, 163, 23);
        panel_game.add(lbl_suma_res_p5);

        lbl_suma_res_pa_p5 = new JLabel("<html>Puntaje<br>Acumulado:");
        lbl_suma_res_pa_p5.setFont(new Font("Ravie", Font.PLAIN, 14));
        lbl_suma_res_pa_p5.setBounds(51, 595, 172, 48);
        panel_game.add(lbl_suma_res_pa_p5);

        img_dado_1_p5 = new JLabel("");
        img_dado_1_p5.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_5.png")));
        img_dado_1_p5.setBounds(237, 560, 50, 52);
        panel_game.add(img_dado_1_p5);

        img_dado_2_p5 = new JLabel("");
        img_dado_2_p5.setIcon(new ImageIcon(Game.class.getResource("/imagenes/dado_6.png")));
        img_dado_2_p5.setBounds(293, 560, 50, 52);
        panel_game.add(img_dado_2_p5);

        lbl_p5_p = new JLabel("Posici\u00F3n ");
        lbl_p5_p.setFont(new Font("Ravie", Font.PLAIN, 16));
        lbl_p5_p.setBounds(231, 620, 131, 28);
        panel_game.add(lbl_p5_p);

        //BORDE 1 VERTICAL
        lbl_border_1 = new JLabel("");
        lbl_border_1.setIcon(new ImageIcon(Game.class.getResource("/imagenes/border_1.png")));
        lbl_border_1.setBounds(0, 0, 22, 325);
        panel_game.add(lbl_border_1);

        //BORDE 2 HORIZONTAL
        JLabel lblborder_2 = new JLabel("");
        lblborder_2.setIcon(new ImageIcon(Game.class.getResource("/imagenes/border_2.png")));
        lblborder_2.setBounds(0, 0, 901, 17);
        panel_game.add(lblborder_2);

        //BORDE 3 HORIZONTAL
        JLabel lblborder_3 = new JLabel("");
        lblborder_3.setIcon(new ImageIcon(Game.class.getResource("/imagenes/border_2.png")));
        lblborder_3.setBounds(0, 240, 901, 17);
        panel_game.add(lblborder_3);

        //BORDE 4 VERTICAL
        lbl_table_1 = new JLabel("");
        lbl_table_1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_table_1.setIcon(new ImageIcon(Game.class.getResource("/imagenes/border_table.png")));
        lbl_table_1.setBounds(198, 10, 18, 236);
        panel_game.add(lbl_table_1);

        //BORDE 5 VERTICAL
        JLabel lbl_table_2 = new JLabel("");
        lbl_table_2.setIcon(new ImageIcon(Game.class.getResource("/imagenes/border_table.png")));
        lbl_table_2.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_table_2.setBounds(198, 256, 18, 236);
        panel_game.add(lbl_table_2);

        //BORDE 6 VERTICAL
        JLabel lbl_table_3 = new JLabel("");
        lbl_table_3.setIcon(new ImageIcon(Game.class.getResource("/imagenes/border_table.png")));
        lbl_table_3.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_table_3.setBounds(545, 69, 18, 236);
        panel_game.add(lbl_table_3);

        //BORDE 7 VERTICAL
        JLabel lbl_table_4 = new JLabel("");
        lbl_table_4.setIcon(new ImageIcon(Game.class.getResource("/imagenes/border_table.png")));
        lbl_table_4.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_table_4.setBounds(718, 69, 18, 236);
        panel_game.add(lbl_table_4);

        //BORDE 8 VERTICAL
        JLabel border8 = new JLabel("");
        border8.setIcon(new ImageIcon(Game.class.getResource("/imagenes/border_1.png")));
        border8.setBounds(0, 310, 22, 325);
        panel_game.add(border8);

        //BORDE 11 VERTICAL
        JLabel border11 = new JLabel("");
        border11.setIcon(new ImageIcon(Game.class.getResource("/imagenes/border_1.png")));
        border11.setBounds(368, 0, 22, 325);
        panel_game.add(border11);

        //BORDE 12 HORIZONTAL
        JLabel border12 = new JLabel("");
        border12.setIcon(new ImageIcon(Game.class.getResource("/imagenes/border_2.png")));
        border12.setBounds(0, 485, 901, 17);
        panel_game.add(border12);

        //BORDE 13 VERTICAL
        JLabel border13 = new JLabel("");
        border13.setIcon(new ImageIcon(Game.class.getResource("/imagenes/border_1.png")));
        border13.setBounds(368, 310, 22, 325);
        panel_game.add(border13);

        //BORDE 14 VERTICAL
        JLabel border14 = new JLabel("");
        border14.setIcon(new ImageIcon(Game.class.getResource("/imagenes/border_1.png")));
        border14.setBounds(0, 620, 22, 325);
        panel_game.add(border14);

        //BORDE 15 VERTICAL
        JLabel border15 = new JLabel("");
        border15.setIcon(new ImageIcon(Game.class.getResource("/imagenes/border_1.png")));
        border15.setBounds(368, 620, 22, 325);
        panel_game.add(border15);

        //BORDE 16 HORIZONTAL
        JLabel border16 = new JLabel("");
        border16.setIcon(new ImageIcon(Game.class.getResource("/imagenes/border_2.png")));
        border16.setBounds(0, 650, 901, 17);
        panel_game.add(border16);
    }

    public void panelCarrera(){
        panel_carrera = new JPanel();
        panel_carrera.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_carrera.setBackground(new Color(85, 107, 47));
        panel_carrera.setBounds(20, 45, 901, 522);
        contentPane.add(panel_carrera);
        panel_carrera.setLayout(null);

        lbl_Car_1 = new JLabel("D.T");
        lbl_Car_1.setForeground(Color.YELLOW);
        lbl_Car_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
        lbl_Car_1.setHorizontalTextPosition(SwingConstants.RIGHT);
        lbl_Car_1.setVerticalAlignment(SwingConstants.TOP);
        lbl_Car_1.setIcon(new ImageIcon(Game.class.getResource("/imagenes/car_marron.png")));
        lbl_Car_1.setBounds(0, 11, 170, 76);
        panel_carrera.add(lbl_Car_1);

        lbl_Car_2 = new JLabel("B.O");
        lbl_Car_2.setForeground(Color.PINK);
        lbl_Car_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
        lbl_Car_2.setHorizontalTextPosition(SwingConstants.RIGHT);
        lbl_Car_2.setIcon(new ImageIcon(Game.class.getResource("/imagenes/car_super.png")));
        lbl_Car_2.setBounds(0, 112, 170, 88);
        panel_carrera.add(lbl_Car_2);

        lbl_Meta = new JLabel("");
        lbl_Meta.setIcon(null);
        lbl_Meta.setBounds(831, 0, 70, 511);
        panel_carrera.add(lbl_Meta);

        lbl_Car_3 = new JLabel("L.O");
        lbl_Car_3.setForeground(Color.ORANGE);
        lbl_Car_3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
        lbl_Car_3.setHorizontalTextPosition(SwingConstants.RIGHT);
        lbl_Car_3.setIcon(new ImageIcon(Game.class.getResource("/imagenes/car_convertible.png")));
        lbl_Car_3.setBounds(0, 214, 170, 88);
        panel_carrera.add(lbl_Car_3);

        lbl_Car_4 = new JLabel("R.P");
        lbl_Car_4.setForeground(Color.GREEN);
        lbl_Car_4.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
        lbl_Car_4.setHorizontalTextPosition(SwingConstants.RIGHT);
        lbl_Car_4.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Car_4.setIcon(new ImageIcon(Game.class.getResource("/imagenes/car_clasic.png")));
        lbl_Car_4.setBounds(0, 322, 170, 76);
        panel_carrera.add(lbl_Car_4);

        lbl_Car_5 = new JLabel("T.P");
        lbl_Car_5.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Car_5.setForeground(Color.CYAN);
        lbl_Car_5.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
        lbl_Car_5.setHorizontalTextPosition(SwingConstants.RIGHT);
        lbl_Car_5.setIcon(new ImageIcon(Game.class.getResource("/imagenes/car_red.png")));
        lbl_Car_5.setBounds(0, 423, 170, 88);
        panel_carrera.add(lbl_Car_5);

        pista = new JLabel("");
        pista.setHorizontalTextPosition(SwingConstants.RIGHT);
        pista.setIcon(new ImageIcon(Game.class.getResource("/imagenes/pista_!.jpg")));
        pista.setBounds(0, 0, 901, 522);
        panel_carrera.add(pista);
    }

    private void InitComponents() {
        contentPane = new JPanel();
        contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        contentPane.setBackground(new Color(60, 179, 113));
        contentPane.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(240, 240, 240), new Color(255, 255, 255), new Color(105, 105, 105), new Color(160, 160, 160)), new LineBorder(new Color(180, 180, 180))));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        panelNpartida();
       btnHome();
       panelPuntajes();
       panelCarrera();

    }
}