package br.com.smarket.teste.dao;

import static org.junit.Assert.*;
import br.com.smarket.dao.ProdutoDAO;
import br.com.smarket.dao.SecaoDAO;
import br.com.smarket.model.Produto;
import br.com.smarket.model.Secao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ProdutoDAOTest {

	ProdutoDAO dao;
	String nome;
	Secao secao;
	long id;
	double peso;
	boolean BaixaTemperatura;

	@Before
	public void setUp() throws Exception {
		dao = new ProdutoDAO();
		nome = "nome";
		id = 2;
		secao = new Secao("nome", 0, 0, 0, 0, null);
		peso =1;
		BaixaTemperatura = false;
	}
	
	@Test
	public void listarProdutoTest() throws SQLException {
		assertTrue(dao.listar() instanceof List);
	}
	
	@Test
	public void inserirProdutoTest() throws SQLException {
		Produto prod = new Produto(nome, peso, BaixaTemperatura, secao);
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(prod);
		secao.setProdutos(produtos);
		new SecaoDAO().insertOrUpdate(secao);
		prod.setSecao(secao);
		dao.insertOrUpdate(prod);
		
		List<Produto> list = dao.listar();
		assertTrue(list.contains(prod));
	}
	
	@Test
	public void removerProdutoTest() throws SQLException {
		Produto prod = new Produto(nome, peso, BaixaTemperatura, secao);
		
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(prod);
		secao.setProdutos(produtos);
		new SecaoDAO().insertOrUpdate(secao);
		prod.setSecao(secao);
		
		dao.insertOrUpdate(prod);
		dao.delete(prod);
		List<Produto> list = dao.listar();
		assertFalse(list.contains(prod));
	}
	
	@Test
	public void alterarProduto(){
		Produto prod = new Produto(nome, peso, BaixaTemperatura, secao);
		Produto prod2 = new Produto(prod.getId(), nome, peso, true, secao);
		
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(prod);
		secao.setProdutos(produtos);
		new SecaoDAO().insertOrUpdate(secao);
		prod.setSecao(secao);
		
		dao.insertOrUpdate(prod);
		dao.insertOrUpdate(prod2);
		
		List<Produto> list = dao.listar();
		assertTrue(list.contains(prod2));
		assertFalse(list.contains(prod));
	}
	
}
