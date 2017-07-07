package av1;

import java.sql.Connection;

public interface IFuncionarioDAO {
	Connection getConnection();
	void criar(Funcionario funcionario); 
	void recuperar(Funcionario funcionario);
	void atualizar(Funcionario funcionario);
	void deletar(Funcionario funcionario);
}
