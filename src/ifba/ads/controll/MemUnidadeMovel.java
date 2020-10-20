package ifba.ads.controll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ifba.ads.model.ConfiguracaoDaUnidade;
import ifba.ads.model.UnidadeEuclidiana;
import ifba.ads.model.UnidadeManhattan;
import ifba.ads.model.UnidadeMovel;

public class MemUnidadeMovel implements UnidadeMovelDAO {
	
	private Map<String, UnidadeMovel> unidades;
	
	public MemUnidadeMovel() throws Exception {
		try {
			
			this.povoar();
				} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	  private void povoar() throws Exception {
			
		  	ConfiguracaoDaUnidade configuracao = new ConfiguracaoDaUnidade();
			ConfiguracaoDaUnidade configuracao2 = new ConfiguracaoDaUnidade();
			
			this.inserir(new UnidadeEuclidiana("teste", 4, 2, configuracao));
			this.inserir(new UnidadeManhattan("teste2", 42, 24, configuracao2));
		  	this.inserir(new UnidadeEuclidiana("teste3", 3, 2, configuracao));
			
	    }
	
	@Override
	public void inserir(UnidadeMovel unidade) {
		this.unidades.put(unidade.getId(), unidade);		
	}

	@Override
	public void atualizar(UnidadeMovel unidade) {
		this.unidades.put(unidade.getId(), unidade);
		
	}

	@Override
	public int deletar(String id) {
		this.unidades.remove(id);
		
		return 0;
	}

	@Override
	public ArrayList<UnidadeMovel> buscarTodasAsUnidades() {
		
		return null;
	}

	@Override
	public UnidadeMovel buscarPorId(String id) {
		return this.unidades.get(id);
	}
	
}
