package ifba.ads.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MonitorDeUnidadeConsole {
	
		private MonitorDeUnidade unidade;
		
		public  MonitorDeUnidadeConsole() throws Exception {
			this.unidade = null;		
		}
		
		
		public void run() throws Exception {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Informe a localização da Unidade:");
			
			System.out.println("Informe a Configuração da Unidade:");
			
		
			System.out.println("Informe a area que a Unidade sera deslocada:");

		}
		
		public static void main(String[] args) throws Exception {
			MonitorDeUnidadeConsole console = new MonitorDeUnidadeConsole();
			console.run();
		}
}
