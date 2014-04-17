package br.com.smarket.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.smarket.dao.UsuarioDAO;
import br.com.smarket.model.Usuario;

public class UsuarioController extends Controller{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4219635448516257481L;

	public static void CadastrarUsuario(Usuario usuario) throws Throwable
	{
		
		UsuarioDAO produtoDao = new UsuarioDAO();
		produtoDao.insertOrUpdate(usuario);
	}
	
	public void AlterarUsuario(Usuario usuario)
	{
		
	}
	
	public void RemoverUsuario(Usuario usuario)
	{
		
	}
	
	public List<Usuario> BuscarUsuarios()
	{
		return new ArrayList<Usuario>();
	}
}
