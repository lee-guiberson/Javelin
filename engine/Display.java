package engine;

import javax.swing.JFrame;
import javax.swing.JPanel;    
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections; 

/**
 * Class to handle display
 */
class Display {
   /** Full framed window (with title bar) */
   private JFrame f;
   /** Screen (without title bar) */
   private InnerDisplay d;

   /** Title that will be displayed on title bar */
   private final String title;
   
   /** All the Drawable objects */
   private ArrayList<Drawable> drawables;
   
   /** Screen width */
   private int width;
   /** Screen height */
   private int height;

   /**
    * Constructor for display
    * @param objects A hashmap of objects
    * @param input   Input object
    * @param width   Screen width
    * @param height  Screen height
    * @param title   Title
    */
   public Display(HashMap<String, Object> objects, Input input, int width, int height, String title) {
      // Assign width and height variables
      this.width = width;
      this.height = height;
   
      // Set up the JFrame
      this.title = title;
      f = new JFrame(this.title);
      f.addKeyListener(input);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
      d = new InnerDisplay(new Dimension(this.width,this.height));
      f.add(d);
      f.pack();
      
      // Initialize drawables arraylist with all Drawables in hashmap of objects
      drawables = new ArrayList<Drawable>();
      for(Object o : objects.values()) {
         if(o instanceof Drawable) {
            drawables.add((Drawable) o);
         }
      }
      
      // Sort the drawables by the precedence
      // Higher precedence means Drawable object will be drawn on screen after those with lower precedence
      Collections.sort(
         drawables, 
         (Drawable d1, Drawable d2) -> Integer.valueOf(d1.getPrecedence()).compareTo(d2.getPrecedence())
      );
      
      // Make the window visible
      f.setVisible(true);
   }
   
   /**
    * Screen (without title bar)
    */
   private class InnerDisplay extends JPanel {  
      // Initialize by calling super and setting size of window
      public InnerDisplay(Dimension d) {
         super();
         setPreferredSize(d);
      }
      
      /**
       * Draws all the Drawable objects to screen
       * @param g Graphics object
       */
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         for(Drawable d : drawables) {
            d.draw(g);
         }
      }
   }
   
   /** Repaint the screen */
   public void updateScreen() {
      d.repaint();
   }
}

