package av1;

import java.sql.Connection;

public interface IPessaoDAO {
	Connection getConnection();
	boolean criar(Pessoa pessoa); 
	void recuperar(Pessoa pessoa);
	boolean atualizar(Pessoa pessoa);
	boolean deletar(Pessoa pessoa);
}
