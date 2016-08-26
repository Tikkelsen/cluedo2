package model;

public class Characters {
	
	private String name;
	private int xPos;
	private int yPos;
	private boolean isPlaying;
	String ch;
	public String image;
	
	/**
	 * Constructor
	 * @param name name of the character
	 * @param ch id of the character
	 * @param xPos x position of the character
	 * @param yPos y position of the character
	 * @param image image name of the character
	 */
	public Characters(String name, String ch, int xPos, int yPos, String image) {
		this.name = name;
		this.xPos = xPos;
		this.yPos = yPos;
		this.image = image;
		this.ch = ch;
	}

	public String getName() {
		return name;
	}


	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public boolean isPlaying() {
		return isPlaying;
	}
	
	public String getCh() {
		return ch;
	}

	public String getImage() {
		return image;
	}
}
