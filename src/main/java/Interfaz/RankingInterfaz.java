package Interfaz;

import Gestion.Gestion_Reloj;

import control.Ranking;
import model.Dados;
import model.Jugador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Comparator;
import java.util.List;


public class RankingInterfaz extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -3149039581740401107L;
    private JPanel panelPrincipal;
    private JButton btn_back;
    private JLabel principal_title;
    //public static List<Jugador> jugadores = new Ranking().rankingJsonToArrayList();
    //public static List<Jugador> jugadores = Dados.jugadores;
    public static List<Jugador> jugadores = Start.jugadores;
    private static JLabel lblhora;
    private static JLabel lblhora_p2;
    private static JLabel lblhora_p3;
    private static JLabel lblhora_p4;
    private static JLabel lblhora_p5;



    public RankingInterfaz(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(Start.class.getResource("/imagenes/logo_game.png")));
        setTitle("Ranking Fast & Furios");
        initComponents();
    }

    private void subTitle(){
        //POSICION
        JLabel pos = new JLabel("POS");
        pos.setForeground(Color.WHITE);
        pos.setBounds(30, 70, 50, 30);
        pos.setFont(new Font("Ravie", Font.PLAIN, 20));
        panelPrincipal.add(pos);

        //NOMBRE
        JLabel name = new JLabel("NOMBRE");
        name.setForeground(Color.WHITE);
        //20px de espacio entre cada uno en x
        name.setBounds(100, 70, 120, 30);
        name.setFont(new Font("Ravie", Font.PLAIN, 20));
        panelPrincipal.add(name);

        //#LANZAMIENTOS
        JLabel nLanza = new JLabel("#LANZAMIENTOS");
        nLanza.setForeground(Color.WHITE);
        //20px de espacio entre cada uno en x
        nLanza.setBounds(280, 70, 200, 30);
        nLanza.setFont(new Font("Ravie", Font.PLAIN, 20));
        panelPrincipal.add(nLanza);

        //#PARTIDAS
        JLabel nPartidas = new JLabel("#PARTIDAS");
        nPartidas.setForeground(Color.WHITE);
        //20px de espacio entre cada uno en x
        nPartidas.setBounds(480, 70, 200, 30);
        nPartidas.setFont(new Font("Ravie", Font.PLAIN, 20));
        panelPrincipal.add(nPartidas);

        //PAIS
        JLabel country = new JLabel("PAIS");
        country.setForeground(Color.WHITE);
        country.setBounds(670, 70, 100, 30);
        country.setFont(new Font("Ravie", Font.PLAIN, 20));
        panelPrincipal.add(country);

        //TOTAL SCORE
        JLabel tScore = new JLabel("PUNTAJE GENERAL");
        tScore.setForeground(Color.WHITE);
        tScore.setBounds(763, 70, 260, 30);
        tScore.setFont(new Font("Ravie", Font.PLAIN, 20));
        panelPrincipal.add(tScore);

        //HORA
        JLabel hora = new JLabel("HORA");
        hora.setForeground(Color.WHITE);
        hora.setBounds(1005, 70, 164, 30);
        hora.setFont(new Font("Ravie", Font.PLAIN, 20));
        hora.setHorizontalAlignment(SwingConstants.CENTER);
        panelPrincipal.add(hora);
    }

    //IMPRIMIR DATOS DE CADA JUGADOR POR FILA
    public void fila(Jugador j, int y){
        //POSICION
        JLabel pos = new JLabel(String.valueOf(j.getPosGeneral()));
        pos.setForeground(Color.WHITE);
        pos.setBounds(30, y, 50, 30);
        pos.setFont(new Font("Ravie", Font.PLAIN, 20));
        panelPrincipal.add(pos);

        //NOMBRE
        JLabel name = new JLabel(j.getName());
        name.setForeground(Color.WHITE);
        //20px de espacio entre cada uno en x
        name.setBounds(100, y, 300, 30);
        name.setFont(new Font("Ravie", Font.PLAIN, 20));
        panelPrincipal.add(name);

        //#LANZAMIENTOS
        JLabel nLanza = new JLabel(String.valueOf(j.getnLanzamientos()));
        nLanza.setForeground(Color.WHITE);
        //20px de espacio entre cada uno en x
        nLanza.setBounds(330, y, 200, 30);
        nLanza.setFont(new Font("Ravie", Font.PLAIN, 20));
        panelPrincipal.add(nLanza);

        //#PARTIDAS
        JLabel nPartidas = new JLabel(String.valueOf(j.getnPartidas()));
        nPartidas.setForeground(Color.WHITE);
        //20px de espacio entre cada uno en x
        nPartidas.setBounds(530, y, 200, 30);
        nPartidas.setFont(new Font("Ravie", Font.PLAIN, 20));
        panelPrincipal.add(nPartidas);

        //PAIS
        JLabel country = new JLabel(j.getCountry());
        country.setForeground(Color.WHITE);
        country.setBounds(670, y, 100, 30);
        country.setFont(new Font("Ravie", Font.PLAIN, 20));
        panelPrincipal.add(country);

        //TOTAL SCORE
        JLabel tScore = new JLabel(String.valueOf(j.getTotalScore()));
        tScore.setHorizontalAlignment(SwingConstants.CENTER);
        tScore.setForeground(Color.WHITE);
        tScore.setBounds(785, y, 260, 30);
        tScore.setFont(new Font("Ravie", Font.PLAIN, 20));
        panelPrincipal.add(tScore);


    }


    private void title(){
        principal_title = new JLabel("RANKING");
        principal_title.setHorizontalAlignment(SwingConstants.CENTER);
        principal_title.setHorizontalTextPosition(SwingConstants.CENTER);
        principal_title.setFont(new Font("Ravie", Font.BOLD, 38));
        principal_title.setForeground(Color.WHITE);
        principal_title.setBounds(0, 20, 1200, 52);
        panelPrincipal.add(principal_title);
    }

    private void btn_Back(){
        btn_back = new JButton("");
        btn_back.setRolloverIcon(new ImageIcon(Game.class.getResource("/imagenes/home_2.png")));
        btn_back.setPressedIcon(new ImageIcon(Game.class.getResource("/imagenes/home_press.png")));
        btn_back.setRequestFocusEnabled(false);
        btn_back.setContentAreaFilled(false);
        btn_back.setIcon(new ImageIcon(Game.class.getResource("/imagenes/home_1.png")));
        btn_back.setBorder(null);
        btn_back.setBounds(1058, 542, 85, 85);


        btn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Start start = new Start();
                start.setVisible(true);
                dispose();
            }
        });

        panelPrincipal.add(btn_back);
    }

    private void reloj(){

        Thread reloj1 = new Thread(new Gestion_Reloj(lblhora, jugadores.get(0).getCountry()));
        Thread reloj2 = new Thread(new Gestion_Reloj(lblhora_p2,jugadores.get(1).getCountry()));
        Thread reloj3 = new Thread(new Gestion_Reloj(lblhora_p3,jugadores.get(2).getCountry()));
        Thread reloj4 = new Thread(new Gestion_Reloj(lblhora_p4,jugadores.get(3).getCountry()));
        Thread reloj5 = new Thread(new Gestion_Reloj(lblhora_p5,jugadores.get(4).getCountry()));

        reloj1.start();
        reloj2.start();
        reloj3.start();
        reloj4.start();
        reloj5.start();

    }
    private void initComponents() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1200, 675);
        setLocationRelativeTo(null);
        panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.BLACK);
        panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelPrincipal);
        panelPrincipal.setLayout(null);
        btn_Back();
        title();
        subTitle();

        jugadores.sort(new Comparator<Jugador>() {
            @Override
            public int compare(Jugador o1, Jugador o2) {
                String pos1 = String.valueOf(o1.getPosGeneral());
                String pos2 = String.valueOf(o2.getPosGeneral());
                return pos1.compareTo(pos2);
            }
        });
        fila(jugadores.get(0), 110);
        fila(jugadores.get(1), 210);
        fila(jugadores.get(2), 310);
        fila(jugadores.get(3), 410);
        fila(jugadores.get(4), 510);

        lblhora = new JLabel("00:00:00");
        lblhora.setFont(new Font("Papyrus", Font.ITALIC, 19));
        lblhora.setForeground(Color.ORANGE);
        lblhora.setBounds(1058, 108, 111, 30);
        panelPrincipal.add(lblhora);

        lblhora_p2 = new JLabel("00:00:00");
        lblhora_p2.setFont(new Font("Papyrus", Font.ITALIC, 19));
        lblhora_p2.setForeground(Color.ORANGE);
        lblhora_p2.setBounds(1058, 208, 111, 30);
        panelPrincipal.add(lblhora_p2);

        lblhora_p3 = new JLabel("00:00:00");
        lblhora_p3.setFont(new Font("Papyrus", Font.ITALIC, 19));
        lblhora_p3.setForeground(Color.ORANGE);
        lblhora_p3.setBounds(1058, 307, 111, 30);
        panelPrincipal.add(lblhora_p3);

        lblhora_p4 = new JLabel("00:00:00");
        lblhora_p4.setFont(new Font("Papyrus", Font.ITALIC, 19));
        lblhora_p4.setForeground(Color.ORANGE);
        lblhora_p4.setBounds(1058, 404, 111, 30);
        panelPrincipal.add(lblhora_p4);

        lblhora_p5 = new JLabel("00:00:00");
        lblhora_p5.setFont(new Font("Papyrus", Font.ITALIC, 19));
        lblhora_p5.setForeground(Color.ORANGE);
        lblhora_p5.setBounds(1058, 501, 111, 30);
        panelPrincipal.add(lblhora_p5);

        JButton btn_back_1 = new JButton();
        btn_back_1.setRequestFocusEnabled(false);
        btn_back_1.setContentAreaFilled(false);
        btn_back_1.setBorderPainted(false);
        btn_back_1.setBorder(null);
        btn_back_1.setBounds(801, 539, 140, 97);
        panelPrincipal.add(btn_back_1);

        reloj();
    }



    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }


    public JButton getBtn_back() {
        return btn_back;
    }
}