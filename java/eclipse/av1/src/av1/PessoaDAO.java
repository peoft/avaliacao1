package av1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaDAO implements IPessaoDAO {

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().getConnection("jdbc:mysql://localhost:3306/AV1","root","root");
            conn.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
	}

	@Override
	public boolean criar(Pessoa pessoa) {
		boolean ret = false;
		Connection connection = null;
		// TODO Auto-generated method stub
		try {
			connection = getConnection();
			String queryString = "INSERT INTO Pessoa(id, nome, dataNascimento, cpf, sexo) VALUES(?,?,?,?,?)";
			try (PreparedStatement ptmt = connection.prepareStatement(queryString)) {				
				ptmt.setInt(1, pessoa.getId());
				ptmt.setString(2, pessoa.getNome());
				ptmt.setDate(3,  new java.sql.Date(pessoa.getDataNascimento().getTime()));
				ptmt.setString(4, pessoa.getCpf());
				ptmt.setString(5, pessoa.getSexo().toString());
				ptmt.executeUpdate();
			}
			connection.commit();
			ret = true;
		} catch (SQLException e) {
			System.out.println("Erro ao adicionar =" + e.getMessage());
			e.printStackTrace();
			if (connection != null)
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

	@Override
	public boolean recuperar(Pessoa pessoa) {
		boolean ret = false;
		String queryString = "SELECT * FROM pessoa where id = ?";
		try (
			Connection connection = getConnection();
			PreparedStatement ptmt = connection.prepareStatement(queryString);
			) {
			ptmt.setInt(1, pessoa.getId());
			try (ResultSet resultSet = ptmt.executeQuery()){			
				while (resultSet.next()) {
					System.out.println("id=" + resultSet.getInt("id"));
					System.out.println("dataNascimento=" + resultSet.getDate("dataNascimento"));
					System.out.println("nome=" + resultSet.getString("nome"));
					System.out.println("sexo=" + resultSet.getString("sexo"));
					System.out.println("cpf=" + resultSet.getString("cpf"));
					pessoa.setCpf(resultSet.getString("cpf"));
										
					pessoa.setDataNascimento(new java.util.Date(resultSet.getDate("dataNascimento").getTime()));
					pessoa.setNome(resultSet.getString("nome"));
					String sexo;
					sexo = resultSet.getString("sexo");
					if (sexo.equalsIgnoreCase("Masculino")) {
						pessoa.setSexo(SEXO.Masculino);
					} else {
						pessoa.setSexo(SEXO.Feminino);
					}
				}				
				ret = true;
			} catch (SQLTimeoutException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;		
	}

	@Override
	public boolean atualizar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		boolean ret = false;
/*		try {
			String queryString = "UPDATE student SET Name=? WHERE RollNo=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, student.getName());
			ptmt.setInt(2, student.getRollNo());
			ptmt.executeUpdate();
			System.out.println("Table Updated Successfully");
		} catch (SQLException e) {
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
			} catch (Exception e) {
			}
		}*/
		return ret;
		
	}

	@Override
	public boolean deletar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		boolean ret = false;
		Connection connection = null;
		// TODO Auto-generated method stub
		try {
			connection = getConnection();
			String queryString = "DELETE FROM Pessoa WHERE id = ?";
			try (PreparedStatement ptmt = connection.prepareStatement(queryString)) {				
				ptmt.setInt(1, pessoa.getId());
				ptmt.executeUpdate();				
			} catch (SQLException e) {
				System.out.println("Erro ao remover =" + e.getMessage());
				e.printStackTrace();
			}
			connection.commit();
			System.out.println("Registro removido da tabela!");
			ret = true;
		} catch (SQLException e) {
			System.out.println("Erro ao remover =" + e.getMessage());
			e.printStackTrace();
			if (connection != null)
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ret;
		
	}
	
	public static void main(String[] args) {
		Connection connection;
		PessoaDAO p = new PessoaDAO();
		connection = p.getConnection();
		if (connection != null) {
			System.out.print("Conectou!!!");
		}
	}

	@Override
	public boolean recuperarPeloCPF(Pessoa pessoa) {
		// TODO Auto-generated method stub
		boolean ret = false;
		String queryString = "SELECT id FROM pessoa where cpf = ?";
		try (
			Connection connection = getConnection();
			PreparedStatement ptmt = connection.prepareStatement(queryString);
			) {
			ptmt.setString(1, pessoa.getCpf());
			try (ResultSet resultSet = ptmt.executeQuery()){			
				while (resultSet.next()) {
					System.out.println("id " + resultSet.getInt("id"));
					pessoa.setId(resultSet.getInt("id"));
					ret = true;
				}				
			} catch (SQLTimeoutException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;		
	}

}
