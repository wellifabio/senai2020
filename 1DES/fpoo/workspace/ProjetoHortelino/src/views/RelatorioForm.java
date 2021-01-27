package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class RelatorioForm extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel panel;

	RelatorioForm() {
		// Propriedades do Formulário
		setTitle("Relatório de Compras");
		setBounds(200, 149, 700, 450);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
