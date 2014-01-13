package source;

import java.awt.Graphics;

public class Block {
	
	public int x;
	public int y;
	public int direction;
	
	public Block(int x, int y) {
		this.x = x;
		this.y = y;
		direction = 1;
	}
	
	public void paint(Graphics g) {
		g.fillRect(x, y, 10, 10);
	}
}
