package GameOfLife;

import java.awt.Graphics;

import javax.swing.JComponent;

public class previousgen extends JComponent {
	public static Case[][] grid = { 	
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
						{ new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false), new Case(false),},
		        };

public Case[][] getGrid() {
		return grid;
}

public static void setGrid(Case[][] grid) {
	previousgen.grid = grid;
}

}