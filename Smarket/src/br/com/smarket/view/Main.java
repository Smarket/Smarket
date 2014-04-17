package br.com.smarket.view;

import br.com.smarket.controller.UsuarioController;
import br.com.smarket.dao.ProdutoDAO;
import br.com.smarket.dao.SecaoDAO;
import br.com.smarket.model.*;

public class Main {
	
    public static void main(String[] args) {
    	try{


    	/*Usuario user = new Usuario();
    	user.setAdministrador(false);
    	user.setLogin("Yuri");
    	user.setSenha("123");
    	UsuarioController.CadastrarUsuario(user);*/
    		
    		Secao secao = new Secao();
        	secao.setNome("SecaoDeVasilina");
        	SecaoDAO secaoDAO = new SecaoDAO();
        	secaoDAO.insertOrUpdate(secao);
            
        	Produto produto = new Produto();
        	produto.setNome("Vasilina");
        	produto.setSecao(secao);
        	
        	ProdutoDAO produtoDAO = new ProdutoDAO();
        	produtoDAO.insertOrUpdate(produto);

    	}
    	catch(Throwable ex)
    	{
    		ex.printStackTrace();
    	} 	
    }
}
