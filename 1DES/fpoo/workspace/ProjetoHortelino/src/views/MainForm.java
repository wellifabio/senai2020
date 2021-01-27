package views;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controllers.ProcessaCompra;
import controllers.ProcessaProduto;

public class MainForm extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JMenu menuArquivo, menuSistema;
	private JMenuBar menuBar = new JMenuBar();
	private JMenuItem itemProdutos, itemCompras, itemRelatorios, itemSair;
	private JLabel lbFundo;
	private ImageIcon img = new ImageIcon("./img/fundo2.png");
	
	MainForm(){
		//Configuração do Formulário
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Loja de Ferragens do Hortelino - Sistema de Compras");
		setBounds(200, 100, 700, 500);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);
		
		//Colocando a imagem no fundo
		lbFundo = new JLabel();
		lbFundo.setIcon(img);
		lbFundo.setBounds(220,15,430,405);
		panel.add(lbFundo);
		
		//Barra de Menús
		setJMenuBar(menuBar);
		menuArquivo = new JMenu("Arquivo");
		menuSistema = new JMenu("Sistema");
		menuBar.add(menuArquivo);
		menuBar.add(menuSistema);
		itemProdutos = new JMenuItem("Produtos");
		itemCompras = new JMenuItem("Compras");
		itemRelatorios = new JMenuItem("Relatórios");
		itemSair = new JMenuItem("Sair do Sistema.");
		menuArquivo.add(itemProdutos);
		menuArquivo.add(itemCompras);
		menuSistema.add(itemRelatorios);
		menuSistema.add(itemSair);
		itemProdutos.addActionListener(this);
		itemCompras.addActionListener(this);
		itemRelatorios.addActionListener(this);
		itemSair.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == itemProdutos) {
			ProdutoForm pf = new ProdutoForm();
			pf.setModal(true);
			pf.setVisible(true);
		} else if(e.getSource() == itemCompras) {
			CompraForm cf = new CompraForm();
			cf.setModal(true);
			cf.setVisible(true);			
		} else if(e.getSource() == itemRelatorios) {
			RelatorioForm rf = new RelatorioForm();
			rf.setModal(true);
			rf.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(this, "Obrigado Hortelino.","Valeu",JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
	}
	
	public static void main(String[] args) {
		ProcessaProduto.abrir();
		ProcessaCompra.abrir();
		MainForm mf = new MainForm();
		mf.setVisible(true);
	}

}
