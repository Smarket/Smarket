package br.com.smarket.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import br.com.smarket.controller.Controller;
import br.com.smarket.util.HibernateUtil;

public class ViewTabs extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTabs frame = new ViewTabs();
					HibernateUtil.getSessionFactory(); 
					frame.setVisible(true);					
					frame.addWindowListener(new Controller());
					frame.setIconImage(ImageIO.read(getClass().getResource("/IconSmarket.png")));
					frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					frame.setCursor(Cursor.getDefaultCursor());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static JLabel lblNome = new JLabel("Não Autenticado", SwingConstants.CENTER);
	private static JButton btnLogin;
	private JTabbedPane tabProdutos;
	public ViewTabs() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
		} catch (Exception e) {
		}
		
		Controller controller = new Controller();
		setTitle("SMARKET - Gerenciador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 788, 495);
		getContentPane().setLayout(null);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(553, 34, 89, 23);
		btnLogin.addActionListener(controller);
		getContentPane().add(btnLogin);
		
		lblNome.setBounds(550, 8, 95, 33);
		getContentPane().add(lblNome);

		Image imagem = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/SmarketLogo.jpg"));  
		ImageIcon logo = new ImageIcon(imagem);
		JLabel lblImage = new JLabel(logo);
		lblImage.setBounds(653, 7, 120, 50);
		getContentPane().add(lblImage);
		
		tabProdutos = new JTabbedPane(JTabbedPane.TOP);
		tabProdutos.setBounds(0, 0, 784, 460);
		tabProdutos.setFont(tabProdutos.getFont().deriveFont((float)17));
		getContentPane().add(tabProdutos);
		
		tabProdutos.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=20 marginheight=20>Produtos</body></html>", null, new ViewProduto(), null);
		tabProdutos.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=20 marginheight=20>Mapas</body></html>", null, new ViewMapa(), null);
		tabProdutos.addTab("<html><body leftmargin=0 topmargin=0 marginwidth=20 marginheight=0>Gerenciador de Usu\u00E1rios</body></html>", null, new ViewUsuario(), null);
		tabProdutos.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=20 marginheight=20>Se\u00E7\u00E3o</body></html>", null, new ViewSecao(), null);
		
		habilitarAbas(false,true);

	}
	
	public JPanel getAba(int i)
	{
		return (JPanel)tabProdutos.getComponentAt(i);
	}
	
	public int getNumAbas()
	{
		return tabProdutos.getTabCount();
	}
	
	public void habilitarAbas(boolean habilitar, boolean users)
	{
		for(int i=0; i<tabProdutos.getTabCount(); i++)
		{
			if(users||!(tabProdutos.getComponentAt(i) instanceof ViewUsuario))
			habilitar((Container)tabProdutos.getComponentAt(i), habilitar);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void habilitar(Container c, boolean habilitar)
	{
		Component[] components = c.getComponents();
        for (Component component : components) {
            component.setEnabled(habilitar);
            if(component instanceof Container) habilitar((Container)component, habilitar);
            if(component instanceof JList) component.setVisible(habilitar);
            if(component instanceof JTextField) ((JTextField)component).setText(null);
            if(component instanceof JComboBox) ((JComboBox)component).setSelectedIndex(-1);
        }
	}
	
	public static String getNomeLogado()
	{
		if(lblNome.getText().equals("Não Autenticado")) return null;
		return lblNome.getText();
	}
	
	public static void setNomeLogado(String s)
	{
		if(s==null)
		{
			lblNome.setText("Não Autenticado");
			btnLogin.setText("Login");
		}
		else
		{
			lblNome.setText(s);
			btnLogin.setText("Logout");
		}
	}
}