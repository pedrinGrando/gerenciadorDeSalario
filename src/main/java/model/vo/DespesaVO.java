package model.vo;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DespesaVO {

	private int idDespesa;
	private int idUsuario;
	private String divnome;
	private double valor;
	private LocalDate ultimoPagamento;
	
	public DespesaVO(int idDespesa, int idUsuario, String divnome, double valor, LocalDate ultimoPagamento) {
		super();
		this.idDespesa = idDespesa;
		this.idUsuario = idUsuario;
		this.divnome = divnome;
		this.valor = valor;
		this.ultimoPagamento = ultimoPagamento;
	}

	public DespesaVO() {
		super();
	}

	public int getIdDespesa() {
		return idDespesa;
	}

	public void setIdDespesa(int idDespesa) {
		this.idDespesa = idDespesa;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDivnome() {
		return divnome;
	}

	public void setDivnome(String divnome) {
		this.divnome = divnome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getUltimoPagamento() {
		return ultimoPagamento;
	}

	public void setUltimoPagamento(LocalDate ultimoPagamento) {
		this.ultimoPagamento = ultimoPagamento;
	}
	//FORMATAÇAO
	DecimalFormat df = new DecimalFormat("0.00");
	
	public String toString() {
		return "\nID: " + this.getIdDespesa()
		       + "\nID usuário: " + this.getIdUsuario()
		       + "\nNome da despesa: " + this.getDivnome()
		       + "\nValor: R$ " + df.format(this.getValor())
		       + "\nData pagamento: " + this.validarData(this.getUltimoPagamento());
	}
	
	private String validarData(LocalDate data) {
		String resultado = "";
		if(data != null) {
			resultado = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		} else {
			resultado = "Nula";
		}
		return resultado; 
	}
	
	
	
	
	
	
}
