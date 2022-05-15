// Abstract class that represents something that will be drawn to the screen
public abstract class Sprite implements Drawable {
   // x coordinate of sprite
   private int x;
   // y coordinate of sprite
   private int y;
   
   // Width of sprite
   private int width;
   // Height of sprite
   private int height;
   
   // The width of the screen
   private int screenWidth;
   // The height of the screen
   private int screenHeight;
   
   // The precedence of the sprite for drawing order
   private int precedence;
   
   // Game
   private Game g;
      
   // Constructor
   public Sprite(int x, int y, int width, int height, int precedence, Game g) {
      // Set up coordinates
      this.x = x;
      this.y = y;
      
      // Set up area
      this.width = width;
      this.height = height;
      
      // Set up screen size
      int[] dimensions = g.getDimensions();
      this.screenWidth = dimensions[0];
      this.screenHeight = dimensions[1];
      
      // Set up precedence
      this.precedence = precedence;
      
      // Set up game
      this.g = g;
   }
   
   // Get x
   public int getX() {
      return x;
   }
   
   // Get y
   public int getY() {
      return y;
   }
   
   // Get coordinates
   public int[] getPoint() {
      return new int[]{x, y};
   }
   
   // Get center x
   public int getCenterX() {
      return x/2;
   }
   
   // Get center y
   public int getCenterY() {
      return y/2;
   }
   
   // Get center point
   public int[] getCenterPoint() {
      return new int[]{x/2, y/2};
   }
   
   // Get width
   public int getWidth() {
      return width;   
   }
   
   // Get height
   public int getHeight() {
      return height;
   }
   
   // Set x
   public void setX(int x) {
      this.x = x;
   }
   
   // Set y
   public void setY(int y) {
      this.y = y;
   }
   
   // Increment x
   public void incrementX(int dx) {
      x += dx;
   }
   
   // Increment y
   public void incrementY(int dy) {
      y += dy;
   }
   
   // Set width
   public void setWidth(int width) {
      this.width = width;
   }
   
   // Set height
   public void setHeight(int height)  {
      this.height = height;
   }
   
   // Get screen width
   public int getScreenWidth() {
      return screenWidth;
   }
   
   // Get screen height
   public int getScreenHeight() {
      return screenHeight;
   }
   
   // Get precedence
   public int getPrecedence() {
      return precedence;
   }
   
   // Get game
   public Game getGame() {
      return g;
   }
}