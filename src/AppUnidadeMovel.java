import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Spliterator;

import ifba.ads.controll.UnidadeMovelDAO;

public class AppUnidadeMovel {

	public static void main(String args[]) throws IOException {

		Properties prop = getProp();
		
		System.out.println("UI = " + prop.getProperty("UI"));
		System.out.println("LOGICA = " + prop.getProperty("LOGICA"));
		System.out.println("PERSISTENCIA = " + prop.getProperty("PERSISTENCIA"));

	}
	
	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/UnidadeMovel-conf.properties");
		props.load(file);
		return props;

	}

}
