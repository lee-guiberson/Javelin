package engine;

import java.util.HashMap;
import java.lang.Thread;

/**
 * Class representing whole app
 */
public class App {
   /** All the objects */
   private HashMap<String, Object> objects;

   /** Screen */
   private Display display;

   /** Input */
   private Input input;
   
   /** Whether app is currently running or not */
   private boolean running;

   /** Duration of frame in milliseconds */
   private int frameTime = 8;

   /** Width of screen */
   private int width;
   /** Height of screen */
   private int height;
   
   /** Title */
   private final String title;
   
   // Constructor
   public App(String title, int width, int height) {
      this.title = title;

      this.width = width;
      this.height = height;

      Sprite.setScreenDimensions(width, height);

      objects = new HashMap<String, Object>();
   }
   
   /**
    * Method representing main logic of app
    */
   public void start() {
         
      input = new Input(objects);
      
      display = new Display(objects, input, width, height, title);

      // App loop
      running = true;
      while(running) {
         // Update states
         updateStates();
         // Update Screen  
         display.updateScreen();
         // Wait between each frame
         try{ Thread.sleep(frameTime); }
         catch(InterruptedException e){ System.err.println(e); }
      }
   }
   
   /**
    * Update the state of all the Updateable objects
    */
   private void updateStates() {
      for(Object o : objects.values())
            if(o instanceof Updateable)
               ((Updateable)o).update();
   }
   
   /**
    * Returns a hashmap of all of the objects
    * @return Hashmap of all of the objects
    */
   public HashMap<String, Object> getObjects() {
      return objects;
   }
   
   /**
    * Returns object of given key
    * @param name Name of object
    * @return     Object corresponding to name. 
    *             Null if doesn't exist
    */
   public Object get(String name) {
      return objects.get(name);
   }

   /**
    * Adds an object to the app
    * @param name Name of object
    * @param o    Object
    */
   public void add(String name, Object o) {
      objects.put(name, o);
   }
}