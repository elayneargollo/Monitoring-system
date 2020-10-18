package ifba.ads.model;

public class UnidadeManhattan extends UnidadeMovel{

	public UnidadeManhattan() {
	}
	
	public UnidadeManhattan(String id, float latitude, float longitude, ConfiguracaoDaUnidade configuracao) {
		super(id, latitude, longitude, configuracao);
	}

	@Override
	public float getDistancia(float latitudeDestino, float longitudeDestino) {
		
		float distancia;
		distancia = (float) (Math.pow((latitudeDestino - this.getLatitude()),2) - (long) Math.pow((latitudeDestino - this.getLongitude()),2));
			
		return distancia;
	}


}
