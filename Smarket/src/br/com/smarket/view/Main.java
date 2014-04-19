package br.com.smarket.view;

import java.util.List;
import br.com.smarket.controller.UsuarioController;
import br.com.smarket.dao.ProdutoDAO;
import br.com.smarket.dao.SecaoDAO;
import br.com.smarket.model.*;

public class Main {
	
    public static void main(String[] args) {
    	try{
    		
    		/* Testando listagem
	    	List<Usuario> listaDeUsuarios = UsuarioController.buscarUsuarios();
	    	for(Usuario usuario : listaDeUsuarios) {
	            System.out.println(usuario.getLogin());
	        }*/
    	}
    	catch(Throwable ex)
    	{
    		ex.printStackTrace();
    	} 	
    }
}
