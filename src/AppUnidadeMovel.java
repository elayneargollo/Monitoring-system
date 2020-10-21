import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Spliterator;

import ifba.ads.controll.UnidadeMovelDAO;
import ifba.ads.model.UnidadeMovelLogica;
import ifba.ads.view.UnidadeMovelUI;


public class AppUnidadeMovel {
	
	private UnidadeMovelUI ui;
	private UnidadeMovelLogica logica;
	private UnidadeMovelDAO persistencia;
	
	
	/*
	public void loadClasses(String fileConfName) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		Properties prop= getProp();;
		
		this.persistencia = (UnidadeMovelDAO) (Class.forName((String) prop.getProperty("PERSISTENCIA")).newInstance());
		this.logica=  (UnidadeMovelLogica) (Class.forName((String) prop.getProperty("LOGICA")).newInstance());
		this.ui=  (UnidadeMovelUI) (Class.forName((String)prop.getProperty("UI")).newInstance());
		

		System.out.println(persistencia);
		System.out.println(logica);
		System.out.println(ui);
		
	}

	
	public void asm(String fileConfName) throws Exception {
		this.loadClasses(fileConfName);
		this.logica.setPersistencia(this.persistencia);
		this.ui.setLogica(this.logica);
		this.ui.run();
	}*/


	public static void main(String[] args) throws Exception {

		Properties prop = getProp();
		
		System.out.println("UI = " + prop.getProperty("UI"));
		System.out.println("LOGICA = " + prop.getProperty("LOGICA"));
		System.out.println("PERSISTENCIA = " + prop.getProperty("PERSISTENCIA")); 
		
		//(new AppUnidadeMovel()).asm(args[0]);

		
	

	}
	
	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/UnidadeMovel-conf.properties");
		props.load(file);
		return props;

	}

}



