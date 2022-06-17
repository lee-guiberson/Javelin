package engine;

import java.awt.event.KeyEvent;

/**
 * Interface for any object that responds to key presses
 */
public interface Controllable  {
   /**
    * Method that will run whenver a key is pressed
    * and is also returned from getInput()
    * @param e    keyevent triggered
    * @param type KeyEvent type
    */ 
   void registerInput(KeyEvent e, KeyEventType type);
   
  /**
   * Returns the key codes that will trigger registerInput() 
   * @return keycodes   
   */
   int[] getInputs();
}