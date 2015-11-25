/* 
 * Name: Songhao Zhou 
 * Login: cs11wJC
 * Date: 1/15/2014
 * File: CS11Turtle_Threaded.java 
 * drawing the CS11WJC, WINTER AND 2014
 */ 

import turtleClasses.*; 
import java.awt.*;



/* 
 * Name: cs11Turtle
 * Purpose: define the private variables
 */

public class CS11Turtle_Threaded extends Turtle implements Runnable 
{ 
  private final static int CHAR_HALF_WIDTH = 20; 
  private final static int CHAR_WIDTH = 40; 
  private final static int LINE_HEIGHT = 80; 
  private final static int CHAR_PADDING = 40; 
  private final static int LINE_PADDING = 40; 
  private final static int LINE_SPACE = LINE_HEIGHT + LINE_PADDING; 
  private final static int CHAR_SPACE = CHAR_WIDTH + CHAR_PADDING; 
 
  private final static int START_X_1 = 40; //starting x offset for line 1 
  private final static int START_X_2 = 80; //starting x offset for line 2 
  private final static int START_X_3 = 160; //starting x offset for line 3 
  
  // starting x offset for creative drawing
  private final static int START_X_C = 40; 
  
  private final static int START_Y = 40; //starting y offset 
 
  private final static int PEN_WIDTH = 10; 
  private final static Color PEN_COLOR_BL = Color.BLACK;
  private final static Color PEN_COLOR_R = Color.RED;
  private final static Color PEN_COLOR_G = Color.GREEN;
  private final static Color PEN_COLOR_B = Color.BLUE;
  private final static Color PEN_COLOR_Y = Color.YELLOW;

  //for 1
  private final static int TURN_FOR_1 = 45; 

  //for w
  private final static int TURN_FOR_W1 = 85;
  private final static int TURN_FOR_W2 = 157;  
  private final static int TURN_FOR_W3 = 144 ; 
  private final static int FORWARD_FOR_W1 = 42; 
	
  //for z
  private final static int TURN_FOR_Z = 117;
  private final static int FORWARD_FOR_Z = 90; 

  //for n
  private final static int TURN_FOR_N1 = 63;
  private final static int TURN_FOR_N2 = 153;
  private final static int FORWARD_FOR_N = 89;

  //for r
  private final static int TURN_FOR_R1 = 45;
  private final static int TURN_FOR_R2 = 56;

  private final static int DELAY = 500;

  private final static int WORLD_WIDTH = 600; 
  private final static int WORLD_HEIGHT = 400; 

  //save the variables that need in run
  private char ch;
  private int x, y;


 
  /* 
  * Name: Constructor name 
  * Purpose: Briefly describe the purpose of this constructor 
  * Parameters: List all parameters and their types and what they represent.  * 	* If no parameters, just state None. 
  */ 
 
  public CS11Turtle_Threaded(World w, char ch, int x, int y, int delay)
  { 
    //call the super class
    super(w, delay); 
  
    //save the parameters that passed in
    this.ch = ch;
    this.x = x;
    this.y = y;

    this.setPenWidth(PEN_WIDTH);
    this.setPenColor(Color.blue); 

    //start the run
    new Thread(this).start();
  }



  /* 
  * Name: Draw C
  * Purpose: Use turtle to draw letter c 
  * Parameters: the starting postion x and y 
  * Return: void
  */ 
 
  private void drawC(int x, int y) 
  { 
    penUp(); 
    moveTo(x, y); // always start in upper left corner of this char block 
    turnToFace(getXPos() + 1, getYPos()); // face right 
    penDown(); 
    forward(CHAR_WIDTH); 
    penUp(); 
    backward(CHAR_WIDTH); 
    turnRight(); 
    penDown(); 
    forward(CHAR_SPACE); 
    turnLeft(); 
    forward(CHAR_WIDTH); 
   }

  /* 
  * Name: Draw S 
  * Purpose: Use turtle to draw letter c 
  * Parameters: the starting postion x and y 
  * Return: void
  */ 
 
  private void drawS(int x, int y) 
  { 
    penUp(); 
    moveTo(x, y); 
    turnToFace(getXPos() + 1, getYPos()); 
    penDown();
    forward(CHAR_WIDTH); //first horizontal line of S
    penUp();
    backward(CHAR_WIDTH);
    turnRight();
    penDown();
    forward(CHAR_WIDTH); //first vertical line of S
    penUp();
    turnLeft();
    penDown();
    forward(CHAR_WIDTH); //second horizontal line of S
    penUp();
    turnRight();
    penDown();
    forward(CHAR_WIDTH); //second vertical line of S
    penUp();
    turnRight();
    penDown();
    forward(CHAR_WIDTH); //last line of S
  } 



