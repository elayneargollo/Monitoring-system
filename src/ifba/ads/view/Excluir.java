package ifba.ads.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import ifba.ads.model.Monitorar;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Excluir extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static MenuBar menuBar;
	private Monitorar areaMonitorada;
	private JTextField idDaUnidade;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Excluir frame = new Excluir();
					menuBar = new MenuBar(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Excluir() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setTitle("Deletar");
		
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(250, 250));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);
		
		pack();
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Deletar Unidade", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 25, 230, 150);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("ID :");
		
		idDaUnidade = new JTextField();
		idDaUnidade.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Insira a informa\u00E7\u00E3o da unidade\r\n");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(37)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(idDaUnidade, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
					.addGap(15))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel_1)
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(idDaUnidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9))
		);
		panel.setLayout(gl_panel);
		
			
		JButton btnNewButton = new JButton("Deletar\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				areaMonitorada = new Monitorar();
				
				if(areaMonitorada.deletar(getId()) == 1) {
					JOptionPane.showMessageDialog(null, "Unidade excluida.");
				} else {
					JOptionPane.showMessageDialog(null, "Não é possível excluir.");
				}
				
				setVisible(false);	
				System.exit(0);
			}
		});
		
		btnNewButton.setBounds(10, 186, 219, 23);
		contentPane.add(btnNewButton);
	}
	
	public String getId() {
		return idDaUnidade.getText();
	}
}

