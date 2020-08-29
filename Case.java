package GameOfLife;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;

public class Case extends JButton {
private boolean life;



public Case(boolean b) {
	life = b;
	this.addMouseListener(new CaseClickListener());
}

public boolean isLife() {
	return life;
}

public void setLife(boolean life) {
	this.life = life;
}

	public void paint(Graphics g) {
		Rectangle bound = g.getClipBounds();
		g.setColor(life ? Color.BLACK : Color.WHITE);
		g.fillRect(bound.x,bound.y,bound.width,bound.height);
		g.setColor(Color.GRAY);
		g.drawRect(bound.x, bound.y, bound.width-1, bound.height-1);
		repaint();
		
	};

}
