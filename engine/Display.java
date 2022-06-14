package engine;

import javax.swing.JFrame;
import javax.swing.JPanel;    
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections; 


public class Display {
   // Full framed window 
   private JFrame f;
   // Inner window
   private InnerDisplay d;

   // Title of the window
   private final String TITLE = "PONG";
   
   // Drawables to draw to screeen
   private ArrayList<Drawable> drawables;
   
   // The width and height of the screen
   private int width;
   private int height;

   // Initializes window and then draws first frame
   public Display(HashMap<String, Object> objects, Input input, int width, int height) {
      // Assign width and height variables
      this.width = width;
      this.height = height;
   
      // Set up the JFrame
      f = new JFrame(TITLE);
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
   
   // Represents the inner window 
   private class InnerDisplay extends JPanel {  
      // Initialize by calling super and setting size of window
      public InnerDisplay(Dimension d) {
         super();
         setPreferredSize(d);
      }
      
      // Paints all the drawables
      @Override
      public void paintComponent(Graphics g) {
         // paint all of the drawables to screen
         super.paintComponent(g);
         for(Drawable d : drawables) {
            d.draw(g);
         }
      }
   }
   
   // Repaint the screen
   public void updateScreen() {
      d.repaint();
   }
}

