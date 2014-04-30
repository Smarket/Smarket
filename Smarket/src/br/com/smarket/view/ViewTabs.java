package br.com.smarket.view;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class ViewTabs extends JFrame {

	/**
	 * @author Tharik Antunes
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ViewTabs frame = new ViewTabs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewTabs() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
		} catch (Exception e) {
		}
		
		setTitle("SMARKET - Gerenciador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 788, 495);
		getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Logout");
		btnLogin.setBounds(553, 34, 89, 23);
		getContentPane().add(btnLogin);
		
		JLabel lblNome = new JLabel("Carlos H.");
		lblNome.setBounds(573, 9, 89, 33);
		getContentPane().add(lblNome);
		
		ImageIcon logo = new ImageIcon("images/SmarketLogo.jpg");
		JLabel lblImage = new JLabel(logo);
		lblImage.setBounds(653, 7, 120, 50);
		getContentPane().add(lblImage);
		
		JTabbedPane tabProdutos = new JTabbedPane(JTabbedPane.TOP);
		tabProdutos.setBounds(0, 0, 784, 460);
		tabProdutos.setFont(tabProdutos.getFont().deriveFont((float)17));
		getContentPane().add(tabProdutos);
		
		tabProdutos.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=20 marginheight=20>Produtos</body></html>", null, new ViewProduto(), null);
		tabProdutos.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=20 marginheight=20>Mapas</body></html>", null, new ViewMapa(), null);
		tabProdutos.addTab("<html><body leftmargin=0 topmargin=0 marginwidth=20 marginheight=0>Gerenciador de Usu\u00E1rios</body></html>", null, new ViewUsuario(), null);
		tabProdutos.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=20 marginheight=20>Se\u00E7\u00E3o</body></html>", null, new ViewSecao(), null);


	}
}