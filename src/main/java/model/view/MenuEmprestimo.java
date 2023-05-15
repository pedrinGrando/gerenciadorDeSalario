package model.view;

import java.text.DecimalFormat;
import java.util.Scanner;
import model.dao.DespesaDAO;
import model.vo.DespesaVO;
import model.vo.UserVO;

public class MenuEmprestimo {
   
	Scanner teclado = new Scanner(System.in);
	double credito = 0;
	double dividaTotal = 0;
	double salario = 0;
	
	//Strings mensagens ao usuário 
	String semCredito = "\nVocê não tem crédito aprovado! ";
	String aprovado = "\nVocê possui linha de crédito aprovado! ";
	
		public void calculoDeEmprestimo(UserVO userVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		dividaTotal = despesaDAO.calcularDescontoTotalDAO(userVO, userVO.getBruto()) ;
		salario = userVO.getBruto();
		
		if (salario <= 500 && dividaTotal >= 300) {
			credito = 0;
		} if (salario <= 850 && dividaTotal >= 500) {
			credito = 0;
		}if (salario <= 1150 && dividaTotal >= 650) {
			credito = 0;
		}if (salario <= 1400 && dividaTotal >= 700) {
			credito = 0;
		}if (salario >= 1700 && dividaTotal <= 650) {
			credito = 650;
		}if (salario >= 2000 && dividaTotal <= 1000) {
			credito = 1050;
		}if (salario >= 2200 && dividaTotal <= 650) {
			credito = 650;
		}if (salario >= 2500 && dividaTotal <= 1500) {
			credito = 1654;
		}if (salario >= 2700 && dividaTotal <= 4000) {
			credito = 2358;
		}if (salario >= 3100 && dividaTotal <= 5000) {
			credito = 2954;
		} 
		
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("---------------- Menu de Empréstimo ---------------- ");
	    System.out.print("Calculando...");
	    System.out.print("\nCálculo finalizado! ");
		if (credito != 0) {
			System.out.print(aprovado);
		} else {
			System.out.println(semCredito);
		}
		System.out.print("\nCrédito disponível: R$ " + df.format(credito));
		
		
	}
	
}
