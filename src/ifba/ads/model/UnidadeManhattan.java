package ifba.ads.model;

public class UnidadeManhattan extends UnidadeMovel{

	public UnidadeManhattan(String id, float latitude, float longitude, ConfiguracaoDaUnidade configuracao) {
		super(id, latitude, longitude, configuracao);
	}

	@Override
	public float distanciaEntreOrigemEDestino(float latitudeDestino, float longitudeDestino) {
		long obterValorQuadradoLatitude = (long) Math.pow((latitudeDestino - this.getLatitude()),2);
		long obterValorQuadradoLongitude = (long) Math.pow((latitudeDestino - this.getLongitude()),2);
		
		return obterValorQuadradoLatitude - obterValorQuadradoLongitude;
	}


}
