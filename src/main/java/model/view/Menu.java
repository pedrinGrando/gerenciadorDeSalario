package model.view;


import java.util.Scanner;

import model.vo.UserVO;

public class Menu {
	
	
	//Opçoes do sistema
	private static final int OPCAO_MENU_CALCULAR_SALDO = 1;
	private static final int OPCAO_MENU_CONSULTAR_USUARIO = 2;
	private static final int OPCAO_MENU_INSERIR_DESPESA = 3;
	private static final int OPCAO_MENU_REMOVER_DESPESA = 4;
	private static final int OPCAO_MENU_ATUALIZAR_DADOS = 5;
	
	//TESTES
	private static final int OPCAO_MENU_CONSULTAR_DESPESA = 6;
	private static final int OPCAO_MENU_CONSULTA_DE_SALDOS_MENSAIS = 7;
	private static final int OPCAO_MENU_INSERIR_AUMENTO = 8;
	private static final int OPCAO_MENU_INSERIR_DESCONTO = 9;
	private static final int OPCAO_MENU_SIMULAR_EMPRESTIMO = 10;
	
	
	private static final int OPCAO_MENU_VOLTAR = 0;
	

	Scanner teclado = new Scanner(System.in);

	public void apresentarMenu(UserVO userVO) {
	
			int opcao = this.apresentarOpcoesMenu(userVO);
			while(opcao != OPCAO_MENU_VOLTAR) {
				switch(opcao) {
				case OPCAO_MENU_CALCULAR_SALDO: {
					MenuSaldo menuSaldo = new MenuSaldo();
					menuSaldo.apresentarMenuSaldo(userVO);
					break;
				}
				case OPCAO_MENU_CONSULTAR_USUARIO: {
					if (userVO.getTipoUsuario() == 1) {
						MenuUsuario menuUsuario = new MenuUsuario();
						menuUsuario.realizarConsulta();
					}
				
						
					break;
				         }
				case OPCAO_MENU_REMOVER_DESPESA: {
					MenuDespesa menuDespesa = new MenuDespesa();
					menuDespesa.removerDespesa(userVO);
					break;
				}
				
					
				case OPCAO_MENU_INSERIR_DESPESA : {
						MenuDespesa menuDespesa = new MenuDespesa();
						menuDespesa.InserirDespesa(userVO);
					break;
					}
					
				case OPCAO_MENU_ATUALIZAR_DADOS : {
						MenuUsuario menuUsuario = new MenuUsuario();
						menuUsuario.atualizarUsuario();
					break;
					}
				
				case OPCAO_MENU_CONSULTAR_DESPESA : {
					MenuDespesa menuDespesa = new MenuDespesa();
					menuDespesa.consultarDespesa();
					break;
				}
				
				case OPCAO_MENU_CONSULTA_DE_SALDOS_MENSAIS : {
					MenuTabela menuTabela = new MenuTabela();
					menuTabela.realizarConsultasTabela(userVO);
				}
				
				
				case OPCAO_MENU_INSERIR_AUMENTO : {
					MenuUsuario menuUsuario = new MenuUsuario();
					menuUsuario.inserirAumento(userVO);
					break;
				}
				case OPCAO_MENU_INSERIR_DESCONTO : {
					MenuUsuario menuUsuario = new MenuUsuario();
					menuUsuario.inserirDesconto(userVO);
					break;
				}
				case OPCAO_MENU_SIMULAR_EMPRESTIMO : {
					MenuEmprestimo menuEmprestimo = new MenuEmprestimo();
					menuEmprestimo.calculoDeEmprestimo(userVO);
					break;
				}
				
				    default : {
					System.out.println("\nOpção Inválida!");
				}
				
				}
			
		opcao = this.apresentarOpcoesMenu(userVO);
				}
			}
	
	private int apresentarOpcoesMenu(UserVO userVO) {
		System.out.println("\n---------- GS Gerenciador System -------------");
		System.out.println("------------ Menu Principal ------------------");
		System.out.println("\nOpcões: ");
		System.out.println(OPCAO_MENU_CALCULAR_SALDO + " - Cálculo de saldo"  + "            "   + OPCAO_MENU_CONSULTAR_DESPESA + " - Consultar despesa");
		System.out.println(OPCAO_MENU_CONSULTAR_USUARIO + " - Consulta de usuário " +  "        "    + OPCAO_MENU_CONSULTA_DE_SALDOS_MENSAIS + " - Tabela de saldos mensais");
		System.out.println(OPCAO_MENU_INSERIR_DESPESA + " - Inserir despesa" + "             "   + OPCAO_MENU_INSERIR_AUMENTO + " - Inserir aumento");   
		System.out.println(OPCAO_MENU_REMOVER_DESPESA + " - Remover despesa"+  "             "  + OPCAO_MENU_INSERIR_DESCONTO + " - Inserir desconto" );
		System.out.println(OPCAO_MENU_ATUALIZAR_DADOS + " - Atualizar dados" + "             "   + OPCAO_MENU_SIMULAR_EMPRESTIMO + " - Simular empréstimo");
		System.out.print("\nDigite uma opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

}