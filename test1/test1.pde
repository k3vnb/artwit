void setup() {
   size(640, 360);
   stroke(0, 20, 255);
 }

void draw(){
  
 
 float x = random(width);
 float y = random(height);

 float angle = random(120);
 float len = random(2000);
 background(200, angle, 0);
 fill(255, 190, 0);
 ellipse(len, len, angle, angle);

  drawCircle(width/2, height/2, 16);
  drawDots();
  save("output.png");
  exit();
}
//void drawBranch(int len, int rand1, int angle, int rand2){
//   stroke(0, 20, 255);
//   line(rand1, 0, 0, len);
//   line(0, rand1, 0, -len);
//   line(0, angle, 0, len);
//   translate(0, -len);
//   rotate(angle);
//   if (len > 1){
//     len = len - 1;
//     rotate(angle);
//     drawBranch(len/2, rand1/2, angle, rand2/2);
//   }
//  }
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
  float fills = random(255);
  stroke(fills, 50, 20);
    for (int i = 30; i < r; i = i+5) {

    for (int j = 0; j < r1; j = j+5) {
              stroke(fills, 20, 55);
    point(i, j);
  }
 }
}
