# Javelin
A lightweight java framework for simple games and animations that's perfect for learning 
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

    public void Draw(Graphics g)  {
        g.fillOval(x, y, width, height);
    }
}
```
Firstly, `extends Sprite` is used to indicate that Circle is a sprite. In the constructor, `super(x, y, width, height);` passes the coordinates and size to the Sprite class so that the fields can be used later on. Every sprite must also implement the `draw(Graphics g)`, which where the code to draw the sprite will be located. The `draw()` method is called every frame. Here, we draw a circle through `g.fillOval(x, y, width, height);` Notice how we can access `x`, `y`, `width`, and `height`.

Now that we have create a circle class, we can a circle to the screen through adding:
```java
a.add("mycircle", new Circle(50, 100, 30, 30));
```
before we start the app. Now a circle should a appear on the screen.
### Updateable interface
Some sprites have states which change everyframe, which means that they should implement the `updateable` interface. For instance, to make our circle move, we would do this:
```java
class Circle extends Sprite implements Updateable {
    private int dx = 2;
    private int dy = 6;

    public Circle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void draw(Graphics g)  {
        g.fillOval(x, y, width, height);
    }

    public void update() {
        x += dx;
        y += dy;
        if(x < 0 || x + width > screenWidth) {
            dx *= -1;
        }
        if(y < 0 || y + height > screenHeight) {
            dy *= -1;
        }
    }
}
```
The `update()` method is called every frame and should update the state of the circle. Here we are updating the circle's position by `dx` and `dy` and also checking for collisions. If there is a collision, then we change `dx` or `dy`. We can also access the screen width and height with `screenWidth` and `screenHeight` from within any class that extends Sprite.
### Controllable interface
Any sprite that responds to input should implement the `Controllable` interface. If we implement the controllabe interface, we must define two methods: `getInputs()` and `registerInput()` Let's say we want the circle to stop when we hit the space bar. Then we would add `Controllabe` to the class signature and add the following two methods:
```java
public int[] getInputs() {
    return new int[]{KeyEvent.VK_SPACE};
}

public void registerInput(KeyEvent e, KeyEventType type) {
    if(e.getKeyCode() == KeyEvent.VK_SPACE && type.equals(KeyEventType.RELEASED)) {
        dx = 0;
        dy = 0;
    }
}
```
`getInputs()` returns an array of the keycodes that the sprite responds to while `registerInput()` is called whenever one of the keys corresponding to the keycodes returned from `getInputs()` is pressed, released or typed. Here, when space is released, we make the ball stop moving. The three type of keyevent are represented by `PRESSED`, `RELEASED`, and `TYPED`.

Congratulations! You finished the tutorial!

Here is the finished code:
```java
import engine.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        App a = new App("My first app", 400, 400);
        a.add("mycircle", new Circle(50,100,30,30));
        a.start();
    }
}

class Circle extends Sprite implements Updateable, Controllable {
    private int dx = 2;
    private int dy = 6;

    public Circle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
    }

    public void update() {
        x += dx;
        y += dy;
        if(x < 0 || x + width > screenWidth) {
            dx *= -1;
        }
        if(y < 0 || y + height > screenHeight) {
            dy *= -1;
        }
    }

    public int[] getInputs() {
        return new int[]{KeyEvent.VK_SPACE};
    }

    public void registerInput(KeyEvent e, KeyEventType type) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE && type.equals(KeyEventType.RELEASED)) {
            dx = 0;
            dy = 0;
        }
    }
}
```
