package uniandes.cupi2.nonogramas.interfaz;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.plaf.ColorUIResource;

import uniandes.cupi2.nonogramas.mundo.Board;
import uniandes.cupi2.nonogramas.mundo.Tiles;
import uniandes.cupi2.nonogramas.mundo.CustomColors;
import uniandes.cupi2.nonogramas.mundo.CustomFonts;

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
	private ImageIcon favicon = new ImageIcon(getClass().getClassLoader().getResource("imagenes/favicon.png"));
	
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
		
		board = new Board(this);
		tiles = new Tiles(this);
		setLayout(new BorderLayout());
		setSize(840, 710);
		setTitle("Nonograms");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(favicon.getImage());
		setResizable(false);
		
		bannerPanel = new BannerPanel();
		add(bannerPanel, BorderLayout.NORTH);
		
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
	public void reqFuncOption2(){
		String returned = board.method2();
		JOptionPane.showMessageDialog(this, returned, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Executes the program, creating a new interface
	 * Customize UI elemets
	 * @param args Invoking arguments. I does not requiere any.
	 */
	public static void main(String[] args){

		MainInterface main = new MainInterface();
		main.setVisible(true);
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

