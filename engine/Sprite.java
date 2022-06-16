package engine;

/**
 * Abstract class that represents generic object drawn to screen
 */
public abstract class Sprite implements Drawable {
   // Coordinates
   /** 
    * x coordinate of sprite
    * (coordinate is for upper left most point)
    */
   private int x;
   /** 
    * y coordinate of sprite 
    * (coordinate is for upper left most point)
    */
   private int y;
   
   /** Width of sprite */
   private int width;
   /** Height of sprite */
   private int height;
   
   // Maybe should be static?
   /** Width of the screen in pixels */
   private int screenWidth;
   /** Height of the screen in pixels */
   private int screenHeight;
   
   /** 
    * Integer for drawing order.
    * Sprites with higher precedence will be drawn onto the screen later
    */
   private int precedence;
   
   /** Game */
   private Game g;
      
   /**
    * Constructs sprites
    * @param x          x-coordinate
    * @param y          y-coordinate
    * @param width      width
    * @param height     height
    * @param precedence precedence(for drawing order)
    * @param g          game
    */
   public Sprite(int x, int y, int width, int height, int precedence, Game g) {
      this.x = x;
      this.y = y;
      
      this.width = width;
      this.height = height;
      
      // Set up screen size
      int[] dimensions = g.getDimensions();
      this.screenWidth = dimensions[0];
      this.screenHeight = dimensions[1];
      
      this.precedence = precedence;
      
      this.g = g;
   }
      
   // Coordinates

   public int getX() {
      return x;
   }

   public void setX(int x) {
      this.x = x;
   }

   /**
    * Increment x by dx
    * @param dx value to increment x by
    */
    public void incrementX(int dx) {
      x += dx;
   }
   
   public int getY() {
      return y;
   }
     
   public void setY(int y) {
      this.y = y;
   }
      
   /**
    * Increment y by dy
    * @param dy value to increment y by
    */
   public void incrementY(int dy) {
      y += dy;
   }
   
   /**
    * Gets both x and y coordinates
    * @return [x, y] 
    */
   public int[] getPoint() {
      return new int[]{x, y};
   }

   // Area
      
   public int getWidth() {
      return width;   
   }

   public void setWidth(int width) {
      this.width = width;
   }
   
   public int getHeight() {
      return height;
   }

   public void setHeight(int height)  {
      this.height = height;
   }
   
   // Misc

   public int getPrecedence() {
      return precedence;
   }
   
   public Game getGame() {
      return g;
   }

   // Screen

   public int getScreenWidth() {
      return screenWidth;
   }
   
   public int getScreenHeight() {
      return screenHeight;
   }
}