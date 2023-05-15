package model.controller;

import java.util.ArrayList;

import model.bo.UserBO;
import model.vo.UserVO;

public class UserCONTROLLER {

	public UserVO realizarLoginController(UserVO userVO) {
       UserBO userBO = new UserBO();
		return userBO.realizarLoginBO(userVO);
	}

	public UserVO cadastrarUsuarioController(UserVO userVO) {
		UserBO userBO = new UserBO();	
		return userBO.cadastrarUsuarioBO(userVO);
	}

	public ArrayList<UserVO> consultarTodosUsuariosController() {
		UserBO userBO = new UserBO();
		return userBO.consultarTodosUsuariosBO();
		
	}
	
	public UserVO consultarUsuarioController(UserVO userVO) {
		UserBO userBO = new UserBO();
		return userBO.consultarUsuarioBO(userVO);
	}

	public boolean atualizarUsuarioController(UserVO userVO) {
		UserBO userBO = new UserBO ();	
		return userBO.atualizarUsuarioBO(userVO);
	}

	public boolean inserirAumentoController(UserVO userVO, UserVO aumento) {
		UserBO userBO = new UserBO ();	
		return userBO.inserirAumentoBO(userVO, aumento);
	
	}

	public boolean inserirDescontoController(UserVO userVO, UserVO desconto) {
		UserBO userBO = new UserBO ();	
		return userBO.inserirDescontoBO(userVO, desconto);
	}
}
