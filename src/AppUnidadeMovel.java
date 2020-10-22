import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import ifba.ads.controll.UnidadeMovelDAO;
import ifba.ads.model.UnidadeMovelLogica;
import ifba.ads.view.UnidadeMovelUI;

public class AppUnidadeMovel {

	private static UnidadeMovelUI ui;
	private static UnidadeMovelLogica logica;
	private static UnidadeMovelDAO persistencia;

	public static void main(String args[]) throws Exception {
		init();
	}

	public static void init() throws Exception {

		Properties propriedade = getProp();

		logica = (UnidadeMovelLogica) (Class.forName((String) propriedade.get("LOGICA")).newInstance());
		ui = (UnidadeMovelUI) (Class.forName((String) propriedade.get("UI")).newInstance());
		persistencia = (UnidadeMovelDAO) (Class.forName((String) propriedade.get("PERSISTENCIA")).newInstance());
		
		logica.setPersistencia(persistencia);
		ui.setLogica(logica);
		ui.run();

	}

	public static Properties getProp() throws IOException {

		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/UnidadeMovel-conf.properties");
		props.load(file);

		return props;

	}

}
