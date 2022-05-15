package engine;

import java.awt.Graphics;

// Interface for any object that will be drawn to the screen
public interface Drawable {
   // Function that will draw the Drawable object onto the screen
   void draw(Graphics g);
   
   // Returns the precedence of the Drawable object
   // A higher precedence means that it will appear in front
   // if Drawable objects are overlapping
   int getPrecedence();
}