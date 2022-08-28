package world;

/**
 * Importation of required libraries
 */
import java.awt.Font;
import java.awt.FontFormatException;

import java.io.IOException;
import java.io.InputStream;

/**
 * This class represents Custom Fonts
 * Here you can import any custom font file just by creating a new method that calls your font
 */
public class CustomFonts {
    
    //--------------------------------------------------------------------------------------------------------------
    // Class Atributes
    //--------------------------------------------------------------------------------------------------------------
    
    /**
     * Font "FontAwesome"
     */
    private Font fontAwesome;

    /**
     * Font "Pixellari"
     */
    private Font pixellari;

    /**
     * Font "AlarmClock"
     */
    private Font alarmClock;

    /**
     * Font "Consolas"
     */
    private Font consolas;

    //--------------------------------------------------------------------------------------------------------------
    // Class Methods
    //--------------------------------------------------------------------------------------------------------------
    
    /**
     * Resturns a custom usable font by the name of "fontAwesome"
     * custom font folder might be loaded in java project
     * font file might be a "ttf" or "otf" file
     * @return fontAwesome Font
     */
    public Font fontAwesome() {
        
        try {
            InputStream is = getClass().getResourceAsStream("/fonts/FontAwesomeSolid.otf");
            this.fontAwesome = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(16f).deriveFont(Font.BOLD);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        return this.fontAwesome; 
    }


    /**
     * Resturns a custom usable font by the name of "pixellari"
     * custom font folder might be loaded in the java project
     * font file might be a "ttf" or "otf" file
     * @return pixellari Font
     */
    public Font pixellari() {
        
        try {
            InputStream is = getClass().getResourceAsStream("/fonts/Pixellari.ttf");
            this.pixellari = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(16F);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        return this.pixellari; 
    }


    /**
     * Resturns a custom usable font by the name of "alarmClock"
     * custom font folder might be loaded in java project
     * font file might be a "ttf" or "otf" file
     * @return alarmClock Font
     */
    public Font alarmClock() {
        
        try {
            InputStream is = getClass().getResourceAsStream("/fonts/alarmClock.ttf");
            this.alarmClock = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(20F).deriveFont(Font.BOLD);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        return this.alarmClock; 
    }


    /**
     * Resturns a custom usable font by the name of "consolas"
     * custom font folder might be loaded in java project
     * font file might be a "ttf" or "otf" file
     * @return consolas Font
     */
    public Font consolas() {
        
        try {
            InputStream is = getClass().getResourceAsStream("/fonts/consolas.ttf");
            this.consolas = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(16F);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        return this.consolas; 
    }
}

