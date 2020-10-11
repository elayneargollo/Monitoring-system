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
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MonitorDeUnidade extends JFrame {

	private JTextField txtLatitude;
	private JTextField txtLongitude;
	private Monitorar areaMonitorada;
	private JCheckBox cameraDeVideo;
	private JCheckBox medidorCO2;
	private JCheckBox medidorMetano;
	private JCheckBox termometro;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonitorDeUnidade frame = new MonitorDeUnidade();
					frame.menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MonitorDeUnidade() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		setTitle("Monitoramento de Unidade Móvel");

		JPanel painel = new JPanel();
		painel.setPreferredSize(new Dimension(500, 360));
		getContentPane().add(painel, BorderLayout.CENTER);
		painel.setLayout(null);

		JPanel equipamento = new JPanel();
		equipamento.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Equipamentos",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		equipamento.setBounds(23, 137, 213, 139);
		painel.add(equipamento);
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
		painel.add(localizacao);
		localizacao.setLayout(null);

		JLabel lblLatitude = new JLabel("Latitude");
		lblLatitude.setBounds(10, 24, 60, 15);
		localizacao.add(lblLatitude);

		txtLatitude = new JTextField();
		txtLatitude.setBounds(75, 22, 114, 19);
		;
		localizacao.add(txtLatitude);
		txtLatitude.setColumns(10);

		JLabel lblLongitude = new JLabel("Longitude");
		lblLongitude.setBounds(10, 51, 79, 15);
		localizacao.add(lblLongitude);

		txtLongitude = new JTextField();
		txtLongitude.setBounds(97, 49, 92, 19);
		localizacao.add(txtLongitude);
		txtLongitude.setColumns(10);

		JButton btnMover = new JButton("Mover");
		btnMover.setBounds(23, 296, 213, 25);
		painel.add(btnMover);
		pack();
		setLocationRelativeTo(null);

		btnMover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				areaMonitorada = new Monitorar();
				System.out.println(areaMonitorada.unidadeMovelMaisProxima(getLongitude(), getLatitude(), getCamera(),
						getTermomentro(), getMedidorC02(), getMedidorMetano()));

			}
		});

		setVisible(true);
	}

	public boolean getCamera() {
		return cameraDeVideo.isSelected();
	}

	public boolean getMedidorC02() {
		return medidorCO2.isSelected();
	}

	public boolean getTermomentro() {
		return termometro.isSelected();
	}

	public boolean getMedidorMetano() {
		return medidorMetano.isSelected();
	}

	public float getLongitude() {
		return Float.parseFloat(txtLongitude.getText());
	}

	public float getLatitude() {
		return Float.parseFloat(txtLatitude.getText());
	}

	public void menu() {

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnUnidades = new JMenu("Unidades");
		menuBar.add(mnUnidades);

		JMenuItem mntmBuscar = new JMenuItem("Buscar");
		mnUnidades.add(mntmBuscar);

		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);

		JMenuItem mntmVerso = new JMenuItem("Versão");
		mnSobre.add(mntmVerso);

		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mnSobre.add(mntmAjuda);

	}

}
