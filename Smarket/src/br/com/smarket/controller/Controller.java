package br.com.smarket.controller;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.*;
import java.io.*;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.com.smarket.model.Usuario;
import br.com.smarket.view.ViewLogin;
import br.com.smarket.view.ViewMapa;
import br.com.smarket.view.ViewProduto;
import br.com.smarket.view.ViewSecao;
import br.com.smarket.view.ViewTabs;
import br.com.smarket.view.ViewUsuario;

public class Controller implements ActionListener, WindowListener, ListSelectionListener, KeyListener, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Login")
		{
			ViewLogin vl = new ViewLogin();
			JOptionPane.showOptionDialog(null, vl,
		            "Login de Usuário", JOptionPane.NO_OPTION,
		            JOptionPane.PLAIN_MESSAGE, null, new Object[] {},
		            null);
			
			Component component = (Component) e.getSource();
			while(!(component instanceof ViewTabs)) component = (Component) component.getParent();
			ViewTabs view = (ViewTabs) component;
			
			List<Usuario> l = (List<Usuario>) new UsuarioController().buscarUsuarios();
			Usuario u = new Usuario();
			u.setLogin(ViewTabs.getNomeLogado());
			
			while(!(component instanceof ViewTabs)) component = (Component) component.getParent();
			component.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			  
			if(u.getLogin()!=null)
			{
				u = l.get(l.indexOf(u));
				if(u.getAdministrador()) view.habilitarAbas(true, true);
				else view.habilitarAbas(true, false);
				for(int i=0; i<view.getNumAbas(); i++) if(view.getAba(i).isEnabled()){
					JPanel panel = view.getAba(i);
					if(panel instanceof ViewProduto) ((ViewProduto)panel).atualizarLista();
					if(panel instanceof ViewSecao) ((ViewSecao)panel).atualizarLista();
					if(panel instanceof ViewUsuario) ((ViewUsuario)panel).atualizarLista();
				}
			}
			component.setCursor(Cursor.getDefaultCursor());
		}
		if(e.getActionCommand()=="Logout")
		{
			Component component = (Component) e.getSource();
			while(!(component instanceof ViewTabs)) component = (Component) component.getParent();
			component.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			
			List<Usuario> lista = (List<Usuario>) new UsuarioController().buscarUsuarios();
			Usuario user = new Usuario();
			user.setLogin(ViewTabs.getNomeLogado());
			user = lista.get(lista.indexOf(user));
			user.setAutenticado(false);
			try {
				new UsuarioController().alterarUsuario(user);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			ViewTabs.setNomeLogado(null);
			((ViewTabs)(((JComponent)e.getSource()).getParent().getParent().getParent().getParent())).habilitarAbas(false, true);
			
			component.setCursor(Cursor.getDefaultCursor());
		}
		if(e.getActionCommand()=="Entrar")
		{
			((ViewLogin)((JButton)e.getSource()).getParent()).autentica();
		}
	}

	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER)
		{
			((ViewLogin)((JTextField)event.getSource()).getParent()).clicarBotaoLogin();
		}	
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent event) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		Usuario u = new Usuario();
		u.setLogin(ViewTabs.getNomeLogado());
		if(u.getLogin()!=null)
		{
			List<Usuario> l = (List<Usuario>) new UsuarioController().buscarUsuarios();
			u = l.get(l.indexOf(u));
			u.setAutenticado(false);
			try {
				new UsuarioController().alterarUsuario(u);
			} catch (SmarketException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
