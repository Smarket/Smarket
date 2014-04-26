package br.com.smarket.controller;

import java.util.List;
import br.com.smarket.dao.SecaoDAO;
import br.com.smarket.model.Secao;


public class MapaController extends Controller{

	private static final long serialVersionUID = 4542629248787899900L;
	
	private static SecaoDAO secaoDAO;
	
	public static void gerarMapa(List<Secao> secoes)
	{
	}
	
	public static List<Secao> getListaSecao() 
	{
		return secaoDAO.listar();
	}

}
