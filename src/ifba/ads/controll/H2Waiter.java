package ifba.ads.controll;

import java.sql.Connection;
import java.sql.SQLException;

public class H2Waiter implements H2CRUD {

	private Connection connection;
	
	public H2Waiter() throws SQLException{
		this.connection  =  new H2Connection().getConnection(); 
	}

	@Override
	public void inserir() {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void consultar() {
		// TODO Auto-generated method stub

	}

}
