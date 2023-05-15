package model.bo;

import model.dao.DespesaDAO;
import model.vo.DespesaVO;
import model.vo.UserVO;

public class DespesaBO {

	public DespesaVO inserirDespesaBO(DespesaVO despesaVO) {
	     DespesaDAO despesaDAO = new DespesaDAO();
		return despesaDAO.inserirDespesaDAO(despesaVO);
	}

	public boolean excluirDespesaBO(UserVO userVO, int idDespesa) {
		boolean resultado = false;
		DespesaDAO despesaDAO = new DespesaDAO();
		
		resultado = despesaDAO.excluirDespesaDAO(userVO, idDespesa);
	
		return resultado;
	
	}

	public DespesaVO consultarDespesaPorNome(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		DespesaVO despesa = despesaDAO.consultarDespesaPorNomeDAO(despesaVO);
		if (despesa == null) {
			System.out.println("Despesa não localizada! ");
		}
		
		return despesa;
	}

}
