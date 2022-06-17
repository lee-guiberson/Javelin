# Placeholder name
A lightweight java framework for simple games and animations for beginners 
## Basic Tutorial
Create a new folder and place the directory *engine* into it. At the top, include:
```
import engine.*;
```
Other potential imports include:
```
import java.awt.Graphics;
import java.awt.Color;
imoprt java.awt.event.KeyEvent;
```
To start, write:
```
App a = new App("My first app", 400, 400);
```
The App class represents the entire application and will house the rest of the code.
It's constructor's signature is `App(String title, int width, int height)`
`title` is a String that will show up on the title bar of the window while `width`
and `height` are int's that represent the dimensions of the window in pixels.
To run the app, do:
```
a.start()
```
Now, the java program should produce a blank screen.