package world;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import userInterface.MainInterface;

import java.awt.Image;

/**
 * This class represents Games Tiles
 */
public class Tiles {
    
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
    /**
     * Colums and rows info message
     */
    private String message;
    /**
     * title of windows
     */
    private String title;
    /**
     * Invokes CustomFonts Class
     */
    private static final CustomFonts customFonts = new CustomFonts();

    //--------------------------------------------------------------------------------------------------------------
    // Constructor
    //--------------------------------------------------------------------------------------------------------------
    
    /**
     * Constructor of the Tiles class
     * Creates new icon and transform it for a better fit in the gameboard tiles
     * @param pMain Main interface window
     */
    public Tiles(MainInterface pMain){

        main = pMain;
        icon = new ImageIcon("data/imagenes/casilla_rellena.png");
        tile = new ImageIcon(icon.getImage().getScaledInstance(56, 50, Image.SCALE_DEFAULT));
    }
    
    //--------------------------------------------------------------------------------------------------------------
    // Class Methods
    //--------------------------------------------------------------------------------------------------------------
    
   /**
    * Set the clues values for each row in the gameboard
    * @param rowClue List of the clues for the nonogram by rows
    * @param matrix Player buttons Array
    */
    public void fillRowsClues(String[] rowClue, JButton[][] matrix) {

        int aux = 0;
        int aux2 = 0;
        char addColum = '0';

        for (int i = 2;i < 7;i++) {
            for(int j = 0;j < 2;j++) {
                matrix [i][j].setFont(customFonts.alarmClock());
                if(j == 0) {
                    addColum = rowClue[aux].charAt(0);
                    matrix [i][j].setIcon(null);
                    aux++;
                    matrix [i][j].setText(String.valueOf(addColum));
                    if(matrix[i][j].getText().equals("0")) {
                        matrix[i][j].setText("");
                    }
                    else {
                        matrix [i][j].setText(String.valueOf(addColum));
                    }
                }
                else {
                    addColum = rowClue[aux2].charAt(2);
                    matrix [i][j].setIcon(null);
                    matrix [i][j].setText(String.valueOf(addColum));
                    if(matrix[i][j].getText().equals("0")) {
                        matrix[i][j].setText("");
                    }
                    else {
                        matrix [i][j].setText(String.valueOf(addColum));
                    }
                    aux2++;
                }
            }
        }
    }

    /**
    * Set the clues values for each column in the gameboard
    * @param rowClueList List of the clues for the nonogram by column
    * @param matrix Player buttons Array
    */
    public void fillColumsClues(String[] colClue, JButton[][] matrix) {

        int aux = 0;
        int aux2 = 0;
        char addRow = '0';

        for (int i = 0;i < 2;i++) {
            for(int j = 2;j < 7;j++) {
                matrix [i][j].setFont(customFonts.alarmClock());
                if(i == 0 ) {
                    addRow = colClue[aux].charAt(i);
                    matrix [i][j].setIcon(null);
                    matrix [i][j].setText(String.valueOf(addRow));
                    aux++;
                    if (matrix[i][j].getText().equals("0")) {
                        matrix[i][j].setText("");
                    }
                    else {
                        matrix [i][j].setText(String.valueOf(addRow));
                    }
                }
                else {
                    addRow = colClue[aux2].charAt(2);
                    matrix [i][j].setIcon(null);
                    matrix [i][j].setText(String.valueOf(addRow));
                    if (matrix[i][j].getText().equals("0")) {
                        matrix[i][j].setText("");
                    }
                    else {
                        matrix [i][j].setText(String.valueOf(addRow));
                    }
                    aux2++;
                }
            }
        }
    }

    /**
     * Calculates the number of correct tiles per column
     */

     
    public void getCorrectByColumn() {

        int[] column;
        String[][] answers = main.giveBoardAnswers();
        String[][] userMatrix =  main.givePlayerMatrix();
        String temp;
        String userTemp;

        column = new int[5];
        icon =  new ImageIcon("res/images/dialog.gif");
        message = "";
		
		for (int j = 0; j < 5; j++) {
            column[j] = 5;

			for( int i = 0; i < 5; i++) {
                temp = answers[i][j];
				userTemp = userMatrix [i][j];

				if (!temp.equals(userTemp)) {
					column[j] = column[j] - 1;
                }
                
			}
           message = message+"> Column "+(j+1)+" has "+column[j]+ " Tiles correct_\n";
		}
		title = "Correct Tiles by column";
  
		JOptionPane.showMessageDialog(main, message, title, JOptionPane.PLAIN_MESSAGE, icon);

	}

    /**
     * Calculates the number of correct tiles per row
     */
    public void getCorrectByRow() {
        
        int[] row;
        String[][] answers = main.giveBoardAnswers();
        String[][] userMatrix =  main.givePlayerMatrix();
        String temp;
        String userTemp;
        
        row = new int[5];
        icon =  new ImageIcon("res/images/dialog.gif");
        message="";

		for (int i = 0; i < 5; i++) {
            row[i] = 5;

			for( int j = 0; j < 5; j++) {
				temp = answers[i][j];
				userTemp = userMatrix [i][j];

				if ( !temp.equals(userTemp)) {
					row[i] = row[i] - 1;
				}
            }
            message = message+"> Row "+(i+1)+" has "+row[i]+ " Tiles correct_\n";
		}
		title = "Correct Tiles by row";

		JOptionPane.showMessageDialog(main, message, title, JOptionPane.INFORMATION_MESSAGE, icon);
		 
	}

}
