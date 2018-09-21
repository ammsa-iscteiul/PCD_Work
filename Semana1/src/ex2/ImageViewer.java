package ex2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

import javax.activation.MimetypesFileTypeMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class ImageViewer {
	
	
	private JFrame frame;
	private String IMAGEPATH = "images/";
	private int width = 300;
	private int height = 300;
	private int r = 0;
	private File[] file;
	private JLabel image = new JLabel();

	public ImageViewer() {
		frame = new JFrame("Gallery");
		
		// para que o botao de fechar a janela termine a aplicacao
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		// conteudo em sequencia da esquerda para a direita
		frame.setLayout(new FlowLayout());
		
		addFrameContent();
		
		// para que a janela se redimensione de forma a ter todo o seu conteudo visivel
		frame.pack();
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = dimension.width;
		int y = dimension.height;
		frame.setLocation((x/2)-(width/2), (y/2)-(height/2));
		frame.setSize(width, height);
		
	}

	public void open() {
		// para abrir a janela (torna-la visivel)
		frame.setVisible(true);
	}
	
	private void addFrameContent() {
				
		frame.setLayout(new BorderLayout());
		
		//botão prev
		JLabel labelPrev = new JLabel("Prev");
		frame.add(labelPrev, BorderLayout.WEST);
		JButton prev = new JButton("Prev");
		prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(r>0) {
					r = r - 1;					
					//System.out.println(r);
				}
				Foto(r);
			}
		});
		frame.add(prev, BorderLayout.WEST);
		
		//botão Next
		JLabel labelNext = new JLabel("Next");
		frame.add(labelNext, BorderLayout.EAST);
		JButton next = new JButton("Next");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mete aqui a parte toda do imageicon + frame.validate();
				if(r < 2) {
					r = r + 1;
					Foto(r);										
					//System.out.println(r);
				}
				
			}
		});
		frame.add(next, BorderLayout.EAST);
		
		//botão Refresh
		JLabel labelRefresh = new JLabel("Refresh");
		frame.add(labelRefresh, BorderLayout.SOUTH);
		JButton refresh = new JButton("Refresh");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(r != 0) {
					r = 0;
					Foto(0);
					//System.out.println(r);
				}	
			}
		});
		frame.add(refresh, BorderLayout.SOUTH);		
		
		creatImageArray();
		
		//primeira foto
		Foto(r);
		
		System.out.println(file.length);
		
	}
	
	private void Foto(int f) {		
		ImageIcon icon = new ImageIcon("images/"+ file[f].getName());
		image.setIcon(icon);
		frame.add(image, BorderLayout.CENTER);
		frame.validate();
	}
	
	private void creatImageArray() {
		file = new File(IMAGEPATH).listFiles(new FileFilter() {
			public boolean accept (File f) {
				String mimetype= new MimetypesFileTypeMap().getContentType(f);

				if (mimetype.startsWith("image/")) {
					return true;
				}else
					return false;
				
			}
		});
	}

	public static void main(String[] args) {		
		
		ImageViewer window = new ImageViewer();
		
		window.open();
		
	
		

	}

}
