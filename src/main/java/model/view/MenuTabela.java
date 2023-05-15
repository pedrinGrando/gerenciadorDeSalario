package model.view;

import java.util.ArrayList;
import java.util.Scanner;

import model.controller.TabelaCONTROLLER;
import model.dao.TabelaDAO;
import model.vo.TabelaVO;
import model.vo.UserVO;

public class MenuTabela {
	
	private static final int OPCAO_TABELA_CONSULTAR_DADO_ESPECIFICO = 1;
	private static final int OPCAO_TABELA_CONSULTAR_TABELA_COMPLETA = 2;
	private static final int OPCAO_TABELA_CONSULTAR_VOLTAR = 9;
	
	Scanner teclado = new Scanner(System.in);

	public void salvarDadosTabela(UserVO userVO, TabelaVO tabelaVO) {
		TabelaDAO tabelaDAO = new TabelaDAO();
		tabelaVO = tabelaDAO.salvarDadosTabelaDAO(userVO, tabelaVO);
	
		if(tabelaVO.getIdTabela() != 0 ) {
			System.out.print("-------------------------------------");
			System.out.println("\n Dados salvos com sucesso!        |     ");
			System.out.print("-------------------------------------");
			
		} else {
			System.out.println(" - Não foi possível salvar os dados! ");
			
		}
		
	}

	// CONSULTAS
	public void realizarConsultasTabela(UserVO userVO) {
	int opcao = this.apresentaOpcoesMenuTabelaMensais();
	TabelaCONTROLLER tabelaController = new TabelaCONTROLLER();
    while (opcao != OPCAO_TABELA_CONSULTAR_VOLTAR) { 
    	switch (opcao) {
    	
    	case OPCAO_TABELA_CONSULTAR_DADO_ESPECIFICO : {
    		//opcao = OPCAO_TABELA_CONSULTAR_VOLTAR;
    		TabelaVO tabelaVO = new TabelaVO();
    		tabelaVO.setIdUsuario(userVO.getIdUsuario());
    		System.out.println("------------ Tabela Mensal  ------------");
    		System.out.print("\n/Digite 'Nao' se deseja voltar a página inicial!/ ");
    		System.out.print("\nInforme o mês para consulta: ");
    		tabelaVO.setData(teclado.nextLine());
    		//TESTE
    		if (tabelaVO.getData().equalsIgnoreCase("nao")) {
    			Menu menu = new Menu();
    			menu.apresentarMenu(userVO);
   
    		}if (tabelaVO.getData() != "nao") {
    			TabelaVO tabela = tabelaController.consultarMesController(tabelaVO);
    			System.out.print("\n------------ Tabela Mensal  ------------ ");
				System.out.print(tabela);
				System.out.println();
				break;
				
    		} else {
    			System.out.println("O mês deve ser informado! ");
    		 }
    
    	   }
    		
    	case OPCAO_TABELA_CONSULTAR_TABELA_COMPLETA : {
    		//opcao = OPCAO_TABELA_CONSULTAR_VOLTAR;
    		TabelaVO tabelaVO = new TabelaVO();
    		tabelaVO.setIdUsuario(userVO.getIdUsuario());
    		ArrayList<TabelaVO> tabela_completaVO = tabelaController.consultarTabelaCompletaController(tabelaVO);
    		System.out.println("-------------- Tabela Completa ------------------------------------------");
    		System.out.printf("\n%3s  %-13s  %-13s  %-9s  %-10s  %-9s  ",
					"ID", "USUARIO", "MES", "ANO", "TOTAL", "SALDO");
    		
    		for (int i = 0; i < tabela_completaVO.size(); i++ ) {
    			tabela_completaVO.get(i).imprimir();
			}
    		
    		System.out.println("\n-------------- Tabela Completa ------------------------------------------");
    		System.out.print("\nDeseja voltar a página inicial? ");
    		System.out.print("\nResposta: ");
    		String res = teclado.next();
    		if (res.equalsIgnoreCase("sim")) {
    			Menu menu = new Menu();
    			menu.apresentarMenu(userVO);
    		}else {
    			Login login = new Login();
    			login.apresentarMenuLogin();
    		}
  
			System.out.println();
			break;
    		
    		
    	   }
    	
    	}

    }
}

	
	public int apresentaOpcoesMenuTabelaMensais() {
	
		System.out.println("-------------- Menu de Tabela mensal --------------");
		System.out.println(OPCAO_TABELA_CONSULTAR_DADO_ESPECIFICO + " - Consultar mês específico");
		System.out.println(OPCAO_TABELA_CONSULTAR_TABELA_COMPLETA + " - Consultar tabela completa (TESTE)");
		System.out.print("\nOpção: ");
		
		return Integer.parseInt(teclado.nextLine());
	}

}
