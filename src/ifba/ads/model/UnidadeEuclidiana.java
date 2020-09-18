package ifba.ads.model;

public class UnidadeEuclidiana extends UnidadeMovel{

	public UnidadeEuclidiana(String id, long latitude, long longitude, ConfiguracaoDaUnidade configuracao) {
		super(id, latitude, longitude, configuracao);
	}

	@Override
	public long distanciaEntreOrigemEDestino() {

		return 0;
	}

}
