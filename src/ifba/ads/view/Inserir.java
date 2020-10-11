package ifba.ads.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import ifba.ads.model.Monitorar;

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

	private JTextField latitude;
	private JTextField longitude;
	private JCheckBox cameraDeVideo;
	private JCheckBox medidorCO2;
	private JCheckBox medidorMetano;
	private JCheckBox termometro;
	private JPanel start;
	private static MenuBar menuBar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inserir frame = new Inserir();
					menuBar = new MenuBar(frame);
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
		start.setPreferredSize(new Dimension(250, 360));
		getContentPane().add(start, BorderLayout.CENTER);
		start.setLayout(null);

		JPanel equipamento = new JPanel();
		equipamento.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Equipamentos",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		equipamento.setBounds(23, 137, 213, 139);
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

		JPanel localizacao = new JPanel();
		localizacao.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Localiza\u00E7\u00E3o",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		localizacao.setBounds(23, 28, 213, 87);
		start.add(localizacao);
		localizacao.setLayout(null);

		JLabel lblLatitude = new JLabel("Latitude");
		lblLatitude.setBounds(10, 24, 60, 15);
		localizacao.add(lblLatitude);

		latitude = new JTextField();
		latitude.setBounds(75, 22, 114, 19);
		;
		localizacao.add(latitude);
		latitude.setColumns(10);

		JLabel lblLongitude = new JLabel("Longitude");
		lblLongitude.setBounds(10, 51, 79, 15);
		localizacao.add(lblLongitude);

		longitude = new JTextField();
		longitude.setBounds(97, 49, 92, 19);
		localizacao.add(longitude);
		longitude.setColumns(10);

		JButton btnMover = new JButton("Mover");
		btnMover.setBounds(23, 296, 213, 25);
		start.add(btnMover);
		pack();
		setLocationRelativeTo(null);

		btnMover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "tem q terminar");
			}
		});

		setVisible(true);

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

	public float getLongitude() {
		return Float.parseFloat(this.longitude.getText());
	}

	public float getLatitude() {
		return Float.parseFloat(this.latitude.getText());
	}

}
