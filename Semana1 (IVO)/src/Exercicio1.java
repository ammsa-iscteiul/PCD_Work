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

public class Exercicio1 {
	private JFrame frame;

	public Exercicio1(String titulo_texto) {
		frame = new JFrame(titulo_texto);

		// para que o botao de fechar a janela termine a aplicacao
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// conteudo em sequencia da esquerda para a direita
		frame.setLayout(new FlowLayout());

		addFrameContent();

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

		JLabel label1 = new JLabel("Title");
		frame.add(label1);

		JTextField text1 = new JTextField("Hello");
		frame.add(text1);

		JLabel label2 = new JLabel("Width");
		frame.add(label2);

		JTextField text2 = new JTextField("300");
		frame.add(text2);

		JLabel label3 = new JLabel("Height");
		frame.add(label3);

		JTextField text3 = new JTextField("150");
		frame.add(text3);

		JButton button = new JButton("Update");
		/*
		 * button.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { JOptionPane.showMessageDialog(frame,
		 * check.isSelected() ? "checked" : "not checked"); } });
		 * 
		 */

		/*
		 * abreviatura para passar por cima da criação de uma classe de uma
		 * interface especificando os métodos obrigatórios dessa interface
		 */
		frame.add(button);

		JCheckBox center = new JCheckBox("center");
		frame.add(center);

	}

	
	public static void main(String[] args) {
		Exercicio1 window = new Exercicio1("Hello");
		
		window.open(300, 150);
	}
}
