package source;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FramGame extends JFrame {
	
	public FramGame() {
		this.setTitle("Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		this.setSize(screen.width * 3 / 4, screen.height * 3 / 4);
		this.setLocation(screen.width / 8, screen.height / 8);
		PanelGame pg = new PanelGame();
		addKeyListener(pg);
		add(pg);
	}

}
