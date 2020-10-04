package ifba.ads.controll;

import ifba.ads.model.UnidadeMovel;

public interface H2CRUD {
	
	abstract void inserir(UnidadeMovel unidade);
	abstract void atualizar();
	abstract void deletar();
	abstract void consultar();
	
}
