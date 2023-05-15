package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.vo.UserVO;

public class UserDAO {

	public UserVO realizarLoginDAO(UserVO userVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT u.idusuario, u.tipousuario, u.nome, u.cpf, u.datanasci, "
				+ "u.bruto, u.liquido, u.email "
				+ "FROM USUARIO u "
				+ "WHERE u.login like '" + userVO.getLogin() + "' "
				+ "AND u.senha like '" + userVO.getSenha() + "' ";
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				userVO.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				userVO.setTipoUsuario(Integer.parseInt(resultado.getString(2)));
				userVO.setNome(resultado.getString(3));
				userVO.setCpf(resultado.getString(4));
				userVO.setDataNasci(LocalDate.parse(resultado.getString(5),
						DateTimeFormatter.ofPattern("yyy-MM-dd")));
				userVO.setBruto(Double.parseDouble(resultado.getString(6)));
				userVO.setLiquido(Double.parseDouble(resultado.getString(7)));
				userVO.setEmail(resultado.getString(5));
				
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do realizarLoginDAO!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		

		return userVO;
	}
	
	
	
	

	public UserVO cadastrarUsuarioDAO(UserVO userVO) {
		
		String query ="INSERT INTO usuario (tipousuario, nome, cpf, datanasci, email, login, senha, "
				+ " bruto, liquido ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			pstmt.setInt(1, userVO.getTipoUsuario());
			pstmt.setString(2, userVO.getNome());
			pstmt.setString(3, userVO.getCpf());
			pstmt.setObject(4, userVO.getDataNasci());
			pstmt.setString(5, userVO.getEmail());
			pstmt.setString(6, userVO.getLogin());
			pstmt.setString(7, userVO.getSenha());
			pstmt.setDouble(8, userVO.getBruto());
			pstmt.setDouble(9, userVO.getLiquido());
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();	
			if(resultado.next()) {
				userVO.setIdUsuario(Integer.parseInt(resultado.getString(1)));
			}
			
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método cadastrarUsuarioDAO");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return userVO;
		
	}
	
	public boolean verificarExistenciaRegistroPorCpfDAO(UserVO user) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		boolean retorno = false;
		String query = "SELECT cpf FROM usuario WHERE cpf = '" + user.getCpf() + "' ";
		try {
		resultado = stmt.executeQuery(query);
		if(resultado.next()) {
			retorno = true;
		}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método verificarExistenciaRegistroPorCpfDAO");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return retorno;
	}

	public ArrayList<UserVO> consultarTodosUsuariosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<UserVO> listaUsuarioVO = new ArrayList<UserVO>();
		
