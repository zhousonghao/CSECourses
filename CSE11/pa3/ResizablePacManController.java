/* 
 * Name: Songhao Zhou 
 * Login: cs11wJC
 * Date: 1/27/2014
 * File: ResizablePacManController.java 
 * control the OnMousePress, OnMouseDrag, OnMouseClick and super class paint
 */ 

import objectdraw.*;
import java.awt.*;
import java.lang.Math;



/* 
 * Name: ResizablePacManController
 * Purpose: creating the class (constructor)
 */
public class ResizablePacManController extends WindowController
{

private Line vertical_line; // object to create vertical line
private Line horizontal_line; // object to create vertical line
private static final double vertical_line_y_StartPoint = 0; // vertical line's y coordinate will always be 0
private static final double horizontal_line_x_StartingPoint = 0; // horizontal line's x coordinate will always be 0
private boolean vertical_grabbed, horizontal_grabbed; // the boolean varaible to check whether the horizontal or vertical line has een grabbed

private static final int BOUNDARY_OFFSET = 5; // the amount of value that we need to keep vertical and horizontal line off the canvas boundry
private Location lastpoint_vertical, lastpoint_horizontal; // location to store the last point of vertical and horizontal line
private double proportion_vertical=0.5, proportion_horizontal=0.5; // the initial proportion when the program is started
private static final int TWO = 2; // initialize the constant TWO is 2
//parameter for pacman
private static final double PacManSize = 50; // the starting size of PacMan



/* 
 * Name: begin
 * Purpose: begin will only run once; during begin, we draw the horizontal and vertical
 */ 
public void begin()
{
	int horizontal_x_coordinate; // local variable to store the horizontal x coordinate
	int horizontal_y_coordinate_end; // local variable to store the horizontal y coordinate
	int vertical_y_coordinate; // local variable to store the vertical x coordinate
	int vertical_x_coordinate_end; // local variable to store verticalx coordinate 

	horizontal_x_coordinate = canvas.getWidth()/TWO;  // set the initial horizontal x coordinate
	horizontal_y_coordinate_end = canvas.getHeight(); // set the initial horizontal y coordinate
	vertical_line = new Line (horizontal_x_coordinate, vertical_line_y_StartPoint, horizontal_x_coordinate, horizontal_y_coordinate_end, canvas); // create h_line

	vertical_y_coordinate = canvas.getHeight()/TWO; // set the initial vertical x coordinate
	vertical_x_coordinate_end = canvas.getWidth(); // set the initial vertical y coordinate
	horizontal_line = new Line (horizontal_line_x_StartingPoint,vertical_y_coordinate, vertical_x_coordinate_end, vertical_y_coordinate, canvas); // create v_line

}//end of begin



/* 
 * Name: OnMousePress
 * Purpose: In OnMousePress we check whether the vertical and horizontal line is grabbed
 * Parameters:  Location point, we have this parameter to determine the point when user press the mouse
 */ 
public void onMousePress( Location point )
{
	if(vertical_line.contains(point) )  // if statement to check whether vertical line contains the mouse-click point
	
	{
		vertical_grabbed = true;    // set vertical_grabbed to true if it contains mouse-click point
	}
	
	else
		vertical_grabbed = false;  //set vertical_grabbed to true if it doesn't contain mouse-click point


	if (horizontal_line.contains(point) ) // if statement to check whether vertical line contains the mouse-click point

	{
		horizontal_grabbed = true;  // set horizontal_grabbed to true if it contains mouse-click point

	}
	else 
		horizontal_grabbed = false; // set horizontal_grabbed to true if it doesn't contain mouse-click point

}// end of onMousePress



/* 
 * Name: OnMouseClick
 * Purpose: In OnMouseClick we pass the parameters that ResizablePacMan.java needs
 * Parameters:  Location point, we have this parameter to pass along the x and y coordinates of the mouse
 */ 

public void onMouseClick( Location point )
{	
	new ResizablePacMan( point.getX(), point.getY(), PacManSize, canvas, horizontal_line, vertical_line); // pass along the parameters to ResizablePacMan
}



/* 
 * Name: OnMouseDrag
 * Purpose: In OnMouseDrag we move the horizontal and vertical lines to the new location where user has dragged
 * Parameters:  Location point, we have this parameter determine where should lines end up at
 */ 

public void onMouseDrag( Location point )
{
	double vertical_X_location, horizontal_Y_location;  // variables to store the vertical_X_location, horizontal_Y_location

	vertical_X_location = point.getX(); // initialize the vertical_X_location
	horizontal_Y_location = point.getY(); // initialize the horizontal_Y_location
	

	//check if vertical line is grabbed and with the left and right boudnry respect to the canvas
	if(vertical_grabbed && vertical_X_location >= BOUNDARY_OFFSET && vertical_X_location <= canvas.getWidth()-BOUNDARY_OFFSET ) 
	{
	
	vertical_line.setEndPoints(point.getX(),vertical_line_y_StartPoint, point.getX(), canvas.getHeight()); // if it satisefy the statement, set the vertical line
	proportion_vertical = point.getX() / canvas.getWidth(); // calculate the proportion of the vertical line respect to the canvas height
	
	}//end of if 

	//check if horizontal line is grabbed and with the top and bottom boudnry respect to the canvas
	if(horizontal_grabbed && horizontal_Y_location >= BOUNDARY_OFFSET && horizontal_Y_location <= canvas.getHeight()-BOUNDARY_OFFSET)
	{
	
	horizontal_line.setEndPoints(horizontal_line_x_StartingPoint, point.getY(), canvas.getWidth(), point.getY());//if it satisefy the statement, set the h_line
	proportion_horizontal = point.getY() / canvas.getHeight(); // calculate the proportion of the vertical line respect to the canvas width

	}//end of if

} // end of OnMouseDrag




/* 
 * Name: paint 
 * Purpose: To reset the postion of vertical and horizontal lines when canvas size had changed
 * Parameters: java.awt.Graphics g, a superclass
 */ 
public void paint( java.awt.Graphics g)
{
	super.paint(g); // make a call to the superclass

	// reset the position of vertical line while changing the size of the canvas
	vertical_line.setEndPoints( canvas.getWidth() * proportion_vertical, 0 , canvas.getWidth() * proportion_vertical, canvas.getHeight());

	//reset the position of horizontal line while changing the size of the canvas
	horizontal_line.setEndPoints(horizontal_line_x_StartingPoint, canvas.getHeight() * proportion_horizontal, canvas.getWidth(), canvas.getHeight() * proportion_horizontal);

}// end of paint

}//end of class

