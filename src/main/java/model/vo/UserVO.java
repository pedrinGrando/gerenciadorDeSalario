package model.vo;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserVO {

	private int idUsuario;
	private int TipoUsuario;
	private String nome;
	private String cpf;
	private LocalDate DataNasci;
	private double bruto;
	private double liquido;
	private String email;
	private String login;
	private String senha;
	
	public UserVO(int idUsuario, int tipoUsuario, String nome, String cpf, LocalDate dataNasci, double bruto,
			double liquido, String email, String login, String senha) {
		super();
		this.idUsuario = idUsuario;
		TipoUsuario = tipoUsuario;
		this.nome = nome;
		this.cpf = cpf;
		DataNasci = dataNasci;
		this.bruto = bruto;
		this.liquido = liquido;
		this.email = email;
		this.login = login;
		this.senha = senha;
	}

	public UserVO() {
		super();
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getTipoUsuario() {
		return TipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNasci() {
		return DataNasci;
	}

	public void setDataNasci(LocalDate dataNasci) {
		DataNasci = dataNasci;
	}

	public double getBruto() {
		return bruto;
	}

	public void setBruto(double bruto) {
		this.bruto = bruto;
	}

	public double getLiquido() {
		return liquido;
	}

	public void setLiquido(double liquido) {
		this.liquido = liquido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	//VALIDACAO DE DATA 
	private String validarData(LocalDate data) {
		String resultado = "";
		if(data != null) {
			resultado = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}
		return resultado; 
	}

	
	//FORMATAÇAO
			DecimalFormat df = new DecimalFormat("0.00");
	
	public void imprimir() {
		System.out.printf("\n%3d  %-13s  %-20s  %-11s  %-25s  %-13s %-24s  %-24s  %-10s  %-10s ", 
				this.getIdUsuario(),
				this.getTipoUsuario(),
				this.getNome(),
				this.getCpf(),
				this.validarData(this.getDataNasci()),
				this.getEmail(),
				this.getLogin(),
				this.getSenha(),
		        this.df.format(this.getBruto()),   
		        this.df.format(this.getLiquido()));
	}
	
	
	public String toString() {
		return "\nID: " + this.getIdUsuario()
		      + "\nTipo de usuário: " + this.getTipoUsuario()
		      + "\nNome: " + this.getNome()
		      +  "\nData de Nascimento: " + this.validarData(this.getDataNasci())
		      + "\nEmail: " + this.getEmail()
		      + "\nLogin: " + this.getLogin()
		      + "\nSenha: " + this.getSenha()
		      + "\nBruto: " + df.format(this.getBruto())
		      + "\nLiquido: " + df.format(this.getLiquido());
		
	}
	
	
}
