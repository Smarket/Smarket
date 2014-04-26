package br.com.smarket.teste.dao;

import java.util.List;

import br.com.smarket.dao.ProdutoDAO;
import br.com.smarket.dao.SecaoDAO;
import br.com.smarket.model.Produto;
import br.com.smarket.model.Secao;

public class TesteProdutoDAO {
	
	public static void main(String[] args) {
		Secao secao = new Secao();
		secao.setNome("sddfdjkjjksf");
		SecaoDAO dao = new SecaoDAO();
		System.out.println(secao.getId());
		dao.insertOrUpdate(secao);
		System.out.println(secao.getId());
		
		Produto produto = new Produto();
		produto.setNome("yursdfsdfjkjkjsdfi");
		produto.setSecao(secao);
		System.out.println(secao.getId());
		
		Produto produto1 = new Produto();
		produto1.setNome("yursdfsdfjkjkasdsadsadsadjsdfi");
		produto1.setSecao(secao);

		ProdutoDAO produtoDao = new ProdutoDAO();
		produtoDao.insertOrUpdate(produto);
		produtoDao.insertOrUpdate(produto1);
		
		List<Produto> listar = produtoDao.listar();
		for (Produto produto2 : listar) {
			System.out.println("Nome "+produto2.getNome());
		}
		
		
	}
}
