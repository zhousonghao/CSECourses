/* 
 * Name: Songhao Zhou 
 * Login: cs11wjc
 * Date: 3/11/2014 
 * File: Point.java 
 * This java file is designed to includes all the necessay methods for Point
 */ 

import java.awt.*; 
import objectdraw.*; 



/* 
 * Name: Point 
 * Purpose: Provide 4 different kinds of constructor; also setter, 
 * getter methods
 */

public class Point 
{ 
  private int x; 
  private int y; 



  /* 
  * Name: Point()
  * Purpose: This is a no-arg constructor and its purpose is to call its super
  * and set its x and y to be 0
  * Parameters: None. 
  * Return: no return type
  */ 

  public Point()
  { 
    this.setX(0);
    this.setY(0);
  } 
 


  /* 
  * Name: Point( int x, int y )
  * Purpose: This is a constructor takes int x, int y
  * in order to reset x and y value
  * Parameters: None. 
  * Return: no return type
  */ 

  public Point( int x, int y )
  {
    this.setX(x);
    this.setY(y);
  } 



  /* 
  * Name: Circle( Circle c )
  * Purpose: This is a copy constructor takes a Point point which contains
  * the x and y values that need to be copied over
  * Parameters: None. 
  * Return: no return type
  */ 

  public Point( Point point )
  {
    this.setX( point.getX() );
    this.setY( point.getY() );
  } 



  /* 
  * Name: getX()
  * Purpose: This method serves a purpose that return an int (x value)
  * Parameters: None. 
  * Return: int
  */ 

  public int getX()
  {
    return this.x;

  } 



  /* 
  * Name: getX()
  * Purpose: This method serves a purpose that return an int (y value)
  * Parameters: None. 
  * Return: int
  */ 

  public int getY()
  {
    return this.y;

  } 



  /* 
  * Name: setX( int x )
  * Purpose: This method serves a purpose to set the x value when
  * an object has called this merhid based on formal parameter x
  * Parameters: int x 
  * Return: void
  */ 

  private void setX( int x )
  {
    this.x = x;

  } // Private! so Points are immutable 



  /* 
  * Name: setY( int y )
  * Purpose: This method serves a purpose to set the y value when
  * an object has called this merhid based on formal parameter y
  * Parameters: int y
  * Return: void
  */ 

  private void setY( int y )
  { 
    this.y = y;

  } // Private! so Points are immutable 



  /* 
  * Name:  move( int xDelta, int yDelta )
  * Purpose: This method serves a purpose that move the center point based
  * on the xDelta and yDelta
  * Parameters: None. 
  * Return: void
  */ 

  public void move( int xDelta, int yDelta )
  {
    this.setX(this.getX()+xDelta);
    this.setY(this.getY()+yDelta);
  } 
 


  /* 
  * Name:  toString()
  * Purpose: This method serves a purpose to print out the value of point
  * Parameters: None. 
  * Return: String
  */ 

  @Override 
  public String toString()
  {
    String s;

    s = "Point: (" + this.x + "," + this.y + ")";
 
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

    else if( ((Point)this).getX() == ((Point)o).getX() && 
             ((Point)this).getY() == ((Point)o).getY() )
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

}//end of class
