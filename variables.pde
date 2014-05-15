
/*------------------------- colors */

color white            = color(255);
color black            = color(0);
color backgroundColor  = (color)white;
color foregroundColor  = (color)black;

color randomColor() {
  color c = color(random(255), random(255), random(255));
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
boolean animating = false;
float textWidth = windowWidth * .5;
float textHeight = windowHeight * .8;
float margen = 70.0;
