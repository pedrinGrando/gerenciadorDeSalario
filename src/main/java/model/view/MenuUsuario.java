package model.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import model.controller.UserCONTROLLER;
import model.vo.UserVO;

public class MenuUsuario {
	
	private static final int OPCAO_MENU_CONSULTAR_TODOS_USERS = 2;
	private static final int OPCAO_MENU_CONSULTAR_UM_USER = 1;
	private static final int OPCAO_MENU_CONSULTAR_USUARIO_VOLTAR = 9;
	
	//ATUALIZAÇÕES
	private static final int OPCAO_ATUALIZAR_TIPOUSUARIO = 1;
	private static final int OPCAO_ATUALIZAR_NOME = 2;
	private static final int OPCAO_ATUALIZAR_CPF = 3;
	private static final int OPCAO_ATUALIZAR_DATANASCI = 4;
	private static final int OPCAO_ATUALIZAR_EMAIL = 5;
	private static final int OPCAO_ATUALIZAR_LOGIN = 6;
	private static final int OPCAO_ATUALIZAR_SENHA = 7;
	private static final int OPCAO_ATUALIZAR_BRUTO = 8;
	private static final int OPCAO_ATUALIZAR_LIQUIDO = 9;
	private static final int OPCAO_ATUALIZAR_voltar = 0;
	
	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter fin = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public void cadastrarUsuario(UserVO userVO) {
		System.out.println("-------------- Cadastro --------------");
		System.out.println("Preencha os campos abaixo! ");
		
		System.out.print("Digite o nome: ");
		userVO.setNome(teclado.nextLine());
		System.out.print("Digite o CPF: ");
		userVO.setCpf(teclado.nextLine());
		System.out.print("Digite sua data de nascimento: ");
		userVO.setDataNasci(LocalDate.parse(teclado.nextLine(), fin));
		System.out.print("Digite o e-mail: ");
		userVO.setEmail(teclado.nextLine());
		System.out.print("-------------- Segunda etapa --------------");
		System.out.print("\nCrie seu login: ");
	    userVO.setLogin(teclado.nextLine());
	    System.out.print("Digite sua senha: (últimos 4 dígitos do cpf): ");
		userVO.setSenha(teclado.nextLine());
		System.out.print("-------------- Última etapa --------------");
		System.out.print("\nDigite seu salário bruto: R$ ");
		userVO.setBruto(teclado.nextDouble());
		System.out.print("\nDigite seu salário líquido: R$ ");
		userVO.setLiquido(teclado.nextDouble());
		
	
		if (this.validarCamposCadastro(userVO)) {
			UserCONTROLLER userContrller = new UserCONTROLLER();
			userVO = userContrller.cadastrarUsuarioController(userVO);
			if (userVO.getIdUsuario() != 0) {
				System.out.print("-------------------------------------");
				System.out.println("\n Usuário cadastrado com sucesso!        |     ");
				System.out.print("-------------------------------------");
				System.out.println("Faça o login na página inicial.");
			} else {
				System.out.println("Não foi possível cadastrar o usuário! ");
			}
			
		}	
	}

	private boolean validarCamposCadastro(UserVO userVO) {
		
		boolean resultado = true;
		System.out.println();
		if (userVO.getNome() == null || userVO.getNome().isEmpty()) {
			System.out.println("O campo de Nome é obrigatório! ");
			resultado = false;
		}
		
		if (userVO.getCpf() == null || userVO.getCpf().isEmpty()) {
			System.out.println("O campo CPF é obrigatório! ");
			resultado = false;
		}
		
		if (userVO.getDataNasci() == null) {
			System.out.println("A data de nascimento é obrigatória! ");
			resultado = false;
		
		}
		
		if (userVO.getEmail() == null || userVO.getEmail().isEmpty()) {
			System.out.println("O campo E-mail é obrigatório! ");
			resultado = false;
			
		}
		
		if (userVO.getLogin() == null || userVO.getLogin().isEmpty()) {
			System.out.println("O campo login é obrigatório! ");
			resultado = false;
			
		}
		
		if (userVO.getSenha() == null || userVO.getSenha().isEmpty()) {
			System.out.println("O campo senha é obrigatório! ");
			resultado = false;
		}
		
		if (userVO.getBruto() == 0) {
		System.out.println("É obrigatório informar um salário bruto! ");
		resultado = false;
		}
		
		if (userVO.getLiquido() == 0) {
			System.out.println("É obrigatório informar um salário líquido! ");
			resultado = false;
			}
		return resultado;
	}


