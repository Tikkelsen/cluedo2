package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Board;
import model.Characters;
import model.Square;
import controller.GraphicalGameController;

@SuppressWarnings("serial")
public class CluedoJPanel extends JPanel {

	private Board board;
	private Square[][] squares;
	private ArrayList<Characters> characters;
	private GraphicalGameController pl;
	
	/**
	 * Constructor
	 * @param pl graphical game controller being used
	 */
	public CluedoJPanel(GraphicalGameController pl) {
		this.pl = pl;
		characters = pl.getDeck().getCharacters();
		squares = pl.getSquares();
		
		
		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getX() < 16 * 24 && e.getY() < 16 * 26) {
					Square s = squares[e.getX() / 16][e.getY() / 16];
					System.out.println("Square: " +s.getName());
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		}); 
	}
	
	/**
	 * Paints the board and players on the JPanel
	 */
	@Override
	public void paint(Graphics g) {
		for(int y = 0; y < squares.length; y++) {
			for(int x = 0; x < squares[0].length; x++) {
				Square square = squares[y][x];
				
				//Bug testing, shouldn't get here
				if(square == null) {
					System.out.println("Nahhhh.. y: "+y+ " x: "+x);
				}
				
				//check what the square is and draw the corresponding image
				
				else if(square.isWallSquare()) {
					g.drawImage(createBoardImage("wallsquare.png"), x*16, y*16, null);
				}
				else if(square.isBoundary()) {
					g.setColor(Color.BLACK);
					g.fillRect(x*16, y*16, 16, 16);
				}
				else if(square.isDoor()) {
					g.drawImage(createBoardImage("carpetsquare.png"), x*16, y*16, null);
				}
				else if(square.isRoomSquare()) {
					g.drawImage(createBoardImage("carpetsquare.png"), x*16, y*16, null);
				}
				else if(square.isOccupied()) {
					Characters player = square.getPlayer().getCharacter();
					Image playerImage = createPlayerImage(player.getImage());
					g.drawImage(playerImage, x*16, y*16, null);
				}
				//must be a floor square then
				else {
					g.drawImage(createBoardImage("floorsquare.png"), x*16, y*16, null);
				}
				
				//draw all the characters
				Image charIcon = drawCharacter(x, y);
				if(charIcon != null){
					g.drawImage(charIcon, x*16, y*16, null);
				}
			}
		}
	}
	
	
	/**
	 * Draws the character on the board
	 * @param x x position of the character to be drawn
	 * @param y y position of the character to be drawn
	 * @return the image to draw
	 */
	private Image drawCharacter(int x, int y) {
		for(Characters p : characters) {
			if(p.getxPos() == x && p.getyPos() == y) {
				return createPlayerImage(p.getImage());
			}
		}
		return null;
	}
	
	/**
	 * Gets an image to draw from the board file
	 * @param imageName the name of the image
	 * @return the image object to be drawn
	 */
	private Image createBoardImage(String imageName) {
		Image image;
		Image resizedImage = null;
		
		try {
			image = ImageIO.read(new File("Images" +File.separator+ "boardimages" +File.separator +imageName));
			resizedImage = image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		}
		catch(IOException e) {
			System.out.println("(createBoardImage)Could not read image file: " +imageName);
		}
		
		return resizedImage;
	}
	
	/**
	 * Creates a player image from the players file
	 * @param imageName Name of the player image
	 * @return Image object of the specific player
	 */
	private Image createPlayerImage(String imageName) {
		Image image;
		Image resizedImage = null;
		
		try {
			 image = ImageIO.read(new File("Images"+File.separator+"characters"+File.separator+imageName));
			 resizedImage = image.getScaledInstance(16,16, Image.SCALE_SMOOTH);
			
		} catch (IOException e) {
			System.out.println("(createPlayerImage)Could not read image file: "+imageName);
		}
		
		return resizedImage;
	}
}
