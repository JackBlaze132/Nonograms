package userInterface;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import world.CustomColors;

/**
 * This Class represents the rightside panel
 */
public class RightPanel extends JPanel {
	//--------------------------------------------------------------------------------------------------------------
    // Class Atributes
    //--------------------------------------------------------------------------------------------------------------
    
	/**
	 * Invokes CustomColors class
	 */
	private static final CustomColors customColors = new CustomColors();

	//--------------------------------------------------------------------------------------------------------------
    // Constructor
    //--------------------------------------------------------------------------------------------------------------
    
	/**
	 * Constructor of rightside panel
	 */
	public RightPanel()	{
		
		ImageIcon sideBanner = new ImageIcon(getClass().getClassLoader().getResource("images/right.gif"));
		setSize(sideBanner.getIconHeight(), sideBanner.getIconWidth());
		
		JLabel image = new JLabel("");
		image.setIcon(sideBanner);
		add(image);
		
		setBackground(customColors.myDarkGray());
		//image.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));
	}
}
