import java.awt.event.KeyEvent;
import java.util.HashMap;

// Interface for objects that will take key input
public interface Controllable  {
   // Function that will run any time a key in getInputs()
   // is typed. Contains logic for all the key presses 
   void registerInput(KeyEvent e, KeyEventType type);
   
   // Return the key codes that the Controllable object will use
   int[] getInputs();
}