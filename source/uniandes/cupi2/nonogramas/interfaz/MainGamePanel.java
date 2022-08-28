package uniandes.cupi2.nonogramas.interfaz;

import uniandes.cupi2.nonogramas.mundo.CustomColors;
import uniandes.cupi2.nonogramas.mundo.CustomFonts;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.Border;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;

import java.util.Properties;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This class represents the Main Game panel
 */
public class MainGamePanel extends JPanel implements ActionListener {
    
    //--------------------------------------------------------------------------------------------------------------
    // Class Atributes
    //--------------------------------------------------------------------------------------------------------------
    
    /**
	 * New atriibutte of MainInterface type
	 */
    private MainInterface main;

    /**
	 * Panel that loads or resets a game
	 */
    private JPanel newGamePanel;

    /**
	 * Main gameboard composed by tiles
	 */
    private TilesPanel tilesPanel;

    /**
	 * Button that loads a game file
	 */
    private JButton btnLoad;

    /**
	 * Button that resest the current game
	 */
    private JButton btnReset;

    /**
	 * Empty Labetl that works as a separator
	 */
    private JLabel sep;

    /**
     * Selected file from the file chooser
     */
    private File selectedFile;

    /**
     * The current Selected file from the file chooser
     */
    private File currentFile;

    /**
     * File with the the puzzle clues and answers
     */
    private Properties fileProperties;

    /**
     * Name of the current puzzle
     */
    private String puzzleName;
    
    /**
     * Fixed list of the current puzzle clues by columns
     */
    private String[] columsClues;

    /**
     * Fixed list of the current puzzle clues by row
     */
    private String[] rowsClues;
    
    /**
     * Fixed list of the current puzzle answers
     */
    private String[] answers;

    /**
     * Command for load button
     */
    private static final String LOAD = "LOAD";

    /**
     * Command for reset button
     */
    private static final String RESET ="RESET";

    /**
     * invokes the CustomColors class
     */
    private static final CustomColors customColors = new CustomColors();

    /**
     * invokes the CustomsFonts class
     */
    private static final CustomFonts customFonts = new CustomFonts();
    
    /**
	 * Line border of myDarkColor Color
	 */
    private static final Border lineBorder = BorderFactory.createLineBorder(customColors.myDarkGray());

    /**
	 * Titled border for the main gameboard section
	 */
    private static final TitledBorder titledBorder = BorderFactory.createTitledBorder(lineBorder, "New Game");

    //--------------------------------------------------------------------------------------------------------------
    // Constructor
    //--------------------------------------------------------------------------------------------------------------
    
    /**
     * Constructor of the MainGamePanel class
     * @param pMain Indicates it will show in the main interface
     */
    public MainGamePanel(MainInterface pMain) {
        
        main = pMain;
        selectedFile = null;
        fileProperties = new Properties();

        puzzleName = null;
        columsClues = new String[5];
        rowsClues = new String[5];
        answers = new String[5];

        setLayout(new BorderLayout());

        tilesPanel = new TilesPanel(pMain);
        add(tilesPanel, BorderLayout.CENTER);

        newGamePanel = new JPanel();
        add(newGamePanel, BorderLayout.SOUTH);
        
        //newGamePanel.setLayout(new GridLayout(1,2));
        newGamePanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
            c.gridwidth = 2;
            c.gridheight = 1;
            c.gridx = 0;
            c.gridy = 1;

        GridBagConstraints d = new GridBagConstraints();
            d.gridwidth = 2;
            d.gridheight = 1;
            d.gridx = 3;
            d.gridy = 1;

        GridBagConstraints f = new GridBagConstraints();
            f.gridwidth = 1;
            f.gridheight = 1;
            f.gridx = 2;
            f.gridy = 1;

        newGamePanel.setBorder(titledBorder);
        titledBorder.setTitleColor(customColors.pewter());
        newGamePanel.setBackground(customColors.myDarkGray());

        
        btnLoad = new JButton(" Load");
        btnLoad.setFont(customFonts.fontAwesome());
        btnLoad.setFocusable(false);
        btnLoad.setPreferredSize(new Dimension(190,30));
        btnLoad.setActionCommand(LOAD);
        btnLoad.addActionListener(this);
        btnLoad.setBackground(customColors.blueCale());
        btnLoad.setBorder(BorderFactory.createEmptyBorder());
        btnLoad.setForeground(Color.white);
        newGamePanel.add(btnLoad, c);
        
        sep = new JLabel();
        sep.setPreferredSize(new Dimension(10, 30));
        newGamePanel.add(sep, f);
        
        
        btnReset = new JButton(" Reset");
        btnReset.setFont(customFonts.fontAwesome());
        btnReset.setFocusable(false);
        btnReset.setPreferredSize(new Dimension(190,30));
        btnReset.setActionCommand(RESET);
        btnReset.addActionListener(this);
        btnReset.setBackground(customColors.honeySuckle());
        btnReset.setForeground(Color.WHITE);
        btnReset.setBorder(BorderFactory.createEmptyBorder());
        newGamePanel.add(btnReset, d);
        
        

        tilesPanel.setBackground(customColors.myDarkGray());

    }
    
