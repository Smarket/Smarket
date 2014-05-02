package br.com.smarket.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;

import br.com.smarket.dao.UsuarioDAO;
import br.com.smarket.model.Usuario;
import br.com.smarket.view.ViewSecao;
import br.com.smarket.view.ViewTabs;
import br.com.smarket.view.ViewUsuario;


public class UsuarioController extends Controller {

	private static final long serialVersionUID = 4219635448516257481L;

	private UsuarioDAO usuarioDAO = new UsuarioDAO();


	public void cadastrarUsuario(Usuario usuario) throws SmarketException {
		if(usuario.getLogin()==null || usuario.getLogin().isEmpty()) throw new SmarketException("Não é permitido nome em branco.");
		if(usuario.getSenha()==null || usuario.getSenha().isEmpty()) throw new SmarketException("Não é permitido senha em branco.");
		try{
			usuarioDAO.insertOrUpdate(usuario);
		}
		catch(ConstraintViolationException e){
			throw new SmarketException("Já existe usuário com mesmo login.");
		}
		catch(HibernateException e){
			throw new SmarketException("Erro ao cadastrar usuário.", e);
		}
	}

	public void alterarUsuario(Usuario usuario) throws SmarketException {
		try{
			usuarioDAO.insertOrUpdate(usuario);
		}
		catch(HibernateException e){
			throw new SmarketException("Erro atualizar usuário.", e);
		}
	}

	public void removerUsuario(Usuario usuario) throws SmarketException {
		try{
			usuarioDAO.delete(usuario);
		}
		catch(HibernateException e){
			throw new SmarketException("Erro ao excluir usuário.", e);
		}
	}

	public List<Usuario> buscarUsuarios() {
		return usuarioDAO.listar();
	}
	
	public void actionPerformed(ActionEvent event) {
		
		JComponent component = (JComponent) event.getSource();
		while(!(component instanceof ViewUsuario)) component = (JComponent) component.getParent();
		ViewUsuario view = (ViewUsuario) component;
		
		switch (event.getActionCommand()){
		
			case "Salvar":
				
				if(view.getSenha().equals(view.getConfirmar())) {
					Usuario u = new Usuario();
					u.setLogin(view.getNome());
					u.setSenha(view.getSenha());
					u.setAdministrador(view.getAdmin());
					if(ViewTabs.getNomeLogado().equals(u.getLogin())) u.setAutenticado(true);
					
					if(u.getAutenticado() && u.getAdministrador() == false) 
					{
						JOptionPane.showMessageDialog(null,
							"Não é possível diminuir o papel de um usuário logado.","Erro",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						try{this.cadastrarUsuario(u);}
						catch(Exception e){JOptionPane.showMessageDialog(null,e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);}
						view.atualizarLista();
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Confirmação de senha incorreta.","Erro",JOptionPane.ERROR_MESSAGE);
				}
				break;
			
			case "Novo":
				view.habilitarNome(true);
				view.getLista().clearSelection();
				view.alterarDados(null,null,false);
				break;
				
			case "Remover":
				Usuario u = new Usuario();
				u.setLogin(view.getNome());
				u.setSenha(view.getSenha());
				u.setAdministrador(view.getAdmin());
				if(!ViewTabs.getNomeLogado().equals(u.getLogin()))
				{
					try{
						this.removerUsuario(u);
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null,e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"Não é possível remover você mesmo.","Erro",JOptionPane.ERROR_MESSAGE);
				}
				view.alterarDados(null,null,false);
				view.atualizarLista();
				break;
				
			default:
				break;
		}
	}

	@SuppressWarnings("unchecked")
	public void valueChanged(ListSelectionEvent event) {
		JComponent component = (JComponent) event.getSource();
		while(!(component instanceof ViewUsuario)) component = (JComponent) component.getParent();
		ViewUsuario view = (ViewUsuario) component;
		if(event.getValueIsAdjusting()==false)
		{
			if(!view.getLista().isSelectionEmpty()){
				view.habilitarNome(false);
				Usuario u = (Usuario)(view.getLista().getSelectedValue());
				view.alterarDados(u.getLogin(), u.getSenha(), u.getAdministrador());
			}	
		}	
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER)
		{
			JComponent component = (JComponent) event.getSource();
			while(!(component instanceof ViewUsuario)) component = (JComponent) component.getParent();
			ViewUsuario view = (ViewUsuario) component;
			view.clicarBotaoSalvar();
		}	
	}
}
