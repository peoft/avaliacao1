package av1;

import java.util.Date;

public class Motorista extends Pessoa {
	public Motorista(int id, String nome, Date dataNascimento, String cpf, SEXO sexo) {
		super(id, nome, dataNascimento, cpf, sexo);
		// TODO Auto-generated constructor stub
	}

	private String numeroCNH;

	public String getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}
}
