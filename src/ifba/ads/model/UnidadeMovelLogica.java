package ifba.ads.model;

import ifba.ads.controll.UnidadeMovelDAO;

public interface UnidadeMovelLogica {
	
	public void setPersistencia(UnidadeMovelDAO persistencia) throws Exception;
	public void atualizar(String id);
	public void mover(UnidadeMovel unidade);
	
}
