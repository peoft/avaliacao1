package av1;

import java.sql.Connection;

public interface IMotoristaDAO {
	Connection getConnection();
	void criar(Motorista motorista); 
	void recuperar(Motorista motorista);
	void atualizar(Motorista motorista);
	void deletar(Motorista motorista);

}
