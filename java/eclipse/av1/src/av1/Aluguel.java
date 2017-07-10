package av1;

import java.math.BigDecimal;
import java.util.Date;

public class Aluguel {
	private int id;
	private Date dataPedido;
	private Date dataEntrega;
	private Date dataDevolucao;
	private BigDecimal valorTotal;
	
	public Aluguel(int id, Date dataPedido, Date dataEntrega, Date dataDevolucao, BigDecimal valorTotal) {
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataDevolucao = dataDevolucao;
		this.valorTotal = valorTotal;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}	

}
