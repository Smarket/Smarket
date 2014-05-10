package br.com.smarket.view;

import java.awt.Color;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.smarket.controller.ProdutoController;
import br.com.smarket.controller.SecaoController;
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
	private JPanel panelNovoEditar;
	private JButton buttonSalvar;
	private JButton buttonNovo;
	private JButton buttonRemover;
	private JTextField textNomeProduto;
	private JTextField textPeso;
	private JComboBox<Secao> textBoxSessao;
	private JList<Produto> listaProdutos;
	private DefaultListModel<Produto> listaModel;
	private JCheckBox checkBoxTemperatura;
	private ProdutoController produtoController;
	
	//construtor por default
	public ViewProduto(){
		panelSizeX = 800;
		panelSizeY = 600;
		this.produtoController = new ProdutoController();
		this.createPanel();
		//this.atualizarLista();
		//this.atualizarSecoes();
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

		listaModel = new DefaultListModel<Produto>();
		listaProdutos = new JList<Produto>();
		listaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaProdutos.setModel(listaModel);
		listaProdutos.addListSelectionListener(produtoController);
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
		
		JLabel labelSessao = new JLabel("Seção");
		labelSessao.setBounds(260, 80, 300, 30);
		panelNovoEditar.add(labelSessao);

		JLabel labelPeso = new JLabel("Peso/kg");
		labelPeso.setBounds(40, 175, 300, 30);
		panelNovoEditar.add(labelPeso);

	}

	public void createPanelNovoEditar(){

		this.panelNovoEditar = new JPanel();
		panelNovoEditar.setLayout(null);
		panelNovoEditar.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true), "Novo/Editar Produtos"));
		panelNovoEditar.setBounds(290, 15, 485, 372);
		panelNovoEditar.setName("panelEdicao");
		this.add(panelNovoEditar);
	}
	
	//método para criar as caixas de texto
	public void createTextBox(){

		textNomeProduto = new JTextField();
		textNomeProduto.setBounds(40, 105, 150, 24);
		panelNovoEditar.add(textNomeProduto);

		textPeso = new JTextField();
		textPeso.setBounds(40, 200, 150, 24);
		textPeso.addKeyListener(produtoController);
		panelNovoEditar.add(textPeso);
		
		textBoxSessao = new JComboBox<Secao>();
		textBoxSessao.setBounds(260, 105, 150, 24);
		textBoxSessao.addKeyListener(produtoController);
		panelNovoEditar.add(textBoxSessao);

		checkBoxTemperatura = new JCheckBox("Baixa Temperatura");
		checkBoxTemperatura.setBounds(39, 250, 150, 22);
		checkBoxTemperatura.addKeyListener(produtoController);
		panelNovoEditar.add(checkBoxTemperatura);
	
	}

	//método para criar os botões
	public void createButtons(){

		this.buttonNovo = new JButton("Novo");		      
		buttonNovo.setBounds(10, 362, 80, 25);
		buttonNovo.addActionListener(produtoController);
		this.add(buttonNovo);

		this.buttonRemover = new JButton("Remover");		      
		buttonRemover.setBounds(200, 362, 80, 25);
		buttonRemover.addActionListener(produtoController);
		this.add(buttonRemover);

		this.buttonSalvar = new JButton("Salvar");		      
		buttonSalvar.setBounds(373, 327, 80, 25);
		buttonSalvar.addActionListener(produtoController);
		panelNovoEditar.add(buttonSalvar);
	}
	
	public void atualizarLista()
	{
		int i = listaProdutos.getSelectedIndex();
		listaModel.clear();
		List<Produto> produtos = produtoController.listarProdutos();
		for(Produto p : produtos)
		{
			listaModel.addElement(p);
		}
		listaProdutos.setSelectedIndex(i);
		
	}
	
	public void atualizarSecoes(){
		List<Secao> secoes = new SecaoController().listarSecoes();
		textBoxSessao.removeAllItems();
		for(Secao s : secoes){
			textBoxSessao.addItem(s);
		}
		textBoxSessao.setSelectedIndex(-1);
	}

	public Produto getProdutoNovo()
	{
		Produto p = new Produto();
		p.setNome(textNomeProduto.getText());
		try{p.setPeso(Double.parseDouble(textPeso.getText()));}
		catch(NumberFormatException e){ p.setPeso(0);}
		p.setBaixaTemperatura(checkBoxTemperatura.isSelected());
		p.setSecao((Secao)textBoxSessao.getSelectedItem());
		return p;
	}
	
	public Produto getProdutoSelecionado()
	{
		Produto p = listaProdutos.getSelectedValue();
		p.setNome(textNomeProduto.getText());
		try{p.setPeso(Double.parseDouble(textPeso.getText()));}
		catch(NumberFormatException e){ p.setPeso(0);}
		p.setBaixaTemperatura(checkBoxTemperatura.isSelected());
		p.setSecao((Secao)textBoxSessao.getSelectedItem());
		return p;
	}
	
	public void alterarDados(String nome, String peso, Secao s, boolean frio)
	{
		textNomeProduto.setText(nome);
		textPeso.setText(peso);
		checkBoxTemperatura.setSelected(frio);
		if(s!=null) textBoxSessao.getModel().setSelectedItem(s);
		else textBoxSessao.setSelectedIndex(-1);
	}
	
	public JList<Produto> getListaProduto()
	{
		return listaProdutos;
	}
	
	public void clicarBotaoSalvar()
	{
		buttonSalvar.doClick();
	}

}
