# Placeholder name
A lightweight java framework for simple games and animations for beginners 
## Basic Tutorial
This tutorial will teach the basics of the library and will create a ball that will
bounce around the screen and respond to user input. <br>
Create a new folder and place the directory *engine* into it. At the top, include:
```java
import engine.*;
```
Other potential useful imports are:
```java
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
```
To start, write:
```java
App a = new App("My first app", 400, 400);
```
The App class represents the entire application and will house the rest of the code.
It's constructor's signature is `App(String title, int width, int height)`
`title` will show up on the title bar of the window while `width`
and `height` represent the dimensions of the window in pixels.
To run the app, do:
```java
a.start();
```
Now, the java program should produce a blank screen.
### Adding Sprites
Any object that will be drawn on screen will use the Sprite abstract class. Let's look at this circle class:
```java
class Circle extends Sprite {
    public Circle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Draw(Graphics g)  {
        g.fillOval(x, y, width, height);
    }
}
```
Firstly, `extends Sprite` is used to indicate that Circle is a sprite. In the constructor, `super(x, y, width, height);` passes the coordinates and size to the Sprite class so that the fields can be used later on. Every sprite must also implement the `draw(Graphics g)`, which where the code to draw the sprite will be located. The `draw()` method is called every frame. Here, we draw a circle through `g.fillOval(x, y, width, height);` Notice how we can access `x`, `y`, `width`, and `height`. <br>
Now that we have create a circle class, we can a circle to the screen through adding:
```java
a.add("mycircle", new Circle(0, 0, 10, 10));
```
before we start the app. Now a circle should a appear on the screen.