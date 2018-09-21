import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


/*
 * Janelas (JFrame)
 * painéis (JPanel)
 * etiquetas (JLabel)
 * campos de texto (JTextField)
 * botões (JButton, JCheckBox)
 * formas de os organizar (FlowLayout, GridLayout)
 * 
 * */

public class Exercicio1_prof {
	private JFrame frame;
	private JTextField texto1;
	private JTextField texto2;
	private JTextField texto3;

	public Exercicio1_prof(String titulo_texto) {
		frame = new JFrame(titulo_texto);

		// para que o botao de fechar a janela termine a aplicacao
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// conteudo em sequencia da esquerda para a direita
		frame.setLayout(new FlowLayout());

		addFrameContent();
		
		frame.setResizable(false); //nao permitir que seja resizable
		// para que a janela se redimensione de forma a ter todo o seu conteudo
		// visivel
		frame.pack();
		
	}

	public void open() {
		// para abrir a janela (torna-la visivel)
		frame.setVisible(true);
	}

	private void addFrameContent() {

		/*
		 * para organizar o conteudo em grelha (linhas x colunas) se um dos
		 * valores for zero, o numero de linhas ou colunas (respetivamente) fica
		 * indefinido, e estas sao acrescentadas automaticamente
		 */
		frame.setLayout(new GridLayout(4, 2));

		//Titulo
		JLabel label1 = new JLabel("Title");
		frame.add(label1);

		texto1 = new JTextField(frame.getTitle());
		frame.add(texto1);

		//Largura
		JLabel label2 = new JLabel("Width");
		frame.add(label2);

		texto2 = new JTextField(frame.getWidth()+"");
		frame.add(texto2);

		//Altura
		JLabel label3 = new JLabel("Height");
		frame.add(label3);

		texto3 = new JTextField(frame.getHeight()+"");
		frame.add(texto3);
		
		JButton button = new JButton("Update");
		button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				frame.setTitle(texto1.getText());
				frame.setSize(Integer.parseInt(texto2.getText()), Integer.parseInt(texto3.getText()));
				/* frame.setSize espera 2 argumentos inteiros */
			} 
			});
		 
		 

		/*
		 * abreviatura para passar por cima da criação de uma classe de uma
		 * interface especificando os métodos obrigatórios dessa interface
		 */
		frame.add(button);

		final JCheckBox check = new JCheckBox("center");
		frame.add(check);

	}

	
	public static void main(String[] args) {
		Exercicio1_prof window = new Exercicio1_prof("Hello");
		
		window.open();
	}
}
