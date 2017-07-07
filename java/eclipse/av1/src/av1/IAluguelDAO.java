package av1;

import java.sql.Connection;

public interface IAluguelDAO {
	Connection getConnection();
	void criar(Aluguel aluguel); 
	void recuperar(Aluguel aluguel);
	void atualizar(Aluguel aluguel);
	void deletar(Aluguel aluguel);
}
