package br.com.smarket.controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import br.com.smarket.dao.SecaoDAO;
import br.com.smarket.model.Secao;
import br.com.smarket.view.ViewMapa;
import java.sql.*;


public class MapaController extends Controller{

	private static final long serialVersionUID = 4542629248787899900L;
	
	private SecaoDAO secaoDAO;
	
	public void gerarMapa(List<Secao> secoes)
	{
		
	}
	
	public List<Secao> getListaSecao() 
	{
		return secaoDAO.listar();
	}
	
	public void actionPerformed(ActionEvent event) {
			
		JComponent component = (JComponent) event.getSource();
		while(!(component instanceof ViewMapa)) component = (JComponent) component.getParent();
		ViewMapa view = (ViewMapa) component;
		
		switch (event.getActionCommand()){
		
			case "Abrir":
				String caminho = view.selecionarImagem();
				view.setImagem(caminho);
				break;
			case "Salvar":
				if(view.getTextoArquivo()==null || view.getTextoArquivo().isEmpty())
					JOptionPane.showMessageDialog(null,"Nenhuma imagem selecionada.","Erro",JOptionPane.ERROR_MESSAGE);
				else new salvarMapa(new File(view.getTextoArquivo()));
				break;
			case "Excluir":
				view.setImagem(null);
				break;
		}
			
	}
}

class salvarMapa{
	public salvarMapa(File imagem){

		Connection connection = null;
		String connectionURL = "jdbc:mysql://dbmy0060.whservidor.com/yumaol1_1";
		PreparedStatement psmnt = null;
		FileInputStream fis;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "yumaol1_1", "smarket1");
			
			try
			{
				psmnt = connection.prepareStatement("drop table Mapa");
				psmnt.executeUpdate();
				psmnt.close();
			} 
			catch (Exception e){}
			
			psmnt = connection.prepareStatement("create table Mapa(Id int(5) NOT NULL auto_increment, "
					+ "img_mapa longblob, "
					+ "PRIMARY KEY  (`Id`))");
			psmnt.executeUpdate();
			psmnt.close();
			
			psmnt = connection.prepareStatement
					("insert into Mapa(img_mapa) "+ "values(?)");
			fis = new FileInputStream(imagem);
			psmnt.setBinaryStream(1, (InputStream)fis, (int)(imagem.length()));
			int s = psmnt.executeUpdate();
			if(s>0) {
				JOptionPane.showMessageDialog(null,"Mapa atualizado com sucesso!.","Erro",JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null,"Erro ao salvar mapa.","Erro",JOptionPane.ERROR_MESSAGE);
			}
			connection.close();
			psmnt.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}