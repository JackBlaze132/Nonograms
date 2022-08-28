package uniandes.cupi2.nonogramas.interfaz;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

import java.util.ArrayList;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import uniandes.cupi2.nonogramas.mundo.CustomColors;

/**
 * This class represents the main gameboard
 */
public class TilesPanel extends JPanel implements ActionListener{

    /**
     * New atriibutte of MainInterface type
     */
    private MainInterface main;

    /**
     * Number of current tiles created
     */
    private int numButtons;

    private static final long serialVersionUID = 1L;
    private static final int numRows = 7;
    private static final int numColums = 7;
    private static final String filledImageRoute = "data/imagenes/casilla_rellena.png";
    
    
    

    private JButton matrix[][];

    private ArrayList<JButton> buttonList;

    
    
    private CustomColors customColors = new CustomColors();

    private Border linBorder = BorderFactory.createLineBorder(customColors.myDarkGray());
	private TitledBorder titledBorder = BorderFactory.createTitledBorder(linBorder, "Game Board");

    ImageIcon icon = new ImageIcon(filledImageRoute);
    ImageIcon tile = new ImageIcon(icon.getImage().getScaledInstance(56, 50, Image.SCALE_DEFAULT));

    //--------------------------------------------------------------------------------------------------------------
    // Constructor
    //--------------------------------------------------------------------------------------------------------------
    
    /**
     * Constructor of the TilesPanel class
     * @param pMain
     */
    public TilesPanel(MainInterface pMain) {
        
        main = pMain;
        numButtons = 0;
        matrix = new JButton[numRows][numColums];
        buttonList = new ArrayList<>();
        setLayout(new GridLayout(7,7));
        setBorder(new TitledBorder(titledBorder));
        titledBorder.setTitleColor(customColors.pewter());
        

        for (int i = 0; i < numRows;i ++)
        {
            for (int j = 0; j < numColums; j++)
            {
                JButton button = new JButton();
                button.setActionCommand(String.valueOf(numButtons));
                button.addActionListener(this);
                button.setIcon(null);
                button.setBackground(customColors.burntOrange());
                button.setEnabled(false);
                button.setBorder(BorderFactory.createEmptyBorder());
                matrix[i][j] = button;
                buttonList.add(button);
                add(button);

                if (i%2 == 1 && j%2 == 1)
                {
                    button.setBackground(customColors.burntTangarine());
                }
                else if (i%2 == 0 && j%2 == 0)
                {
                    button.setBackground(customColors.burntTangarine());
                }
                numButtons++;
            }
        }
    } 
    
    //--------------------------------------------------------------------------------------------------------------
    // Class Methods
    //--------------------------------------------------------------------------------------------------------------
    
    /**
     * Gives the buttons Array that compose the gameboard
     * @return the buttons Array
     */
    public JButton[][] giveMatrix() {
		return matrix;
	}
    
    /**
     * Enable the buttons so the player can start the game
     * The playable area is composed by a Array of 5x5
     */
    public void enableTiles() {

        for (int i = 2; i < 7; i++)
        {
            for (int j = 2;j < 7; j++)
            {
                matrix[i][j].setEnabled(true);
                setBlankTile(matrix[i][j]);
                matrix[i][j].setBackground(customColors.orange());
                if (i%2 == 1 && j%2 == 1)
                {
                    matrix[i][j].setBackground(customColors.tangarine());
                }
                else if (i%2 == 0 && j%2 == 0){
                    matrix[i][j].setBackground(customColors.tangarine());
                }
            }
        }
    }

    /**
     * Refresh the gameboard in order to star a new clean game
     */
    public void resetTiles() {

        for (int i = 2; i < 7; i++){
            for (int j = 2; j < 7; j++){
                JButton button = matrix[i][j];
                button.setBackground(customColors.orange());
                button.setIcon(null);
                button.setEnabled(true);
                if (i%2 == 1 && j%2 == 1){
                    button.setBackground(customColors.tangarine());
                }
                else if (i%2 == 0 && j%2 == 0){
                    button.setBackground(customColors.tangarine());

                }
            }
        }
    }

    /**
     * Configure the blank tiles icons
     * It is null in order to show a clean tile
     * @param button The current clicked tile icon
     */
    public void setBlankTile(JButton button) {
        button.setIcon(null);
        
    }

    /**
     * Configure the filled tiles icons
     * It shows a darker tile after is clciked
     * @param button The current clicked tile icon
     */
    public void setFilledTile(JButton button){
        button.setIcon(tile);
    }

    /**
     * Changes the tiles icons
     * If it is filled, then turn it to blank after click
     * If it is blank, the turn it into a filled one after clicking
     * @param button
     */
    public void changeTileIcon(JButton button){
       
        if (button.getIcon() == null)
       {
            setFilledTile(button);
       }
       
       else if(button.getIcon() == tile)
       {
            setBlankTile(button);
       }
    }

    /**
     * Manage the Tiles event
     * @param e Event associated withj clicking a tile
     */
    @Override
    public void actionPerformed(ActionEvent e){
        
        boolean finishedBoxes = false;

        for (int i = 0; i < buttonList.size() && !finishedBoxes; i++)
        {
            if (String.valueOf(i).equals(e.getActionCommand()))
            {
                changeTileIcon(buttonList.get(i));
                main.compareArrays();
                finishedBoxes = true;
            }
        }
    }
}
