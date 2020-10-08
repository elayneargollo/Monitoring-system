package ifba.ads.controll;

import java.util.ArrayList;

import ifba.ads.model.UnidadeMovel;

public interface UnidadeMovelDAO {
	
	abstract void inserir(UnidadeMovel unidade);
	abstract void atualizar(UnidadeMovel unidade);
	abstract void deletar(UnidadeMovel unidade);
	abstract ArrayList<UnidadeMovel> buscarUnidadesH2();
	
}
