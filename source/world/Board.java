package world;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import userInterface.MainInterface;

import java.awt.Image;

import java.io.File;
import java.util.Arrays;

/**
 * This class represents GameBoard
 */
public class Board {

    //--------------------------------------------------------------------------------------------------------------
    // Class Atributes
    //--------------------------------------------------------------------------------------------------------------
    
    /**
     * Image for buttons
     */
    ImageIcon icon;

    /**
     * transformation atribute for icon
     */
    ImageIcon tile;

    /**
     * Main windows of the application
     */
    private MainInterface main;

    //--------------------------------------------------------------------------------------------------------------
    // Constructor
    //--------------------------------------------------------------------------------------------------------------
    
     /**
     * Creates new icon and transform it for a better fit in the gameboard tiles
     * Constructor of the main class
     * @param pMain Main interface window
     */
    public Board(MainInterface pMain) {
        
        main = pMain;
        icon = new ImageIcon("data/imagenes/casilla_rellena.png");
        tile = new ImageIcon(icon.getImage().getScaledInstance(56, 50, Image.SCALE_DEFAULT));
    }

    //--------------------------------------------------------------------------------------------------------------
    // Class Methods
    //--------------------------------------------------------------------------------------------------------------
    
    /**
     * Verefies if there is a valid file loaded in the program
     * @param selectedFile valid selected file
     * @param currentGame game in progress
     * @return Boolean answer to chechk if there is or not a valid selected fie
     */
    public boolean thereSelectedFile(File selectedFile, File currentGame) {
        
        boolean restore = false;

        if (selectedFile != null && currentGame != null){
            restore = true;
        }
        else{
            restore = false;
        }
        return restore;
    }

    /**
     * Creates an Array that is going to be compared wth the Answers Array
     * The created Array is gave in terms of "0" and "1"
     * @param matrix current player Array
     * @return the array of the player in terms of "0" and "1"
     */
    public String[][] createCompareArrays(JButton[][] matrix) {
        
        String[][] restore =  new String[5][5];

        for (int i = 2;i < 7; i++){
            for (int j = 2;j < 7;j++){
                if (matrix[i][j].getIcon() == null){
                    restore[i-2][j-2] = "0";
                }
                else{
                    restore[i-2][j-2] = "1";
                }
            }
        }

        return restore;
    }

    /**
     * Create an Array that contains the nonogram puzzle's anwers
     * "1" are the tiles that might the filled and "0" the tiles that not.
     * exg : ["10101", "00110"."10010","011001", "10110"]
     * @param answers List of 5 (0-4) positions with the answers
     * @return A Arrays of [5]x[5] that contaisn puzzle answers
     */
    public String[][] giveAnswerList(String[] answers) {
       
        String[][] restore = new String[5][5];
        
        for (int i = 0;i < 5; i++){
            for (int j = 0;j < 5; j++){
                char temp = answers[i].charAt(j);
                restore[i][j] = String.valueOf(temp);
            }       
        }

        return restore;
    }

    /**
     * Compares the answers Array with the player's Array
     * Throughts a  message when th eplayer conppleates the puzzle
     * @param answers Answers Array in terms of "0" and "1"
     * @param compare Player Array in terms of "0" and "1"
     */
    public void compareArrays(String[][] answers, String[][] compare) {
        
        String message = "CONGRATULATIONS!, you solved the puzzle:\n" + main.givePuzzleName();

        if (Arrays.deepEquals(answers, compare)){
            JOptionPane.showMessageDialog(main, message, "Congralutations", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Method for extension 1
     * @return Answer 1 message
     */
    public String method1() {
        return "NONOGRAMS\n\n" +
                ">Developed by:\n" +
                " Eder Martínez_\n\n" +
                ">Version 2.1.0";
    }

    /**
     * Method for extension 2
     * @return Answer 2 message
     */
    public void method2() {

        System.exit(0);
    }



}
