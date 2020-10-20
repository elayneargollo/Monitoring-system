import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Spliterator;

import ifba.ads.controll.UnidadeMovelDAO;

public class LerArquivo {
	
	/*
	
	public static void main(String args[]) throws IOException {
		
			ArrayList<String> dados = new ArrayList();
		
			FileInputStream arquivo = new FileInputStream("UnidadeMovel-Conf.txt");
			InputStreamReader imput = new InputStreamReader(arquivo);
			BufferedReader br = new BufferedReader(imput);
			
			System.out.println("------ TESTANDO ------");
			
			Integer DocsCounter = 1;
			String row;
			
			
			for (row = br.readLine(), DocsCounter = 1; row != null; DocsCounter++, row = br.readLine()) {
				dados.add(row);						
				
			}
			
			
			System.out.println(dados);
			
			System.out.println("------ QUEBRANDO ------");
			
			String persistencia= dados.get(0); 
			String logica= dados.get(1);
			String ui= dados.get(2);

	
		} */
	
		public static Properties getProp() throws IOException
		{
			Properties props = new Properties();
			FileInputStream file = new FileInputStream("./properties/UnidadeMovel-conf.properties");
			props.load(file);
			return props;
       
		}
   
		public static void main(String args[]) throws IOException
		{
			System.out.println("======= TESTANDO Arquivo Properties =======");
			Properties prop = getProp();
			System.out.println("UI = "+prop.getProperty("UI"));
			System.out.println("LOGICA = "+prop.getProperty("LOGICA"));
			System.out.println("PERSISTENCIA = "+prop.getProperty("PERSISTENCIA"));

		}
				
}


