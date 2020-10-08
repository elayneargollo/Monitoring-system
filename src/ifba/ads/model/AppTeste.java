package ifba.ads.model;

import java.sql.SQLException;

import ifba.ads.controll.H2unidadeMovel;

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

		UnidadeMovel unidade = new UnidadeEuclidiana("teste", 4, 2, configuracao);
		UnidadeMovel unidade3 = new UnidadeEuclidiana("teste3", 3, 2, configuracao);
		UnidadeMovel unidadeM = new UnidadeManhattan("teste2", 42, 24, configuracao2);

		Monitorar areaMonitorada = new Monitorar();

		System.out.println("=> "+areaMonitorada.unidadeMovelMaisProxima(7, 5, true, false, true, false));

	}

}
