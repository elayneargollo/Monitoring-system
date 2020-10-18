package ifba.ads.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import ifba.ads.model.ConfiguracaoDaUnidade;
import ifba.ads.model.Monitorar;
import ifba.ads.model.UnidadeEuclidiana;
import ifba.ads.model.UnidadeManhattan;
import ifba.ads.model.UnidadeMovel;

import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Inserir extends JFrame {
	
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


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inserir frame = new Inserir();
					menuBar = new MenuBar(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inserir() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		setTitle("Inserir");

		start = new JPanel();
		start.setPreferredSize(new Dimension(250, 430));
		getContentPane().add(start, BorderLayout.CENTER);
		start.setLayout(null);

		JPanel equipamento = new JPanel();
		equipamento.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Equipamentos",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		equipamento.setBounds(23, 207, 213, 139);
		start.add(equipamento);
		equipamento.setLayout(null);

		cameraDeVideo = new JCheckBox("C�mera de V�deo");
		cameraDeVideo.setBounds(27, 23, 145, 23);
		equipamento.add(cameraDeVideo);

		medidorCO2 = new JCheckBox("Medidor de CO2");
		medidorCO2.setBounds(27, 50, 137, 23);
		equipamento.add(medidorCO2);

		medidorMetano = new JCheckBox("Medidor de Metano");
		medidorMetano.setBounds(27, 78, 163, 23);
		equipamento.add(medidorMetano);

		termometro = new JCheckBox("Term�metro");
		termometro.setBounds(27, 105, 111, 23);
		equipamento.add(termometro);

		JPanel tipoUnidade = new JPanel();
		tipoUnidade.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Tipo de Unidade", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		tipoUnidade.setBounds(23, 109, 213, 87);
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
		btnInserir.setBounds(23, 357, 213, 25);
		start.add(btnInserir);
		
				
		JPanel localizacao = new JPanel();
		localizacao.setLayout(null);
		localizacao.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Localiza\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		localizacao.setBounds(23, 11, 213, 87);
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
		pack();
		setLocationRelativeTo(null);
		
		btnInserir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(getResponse() > 0) {
					JOptionPane.showMessageDialog(null, "Inserida com sucesso.");
				}else {
					JOptionPane.showMessageDialog(null, "Tente novamente.");
				}
			
			}
		});	
		
	}
	
	public int getResponse() {
	
		int status = 0;
		UnidadeMovel unidade = null;
		areaMonitorada = new Monitorar();

		if (getEuclidiana()) {
			status = 1;
			unidade = new UnidadeEuclidiana();
		} else if(getManhattan()){
			status = 2;
			unidade = new UnidadeManhattan();
		} else {
			return 0;
		}
		
		unidade.setId("nqq");
		unidade.setLatitude(getLatitude());
		unidade.setLongitude(getLongitude());
		
		ConfiguracaoDaUnidade configuracao = new ConfiguracaoDaUnidade();				
		configuracao.adicionarEquipamentosAUnidade(getCamera(), getTermomentro(),getMedidorC02(), getMedidorMetano());
		
		unidade.setConfiguracao(configuracao);
		areaMonitorada.addUnidade(unidade);
		
		return status;
	}

	public boolean getCamera() {
		return this.cameraDeVideo.isSelected();
	}

	public boolean getMedidorC02() {
		return this.medidorCO2.isSelected();
	}

	public boolean getTermomentro() {
		return this.termometro.isSelected();
	}

	public boolean getMedidorMetano() {
		return this.medidorMetano.isSelected();
	}
	
	public boolean getEuclidiana() {
		return this.unidadeEuclidiana.isSelected();
	}
	
	public boolean getManhattan() {
		return this.unidadeManhattan.isSelected();
	}

	public float getLongitude() {
		return Float.parseFloat(this.textLongitude.getText());
	}

	public float getLatitude() {
		return Float.parseFloat(this.textLatitude.getText());
	}

}
