package br.com.smarket.controller;

import java.util.List;

import br.com.smarket.dao.UsuarioDAO;
import br.com.smarket.model.Usuario;

// Os metodos ser�o est�ticos? Fiz assim pois j� tinha-se come�ado a fazer desse modo.
// Exce��es devem ser tratadas na classe Controller ou fora dela?

public class UsuarioController extends Controller{

	private static final long serialVersionUID = 4219635448516257481L;
	
	private static UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	private static Usuario criarUsuario() //como os dados s�o obtidos para criar o usu�rio?
	{
		Usuario usuario = new Usuario();
		return usuario;
	}
	
	public static void cadastrarUsuario()
	{
		// Usuario usuario = criarUsuario();
		// usuarioDAO.insertOrUpdate(usuario);
	}
	
	public static void alterarUsuario() 
	{
		// Usuario usuario = criarUsuario();
		// usuarioDAO.insertOrUpdate(usuario);
	}
	
	public static void removerUsuario() 
	{
		// usuarioDAO.delete(login);
	}
	
	public static List<Usuario> buscarUsuarios()
	{
		return usuarioDAO.listar();
	}
}
