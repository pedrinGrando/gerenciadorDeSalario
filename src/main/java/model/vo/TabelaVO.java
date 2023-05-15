package model.vo;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class TabelaVO {
          
	     private int idTabela;
	     private int idUsuario;
	     private String data;
	     private int ano;
	     private double totalRest;
	     private double saldo;
	     
		public TabelaVO(int idTabela, int idUsuario, String data, int ano, double totalRest, double saldo) {
			super();
			this.idTabela = idTabela;
			this.idUsuario = idUsuario;
			this.data = data;
			this.ano = ano;
			this.totalRest = totalRest;
			this.saldo = saldo;
		}

		public TabelaVO() {
			super();
		}

		public int getIdTabela() {
			return idTabela;
		}

		public void setIdTabela(int idTabela) {
			this.idTabela = idTabela;
		}

		public int getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public int getAno() {
			return ano;
		}

		public void setAno(int ano) {
			this.ano = ano;
		}

		public double getTotalRest() {
			return totalRest;
		}

		public void setTotalRest(double totalRest) {
			this.totalRest = totalRest;
		}

		public double getSaldo() {
			return saldo;
		}

		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}
	     
		DecimalFormat df = new DecimalFormat("0.00");
		
	public String toString() {
		return 
			     "\nUsuário: " + this.getIdUsuario()
			      + "\n- Mês: " + this.getData()
			      + "\n- Ano: " + this.getAno()
			      + "\n- Total Final: R$ " + df.format(this.getTotalRest())
			      + "\n- Saldo FInal: R$ " + df.format(this.getSaldo());
		}

	public void imprimir() {
		System.out.printf("\n%3d  %-10s  %-16s  %-8s  %-12s  %-2s ", 
				this.getIdTabela(),
				this.getIdUsuario(),
				this.getData(),
				this.getAno(),
				this.getTotalRest(),
				this.getSaldo());
	}
}
