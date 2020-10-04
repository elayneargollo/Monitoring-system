package ifba.ads.controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ifba.ads.model.UnidadeMovel;

public class H2Waiter implements H2CRUD {

	private Connection conexao;

	public H2Waiter() throws SQLException {
		conexao = DriverManager.getConnection("jdbc:h2:" + "./database/unidadeMovel", "sa", "");
	}

	public String criarTabela() {
		Statement stmt;
		String sql = "CREATE TABLE UNIDADEMOVEL" 
					  + "(id VARCHAR(255)," 
					  + " latitude DOUBLE, " 
					  + " longitude DOUBLE, "
					  + " configuracao VARCHAR(255), "
					  + " PRIMARY KEY (id))";
		

		try {
			stmt = conexao.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return "Tabela criada !";

	}

	@Override
	public void inserir(UnidadeMovel unidade) {
		String sql = "INSERT INTO UNIDADEMOVEL(id, latitude, longitude, configuracao) VALUES (?,?,?,?)";
		PreparedStatement stmt;
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, unidade.getId());
			stmt.setFloat(2, unidade.getLatitude());
			stmt.setFloat(3, unidade.getLongitude());
			stmt.setString(4, unidade.getConfiguracao().toString());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("Nao e possivel inserir : chave primaria violada ! ");
			System.exit(0);
		}

	}

	@Override
	public void atualizar(UnidadeMovel unidade) {
		String sql = "update UNIDADEMOVEL set  latitude=?, longitude=?, configuracao=? where id=?";
		PreparedStatement stmt;

		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setFloat(1, unidade.getLatitude());
			stmt.setFloat(2, unidade.getLongitude());
			stmt.setString(3, unidade.getConfiguracao().toString());
			stmt.setString(4, unidade.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deletar(UnidadeMovel unidade) {
		String sql = "delete from UNIDADEMOVEL where id=? ";
		PreparedStatement stmt;
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, unidade.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void consultar() {
		String sql = " select * from UNIDADEMOVEL";
		Statement stmt;

		try {
			stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				
				System.out.println("\tid: " + rs.getString(1) 
											+ "\tLatitude: " 
											+ rs.getFloat(2) 
											+ "\tLongitude: "
											+ rs.getFloat(3) 
											+ "\t" 
											+ rs.getString(4));
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
