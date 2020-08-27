package GameOfLife;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;




public class GameOfLife {
	

    public static void main(String[] a) {
    	
    	
    	EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                JFrame frame = new JFrame("GameOfLife");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		ImageIcon img = new ImageIcon("E:\\Dev\\MonWorkspace\\CPS tester\\src\\icon_GameOfLife.png");
        		frame.setIconImage(img.getImage());
                frame.add(background());
                frame.setSize(500, 530);
                frame.setVisible(true);
                frame.setResizable(true); 
                
                
                
            }
           ;
        });
  }
 public static int raws=20;
 public static int columns=20;

 public static JPanel createGrid() {
	 	previousgen previousgen = new previousgen();
	    JPanel grid = new JPanel();
	    GridLayout layout = new GridLayout(raws,columns);
	    layout.setHgap(1);
	    layout.setVgap(1);
	    grid.setLayout(layout);
	    for (int x=0;x<raws;x++) {
	    	for(int y=0;y<columns;y++) {
	    		grid.add(previousgen.grid[x][y]);
	    	}
	    }
	    return grid;
	    
	  
  }
 public static boolean getRandomBoolean() {
     return Math.random() < 0.5;
 }
public static JPanel background() {
	Timer t = new Timer(0, null);
	t.setRepeats(true);
	t.setDelay(125);//setDelay(ms)
	JPanel background = new JPanel();
	JPanel buttons = new JPanel();
	FlowLayout flawlayout = new FlowLayout();
	BorderLayout borderlayout = new BorderLayout();
	buttons.setLayout(flawlayout);
	background.setLayout(borderlayout);
	background.add(createGrid(),BorderLayout.CENTER);
	JButton start = new JButton("Start");
	JButton randomgen = new JButton("Random Generation");
	JButton clear = new JButton("Clear");
	JButton nextgen = new JButton("Next Generation");
	JButton stop = new JButton("Stop");
	background.add(buttons, BorderLayout.NORTH);
	buttons.add(start);
	buttons.add(randomgen);
	buttons.add(nextgen);
	buttons.add(clear);
	buttons.add(stop);
	t.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nextgeneration();
		}
		
	});
	start.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == start) {
				t.start();
				
			}
		}
	});
	randomgen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == randomgen) {
				previousgen previousgen = new previousgen();
				for (int x=0;x<raws;x++) {
					for (int y=0;y<columns;y++) {
						previousgen.grid[y][x].setLife(getRandomBoolean());
					}
				}
				
			}
		}
	});
	nextgen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == nextgen) {
				nextgeneration();
			}
		}
	});
	clear.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == clear) {
				previousgen previousgen = new previousgen();
				for (int x=0;x<raws;x++) {
					for (int y=0;y<columns;y++) {
						previousgen.grid[y][x].setLife(false);
					}
				}
				
			}
		}
	});
	stop.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == stop) {
				t.stop();
			}
		}
	});
	return background;
	
}
public static void nextgeneration() {
		previousgen previousgen = new previousgen();
		boolean[][] nextgen= {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
        };
		for (int x=0;x<raws;x++) {
			for (int y=0;y<columns;y++) {
					int voisins=0;
					
					if (previousgen.grid[y][x].isLife()) {
						voisins=-1;
					}
					for (int vx=-1;vx<2;vx++) {
						for (int vy=-1;vy<2;vy++) {
							try {
							if (previousgen.grid[y+vy][x+vx].isLife()) {
								voisins++;
								
							}}catch(Exception e1) {};
						}
					}
					if (voisins==3&!previousgen.grid[y][x].isLife()) {
						nextgen[y][x]=true;
					} else if ((voisins==3|voisins==2)&previousgen.grid[y][x].isLife()) {
						nextgen[y][x]=true;
					} else {
						nextgen[y][x]=false;
					}
			}
		}
		
		for (int x=0;x<raws;x++) {
			for (int y=0;y<columns;y++) {
//				if (nextgen[y][x]) {
//					previousgen.grid[y][x].setLife(true);
//				} else {
//					previousgen.grid[y][x].setLife(false);
//				}
				previousgen.grid[y][x].setLife((nextgen[y][x]));
			}
		}

		
	
}
}
