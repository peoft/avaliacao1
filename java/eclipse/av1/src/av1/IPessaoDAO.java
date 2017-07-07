package av1;

import java.sql.Connection;

public interface IPessaoDAO {
	Connection getConnection();
	void criar(Pessoa pessoa); 
	void recuperar(Pessoa pessoa);
	void atualizar(Pessoa pessoa);
	void deletar(Pessoa pessoa);
}
