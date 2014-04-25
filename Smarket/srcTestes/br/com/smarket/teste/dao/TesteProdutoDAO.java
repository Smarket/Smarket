package br.com.smarket.teste.dao;

import br.com.smarket.dao.ProdutoDAO;
import br.com.smarket.dao.SecaoDAO;
import br.com.smarket.model.Produto;
import br.com.smarket.model.Secao;

public class TesteProdutoDAO {
	
	public static void main(String[] args) {
		Produto produto = new Produto();
		produto.setNome("yursdfsdfsdfi");
		Secao secao = new Secao();
		secao.setNome("sddfdsf");
		SecaoDAO dao = new SecaoDAO();
		dao.insertOrUpdate(secao);
		produto.setSecao(secao);
		
		ProdutoDAO produtoDao = new ProdutoDAO();
		
		produtoDao.insertOrUpdate(produto);
		
		System.out.println("asdgh");
	}
}
