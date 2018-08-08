float angle = random(0, 6);
float randomX = random(-100, 870);
float randomY = random(-100, 1200);
float randomSize = random(420);
float randomVal = random(600);
float randomVal2 = random(120, 1200);

void setup() {
  size(900, 600);
}


void draw() {
  background(200, 100, 0);

  stroke(0, 20, 255);
  fill(255, 190, 0);
  ellipse(randomX, randomY, randomSize, randomSize);

  // Start the tree from the bottom of the screen
  translate(width/2,height);

  line(0,0,randomVal, -120);
  // Move to the end of that line
  translate(0,-120);
  // Start recursive branching
  branch(120);
  translate(-randomVal, randomVal2);
  branch2(randomVal2);

  drawDots();
  save("output.png");
  exit();
}

void branch(float h) {

  h *= 0.66;
  line(randomVal,0,0, -h);
  line(0,randomVal/12,0, h);
  line(0, randomVal/4, 0, h);

  if (h > 4) {
    pushMatrix();
    rotate(angle * .001);
    translate(0, -h);
    branch(h);

    popMatrix();
    pushMatrix();
    rotate(-angle * .008);
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
  // if statement serves as exit function for recursive function
  if (h > 14) {

    pushMatrix();    // Save the current state of transformation (i.e. where are we now)
    rotate(angle * .001);   // Rotate
    translate(h, -h); // Move to the end of the branch
    branch(h);
    popMatrix();     // restores prev matrix state

    // Repeat the same thing, only branch off to the "left" this time!
    pushMatrix();
    rotate(-angle);


    translate(0, -h);
    branch2(h * .9);
    popMatrix();
  }
}
void drawDots() {
    for (int i = -1450; i < 450; i = i+5) {
        float fills1 = random(-255, 255);
        float fills2 = random(-100, 200);
        stroke(fills1, 50, fills2);
    for (int j = -1450; j < 1450; j = j+5) {
              stroke(fills1, 20, fills2);
    point(i, j);
  }
 }
}
