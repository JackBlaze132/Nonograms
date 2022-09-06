package userInterface;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import world.CustomColors;

/**
 * This Class represents the leftside panel
 */
public class LeftPanel extends JPanel {
	
	//--------------------------------------------------------------------------------------------------------------
    // Class Atributes
    //--------------------------------------------------------------------------------------------------------------
    
	/**
	 * Invokes CustomColors class
	 */
	private static final CustomColors customColor = new CustomColors();
	
	//--------------------------------------------------------------------------------------------------------------
    // Constructor
    //--------------------------------------------------------------------------------------------------------------
    
	/**
	 * Constructor of leftside panel
	 */
	public LeftPanel() {
		
		ImageIcon sideBanner = new ImageIcon("res/images/left.png");
		setSize(sideBanner.getIconHeight(), sideBanner.getIconWidth());
		
		JLabel image = new JLabel("");
		image.setIcon(sideBanner);
		add(image);
		
		setBackground(customColor.myDarkGray());
	}
}
