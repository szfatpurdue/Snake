package source;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class PanelGame extends JPanel implements KeyListener {
	
	BlockHead SnakeHead;
	LinkedList<BlockBody> SnakeBody;
	public int screenWidth;
	public int screenHeight;
	
	public PanelGame() {
		//Get screen attributes
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		this.screenHeight = screen.height * 3 / 4 - 40;
		this.screenWidth = screen.width * 3 / 4 - 20;
		//initialize head at middle of the screen
		SnakeHead =  new BlockHead((screenWidth + 5) / 2, (screenHeight + 4) / 2);
		//initialize body
		SnakeBody = new LinkedList<BlockBody>();
		//five blocks long
		for (int i = 0; i < 5; i++) {
			SnakeBody.add(new BlockBody(SnakeHead.x, SnakeHead.y + (i + 1) * 10));
		}
		//Move Control Timer
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(SnakeHead.x + ", " + SnakeHead.y);
				switch(SnakeHead.direction) {
					case 1:
						if (SnakeHead.y >= 10) {
							SnakeHead.y -= 10;
							repaint();
						}
						break;
					case 2:
						if (SnakeHead.x + 10 <= screenWidth) {
							SnakeHead.x += 10;
							repaint();
						}
						break;
					case 3:
						if (SnakeHead.y + 10 <= screenHeight) {
							SnakeHead.y += 10;
							repaint();
						}
						break;
					case 4:
						if (SnakeHead.x >= 10) {
							SnakeHead.x -= 10;
							repaint();
						}
						break;
				}
			}
		});
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(0, 0, screenWidth + 5, screenHeight + 4);
		SnakeHead.paint(g);
		for (BlockBody body : SnakeBody) {
			body.paint(g);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_DOWN:
            down();
            break;
        case KeyEvent.VK_UP:
            up();
            break;
        case KeyEvent.VK_RIGHT:
            right();
            break;
        case KeyEvent.VK_LEFT:
            left();
            break;
        }

    }

	private void left() {
		if (SnakeHead.x >= 10) {
			SnakeHead.x -= 10;
			SnakeHead.direction = 4;
		}
		repaint();
	}

	private void right() {
		if (SnakeHead.x + 10 <= this.screenWidth) {
			SnakeHead.x += 10;
			SnakeHead.direction = 2;
		}
		repaint();
	}

	private void up() {
		if (SnakeHead.y >= 10) {
			SnakeHead.y -= 10;
			SnakeHead.direction = 1;
		}
		repaint();
	}

	private void down() {
		if (SnakeHead.y + 10 <= this.screenHeight){
			SnakeHead.y += 10;
			SnakeHead.direction = 3;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
	
}