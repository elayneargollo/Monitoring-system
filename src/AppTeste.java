import java.sql.SQLException;

import ifba.ads.controll.H2Waiter;
import ifba.ads.model.AreaMonitorada;
import ifba.ads.model.ConfiguracaoDaUnidade;
import ifba.ads.model.EquipamentoEnum;
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

		UnidadeMovel unidade = new UnidadeEuclidiana("teste", 4, 2, configuracao);
		UnidadeMovel unidade3 = new UnidadeEuclidiana("teste3", 3, 2, configuracao);
		UnidadeMovel unidadeM = new UnidadeManhattan("teste2", 42, 24, configuracao2);

		AreaMonitorada areaMonitorada = new AreaMonitorada();
		
		areaMonitorada.inserirUnidades(unidadeM);
		areaMonitorada.inserirUnidades(unidade3);
		
		System.out.println("=> "+areaMonitorada.monitorar(7, 5, true, false, true, false));
		
		/* Testes da camada de controll */
		
		H2Waiter service = new H2Waiter();
	
		System.out.println("\nCondicao inicial do banco =>");
		service.inserir(unidadeM);
		service.consultar();	
		
		System.out.println("\nCondicao apos atualizar unidade =>");
		unidadeM.setLatitude(5);
		service.atualizar(unidadeM);
		service.consultar();
		
		System.out.println("\nCondicao apos deletar unidade =>");
		service.deletar(unidadeM);
		service.consultar();

	}

}
