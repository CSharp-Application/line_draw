import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class iroiro_maruugoku extends PApplet {

PVector start;
PVector stop;
PVector p_xy = new PVector();
float x;
float y;
float step = 0.005f;
float pct = 0.0f;

public void setup() {
 
 background(0);
 stroke(255);
 strokeWeight(5);
 start = new PVector(random(width),random(height));
 stop = new PVector(random(width),random(height));
 p_xy.x = start.x;
 p_xy.y = start.y;
 x = start.x;
 y = start.y;
}

public void draw() {
 if(pct < 1.0f) {
  x = start.x + ((stop.x-start.x) * pct);
  y = start.y + ((stop.y-start.y) * pct);
  pct += step;
 }else{
   reset();
 }
 line(p_xy.x,p_xy.y,x,y);
 p_xy.x = x;
 p_xy.y = y;
 if(keyPressed) {
  if(keyCode == UP) {
   step += 0.01f;
   if(step <= 1) {
     step = 0.99f;
   }
  }
  if(keyCode == DOWN) {
   step -= 0.01f; 
   if(step <= 0) {
    step = 0.01f; 
   }
  }
  if(keyCode != UP && keyCode != DOWN) {
   background(0); 
  }
 }
}

public void reset() {
 start.x = stop.x;
 start.y = stop.y;
 stop.x = random(width);
 stop.y = random(height);
 x = start.x;
 y = start.y;
 pct = 0;
}
  public void settings() {  size(800,500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "iroiro_maruugoku" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
