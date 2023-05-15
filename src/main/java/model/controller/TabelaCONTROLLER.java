package model.controller;

import java.util.ArrayList;

import model.bo.TabelaBO;
import model.vo.TabelaVO;

public class TabelaCONTROLLER {

	public TabelaVO consultarMesController(TabelaVO tabelaVO) {
		TabelaBO tabelaBO = new TabelaBO();
		return tabelaBO.consultarMesTabelaBO(tabelaVO);
	}

	public ArrayList<TabelaVO> consultarTabelaCompletaController(TabelaVO tabelaVO) {
		TabelaBO tabelaBO = new TabelaBO();
		return tabelaBO.consultarTabelaCompletaBO(tabelaVO);
	}

	
}
