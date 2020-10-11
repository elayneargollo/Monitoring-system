package ifba.ads.model;

import java.util.ArrayList;
import java.util.Iterator;

import ifba.ads.controll.H2unidadeMovel;
import ifba.ads.controll.UnidadeMovelDAO;

public class Monitorar extends H2unidadeMovel  {

	UnidadeMovelDAO unidadeMovelDAO;
	public String resposta;
	public ArrayList<UnidadeMovel> unidades;
	public ArrayList<UnidadeMovel> unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento = new ArrayList<>();
	
	public Monitorar() {
    	this.unidadeMovelDAO = new H2unidadeMovel();
 		this.unidades = buscarUnidadesH2();
    }    
	
	public void addUnidade (UnidadeMovel unidade) {
		this.unidadeMovelDAO.inserir(unidade);
	}
	
 	public String unidadeMovelMaisProxima(float latitude, float longitude, boolean cameraDeVideo, boolean termometro,
			boolean medidordeCo2, boolean medidorDeMetano) {
 		
 		this.procuraUnidadeComRequisitoMinimo(cameraDeVideo,termometro, medidordeCo2, medidorDeMetano);
		this.atualizar(buscarUnidadeComMenorDistancia(latitude, longitude));
		
		return "Unidade " + buscarUnidadeComMenorDistancia(latitude, longitude).getId() + " irá se deslocar";
	}

	public void procuraUnidadeComRequisitoMinimo(boolean cameraDeVideo, boolean termometro,boolean MedidordeCo2, boolean medidorDeMetano) {

		String equipamentosMinimosParaMonitoramento = equipamentosMinimos(cameraDeVideo, termometro, MedidordeCo2,
				medidorDeMetano).toString();

		equipamentosMinimosParaMonitoramento = equipamentosMinimosParaMonitoramento.replace("[", "");
		equipamentosMinimosParaMonitoramento = equipamentosMinimosParaMonitoramento.replace("]", "");

		if (equipamentosMinimosParaMonitoramento.equals("")) {
			unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento = unidades;
		} else {

			Iterator<UnidadeMovel> it = unidades.iterator();

			while (it.hasNext()) {

				UnidadeMovel atual = it.next();

				String configuracoesDaUnidade = (atual.getConfiguracao().getEquipamentos().toString());

				configuracoesDaUnidade = configuracoesDaUnidade.replace("[", "");
				configuracoesDaUnidade = configuracoesDaUnidade.replace("]", "");

				if (configuracoesDaUnidade.contains(equipamentosMinimosParaMonitoramento)) {
					unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.add(atual);
				}

			}

			if (unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.size() == 0) {
				resposta = "Sistema não tem unidades com requisitos minimos exigidos";
				System.out.println(resposta);
				System.exit(0);
			}

		}

	}

	public ArrayList<EquipamentoEnum> equipamentosMinimos(boolean cameraDeVideo, boolean termometro,
			boolean MedidordeCo2, boolean MedidordeMetano) {

		ArrayList<EquipamentoEnum> equipamentosMinimos = new ArrayList<>();

		if (cameraDeVideo == true) {
			equipamentosMinimos.add(EquipamentoEnum.CAMERADEVIDEO);
		}
		if (termometro == true) {
			equipamentosMinimos.add(EquipamentoEnum.TERMOMETRO);
		}
		if (MedidordeCo2 == true) {
			equipamentosMinimos.add(EquipamentoEnum.MEDIDORDEC02);
		}
		if (MedidordeMetano == true) {
			equipamentosMinimos.add(EquipamentoEnum.MEDIDORDEMETANO);
		}

		return equipamentosMinimos;

	}

	public UnidadeMovel buscarUnidadeComMenorDistancia(float latitude, float longitude) {

		float menorDistancia = unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.get(0)
				.getDistancia(latitude, longitude);
		UnidadeMovel unidadeQueIraSeDeslocar = unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.get(0);

		for (int i = 0; i < unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.size(); i++) {

			float distanciaDestaUnidade = unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.get(i)
					.getDistancia(latitude, longitude);

			if (menorDistancia > distanciaDestaUnidade) {
				menorDistancia = distanciaDestaUnidade;
				unidadeQueIraSeDeslocar = unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.get(i);
			}

		}

		unidadeQueIraSeDeslocar.setLocalizacao(longitude, latitude);
		return unidadeQueIraSeDeslocar;
	}

}
