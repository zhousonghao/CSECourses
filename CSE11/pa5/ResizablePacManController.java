/* 
 * Name: Songhao Zhou 
 * Login: cs11wJC
 * Date: 2/10/2014
 * File: ResizablePacManController.java 
 * control the MousePressed, MouseDraged, MouseClicked, super class paint
 * actionPerformed and statechanged method
 */ 

import objectdraw.*;
import java.awt.*;
import java.lang.Math;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/* 
 * Name: ResizablePacManController
 * Purpose: creating the class (constructor) implementing the interfaces
 * ActionListener, MouseListener, MouseMotionListener and ChangeListener
 */
public class ResizablePacManController extends WindowController implements 
	ActionListener, MouseListener, MouseMotionListener, ChangeListener
{

  private Line vertical_line; // object to create vertical line
  private Line horizontal_line; // object to create vertical line

  // vertical line's y coordinate will always be 0
  private static final double vertical_line_y_StartPoint = 0; 
 
  // horizontal line's x coordinate will always be 0
  private static final double horizontal_line_x_StartingPoint = 0; 

  // the boolean varaible to check 
  // whether the horizontal or vertical line has een grabbed
  private boolean vertical_grabbed, horizontal_grabbed; 

  // the amount of value that we need to keep vertical and horizontal
  // line off the canvas boundry
  private static final int BOUNDARY_OFFSET = 5; 

  // location to store the last point of vertical and horizontal line
  private Location lastpoint_vertical, lastpoint_horizontal; 

  // the initial proportion when the program is started
  private double proportion_vertical=0.5, proportion_horizontal=0.5; 

  // initialize the constant TWO is 2
  private static final int TWO = 2; 

  // initialize the constant TWO is 2
  private static final int ONE = 1; 

  //parameter for pacman
  private static final double PacManSize = 50;// the starting size of PacMan
  private static final int ANGLE_INCREMENT = 10;//the amount of angle increment

  //GUI stuff
  private JButton start_Button,stop_Button,clear_all_Button,switch_spin_Button;
  private JSlider speedSlider;
  private JLabel northPanel_text, jslider_text;

  //Location variables
  private Location point;

  //JSlider variables
  private static final int SLOW_SPEED = 1;
  private static final int FASR_SPPED = 100;
  private static final int DEFAULT_SPEED = 50;
  private int current_speed = 50;

  //boolean variables
  private boolean clear_all_button_status;
  private boolean check_click;
  private boolean switched;

  //variable for spin
  private int direction = -1 ;

  /* 
   * Name: begin
   * Purpose: begin will only run once; during begin, we draw 
   * the horizontal and vertical lines and make them to appear at the middle
   * of canvas.At the same time, we create the two big panels (north and south)
   * then in the north panel we have one text panel to contain the text
   * message, and another contains 4 buttons; while for the south panel, 
   * we let it contain the JSlider.
   */ 
  public void begin()
  {
  // local variable to store the horizontal x coordinate
  int horizontal_x_coordinate; 
    
  // local variable to store the horizontal y coordinate
  int horizontal_y_coordinate_end; 

  // local variable to store the vertical x coordinate
  int vertical_y_coordinate; 

  // local variable to store verticalx coordinate 
  int vertical_x_coordinate_end; 
	
  // set the initial horizontal x coordinate
  horizontal_x_coordinate = canvas.getWidth()/TWO;  
	
  // set the initial horizontal y coordinate
  horizontal_y_coordinate_end = canvas.getHeight(); 
	
  // create h_line
  vertical_line = new Line (horizontal_x_coordinate, 
  vertical_line_y_StartPoint, horizontal_x_coordinate,
  horizontal_y_coordinate_end, canvas); 

  // set the initial vertical x coordinate
  vertical_y_coordinate = canvas.getHeight()/TWO; 
	
  // set the initial vertical y coordinate
  vertical_x_coordinate_end = canvas.getWidth(); 
	
  // create v_line
  horizontal_line = new Line (horizontal_line_x_StartingPoint,
  vertical_y_coordinate, vertical_x_coordinate_end, 
  vertical_y_coordinate, canvas);

  //contruction of GUI panel 
  JPanel northPanel = new JPanel();
  northPanel.setLayout( new GridLayout( TWO, ONE ) );
  JPanel southPanel = new JPanel();
	
  //construction for smaller panels
  JPanel buttonPanel = new JPanel();
  JPanel textPanel = new JPanel();
  JPanel jsliderPanel = new JPanel();		

  //construction for buttons
  start_Button = new JButton( "Start" );
  stop_Button = new JButton( "Stop" );
  clear_all_Button = new JButton( "Clear All");
  switch_spin_Button = new JButton("Switch Spin");

  //contruction for slider
  speedSlider = new JSlider (JSlider.HORIZONTAL, SLOW_SPEED,
  FASR_SPPED, DEFAULT_SPEED);

  //contruction of GUI panel for text
  northPanel_text = new JLabel( "Resizable PacMan controls" );
  jslider_text = new JLabel ( "The speed is " + current_speed );
	
  //addlistener to the buttons 
  start_Button.addActionListener( this );
  stop_Button.addActionListener( this );
  clear_all_Button.addActionListener( this );
  speedSlider.addChangeListener( this );
  switch_spin_Button.addActionListener( this );	

  //add buttons to the corresponding panel
  textPanel.add( northPanel_text );
  buttonPanel.add( start_Button );
  buttonPanel.add( stop_Button );
  buttonPanel.add( clear_all_Button );
  buttonPanel.add( switch_spin_Button );
  jsliderPanel.add( speedSlider );

  //layout
  northPanel.add(textPanel);	
  northPanel.add(buttonPanel);
  southPanel.add(jslider_text);
  southPanel.add(speedSlider);

  //set the container
  Container contentPane = getContentPane();
  contentPane.add(northPanel, BorderLayout.NORTH);
   
  //add southpanel to the container using borderlayout	
  contentPane.add(southPanel, BorderLayout.SOUTH);	
  contentPane.validate();

  //Register for mouse events
  canvas.addMouseListener ( this );
  canvas.addMouseMotionListener ( this );	

  }//end of begin



  /* 
  * Name: mousePressed
  * Purpose: In mousePressed we check whether the vertical and horizontal
  * line is grabbed. if they are grabbed then set the corresponding boolean
  * variable to true.
  * Parameters:  MouseEvent evt, we have this parameter to determine
  * the point when user press the mouse.
  */ 
  public void mousePressed( MouseEvent evt )
  {
  //create a new location to store the point where the mouse is pressed
  point = new Location (evt.getX(), evt.getY());

  // if statement to check whether vertical line contains 
  // the mouse-click point
  if(vertical_line.contains(point) ) 	
    {
    // set vertical_grabbed to true if it contains mouse-click point
    vertical_grabbed = true;    	
    }
	
  else
    //set vertical_grabbed to true if it doesn't contain mouse-click point
    vertical_grabbed = false;  

    // if statement to check whether vertical line contains
    // the mouse-click point
  if (horizontal_line.contains(point) )
      {
      // set horizontal_grabbed to true if it contains mouse-click point
      horizontal_grabbed = true;  
      }
  else 
      // set horizontal_grabbed to true if it doesn't contain 
      // mouse-click point 
      horizontal_grabbed = false; 

  }// end of onMousePress



  /* 
  * Name: mouseClicked
  * Purpose: In mouseClicked we pass the parameters that ResizablePacMan.java
  * needs. which is the point where mouseclicked happens,pacmansize, canvas
  * horizontal and vertical lines, speed slider, check_click and direction
  * Parameters: MouseEvent evt, we have this parameter to pass along 
  * the x and y coordinates of the mouse
  */ 
  public void mouseClicked( MouseEvent evt ) 
  {	
    ResizablePacMan PacMan;

    //pass along the parameters only if the click happens in the boundary
  if(evt.getX() >= BOUNDARY_OFFSET && evt.getX() <= 
     canvas.getWidth()-BOUNDARY_OFFSET && evt.getY() >=
     BOUNDARY_OFFSET && evt.getY() <= canvas.getHeight()-BOUNDARY_OFFSET)
    {
    //create a new PacMan        
    PacMan = new ResizablePacMan( evt.getX(), evt.getY(), PacManSize, 
    canvas, horizontal_line, vertical_line, speedSlider, check_click, 
    direction); 
	
    // pass along the parameters to ResizablePacMan
    clear_all_Button.addActionListener( PacMan );
    stop_Button.addActionListener( PacMan );
    start_Button.addActionListener( PacMan );
    switch_spin_Button.addActionListener( PacMan );
    speedSlider.addChangeListener( PacMan );

    }
	
  }// end of MouseClicked



  /* 
  * Name: mouseDragged
  * Purpose: In mouseDragged we move the horizontal and vertical lines 
  * to the new location where user has dragged
  * Parameters:  MouseEvent evt, we have this parameter determine 
  * where should lines end up at
  */ 
  public void mouseDragged( MouseEvent evt ) 
  {
  // variables to store the vertical_X_location, horizontal_Y_location
  double vertical_X_location, horizontal_Y_location;  
	
  // initialize the vertical_X_location
  vertical_X_location = evt.getX(); 
	
  // initialize the horizontal_Y_location
  horizontal_Y_location = evt.getY(); 	

  //check if vertical line is grabbed and with the left and right boudnry
  //respect to the canvas
  if(vertical_grabbed && vertical_X_location >= BOUNDARY_OFFSET && 
     vertical_X_location <= canvas.getWidth()-BOUNDARY_OFFSET ) 
    {
      // if it satisefy the statement, set the vertical line
      vertical_line.setEndPoints(evt.getX(),vertical_line_y_StartPoint, 
      evt.getX(), canvas.getHeight()); 

      // calculate the proportion of the vertical line respect to the canvas
      // height
      proportion_vertical = evt.getX() / canvas.getWidth(); 	

    }//end of if 

    //check if horizontal line is grabbed and with the top and bottom boudnry 
    //respect to the canvas
  if(horizontal_grabbed && horizontal_Y_location >= BOUNDARY_OFFSET &&
     horizontal_Y_location <= canvas.getHeight()-BOUNDARY_OFFSET)
    {
    //if it satisefy the statement, set the h_line
    horizontal_line.setEndPoints(horizontal_line_x_StartingPoint, 
    evt.getY(), canvas.getWidth(), evt.getY());

    // calculate the proportion of the vertical line respect to the 
    // canvas width
    proportion_horizontal = evt.getY() / canvas.getHeight();
	
    }//end of if

  } // end of mouseDragged



  /* 
  * Name: paint 
  * Purpose: To reset the postion of vertical and horizontal lines when
  * canvas size had changed
  * Parameters: java.awt.Graphics g, a superclass
  */ 
  public void paint( java.awt.Graphics g)
  {
  super.paint(g); // make a call to the superclass

  // reset the position of vertical line while changing the size
  // of the canvas
  vertical_line.setEndPoints( canvas.getWidth() * proportion_vertical, 0 , 
  canvas.getWidth() * proportion_vertical, canvas.getHeight());

  //reset the position of horizontal line while changing the size 
  //of the canvas
  horizontal_line.setEndPoints(horizontal_line_x_StartingPoint, 
  canvas.getHeight() * proportion_horizontal, canvas.getWidth(),
  canvas.getHeight() * proportion_horizontal);

  }// end of paint



  /* 
  * Name: actionPerformed
  * Purpose: this is the requirement for action listener which listen to the
  * action performed. In each case, there will be a correspondong boolean
  * varaible set to true; in the swtich spiin, there is a int varaible direction
  * which will set to be negative of its value if swtich spin button is hit
  * Parameters: ActionEvent evt, using this we can get which trigger the action
  * Return: void
  */
  public void actionPerformed( ActionEvent evt )
  {
  if(evt.getSource() == clear_all_Button)
    {
    clear_all_button_status = true;
    }

  else if (evt.getSource() == start_Button)
      {
      check_click = false;	

      }

  else if (evt.getSource() == stop_Button)
        {
	check_click = true;
        }

  else if ( evt.getSource() == switch_spin_Button )
          {
	  direction = -direction; 
          //direction will be passed to ResizablePacMan and stored
	  }		

  }

  // MouseListener
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
  * Purpose: none
  * Parameters: MouseEvent evt. 
  * Return: void. 
  */ 
  public void mouseReleased( MouseEvent evt ) { }

  // ChangeListener
  /* 
  * Name: stateChanged
  * Purpose: this is the requirement for  Changelistener which listen to the
  * change performed.In this method, we will use getsource to get which 
  * object triggered event and then pass along the speedslider to 
  * ResizablePacMan.At the same time, set the text "The Speed is" with the
  * variable current_speed which will change accordingly to the slide
  * Parameters: ActionEvent evt, using this we can get which trigger the action
  * Return: void
  */
  public void stateChanged( ChangeEvent evt ) 
  { 
  JSlider speedSlider = (JSlider)evt.getSource();
  current_speed = speedSlider.getValue();
  jslider_text.setText( "The speed is " + current_speed );
  }

}//end of class

