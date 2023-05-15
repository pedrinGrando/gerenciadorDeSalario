package model.controller;

import model.bo.DespesaBO;
import model.bo.UserBO;
import model.vo.DespesaVO;
import model.vo.UserVO;

public class DespesaCONTROLLER {

	public DespesaVO inserirDespesaController(DespesaVO despesaVO) {
		DespesaBO despesaBO = new DespesaBO();
		return despesaBO.inserirDespesaBO(despesaVO);

	}

	public boolean excluirDespesaController(UserVO userVO, int idDespesa) {

		DespesaBO despesaBO = new DespesaBO();	
		return despesaBO.excluirDespesaBO(userVO, idDespesa);	
	}

	public DespesaVO consultarDespesaPorNome(DespesaVO despesaVO) {
		
		DespesaBO despesaBO = new DespesaBO();
		return despesaBO.consultarDespesaPorNome(despesaVO);
		
	}

}
