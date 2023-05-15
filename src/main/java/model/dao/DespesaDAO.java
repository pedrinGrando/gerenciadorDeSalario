package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.vo.DespesaVO;
import model.vo.UserVO;

public class DespesaDAO {

	public DespesaVO inserirDespesaDAO(DespesaVO despesaVO) {
		String query ="INSERT INTO despesa (idusuario, divnome, valor, ultimopagamento ) VALUES (?, ?, ?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			pstmt.setInt(1, despesaVO.getIdUsuario());
			pstmt.setString(2, despesaVO.getDivnome());
			pstmt.setDouble(3, despesaVO.getValor());
			pstmt.setObject(4, despesaVO.getUltimoPagamento());
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();	
			if(resultado.next()) {
				despesaVO.setIdDespesa(Integer.parseInt(resultado.getString(1)));
			}
			
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método inserirDespesaDAO");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return despesaVO;
	}

	public double calcularDescontoTotalDAO(UserVO userVO, double bruto) {
		double desconto = 0;
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT SUM(VALOR) as total "
				+ "FROM DESPESA "
				+ "WHERE idusuario = " + userVO.getIdUsuario();
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				desconto = resultado.getDouble(1);
				
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método calcularDescontoTotalDAO");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return desconto;
	}

	public boolean excluirDespesaDAO(UserVO userVO, int idDespesa) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		
		String query = "UPDATE despesa SET valor = " + 0
				+ " WHERE idusuario = " + userVO.getIdUsuario()
				+ " AND IDESPESA = " + idDespesa;
		
		try {
			if(stmt.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método excluirDespesaDAO");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	public DespesaVO consultarDespesaPorNomeDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		DespesaVO despesa = new DespesaVO();
		
		String query = "SELECT idespesa, idusuario, divnome, valor, ultimopagamento "
				+ "FROM DESPESA "
				+ "WHERE divnome like '" + despesaVO.getDivnome() + "'";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				despesa.setIdDespesa(Integer.parseInt(resultado.getString(1)));
				despesa.setIdUsuario(Integer.parseInt(resultado.getString(2)));
				despesa.setDivnome(resultado.getString(3));
				despesa.setValor(resultado.getDouble(4));
				despesa.setUltimoPagamento(LocalDate.parse(resultado.getString(5), 
						DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método consultarDespesaPorNomeDAO");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return despesa;
	}

	public int recuperarIdUsuarioPorCpf(String text) {
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		DespesaVO despesa = new DespesaVO();
		int idUserDesp = 0;
		
		String query = "SELECT idusuario "
				+ "FROM usuario "
				+ "WHERE cpf = " + text;
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				idUserDesp = Integer.parseInt(resultado.getString(1));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método recuperarIdUsuarioPorCpf");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
	
		return idUserDesp;
	}

	
	public DespesaVO inserirDespesaNovaInterfaceDAO(DespesaVO despesaNova) {
		String query ="INSERT INTO despesa (idusuario, divnome, valor, ultimopagamento ) VALUES (?, ?, ?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			pstmt.setInt(1, despesaNova.getIdUsuario());
			pstmt.setString(2, despesaNova.getDivnome());
			pstmt.setDouble(3, despesaNova.getValor());
			pstmt.setObject(4, despesaNova.getUltimoPagamento());
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();	
			if(resultado.next()) {
				despesaNova.setIdDespesa(Integer.parseInt(resultado.getString(1)));
			}
			
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método inserirDespesaDAO");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return despesaNova;
	}
	
	public boolean removerDespesaInterfaceDAO(int idUser, String nomeDiv) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		
		String query = "DELETE FROM despesa " 
				+ " WHERE idusuario = " + idUser
				+ " AND divnome = '" + nomeDiv +"' ";
		
		try {
			if(stmt.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método removerDespesaInterfaceDAO");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}
	
	public DespesaVO consultarDespesaPorNomeInterfaceDAO(DespesaVO despesaVO, int idUser) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		DespesaVO despesa = new DespesaVO();
		
		String query = "SELECT idespesa, idusuario, divnome, valor, ultimopagamento "
				+ "FROM DESPESA "
				+ "WHERE divnome like '" + despesaVO.getDivnome() + "'"
				+ "AND idusuario = " +idUser ;
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				despesa.setIdDespesa(Integer.parseInt(resultado.getString(1)));
				despesa.setIdUsuario(Integer.parseInt(resultado.getString(2)));
				despesa.setDivnome(resultado.getString(3));
				despesa.setValor(resultado.getDouble(4));
				despesa.setUltimoPagamento(LocalDate.parse(resultado.getString(5), 
						DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método consultarDespesaPorNomeDAO");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return despesa;
	}
	
}
