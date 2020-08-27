package GameOfLife;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class CaseClickListener extends MouseAdapter {
	public void mousePressed(MouseEvent e) {
	previousgen previousgen = new previousgen();
	Case acase = (Case) e.getSource();
	acase.setLife(!acase.isLife());
	}

}

