package br.com.smarket.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import br.com.smarket.controller.UsuarioController;
import br.com.smarket.model.Usuario;


public class ViewUsuario extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private static final int LAR_PAINEL_USUARIO = 580;
	private static final int ALT_PAINEL_USUARIO = 400;
	
	private PainelListaUsuarios painelLista = new PainelListaUsuarios();
	private PainelDadosUsuario painelDados = new PainelDadosUsuario();
	
	public ViewUsuario()
	{
		this.setLayout(new BorderLayout());
		this.setSize(LAR_PAINEL_USUARIO, ALT_PAINEL_USUARIO);
		add(painelLista, BorderLayout.LINE_START);
		add(painelDados, BorderLayout.CENTER);
	}
	
	class PainelListaUsuarios extends JPanel{
		
		private static final long serialVersionUID = 1L;
		private static final int LAR_LISTA_USUARIO = 290;
		private static final int ALT_LISTA_USUARIO = 390;
		private static final int LAR_BOTAO_USUARIO = 80;
		private static final int ALT_BOTAO_USUARIO = 25;
		private static final int ESPACAMENTO = 10;
		
		private UsuarioController usuarioController = new UsuarioController();
		
		private JList<Usuario> listUsuarios = new JList<Usuario>(new DefaultListModel<Usuario>());
		private JLabel labelListaUsuarios = new JLabel("Usuários");
		private JButton buttonAdicionar = new JButton("Novo");
		private JButton buttonRemover = new JButton("Remover");
		
		public PainelListaUsuarios() {
			
			this.setLayout(new BorderLayout(1,1));
			this.setPreferredSize(new Dimension(LAR_LISTA_USUARIO, ALT_LISTA_USUARIO));
			this.setBorder(new EmptyBorder(6,ESPACAMENTO,3,ESPACAMENTO));
			
			this.add(labelListaUsuarios, BorderLayout.PAGE_START);
			
			JPanel buttons = new JPanel(new BorderLayout());
			buttons.setBorder(new EmptyBorder(new Insets(3, 0, 0, 0)));
			buttonAdicionar.setPreferredSize(new Dimension(LAR_BOTAO_USUARIO, ALT_BOTAO_USUARIO));
			buttonAdicionar.addActionListener(usuarioController);
			buttonRemover.setPreferredSize(new Dimension(LAR_BOTAO_USUARIO, ALT_BOTAO_USUARIO));
			buttonRemover.addActionListener(usuarioController);
			buttons.add(buttonAdicionar, BorderLayout.LINE_START);
			buttons.add(buttonRemover, BorderLayout.LINE_END);
			this.add(buttons, BorderLayout.PAGE_END);
			
			listUsuarios.addListSelectionListener(usuarioController);
			listUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			JScrollPane listScrollUsuarios = new JScrollPane();
			listScrollUsuarios.setViewportView(listUsuarios);
			listScrollUsuarios.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			listScrollUsuarios.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			//this.atualizarLista();
			this.add(listScrollUsuarios, BorderLayout.CENTER);
		
		}
		
		public void atualizarLista()
		{
			DefaultListModel<Usuario> listUsuariosModel = ((DefaultListModel<Usuario>)this.listUsuarios.getModel());
			int i = listUsuarios.getSelectedIndex();
			listUsuariosModel.clear();
			List<Usuario> listaUsuarios = usuarioController.buscarUsuarios();
			for(Usuario u : listaUsuarios)
			{
				listUsuariosModel.addElement(u);
			}
			listUsuarios.setSelectedIndex(i);
			
		}
	}
	class PainelDadosUsuario extends JPanel{
		
		private static final long serialVersionUID = 1L;
		private static final int MARGEM = 10;
		private static final int ESPACAMENTO_H_CAIXAS = 90;
		private static final int ESPACAMENTO_V_CAIXAS = 25;
		private static final int ESPACAMENTO_V_SELECAO = 55;
		private static final int LAR_CAIXA_TXT = 160; 
		private static final int ALT_CAIXA_TXT = 4;
		private static final int LAR_BOTAO_USUARIO = 80;
		private static final int ALT_BOTAO_USUARIO = 25;
		
		private UsuarioController usuarioController = new UsuarioController();
		private JLabel labelNome = new JLabel("Nome de Usuário");
		private JLabel labelSenha = new JLabel("Senha");
		private JLabel labelConfirmar = new JLabel("Confirmação de Senha");
		private JLabel labelTipo = new JLabel("Tipo de Usuário");
		private JTextField textNome = new JTextField(20);
		private JPasswordField textSenha = new JPasswordField(20);
		private JPasswordField textConfirmar= new JPasswordField(20);
		private JButton buttonSalvar = new JButton("Salvar");
		private JRadioButton buttonComum = new JRadioButton("Comum (Apenas edita produtos e mapas)");
		private JRadioButton buttonAdmin = new JRadioButton("Administrador (Adiciona/edita outros administradores)");
		
		public PainelDadosUsuario() {
			this.setLayout(new BorderLayout());
			this.setBorder(new EmptyBorder(MARGEM+5, 0, 3, MARGEM-1));
			this.setName("PainelDadosUsuario");
			
			JPanel panelUsuario = new JPanel(new GridBagLayout());
			panelUsuario.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1 , true), "Novo/Editar Usuário"));
			this.add(panelUsuario, BorderLayout.CENTER);
			
			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(50, 0, 3, ESPACAMENTO_H_CAIXAS);
			c.anchor = GridBagConstraints.WEST;
			c.gridx = 0;
			c.gridy = 0;
			panelUsuario.add(labelNome, c);
			
			c.insets = new Insets(0, 0, ESPACAMENTO_V_CAIXAS, ESPACAMENTO_H_CAIXAS);
			c.ipadx = LAR_CAIXA_TXT;
			c.ipady = ALT_CAIXA_TXT;
			c.gridx = 0;
			c.gridy = 1;
			panelUsuario.add(textNome, c);
			
			c.insets = new Insets(0, 0, 3, ESPACAMENTO_H_CAIXAS);
			c.ipadx = 0;
			c.ipady = 0;
			c.gridx = 0;
			c.gridy = 2;
			panelUsuario.add(labelSenha, c);
			
			c.insets = new Insets(0, 0, 3, 0);
			c.gridx = 1;
			panelUsuario.add(labelConfirmar, c);
			
			c.insets = new Insets(0, 0, 0, ESPACAMENTO_H_CAIXAS);
			c.ipadx = LAR_CAIXA_TXT;
			c.ipady = ALT_CAIXA_TXT;
			c.gridx = 0;
			c.gridy = 3;
			panelUsuario.add(textSenha, c);
			
			c.insets = new Insets(0, 0, 0, 0);
			c.gridx = 1;
			textConfirmar.addKeyListener(usuarioController);
			panelUsuario.add(textConfirmar, c);
			
			c.insets = new Insets(ESPACAMENTO_V_SELECAO, 0, 0, 0);
			c.ipadx = 0;
			c.ipady = 0;
			c.gridwidth=2;
			c.gridx=0;
			c.gridy=4;
			panelUsuario.add(labelTipo, c);
			
			c.insets = new Insets(0, 0, 0, 0);
			ButtonGroup b = new ButtonGroup();
			b.add(buttonComum);
			b.add(buttonAdmin);
			buttonAdmin.addKeyListener(usuarioController);
			buttonComum.addKeyListener(usuarioController);
			buttonComum.setSelected(true);
			
			c.gridy=5;
			panelUsuario.add(buttonAdmin, c);
			
			c.gridy=6;
			panelUsuario.add(buttonComum, c);
			
			c.insets = new Insets(25, 0, 0, 0);
			c.gridy=7;
			c.anchor = GridBagConstraints.LINE_END;
			buttonSalvar.setMinimumSize(new Dimension(LAR_BOTAO_USUARIO, ALT_BOTAO_USUARIO));
			panelUsuario.add(buttonSalvar, c);
			buttonSalvar.addActionListener(usuarioController);
			
		}
	}	
	
	public void alterarDados(String nome, String senha, boolean admin)
	{
		this.painelDados.textNome.setText(nome);
		this.painelDados.textSenha.setText(senha);
		this.painelDados.textConfirmar.setText(senha);
		this.painelDados.buttonAdmin.setSelected(admin);
		this.painelDados.buttonComum.setSelected(!admin);
	}
	
	public String getNome()
	{
		return this.painelDados.textNome.getText();
	}
	
	public void habilitarNome(boolean habilitar)
	{
		this.painelDados.textNome.setEnabled(habilitar);
	}
	
	public boolean getAdmin()
	{
		return this.painelDados.buttonAdmin.isSelected();
	}
	
	public String getSenha()
	{
		return new String(this.painelDados.textSenha.getPassword());
	}
	
	public String getConfirmar()
	{
		return new String(this.painelDados.textConfirmar.getPassword());
	}
	
	public void atualizarLista()
	{
		this.painelLista.atualizarLista();
	}
	
	public void clicarBotaoSalvar()
	{
		this.painelDados.buttonSalvar.doClick();
	}
	
	public JList<Usuario> getLista()
	{
		return this.painelLista.listUsuarios;
	}
}