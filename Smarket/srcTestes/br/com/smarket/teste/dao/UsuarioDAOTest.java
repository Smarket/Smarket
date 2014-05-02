package br.com.smarket.teste.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import br.com.smarket.dao.UsuarioDAO;
import br.com.smarket.model.Usuario;

import org.junit.Before;
import org.junit.Test;

public class UsuarioDAOTest {
	
	UsuarioDAO dao;
	String login, nome, senha;
	boolean adm, aut;
	
	@Before
	public void setUp() throws Exception {
		dao = new UsuarioDAO();
		login = "login";
		senha = "123";
		adm = false;
		aut = false;
	}
	
	@Test
	public void listarTest() throws SQLException{
		assertTrue(dao.listar() instanceof List);
	}
	
	@Test
	public void inserirUsuarioTest() throws SQLException {
		Usuario user = new Usuario(login, senha, adm, aut);
		
		dao.insertOrUpdate(user);
		
		List<Usuario> list = dao.listar();
		assertTrue(list.contains(user));
	}
	
	@Test
	public void removerUsuarioTest() throws SQLException {
		Usuario user = new Usuario(login, senha, adm, aut);
		dao.insertOrUpdate(user);
		
		dao.delete(user);
		
		List<Usuario> list = dao.listar();
		assertFalse(list.contains(user));
	}
	
	@Test
	public void alterarUsuarioTest() throws SQLException {
		Usuario user = new Usuario(login, senha, adm, aut);
		Usuario user2 = new Usuario(login, senha, true, aut);
		
		dao.insertOrUpdate(user);
		dao.insertOrUpdate(user2);
		
		List<Usuario> list = dao.listar();
		assertTrue(list.contains(user2));
		assertFalse(list.contains(user));
	}
	
	

}
