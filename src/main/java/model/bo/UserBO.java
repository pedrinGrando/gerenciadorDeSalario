package model.bo;

import java.util.ArrayList;

import model.dao.UserDAO;
import model.vo.UserVO;

public class UserBO {

	public UserVO realizarLoginBO(UserVO userVO) {
		UserDAO userDAO = new UserDAO();
		
		return userDAO.realizarLoginDAO(userVO);
	}

	public UserVO cadastrarUsuarioBO(UserVO userVO) {
		UserDAO userDAO = new UserDAO();
		if(userDAO.verificarExistenciaRegistroPorCpfDAO(userVO)) {
			System.out.println("\nUsuário já cadastrado!");
	}else {
		userVO = userDAO.cadastrarUsuarioDAO(userVO);
	}
		return userVO;
	}
	
	public ArrayList<UserVO> consultarTodosUsuariosBO() {
		UserDAO userDAO = new UserDAO();
		ArrayList<UserVO> listaUsuarioVO = userDAO.consultarTodosUsuariosDAO();
		if(listaUsuarioVO.isEmpty()) {
			System.out.println("\nLista de usuários está vázia! ");
			
		}
		return listaUsuarioVO;
	}
	
	public UserVO consultarUsuarioBO(UserVO userVO) {
		UserDAO userDAO = new UserDAO();
		UserVO usuario = userDAO.consultarUsuarioInterfaceDAO(userVO);
		if(usuario == null) {
			System.out.println("\nUsuário não localizado! ");
		}
		return usuario;
	}

	public boolean atualizarUsuarioBO(UserVO userVO) {
		boolean resultado = false;
		UserDAO userDAO = new UserDAO();
		if(userDAO.verificarExistenciaRegistroPorIdUsuarioDAO(userVO.getIdUsuario())) {
			resultado = userDAO.atualizarUsuarioDAO(userVO);
		} else {
				System.out.println("Usuário inexistente! ");
			}
			
		return resultado;
	}

	public boolean inserirAumentoBO(UserVO userVO, UserVO aumento) {
		boolean resultado = false;
		UserDAO userDAO = new UserDAO();
		if (userVO.getBruto() != 0) {
			resultado = userDAO.inserirAumentoDAO(userVO, aumento);
		} else {
			System.out.print("Usuário não possui salário cadastrado! ");
			System.out.print("\nCadastre seu salário na página inicial! ");
		}
		
		return resultado;
	}

	public boolean inserirDescontoBO(UserVO userVO, UserVO desconto) {
		boolean resultado = false;
		UserDAO userDAO = new UserDAO();
		if(userVO.getBruto() != 0) {
			resultado = userDAO.inserirDescontoDAO(userVO, desconto);
		} else {
			System.out.println("Usuário não possui salário cadastrado! ");
			System.out.println("Cadastre seu salário na página inicial! ");
		}
		
		
		return resultado;
	}
}
