package ifba.ads.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MenuBar {

	public MenuBar(JFrame  mainWindow) {

		JMenuBar menuBar = new JMenuBar();
		mainWindow.setJMenuBar(menuBar);
	
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
