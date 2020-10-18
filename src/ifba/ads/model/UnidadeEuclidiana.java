package ifba.ads.model;

public class UnidadeEuclidiana extends UnidadeMovel {

	public UnidadeEuclidiana(String id, float latitude, float longitude, ConfiguracaoDaUnidade configuracao) {
		super(id, latitude, longitude, configuracao);
	}
	
	public UnidadeEuclidiana() {
		
	}

	@Override
	public float getDistancia(float latitudeDestino, float longitudeDestino) {

		float distancia;
		distancia = (float) Math.sqrt(Math.pow((latitudeDestino - this.getLatitude()), 2)
						+ Math.pow((longitudeDestino - this.getLongitude()), 2));

		return distancia;

	}

}
