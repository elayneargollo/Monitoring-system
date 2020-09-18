package ifba.ads.model;

public class AppTeste {

	public static void main(String[] args) {

		
		ConfiguracaoDaUnidade configuracao = new ConfiguracaoDaUnidade();
		
		configuracao.adicionarEquipamentosAUnidade(EquipamentoEnum.CAMERADEVIDEO);
		configuracao.adicionarEquipamentosAUnidade(EquipamentoEnum.MEDIDORDEC02);
		
		UnidadeMovel unidade = new UnidadeEuclidiana("teste", 1234,4321, configuracao);
		System.out.println(unidade);
		
		SistemaDeMonitoramento monitoramento = new SistemaDeMonitoramento();
		

	}

}
