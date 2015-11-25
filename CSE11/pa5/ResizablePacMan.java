/* 
 * Name: Songhao Zhou 
 * Login: cs11wJC
 * Date: 2/10/2014
 * File: ResizablePacMan.java 
 * control the resizing, color of PacMan,spin,stop (everything about PacMan)
 */ 

import objectdraw.*;
import java.awt.*;
import java.lang.Math;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/* 
 * Name: ResizablePacMan
 * Purpose: creating the class ResizablePacMan
 * responsible for the active resizing, spining, changing color part
 */
public class ResizablePacMan extends ActiveObject implements ActionListener,
MouseListener, MouseMotionListener, ChangeListener
{
  private static final double START_ANGLE = 0; // the given start angle value
  private static final double ARC_ANGLE = 280; // the given arc angle 

  // given change in pixels of size to make resizing a smooth transition
  private static final double SIZECHANGE = 2;  

  private static final double HALF = 0.5;      // define half = 0.5	
  private static final double TWICE = 2;       // define twice = 2
 
  //the amount of pixel that needed to keep the center unshifted
  private static final double INCREASE_OFFSET = -1;

  //the amount of pixel that needed to keep the center unshifted  
  private static final double DECREASE_OFFSET = 1; 

  //the amount of angle increment
  private static final int ANGLE_INCREMENT = 10; 

  // the amount of value that we need to keep vertical and horizontal
  // line off the canvas boundry
  private static final int BOUNDARY_OFFSET = 5;

  // the variable to store the intersection x and y coordinates
  private double intersection_x, intersection_y; 

  // the variable to store the x and y location that Controller has pass along
  private double xloc,yloc;

  private double PacManSize, original_PacManSize;
  
  //JSlider variables
  private static final int SLOW_SPEED = 1;
  private static final int FASR_SPPED = 100;
  private static final int DEFAULT_SPEED = 50;
  private double spin_speed;
  private double pause_time;

  //pacman variables
  private FilledArc PacMan;

  // variable for angle change during the resizing
  private double angle; 

  //variables for line
  private Line hLine, vLine; 

  //boolean variables
  private boolean pacman_present;

  private boolean clear_all_button_status;
  private static boolean check = false;
  private boolean cleared = false;
  private boolean check_click;
  private boolean grabbed_one;

  private boolean switched;

  //variables for spin
  private int direction1;

  //GUI stuff
  private JButton start_Button, stop_Button, clear_all_Button;
  private JSlider speedSlider;

  //location variables
  private Location point_pressed;
  private Location point_draggedd;
  private Location lastpoint;

  //canvas
  private DrawingCanvas canvas;

  /* 
  * Name: ResizablePacMan
  * Purpose: creating the class (constructor)]
  * Parameters: double xloc, the x location where mouse click happened;  
  * double yloc, the y location where mouse click happened; double size,
  * the desired size of PacMan; DrawingCanvas canvas,the canvas we draw on;
  * Line hLine, the horizontal line we pass along; Line vLine, the vertical 
  * line we pass along.JSlider speedSlider, the JSlider that we've created
  * in controller; check_click, the boolean variable whick check if the 
  * stop button is hit before anything created; direction is a int that
  * indicates which direction the PacMan is spinning(1 for counter-clockwise
  * -1 for clockwise
  */ 
  public ResizablePacMan(double xloc,double yloc, double size, 
  DrawingCanvas can  vas, Line hLine, Line vLine, JSlider speedSlider,
  boolean check_click, int di  rection)
  {
  double start_x, start_y;
  original_PacManSize = size;//initialize original PacManSize
  PacManSize = size;         // initialize PacManSize
  angle = START_ANGLE; //initialize the angle to be the START_ANGLE = 0
	
  // pass along the horizontal and vertical line in order to check 
  // posistion of PacMan in run
  this.hLine = hLine;   
  this.vLine = vLine;

  // pass along the x location and y location during mouse click to check
  // position of PacMan in run
  this.xloc = xloc;
  this.yloc = yloc;
	
  // pass along speedslider
  this.speedSlider = speedSlider;

  // pass along check_click
  this.check_click = check_click;

  //store canvas
  this.canvas = canvas;

  //pass along spin 
  this.direction1 = direction;

  // get x coordinate of hline and vline intersection 
  intersection_x = (vLine.getEnd()). getX(); 
	
  // get y coordinate of hline and vline intersection
  intersection_y = (hLine.getEnd()). getY(); 

  //set the point where PacMan will be created at the center of click
  start_x = xloc - size/TWICE;  // set the x coord
  start_y = yloc - size/TWICE;  // set the y coord

  // create the PacMan using all the parameters that controler has sent along
  this.PacMan = new FilledArc (start_x, start_y, size, size, START_ANGLE,
  ARC_ANGLE, canvas); 
	
  pacman_present = true;
	
  //Register for mouse events	
  canvas.addMouseListener ( this );
  canvas.addMouseMotionListener ( this );	


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
  * Purpose: run the animation part of the PacMan (resizing and changing the 
  * color while size of canvas has changed. Also adds the condition where
  * stop and starts happens (using a boolean variable called check)
  */ 
  public void run()
  {
  // an infinte loop to keep the PacMan resizing and changing color
  while(true)
    {
  do
      {
  //check if stop button is not hit and the first ever check is passed
  if( check == false && check_click == false)
        {
        // increase Pacmansize 2 pixels everytime
        PacManSize = PacManSize + SIZECHANGE;  
        PacMan.setWidth(PacManSize); // apply the change in width to pacman
        PacMan.setHeight(PacManSize); // apply the change in height to pacman
        // increase the spinning angle by 1 every time
        angle = angle + ANGLE_INCREMENT*direction1; 

         PacMan.setStartAngle(angle); // apply the change in angle to PacMan
         PacMan.move(INCREASE_OFFSET, INCREASE_OFFSET);
        }

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
	
  spin_speed = speedSlider.getValue();
  pause_time = FASR_SPPED - spin_speed;
  pause(pause_time); // pause the change about 50 millisecond
 
      } while(PacManSize <= TWICE * original_PacManSize); 
      // keep increasing the size and spinning if pacman is less than twice of
      //its size
 
  do
      {
  //check if stop button is not hit and the first ever check is passed
  if( check == false && check_click==false)
        {    
        // increase Pacmansize 2 pixels everytime
        PacManSize = PacManSize - SIZECHANGE; 
        PacMan.setWidth(PacManSize);  // apply the change in width to pacman
        PacMan.setHeight(PacManSize); // apply the change in height to pacman
        // increase the spinning angle by 1 every time
        angle = angle + ANGLE_INCREMENT*direction1;
 
        PacMan.setStartAngle(angle); // apply the change in angle to PacMan
        PacMan.move(DECREASE_OFFSET, DECREASE_OFFSET);     
        }

  //set color to magenta if it's in 1st quadrant(upper right)
  if( xloc > (vLine.getEnd()). getX() && yloc < (hLine.getEnd()). getY() )
        {
        PacMan.setColor(Color.magenta);//set to magenta
        }
 
  //set color to Cyan if it's in 2nd quadrant (upper left)
  else if ( xloc < (vLine.getEnd()). getX() && yloc < (hLine.getEnd()). getY())
        {
        PacMan.setColor(Color.cyan); //set to cyan
        }
     
  // set color to yelloe if it's in 3rd quadrant (lower left)
  else if( xloc < (vLine.getEnd()). getX() && yloc > (hLine.getEnd()). getY())
        {
	PacMan.setColor(Color.yellow); //set to yellow
        }
 
  //set color to black if it's in 4th quadrant (lower right)
  else if( xloc > (vLine.getEnd()). getX() && yloc > (hLine.getEnd()). getY())
        {
        PacMan.setColor(Color.black); //set to black
        }
 
  spin_speed = speedSlider.getValue();    
  pause_time = FASR_SPPED - spin_speed;
  pause(pause_time); // pause the change about 50 millisecond

      } while(PacManSize >= HALF * original_PacManSize ); 
      // keep decreasing the size and spinning if pacman is larger than half of
      //its size

    }//end of while (true)
  }//end of public run
 


  /* 
  * Name: actionPerformed
  * Purpose: this is the requirement for action listener which listen to the
  * action performed. In each case, there will be a correspondong boolean
  * varaible set to true; in the swtich spiin,there is a int varaible direction
  * which will set to be negative of its value if swtich spin button is hit
  * Parameters: ActionEvent evt, using this we can get which trigger the action
  * Return: void
  */
  public void actionPerformed( ActionEvent evt )
  {
  //check if clear all button is hit but it hasn't been cleared yet
  if(evt.getActionCommand() .equals( "Clear All") && cleared == false )
    {
    clear_all_button_status = true; // set cleared button hit to true
	
    PacMan.removeFromCanvas(); // remove PacMan from the canvas
    cleared = true; // set cleared already to true	
    }

  //check if start button is hit
  else if (evt.getActionCommand() .equals( "Start") )
    {
    check = false; // set clear button hit to false
    check_click = false; // set first check of clear button to false
    }

  //check if clear button is hit
  else if (evt.getActionCommand() .equals( "Stop") )
    {
    check = true; // set clear button hit to true
    check_click = true;
    }

  else if ( evt.getActionCommand() .equals( "Switch Spin" ) )
    {
    switched = true;
    direction1 = -direction1;
    }
  }



  /* 
  * Name: mousePressed
  * Purpose: In mousePressed we check whether the PacMan is grabbed
  * if they are grabbed then set the corresponding boolean
  * variable to true.
  * Parameters:  MouseEvent evt, we have this parameter to determine
  * the point when user press the mouse.
  */ 
  public void mousePressed( MouseEvent evt ) 
  {
  //create a new location point to store the current mouse location
  point_pressed = new Location (evt.getX(), evt.getY());
	
  if(PacMan.contains(point_pressed))
    {
    grabbed_one = true; //set grabbed_one to true if it contains the point
    lastpoint = point_pressed; // store the current point lastpoint
    }	
  }

  /* 
  * Name: mouseDragged
  * Purpose: In mouseDragged we move the PacMans 
  * to the new location where user has dragged
  * Parameters:  MouseEvent evt, we have this parameter determine 
  * where should lines end up at
  */ 
  public void mouseDragged( MouseEvent evt ) 
  {
  //create a new location point to store the current mouse location
  point_draggedd = new Location (evt.getX(), evt.getY());
		
  //check if grabbed is true and whether the center point of each pacman is 
  //within the boudary
  if (grabbed_one && xloc+ evt.getX() - lastpoint.getX() >= BOUNDARY_OFFSET
      && xloc+evt.getX() - lastpoint.getX() <= canvas.getWidth()-
      BOUNDARY_OFFSET && yloc+(evt.getY() - lastpoint.getY()) >= 
      BOUNDARY_OFFSET && yloc+(evt.getY() - lastpoint.getY()) <= 
      canvas.getHeight()-BOUNDARY_OFFSET)
    {
    //upodate the xloc of the center of each pacman by the amount of dragged
    xloc = xloc + (evt.getX() - lastpoint.getX());
    //upodate the yloc of the center of each pacman by the amount of dragged
    yloc = yloc + (evt.getY() - lastpoint.getY());

    //move the pacman by the amount of dragged
    PacMan.move(evt.getX() - lastpoint.getX(), evt.getY() - lastpoint.getY());
    lastpoint = point_draggedd; // set the new current location to lastpoint

    }
  }


  // MouseListener
  /* 
  * Name: mouseClicked 
  * Purpose: none
  * Parameters: MouseEvent evt. 
  * Return: void. 
  */ 
  public void mouseClicked( MouseEvent evt ) { }

  /* 
  * Name: mouseEntered 
  * Purpose: none
  * Parameters: MouseEvent evt. 
  * Return: void. 
  */ 
  public void mouseEntered( MouseEvent evt ) { }

  /* 
  * Name: mouseExited 
  * Purpose: none
  * Parameters: MouseEvent evt. 
  * Return: void. 
  */ 
  public void mouseExited( MouseEvent evt ) { }

  /* 
  * Name: mouseMoved 
  * Purpose: none
  * Parameters: MouseEvent evt. 
  * Return: void. 
  */ 
  public void mouseMoved( MouseEvent evt ) { }

  /* 
  * Name: mouseReleased 
  * Purpose: set the boolean variable for determing grab status back to false
  * Parameters: MouseEvent evt. 
  * Return: void. 
  */ 
  public void mouseReleased( MouseEvent evt ) 
  {
  grabbed_one = false; //set grabbed_one to false
  }

  // ChangeListener
  /* 
  * Name: stateChanged 
  * Purpose: none
  * Parameters: ChangeEvent evt. 
  * Return: void. 
  */ 
  public void stateChanged( ChangeEvent evt ) {}

}//end of class



