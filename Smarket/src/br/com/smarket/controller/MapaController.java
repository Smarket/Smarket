package br.com.smarket.controller;

import java.util.List;
import br.com.smarket.dao.SecaoDAO;
import br.com.smarket.model.Secao;

//Os metodos ser�o est�ticos? Fiz assim pois j� tinha-se come�ado a fazer desse modo.

public class MapaController extends Controller{

	private static final long serialVersionUID = 4542629248787899900L;
	
	private static SecaoDAO secaoDAO;
	
	public static void gerarMapa(List secoes)
	{
	}
	
	public static List<Secao> getListaSecao() 
	{
		return secaoDAO.listar();
	}

}
