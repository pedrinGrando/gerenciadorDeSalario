package model.vo;

import java.time.LocalDate;

public class MetaVO {

	private int idMeta;
	private int idUsuario;
	private String nome;
	private double valor;
	private LocalDate dataPrevista;
	
	public MetaVO(int idMeta, int idUsuario, String nome, double valor, LocalDate dataPrevista) {
		super();
		this.idMeta = idMeta;
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.valor = valor;
		this.dataPrevista = dataPrevista;
	}

	public MetaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdMeta() {
		return idMeta;
	}

	public void setIdMeta(int idMeta) {
		this.idMeta = idMeta;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(LocalDate dataPrevista) {
		this.dataPrevista = dataPrevista;
	}
	
}
