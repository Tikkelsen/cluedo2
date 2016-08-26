package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import model.Card;
import model.Player;
import controller.GraphicalGameController;

@SuppressWarnings("serial")
public class InfoPanel extends JPanel {

	private GraphicalGameController pl;
	private ArrayList<Player> player;
	private JLabel dice;
	private JLabel charName;
	
	/**
	 * Constructor
	 * @param pl graphical game controller being used
	 */
	public InfoPanel(GraphicalGameController pl) {
		this.pl = pl;
		this.player = pl.getPlayerList();
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		setLayout(null);
		
		charName = new JLabel("Miss Scarlet");
		charName.setHorizontalAlignment(SwingConstants.CENTER);
		charName.setBounds(10, 37, 380, 23);
		charName.setFont(new Font("Calibri", Font.BOLD, 18));
		add(charName);
		
		JLabel charIcon = new JLabel();
		charIcon.setBounds(149, 71, 100, 100);
		add(charIcon);
		
		drawCards();
		
		JLabel roll = new JLabel("Your Dice:");
		roll.setBounds(309, 313, 50, 14);
		add(roll);
		
		dice = new JLabel();
		dice.setBounds(324, 338, 31, 31);
		displayDice(pl.rollDice());
		add(dice);
		
		setVisible(true);
		
		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
			@Override
			public void mouseEntered(MouseEvent e) {

			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Pressed mouse");
			}
		});
	}
	
	/**
	 * Draw all the cards the player has
	 */
	public void drawCards() {
		Player p = player.get(0);
		if(p != null) {
			ArrayList<Card> cards = p.getCards();
			for(int i = 1; i < cards.size(); i++) {
				ImageIcon cardIcon = new ImageIcon(createCardImage(cards.get(i - 1).getImage()));
				JLabel card = new JLabel(cardIcon);
				card.setBounds(10 * i, 180 * i, 70, 104);
				add(card);
			}
		}
	}
	
	public Image createCardImage(String fileName) {
		Image image;
		Image resizedImage = null;
		
		try {
			image = ImageIO.read(new File("Images" + File.separator + "cards" + File.separator + fileName));
			resizedImage = image.getScaledInstance(70, 104, Image.SCALE_SMOOTH);

		} catch (IOException e) {
			System.out.println("Could not read image file: " + e.getMessage());
		}
		return resizedImage;
	}
	
	public void displayDice(int roll) {
		Image image;
		Image resizedImage = null;
		
		try {
			image = ImageIO.read(new File("Images" + File.separator + "dice" + File.separator + roll + ".png"));
			resizedImage = image.getScaledInstance(31, 31, Image.SCALE_SMOOTH);
			dice.setIcon(new ImageIcon(resizedImage));

		} catch (IOException e) {
			System.out.println("Could not read image file: " + e.getMessage());
		}
	}
}
