package ex1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class FrameTest {
	private JFrame frame;

	public FrameTest() {
		frame = new JFrame("Test");
		
		// para que o botao de fechar a janela termine a aplicacao
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		// conteudo em sequencia da esquerda para a direita
		frame.setLayout(new FlowLayout());
		
		addFrameContent();
		
		// para que a janela se redimensione de forma a ter todo o seu conteudo visivel
		frame.pack();
	}

	public void open() {
		// para abrir a janela (torna-la visivel)
		frame.setVisible(true);
	}

	private void addFrameContent() {
		
		
		/* para organizar o conteudo em grelha (linhas x colunas)
		se um dos valores for zero, o numero de linhas ou colunas (respetivamente) fica indefinido,
		e estas sao acrescentadas automaticamente */
		
		frame.setLayout(new GridLayout(4,2));//4 linhas e duas colunas

		JLabel labelTitle = new JLabel("Title");
		frame.add(labelTitle);

		JTextField textTitle = new JTextField("Hello");
		frame.add(textTitle);
		
		JLabel labelWidth = new JLabel("Width");
		frame.add(labelWidth);

		JTextField textWidth = new JTextField("300");
		frame.add(textWidth);
		
		JLabel labelHeight = new JLabel("Height");
		frame.add(labelHeight);

		JTextField textHeight = new JTextField("150");
		frame.add(textHeight);
		
		JCheckBox check = new JCheckBox("check");
		frame.add(check);
		
		JButton button = new JButton("button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(frame, check.isSelected() ? "checked" : "not checked"); if...
				int height =0;
				int width = 0;
				String title = textTitle.getText();
				try {
					width = Integer.parseInt(textWidth.getText());
					height = Integer.parseInt(textHeight.getText());
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, "não valido");
					width = 300;//pixel
					height = 150;//pixel
				}				
				if(check.isSelected()) {
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
					int x = dimension.width;
					int y = dimension.height;
					frame.setLocation((x/2)-(width/2), (y/2)-(height/2));
					
				}
				frame.setTitle(title);
				frame.setSize(width, height);
				frame.validate();//necessário para validar e para renderizar de novo
				
				
			}
		});
		frame.add(button);	
	}

	public static void main(String[] args) {
		FrameTest window = new FrameTest();
		window.open();
	}
}