		String query = "SELECT idusuario, tipousuario, nome, cpf, "
				+ " datanasci, email, login, "
				+ " senha, bruto, liquido "
				+ "FROM usuario ";
			
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				UserVO usuario = new UserVO();
				usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuario.setTipoUsuario(Integer.parseInt(resultado.getString(2)));
				usuario.setNome(resultado.getString(3));
				usuario.setCpf(resultado.getString(4));
				usuario.setDataNasci(LocalDate.parse(resultado.getString(5), 
						DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				usuario.setEmail(resultado.getString(6));
				usuario.setLogin(resultado.getString(7));
				usuario.setSenha(resultado.getString(8));
				usuario.setBruto(resultado.getDouble(9));
				usuario.setLiquido(resultado.getDouble(10));
				listaUsuarioVO.add(usuario);
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método consultarTodosUsuariosDAO");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaUsuarioVO;
	}
	
	
	public UserVO consultarUsuarioDAO(UserVO userVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		UserVO usuario = new UserVO();
		
		String query = "SELECT u.idusuario, u.tipousuario, u.nome, u.cpf, u.datanasci, "
				+ "u.email, u.login, u.senha, u.liquido, u.bruto "
				+ "FROM USUARIO u "
				+ "WHERE u.idusuario = " + userVO.getIdUsuario();
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuario.setTipoUsuario(Integer.parseInt(resultado.getString(2)));
				usuario.setNome(resultado.getString(3));
				usuario.setCpf(resultado.getString(4));
				usuario.setDataNasci(LocalDate.parse(resultado.getString(5), 
						DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				usuario.setEmail(resultado.getString(6));
				usuario.setLogin(resultado.getString(7));
				usuario.setSenha(resultado.getString(8));
				usuario.setBruto(resultado.getDouble(9));
				usuario.setLiquido(resultado.getDouble(10));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método consultarUsuarioDAO");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuario;
	}

	public boolean atualizarUsuarioDAO(UserVO userVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		
		String query = "UPDATE usuario SET tipousuario = " + userVO.getTipoUsuario()
				+ ", nome = '" + userVO.getNome()
				+ "', cpf = '" + userVO.getCpf()
				+ "', datanasci = '" + userVO.getDataNasci()
				+ "', email = '" + userVO.getEmail()
				+ "', login = '" + userVO.getLogin()
				+ "', senha = '" + userVO.getSenha()
				+ "', bruto = '" + userVO.getBruto()
				+ "', liquido = '" + userVO.getLiquido()
				+ "' WHERE idusuario = " + userVO.getIdUsuario();
		 
		
		try {
			if(stmt.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método atualizarUsuarioDAO");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	public boolean verificarExistenciaRegistroPorIdUsuarioDAO(int idUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		boolean retorno = false;
		String query = "SELECT idusuario FROM usuario WHERE idusuario = " + idUsuario;
		try {
		resultado = stmt.executeQuery(query);
		if(resultado.next()) {
			retorno = true;
		}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método verificarExistenciaRegistroPorIdusuarioDAO");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return retorno;

	}

	public boolean inserirAumentoDAO(UserVO userVO, UserVO aumento) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		double soma = userVO.getBruto() + aumento.getBruto();
		
		String query = "UPDATE usuario SET bruto = " + soma
		+ "WHERE idusuario = " + userVO.getIdUsuario();
 

   try {
	   if(stmt.executeUpdate(query) == 1) {
		retorno = true;
	   }
          } catch (SQLException erro) {
	System.out.println("Erro ao executar a query do método inserirAumentoDAO");
	System.out.println("Erro: " + erro.getMessage());	
   } finally {
	Banco.closeStatement(stmt);
	Banco.closeConnection(conn);
    }
	
		return retorno;
	}

	public boolean inserirDescontoDAO(UserVO userVO, UserVO desconto) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		double descontar = userVO.getBruto() -  desconto.getBruto();
		
		String query = "UPDATE usuario SET bruto = " + descontar
		+ "WHERE idusuario = " + userVO.getIdUsuario();
 

   try {
	   if(stmt.executeUpdate(query) == 1) {
		retorno = true;
	   }
          } catch (SQLException erro) {
	System.out.println("Erro ao executar a query do método inserirAumentoDAO");
	System.out.println("Erro: " + erro.getMessage());	
   } finally {
	Banco.closeStatement(stmt);
	Banco.closeConnection(conn);
    }
	
		return retorno;
	}
	
	public UserVO verificarNomeUsuarioInterface(UserVO userVericado) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		UserVO usuario = new UserVO();
		
		String query = "SELECT u.idusuario, u.tipousuario, u.nome, u.cpf, u.datanasci, "
				+ "u.email, u.login, u.senha, u.liquido, u.bruto "
				+ "FROM USUARIO u "
				+ "WHERE u.cpf = " + userVericado.getCpf();
				
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuario.setTipoUsuario(Integer.parseInt(resultado.getString(2)));
				usuario.setNome(resultado.getString(3));
				usuario.setCpf(resultado.getString(4));
				usuario.setDataNasci(LocalDate.parse(resultado.getString(5), 
						DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				usuario.setEmail(resultado.getString(6));
				usuario.setLogin(resultado.getString(7));
				usuario.setSenha(resultado.getString(8));
				usuario.setBruto(resultado.getDouble(9));
				usuario.setLiquido(resultado.getDouble(10));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método consultarUsuarioDAO");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuario;
	}
	
	public UserVO consultarUsuarioPorIdInterfaceDAO(int idUser) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		UserVO usuario = new UserVO();
		
		String query = "SELECT u.idusuario, u.tipousuario, u.nome, u.cpf, u.datanasci, "
				+ "u.email, u.login, u.senha, u.liquido, u.bruto "
				+ "FROM USUARIO u "
				+ "WHERE u.idusuario = " + idUser;
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuario.setTipoUsuario(Integer.parseInt(resultado.getString(2)));
				usuario.setNome(resultado.getString(3));
				usuario.setCpf(resultado.getString(4));
				usuario.setDataNasci(LocalDate.parse(resultado.getString(5), 
						DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				usuario.setEmail(resultado.getString(6));
				usuario.setLogin(resultado.getString(7));
				usuario.setSenha(resultado.getString(8));
				usuario.setBruto(resultado.getDouble(9));
				usuario.setLiquido(resultado.getDouble(10));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método consultarUsuarioDAO");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuario;
	}
	
	public boolean inserirAumentoInterfaceDAO(UserVO userVO, double valorAumento) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		double soma = userVO.getBruto() + valorAumento;
		
		String query = "UPDATE usuario SET bruto = " + soma
		+ "WHERE idusuario = " + userVO.getIdUsuario();
 

   try {
	   if(stmt.executeUpdate(query) == 1) {
		retorno = true;
	   }
          } catch (SQLException erro) {
	System.out.println("Erro ao executar a query do método inserirAumentoDAO");
	System.out.println("Erro: " + erro.getMessage());	
   } finally {
	Banco.closeStatement(stmt);
	Banco.closeConnection(conn);
    }
	
		return retorno;
	}
	
	public boolean inserirDescontoInterfaceDAO(UserVO userVO, double valorDesconto) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		double descontar = userVO.getBruto() - valorDesconto;
		
		String query = "UPDATE usuario SET bruto = " + descontar
		+ "WHERE idusuario = " + userVO.getIdUsuario();
 

   try {
	   if(stmt.executeUpdate(query) == 1) {
		retorno = true;
	   }
          } catch (SQLException erro) {
	System.out.println("Erro ao executar a query do método inserirAumentoDAO");
	System.out.println("Erro: " + erro.getMessage());	
   } finally {
	Banco.closeStatement(stmt);
	Banco.closeConnection(conn);
    }
	
		return retorno;
	}
	
	public boolean atualizarNomeInterfaceDAO(UserVO userVO, String nome) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		
		String query = "UPDATE usuario SET nome = '" + nome +"' "
		+ "WHERE idusuario = " + userVO.getIdUsuario();
 
   try {
	   if(stmt.executeUpdate(query) == 1) {
		retorno = true;
	   }
          } catch (SQLException erro) {
	System.out.println("Erro ao executar a query do método atualizarNomeInterfaceDAO");
	System.out.println("Erro: " + erro.getMessage());	
   } finally {
	Banco.closeStatement(stmt);
	Banco.closeConnection(conn);
    }
	
		return retorno;
	}
	
	public boolean atualizarEmailInterfaceDAO(UserVO userVO, String email) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		
		String query = "UPDATE usuario SET email = '" + email +"' "
		+ "WHERE idusuario = " + userVO.getIdUsuario();
 
   try {
	   if(stmt.executeUpdate(query) == 1) {
		retorno = true;
	   }
          } catch (SQLException erro) {
	System.out.println("Erro ao executar a query do método atualizarEmailInterfaceDAO");
	System.out.println("Erro: " + erro.getMessage());	
   } finally {
	Banco.closeStatement(stmt);
	Banco.closeConnection(conn);
    }
	
		return retorno;
	}
	
	public boolean atualizarUsernameInterfaceDAO(UserVO userVO, String log) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		
		String query = "UPDATE usuario SET email = '" + log +"' "
		+ "WHERE idusuario = " + userVO.getIdUsuario();
 
   try {
	   if(stmt.executeUpdate(query) == 1) {
		retorno = true;
	   }
          } catch (SQLException erro) {
	System.out.println("Erro ao executar a query do método atualizarUsernameInterfaceDAO");
	System.out.println("Erro: " + erro.getMessage());	
   } finally {
	Banco.closeStatement(stmt);
	Banco.closeConnection(conn);
    }
	
		return retorno;
	}
	
	public boolean atualizarBrutoInterfaceDAO(UserVO userVO, double brut) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		
		String query = "UPDATE usuario SET bruto = " + brut
		+ "WHERE idusuario = " + userVO.getIdUsuario();
 
   try {
	   if(stmt.executeUpdate(query) == 1) {
		retorno = true;
	   }
          } catch (SQLException erro) {
	System.out.println("Erro ao executar a query do método atualizarBrutoInterfaceDAO");
	System.out.println("Erro: " + erro.getMessage());	
   } finally {
	Banco.closeStatement(stmt);
	Banco.closeConnection(conn);
    }
	
		return retorno;
	}
	
