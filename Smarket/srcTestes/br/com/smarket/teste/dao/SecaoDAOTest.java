package br.com.smarket.teste.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;
import br.com.smarket.dao.SecaoDAO;
import br.com.smarket.model.Secao;
import br.com.smarket.model.Produto;

import org.junit.Before;
import org.junit.Test;

public class SecaoDAOTest {
	SecaoDAO dao;
	int xi, xf, yi, yf;
	String nome;
	List<Produto> LProdutos;
	
	@Before
	public void setUp() throws Exception{
		dao = new SecaoDAO();
		nome = "nome";
		xi=xf=yf=yi = 0;
		LProdutos = null;
	}
	
	@Test
	public void listarTest() throws SQLException {
		assertTrue(dao.listar() instanceof List);
	}
	
	@Test
	public void inserirSecaoTest() {
		Secao sec = new Secao(nome, xi, xf, yi, yf, LProdutos);
		
		dao.insertOrUpdate(sec);
		
		List<Secao> list = dao.listar();
		assertTrue(list.contains(sec));
	}
	
	@Test
	public void removerSecaoTest() throws SQLException {
		Secao sec = new Secao(nome, xi, xf, yi, yf, LProdutos);
		dao.insertOrUpdate(sec);
		
		dao.delete(sec);
		
		List<Secao> list = dao.listar();
		assertFalse(list.contains(sec));
	}
	
	@Test
	public void alterarSecaoTest() throws SQLException {
		Secao sec = new Secao(nome, xi, xf, yi, yf, LProdutos);
		Secao sec2 = new Secao(sec.getId(), nome, xi, xf, yi, 1, LProdutos);
		
		dao.insertOrUpdate(sec);
		dao.insertOrUpdate(sec2);
		
		List<Secao> list = dao.listar();
		assertTrue(list.contains(sec2));
		assertFalse(list.contains(sec));
		
	}

	
}