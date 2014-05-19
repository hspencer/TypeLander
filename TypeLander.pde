/**
 *  
 *  TypeLander
 *  
 *  Tipeador para la Ciudad Abierta
 * 
 *                   @hspencer 2014
 */


import peasy.*;

PeasyCam cam;
PrintWriter txt;

void setup() {
  size(windowWidth, windowHeight, P3D);
  cam = new PeasyCam(this, 700);
  cam.setMinimumDistance(0);
  cam.setMaximumDistance(2500);

  /* familias tipograficas*/
  font[0] = createFont("ChaparralPro-Regular", 32, true);
  font[1] = createFont("GillSans", 32, true);
  font[2] = createFont("Courier", 32, true);
  font[3] = createFont("HelveticaNeue", 32, true);
  font[4] = createFont("SerifaStd-Light", 32, true);

  cursor(CROSS);
  textMode(SHAPE);
  smooth();
}

void draw() {
  background(backgroundColor);
  fill(foregroundColor, foregroundAlpha);
  textFont(font[currentFont], 32);
  text(typedText+(frameCount/10 % 2 == 0 ? "_" : ""), -textWidth/2, -textHeight/2, textWidth/2, textHeight/2);

  if (keyPressed) { 
    if (key == ESC) {
      fading = true;
      txt.print("\n\n----\n\n");
      txt.print(typedText);
      key = ' ';
    }
  }

  if (fading) {
    foregroundAlpha -= 10;

    if (foregroundAlpha <= 5) {
      fading = false;
      foregroundAlpha = 255;
      typedText = "";
    }
  }

  stroke(0, 20);
  line(5, 5, -5, -5);
  line(5, -5, -5, 5);

  noStroke();
  fill(200, 240, 100, 30);
  rectMode(CORNERS);
  rect(-textWidth/2 - margen, -textHeight/2 - margen, textWidth/2 + margen, textHeight/2 + margen);
}

