import java.sql.SQLException;

import ifba.ads.controll.H2UNIDADEMOVEL;
import ifba.ads.model.ConfiguracaoDaUnidade;
import ifba.ads.model.EquipamentoEnum;
import ifba.ads.model.Monitorar;
import ifba.ads.model.UnidadeEuclidiana;
import ifba.ads.model.UnidadeManhattan;
import ifba.ads.model.UnidadeMovel;

public class AppTeste {

	public static void main(String[] args) throws SQLException {
		
		/* Configuracao da camada de negocio */

		ConfiguracaoDaUnidade configuracao = new ConfiguracaoDaUnidade();
		ConfiguracaoDaUnidade configuracao2 = new ConfiguracaoDaUnidade();
		ConfiguracaoDaUnidade configuracao3 = new ConfiguracaoDaUnidade();

		configuracao.adicionarEquipamentosAUnidade(EquipamentoEnum.CAMERADEVIDEO);
		configuracao.adicionarEquipamentosAUnidade(EquipamentoEnum.MEDIDORDEC02);
		
		configuracao2.adicionarEquipamentosAUnidade(EquipamentoEnum.MEDIDORDEC02);
		
		configuracao3.adicionarEquipamentosAUnidade(EquipamentoEnum.CAMERADEVIDEO);

		UnidadeMovel unidade = new UnidadeEuclidiana("teste", 3, 2, configuracao);
		UnidadeMovel unidade3 = new UnidadeEuclidiana("teste3", 7, 2, configuracao);
		UnidadeMovel unidadeM = new UnidadeManhattan("teste2", 42, 24, configuracao2);
		
		Monitorar areaMonitorada = new Monitorar();
		areaMonitorada.inserirUnidades(unidade);
		areaMonitorada.inserirUnidades(unidadeM);
		areaMonitorada.inserirUnidades(unidade3);

		System.out.println("=> "+areaMonitorada.monitorar(7, 5, true, false, true, false));	

	}

}