    //--------------------------------------------------------------------------------------------------------------
    // Class Methods
    //--------------------------------------------------------------------------------------------------------------
    
    /**
     * Gives a list with the current puzzle's correct answers
     * @return Answer List
     */
    public String[] giveAnswersList() {
        return answers;
    } 
    
    /**
     * Gives an Array with the Player answers
     * @return Player's answers Array
     */
    public JButton[][] givePlayerMatrix() {
        return tilesPanel.giveMatrix();
    }

    /**
     * Gives the name of the current puzzle
     * @return The name of the curretn puzzle
     */
    public String givePuzzleName() {
        return puzzleName;
    }

    /**
     * Give the valid selected file on the file chooser
     * @return
     */
    public File giveSelectedFile() {
        return selectedFile;
    }

    /**
     * Gives the current file selected on the file chooser
     * @return the current game file
     */
    public File giveCurrentFile() {
        return currentFile;
    }
    
    /**
     * Reads the properties file and add the clues for the current puzzle
     * @param file
     */
    public void fillValuesList(Properties file) {
        
        int aux = 1;

        for (int i = 0;i < 5;i++) {

            String pColumn = "nonograma.pistasColumna" + String.valueOf(aux);
            String pRow = "nonograma.pistasFila" + String.valueOf(aux);
            String rRow = "nonograma.tableroFila" + String.valueOf(aux);

            columsClues[i] = file.getProperty(pColumn);
            rowsClues[i] = file.getProperty(pRow);
            answers[i] = file.getProperty(rRow);

            aux++;
        }
    }

    /**
     * Execurtes a new file choose in "\data" directory
     * Verifies if there is a selected file, this not, then send a message
     * Verifies if the slected file has ".properties" extension, if not, then send a message
     */
    public void selectFile() {

        JFileChooser fileChooser = new JFileChooser("data");
        int answer = fileChooser.showOpenDialog(main);
        String message;
        String title;
        String compare = "properties";       
        
        if(answer == JFileChooser.CANCEL_OPTION) {
            message = "Must select a file to Start the Game";
            title = "Start Game";
            JOptionPane.showMessageDialog(main, message, title, JOptionPane.WARNING_MESSAGE);
        }
        else if (answer == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getPath();
            String extension = "";
            int i = path.lastIndexOf(".");
            extension = path.substring(i+1);

            if (!extension.equals(compare)) {
                message = "Archive file is not a .properties file";
                title = "Error Loading Game";
                JOptionPane.showMessageDialog(main, message, title, JOptionPane.ERROR_MESSAGE);
                
                if (!main.thereSelectedFile()) {
                    selectedFile = null;
                }
            }
            else {
                currentFile = selectedFile;
                try {
                    fileProperties.load(new FileReader(selectedFile));
                    puzzleName = fileProperties.getProperty("nonograma.nombreProblema");
                    fillValuesList(fileProperties);
                    main.fillColumsClues(columsClues, tilesPanel.giveMatrix());
                    main.fillRowsClues(rowsClues, tilesPanel.giveMatrix());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                
                tilesPanel.enableTiles();
            }   
        }
    }

   /**
	 * Manage the events of the button
	 * If there is not a valid selected file, a message will be shown on screen
     * If ther in not a game in progress, a message will be shown on screen
	 * @param e Event associated to clickin the button, e != null
	 */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (LOAD.equals(e.getActionCommand())) {
            selectFile();
        }
        else if (RESET.equals(e.getActionCommand())) {
            if(selectedFile == null) {
                String message = "No game in progress";
                String title = "Reset Game";
                JOptionPane.showMessageDialog(main, message, title, JOptionPane.ERROR_MESSAGE);
            }
            else{
                tilesPanel.resetTiles();
            }
        }
    }
}
