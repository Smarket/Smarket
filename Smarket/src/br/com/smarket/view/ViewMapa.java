package br.com.smarket.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.com.smarket.controller.MapaController;

public class ViewMapa extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JPanel panelUpload;
	private JPanel panelImage;
	private JButton btnExcluir;
	private JButton btnSalvar;
	private JButton btnAbrir;
	private JTextField txtArquivo;
	private Border borderUpload;
	private Border borderImage;
	private JLabel lblImg;
	private JScrollPane scrollImagem;

	private MapaController mapaController;
	
	public ViewMapa() {
		
		this.panelUpload = new JPanel();
		this.panelImage = new JPanel();
		this.btnExcluir = new JButton("Excluir");
		this.btnSalvar = new JButton("Salvar");
		this.btnAbrir = new JButton("Abrir");
		this.txtArquivo = new JTextField();
		this.txtArquivo.setEditable(false);
		this.lblImg = new JLabel();
		this.scrollImagem = new JScrollPane();
		this.mapaController = new MapaController();
	
		this.setStyle();
		this.setBound();
		this.addOnPanels();
		this.setListeners();
		this.setLayout(null);
		this.add(panelImage);
		this.add(panelUpload);
	}

	private void setStyle() {
		this.panelUpload.setLayout(null);
		this.panelImage.setLayout(null);
		this.borderUpload = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1 , true), "Adicionar Mapas");
		this.borderImage = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1 , true), "Preview");
		this.scrollImagem.setBorder(new LineBorder(this.getBackground(),1,true));
		this.txtArquivo.setBackground(Color.WHITE);
	}

	private void setBound() {
		this.panelUpload.setBounds(10, 7, 300, 380);
		this.panelImage.setBounds(320, 7, 455, 380);
		this.txtArquivo.setBounds(15, 130, 190,25);
		this.btnAbrir.setBounds(210, 130, 75, 25);
		this.btnExcluir.setBounds(15, 340, 75, 25);
		this.btnSalvar.setBounds(210, 340, 75, 25);
		this.scrollImagem.setBounds(15, 20, 425, 345);
	}
	
	private void addOnPanels() {
		this.panelUpload.setBorder(this.borderUpload);
		this.panelImage.setBorder(this.borderImage);
		this.panelUpload.add(this.btnExcluir);
		this.panelUpload.add(this.btnSalvar);
		this.panelUpload.add(this.btnAbrir);
		this.panelUpload.add(this.txtArquivo);
		this.panelImage.add(this.scrollImagem);
	}
	
	private void setListeners() {
		this.btnAbrir.addActionListener(mapaController);
		this.btnExcluir.addActionListener(mapaController);
		this.btnSalvar.addActionListener(mapaController);
	}
	
	public String selecionarImagem(){
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter(
		    "Imagens JPG e PNG", "jpg", "png");
		chooser.setFileFilter(filtro);
		int resultado = chooser.showOpenDialog(this);
		if(resultado == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile().getAbsolutePath();
		}
		else
		{
			return null;
		}
	}
	
	public void setImagem(String caminhoImagem){
		if(caminhoImagem!=null)
		{
			this.txtArquivo.setText(caminhoImagem);
			BufferedImage imagem = null;
			try {
				imagem = ImageIO.read(new File(caminhoImagem));
				lblImg = new JLabel(new ImageIcon(imagem));
				scrollImagem.setViewportView(lblImg);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Erro ao abrir imagem.","Erro",JOptionPane.ERROR_MESSAGE);
			}
		}
		else
		{
			lblImg = new JLabel();
			scrollImagem.setViewportView(lblImg);
			this.txtArquivo.setText(null);
		}
			
	}

	
	public String getTextoArquivo(){
		return this.txtArquivo.getText();
	}
	
	class ImagePanel extends JPanel{

		private BufferedImage imagem;

		public void setImagem(String caminhoImagem) {
			if(caminhoImagem!=null){
				try {                
					this.imagem = ImageIO.read(new File(caminhoImagem));
				} catch (IOException ex){
				}
			}
			else imagem = null;
			this.setPreferredSize(new Dimension(imagem.getWidth(), imagem.getHeight()));
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(imagem, 0, 0, null);     
		}
	}
}

