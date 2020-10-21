package ifba.ads.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import ifba.ads.model.ConfiguracaoDaUnidade;
import ifba.ads.model.UnidadeMovelLogica;

public class MonitorDeUnidadeConsole implements UnidadeMovelUI {
	
		private MonitorDeUnidade unidade;
		private UnidadeMovelLogica unidadeLogica;
		
		public  MonitorDeUnidadeConsole() throws Exception {
			this.unidade = null;		
		}
		

		@Override
		public void setLogica(UnidadeMovelLogica logica) throws Exception {
			this.unidadeLogica = logica;			
		}
		
		public void run() throws Exception {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Informe a latitude:");
			Double latitude = Double.parseDouble(br.readLine());
			
			System.out.println("Informe a longitude da Unidade:");
			Double longitude = Double.parseDouble(br.readLine());
			
			System.out.println("Deseja termometro ? (Y/N)");
			String termometro = br.readLine();
			
			System.out.println("Deseja camera de video ? (Y/N)");
			String cameraDeVideo = br.readLine();
			
			System.out.println("Deseja medidor de CO2 ? (Y/N)");
			String medidorCO2 = br.readLine();
			
			System.out.println("Deseja medidor de metado ? (Y/N)");
			String medidorMetano = br.readLine();
			
		}
		
		public static void main(String[] args) throws Exception {
			MonitorDeUnidadeConsole console = new MonitorDeUnidadeConsole();
			console.run();
		}

}
