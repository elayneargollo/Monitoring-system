package ifba.ads.model;

public interface ComandarMonitoramento {

	public String monitorar(float latitude, float longitude, boolean cameraDeVideo, boolean termometro, boolean MedidordeCo2,
			boolean medidorDeMetano);
	public void atualizarLocalizacao(UnidadeMovel unidade, float latitude, float longitude);
	public void inserirUnidades(UnidadeMovel unidade);
	
}
