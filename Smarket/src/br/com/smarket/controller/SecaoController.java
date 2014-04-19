package br.com.smarket.controller;

import java.util.List;
import br.com.smarket.dao.SecaoDAO;
import br.com.smarket.model.Secao;

//Os metodos ser�o est�ticos? Fiz assim pois j� tinha-se come�ado a fazer desse modo.
//Exce��es devem ser tratadas na classe Controller ou fora dela?

public class SecaoController extends Controller{

	private static final long serialVersionUID = -448467334738335113L;
	
	private static SecaoDAO secaoDAO = new SecaoDAO();
	
	private static Secao criarSecao() //como os dados s�o obtidos para criar a se��o?
	{
		Secao secao = new Secao(); 
		return secao;
	}
	
	public static void inserirSecao() throws Exception 
	{
		// Secao secao = criarSecao();
		// secaoDAO.insertOrUpdate(secao);
	}
	
	public static void alterarSecao() throws Exception
	{
		// Secao secao = criarSecao();
		// secaoDAO.insertOrUpdate(secao);
	}
	
	public static void removerSecao() throws Exception
	{
		// secaoDAO.delete(id);
	}
	
	public static List<Secao> listarSecoes() throws Exception
	{
		return secaoDAO.listar();
	}
}
