package userInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import world.CustomColors;

import javax.swing.border.Border;

/**
 * This Class represents the options panel
 */
public class OptionsPanel extends JPanel implements ActionListener {
	
	//--------------------------------------------------------------------------------------------------------------
    // Class Atributes
    //--------------------------------------------------------------------------------------------------------------
    
	/**
	 * New atriibutte of MainInterface type
	 */
	private MainInterface main;

	/**
	 * button that throws number of corrent answers by row
	 */
	private JButton btnCorrectByRow;

	/**
	 * button that throws number of corrent answers by column
	 */
	private JButton btnCorrectByColum;

	/**
	 * button that throws Option 1 message
	 */
	private JButton btnOption1;

	/**
	 * button that throws Option 2 message
	 */
	private JButton btnOption2;
	
	/**
	 * Empty Label that work as a separator
	 */
	private JLabel sep;

	/**
	 * Pop-up window message
	 */
	private String message;
	
	/**
	 * Pop-up window title
	 */
	private String title;
	
	/**
	 * Command for option 1 button
	 */
	private static final String OPTION_1 = "OPTION_1";

	/**
	 * Command for option 2 button
	 */
	private static final String OPTION_2 = "OPTION_2";

	/**
	 * Command for correct by row button
	 */
	private static final String CORRECT_BY_ROW = "CORRECT_BY_ROW";

	/**
	 * Command for correct by column button
	 */
	private static final String CORRECT_BY_COLUMN = "CORRECT_BY_COLUMN";

	/**
	 * Invokes CustomColors class
	 */
	private static final CustomColors customColors = new CustomColors();

	/**
	 * Line border of myDarkColor Color
	 */
	private static final Border linBorder = BorderFactory.createLineBorder(customColors.myDarkGray());

	/**
	 * Titled border for the options section
	 */
	private TitledBorder titledBorder = BorderFactory.createTitledBorder(linBorder, "Options");
	
	
	//--------------------------------------------------------------------------------------------------------------
    // Constructor
    //--------------------------------------------------------------------------------------------------------------
    
