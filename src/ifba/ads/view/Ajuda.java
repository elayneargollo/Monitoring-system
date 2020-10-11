package ifba.ads.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Ajuda extends JFrame {

	private JPanel contentPane;
	private static MenuBar menuBar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajuda frame = new Ajuda();
					menuBar = new MenuBar(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ajuda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		setTitle("Ajuda");
		
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(420, 330));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);
		
		pack();
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ajuda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 400, 231);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea txtrVerso = new JTextArea();
		txtrVerso.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtrVerso.setEditable(false);
		txtrVerso.setBackground(SystemColor.control);
		txtrVerso.setText("+ Localiza\u00E7\u00E3o: \r\n\r\nInforme nos campos a localiza\u00E7\u00E3o que deseja.\r\n\r\nLatitude: deve conter o valor da latitude.\r\nLongitude: deve conter o valor da longitude.\r\n\r\n+ Equipamento:\r\n\r\nSelecione os equipamentos necess\u00E1rios para monitorar.\r\n\t");
		txtrVerso.setBounds(10, 29, 380, 179);
		panel.add(txtrVerso);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		btnNewButton.setBounds(166, 264, 89, 23);
		contentPane.add(btnNewButton);
	}
}
