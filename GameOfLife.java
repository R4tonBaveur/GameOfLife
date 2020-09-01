package GameOfLife;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;

import java.util.ArrayList;
import java.util.List;

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
                JFrame window = new JFrame("GameOfLife");
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		ImageIcon img = new ImageIcon("C:\\Users\\matth\\Pictures\\GameOfLife.png");
        		window.setIconImage(img.getImage());
        		window.add(background());
        		window.setSize(800, 800);
        		window.setVisible(true);
        		window.setResizable(true);
            };
        });
}

public static int raws=40;
public static int columns=40;
static JCheckBox[]BornConds= {new JCheckBox("0",false), new JCheckBox("1",false), new JCheckBox("2",false), new JCheckBox("3",true), new JCheckBox("4",false), new JCheckBox("5",false), new JCheckBox("6",false), new JCheckBox("7",false), new JCheckBox("8",false)};
static JCheckBox[]SurviveConds= {new JCheckBox("0",false), new JCheckBox("1",false), new JCheckBox("2",true), new JCheckBox("3",true), new JCheckBox("4",false), new JCheckBox("5",false), new JCheckBox("6",false), new JCheckBox("7",false), new JCheckBox("8",false)};

public static boolean getRandomBoolean() {
     return Math.random() < 0.5;
 }

public static JPanel background() {
	//Creating the different components
	JPanel background = new JPanel();
	JPanel buttons = new JPanel();
	JPanel grid = new JPanel();
	FlowLayout flawlayout = new FlowLayout();
	BorderLayout borderlayout = new BorderLayout();
	GridLayout gridlayout = new GridLayout(raws,columns);
	GridLayout RulesLayout = new GridLayout(2,10);
	JButton start = new JButton("Start");
	JButton randomgen = new JButton("Random Generation");
	JButton clear = new JButton("Clear");
	JButton nextgen = new JButton("Next Generation");
	JButton stop = new JButton("Stop");
	JButton settings = new JButton("Delay");
	JButton rules = new JButton("rules");
	JDialog RulesWindow = new JDialog();
	JPanel RulesPanel = new JPanel();
	JLabel bornlabel = new JLabel("cell borns");
	JLabel survivelabel = new JLabel("cell survives");
	previousgen previousgen = new previousgen();
	ImageIcon settingsIcon = new ImageIcon("C:\\Users\\matth\\Pictures\\settings_logo.png");
	Timer t = new Timer(0, null);//creates the timer for repeatedly spawning the next generations
	t.setRepeats(true);
	t.setDelay(125);//setDelay(Ms) sets repeat delay of start button
	String[] delaylist = {"Delay","125","250","500","1000"};
	//Adding the layouts to the panels and setting them
	buttons.setLayout(flawlayout);
	background.setLayout(borderlayout);
    grid.setLayout(gridlayout);
    gridlayout.setHgap(0);
    gridlayout.setVgap(0);
    RulesPanel.setLayout(RulesLayout);
	RulesLayout.setHgap(5);
	RulesLayout.setVgap(10);
	//setting the RulesWindow frame
	RulesWindow.setIconImage(settingsIcon.getImage());
	RulesWindow.setTitle("Rules");
	RulesWindow.setDefaultCloseOperation(RulesWindow.HIDE_ON_CLOSE);
	RulesWindow.setSize(650,200);
	//adding the different components to all their frame
    for (int x=0;x<raws;x++) {
    	for(int y=0;y<columns;y++) {
    		grid.add(previousgen.grid[x][y]);
    	}
    }
	background.add(buttons, BorderLayout.NORTH);
	background.add(grid, BorderLayout.CENTER);
	buttons.add(start);
	buttons.add(randomgen);
	buttons.add(nextgen);
	buttons.add(clear);
	buttons.add(stop);
	buttons.add(rules);
	buttons.add(settings);
	RulesWindow.add(RulesPanel);
	RulesPanel.add(bornlabel);
	for (int i=0;i<9;i++) {
		RulesPanel.add(BornConds[i]);
	};
	RulesPanel.add(survivelabel);
	for (int i=0;i<9;i++) {
		RulesPanel.add(SurviveConds[i]);
	};
	
	rules.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == rules) {
				RulesWindow.setVisible(true);
			}
		}
	});
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
	settings.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == settings) {
				JOptionPane WindowSetting = new JOptionPane();
				String GenerationDelay = (String) WindowSetting.showInputDialog(null,"Select a delay between each generation","Delay",JOptionPane.QUESTION_MESSAGE, null, delaylist,delaylist[0]);
				if ("125".equals(GenerationDelay)) {
					t.setDelay(125);
				} else if ("250".equals(GenerationDelay)) {
					t.setDelay(250);
				}else if ("500".equals(GenerationDelay)) {
					t.setDelay(500);
				}else if ("1000".equals(GenerationDelay)) {
					t.setDelay(1000);
				};
			};
		};
	});
	return background;
	
	
}

public static void nextgeneration() {
		previousgen previousgen = new previousgen();
		boolean[][] nextgen= {
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
				{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
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
					for (int i=0;i<9;i++) {
						if(BornConds[i].isSelected()&i==voisins&!previousgen.grid[y][x].isLife()) {
							nextgen[y][x]=true;
						} else if (SurviveConds[i].isSelected()&i==voisins&previousgen.grid[y][x].isLife()) {
							nextgen[y][x]=true;
						}
					}
			}
		}
		
		for (int x=0;x<raws;x++) {
			for (int y=0;y<columns;y++) {
				previousgen.grid[y][x].setLife((nextgen[y][x]));
			}
		}

		
	
}
}
