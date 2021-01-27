import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainForm extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JLabel lbValor1, lbValor2;
	private JTextField tfValor1, tfValor2, tfResultado;
	private JButton btSair,btCalcula;
	
	MainForm(){
		// Cabeçalho do Formulário
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Minha Primeira Tela");
		setBounds(200, 100, 1000, 600);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);
		
		lbValor1 = new JLabel("Valor 1");
		lbValor1.setBounds(10,10,100,30);
		panel.add(lbValor1);
		lbValor2 = new JLabel("Valor 2");
		lbValor2.setBounds(110,10,100,30);
		panel.add(lbValor2);
		
		tfValor1 = new JTextField();
		tfValor1.setBounds(10,40,100,30);
		panel.add(tfValor1);
		tfValor2 = new JTextField();
		tfValor2.setBounds(110,40,100,30);
		panel.add(tfValor2);
		tfResultado = new JTextField("Resultado");
		tfResultado.setBounds(210,40,100,30);
		tfResultado.setEnabled(false);
		panel.add(tfResultado);
		
		btSair = new JButton("Sair");
		btSair.setBounds(10,400,100,30);
		panel.add(btSair);
		
		btCalcula = new JButton("Calcula");
		btCalcula.setBounds(110,400,100,30);
		panel.add(btCalcula);
		
		btSair.addActionListener(this);
		btCalcula.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		MainForm telaPrincipal = new MainForm();
		telaPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btSair) {
			dispose();
		}
		if(e.getSource() == btCalcula) {
			tfResultado.setText(tfValor1.getText()+tfValor2.getText());
		}		
	}
}
