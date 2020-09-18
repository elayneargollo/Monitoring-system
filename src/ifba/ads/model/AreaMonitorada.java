package ifba.ads.model;

import java.util.ArrayList;
import java.util.Iterator;

public class AreaMonitorada implements ComandarMonitoramento {

	public ArrayList<UnidadeMovel> unidades = new ArrayList<>();
	public ArrayList<UnidadeMovel> unidadeMovelQuePossuiRequisitosMinimos = new ArrayList<>();

	public void requisitoMinimo(boolean cameraDeVideo, boolean termometro, boolean MedidordeCo2,
			boolean medidorDeMetano) {

		String equipamentosMinimo = equipamentosMinimos(cameraDeVideo, termometro, MedidordeCo2, medidorDeMetano)
				.toString();

		equipamentosMinimo = equipamentosMinimo.replace("[", "");
		equipamentosMinimo = equipamentosMinimo.replace("]", "");

		if (equipamentosMinimo.equals("")) { // se ele n exigir, qlqr unidade serve =)
			unidadeMovelQuePossuiRequisitosMinimos = unidades;
		} else {

			Iterator<UnidadeMovel> it = unidades.iterator();

			while (it.hasNext()) {

				UnidadeMovel atual = it.next();

				String conf = (atual.getConfiguracao().equipamentos.toString());

				conf = conf.replace("[", "");
				conf = conf.replace("]", "");

				if (conf.contains(equipamentosMinimo)) {
					unidadeMovelQuePossuiRequisitosMinimos.add(atual);
				}

			}

		}

	}

	@Override
	public String monitorar(float latitude, float longitude, boolean cameraDeVideo, boolean termometro,
			boolean MedidordeCo2, boolean medidorDeMetano) {

		requisitoMinimo(cameraDeVideo, termometro, MedidordeCo2, medidorDeMetano);
		
		float menorDistancia = unidadeMovelQuePossuiRequisitosMinimos.get(0).distanciaEntreOrigemEDestino(latitude,longitude);
		UnidadeMovel unidade = unidadeMovelQuePossuiRequisitosMinimos.get(0);

		for (int i = 0; i < unidadeMovelQuePossuiRequisitosMinimos.size(); i++) {

			float distanciaDestaUnidade = unidadeMovelQuePossuiRequisitosMinimos.get(i)
					.distanciaEntreOrigemEDestino(latitude, longitude);

			if (menorDistancia > distanciaDestaUnidade) {
				menorDistancia = distanciaDestaUnidade;
				unidade = unidadeMovelQuePossuiRequisitosMinimos.get(i);
			}

		}
		atualizarLocalizacao(unidade, latitude, longitude);

		return "Unidade com identificador " + unidade.getId() + " transladada para o local solicitado";
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
