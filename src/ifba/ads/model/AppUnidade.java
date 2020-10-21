package ifba.ads.model;

import ifba.ads.controll.UnidadeMovelDAO;

public class AppUnidade implements UnidadeMovelLogica {
	
	private UnidadeMovelDAO unidadeDAO;

	public AppUnidade() {
		
	}
	
	public void addUnidadeMovelEuclidiana() {
		
	}
	
	public void addUnidadeMovelManhattan() {
		
	}

	@Override
	public void atualizar(String id) {
		
	}

	@Override
	public void mover(UnidadeMovel unidade) {
		
	}
	
	@Override
	public void setPersistencia(UnidadeMovelDAO persistencia) throws Exception {
		this.unidadeDAO = persistencia;		
	}
	
}
