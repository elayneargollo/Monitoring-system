package ifba.ads.controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ifba.ads.model.ConfiguracaoDaUnidade;
import ifba.ads.model.EquipamentoEnum;
import ifba.ads.model.UnidadeEuclidiana;
import ifba.ads.model.UnidadeManhattan;
import ifba.ads.model.UnidadeMovel;

public class H2unidadeMovel implements UnidadeMovelDAO {

	private Connection conexao;
	
	private static final int UNIDADE_EUCLIDIANA = 0;
	private static final int UNIDADE_MANHATTAN = 1;	
	
	private final String INSERT = "INSERT INTO UNIDADEMOVEL "
									+ "(id, latitude, longitude, configuracao, tipoDaUnidade)"
									+ "VALUES (?,?,?,?,?)";
	
	private final String CREATE = "CREATE TABLE UNIDADEMOVEL " 
								  + "(id VARCHAR(255)," 
								  + " latitude DOUBLE, " 
								  + " longitude DOUBLE, "
								  + " configuracao VARCHAR(255), "
								  + " tipoDaUnidade INT, "
								  + " PRIMARY KEY (id))";

	private final String ATUALIZAR  = "update UNIDADEMOVEL  "
									+ "set  latitude=?, longitude=?, configuracao=? "
									+ "where id=?";
	
	private final String CONSULTAR = " select * from UNIDADEMOVEL DADE";

	public H2unidadeMovel() {
		try {
			conexao = DriverManager.getConnection("jdbc:h2:" + "./database/unidadeMovel", "sa", "");
		//	criarTabela();
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
			stmt.setString(4, unidade.getConfiguracao().getEquipamentos().toString());
			stmt.setInt(5, H2unidadeMovel.UNIDADE_MANHATTAN);
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
			stmt.setString(4, unidade.getConfiguracao().getEquipamentos().toString());
			stmt.setInt(5,  H2unidadeMovel.UNIDADE_EUCLIDIANA);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			System.out.println(e);
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
			stmt.setString(3, unidade.getConfiguracao().getEquipamentos().toString());
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
									+ "\tEquipamentos: " 
									+ rs.getString(4));
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	

	public ArrayList<UnidadeMovel> getUnidades() {
		Statement stmt;
		
		ArrayList<UnidadeMovel> unidades = new ArrayList<>();
		UnidadeMovel unidade = null;

		try {
			stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(CONSULTAR);

			while (rs.next()) {
				int tipo = rs.getInt("tipoDaUnidade");
				ConfiguracaoDaUnidade conf =  gerarEnum(rs);
				
				if (tipo == 0) {
					unidade = new UnidadeEuclidiana(rs.getString("id"), 
							rs.getFloat("latitude"), 
							rs.getFloat("longitude"), 
							conf);
				
				} 
				else if (tipo == 1) {
					unidade = new UnidadeManhattan(rs.getString("id"), 
													rs.getFloat("latitude"), 
													rs.getFloat("longitude"), 
													conf);
				}
				unidades.add(unidade);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return unidades;

	}

	
	public ConfiguracaoDaUnidade gerarEnum(ResultSet rs) throws SQLException {
		
		String conf = rs.getString("configuracao");
		conf = conf.replace("[", "");
		conf = conf.replace("]", "");
		
		ArrayList<String> myList = new ArrayList<String>(Arrays.asList(conf.split(",")));		
		ConfiguracaoDaUnidade configuracao = new ConfiguracaoDaUnidade();
		
		for (int i=0; i<myList.size(); i++) {
			String valor = myList.get(i).trim();
			configuracao.adicionarEquipamentosAUnidade(EquipamentoEnum.valueOf(valor));
		}

		return configuracao;
	}
}
