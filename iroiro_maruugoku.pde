PVector start;
PVector stop;
PVector p_xy = new PVector();
float x;
float y;
float step = 0.005;
float pct = 0.0;

void setup() {
 size(800,500);
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

void draw() {
 if(pct < 1.0) {
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
   step += 0.01;
   if(step <= 1) {
     step = 0.99;
   }
  }
  if(keyCode == DOWN) {
   step -= 0.01; 
   if(step <= 0) {
    step = 0.01; 
   }
  }
  if(keyCode != UP && keyCode != DOWN) {
   background(0); 
  }
 }
}

void reset() {
 start.x = stop.x;
 start.y = stop.y;
 stop.x = random(width);
 stop.y = random(height);
 x = start.x;
 y = start.y;
 pct = 0;
}
