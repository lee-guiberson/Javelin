package engine;

import java.util.HashMap;
import java.util.ArrayList;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

// Class that handles all of the input
public class Input implements KeyListener {
   // Hashmap of all of the keycodes to the lists of Controllable objects that need the key with the respective key code
   HashMap<Integer, ArrayList<Controllable>> keysToControllables;
      
   public Input(HashMap<String, Object> objects) {
      // Put all of the Controllable objects in hashmap of objects into list
      ArrayList<Controllable> controllables = new ArrayList<Controllable>();
      
      for(Object o : objects.values())
         if(o instanceof Controllable)
            controllables.add((Controllable) o);
      
      // Associate all the keys with the controllable objects that they can correspond to
      keysToControllables = new HashMap<Integer, ArrayList<Controllable>>();
      
      // Iterate through the array list of controllables
      for(Controllable c : controllables) {
         // Iterate throug the keycodes corresponding to the Controllable object
         for(int keyNum : c.getInputs()) {
            // Get array list of Controllables associated with key or create one if none
            ArrayList<Controllable> controllablesAssociatedWithKey = keysToControllables.computeIfAbsent(keyNum, k -> new ArrayList<Controllable>());
            // Add the current controllable to the list corresponding to the key
            controllablesAssociatedWithKey.add(c);
         }
      }   
   }
   
   // 
   private void register(KeyEvent e, KeyEventType t) {
      // Get the list of Controllables corresponding to a key code
      ArrayList<Controllable> controllables = keysToControllables.get(e.getKeyCode());
      // If it exist, iterate through it and send input to each Controllable
      if(controllables != null) for(Controllable c : controllables)
         c.registerInput(e, t);                           
   }    
   
   // Runs if key is released
   public void keyReleased(KeyEvent e) {
      register(e, KeyEventType.RELEASED);
   }
   
   // Runs if key is pressed
   public void keyPressed(KeyEvent e) {
      register(e, KeyEventType.PRESSED);
   }
   
   // Runs if key is typed
   public void keyTyped(KeyEvent e) {
     register(e, KeyEventType.TYPED);
   }
}