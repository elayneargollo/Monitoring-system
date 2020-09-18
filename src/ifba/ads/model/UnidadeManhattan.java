package ifba.ads.model;

public class UnidadeManhattan extends UnidadeMovel{

	public UnidadeManhattan(String id, long latitude, long longitude, ConfiguracaoDaUnidade configuracao) {
		super(id, latitude, longitude, configuracao);
	}

	@Override
	public long distanciaEntreOrigemEDestino() {

		return 0;
	}

}
