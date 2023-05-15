package model.bo;

import java.util.ArrayList;

import model.dao.TabelaDAO;
import model.vo.TabelaVO;

public class TabelaBO {

	public TabelaVO consultarMesTabelaBO(TabelaVO tabelaVO) {
		TabelaDAO tabelaDAO = new TabelaDAO();
		TabelaVO tabela = tabelaDAO.consultarMesTabelaDAO(tabelaVO);
		if(tabela == null) {
			System.out.println("\nDados não encontrados! ");
		}
		return tabela;
	}

	public ArrayList<TabelaVO> consultarTabelaCompletaBO(TabelaVO tabelaVO) {
		TabelaDAO tabelaDAO = new TabelaDAO();
		ArrayList<TabelaVO> tabela_completaVO = tabelaDAO.consultarTabelaCompletaDAO(tabelaVO);
		if(tabela_completaVO.isEmpty()) {
			System.out.println("\nTabela sem dados registrados! ");
		}
		
		return tabela_completaVO;
	}

}
