package model.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.controller.DespesaCONTROLLER;
import model.controller.UserCONTROLLER;
import model.vo.DespesaVO;
import model.vo.UserVO;

public class MenuDespesa {

	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter fin = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
         public void InserirDespesa(UserVO userVO) {
		     DespesaVO despesaVO = new DespesaVO();
        	 
        	 System.out.print("-------------- Nova Despesa --------------");
        	 despesaVO.setIdUsuario(userVO.getIdUsuario());
     		 System.out.print("\nPreencha os campos abaixo! ");
     		 System.out.print("\nDigite o nome para a despesa: ");
     		 despesaVO.setDivnome(teclado.nextLine());
     		 System.out.print("Digite a data do pagamento: ");
     		 despesaVO.setUltimoPagamento(LocalDate.parse(teclado.nextLine(), fin));
     		 System.out.print("Digite o valor da despesa: R$ ");
     		 despesaVO.setValor(teclado.nextDouble());
     		
     		 
     		DespesaCONTROLLER despesaController = new DespesaCONTROLLER();
     			despesaVO = despesaController.inserirDespesaController(despesaVO);
     			if (despesaVO.getIdDespesa() != 0) {
     				System.out.print("-------------------------------------");
					System.out.println("\n Despesa inserida com sucesso!      |     ");
					System.out.print("-------------------------------------");
     			} else {
     				System.out.println("Não foi possível inserir. ");
     			}
     			
     		}

		public void removerDespesa(UserVO userVO) {
			int idDespesa = 0;
			System.out.print("-------------- Remover Despesa --------------");
       	    System.out.print("\nInforme o código da despesa: ");
       	    idDespesa = teclado.nextInt();
       	    
       	 if (idDespesa == 0) {
 			System.out.println("Este campo é obrigatório!");

 		} else {
 			DespesaCONTROLLER despesaController = new DespesaCONTROLLER();
 			boolean resultado = despesaController.excluirDespesaController(userVO, idDespesa);
 			if (resultado) {
 				System.out.println("\nDespesa removida com sucesso! ");
 			} else {
 				System.out.println("\nNão foi possível remover esta despesa! ");
 			}
 
		}
		
	}

		public void consultarDespesa() {
			DespesaCONTROLLER despesaController = new DespesaCONTROLLER();
			DespesaVO despesaVO =  new DespesaVO();
			System.out.print("Informe o nome da despesa: ");
			despesaVO.setDivnome(teclado.nextLine());
			
			if (despesaVO.getDivnome().isEmpty() || despesaVO.getDivnome() == null) {
				System.out.println("É obrigatório informar o nome da despesa! ");
			} else {
				DespesaVO despesa = despesaController.consultarDespesaPorNome(despesaVO);
				System.out.print("\n------------ RESULTADO DA CONSULTA ------------ ");
				System.out.print(despesa);
				System.out.println();
			}
		}
}


