package ifba.ads.model;

import ifba.ads.controll.UnidadeMovelDAO;

public class AppUnidade implements UnidadeMovelLogica {
	
	private UnidadeMovelDAO unidadeDAO;	
	private ConfiguracaoDaUnidade configuracao = new ConfiguracaoDaUnidade();

	public AppUnidade() {
		
	}
	
	public void addUnidadeMovelEuclidiana(String id, float latitude, float longitude, boolean cameraDeVideo, 
						boolean termometro, boolean medidorDeCo2, boolean medidorDeMetano) {

		configuracao.adicionarEquipamentosAUnidade(cameraDeVideo, termometro, medidorDeCo2, medidorDeMetano);
		UnidadeEuclidiana unidade = new UnidadeEuclidiana(id, latitude, longitude, configuracao);
		this.unidadeDAO.inserir(unidade);
		
	}
	
	public void addUnidadeMovelManhattan(String id, float latitude, float longitude, boolean cameraDeVideo, 
					boolean termometro, boolean medidorDeCo2, boolean medidorDeMetano) {
		
		configuracao.adicionarEquipamentosAUnidade(cameraDeVideo, termometro, medidorDeCo2, medidorDeMetano);
		UnidadeManhattan unidade = new UnidadeManhattan();
		this.unidadeDAO.inserir(unidade);
	}


	@Override
	public void mover(float latitude, float longitude, boolean cameraDeVideo, 
			boolean termometro, boolean medidorDeCo2, boolean medidorDeMetano) {
		
		Monitorar monitor = new Monitorar();
		String resposta = (monitor.unidadeMovelMaisProxima(latitude, longitude,	cameraDeVideo,termometro,medidorDeCo2,medidorDeMetano));
		
		System.out.println(resposta);
		
	}
	
	@Override
	public void setPersistencia(UnidadeMovelDAO persistencia) throws Exception {
		this.unidadeDAO = persistencia;		
	}

}
