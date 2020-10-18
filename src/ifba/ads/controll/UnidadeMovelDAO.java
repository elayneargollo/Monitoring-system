package ifba.ads.controll;

import java.util.ArrayList;

import ifba.ads.model.UnidadeMovel;

public interface UnidadeMovelDAO {
	
	abstract void inserir(UnidadeMovel unidade);
	abstract void atualizar(UnidadeMovel unidade);
	abstract int deletar(String id); // ok
	abstract ArrayList<UnidadeMovel> buscarTodasAsUnidades(); // ok
	abstract UnidadeMovel buscarPorId(String id); // ok
	
}
