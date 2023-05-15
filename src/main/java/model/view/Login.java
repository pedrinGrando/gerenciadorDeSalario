package model.view;

import java.text.DecimalFormat;
import java.util.Scanner;

import model.controller.UserCONTROLLER;
import model.vo.UserVO;

public class Login {

	private static final int OPCAO_MENU_LOGIN = 1; //CONSTANTE PADRAO É LETRA MAISCULA
	private static final int OPCAO_MENU_CRIAR_CONTA = 2;
	private static final int OPCAO_MENU_SAIR = 9;
	
	Scanner teclado = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("0.00");
	
	public void apresentarMenuLogin() {
		int opcao = this.apresentarOpcoesMenu();
		while (opcao != OPCAO_MENU_SAIR) {
			switch (opcao) {
			
				case OPCAO_MENU_LOGIN: {
					UserVO userVO = this.realizarLogin();// VO É UM VELHO OBJECT REPRESENTA UMA TABELA DO BANCO DE DADOS
					if(userVO.getIdUsuario() != 0) {
						System.out.print("-------------------------------------");
						System.out.println("\n Login efetuado com sucesso!        |     ");
						System.out.print("-------------------------------------");
						System.out.println("\nNome: " + userVO.getNome());
						System.out.println("CPF: " + userVO.getCpf());
						System.out.println("Salário Bruto atual: R$ " + df.format(userVO.getBruto()));
						
						Menu menu = new Menu();
						menu.apresentarMenu(userVO);
						
					}
					break;
				}
				case OPCAO_MENU_CRIAR_CONTA: {
					this.cadastrarNovoUsuario();
					break;
				}
				default: {
					System.out.println("\nOpção digitada inválida! ");
				}
			}
			opcao = this.apresentarOpcoesMenu(); //INTERATIVIDADE PARA QUE O PROGRAMA ENCERRE QUANDO O USUARIO QUISER (QUEBRA LOOPING)
		}
	}
	
	private UserVO realizarLogin() {
		UserVO userVO = new UserVO();
		System.out.println("< ----------- Entrar ----------- >");
		System.out.print("Usuário: ");
		userVO.setLogin(teclado.nextLine());
		System.out.print("Senha: ");
		userVO.setSenha(teclado.nextLine());
		
		if (userVO.getLogin().isEmpty() || userVO.getSenha().isEmpty()) {
			System.out.println("Os campos de login e senha são obrigatórios! ");
			
		} else {
			UserCONTROLLER userController = new UserCONTROLLER();
			userVO = userController.realizarLoginController(userVO);
			if(userVO.getIdUsuario() == 0) {
				System.out.println("Usuário não encontrado! ");
			}
		}
		return userVO;
	}

	public int apresentarOpcoesMenu() {
		System.out.println("< ------------ GS Gerenciador System ------------ >");
		System.out.println("\nBem Vindo! ");
		System.out.println("\nOpções: ");
		System.out.println(OPCAO_MENU_LOGIN + " - Realizar Login");
		System.out.println(OPCAO_MENU_CRIAR_CONTA + " - Cadastrar");
		System.out.println(OPCAO_MENU_SAIR + " - Encerrar");
		System.out.print("\nDigite uma opção: ");
		
		return Integer.parseInt(teclado.nextLine());
	}

	private void cadastrarNovoUsuario() {
		UserVO userVO = new UserVO();
		userVO.setTipoUsuario(2);
		MenuUsuario menuUsuario = new MenuUsuario();
		menuUsuario.cadastrarUsuario(userVO);
		
	}
}
