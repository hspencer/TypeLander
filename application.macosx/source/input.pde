void keyPressed() {
  if (key==27)
    key=0;
}

void keyReleased() {
  if (key != CODED && key != '´' && !tilde) {
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
      typedText = "...";
      break;
    case DELETE:
      break;
    default:
      typedText += key;
    }
  }
  else if (key == '´') {
    tilde = true;
  }
  else if (key != CODED && tilde) {
    switch(key) {
    case 'a':
      typedText += 'á';
      tilde = false;
      break;
    case 'A':
      typedText += 'Á';
      tilde = false;
      break;
    case 'e':
      typedText += 'é';
      tilde = false;
      break;
    case 'E':
      typedText += 'É';
      tilde = false;
      break;
    case 'i':
      typedText += 'í';
      tilde = false;
      break;
    case 'I':
      typedText += 'Í';
      tilde = false;
      break;
    case 'o':
      typedText += 'ó';
      tilde = false;
      break;
    case 'O':
      typedText += 'Ó';
      tilde = false;
      break;
    case 'u':
      typedText += 'ú';
      tilde = false;
      break;
    case 'U':
      typedText += 'Ú';
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
      foregroundColor = (color)white;
      backgroundColor = (color)black;
      break;
    case RIGHT:
      foregroundColor = (color)black;
      backgroundColor = (color)white;
      break;
    }
  }
}