  /* 
  * Name: Draw 1 
  * Purpose:  Use turtle to draw number 1
  * Parameters: the starting postion x and y 
  * Return: void
  */ 

  private void draw1(int x, int y) 
  { 
    penUp(); 
    moveTo(x, y); //starting point of 1
    turnToFace(getXPos() + 1, getYPos()); 
    forward(CHAR_HALF_WIDTH);// the diagonal line of 1
    turnRight();
    turn(TURN_FOR_1);
    penDown();
    forward(CHAR_HALF_WIDTH);
    penUp();
    backward(CHAR_HALF_WIDTH);
    turn(-TURN_FOR_1);
    penDown();
    forward(CHAR_SPACE);
    penUp();
    turnRight();
    forward(CHAR_HALF_WIDTH);
    turnRight();
    turnRight();
    penDown();
    forward(CHAR_WIDTH);
  }



  /*  
  * Name: Draw w
  * Purpose: Use turtle to draw letter w
  * Parameters: the starting postion x and y 
  * Return: void
  */ 

  private void drawW(int x, int y) 
  { 
    penUp(); 
    moveTo(x, y); //starting point of W
    turnToFace(getXPos() + 1, getYPos()); 
    turn(TURN_FOR_W1);
    penDown();
    forward(CHAR_SPACE); //first diagonal line of W
    penUp();

    //turn the turtle to draw the second diagonal line of W
    turn(-TURN_FOR_W2); 
    penDown();

    // draw the second diagonal line of W
    forward(FORWARD_FOR_W1);
    penUp();

    //turn the turtle to draw the 3rd diagonal line of W
    turn(TURN_FOR_W3); 

    penDown();
	
    //draw the 3rd diagonal line of W
    forward(FORWARD_FOR_W1);
    
    penUp();
    
    //turn the turtle to draw the last diangol line of W
    turn(-TURN_FOR_W2);
	
    penDown();
    forward(CHAR_SPACE);//finish drawing W
  }



	/* 
	* Name: Draw J 
  * Purpose: Use turtle to draw letter j
  * Parameters: the starting postion x and y 
  * Return: void
  */ 

	private void drawJ(int x, int y) 
  { 
 		penUp(); 
 		moveTo(x, y); //starting point of J
 		turnToFace(getXPos() + 1, getYPos()); 
		penDown();
		forward(CHAR_WIDTH);//draw the first horizontal line of J
		penUp();

		//move turtle to the middle of J's first horizontal line
		backward(CHAR_HALF_WIDTH);	turnRight();

		penDown();
		forward(CHAR_SPACE);//draw the vertical line of J
		penUp();
		turnRight();
		penDown();
		forward(CHAR_HALF_WIDTH );//draw the second horizontal line of J
	}



	/* 
  * Name: Draw Z 
  * Purpose: Use turtle to draw letter z
  * Parameters: the starting postion x and y 
  * Return: void
 	*/ 

	private void drawZ(int x, int y) 
  { 
 		penUp(); 
 		moveTo(x, y); //starting point of Z
 		turnToFace(getXPos() + 1, getYPos()); 
		penDown();
		forward(CHAR_WIDTH);//draw the first horizontal line of Z
		penUp();	
		turn(TURN_FOR_Z);
		penDown();
		forward(FORWARD_FOR_Z);
		penUp();
		turn(-TURN_FOR_Z);
		penDown();
		forward(CHAR_WIDTH);
	}



	/* 
  * Name: Draw I 
  * Purpose: Use turtle to draw letter i
  * Parameters: the starting postion x and y 
  * Return: void
  */ 

	private void drawI(int x, int y) 
  { 
 		penUp(); 
 		moveTo(x, y); //starting point of I
 		turnToFace(getXPos() + 1, getYPos()); 
		penDown();
		forward(CHAR_WIDTH);//draw the first horizontal line of I
		penUp();
		
		//move turtle to the middle of I's first horizontal line
		backward(CHAR_HALF_WIDTH);
		
		turnRight();
		penDown();
		forward(CHAR_SPACE);//draw the vertical line of I
		penUp();
		turnRight();

		//move turtle to the left end of I's second horizontal line
		forward(CHAR_HALF_WIDTH );
	
		turnRight();
		turnRight();//flip 180 degrees
		penDown();
		forward(CHAR_WIDTH);//draw the base line of I
	}	



	/* 
  * Name: Draw N 
  * Purpose: Use turtle to draw letter n
  * Parameters: the starting postion x and y 
  * Return: void
 	*/ 

