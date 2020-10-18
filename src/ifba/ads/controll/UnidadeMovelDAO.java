package ifba.ads.controll;

import java.util.ArrayList;

import ifba.ads.model.UnidadeMovel;

public interface UnidadeMovelDAO {
	
	abstract void inserir(UnidadeMovel unidade);
	abstract void atualizar(UnidadeMovel unidade);
	abstract int deletar(String id); 
	abstract ArrayList<UnidadeMovel> buscarTodasAsUnidades(); 
	abstract UnidadeMovel buscarPorId(String id); 
	
}
