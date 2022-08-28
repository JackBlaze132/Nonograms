package uniandes.cupi2.nonogramas.interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.cupi2.nonogramas.mundo.CustomColors;

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
		
		ImageIcon sideBanner = new ImageIcon("data/imagenes/derecha alt 2.gif");
		setSize(sideBanner.getIconHeight(), sideBanner.getIconWidth());
		
		JLabel image = new JLabel("");
		image.setIcon(sideBanner);
		add(image);
		
		setBackground(customColors.myDarkGray());
		//image.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));
	}
}
