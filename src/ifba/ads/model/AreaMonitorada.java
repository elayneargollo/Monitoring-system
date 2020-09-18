package ifba.ads.model;

import java.util.ArrayList;
import java.util.Iterator;

public class AreaMonitorada implements ComandarMonitoramento {

	public ArrayList<UnidadeMovel> unidades = new ArrayList<>();
	public ArrayList<UnidadeMovel> unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento = new ArrayList<>();

	public void requisitoMinimo(boolean cameraDeVideo, boolean termometro, boolean MedidordeCo2,
			boolean medidorDeMetano) {

		String equipamentosMinimosParaMonitoramento = equipamentosMinimos(cameraDeVideo, termometro, MedidordeCo2, medidorDeMetano)
				.toString();

		equipamentosMinimosParaMonitoramento = equipamentosMinimosParaMonitoramento.replace("[", "");
		equipamentosMinimosParaMonitoramento = equipamentosMinimosParaMonitoramento.replace("]", "");

		if (equipamentosMinimosParaMonitoramento.equals("")) { // se ele n exigir, qlqr unidade serve =)
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

		}

	}

	@Override
	public String monitorar(float latitude, float longitude, boolean cameraDeVideo, boolean termometro,
			boolean MedidordeCo2, boolean medidorDeMetano) {

		requisitoMinimo(cameraDeVideo, termometro, MedidordeCo2, medidorDeMetano);
		
		float menorDistancia = unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.get(0).distanciaEntreOrigemEDestino(latitude,longitude);
		UnidadeMovel unidadeQueIraSeDeslocar = unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.get(0);

		for (int i = 0; i < unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.size(); i++) {

			float distanciaDestaUnidade = unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.get(i)
					.distanciaEntreOrigemEDestino(latitude, longitude);

			if (menorDistancia > distanciaDestaUnidade) {
				menorDistancia = distanciaDestaUnidade;
				unidadeQueIraSeDeslocar = unidadeMovelQuePossuiRequisitosMinimosDeMonitoramento.get(i);
			}

		}
		atualizarLocalizacao(unidadeQueIraSeDeslocar, latitude, longitude);

		return "Unidade com identificador " + unidadeQueIraSeDeslocar.getId() + " transladada para o local solicitado";
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

	@Override
	public void atualizarLocalizacao(UnidadeMovel unidade, float latitude, float longitude) {
		unidade.setLatitude(latitude);
		unidade.setLongitude(longitude);
	}

	@Override
	public void inserirUnidades(UnidadeMovel unidade) {
		unidades.add(unidade);
	}

}