	private void drawN(int x, int y) 
  { 
 		penUp(); 
 		moveTo(x, y); //starting point of N
 		turnToFace(getXPos() + 1, getYPos()); 
		penDown();
		turn(TURN_FOR_N1);
		forward(FORWARD_FOR_N);//draw the diagonal line of N
		penUp();
		turn(-TURN_FOR_N2);
		penDown();
		forward(CHAR_SPACE);//draw the vertical line of N on the right
		penUp();
		turnLeft();
		forward(CHAR_WIDTH);
		turnLeft();//move turtle to the upper left corner of N
		penDown();
		forward(CHAR_SPACE);//draw the vertical line of N on the left
	}



	/* 
  * Name: Draw T 
  * Purpose: Use turtle to draw letter t
  * Parameters: the starting postion x and y 
  * Return: void
  */ 

	private void drawT(int x, int y) 
  { 
 		penUp(); 
 		moveTo(x, y); //starting point of T
 		turnToFace(getXPos() + 1, getYPos()); 
		penDown();
		forward(CHAR_WIDTH);//draw the first horizontal line of T
		penUp();

		//move turtle to the middle of T's first horizontal line
		backward(CHAR_HALF_WIDTH);

		turnRight();
		penDown();
		forward(CHAR_SPACE);//draw the vertical line of T
  }



	/* 
  * Name: Draw E 
  * Purpose: Use turtle to draw letter e
  * Parameters: the starting postion x and y 
  * Return: void
  */ 

	private void drawE(int x, int y) 
  { 
 		penUp(); 
 		moveTo(x, y); 
 		turnToFace(getXPos() + 1, getYPos()); 
		penDown();
		forward(CHAR_WIDTH); //first horizontal line of E
		penUp();
		backward(CHAR_WIDTH);
		turnRight();
		penDown();
		forward(CHAR_WIDTH); //first vertical line of E
		penUp();
		turnLeft();
		penDown();
		forward(CHAR_WIDTH); //second horizontal line of E
		penUp();
		backward(CHAR_WIDTH);
		turnRight();
		penDown();
		forward(CHAR_WIDTH); //second vertical line of E
		penUp();
		turnLeft();
		penDown();
		forward(CHAR_WIDTH); //last line of E
	} 



	/* 
  * Name: Draw R
  * Purpose: Use turtle to draw letter r
  * Parameters: the starting postion x and y 
  * Return: void
  */ 

	private void drawR(int x, int y) 
  { 
  	penUp(); 
  	moveTo(x, y); 
  	turnToFace(getXPos() + 1, getYPos()); 
 		penDown();
 		forward(CHAR_WIDTH); //first horizontal line of R
		penUp();
		turnRight();
		penDown();
		forward(CHAR_WIDTH); //first vertical line of R
		penUp();
		turnRight();
		penDown();
		forward(CHAR_WIDTH); //second horizontal line of R
		penUp();
		turnRight();
		forward(CHAR_WIDTH); //move turtle to the upper left point of R
		turnRight();
		turnRight();//flip 180 degrees
		penDown();
		forward(CHAR_SPACE);//draw the 80 pixel vertical line of R
		penUp();
		backward(CHAR_WIDTH);
		turn(-TURN_FOR_R1);
		penDown();
		forward(TURN_FOR_R2); //diagonal line of R
  } 



	/* 
  * Name: Draw 2
  * Purpose: Use turtle to draw number 2
  * Parameters: the starting postion x and y 
  * Return: void
  */ 

	private void draw2(int x, int y) 
	{ 
 		penUp(); 
 		moveTo(x, y); 
 		turnToFace(getXPos() + 1, getYPos()); 
		penDown();
		forward(CHAR_WIDTH); //first horizontal line of 2
		penUp();
		turnRight();
		penDown();
		forward(CHAR_WIDTH); //first vertical line of 2
		penUp();
		turnRight();
		penDown();
		forward(CHAR_WIDTH); //second horizontal line of 2
		penUp();
		turnLeft();
		penDown();
		forward(CHAR_WIDTH); //second vertical line of 2
		penUp();
		turnLeft();
		penDown();
		forward(CHAR_WIDTH); //last line of 2
	} 



	/* 
  * Name: Draw 0
  * Purpose: Use turtle to draw number 0
  * Parameters: the starting postion x and y 
  * Return: void
  */ 

