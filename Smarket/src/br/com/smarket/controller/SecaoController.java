package br.com.smarket.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionEvent;
import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import br.com.smarket.dao.SecaoDAO;
import br.com.smarket.model.Secao;
import br.com.smarket.model.Usuario;
import br.com.smarket.view.ViewProduto;
import br.com.smarket.view.ViewSecao;


public class SecaoController extends Controller{

	private static final long serialVersionUID = -448467334738335113L;
	
	private SecaoDAO secaoDAO;
	
	public SecaoController(){
		this.secaoDAO = new SecaoDAO();
	}
	
	public void inserirSecao(Secao secao) throws SmarketException
	{
		if(secao.getNome().isEmpty()) throw new SmarketException("Nome da seção em branco.");
		try{
			secaoDAO.insertOrUpdate(secao);
		}
		catch(HibernateException e){
			throw new SmarketException("Erro ao inserir seção.", e);
		}
	}
	
	public void alterarSecao(Secao secao) throws SmarketException
	{
		if(secao.getNome().isEmpty()) throw new SmarketException("Nome da seção em branco.");
		try{
			secaoDAO.insertOrUpdate(secao);
		}
		catch(HibernateException e){
			throw new SmarketException("Erro ao editar seção.", e);
		}
	}
	
	public void removerSecao(Secao secao) throws SmarketException
	{
		try{
			secaoDAO.delete(secao);
		}
		catch(ConstraintViolationException e){
			throw new SmarketException("A seção contém produtos, não é possível removê-la.");
		}
		catch(HibernateException e){
			throw new SmarketException("Erro ao remover seção.", e);	
		}
	}
	
	public List<Secao> listarSecoes()
	{
		return secaoDAO.listar();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		JComponent component = (JComponent) event.getSource();
		while(!(component instanceof ViewSecao)) component = (JComponent) component.getParent();
		ViewSecao view = (ViewSecao) component;
			
		switch (event.getActionCommand()){
		
			case "Salvar":
				if(view.getListaSecao().getSelectedIndex()==-1)
				{
					Secao secao = view.getSecaoNova();
					if(secao!=null)
					{
						try{this.inserirSecao(secao);}
						catch(SmarketException e){JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);}
					}
				}
				else
				{
					Secao secao = view.getSecaoSelecionada();
					if(secao!=null)
					{
						try{this.alterarSecao(secao);}
						catch(SmarketException e){JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);}
					}
				}
				view.atualizarLista();
				component = (JComponent) event.getSource();
				while(!(component instanceof JTabbedPane)) component = (JComponent) component.getParent();
				JTabbedPane pane = (JTabbedPane) component;
				((ViewProduto)pane.getComponentAt(0)).atualizarSecoes();
				break;
			
			case "Novo":
				((JList<Secao>)view.getListaSecao()).clearSelection();
				view.alterarDados(null,null,null,null,null);
				break;
				
			case "Remover":
				try{this.removerSecao(view.getSecaoSelecionada());}
				catch(SmarketException e){JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);}
				view.alterarDados(null,null,null,null,null);
				view.atualizarLista();
				component = (JComponent) event.getSource();
				while(!(component instanceof JTabbedPane)) component = (JComponent) component.getParent();
				pane = (JTabbedPane) component;
				((ViewProduto)pane.getComponentAt(0)).atualizarSecoes();
				break;
				
			default:
				break;
		}	
	}
	
	@SuppressWarnings("unchecked")
	public void valueChanged(ListSelectionEvent event) {
		
		JComponent component = (JComponent) event.getSource();
		while(!(component instanceof ViewSecao)) component = (JComponent) component.getParent();
		ViewSecao view = (ViewSecao) component;
		
		if(event.getValueIsAdjusting()==false)
		{
			if(!((JList<Usuario>)event.getSource()).isSelectionEmpty()){
				Secao secao = (Secao)((JList<Secao>)event.getSource()).getSelectedValue();
				view.alterarDados(
						secao.getNome(), 
						Integer.toString(secao.getxInicial()),
						Integer.toString(secao.getxFinal()),
						Integer.toString(secao.getyInicial()),
						Integer.toString(secao.getyFinal()));
			}	
		}	
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER)
		{
			JComponent component = (JComponent) event.getSource();
			while(!(component instanceof ViewSecao)) component = (JComponent) component.getParent();
			ViewSecao view = (ViewSecao) component;
			
			view.clicarBotaoSalvar();
		}	
	}
}
