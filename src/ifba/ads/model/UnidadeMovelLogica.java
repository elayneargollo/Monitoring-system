package ifba.ads.model;

import ifba.ads.controll.UnidadeMovelDAO;

public interface UnidadeMovelLogica {
	
	public void setPersistencia(UnidadeMovelDAO persistencia) throws Exception;
	public void mover(float latitude, float longitude, boolean cameraDeVideo, 
					boolean termometro, boolean medidorDeCo2, boolean medidorDeMetano);
	
}