	private void draw0(int x, int y) 
  { 
	 	penUp(); 
 		moveTo(x, y); 
	 	turnToFace(getXPos() + 1, getYPos()); 
		penDown();
		forward(CHAR_WIDTH); //first horizontal line of 0
		penUp();
		turnRight();
		penDown();
		forward(CHAR_SPACE); //first vertical line of 0
		penUp();
		turnRight();
		penDown();
		forward(CHAR_WIDTH); //second horizontal line of 0
		penUp();
		turnRight();
		penDown();
		forward(CHAR_SPACE); //second vertical line of 0
	}



	/* 
  * Name: Draw 4
  * Purpose: Use turtle to draw number 4
  * Parameters: the starting postion x and y 
  * Return: void
  */ 

	private void draw4(int x, int y) 
	{ 
  	penUp(); 
  	moveTo(x, y); 
  	turnToFace(getXPos() + 1, getYPos()); 
 		turnRight();
  	penDown();
		forward(CHAR_WIDTH); //first horizontal line of 4
		penUp();
		turnLeft();
		penDown();
		forward(CHAR_WIDTH); //first vertical line of 4
		penUp();
		turnLeft();
		forward(CHAR_WIDTH); //second horizontal line of 4
		turnRight();
		turnRight();
		penDown();
		forward(CHAR_SPACE); //second vertical line of 4
	} 



	/* 
  * Name: run()
  * Purpose: Drawing different characters based on different ch variable 
  * Parameters: None
  * Return: void
  */

	public void run()
	{
		switch(ch)
    {
      //different cases for switch
 			case 'C': this.drawC(x,y); break;
 			case 'S': this.drawS(x,y); break;
 			case '1': this.draw1(x,y); break;
 			case 'W': this.drawW(x,y); break;
 			case 'J': this.drawJ(x,y); break;
 			case 'I': this.drawI(x,y); break;
 			case 'N': this.drawN(x,y); break;
		  case 'T': this.drawT(x,y); break;
 			case 'E': this.drawE(x,y); break;
 			case 'R': this.drawR(x,y); break;
 			case '2': this.draw2(x,y); break;
 			case '0': this.draw0(x,y); break;
 			case '4': this.draw4(x,y); break;
 		}
	}



	/* 
  * Name: Main!!!
  * Purpose: putting everything together 
  * Parameters: String [] args
  * Return: void
  */

	public static void main(String [] args) 
  { 
 		int startX1 = START_X_1, // starting x offset for line 1 
     		startX2 = START_X_2, // starting x offset for line 2 
     		startX3 = START_X_3; // starting x offset for line 3 
 
		int startXC = START_X_C; // starting x offset for creative drawing

 		int startY = START_Y; // starting y offset 
 
		int x, y; 
 
 		World w = new World(WORLD_WIDTH, WORLD_HEIGHT); 

 		//first line of words 
 		new CS11Turtle_Threaded(w,'C',x = startX1, y = startY, DELAY); 
		new CS11Turtle_Threaded(w,'S',x += CHAR_SPACE, y, DELAY); 
	  new CS11Turtle_Threaded(w,'1',x += CHAR_SPACE, y, DELAY); 
 		new CS11Turtle_Threaded(w,'1',x += CHAR_SPACE, y, DELAY); 
 		new CS11Turtle_Threaded(w,'W',x += CHAR_SPACE, y, DELAY); 
 		new CS11Turtle_Threaded(w,'J',x += CHAR_SPACE, y, DELAY); 
 		new CS11Turtle_Threaded(w,'C',x += CHAR_SPACE, y, DELAY); 

 		//second line of words
 		new CS11Turtle_Threaded(w,'W',x = startX2, y = startY + LINE_SPACE, 
														DELAY); 

		new CS11Turtle_Threaded(w,'I',x += CHAR_SPACE, y, DELAY); 
 		new CS11Turtle_Threaded(w,'N',x += CHAR_SPACE, y, DELAY); 
		new CS11Turtle_Threaded(w,'T',x += CHAR_SPACE, y, DELAY); 
 		new CS11Turtle_Threaded(w,'E',x += CHAR_SPACE, y, DELAY); 
 		new CS11Turtle_Threaded(w,'R',x += CHAR_SPACE, y, DELAY); 

 		//third line of words
 		new CS11Turtle_Threaded(w,'2',x = startX3, y += LINE_SPACE,DELAY); 
 		new CS11Turtle_Threaded(w,'0',x += CHAR_SPACE, y, DELAY); 
 		new CS11Turtle_Threaded(w,'1',x += CHAR_SPACE, y, DELAY); 
 		new CS11Turtle_Threaded(w,'4',x += CHAR_SPACE, y, DELAY); 
	} //End of main
 
} // End of public class CS11Turtle_Threaded extends Turtle


