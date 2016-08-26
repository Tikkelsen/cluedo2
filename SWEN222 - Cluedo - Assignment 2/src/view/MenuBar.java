package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

	/**
	 * Constructor
	 */
	public MenuBar() {
		JMenu file = new JMenu("File");
		add(file);
		
		JMenuItem newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StartFrame(400, 400);
			}
		});
		file.add(newGame);
		
		JMenuItem exitGame = new JMenuItem("Exit Game");
		exitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				JDialog exitDialog = new ExitDialog();
			}
		});
		file.add(exitGame);
	}
}
