package br.com.smarket.controller;

import java.util.List;

import br.com.smarket.dao.UsuarioDAO;
import br.com.smarket.model.Usuario;


public class UsuarioController extends Controller {

	private static final long serialVersionUID = 4219635448516257481L;

	private UsuarioDAO usuarioDAO = new UsuarioDAO();


	public void cadastrarUsuario(Usuario usuario) {
		//validar objeto
		
		usuarioDAO.insertOrUpdate(usuario);
	}

	public void alterarUsuario(Usuario usuario) {
		usuarioDAO.insertOrUpdate(usuario);
	}

	public void removerUsuario(Usuario usuario) {
		usuarioDAO.delete(usuario);
	}

	public List<Usuario> buscarUsuarios() {
		return usuarioDAO.listar();
	}
}
