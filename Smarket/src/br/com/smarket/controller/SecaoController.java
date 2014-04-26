package br.com.smarket.controller;

import java.util.List;
import br.com.smarket.dao.SecaoDAO;
import br.com.smarket.model.Secao;


public class SecaoController extends Controller{

	private static final long serialVersionUID = -448467334738335113L;
	
	private SecaoDAO secaoDAO;
	
	public SecaoController(){
		this.secaoDAO = new SecaoDAO();
	}
	
	private void criarSecao(Secao secao) //como os dados são obtidos para criar a seção?
	{
		//Valida Objeto
		
		//Manda Inserir
		
		
	}
	
	public void alterarSecao() throws Exception
	{
		// Secao secao = criarSecao();
		// secaoDAO.insertOrUpdate(secao);
	}
	
	public void removerSecao() throws Exception
	{
		// secaoDAO.delete(id);
	}
	
	public List<Secao> listarSecoes() throws Exception
	{
		return secaoDAO.listar();
	}
}
