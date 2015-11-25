/* 
 * Name: Songhao Zhou 
 * Login: cs11wjc
 * Date: 3/11/2014 
 * File: CSE11_Line.java 
 * This java file is designed to includes all the necessay methods 
 * for CSE11_Line
 */ 

import java.awt.*; 
import objectdraw.*; 



/* 
 * Name: CSE11_Line 
 * Purpose: Provide 4 different kinds of constructor; also setter, 
 * getter methods
 */

public class CSE11_Line extends Shape 
{
  private Point start; 
  private Point end; 



  /* 
  * Name: CSE11_Line()
  * Purpose: This is a no-arg constructor and its purpose is to call its super
  * and set its start and end to be (0,0)
  * Parameters: None. 
  * Return: no return type
  */ 
 
  public CSE11_Line()
  {
    super();
    this.setStart( new Point(0,0) );
    this.setEnd( new Point(0,0) );   
  } 



  /* 
  * Name: CSE11_Line( Point start, Point end )
  * Purpose: This is a constructor takes Point start, Point end
  * in order to reset start and en points value
  * Parameters: None. 
  * Return: no return type
  */ 

  public CSE11_Line( Point start, Point end )
  {
    this.setStart( new Point(start));
    this.setEnd( new Point(end));    

  } 



  /* 
  * Name: CSE11_Line( CSE11_Line line )
  * Purpose: This is a copy constructor takes a CSE11_Line line which contains
  * the start and end pointsvalues that need to be copied over
  * Parameters: None. 
  * Return: no return type
  */ 

  public CSE11_Line( CSE11_Line line )
  {
    this.setStart( new Point(line.getStart()) );
    this.setEnd( new Point(line.getEnd()) );    

  } 



  /* 
  * Name:  move( int xDelta, int yDelta )
  * Purpose: This method serves a purpose that move the center point based
  * on the xDelta and yDelta
  * Parameters: None. 
  * Return: void
  */ 

  public void move( int xDelta, int yDelta ) 
  {
    this.setStart( new Point(this.getStart().getX()+xDelta, 
                             this.getStart().getY()+yDelta) );
    this.setEnd( new Point(this.getEnd().getX()+xDelta, 
                           this.getEnd().getY()+yDelta) );    
  } 
 


  /* 
  * Name:  toString()
  * Purpose: This method serves a purpose to print out the value of start
  * and end points
  * Parameters: None. 
  * Return: String
  */ 

  @Override 
  public String toString()
  {
    String s;

    s = "CSE11_Line: " + start.toString() + " to " + end.toString();

    return s;

  } 



  /* 
  * Name: equals( Object o )
  * Purpose: This method serves a purpose to equality between two classes 
  * including its class and the contents that they contained
  * upperleft
  * Parameters: None. 
  * Return: boolean
  */ 
 
  @Override 
  public boolean equals( Object o )
  {
    if( o == null)
      return false;
 
    else if( this.getClass() != o.getClass())
      return false;

    else if( ((CSE11_Line)this).getStart().equals( ((CSE11_Line)o).getStart()) 
             && ((CSE11_Line)this).getEnd().equals( ((CSE11_Line)o).getEnd()))
      return true;

    else
      return false;


  } 
 


  /* 
  * Name: hashCode()   
  * Purpose: This method serves a purpose to return an int based on toString 
  * calling hashcode() method
  * upperleft
  * Parameters: None. 
  * Return: int
  */ 

  @Override 
  public int hashCode()
  {
    return this.toString().hashCode();    
  } 
 


  /* 
  * Name: draw( DrawingCanvas canvas, Color c, boolean fill )
  * Purpose: This method serves a purpose to draw the object based on the 
  * Color c, boolean fill that get passed in
  * Parameters: None. 
  * Return: void
  */ 

  public void draw( DrawingCanvas canvas, Color c, boolean fill )
  {
    new Line( this.getStart().getX(), this.getStart().getY(), 
              this.getEnd().getX(), this.getEnd().getY(), canvas);

  }   



  /* 
  * Name: getStart()
  * Purpose: This method serves a purpose that return an int (start value)
  * Parameters: None. 
  * Return: Point
  */ 

  public Point getStart() 
  { 
    return this.start;
  }



  /* 
  * Name: getEnd()
  * Purpose: This method serves a purpose that return an int (end value)
  * Parameters: None. 
  * Return: Point
  */ 

  public Point getEnd() 
  { 
    return this.end;
  }



  /* 
  * Name: setStart( Point p )
  * Purpose: This method serves a purpose to set the start value when
  * an object has called this merhid based on formal parameter p
  * Parameters: Point x 
  * Return: void
  */ 

  private void setStart( Point p ) 
  {
    this.start = p;
  }



  /* 
  * Name: setEnd( Point p )
  * Purpose: This method serves a purpose to set the end value when
  * an object has called this merhid based on formal parameter p
  * Parameters: Point x 
  * Return: void
  */ 

  private void setEnd( Point p ) 
  {
    this.end = p;
  }

}
