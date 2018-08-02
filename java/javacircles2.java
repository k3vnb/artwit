void setup() {
   size(640, 360);
   stroke(0, 20, 255);
 }

void draw(){
 background(200, 100, 0);
 float x = random(width);
 float y = random(height);

 float angle = random(100);
 float len = random(2000);
 fill(255, 190, 0);
 ellipse(x, y, angle, angle);

  drawCircle(width/2, height/2, 6);
  drawDots();
  save("output.png");
  exit();
}

void drawCircle(int x, int radius, int level) {

  float filler = random(255);
  float filler2 = random(132);
  float filler3 = random(200);
  fill(filler3, filler2, filler);
  ellipse(x, height/2, radius*2, radius*2);
  if(level > 1) {
    level = level - 1;
    drawCircle(x - radius/9, radius/9, level);
    drawCircle(x + radius/3, radius/3, level);
  }

}
void drawDots(){

  float r = random(8000);
  float r1 = random(10000);
    for (int i = 3; i < r; i = i+5) {
        float fills = random(255);
        stroke(fills, 50, 20);
    for (int j = 0; j < r1; j = j+5) {
              stroke(fills, 20, 55);
    point(i, j);
  }
 }
}
