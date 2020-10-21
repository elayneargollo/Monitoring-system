package ifba.ads.view;

import ifba.ads.model.UnidadeMovelLogica;

public interface UnidadeMovelUI {
	
	public void setLogica (UnidadeMovelLogica logica) throws Exception;
	public void run() throws Exception;
}
