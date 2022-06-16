package engine;

import java.awt.Graphics;

/**
 * Interface for any object that will be drawn to the screen  
 */ 
public interface Drawable {
   /**
    * Method that draws the Drawable object onto the screen
    * @param g
    */
   void draw(Graphics g);
   
   /**
    * Method that returns precedence
    * Drawable objects with higher precedence
    * will be drawn on screen last.
    * @return precedence
    */
   int getPrecedence();
}