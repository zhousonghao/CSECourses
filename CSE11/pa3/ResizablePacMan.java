/* 
 * Name: Songhao Zhou 
 * Login: cs11wJC
 * Date: 1/27/2014
 * File: ResizablePacMan.java 
 * control the resizing, color of PacMan (everything about PacMan)
 */ 

import objectdraw.*;
import java.awt.*;
import java.applet.*; 


/* 
 * Name: ResizablePacMan
 * Purpose: creating the class ResizablePacMan
 */
public class ResizablePacMan extends ActiveObject
{
private static final double START_ANGLE = 0; // the given start angle value
private static final double ARC_ANGLE = 280; // the given arc angle 
private static final double SIZECHANGE = 2;  // given change in pixels of size to make resizing a smooth transition
private static final double HALF = 0.5;      // define half = 0.5	
private static final double TWICE = 2;       // define twice = 2
private static final double PAUSE_TIME = 50; // the pause time between each pacman size change
private double intersection_x, intersection_y; // the variable to store the intersection x and y coordinates
private double xloc,yloc; // the variable to store the x and y location that Controller has passed along

private double PacManSize, original_PacManSize;

private FilledArc PacMan;
private double angle; // variable for angle change during the resizing
private Line hLine, vLine; //



/* 
 * Name: ResizablePacMan
 * Purpose: creating the class (constructor)]
 * Parameters: double xloc, the x location where mouse click happened; double yloc, the y location where mouse click happened; double size, th   e desired size of PacMan; DrawingCanvas canvas,the canvas we draw on; Line hLine, the horizontal line we pass along; Line vLine, the vertic   al line we pass along
 */ 
public ResizablePacMan(double xloc,double yloc, double size, DrawingCanvas canvas, Line hLine, Line vLine)
{
	double start_x, start_y;
	original_PacManSize = size;//initialize original PacManSize
	PacManSize = size;         // initialize PacManSize
	angle = START_ANGLE; //initialize the angle to be the START_ANGLE = 0
	
	// pass along the horizontal and vertical line in order to check posistion of PacMan in run
	this.hLine = hLine;   
	this.vLine = vLine;

	// pass along the x location and y location during mouse click to check position of PacMan in run
	this.xloc = xloc;
	this.yloc = yloc;
	

	intersection_x = (vLine.getEnd()). getX(); // get x coordinate of hline and vline intersection 
	intersection_y = (hLine.getEnd()). getY(); // get y coordinate of hline and vline intersection

	//set the point where PacMan will be created at the center of click
	start_x = xloc - size/2;  // set the x coord
	start_y = yloc - size/2;  // set the y coord

	// create the PacMan using all the parameters that controler has sent along
	PacMan = new FilledArc (start_x, start_y, size, size, START_ANGLE, ARC_ANGLE, canvas); 

	//set color to magenta if it's in 1st quadrant(upper right)
	if( xloc > intersection_x && yloc < intersection_y )
	{
		PacMan.setColor(Color.magenta); //set to magenta
	}
	//set color to Cyan if it's in 2nd quadrant (upper left)
	else if ( xloc < intersection_x && yloc < intersection_y )
	{
		PacMan.setColor(Color.cyan); // set to cyan
	}
	
	// set color to yelloe if it's in 3rd quadrant (lower left)
	else if( xloc < intersection_x && yloc > intersection_y )
	{
		PacMan.setColor(Color.yellow); //set to yellow
	}

	//set color to black if it's in 4th quadrant (lower right)
	else if( xloc > intersection_x && yloc > intersection_y )
	{
		PacMan.setColor(Color.black); //set to black
	}

	start(); //start the animation
}



/* 
 * Name: run
 * Purpose: run the animation part of the PacMan (resizing and changing the color while size of canvas has changed
 */ 
public void run()
{
// an infinte loop to keep the PacMan resizing and changing color
   while(true){

	do{

	PacManSize = PacManSize + SIZECHANGE;  // increase Pacmansize 2 pixels everytime
	PacMan.setWidth(PacManSize); // apply the change in width to pacman
	PacMan.setHeight(PacManSize); // apply the change in height to pacman
	
	angle ++; // increase the spinning angle by 1 every time
	PacMan.setStartAngle(angle); // apply the change in angle to PacMan

	//set color to magenta if it's in 1st quadrant(upper right)
	if( xloc > (vLine.getEnd()).getX() && yloc < (hLine.getEnd()).getY() )
	{
		PacMan.setColor(Color.magenta); // set to magenta
	}

	//set color to Cyan if it's in 2nd quadrant (upper left)
	else if ( xloc < (vLine.getEnd()).getX() && yloc < (hLine.getEnd()).getY() )
	{
		PacMan.setColor(Color.cyan); //set to cyan
	}
	
	// set color to yelloe if it's in 3rd quadrant (lower left)
	else if( xloc < (vLine.getEnd()).getX() && yloc > (hLine.getEnd()).getY() )
	{
		PacMan.setColor(Color.yellow); //set to yellow
	}

	//set color to black if it's in 4th quadrant (lower right)
	else if( xloc > (vLine.getEnd()).getX() && yloc > (hLine.getEnd()).getY() )
	{
		PacMan.setColor(Color.black); //set to black
	}

	pause(PAUSE_TIME); // pause the change about 50 millisecond

	} while(PacManSize <= TWICE * original_PacManSize); // keep increasing the size and spinning if pacman is less than twice of its size


	do{
	PacManSize = PacManSize - SIZECHANGE; // increase Pacmansize 2 pixels everytime
	PacMan.setWidth(PacManSize);  // apply the change in width to pacman
	PacMan.setHeight(PacManSize); // apply the change in height to pacman

	angle ++; // increase the spinning angle by 1 every time
	PacMan.setStartAngle(angle); // apply the change in angle to PacMan

	//set color to magenta if it's in 1st quadrant(upper right)
	if( xloc > (vLine.getEnd()). getX() && yloc < (hLine.getEnd()). getY() )
	{
		PacMan.setColor(Color.magenta);//set to magenta
	}

	//set color to Cyan if it's in 2nd quadrant (upper left)
	else if ( xloc < (vLine.getEnd()). getX() && yloc < (hLine.getEnd()). getY() )
	{
		PacMan.setColor(Color.cyan); //set to cyan
	}
	
	// set color to yelloe if it's in 3rd quadrant (lower left)
	else if( xloc < (vLine.getEnd()). getX() && yloc > (hLine.getEnd()). getY() )
	{
		PacMan.setColor(Color.yellow); //set to yellow
	}

	//set color to black if it's in 4th quadrant (lower right)
	else if( xloc > (vLine.getEnd()). getX() && yloc > (hLine.getEnd()). getY() )
	{
		PacMan.setColor(Color.black); //set to black
	}

	pause(PAUSE_TIME); // pause the change about 50 millisecond

	} while(PacManSize >= HALF * original_PacManSize ); // keep decreasing the size and spinning if pacman is larger than half of its size

  }//end of while (true)
 }//end of public run
}//end of class



