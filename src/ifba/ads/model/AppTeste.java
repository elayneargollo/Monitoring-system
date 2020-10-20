package ifba.ads.model;

import ifba.ads.controll.MemUnidadeMovel;

public class AppTeste {

	public static void main(String[] args) throws Exception {
		
		MemUnidadeMovel me = new MemUnidadeMovel();
		
		System.out.println(me.buscarTodasAsUnidades());
		System.out.println(me.buscarPorId("teste"));

	}
	

}
