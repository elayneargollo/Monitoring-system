package ifba.ads.model;

import java.util.ArrayList;

public class ConfiguracaoDaUnidade {

	ArrayList<EquipamentoEnum> equipamentos = new ArrayList<>();

	public ArrayList<EquipamentoEnum> getEquipamentos () {
		return equipamentos;
	}
	
	public void adicionarEquipamentosAUnidade(EquipamentoEnum equipamento) {
		equipamentos.add(equipamento);
	}
	
	public void removerEquipamentosAUnidade(EquipamentoEnum equipamento) {
		equipamentos.remove(equipamento);
	}
	
}
