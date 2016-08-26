package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import controller.GraphicalGameController;

@SuppressWarnings("serial")
public class StartFrame extends JFrame implements ActionListener {

	int height;
	int width;
	int playerCount;
	Dimension boardDimensions;
	JPanel contentPane;
	JLabel characterPicture;
	JTextField name;
	int count;
	JTextField txtName;
	
	ArrayList<String> charNameList = new ArrayList<String>();
	ArrayList<String> playerNameList = new ArrayList<String>();
	
	/**
	 * Constructor
	 * @param width width of the frame
	 * @param height height of the frame
	 */
	public StartFrame(int width, int height) {
		this.width = width;
		this.height = height;
		this.contentPane = new JPanel();
		setContentPane(contentPane);
		
		boardDimensions = new Dimension(width, height);
		setSize(new Dimension(400,400));
		setMinimumSize(boardDimensions);
		
		getPlayerCount();
		
		setTitle("Cluedo");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		requestFocus();
		
		setVisible(true);
		
		createLookAndFeel();
	}

	private void createLookAndFeel() {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            System.out.println("Look and feel failed");
        }
	}

	/**
	 * Frame for getting the player count
	 * @return returns the number of players the user has selected
	 */
	private int getPlayerCount() {
		ImageIcon logoImage = new ImageIcon("Images/Logo.jpg");
		JLabel logoLabel = new JLabel();
		logoLabel.setIcon(logoImage);
		logoLabel.setBounds(38, 43, 330, 100);
		
		characterPicture = new JLabel();
		characterPicture.setBounds(200, 200, 30, 30);
		
		String[] possibleCounts = {"3", "4", "5", "6"};
		
		JComboBox<?> countChoice = new JComboBox<Object>(possibleCounts);
		countChoice.setBounds(161, 224, 74, 37);
		
		countChoice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				playerCount = countChoice.getSelectedIndex() + 3;
			}
		});
		
		contentPane.setLayout(null);
		
		JLabel numberOfPlayers = new JLabel("Number of players:");
		numberOfPlayers.setBounds(10, 185, 374, 28);
		numberOfPlayers.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfPlayers.setFont(new Font("Calibri", Font.PLAIN, 20));
		getContentPane().add(numberOfPlayers);
		
		JButton next = new JButton("Next");
		next.setBounds(311, 338, 74, 23);
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getPlayers();
			}
		});
		
		JButton exit = new JButton("Exit");
		exit.setBounds(233, 338, 74, 23);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		
		contentPane.add(logoLabel);
		contentPane.add(countChoice);
		contentPane.add(next);
		contentPane.add(exit);
		
		getRootPane().setDefaultButton(next);
		
		return playerCount;
	}

	private void getPlayers() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(0, 0, 400, 400);
		contentPane = new JPanel();
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JLabel player = new JLabel("Player " + (count + 1));
		player.setHorizontalAlignment(SwingConstants.CENTER);
		player.setFont(new Font("Calibri", Font.PLAIN, 20));
		player.setBounds(10, 11, 364, 35);
		contentPane.add(player);
		
		JLabel header = new JLabel("Choose a name and character");
		header.setFont(new Font("Calibri", Font.PLAIN, 15));
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setBounds(10, 42, 364, 24);
		contentPane.add(header);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Calibri", Font.PLAIN, 15));
		name.setBounds(31, 96, 43, 24);
		contentPane.add(name);
		
		txtName = new JTextField();
		txtName.setText("");
		txtName.setBounds(84, 96, 119, 24);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		characterPicture = new JLabel();
		characterPicture.setBounds(225, 150, 100, 100);
		ImageIcon icon = new ImageIcon("Images/characters/missscarlet30x30.png");
		Image image = icon.getImage();
		Image resizedImage = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
	    characterPicture.setIcon(new ImageIcon(resizedImage));
		contentPane.add(characterPicture);
		
		JLabel lblCharacter = new JLabel("Character:");
		lblCharacter.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblCharacter.setBounds(31, 144, 70, 24);
		contentPane.add(lblCharacter);
		
		ButtonGroup bGroup = new ButtonGroup();
		
		JRadioButton scarlet = new JRadioButton("Miss Scarlet");
		scarlet.setBounds(100, 144, 119, 24);
		scarlet.setActionCommand("missscarlet30x30");
		scarlet.setSelected(true);
		contentPane.add(scarlet);
		
		final JRadioButton peacock = new JRadioButton("Mrs Peacock");
		peacock.setBounds(100, 171, 119, 24);
		peacock.setActionCommand("mrspeacock30x30");
		contentPane.add(peacock);

		final JRadioButton white = new JRadioButton("Mrs White");
		white.setBounds(100, 198, 119, 24);
		white.setActionCommand("mrswhite30x30");
		contentPane.add(white);

		final JRadioButton mustard = new JRadioButton("Colonel Mustard");
		mustard.setBounds(100, 225, 119, 24);
		mustard.setActionCommand("mrmustard30x30");
		contentPane.add(mustard);
		
		final JRadioButton green = new JRadioButton("Reverend Green");
		green.setBounds(100, 252, 119, 24);
		green.setActionCommand("reverendgreen30x30");
		contentPane.add(green);

		final JRadioButton plum = new JRadioButton("Professor Plum");
		plum.setBounds(100, 279, 119, 24);
		plum.setActionCommand("profplum30x30");
		contentPane.add(plum);
		
		bGroup.add(scarlet);
		bGroup.add(peacock);
		bGroup.add(white);
		bGroup.add(mustard);
		bGroup.add(green);
		bGroup.add(plum);
		
		scarlet.addActionListener(this);
		peacock.addActionListener(this);
		white.addActionListener(this);
		mustard.addActionListener(this);
		green.addActionListener(this);
		plum.addActionListener(this);
		
		JButton startGame = new JButton("Start Game");
		startGame.setEnabled(false);
		startGame.setBounds(274, 327, 100, 24);
		startGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GraphicalGameController(charNameList, playerNameList);
			}
		});
		contentPane.add(startGame);
		
		JButton nextPlayer = new JButton("Next Player");
		nextPlayer.setBounds(170, 327, 100, 24);
		nextPlayer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Enumeration<AbstractButton> buttons = bGroup.getElements(); buttons.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();
					
					if(button.isSelected()) {
						if(!txtName.getText().equals("")) {
							charNameList.add(button.getText());
							playerNameList.add(txtName.getText());
							button.setEnabled(false);
							bGroup.clearSelection();
							count++;
							player.setText("Player: " + (count + 1));
							txtName.setSelectionStart(0);
							txtName.setText("");
							txtName.requestFocus();
							txtName.setSelectionStart(0);
						}
					}
					
					if(count == playerCount) {
						nextPlayer.setEnabled(false);
						txtName.setEnabled(false);
						player.setText("Player: " + (count));
						
						green.setEnabled(false);
						scarlet.setEnabled(false);
						peacock.setEnabled(false);
						white.setEnabled(false);
						plum.setEnabled(false);
						mustard.setEnabled(false);
						
						startGame.setEnabled(true);
					}
				}
			}
		});
		contentPane.add(nextPlayer);
		
		txtName.requestFocus();
		txtName.setSelectionStart(0);

		setLocationRelativeTo(null);
		setResizable(false);
		requestFocus();
		setVisible(true);
		
		createLookAndFeel(); // DOES THIS WORK????
		
		getRootPane().setDefaultButton(nextPlayer);
	}
	
	public void actionPerformed(ActionEvent e) {
		ImageIcon icon = new ImageIcon("Images/characters" +e.getActionCommand() + ".png");
		Image image = icon.getImage();
		Image resizedImage = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		characterPicture.setIcon(new ImageIcon(resizedImage));
	}
}
