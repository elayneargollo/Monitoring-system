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

		JMenuItem inserirOpcao = new JMenuItem("Inserir");
		unidadesMenu.add(inserirOpcao);
		
		inserirOpcao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inserir obj = new Inserir();
				obj.main(null);
			}
		});
		
		JMenuItem excluirOpcao = new JMenuItem("Deletar");
		unidadesMenu.add(excluirOpcao);
		
		
		excluirOpcao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Excluir obj = new Excluir();
				obj.main(null);
			}
		});
		
		JMenuItem buscarOpcao = new JMenuItem("Buscar");
		unidadesMenu.add(buscarOpcao);
		
		buscarOpcao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buscar obj = new Buscar();
				obj.main(null);
			}
		});
		
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