	/**
	 * Constructor of the OptionsPanel class
	 * @param pMain Indicates it will show in the main nterface
	 */
	public OptionsPanel (MainInterface pMain) {
		main = pMain;
		setBorder(new TitledBorder(titledBorder));
		setBackground(customColors.myDarkGray());
		titledBorder.setTitleColor(customColors.pewter());
		//setLayout(new GridLayout(1, 4));
		setLayout(new GridBagLayout());
		GridBagConstraints correctRowsCon = new GridBagConstraints();
            correctRowsCon.gridwidth = 2;
            correctRowsCon.gridheight = 1;
            correctRowsCon.gridx = 0;
            correctRowsCon.gridy = 1;

        GridBagConstraints correctColmCon = new GridBagConstraints();
            correctColmCon.gridwidth = 2;
            correctColmCon.gridheight = 1;
            correctColmCon.gridx = 3;
            correctColmCon.gridy = 1;

        GridBagConstraints Option1Con = new GridBagConstraints();
            Option1Con.gridwidth = 2;
            Option1Con.gridheight = 1;
            Option1Con.gridx = 6;
            Option1Con.gridy = 1;

		GridBagConstraints Option2Con = new GridBagConstraints();
            Option2Con.gridwidth = 2;
            Option2Con.gridheight = 1;
            Option2Con.gridx = 9;
            Option2Con.gridy = 1;

		GridBagConstraints sep1Con = new GridBagConstraints();
            sep1Con.gridwidth = 1;
            sep1Con.gridheight = 1;
            sep1Con.gridx = 2;
            sep1Con.gridy = 1;

		GridBagConstraints sep2Con = new GridBagConstraints();
            sep2Con.gridwidth = 1;
            sep2Con.gridheight = 1;
            sep2Con.gridx = 5;
            sep2Con.gridy = 1;

		GridBagConstraints sep3Con = new GridBagConstraints();
            sep3Con.gridwidth = 1;
            sep3Con.gridheight = 1;
            sep3Con.gridx = 8;
            sep3Con.gridy = 1;

		
		
		btnCorrectByRow = new JButton("Correct by row");
		btnCorrectByRow.setActionCommand(CORRECT_BY_ROW);
		btnCorrectByRow.addActionListener(this);
		btnCorrectByRow.setPreferredSize(new Dimension(195,25));
		btnCorrectByRow.setFocusable(false);
		btnCorrectByRow.setBackground(customColors.darkButtons());
		btnCorrectByRow.setBorder(BorderFactory.createEmptyBorder());
		btnCorrectByRow.setForeground(Color.WHITE);
		add(btnCorrectByRow, correctRowsCon);

		sep = new JLabel();
        sep.setPreferredSize(new Dimension(10, 30));
    	add(sep, sep1Con);
		
		btnCorrectByColum = new JButton("Correct by colum");
		btnCorrectByColum.setActionCommand(CORRECT_BY_COLUMN);
		btnCorrectByColum.addActionListener(this);
		btnCorrectByColum.setPreferredSize(new Dimension(195,25));
		btnCorrectByColum.setFocusable(false);
		btnCorrectByColum.setBackground(customColors.darkButtons());
		btnCorrectByColum.setBorder(BorderFactory.createEmptyBorder());
		btnCorrectByColum.setForeground(Color.WHITE);
		add(btnCorrectByColum, correctColmCon);

		sep = new JLabel();
        sep.setPreferredSize(new Dimension(10, 30));
    	add(sep, sep2Con);
		
		btnOption1 = new JButton("Option 1");
		btnOption1.setActionCommand(OPTION_1);
		btnOption1.addActionListener(this);
		btnOption1.setPreferredSize(new Dimension(195,25));
		btnOption1.setFocusable(false);
		btnOption1.setBackground(customColors.darkButtons());
		btnOption1.setBorder(BorderFactory.createEmptyBorder());
		btnOption1.setForeground(Color.WHITE);
		add(btnOption1, Option1Con);

		sep = new JLabel();
        sep.setPreferredSize(new Dimension(10, 30));
    	add(sep, sep3Con);
		
		btnOption2 = new JButton("Option 2");
		btnOption2.setActionCommand(OPTION_2);
		btnOption2.addActionListener(this);
		btnOption2.setPreferredSize(new Dimension(195,25));
		btnOption2.setFocusable(false);
		btnOption2.setBackground(customColors.darkButtons());
		btnOption2.setBorder(BorderFactory.createEmptyBorder());
		btnOption2.setForeground(Color.WHITE);
		add(btnOption2, Option2Con);
	}

	//--------------------------------------------------------------------------------------------------------------
    // Class Methods
    //--------------------------------------------------------------------------------------------------------------
    
	/**
	 * Manage the events of the button
	 * If there is not a valid selected file, a message will be shown on screen
	 * @param e Event associated to clickin the button, e != null
	 */
	public void actionPerformed(ActionEvent e) {

		if( OPTION_1.equals( e.getActionCommand( )))
	    {
	        main.reqFuncOption1( );
		}  

	    else if( OPTION_2.equals( e.getActionCommand( )))
	    {
	        	main.reqFuncOption2( );
	    }

		else if(CORRECT_BY_COLUMN.equals( e.getActionCommand()))
		{
			if (!main.thereSelectedFile())
			{
				message = "No game in progress";
				title = "Error";
				JOptionPane.showMessageDialog(main, message, title, JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				main.getCorrectByColumn();
			}
		}
		
		else if(CORRECT_BY_ROW.equals(e.getActionCommand()))
		{
			if(!main.thereSelectedFile()){
				message = "No game in progress";
				title = "Error";
				JOptionPane.showMessageDialog(main, message, title, JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				main.getCorrectByRow();
			}
		}
	}
}
	
	
