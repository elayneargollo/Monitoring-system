package ifba.ads.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Versao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static MenuBar menuBar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Versao frame = new Versao();
					menuBar = new MenuBar(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Versao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		setTitle("Versão");
		
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(250, 220));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);
		
		pack();
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Versão", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(31, 43, 194, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea txtrVerso = new JTextArea();
		txtrVerso.setEditable(false);
		txtrVerso.setBackground(SystemColor.control);
		txtrVerso.setText("0.2.1 - SNAPSHOT");
		txtrVerso.setBounds(38, 29, 138, 22);
		panel.add(txtrVerso);
		
		JButton btnEncerrar = new JButton("Ok");
		btnEncerrar.setBounds(87, 151, 89, 23);
		contentPane.add(btnEncerrar);
		
		btnEncerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
	}
}
