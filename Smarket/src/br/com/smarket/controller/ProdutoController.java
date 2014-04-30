package br.com.smarket.controller;

import java.util.List;
import br.com.smarket.dao.ProdutoDAO;
import br.com.smarket.model.Produto;


public class ProdutoController extends Controller{

	private static final long serialVersionUID = -1562720750525912198L;

	private static ProdutoDAO produtoDAO = new ProdutoDAO();
	
	public static void inserirProduto(Produto produto) throws Exception 
	{
		// Valida objeto
		// Produto produto = criarProduto();
		// produtoDAO.insertOrUpdate(produto);
	}
	
	public static void alterarProduto() throws Exception
	{
		// Produto produto = criarProduto();
		// produtoDAO.insertOrUpdate(produto);
	}
	
	public static void removerProduto() throws Exception
	{
		// produtoDAO.delete(id);
	}
	
	public static List<Produto> listarProdutos() throws Exception
	{
		return produtoDAO.listar();
	}
}
