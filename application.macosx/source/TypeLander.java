import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import peasy.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class TypeLander extends PApplet {

/**
 *  
 *  TypeLander
 *  
 *  Tipeador para la Ciudad Abierta
 * 
 *                   @hspencer 2014
 */




PeasyCam cam;


public void setup() {
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

public void draw() {
  background(backgroundColor);
  fill(foregroundColor, foregroundAlpha);
  textFont(font[currentFont], 24);
  text(typedText+(frameCount/10 % 2 == 0 ? "_" : ""), -textWidth/2, -textHeight/2, textWidth/2, textHeight/2);

  if (keyPressed) { 
    if (key == ESC) {
      fading = true;
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

public void keyPressed() {
  if (key==27)
    key=0;
}

public void keyReleased() {
  if (key != CODED && key != '\u00b4' && !tilde) {
    switch(key) {
    case BACKSPACE:
      typedText = typedText.substring(0, max(0, typedText.length()-1));
      break;
    case TAB:
      typedText += "    ";
      break;
    case ENTER:
    case RETURN:
      // comment out the following two lines to disable line-breaks
      typedText += "\n";
      break;
    case ESC:
    case DELETE:
      break;
    default:
      typedText += key;
    }
  }
  else if (key == '\u00b4') {
    tilde = true;
  }
  else if (key != CODED && tilde) {
    switch(key) {
    case 'a':
      typedText += '\u00e1';
      tilde = false;
      break;
    case 'A':
      typedText += '\u00c1';
      tilde = false;
      break;
    case 'e':
      typedText += '\u00e9';
      tilde = false;
      break;
    case 'E':
      typedText += '\u00c9';
      tilde = false;
      break;
    case 'i':
      typedText += '\u00ed';
      tilde = false;
      break;
    case 'I':
      typedText += '\u00cd';
      tilde = false;
      break;
    case 'o':
      typedText += '\u00f3';
      tilde = false;
      break;
    case 'O':
      typedText += '\u00d3';
      tilde = false;
      break;
    case 'u':
      typedText += '\u00fa';
      tilde = false;
      break;
    case 'U':
      typedText += '\u00da';
      tilde = false;
      break;
    default:
      typedText += key;
      tilde = false;
    }
  }
  else if (key == CODED) {
    switch(keyCode) {
    case UP:
      currentFont = (currentFont + 1) % font.length;
      // println(currentFont);
      break;
    case DOWN:
      currentFont = (currentFont - 1) % font.length;
      if (currentFont == -1) {
        currentFont = font.length-1;
      }
      // println(currentFont);
      break;
    case LEFT:
      foregroundColor = (int)white;
      backgroundColor = (int)black;
      break;
    case RIGHT:
      foregroundColor = (int)black;
      backgroundColor = (int)white;
      break;
    }
  }
}


/*------------------------- colors */

int white            = color(255);
int black            = color(0);
int backgroundColor  = (int)white;
int foregroundColor  = (int)black;
int foregroundAlpha    = 255; 
public int randomColor() {
  int c = color(random(255), random(255), random(255));
  return c;
}

/*------------------- text & fonts */
PFont[] font = new PFont[5];
String typedText = "TypeLander";
boolean tilde = false;

/*-------------------- environment */
int windowWidth = 1024;
int windowHeight = 768;
int currentFont = 0;
boolean fading = false;
float textWidth = windowWidth * .5f;
float textHeight = windowHeight * .8f;
float margen = 70.0f;
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "TypeLander" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
