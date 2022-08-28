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
                    aux2++;
                }
            }
        }
    }

    /**
     * Calculates the number of correct tiles per column
     */
    public void getCorrectByColumn() {

        int column1 = 5;
		int column2 = 5;
		int column3 = 5;
		int column4 = 5;
		int column5 = 5;

        icon =  new ImageIcon("data/imagenes/dialog alt 1.gif");
		String[][] answers = main.giveBoardAnswers();
		String[][] userMatrix =  main.givePlayerMatrix();
		String temp;
		String userTemp;

		for (int i = 0; i < 5; i++) {
			for( int j = 0; j < 5; j++) {
				temp = answers[i][j];
				userTemp = userMatrix [i][j];

				if ( j == 0 && !temp.equals(userTemp)) {
					column1 = column1 - 1;
				}
				if ( j == 1 && !temp.equals(userTemp)) {
					column2 = column2 - 1;
				}
				if ( j == 2 && !temp.equals(userTemp)) {
					column3 = column3 - 1;
				}
				if ( j == 3 && !temp.equals(userTemp)) {
					column4 = column4 - 1;
				}
				if ( j == 4 && !temp.equals(userTemp)) {
					column5 = column5 - 1;
				}
			}
		}
		message = "> Column 1 has "+column1+" Tiles correct_ \n" +
				  "> Column 2 has "+column2+" Tiles correct_ \n" +
				  "> Column 3 has "+column3+" Tiles correct_ \n" +
				  "> Column 4 has "+column4+" Tiles correct_ \n" +
				  "> Column 5 has "+column5+" Tiles correct_ \n";
		
		title = "Correct Tiles by column";
		
  
		JOptionPane.showMessageDialog(main, message, title, JOptionPane.PLAIN_MESSAGE, icon);

	}

    /**
     * Calculates the number of correct tiles per row
     */
    public void getCorrectByRow() {
        
        int row1 = 5;
		int row2 = 5;
		int row3 = 5;
		int row4 = 5;
		int row5 = 5;
        
        icon =  new ImageIcon("data/imagenes/dialog alt 1.gif");
		String[][] answers = main.giveBoardAnswers();
		String[][] userMatrix =  main.givePlayerMatrix();
		String temp;
		String userTemp;

		for (int i = 0; i < 5; i++) {
			for( int j = 0; j < 5; j++) {
				temp = answers[i][j];
				userTemp = userMatrix [i][j];

				if ( i == 0 && !temp.equals(userTemp)) {
					row1 = row1 - 1;
				}
				if ( i == 1 && !temp.equals(userTemp)) {
					row2 = row2 - 1;
				}
				if ( i == 2 && !temp.equals(userTemp)) {
					row3 = row3 - 1;
				}
				if ( i == 3 && !temp.equals(userTemp)) {
					row4 = row4 - 1;
				}
				if ( i == 4 && !temp.equals(userTemp)) {
					row5 = row5 - 1;
				}
			}
		}
		message = ">Row 1 has "+row1+" Tiles correct_ \n" +
				  ">Row 2 has "+row2+" Tiles correct_ \n" +
				  ">Row 3 has "+row3+" Tiles correct_ \n" +
				  ">Row 4 has "+row4+" Tiles correct_ \n" +
				  ">Row 5 has "+row5+" Tiles correct_ \n";
		title = "Correct Tiles by row";

		JOptionPane.showMessageDialog(main, message, title, JOptionPane.INFORMATION_MESSAGE, icon);
		
	}

}
