package ifba.ads.model;

public abstract class UnidadeMovel {

	public String id;
	public long latitude;
	public long longitude;
	public ConfiguracaoDaUnidade configuracao;

	public UnidadeMovel(String id, long latitude, long longitude, ConfiguracaoDaUnidade configuracao) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.configuracao = configuracao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public long getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return "UnidadeMovel [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", configuracao="
				+ configuracao + "]";
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}
	
	public ConfiguracaoDaUnidade getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(ConfiguracaoDaUnidade configuracao) {
		this.configuracao = configuracao;
	}

	public abstract long distanciaEntreOrigemEDestino();

}
