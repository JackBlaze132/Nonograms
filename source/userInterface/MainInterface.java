package userInterface;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.plaf.ColorUIResource;

import world.Board;
import world.CustomColors;
import world.CustomFonts;
import world.Tiles;

/**
 * This class represents the main interface
 */
public class MainInterface extends JFrame {	
	//--------------------------------------------------------------------------------------------------------------
    // Class Atributes
    //--------------------------------------------------------------------------------------------------------------
    
	/**
	 * New atriibutte of Board type
	 */
	private Board board;

	/**
	 * New atributte of Tiles type
	 */
	private Tiles tiles;

	/**
	 * Pannel that contains the banner image
	 */
	private BannerPanel bannerPanel;

	/**
	 * Panel that contains leftside image
	 */
	private LeftPanel leftPanel;

	/**
	 * Panel that contains rightside image
	 */
	private RightPanel rightPanel;

	/**
	 * Panel that contains program's options
	 */
	private OptionsPanel optionsPanel;

	/**
	 * Panel that contains the gameboad and main game's options
	 */
	private MainGamePanel mainGamePanel;

	/**
	 * creates new favicon icon
	 */
	private ImageIcon favicon;
	
	/**
	 * Invokes CustomColors class
	 */
	private static final CustomColors customColors = new CustomColors();

	/**
	 * Invokes CustomFonts class
	 */
	private static final CustomFonts customFonts = new CustomFonts();

	//--------------------------------------------------------------------------------------------------------------
    // Constructor
    //--------------------------------------------------------------------------------------------------------------
    
