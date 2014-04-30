package br.com.smarket.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import br.com.smarket.model.Produto;

public class ViewSecao extends JPanel{

	private static final long serialVersionUID = 1L;
	
	JPanel pane;
	JPanel paneOpcoes;
	JScrollPane produtos_parent;
	JList<Produto> produtos;
	JLabel sessoes;
	JLabel nomeSessao;
	JTextField nomeSessao_in;
	JLabel coordenadaXInicial;
	JTextField coordenadaXInicial_in;
	JLabel coordenadaXFinal;
	JTextField coordenadaXFinal_in;
	JLabel coordenadaYInicial;
	JTextField coordenadaYInicial_in;
	JLabel coordenadaYFinal;
	JTextField coordenadaYFinal_in;
	JButton botaoNovo;
	JButton botaoRemover;
	JButton botaoSalvar;
	
    GridBagLayout gridbag;
    GridBagConstraints constraints;
    
	
	public ViewSecao(){
		
			produtos_parent = new JScrollPane();
			paneOpcoes = new JPanel();
			produtos = new JList<Produto>();
			Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
			this.setBorder(padding);
			this.setPreferredSize(new Dimension(600,400));
			
			this.setLayout(null);
			paneOpcoes.setLayout(null);
			paneOpcoes.setBounds(290, 15, 485, 372);
			paneOpcoes.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1 , true), "Novo/Editar Seção"));

			sessoes = new JLabel("Sessões");
			sessoes.setBounds(10, 0, 290, 26);			
			
			produtos_parent.setBounds(10, sessoes.getHeight()-5, 270, 337);
			
			produtos.setSize(sessoes.getWidth(), 400);
			produtos.setBounds(0, 0, 270, 398);
			produtos.setOpaque(true);
			produtos.setBackground(Color.white);
			
			
			nomeSessao = new JLabel("Nome da Seção");
			nomeSessao.setBounds(20, 100, 150, 25);
			nomeSessao_in = new JTextField();
			nomeSessao_in.setBounds(nomeSessao.getX(), nomeSessao.getY()+nomeSessao.getHeight(), nomeSessao.getWidth(), nomeSessao.getHeight());
			coordenadaXInicial = new JLabel("Coordenada X inicial");
			coordenadaXInicial.setBounds(nomeSessao.getX()+nomeSessao.getWidth()+20, nomeSessao.getY(), 120, nomeSessao.getHeight());
			coordenadaXInicial_in = new JTextField();
			coordenadaXInicial_in.setBounds(coordenadaXInicial.getX(), coordenadaXInicial.getY()+coordenadaXInicial.getHeight(), 50, coordenadaXInicial.getHeight());
			coordenadaXFinal = new JLabel("Coordenada X final");
			coordenadaXFinal.setBounds(coordenadaXInicial.getX()+coordenadaXInicial.getWidth()+20, coordenadaXInicial.getY(), coordenadaXInicial.getWidth(), coordenadaXInicial.getHeight());
			coordenadaXFinal_in = new JTextField();
			coordenadaXFinal_in.setBounds(coordenadaXFinal.getX(), coordenadaXFinal.getY()+coordenadaXFinal.getHeight(), coordenadaXInicial_in.getWidth(), coordenadaXInicial_in.getHeight());
			coordenadaYInicial = new JLabel("Coordenada Y inicial");
			coordenadaYInicial.setBounds(coordenadaXInicial.getX(), coordenadaXInicial.getY()+3*coordenadaXInicial.getHeight(), coordenadaXInicial.getWidth(), coordenadaXInicial.getHeight());
			coordenadaYInicial_in = new JTextField();
			coordenadaYInicial_in.setBounds(coordenadaYInicial.getX(), coordenadaYInicial.getY()+coordenadaYInicial.getHeight(), coordenadaXInicial_in.getWidth(), coordenadaXInicial_in.getHeight());
			coordenadaYFinal = new JLabel("Coordenada Y final");
			coordenadaYFinal.setBounds(coordenadaYInicial.getX()+coordenadaYInicial.getWidth()+20, coordenadaYInicial.getY(), coordenadaYInicial.getWidth(), coordenadaYInicial.getHeight());
			coordenadaYFinal_in = new JTextField();
			coordenadaYFinal_in.setBounds(coordenadaYFinal.getX(), coordenadaYFinal.getY()+coordenadaYFinal.getHeight(), coordenadaXFinal_in.getWidth(), coordenadaXFinal_in.getHeight());
			botaoNovo = new JButton("Novo");
			botaoNovo.setBounds(10, 362, 80, 25);
			botaoRemover = new JButton("Remover");
			botaoRemover.setBounds(200, 362, 80, 25);
			
			botaoSalvar = new JButton("Salvar");
			botaoSalvar.setBounds(373, 327, 80, 25);
			
			this.add(sessoes);
			this.add(produtos_parent);
			produtos_parent.setViewportView(produtos);
			this.add(paneOpcoes);
			this.add(botaoNovo);
			this.add(botaoRemover);
			paneOpcoes.add(nomeSessao);
			paneOpcoes.add(coordenadaXInicial);
			paneOpcoes.add(coordenadaXInicial_in);
			paneOpcoes.add(coordenadaXFinal);
			paneOpcoes.add(coordenadaXFinal_in);
			paneOpcoes.add(coordenadaYInicial);
			paneOpcoes.add(coordenadaYInicial_in);
			paneOpcoes.add(coordenadaYFinal);
			paneOpcoes.add(coordenadaYFinal_in);
			paneOpcoes.add(nomeSessao_in);
			paneOpcoes.add(botaoSalvar);


			produtos_parent.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			produtos_parent.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			produtos_parent.setBorder(new LineBorder(Color.LIGHT_GRAY));
			
	}
}

