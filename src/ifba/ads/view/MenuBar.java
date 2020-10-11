package ifba.ads.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar {

	public MenuBar(JFrame mainWindow) {

		JMenuBar menu = new JMenuBar();
		mainWindow.setJMenuBar(menu);

		JMenu unidadesMenu = new JMenu("Unidades");
		menu.add(unidadesMenu);

		JMenuItem listarOpcao = new JMenuItem("Listar");
		unidadesMenu.add(listarOpcao);
		
			listarOpcao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Listar obj = new Listar();
					obj.main(null);
				}
			});

		JMenu sobreOpcao = new JMenu("Sobre");
		menu.add(sobreOpcao);

		JMenuItem versaoOpcao = new JMenuItem("Versão");
		sobreOpcao.add(versaoOpcao);
		
			versaoOpcao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Versao obj = new Versao();
					obj.main(null);
				}
			});

		JMenuItem ajudaOpcao = new JMenuItem("Ajuda");
		sobreOpcao.add(ajudaOpcao);
		
		ajudaOpcao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Ajuda obj = new Ajuda();
					obj.main(null);					
				}
			});
	}
}
