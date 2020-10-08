package ifba.ads.model;

import java.util.ArrayList;
import java.util.Iterator;

import ifba.ads.controll.H2UNIDADEMOVEL;

public class Monitorar extends H2UNIDADEMOVEL  {

	public ArrayList<UnidadeMovel> unidades = new ArrayList<>();;
	public ArrayList<UnidadeMovel> unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento = new ArrayList<>();

	public String monitorar(float latitude, float longitude, boolean cameraDeVideo, boolean termometro,
			boolean medidordeCo2, boolean medidorDeMetano) {

		procuraUnidadeComRequisitoMinimo(cameraDeVideo,termometro, medidordeCo2, medidorDeMetano);

		UnidadeMovel unidade = (getMenorDistancia(latitude, longitude));
		atualizar(unidade);
		consultar();
		return "Unidade " + unidade.getId().toString() + " ir· se deslocar";
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

				String configuracoesDaUnidade = (atual.getConfiguracao().equipamentos.toString());

				configuracoesDaUnidade = configuracoesDaUnidade.replace("[", "");
				configuracoesDaUnidade = configuracoesDaUnidade.replace("]", "");

				if (configuracoesDaUnidade.contains(equipamentosMinimosParaMonitoramento)) {
					unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.add(atual);
				}

			}

			if (unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.size() == 0) {
				System.out.println("Sistema n√£o tem unidades com requisitos minimos exigidos");
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

	public UnidadeMovel getMenorDistancia(float latitude, float longitude) {

		float menorDistancia = unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.get(0)
				.distanciaEntreOrigemEDestino(latitude, longitude);
		UnidadeMovel unidadeQueIraSeDeslocar = unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.get(0);

		for (int i = 0; i < unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.size(); i++) {

			float distanciaDestaUnidade = unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.get(i)
					.distanciaEntreOrigemEDestino(latitude, longitude);

			if (menorDistancia > distanciaDestaUnidade) {
				menorDistancia = distanciaDestaUnidade;
				unidadeQueIraSeDeslocar = unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.get(i);
			}

		}

		unidadeQueIraSeDeslocar.setLocalizacao(longitude, latitude);
		return unidadeQueIraSeDeslocar;
	}

	public void inserirUnidades(UnidadeMovel unidade) {

		boolean encontrado = false;

		for (int i = 0; i < unidades.size(); i++) {
			if (unidades.get(i).equals(unidade)) {
				encontrado = true;
			}
		}

		if (encontrado == false) {
			unidades.add(unidade);
			inserir(unidade);
		} else
			System.out.println("N„o È possivel inserir a unidade: esta unidade j· existe !");

	}
}
