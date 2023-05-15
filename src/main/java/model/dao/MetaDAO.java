package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.DespesaVO;
import model.vo.MetaVO;
import model.vo.UserVO;

public class MetaDAO {

	public MetaVO inserirMeta(MetaVO metaVO) {
		String query ="INSERT INTO metas (idusuario, nome, valor, dataprevista) VALUES (?, ?, ?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			pstmt.setInt(1, metaVO.getIdUsuario());
			pstmt.setString(2, metaVO.getNome());
			pstmt.setDouble(3, metaVO.getValor());
			pstmt.setObject(4, metaVO.getDataPrevista());
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();	
			if(resultado.next()) {
				metaVO.setIdMeta(Integer.parseInt(resultado.getString(1)));
			}
			
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método inserirMeta");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return metaVO;
	}
	
}
