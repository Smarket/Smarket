package br.com.smarket.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import org.hibernate.HibernateException;
import br.com.smarket.dao.ProdutoDAO;
import br.com.smarket.model.Produto;
import br.com.smarket.model.Usuario;
import br.com.smarket.view.ViewProduto;

public class ProdutoController extends Controller{

	private static final long serialVersionUID = -1562720750525912198L;

	private ProdutoDAO produtoDAO = new ProdutoDAO();
	
	public void inserirProduto(Produto produto) throws SmarketException
	{
		if(produto.getNome().isEmpty()) throw new SmarketException("Nome do produto em branco.");
		if(produto.getSecao()==null) throw new SmarketException("Escolha a seção do produto.");
		try{
			produtoDAO.insertOrUpdate(produto);
		}
		catch(HibernateException e){
			throw new SmarketException("Erro ao inserir produto.", e);
		}
		
	}
	
	public void alterarProduto(Produto produto) throws SmarketException
	{
		if(produto.getNome().isEmpty()) throw new SmarketException("Nome do produto em branco.");
		if(produto.getSecao()==null) throw new SmarketException("Escolha a seção do produto.");
		try{
			produtoDAO.insertOrUpdate(produto);
		}
		catch(HibernateException e){
			throw new SmarketException("Erro ao editar produto.", e);
		}
	}
	
	public void removerProduto(Produto produto) throws SmarketException
	{
		try{
			produtoDAO.delete(produto);
		}
		catch(HibernateException e){
			throw new SmarketException("Erro ao remover produto.", e);
		}
	}
	
	public List<Produto> listarProdutos()
	{
		return produtoDAO.listar();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		JComponent component = (JComponent) event.getSource();
		while(!(component instanceof ViewProduto)) component = (JComponent) component.getParent();
		ViewProduto view = (ViewProduto) component;
			
		switch (event.getActionCommand()){
		
			case "Salvar":
				if(view.getListaProduto().getSelectedIndex()==-1)
				{
					Produto produto = view.getProdutoNovo();
					try{this.inserirProduto(produto);}
					catch(SmarketException e){JOptionPane.showMessageDialog(null,e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);}
				}
				else
				{ 
					try{this.alterarProduto(view.getProdutoSelecionado());}
					catch(SmarketException e){JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);}
				}
				view.atualizarLista();
				view.atualizarSecoes();
				break;
			
			case "Novo":
				((JList<Produto>)view.getListaProduto()).clearSelection();
				view.atualizarSecoes();
				view.alterarDados(null,null,null,false);
				break;
				
			case "Remover":
				try{this.removerProduto(view.getProdutoSelecionado());}
				catch(SmarketException e){JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);}
				view.alterarDados(null,null,null,false);
				view.atualizarSecoes();
				view.atualizarLista();
				break;
				
			default:
				System.out.println(event.getActionCommand());
				break;
		}	
	}
	
	@SuppressWarnings("unchecked")
	public void valueChanged(ListSelectionEvent event) {
		JList<Produto> lista = ((JList<Produto>)event.getSource()); 
		
		JComponent component = (JComponent) event.getSource();
		while(!(component instanceof ViewProduto)) component = (JComponent) component.getParent();
		ViewProduto view = (ViewProduto) component;
		
		if(lista.getValueIsAdjusting()==false)
		{
			if(!((JList<Usuario>)event.getSource()).isSelectionEmpty()){
				Produto produto = (Produto)((JList<Produto>)event.getSource()).getSelectedValue();
				view.alterarDados(
						produto.getNome(), 
						Double.toString(produto.getPeso()),
						produto.getSecao(),
						produto.getBaixaTemperatura());
			}	
		}	
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER)
		{
			JComponent component = (JComponent) event.getSource();
			while(!(component instanceof ViewProduto)) component = (JComponent) component.getParent();
			((ViewProduto)component).clicarBotaoSalvar();
			
		}	
	}
}
