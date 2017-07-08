package av1;

import java.util.Date;

public class Funcionario extends Pessoa {	
	public Funcionario(int id, String nome, Date dataNascimento, String cpf, SEXO sexo) {
		super(id, nome, dataNascimento, cpf, sexo);
		// TODO Auto-generated constructor stub
	}

	private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}