	public void realizarConsulta() {
		
		int opcao = this.apresentarOpcoesDeConsultas();
		UserCONTROLLER userController = new UserCONTROLLER();
		while(opcao != OPCAO_MENU_CONSULTAR_USUARIO_VOLTAR) {
			switch (opcao) {
			
			
			case OPCAO_MENU_CONSULTAR_UM_USER: {
				opcao = OPCAO_MENU_CONSULTAR_USUARIO_VOLTAR;
				UserVO userVO = new UserVO();
				System.out.print("Informe o código do usuário: ");
				userVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
				if (userVO.getIdUsuario() != 0) {
					UserVO usuario = userController.consultarUsuarioController(userVO);
					System.out.print("\n------------ RESULTADO DA CONSULTA ------------ ");
					System.out.print(usuario);
					System.out.println();
					
					
				} else {
					System.out.println("O código do usuário é obrigatório! ");
				}
				break;
			}
			
			case OPCAO_MENU_CONSULTAR_TODOS_USERS: {
				opcao = OPCAO_MENU_CONSULTAR_USUARIO_VOLTAR;
				ArrayList<UserVO> lista_usuariosVO = userController.consultarTodosUsuariosController();
				System.out.print("\n------------ RESULTADO DA CONSULTA ------------ ");
				System.out.printf("\n%3s  %-13s  %-20s  %-11s  %-25s  %-24s  %-10s  %-10s  ",
						"ID", "TIPO USUÁRIO", "NOME", "CPF", "DATA-NASCIMENTO", "EMAIL", "LOGIN", "SENHA", 
						"BRUTO", "LIQUIDO");
				for (int i = 0; i < lista_usuariosVO.size(); i++ ) {
					lista_usuariosVO.get(i).imprimir();
				}
				System.out.println();
				break;
			}
			
			default: {
			System.out.println("\nOpcão inválida! ");
			opcao = this.apresentarOpcoesDeConsultas();
			}
		}
	}
}
	

	private int apresentarOpcoesDeConsultas() {
		System.out.println("------------ Menu de Consultas ------------");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_USER +" - Consultar um usuário expecífico");
		System.out.println(OPCAO_MENU_CONSULTAR_TODOS_USERS + "- Consultar lista completa");
		System.out.println(OPCAO_MENU_CONSULTAR_USUARIO_VOLTAR +" - Voltar");
		System.out.print("\nDigite uma opção: ");
			System.out.println();
		
		return Integer.parseInt(teclado.nextLine());
	}

	public void atualizarUsuario() {
			UserVO userVO = new UserVO();
			UserCONTROLLER userController = new UserCONTROLLER();
			System.out.println("------------ Atualizar Perfil ------------");
			System.out.print("Informe o código do usuário: ");
			userVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
			
			userVO.setTipoUsuario(2);
			System.out.print("Digite o novo nome: ");
			userVO.setNome(teclado.nextLine());
			System.out.print("Digite o CPF: ");
			userVO.setCpf(teclado.nextLine());
			System.out.print("digite a data de nascimento: ");
			userVO.setDataNasci(LocalDate.parse(teclado.nextLine(), fin));
			System.out.print("Digite o novo e-mail: ");
			userVO.setEmail(teclado.nextLine());
			System.out.print("Atualize o login: ");
			userVO.setLogin(teclado.nextLine());
			System.out.print("Digite a nova senha: ");
			userVO.setSenha(teclado.nextLine());
			System.out.print("Novo salário bruto: R$ ");
			userVO.setBruto(teclado.nextDouble());
			System.out.print("Novo salário líquido: R$ ");
			userVO.setLiquido(teclado.nextDouble());
			
			 boolean resultado = userController.atualizarUsuarioController(userVO);
				if (resultado) {
					System.out.print("-------------------------------------");
					System.out.println("\n Usuário atualizado com sucesso!     |     ");
					System.out.print("-------------------------------------");
				} else {
					System.out.println("Não foi possível atualizar o usuário! ");
		}
	}

	public void inserirAumento(UserVO userVO) {
	     UserVO aumento = new UserVO();
	     UserCONTROLLER userController = new UserCONTROLLER();
	     System.out.print("Informe o aumento recebido: R$");
	     aumento.setBruto(teclado.nextDouble());
	     boolean resultado = userController.inserirAumentoController(userVO, aumento);
	     
	      if (resultado) {
	    		System.out.print("-------------------------------------");
				System.out.println("\n Aumento cadastrado com sucesso!     |     ");
				System.out.print("-------------------------------------");
	      } else {
	    	 System.out.println("Não foi possível inserir o aumento! ");
	      }
	}

	public void inserirDesconto(UserVO userVO) {
		double valor = 0;
		UserVO desconto = new UserVO();
		UserCONTROLLER userController = new UserCONTROLLER();
		boolean resultado = false;
		System.out.print("Informe o valor do desconto: R$ ");
		valor = teclado.nextDouble();
		if (valor < userVO.getBruto()) {
			desconto.setBruto(valor);
			resultado = userController.inserirDescontoController(userVO, desconto);
		}if (resultado) {
    		System.out.print("-------------------------------------");
			System.out.println("\n Desconto inserido com sucesso!     |     ");
			System.out.print("-------------------------------------");
      } else if (valor > userVO.getBruto()) {
    	 System.out.println("  - O valor informado é maior que o salário bruto!  ");
    	 valor = 0;
      }
	
		
	}
	
}
		



