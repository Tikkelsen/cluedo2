package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Class for the exit dialog when the user clicks the exit button
 * @author Tobias
 *
 */
@SuppressWarnings("serial")
public class ExitDialog extends JDialog {

	/**
	 * Constructor
	 */
	public ExitDialog() {
		setTitle("Confirm Exit");
		getContentPane().setLayout(null);
		setBounds(0, 0, 400, 125);
		setLocationRelativeTo(null);
		setResizable(false);
		requestFocus();
		setVisible(true);
		
		JLabel confirmExit = new JLabel("Are you sure you want to exit the game?");
		confirmExit.setFont(new Font("Calibri", Font.PLAIN, 20));
		confirmExit.setHorizontalAlignment(SwingConstants.CENTER);
		confirmExit.setBounds(10, 11, 380, 37);
		getContentPane().add(confirmExit);
		
		JButton no = new JButton("No");
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		no.setBounds(122, 63, 74, 23);
		getContentPane().add(no);
		
		JButton yes = new JButton("Yes");
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		yes.setBounds(201, 63, 74, 23);
		getContentPane().add(yes);
	}
}
