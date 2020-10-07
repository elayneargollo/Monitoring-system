package ifba.ads.model;

public abstract class UnidadeMovel {

	public String id;
	public float latitude;
	public float longitude;
	public ConfiguracaoDaUnidade configuracao;

	public UnidadeMovel(String id, float latitude, float longitude, ConfiguracaoDaUnidade configuracao) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.configuracao = configuracao;
	}

	public String getId() {
		return id;
	}

	public void setLocalizacao(float longitude, float latitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return "UnidadeMovel [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", configuracao=" + configuracao + "]";
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	public ConfiguracaoDaUnidade getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(ConfiguracaoDaUnidade configuracao) {
		this.configuracao = configuracao;
	}
	
	public boolean equals (UnidadeMovel unidade) {
		return this.getId().equals(unidade.getId());
	}

	public abstract float distanciaEntreOrigemEDestino(float latitudeDestino, float longitudeDestino);

}
