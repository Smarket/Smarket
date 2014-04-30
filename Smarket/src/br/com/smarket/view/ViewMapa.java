package br.com.smarket.view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

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
	
	public ViewMapa() {
		
		this.panelUpload = new JPanel();
		this.panelImage = new JPanel();
		this.btnExcluir = new JButton("Excluir");
		this.btnSalvar = new JButton("Salvar");
		this.btnAbrir = new JButton("Abrir");
		this.txtArquivo = new JTextField();
		this.lblImg = new JLabel("TESTE");
	
		this.setStyle();
		this.setBound();
		this.addOnPanels();
		this.setLayout(null);
		this.add(panelImage);
		this.add(panelUpload);
	}

	private void setStyle() {
		this.panelUpload.setLayout(null);
		this.panelImage.setLayout(null);
		this.borderUpload = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1 , true), "Adicionar Mapas");
		this.borderImage = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1 , true), "Preview");
		this.lblImg.setBackground(Color.GREEN);
		this.lblImg.setOpaque(true);
	}

	private void setBound() {
		this.panelUpload.setBounds(10, 7, 300, 380);
		this.panelImage.setBounds(320, 7, 455, 380);
		this.txtArquivo.setBounds(15, 130, 190,25);
		this.btnAbrir.setBounds(210, 130, 75, 25);
		this.btnExcluir.setBounds(15, 340, 75, 25);
		this.btnSalvar.setBounds(210, 340, 75, 25);
		this.lblImg.setBounds(15, 20, 425, 345);
	}
	
	private void addOnPanels() {
		this.panelUpload.setBorder(this.borderUpload);
		this.panelImage.setBorder(this.borderImage);
		this.panelUpload.add(this.btnExcluir);
		this.panelUpload.add(this.btnSalvar);
		this.panelUpload.add(this.btnAbrir);
		this.panelUpload.add(this.txtArquivo);
		this.panelImage.add(this.lblImg);
	}
}

