package engine;

/**
 * Interface for any object that needs updateable state
 */
public interface Updateable {
   /** 
    * Method that will run each frame that should update state 
    */
   void update();
}