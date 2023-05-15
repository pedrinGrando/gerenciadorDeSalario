package model.view;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

import calculosINSSeIR.Calculos;
import model.dao.DespesaDAO;
import model.dao.TabelaDAO;
import model.vo.TabelaVO;
import model.vo.UserVO;

public class MenuSaldo {

	Scanner teclado = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("0.00");
	
	public void apresentarMenuSaldo(UserVO userVO) {
		System.out.println("------------- Cálculo de Saldo -----------------------");    
		System.out.print("\nDeseja inserir VR(vale-alimentação)? ");          
		System.out.print("\nOpção: ");  
		
		// VARIAVIES E OBJETOS
		String resp = teclado.next();
		double vr = 0;
		double saldoP = 0;
		double saldo = 0;
		TabelaVO tabelaVO = new TabelaVO();
		
		System.out.print("Digite o saldo: ");                                            
		  saldoP = teclado.nextDouble();
	
		if(resp.equalsIgnoreCase("sim")) {
			
		System.out.print("Digite o valor do VR: R$ ");                                    
		vr = teclado.nextDouble();
		
	    } 
		  //SAlDO FINAL ARMAZENADO
	       saldo = saldoP + vr;  
	        
	     
		  //CALCULO
	       Calculos calculo = new Calculos();
	       
		   double rest = userVO.getBruto() + saldo;
		   System.out.println("---------------------------------------------");
		   System.out.print("Salário Bruto: " + df.format(userVO.getBruto()));                       
		   
		   //descontos INSS/IRR
		   double inss = calculo.calcularINSS(userVO.getBruto());
		   double restDesc = this.calcularDescontoTotal(userVO, userVO.getBruto());
		   double liquidoFinal = rest - restDesc;
		   double saldoFinal = liquidoFinal - inss;
		   
		   // CONVERSAO DE MES 
		   LocalDate dataAtual = LocalDate.now(); //MES ATUAL
		   Locale brasil = new Locale("pt", "BR");
		   DateTimeFormatter fout1 = DateTimeFormatter.ofPattern("EEEE", brasil);
		   String mes = (dataAtual.getMonth().getDisplayName(TextStyle.FULL, brasil));
		   
		   //IMPRESSAO DE TABELA DE SALDO
	       System.out.print("\nMês: " + mes.toUpperCase(brasil) + "| Saldo somado: R$ " + df.format(rest));
	       System.out.print("\nSaldo final descontado: R$ " + df.format(saldoFinal));                   
	       
	       //ITEM TABELA VO
	       tabelaVO.setData(dataAtual.getMonth().getDisplayName(TextStyle.FULL, brasil));
	       tabelaVO.setAno(dataAtual.getYear());
	       tabelaVO.setTotalRest(saldoFinal);
	       tabelaVO.setSaldo(saldoP);
	       
	      System.out.println("\n---------------------------------------------");
	       System.out.print("\nDeseja salvar os dados deste mês? ");
	       System.out.print("\nResposta: ");
	       String res = teclado.next();
	       
	       // CONDICAO DE SALVAMENTO
	       if (res.equalsIgnoreCase("sim")) {
	    	MenuTabela menuTabela = new MenuTabela();
	    	menuTabela.salvarDadosTabela(userVO, tabelaVO);
	       } else {
	    	   System.out.println("Menu saldo Encerrado! ");
	       }
	       
	       
	}

	//Calculo de despesas total
	private double calcularDescontoTotal(UserVO userVO, double bruto) {
		double total = 0;
		DespesaDAO despesaDAO = new DespesaDAO();
		total = despesaDAO.calcularDescontoTotalDAO(userVO, bruto);
		
		return total;
	}
}
