package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.ProcessaProduto;
import models.Produto;

public class ProdutoForm extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lbCabecalho = new JLabel(new Produto().cabecalho());
	private int codigo = ProcessaProduto.getAutoCodigo();
	private JTextField tfCod = new JTextField(codigo + "");;
	private JTextField tfNome = new JTextField();
	private JTextField tfDescricao = new JTextField();
	private JTextField tfPreco = new JTextField();
	private JTextField tfQuantidade = new JTextField();
	private JButton btAdd, btDel, btCancelar, btSalvar;
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scroll;
	private JLabel lbTotalItens = new JLabel("Total de Ítens:");
	private JLabel lbTotalDinheiro = new JLabel("Total em R$:");
	private JTextField tfTotalItens;
	private JTextField tfTotalDinheiro;
	
	private Produto produto;
	private int totItens = 0;
	private double totDinheiro = 0;

	ProdutoForm() {
		// Propriedades do Formulário
		setTitle("Cadastro de Produtos");
		setBounds(250, 160, 597, 410);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);

		// Montagem dos campos de texto
		tfCod.setEnabled(false);
		lbCabecalho.setBounds(10, 10, 580, 20);
		tfCod.setBounds(10, 30, 40, 25);
		tfNome.setBounds(50, 30, 150, 25);
		tfDescricao.setBounds(200, 30, 150, 25);
		tfPreco.setBounds(350, 30, 80, 25);
		tfQuantidade.setBounds(430, 30, 70, 25);
		panel.add(lbCabecalho);
		panel.add(tfCod);
		panel.add(tfNome);
		panel.add(tfDescricao);
		panel.add(tfPreco);
		panel.add(tfQuantidade);

		// Botão Adicionar (CREATE)
		btAdd = new JButton("Add");
		btAdd.setBounds(500, 30, 68, 25);
		panel.add(btAdd);
		btAdd.addActionListener(this);
		
		// Montagem da Tabela (Read, Update)
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Código");
		tableModel.addColumn("Produto");
		tableModel.addColumn("Descrição");
		tableModel.addColumn("Preço");
		tableModel.addColumn("Quantidade");
		tableModel.addColumn("Subtotal");
		if (!ProcessaProduto.getProdutos().isEmpty()) {
			for (Produto p : ProcessaProduto.getProdutos()) {
				tableModel.addRow(p.getStringVetor());
				totItens += p.getQuantidade();
				totDinheiro += p.getSubtotal();
			}
		}
		table = new JTable(tableModel);
		scroll = new JScrollPane(table);
		scroll.setBounds(10, 55, 559, 275);
		panel.add(scroll);
		
		//Totais
		tfTotalItens = new JTextField(totItens+"");
		tfTotalDinheiro = new JTextField(totDinheiro+"");
		lbTotalItens.setBounds(10,330,80,30);
		tfTotalItens.setBounds(90,335,50,25);
		lbTotalDinheiro.setBounds(140,330,70,30);
		tfTotalDinheiro.setBounds(210,335,60,25);
		panel.add(lbTotalItens);
		panel.add(tfTotalItens);
		panel.add(lbTotalDinheiro);
		panel.add(tfTotalDinheiro);
		
		// Botão Deletar (DELETE)
		btDel = new JButton("Del");
		btDel.setBounds(278, 330, 59, 30);
		panel.add(btDel);
		btDel.addActionListener(this);

		// Botão Cancelar (Cancela as alterações)
		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(328, 330, 120, 30);
		panel.add(btCancelar);
		btCancelar.addActionListener(this);

		// Botão Salvar (Renova a lista)
		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(448, 330, 120, 30);
		panel.add(btSalvar);
		btSalvar.addActionListener(this);	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