	public boolean atualizarUsuarioInterfaceDAO(UserVO userAtualizado) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		
		String query = "UPDATE usuario SET tipousuario = " + userAtualizado.getTipoUsuario()
				+ ", nome = '" + userAtualizado.getNome()
				+ "', email = '" + userAtualizado.getEmail()
				+ "', login = '" + userAtualizado.getLogin()
				+ "', bruto = '" + userAtualizado.getBruto()
				+ "' WHERE idusuario = " + userAtualizado.getIdUsuario();
		 
		try {
			if(stmt.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método atualizarUsuarioInterfaceDAO");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}
	
	public UserVO consultarUsuarioInterfaceDAO(UserVO userVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		UserVO usuario = new UserVO();
		
		String query = "SELECT u.idusuario, u.tipousuario, u.nome, u.cpf, u.datanasci, "
				+ "u.email, u.login, u.senha, u.liquido, u.bruto "
				+ "FROM USUARIO u "
				+ "WHERE u.nome = '" + userVO.getNome() +"' ";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuario.setTipoUsuario(Integer.parseInt(resultado.getString(2)));
				usuario.setNome(resultado.getString(3));
				usuario.setCpf(resultado.getString(4));
				usuario.setDataNasci(LocalDate.parse(resultado.getString(5), 
						DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				usuario.setEmail(resultado.getString(6));
				usuario.setLogin(resultado.getString(7));
				usuario.setSenha(resultado.getString(8));
				usuario.setBruto(resultado.getDouble(9));
				usuario.setLiquido(resultado.getDouble(10));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método consultarUsuarioDAO");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuario;
	}


	public boolean atualizarTipoDeUsuario(UserVO userLogado) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		
		String query = "UPDATE usuario SET tipousuario = " + 2
				     + "WHERE idusuario = " + userLogado.getIdUsuario();
		 
		try {
			if(stmt.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método atualizarTipoDeUsuario");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
		
	}
	
	public boolean excluirContaUsuarioInterface(UserVO userLogado) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		
		String query = "DELETE FROM usuario "
		             + "WHERE idusuario = " + userLogado.getIdUsuario();
		
		
		try {
			if(stmt.executeUpdate(query) == 1) {
				retorno = true;                                                                      
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método excluirContaUsuarioInterface");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}
		
}
