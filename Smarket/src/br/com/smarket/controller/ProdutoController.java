package br.com.smarket.controller;

import java.util.List;
import br.com.smarket.dao.ProdutoDAO;
import br.com.smarket.model.Produto;

//Os metodos ser�o est�ticos? Fiz assim pois j� tinha-se come�ado a fazer desse modo.
//Exce��es devem ser tratadas na classe Controller ou fora dela?

public class ProdutoController extends Controller{

	private static final long serialVersionUID = -1562720750525912198L;

	private static ProdutoDAO produtoDAO = new ProdutoDAO();
	
	private static Produto criarProduto() //como os dados s�o obtidos para criar o produto?
	{
		Produto produto = new Produto();
		return produto;
	}
	
	public static void inserirProduto() throws Exception 
	{
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
