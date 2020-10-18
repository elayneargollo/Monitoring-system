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
	

	public void adicionarEquipamentosAUnidade(boolean cameraDeVideo, boolean termometro, boolean MedidordeCo2, boolean MedidordeMetano) {

		if (cameraDeVideo == true) {
			equipamentos.add(EquipamentoEnum.CAMERADEVIDEO);
		}
		if (termometro == true) {
			equipamentos.add(EquipamentoEnum.TERMOMETRO);
		}
		if (MedidordeCo2 == true) {
			equipamentos.add(EquipamentoEnum.MEDIDORDEC02);
		}
		if (MedidordeMetano == true) {
			equipamentos.add(EquipamentoEnum.MEDIDORDEMETANO);
		}
		
		
	}
	
}
