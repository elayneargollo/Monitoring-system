package ifba.ads.model;

public class AppTeste {

	public static void main(String[] args) {

		/* Instanciando algumas configurações possiveis */

		ConfiguracaoDaUnidade configuracao = new ConfiguracaoDaUnidade();
		ConfiguracaoDaUnidade configuracao2 = new ConfiguracaoDaUnidade();
		ConfiguracaoDaUnidade configuracao3 = new ConfiguracaoDaUnidade();

		/* Adicionando equipaento as essas configurações */

		configuracao.adicionarEquipamentosAUnidade(EquipamentoEnum.CAMERADEVIDEO);
		configuracao.adicionarEquipamentosAUnidade(EquipamentoEnum.MEDIDORDEC02);
		configuracao2.adicionarEquipamentosAUnidade(EquipamentoEnum.MEDIDORDEC02);
		configuracao3.adicionarEquipamentosAUnidade(EquipamentoEnum.CAMERADEVIDEO);

		/* Instanciando unidades moveis */

		UnidadeMovel unidade = new UnidadeEuclidiana("teste", 4, 2, configuracao);
		UnidadeMovel unidade3 = new UnidadeEuclidiana("teste3", 4, 2, configuracao3);
		UnidadeMovel unidadeM = new UnidadeManhattan("teste2", 42, 24, configuracao2);

		/* Instanciando uma area que sera monitorada */

		AreaMonitorada areaMonitorada = new AreaMonitorada();

		/* Insiro na area monitora minhas unidades moveis disponiveis */

		areaMonitorada.inserirUnidades(unidade);
		areaMonitorada.inserirUnidades(unidadeM);
		areaMonitorada.inserirUnidades(unidade3);

		/* Monitoro a área */

		System.out.println(areaMonitorada.monitorar(7, 5, true, false, false, false));

	}

}
