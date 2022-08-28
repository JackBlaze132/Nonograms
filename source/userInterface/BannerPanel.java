package userInterface;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import world.CustomColors;

/**
 * This Class represents the banner panel
 */
public class BannerPanel extends JPanel {
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
	 * Constructor of banner panel
	 */
	public BannerPanel() {

		ImageIcon banner = new ImageIcon("data/imagenes/titulo.gif");
		setSize(banner.getIconHeight(), banner.getIconWidth());
		
		JLabel image = new JLabel("");
		image.setIcon(banner);
		add(image);
		
		setBackground(customColors.myDarkGray());
	}
}
