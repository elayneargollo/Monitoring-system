package ifba.ads.controll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ifba.ads.model.UnidadeMovel;

public class H2Waiter implements H2CRUD {

	private Connection conexao;

	public H2Waiter() throws SQLException {
		this.conexao = new H2Connection().getConnection();

		//String criacaoDeTabela = criarTabela();
	}

	public String criarTabela() {

		String sql = "CREATE TABLE UNIDADEMOVEL" + "(id VARCHAR(255)," + " latitude DOUBLE, " + " longitude DOUBLE, "
				+ " configuracao VARCHAR(255), " + " PRIMARY KEY (id))";

		Statement stmt;

		try {
			stmt = conexao.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
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


		} catch (SQLException e) {
			System.out.println("Nao e possivel inserir : chave primaria violada ! ");
			System.exit(0);
		}

	}

	@Override
	public void atualizar() {

	}

	@Override
	public void deletar() {

	}

	@Override
	public void consultar() {

		String sql = " select * from UNIDADEMOVEL";
		Statement stmt;
		
		try {
			
			stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			System.out.println("Unidades encontradas: ");
			
			while (rs.next()) {
				System.out.println("\t"
									+ rs.getString(1) 
									+ " " + rs.getFloat(2) 
									+ " " + rs.getFloat(3) 
									+ " " + rs.getString(4));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
