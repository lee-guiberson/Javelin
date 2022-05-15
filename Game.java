import java.util.HashMap;
import java.lang.Thread;
import java.awt.event.KeyEvent;
import java.awt.*;

public class Game {
   // All the objects in the game
   private HashMap<String, Object> objects;
   // Screen
   private Display display;
   // Input
   private Input input;
   // Whether game is running or not
   private boolean running;
   // Frame time
   private int frameTime = 8;
   // Size of the screen
   private int width = 850;
   private int height = 525;
   
   // Constructor
   public Game() {
      // initialize the object map
      objects = new HashMap<String, Object>();
      
      // Anonymous object letting user exit
      objects.put("exit", new Controllable() {
         // Get inputs
         public int[] getInputs() {
            return new int[]{KeyEvent.VK_E};
         }
         // Register input
         public void registerInput(KeyEvent e, KeyEventType t) {
            // If e is released, exit application            
            if(e.getKeyCode() == KeyEvent.VK_E && t.equals(KeyEventType.RELEASED)) System.exit(0);
         }
      });
      
      // Set running to true     
      running = true;
         
      // Initialize input
      input = new Input(objects);
      
      // Initialize display
      display = new Display(objects, input, width, height);
   }
   
   
   public void run() {
      // Game loop
      while(running) {
         // Update states
         updateStates();
         // Update Screen  
         display.updateScreen();
         // Wait between each frame
         try{ Thread.sleep(frameTime);}
         catch(InterruptedException e){}
      }
   }
   
   // Updates all the states
   private void updateStates() {
      // Update every Updateable object in objects
      for(Object o : objects.values())
            if(o instanceof Updateable)
               ((Updateable)o).update();
   }
   
   // Returns all of the objects
   public HashMap<String, Object> getObjects() {
      return objects;
   }
   
   // Returns the dimensions of the screen
   public int[] getDimensions() {
      return new int[]{width,height};
   }
   
   // Main function :)
   public static void main(String[] args) {
      // Entry point!!!
      Game g = new Game();
      g.run();
   } 
}