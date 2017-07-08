package av1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
	}

	@Override
	public boolean criar(Pessoa pessoa) {
		boolean ret = false;
		Connection connection = null;
		PreparedStatement ptmt = null;
		// TODO Auto-generated method stub
		try {			
			String queryString = "INSERT INTO Pessoa(id, nome, dataNascimento, cpf, sexo) VALUES(?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, pessoa.getId());
			ptmt.setString(2, pessoa.getNome());
			ptmt.setDate(3,  new java.sql.Date(pessoa.getDataNascimento().getTime()));
			ptmt.setString(4, pessoa.getCpf());
			ptmt.setString(5, pessoa.getSexo().toString());
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
			ret = true;
		} catch (SQLException e) {
			System.out.println("Erro ao adicionar =" + e.getMessage());
			e.printStackTrace();			
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			} catch (Exception e) {
			}
		}
		return ret;
	}

	@Override
	public void recuperar(Pessoa pessoa) {
		// TODO Auto-generated method stub
/*		try {
			String queryString = "SELECT * FROM student";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				System.out.println("Roll No " + resultSet.getInt("RollNo")
						+ ", Name " + resultSet.getString("Name") + ", Course "
						+ resultSet.getString("Course") + ", Address "
						+ resultSet.getString("Address"));
			}
		} catch (SQLException e) {
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			} catch (Exception e) {
			}

		}*/
		
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
/*		try {
			String queryString = "DELETE FROM student WHERE RollNo=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, rollNo);
			ptmt.executeUpdate();
			System.out.println("Data deleted Successfully");
		} catch (SQLException e) {
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			} catch (Exception e) {
			}

		}
		
	*/	
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

}