	/**
	 * Constructor of the MainInterface class
	 */
	public MainInterface(){
		
		favicon = new ImageIcon(getClass().getClassLoader().getResource("images/favicon.png"));
		board = new Board(this);
		tiles = new Tiles(this);
		setUndecorated(true);
		setLayout(new BorderLayout());
		setSize(820, 710);
		setTitle("Nonograms");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(favicon.getImage());
		setResizable(false);

		JPanel titleBar = new JPanel();
		titleBar.setBackground(customColors.myDarkGray());
		titleBar.setLayout(new BorderLayout());
		titleBar.setPreferredSize(new Dimension(this.getWidth(), 225));

		ImageIcon windowIcon = new ImageIcon(MainInterface.class.getClassLoader().getResource("images/favicon.png"));
		Image scaledImage = windowIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		JLabel iconLabel = new JLabel(new ImageIcon(scaledImage));
		iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));  // Padding left

		// Create a title label
		JLabel titleLabel = new JLabel("Nonograms");
		titleLabel.setForeground(Color.WHITE);

		// Panel to hold the icon and title
		JPanel iconAndTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		iconAndTitlePanel.setOpaque(false);  // Make the panel transparent
		iconAndTitlePanel.add(iconLabel);
		iconAndTitlePanel.add(titleLabel);

		titleBar.add(iconAndTitlePanel, BorderLayout.WEST);

		// Create buttons for minimize, maximize, and close with icons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);  // Transparent background
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

		JButton minimizeButton = new JButton(new ImageIcon(MainInterface.class.getClassLoader().getResource("images/minimize.png")));
		customizeButton(minimizeButton);
		minimizeButton.setOpaque(true);
		minimizeButton.setBackground(customColors.myDarkGray());
		minimizeButton.addActionListener(e -> this.setState(JFrame.ICONIFIED));
		minimizeButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				minimizeButton.setBackground(new Color(70, 70, 70));
			}

			public void mouseExited(MouseEvent e) {
				minimizeButton.setBackground(customColors.myDarkGray()); // Restoring the background color
			}
		});

		JButton closeButton = new JButton(new ImageIcon(MainInterface.class.getClassLoader().getResource("images/close.png")));
		customizeButton(closeButton);

		// Ensure button background is painted
		closeButton.setOpaque(true);
		closeButton.setBackground(customColors.myDarkGray());

		// Change button color to red on hover
		closeButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				closeButton.setBackground(Color.RED);
			}

			public void mouseExited(MouseEvent e) {
				closeButton.setBackground(customColors.myDarkGray()); // Restoring the background color
			}
		});

		closeButton.addActionListener(e -> System.exit(0));

		bannerPanel = new BannerPanel();

		// Add buttons to the panel
		buttonPanel.add(minimizeButton);
		buttonPanel.add(closeButton);

		titleBar.add(buttonPanel, BorderLayout.EAST);
		titleBar.add(bannerPanel, BorderLayout.SOUTH);

		// Add the custom title bar to the frame
		this.add(titleBar, BorderLayout.NORTH);

		// Make the window draggable
		makeWindowDraggable(this, titleBar);

		// Main content of the frame

		
		/*bannerPanel = new BannerPanel();
		add(bannerPanel, BorderLayout.NORTH);*/
		
		leftPanel = new LeftPanel();
		add(leftPanel, BorderLayout.WEST);
		
		rightPanel = new RightPanel();
		add(rightPanel, BorderLayout.EAST);
		
		optionsPanel = new OptionsPanel(this);
		add(optionsPanel, BorderLayout.SOUTH);	

		mainGamePanel = new MainGamePanel(this);
		add(mainGamePanel, BorderLayout.CENTER);

	}

	//--------------------------------------------------------------------------------------------------------------
    // Class Methods
    //--------------------------------------------------------------------------------------------------------------

	private static void customizeButton(JButton button) {
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setOpaque(true);  // Ensure the background is painted
		button.setPreferredSize(new Dimension(30, 30));
	}

	private static void makeWindowDraggable(JFrame frame, JPanel titleBar) {
		final Point[] initialClick = {null};
		titleBar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				initialClick[0] = e.getPoint();
				frame.getComponentAt(initialClick[0]);
			}
		});

		titleBar.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				// Get the current location of the window
				int thisX = frame.getLocation().x;
				int thisY = frame.getLocation().y;

				// Determine how much the mouse moved since the initial click
				int xMoved = e.getX() - initialClick[0].x;
				int yMoved = e.getY() - initialClick[0].y;

				// Move window to this position
				int X = thisX + xMoved;
				int Y = thisY + yMoved;
				frame.setLocation(X, Y);
			}
		});
	}
    
	/**
	 * Gives the name of the current puzzle
	 * @return Name of the current puzzle
	 */
	public String givePuzzleName(){
		return mainGamePanel.givePuzzleName();
	}


	/**
	 * Checks if the current selected file is valid to be selected
	 * @return valid selected file
	 */
	public boolean thereSelectedFile(){
		return board.thereSelectedFile(mainGamePanel.giveSelectedFile(), mainGamePanel.giveCurrentFile());
	}

	/**
	 * Give board's answers in a String type Array
	 * @return Current puzzle answers Array
	 */
	public String[][] giveBoardAnswers(){
		return board.giveAnswerList(mainGamePanel.giveAnswersList());
	}

	/**
	 * Give Player's answersm in a Strig type Array
	 * @return Current player answers Array
	 */
	public String[][] givePlayerMatrix(){
		return board.createCompareArrays(mainGamePanel.givePlayerMatrix());
	}

	/**
	 * Fill the current puzzle's clues per rows
	 * @param rRows Set of 5 rows positions for the curretn puzzle clues from (0-4)
	 * @param matrix Player buttons Array
	 */
	public void fillRowsClues(String[] rRows, JButton[][] matrix){
		tiles.fillRowsClues(rRows, matrix);
	}

	/**
	 * Fill the current puzzle's clues per columns
	 * @param cColumns Set of 5 columns positions for the curretn puzzle clues from (0-4)
	 * @param matrix Player buttons Array
	 */
	public void fillColumsClues(String[] cColumns, JButton[][] matrix){
		tiles.fillColumsClues(cColumns, matrix);
	}

	/**
	 * Verefies the number of correct answers per column
	 */
	public void getCorrectByColumn(){
		tiles.getCorrectByColumn();
	}

		/**
	 * Verefies the number of correct answers per row
	 */
	public void getCorrectByRow(){
		tiles.getCorrectByRow();
	}

	/**
	 * Verifies if answers Array and player's Array are the same
	 * If both array are the same, then it sends a message notifying that the player has won
	 */
	public void compareArrays(){
		board.compareArrays(giveBoardAnswers(), givePlayerMatrix());
	}

	/**
	 * Method for extension 1
	 */
	public void reqFuncOption1(){
		String returned = board.method1();
		JOptionPane.showMessageDialog(this, returned, "Respuesta", JOptionPane.INFORMATION_MESSAGE);	
	}

	/**
	 * Method for extension 2
	 */

	/**
	 * Executes the program, creating a new interface
	 * Customize UI elemets
	 * @param args Invoking arguments. I does not requiere any.
	 */
	public static void main(String[] args){

		MainInterface main = new MainInterface();
		main.setVisible(true);
		main.setResizable(true);
		UIManager.put("OptionPane.background", customColors.myDarkGray());
		UIManager.put("Panel.background", Color.BLACK);
		UIManager.put("Panel.border", BorderFactory.createLineBorder(Color.BLACK, 5));
		UIManager.put("OptionPane.border", BorderFactory.createLineBorder(Color.GRAY, 5));
		UIManager.put("OptionPane.messageForeground", Color.WHITE);
		UIManager.put("OptionPane.messageFont", customFonts.consolas());
		UIManager.put("Button.background", customColors.darkButtons());
		UIManager.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));
        UIManager.put("ToggleButton.focus", new ColorUIResource(new Color(0, 0, 0, 0)));
		UIManager.put("Button.foreground", Color.WHITE);
		UIManager.put("Button.border", BorderFactory.createLineBorder(customColors.darkButtons(), 7));
		UIManager.put("Button.disabledText", Color.WHITE);
	}
}

