float angle = random(0, 6);
float randomX = random(-100, 870);
float randomY = random(-100, 1200);
float randomSize = random(420);
float randomVal = random(350);
float randomVal2 = random(120, 1200);
float rand255 = random(255);
float rand200 = random(185, 255);
float rand100 = random(80, 155);

void setup() {
  size(1400, 600);
}


void draw() {
  background(200, 100, 0);

  stroke(0, 20, 255, rand255);
  fill(255, 190, 0);
  ellipse(randomX, randomY, randomSize, randomSize);

  if (angle < 3){
    drawCircle(randomVal, height/angle, 6);
  } else if (angle == 3){
    drawCircle2(randomVal, height/angle, 6);
  };
  // Let's pick an angle 0 to 90 degrees based on the mouse position
  // Start the tree from the bottom of the screen
  translate(width/3,height/3);
  // Draw a line 120 pixels
  line(0,0,randomVal, -120);
  // Move to the end of that line
  translate(0,-120);
  // Start the recursive branching!
  branch(120);
  translate(-randomVal, randomVal2);
  branch2(randomVal2);

  drawDots();
   save("output.png");
  exit();
}

void branch(float h) {
  // Each branch will be 2/3rds the size of the previous one
  h *= 0.66;
  line(randomVal,0,0, -h);
  line(0,randomVal/12,0, h);
  line(0, randomVal/4, 0, h);


  // All recursive functions must have an exit condition!!!!
  // Here, ours is when the length of the branch is 2 pixels or less
  if (h > 4) {
    pushMatrix();    // Save the current state of transformation (i.e. where are we now)
    rotate(angle * .001);   // Rotate by theta
    translate(0, -h); // Move to the end of the branch
    branch(h);       // Ok, now call myself to draw two new branches!!

    popMatrix();     // Whenever we get back here, we "pop" in order to restore the previous matrix state

    // Repeat the same thing, only branch off to the "left" this time!
    pushMatrix();
    rotate(-angle * .0009);
    translate(0, -h);
    branch(h);
    branch2(h);
    popMatrix();
  }
}
void branch2(float h) {
  angle = random(5);

  // Each branch will be 2/3rds the size of the previous one
  h *= 0.66;
    line(-20, h + 1, 10, -h);
    line(h, 20, 20, h);
    line(0, angle, 0, h);
  // All recursive functions must have an exit condition!!!!
  // Here, ours is when the length of the branch is 2 pixels or less
  if (h > 14) {

    pushMatrix();    // Save the current state of transformation (i.e. where are we now)
    rotate(angle * .001);   // Rotate by theta
    translate(h, -h); // Move to the end of the branch
    branch(h);       // Ok, now call myself to draw two new branches!!
    popMatrix();     // Whenever we get back here, we "pop" in order to restore the previous matrix state

    // Repeat the same thing, only branch off to the "left" this time!
    pushMatrix();
    rotate(-angle);


    translate(0, -h);
    branch2(h * .9);
    popMatrix();
  }
}
void drawCircle(float x, float radius, int level) {

  float filler = random(255);
  float filler2 = random(132);
  float filler3 = random(200);
  float randCirc = random(4);

  fill(filler3, filler2, filler, filler);
  ellipse(x, height/2, radius*1.9, radius*1.9);
  if(level > 1 && level < 800) {
    level = level - 1;
    drawCircle(x - radius/9, radius/9, level);
    drawCircle(x + radius*9, radius*randCirc, level);
  }

}
  void drawCircle2(float x, float radius, int level) {

  float filler = random(255);
  float filler2 = random(132);
  float filler3 = random(200);
  float randCirc = random(4);

  fill(filler3, filler2, filler, filler);
  ellipse(x, height/2, radius*1.9, radius*1.9);
  if(level > 1 && level < 800) {
    level = level - 1;
    drawCircle(x - radius/9, radius/9, level);
    drawCircle(x + radius*9, radius*randCirc, level);
  }
}
void drawDots() {
    for (int i = -1450; i < 1450; i = i+5) {
        float fills1 = random(225, 255);
        float fills2 = random(0, 250);
        stroke(fills1, 0, fills2);
    for (int j = -1450; j < 1450; j = j+5) {
              stroke(fills1, 0, fills2);
    point(i, j);
  }
 }
}
