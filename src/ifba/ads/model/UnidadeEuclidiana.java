package ifba.ads.model;

public class UnidadeEuclidiana extends UnidadeMovel{

	
	public UnidadeEuclidiana(String id, float latitude, float longitude, ConfiguracaoDaUnidade configuracao) {
		super(id, latitude, longitude, configuracao);
	}

	@Override
	public float distanciaEntreOrigemEDestino(float latitudeDestino, float longitudeDestino) {
		long obterValorQuadradoLatitude = (long) Math.pow((latitudeDestino - this.getLatitude()),2);
		long obterValorQuadradoLongitude = (long) Math.pow((longitudeDestino - this.getLongitude()),2);
		
		return (float) Math.sqrt(obterValorQuadradoLatitude + obterValorQuadradoLongitude);
	
	}

}
