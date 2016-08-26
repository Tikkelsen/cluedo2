package view;

import java.awt.Graphics;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import controller.GraphicalGameController;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	
	private int FRAME_WIDTH = 832;
	private int FRAME_HEIGHT = 468;
	private JMenuBar menuBar;
	private JPanel contentPane;
	private CluedoJPanel cluedoJPanel;
	private InfoPanel infoPanel;
	private GraphicalGameController pl;
	
	/**
	 * Constructor
	 * @param pl graphical game controller being used
	 */
	public GameFrame(GraphicalGameController pl) {
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.pl = pl;
		setTitle("Cluedo Game");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		requestFocus();
		
		menuBar = new MenuBar();
		setJMenuBar(menuBar);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cluedoJPanel = new CluedoJPanel(pl);
		cluedoJPanel.setBounds(0, 0, 432, 500);
		contentPane.add(cluedoJPanel);
		
		infoPanel = new InfoPanel(pl);
		infoPanel.setBounds(435, 0, 385, 416);
		contentPane.add(infoPanel);
		infoPanel.setLayout(null);
		
		addWindowListener(new java.awt.event.WindowAdapter() {
			//@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				@SuppressWarnings("unused")
				JDialog exitDialog = new ExitDialog();
			}
		});
		
		setLookAndFeel();
		setVisible(true);
	}
	
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException
				| InstantiationException e) {
			e.printStackTrace();
			System.out.println("Look and feel failed");
		}
	}
	
	@Override
	public void paint(Graphics g) {
		menuBar.repaint();
		contentPane.repaint();
		infoPanel.repaint();
	}
	
	public void rollDice() {
		int roll = GraphicalGameController.rollDice();
		infoPanel.displayDice(roll);
	}
	
	public void getTurnInfo() {
		repaint();
	}
}
