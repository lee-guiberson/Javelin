package engine;

import java.util.HashMap;
import java.util.ArrayList;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * Class that handles all of the input
 */
class Input implements KeyListener {
   /** Hash map of keycodes to objects that they affect  */
   HashMap<Integer, ArrayList<Controllable>> keysToControllables;

   /**
    * Initializes input object
    * @param objects Hashmap of objects
    */
   public Input(HashMap<String, Object> objects) {
      // Get arraylist of Controllable objects
      ArrayList<Controllable> controllables = new ArrayList<Controllable>();
      for(Object o : objects.values())
         if(o instanceof Controllable)
            controllables.add((Controllable) o);
      
      // Associate all the keys with the controllable objects that they can correspond to
      keysToControllables = new HashMap<Integer, ArrayList<Controllable>>();
      
      // Iterate through everykeycode
      for(Controllable c : controllables) {
         for(int keyNum : c.getInputs()) {
            // Add respective Controllable to keycode index
            ArrayList<Controllable> controllablesAssociatedWithKey = 
               keysToControllables.computeIfAbsent(keyNum, k -> new ArrayList<Controllable>());
            controllablesAssociatedWithKey.add(c);
         }
      }   
   }
   
   /**
    * Registers the input
    * @param e KeyEvent object
    * @param t KeyEventType enum
    */
   private void register(KeyEvent e, KeyEventType t) {
      // Register input for each Controllable object that responds to keycode
      ArrayList<Controllable> controllables = keysToControllables.get(e.getKeyCode());
      if(controllables != null) for(Controllable c : controllables)
         c.registerInput(e, t);                           
   }    
   
   public void keyReleased(KeyEvent e) {
      register(e, KeyEventType.RELEASED);
   }
   
   public void keyPressed(KeyEvent e) {
      register(e, KeyEventType.PRESSED);
   }
   
   public void keyTyped(KeyEvent e) {
     register(e, KeyEventType.TYPED);
   }
}