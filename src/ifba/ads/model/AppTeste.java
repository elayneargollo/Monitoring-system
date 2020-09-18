package ifba.ads.model;

public class AppTeste {

	public static void main(String[] args) {

		
		ConfiguracaoDaUnidade configuracao = new ConfiguracaoDaUnidade();
		
		configuracao.adicionarEquipamentosAUnidade(EquipamentoEnum.CAMERADEVIDEO);
		configuracao.adicionarEquipamentosAUnidade(EquipamentoEnum.MEDIDORDEC02);
		
		ConfiguracaoDaUnidade configuracao2 = new ConfiguracaoDaUnidade();
		
		configuracao2.adicionarEquipamentosAUnidade(EquipamentoEnum.MEDIDORDEC02);
		
		ConfiguracaoDaUnidade configuracao3 = new ConfiguracaoDaUnidade();
		configuracao3.adicionarEquipamentosAUnidade(EquipamentoEnum.CAMERADEVIDEO);
		
		
		UnidadeMovel unidade = new UnidadeEuclidiana("teste", 4,2, configuracao);
		UnidadeMovel unidade3 = new UnidadeEuclidiana("teste3", 4,2, configuracao3);		
		UnidadeMovel unidadeM = new UnidadeManhattan("teste2", 42,24, configuracao2);

		AreaMonitorada areaMonitorada = new AreaMonitorada();
		
		areaMonitorada.inserirUnidades(unidade);
		areaMonitorada.inserirUnidades(unidadeM);
		areaMonitorada.inserirUnidades(unidade3);
		
		
		System.out.println(areaMonitorada.monitorar(7, 5, false, false, false, false));

		
	}

	
}
