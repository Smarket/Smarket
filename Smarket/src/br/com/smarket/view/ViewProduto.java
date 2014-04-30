package br.com.smarket.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.smarket.model.Produto;
import br.com.smarket.model.Secao;

//classe responsável pela criação do panel com os produtos
//contém o método para criar o panel
//contém o método para criar a lista
//contém o método para criar as labels
//contém o método para criar as caixas de texto
//contém o método para criar os botões

public class ViewProduto extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private int panelSizeX;
	private int panelSizeY;
	JPanel panelNovoEditar;
	
	//construtor por default
	public ViewProduto(){
		panelSizeX = 800;
		panelSizeY = 800;
		this.createPanel();
	}

	//método para criar o panel
	public void createPanel(){

		this.setLayout(null);
		this.setBounds(10, 30, panelSizeX, panelSizeY);

		createListProdutos();
		createPanelNovoEditar();
		createLabels();
		createTextBox();
		createButtons();
	}

	//método para criar a lista de produtos
	public void createListProdutos(){

		DefaultListModel<Produto> listaModel = new DefaultListModel<Produto>();
		JList<Produto> listaProdutos = new JList<Produto>(listaModel);
		

		JScrollPane scrollList = new JScrollPane(listaProdutos);
		scrollList.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1,true));
		scrollList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollList.setBounds(10,21,270,337);
		this.add(scrollList);
	}

	//método para criar as labels
	public void createLabels(){

		JLabel labelProdutos = new JLabel("Lista de Produtos");   	  
		labelProdutos.setBounds(10,3,400,20);
		this.add(labelProdutos);   	 

		JLabel labelNomeProduto = new JLabel("Nome do produto");
		labelNomeProduto.setBounds(40, 80, 300, 30);
		panelNovoEditar.add(labelNomeProduto);
		
		JLabel labelSessao = new JLabel("Sessao");
		labelSessao.setBounds(260, 80, 300, 30);
		panelNovoEditar.add(labelSessao);

		JLabel labelPeso = new JLabel("Peso/kg");
		labelPeso.setBounds(40, 175, 300, 30);
		panelNovoEditar.add(labelPeso);

		JLabel labelTempArmz = new JLabel("Temperatura de Armazenamento");
		labelTempArmz.setBounds(260, 175, 300, 30);
		panelNovoEditar.add(labelTempArmz);

	}

	public void createPanelNovoEditar(){

		this.panelNovoEditar = new JPanel();
		panelNovoEditar.setLayout(null);
		panelNovoEditar.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true), "Novo/Editar Produtos"));
		panelNovoEditar.setBounds(290, 15, 485, 372);
		this.add(panelNovoEditar);
	}
	//método para criar as caixas de texto
	public void createTextBox(){

		JTextField textNomeProduto = new JTextField();
		textNomeProduto.setBounds(40, 110, 150, 20);
		panelNovoEditar.add(textNomeProduto);

		JTextField textPeso = new JTextField();
		textPeso.setBounds(40, 205, 150, 20);
		panelNovoEditar.add(textPeso);
		
		JComboBox<Secao> textBoxSessao = new JComboBox<Secao>();
		textBoxSessao.setBounds(260, 110, 150, 20);
		panelNovoEditar.add(textBoxSessao);

		JComboBox<String> textTemperatura = new JComboBox<String>();
		textTemperatura.setBounds(260, 205, 150, 20);
		textTemperatura.insertItemAt("Normal", 0);
		textTemperatura.insertItemAt("Baixa", 1);
		textTemperatura.setSelectedIndex(0);
		panelNovoEditar.add(textTemperatura);
	
	}

	//método para criar os botões
	public void createButtons(){

		JButton buttonNovo = new JButton("Novo");		      
		buttonNovo.setBounds(10, 362, 80, 25);
		this.add(buttonNovo);

		JButton buttonRemover = new JButton("Remover");		      
		buttonRemover.setBounds(200, 362, 80, 25);
		this.add(buttonRemover);

		JButton buttonSalvar = new JButton("Salvar");		      
		buttonSalvar.setBounds(373, 327, 80, 25);
		panelNovoEditar.add(buttonSalvar);
	}

}
