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
import javax.swing.border.EtchedBorder;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Teste extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static MenuBar menuBar;
	private Monitorar areaMonitorada;
	ArrayList<UnidadeMovel> unidades;

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
		
		setTitle("Listar");
		
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(420, 330));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);
		
		pack();
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Unidade do Sistema", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 25, 400, 221);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea caixaDeTexto = new JTextArea(getUnidades());
		caixaDeTexto.setEditable(false);
		caixaDeTexto.setBounds(39, 38, 298, 148);
		panel.add(caixaDeTexto);
		
		JScrollPane scrollPane = new JScrollPane(caixaDeTexto);
		scrollPane.setBounds(39, 38, 298, 148);
		panel.add(scrollPane);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	
			}
		});
		
		btnNewButton.setBounds(174, 272, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	public String getUnidades() {
		
		unidades = new Monitorar().buscarUnidadesH2();		
		String str = "\n";
		
		for (int i=0; i<unidades.size(); i++) {
			str += unidades.get(i) + "\n";
		}
		
		return str;
	}
}

