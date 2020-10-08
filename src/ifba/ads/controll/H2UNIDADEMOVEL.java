package ifba.ads.controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ifba.ads.model.UnidadeEuclidiana;
import ifba.ads.model.UnidadeManhattan;
import ifba.ads.model.UnidadeMovel;

public class H2UNIDADEMOVEL implements UnidadeMovelDAO {

	private Connection conexao;
	private static int tipoUnidade = 0;
	
	private final String INSERT = "INSERT INTO UNIDADE"
									+ "(id, latitude, longitude, configuracao, tipoDaUnidade)"
									+ "VALUES (?,?,?,?,?)";
	
	private final String CREATE = "CREATE TABLE UNIDADE" 
								  + "(id VARCHAR(255)," 
								  + " latitude DOUBLE, " 
								  + " longitude DOUBLE, "
								  + " configuracao VARCHAR(255), "
								  + " tipoDaUnidade INT, "
								  + " PRIMARY KEY (id))";

	private final String ATUALIZAR  = "update UNIDADE "
									+ "set  latitude=?, longitude=?, configuracao=? "
									+ "where id=?";
	
	private final String CONSULTAR = " select * from UNIDADE";

	public H2UNIDADEMOVEL() {
		try {
			conexao = DriverManager.getConnection("jdbc:h2:" + "./database/unidade", "sa", "");
			criarTabela();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String criarTabela() {
		Statement stmt;

		try {
			stmt = conexao.createStatement();
			stmt.executeUpdate(CREATE);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return "Tabela criada !";

	}

	@Override
	public void inserir(UnidadeMovel unidade) {

		if (unidade instanceof UnidadeEuclidiana) {
			inserirEuclidiana(unidade);
		} else if (unidade instanceof UnidadeManhattan) {
			inserirManhattan(unidade);
		}

	}
	
	public void inserirManhattan (UnidadeMovel unidade) {
		
		PreparedStatement stmt;		
		
		try {
			stmt = conexao.prepareStatement(INSERT);
			stmt.setString(1, unidade.getId());
			stmt.setFloat(2, unidade.getLatitude());
			stmt.setFloat(3, unidade.getLongitude());
			stmt.setString(4, unidade.getConfiguracao().toString());
			stmt.setInt(5, H2UNIDADEMOVEL.tipoUnidade);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			System.out.println(e);
			System.exit(0);
		}
	}
	
	public void inserirEuclidiana (UnidadeMovel unidade) {
	
		PreparedStatement stmt;

		try {
			stmt = conexao.prepareStatement(INSERT);
			stmt.setString(1, unidade.getId());
			stmt.setFloat(2, unidade.getLatitude());
			stmt.setFloat(3, unidade.getLongitude());
			stmt.setString(4, unidade.getConfiguracao().toString());
			stmt.setInt(5,  H2UNIDADEMOVEL.tipoUnidade);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("Nao e possivel inserir : chave primaria violada ! ");
			System.exit(0);
		}
	}

	@Override
	public void atualizar(UnidadeMovel unidade) {
		PreparedStatement stmt;

		try {
			stmt = conexao.prepareStatement(ATUALIZAR);
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
		Statement stmt;

		try {
			stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(CONSULTAR);

			while (rs.next()) {
				
				System.out.println("\tid: " 
									+ rs.getString(1) 
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
