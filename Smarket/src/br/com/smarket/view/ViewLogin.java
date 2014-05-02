package br.com.smarket.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import br.com.smarket.controller.Controller;
import br.com.smarket.controller.SmarketException;
import br.com.smarket.controller.UsuarioController;
import br.com.smarket.model.Usuario;

public class ViewLogin extends JPanel{
	
	private JTextField login;
	private JPasswordField password;
	private JLabel status;
	private JButton logar;
	private Controller controller = new Controller();
	
	public ViewLogin()
	{
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setPreferredSize(new Dimension(200,115));
		this.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		login = new JTextField();
		login.setPreferredSize(new Dimension(150,20));
		password = new JPasswordField();
		password.setPreferredSize(new Dimension(150,20));
		password.addKeyListener(controller);
		JLabel usuario = new JLabel("Usuário:",SwingConstants.LEFT);
		usuario.setPreferredSize(new Dimension(50,20));
		JLabel senha = new JLabel("Senha:");
		senha.setPreferredSize(new Dimension(50,20));
		JLabel espaco = new JLabel("");
		espaco.setPreferredSize(new Dimension(300,20));
		status = new JLabel("");
		status.setName("Status");
		status.setPreferredSize(new Dimension(140,20));
		logar = new JButton("Entrar");
		logar.addActionListener(controller);
		
		this.add(usuario);
		this.add(login);
		this.add(senha);
		this.add(password);
		this.add(espaco);
		this.add(status);
		this.add(logar);
	}

	public void autentica() {
		
		Usuario user = new Usuario();
		user.setLogin(login.getText());
		List<Usuario> lista = (List<Usuario>) new UsuarioController().buscarUsuarios();
		if(lista.contains(user)){
			user = lista.get(lista.indexOf(user));
			if(user.getSenha().equals(new String(password.getPassword())))
			{
				user.autenticar(new String(password.getPassword()));
				try {
					new UsuarioController().alterarUsuario(user);
				} catch (SmarketException e) {
					e.printStackTrace();
				}
				ViewTabs.setNomeLogado(user.getLogin());
				SwingUtilities.getWindowAncestor(this).dispose();
			}
			else
			{
				status.setText("Erro: Senha incorreta.");
			}
		}
		else
		{
			status.setText("Erro: Usuário não existe.");
		}
	}
	
	public void clicarBotaoLogin()
	{
		this.logar.doClick();
	}
}
