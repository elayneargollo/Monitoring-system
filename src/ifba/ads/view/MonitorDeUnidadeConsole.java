package ifba.ads.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import ifba.ads.model.UnidadeMovelLogica;

public class MonitorDeUnidadeConsole implements UnidadeMovelUI {

	private MonitorDeUnidade unidade;
	private UnidadeMovelLogica unidadeLogica;

	public MonitorDeUnidadeConsole() throws Exception {
		this.unidade = null;
	}

	@Override
	public void setLogica(UnidadeMovelLogica logica) throws Exception {
		this.unidadeLogica = logica;
	}

	@Override
	public void run() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Informe a Latitude:");
        float latitude = Float.parseFloat(br.readLine()); 

		System.out.println("Informe a Longitude da Unidade:");
		float longitude = Float.parseFloat(br.readLine()); 
		  
		int aux = 0;

		boolean unidadeTermometro = false;
		boolean unidadeCameraDeVideo = false;
		boolean unidadeMedidorCO2 = false;
		boolean unidadeMedidorMetano = false;

		while (aux == 0) {

			System.out.println("Deseja Termometro ? (Y/N)");
			String termometro = br.readLine();

			if ((termometro.equalsIgnoreCase("Y")) || (termometro.equalsIgnoreCase("N"))) {
				aux = 1;
				if (termometro.equalsIgnoreCase("Y")) {
					unidadeTermometro = true;
				}
			}

		}

		aux = 0;

		while (aux == 0) {

			System.out.println("Deseja Camera de Video ? (Y/N)");
			String cameraDeVideo = br.readLine();

			if ((cameraDeVideo.equalsIgnoreCase("Y")) || (cameraDeVideo.equalsIgnoreCase("N"))) {
				aux = 1;
				if (cameraDeVideo.equalsIgnoreCase("Y")) {
					unidadeCameraDeVideo = true;
				}
			}

		}

		aux = 0;

		while (aux == 0) {

			System.out.println("Deseja Medidor de CO2 ? (Y/N)");
			String medidorCO2 = br.readLine();

			if ((medidorCO2.equalsIgnoreCase("Y")) || (medidorCO2.equalsIgnoreCase("N"))) {
				aux = 1;
				if (medidorCO2.equalsIgnoreCase("Y")) {
					unidadeMedidorCO2 = true;
				}
			}

		}

		aux = 0;

		while (aux == 0) {

			System.out.println("Deseja Medidor de Metado ? (Y/N)");
			String medidorMetano = br.readLine();

			if ((medidorMetano.equalsIgnoreCase("Y")) || (medidorMetano.equalsIgnoreCase("N"))) {
				aux = 1;
				if (medidorMetano.equalsIgnoreCase("Y")) {
					unidadeMedidorMetano = true;
				}
			}

		}

		this.unidadeLogica.mover(latitude, longitude,unidadeCameraDeVideo,unidadeTermometro,unidadeMedidorCO2,unidadeMedidorMetano);
		
	}

	public static void main(String[] args) throws Exception {
		MonitorDeUnidadeConsole console = new MonitorDeUnidadeConsole();
		console.run();
	}

}