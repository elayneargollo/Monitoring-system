package ifba.ads.controll;

import java.sql.SQLException;
import java.util.ArrayList;

import ifba.ads.model.ConfiguracaoDaUnidade;
import ifba.ads.model.EquipamentoEnum;
import ifba.ads.model.UnidadeEuclidiana;
import ifba.ads.model.UnidadeManhattan;
import ifba.ads.model.UnidadeMovel;

public class MemUnidadeMovel implements UnidadeMovelDAO {
	
	private ArrayList<UnidadeMovel> unidades = new ArrayList();

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
		
		configuracao.adicionarEquipamentosAUnidade(EquipamentoEnum.CAMERADEVIDEO);
		configuracao.adicionarEquipamentosAUnidade(EquipamentoEnum.MEDIDORDEC02);
		configuracao2.adicionarEquipamentosAUnidade(EquipamentoEnum.MEDIDORDEC02);
	
		this.inserir(new UnidadeEuclidiana("teste", 4, 2, configuracao));
		this.inserir(new UnidadeManhattan("teste2", 42, 24, configuracao2));
		this.inserir(new UnidadeEuclidiana("teste3", 3, 2, configuracao));

	}

	@Override
	public void inserir(UnidadeMovel unidade) {
		unidades.add(unidade);
	}

	@Override
	public void atualizar(UnidadeMovel unidade) {
		this.unidades.add(unidade);

	}

	@Override
	public int deletar(String id) {
		this.unidades.remove(id);
		return 0;
	}

	@Override
	public ArrayList<UnidadeMovel> buscarTodasAsUnidades() {
		return unidades;
	}

	@Override
	public UnidadeMovel buscarPorId(String id)  {
		
		for (int i=0; i<unidades.size(); i++) {
			if(unidades.get(i).getId().equals(id)) {
				return unidades.get(i);
			}
		}
		return null;
	}

}
