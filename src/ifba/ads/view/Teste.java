package ifba.ads.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import ifba.ads.model.Monitorar;
import ifba.ads.model.UnidadeMovel;

import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Teste extends JFrame {

	
	private JCheckBox cameraDeVideo;
	private JCheckBox medidorCO2;
	private JCheckBox medidorMetano;
	private JCheckBox termometro;
	
	private JPanel start;
	private static MenuBar menuBar;
	
	private JTextField textLatitude;
	private JTextField textLongitude;
	private JCheckBox unidadeManhattan;
	private JCheckBox unidadeEuclidiana;
	private Monitorar areaMonitorada;
	private JLabel lblID;
	private JTextField textID;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teste frame = new Teste();
					menuBar = new MenuBar(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Teste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		setTitle("Inserir");

		start = new JPanel();
		start.setPreferredSize(new Dimension(250, 460));
		getContentPane().add(start, BorderLayout.CENTER);
		start.setLayout(null);

		JPanel equipamento = new JPanel();
		equipamento.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Equipamentos",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		equipamento.setBounds(23, 231, 213, 139);
		start.add(equipamento);
		equipamento.setLayout(null);

		cameraDeVideo = new JCheckBox("Câmera de Vídeo");
		cameraDeVideo.setBounds(27, 23, 145, 23);
		equipamento.add(cameraDeVideo);

		medidorCO2 = new JCheckBox("Medidor de CO2");
		medidorCO2.setBounds(27, 50, 137, 23);
		equipamento.add(medidorCO2);

		medidorMetano = new JCheckBox("Medidor de Metano");
		medidorMetano.setBounds(27, 78, 163, 23);
		equipamento.add(medidorMetano);

		termometro = new JCheckBox("Termômetro");
		termometro.setBounds(27, 105, 111, 23);
		equipamento.add(termometro);

		JPanel tipoUnidade = new JPanel();
		tipoUnidade.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Tipo de Unidade", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		tipoUnidade.setBounds(23, 133, 213, 87);
		start.add(tipoUnidade);
		tipoUnidade.setLayout(null);
		
		unidadeManhattan = new JCheckBox("Unidade Manhattan");
		unidadeManhattan.setBounds(33, 25, 151, 23);
		tipoUnidade.add(unidadeManhattan);
		
		unidadeEuclidiana = new JCheckBox("Unidade Euclidiana");
		unidadeEuclidiana.setBounds(33, 51, 140, 23);
		tipoUnidade.add(unidadeEuclidiana);
		;

		JButton btnInserir = new JButton("Inserir");
		btnInserir.setBounds(23, 388, 213, 25);
		start.add(btnInserir);
		
				
		JPanel localizacao = new JPanel();
		localizacao.setLayout(null);
		localizacao.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		localizacao.setBounds(23, 11, 213, 111);
		start.add(localizacao);
		
		JLabel lblLatitude_1 = new JLabel("Latitude");
		lblLatitude_1.setBounds(10, 24, 60, 15);
		localizacao.add(lblLatitude_1);
		
		textLatitude = new JTextField();
		textLatitude.setColumns(10);
		textLatitude.setBounds(75, 22, 114, 19);
		localizacao.add(textLatitude);
		
		JLabel lblLongitude_1 = new JLabel("Longitude");
		lblLongitude_1.setBounds(10, 51, 79, 15);
		localizacao.add(lblLongitude_1);
		
		textLongitude = new JTextField();
		textLongitude.setColumns(10);
		textLongitude.setBounds(75, 49, 114, 19);
		localizacao.add(textLongitude);
		
		lblID = new JLabel("ID");
		lblID.setBounds(10, 77, 46, 14);
		localizacao.add(lblID);
		
		textID = new JTextField();
		textID.setBounds(75, 74, 114, 20);
		localizacao.add(textID);
		textID.setColumns(10);
		pack();
		setLocationRelativeTo(null);
		
		btnInserir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
			}
			});
		}
	}
	

