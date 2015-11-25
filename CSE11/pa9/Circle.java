/* 
 * Name: Songhao Zhou 
 * Login: cs11wjc
 * Date: 3/11/2014 
 * File: Circle.java 
 * This java file is designed to includes all the necessay methods for circle
 */ 



import java.awt.*; 
import objectdraw.*; 



/* 
 * Name: Circle 
 * Purpose: Provide 4 different kinds of constructor; also setter, 
 * getter methods
 */

public class Circle extends Shape 
{
  private Point center; 
  private int radius; 
 


  /* 
  * Name: Circle()
  * Purpose: This is a no-arg constructor and its purpose is to call its super
  * and set its Upperleft corner to be (0,0), radius to 0
  * Parameters: None. 
  * Return: no return type
  */ 

  public Circle()
  {
    //call super and then set its center and radius
    super();
    this.setCenter(new Point(0,0));
    this.setRadius(0);
  } 



  /* 
  * Name: Circle( Point center, int radius )
  * Purpose: This is a constructor takesPoint center, int radius
  * in order to create a new Point based center and radius
  * Parameters: None. 
  * Return: no return type
  */ 

  public Circle( Point center, int radius )
  { 
    this.setCenter( new Point(center) );
    this.setRadius( radius );
  } 



  /* 
  * Name: Circle( Circle c )
  * Purpose: This is a copy constructor takes a Circle c which contains
  * the center and radius that need to be copied over
  * Parameters: None. 
  * Return: no return type
  */ 

  public Circle( Circle c )
  {
    
    this.setCenter( new Point(c.getCenter()) );  
    this.setRadius( c.getRadius() );
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
    this.setCenter( new Point(this.getCenter().getX()+xDelta,
                    this.getCenter().getY()+yDelta));
  } 
 


  /* 
  * Name:  toString()
  * Purpose: This method serves a purpose to print out the center point of 
  * Parameters: None. 
  * Return: String
  */ 

  @Override 
  public String toString()
  {
    String s;

    s = super.getName() + ": Center: " + center.toString() + ";" + " Radius: "
        + radius; 

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

    //check the equality of centers and radius between 2 circles
    else
    {
      return (((Circle)this).getCenter()).equals(((Circle)o).getCenter()) &&
             (((Circle)this).getRadius()) == ((Circle)o).getRadius();
    }

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
    //if filled then draw a filled oval
    if(fill)
    {
      FilledOval oval = new FilledOval( center.getX()-radius, 
                                        center.getY()-radius, 2*radius ,
                                        2*radius, canvas);
      oval.setColor(c);
    }

    //otherwise draw a framed oval
    else 
    {
      FramedOval oval = new FramedOval( center.getX()-radius, 
                                        center.getY()-radius, 2*radius ,
                                        2*radius, canvas);
      oval.setColor(c);
    }
  }



  /* 
  * Name: getRadius()
  * Purpose: This method serves a purpose that return a int (radius value)
  * Parameters: None. 
  * Return: int
  */ 

  public int getRadius()
  {
    return this.radius;
  }



  /* 
  * Name: getCenter()
  * Purpose: This method serves a purpose that return a point (center value)
  * Parameters: None. 
  * Return: Point
  */ 

  public Point getCenter()
  {
    return this.center;

  }



  /* 
  * Name: setRadius( int radius)
  * Purpose: This method serves a purpose to set the radius value when
  * an object has called this merhid based on formal parameter radius
  * Parameters: int radius 
  * Return: void
  */ 

  public void setRadius( int radius)
  {
    this.radius = radius;

  }



  /* 
  * Name: setRadius( int radius)
  * Purpose: This method serves a purpose to set the center value when
  * an object has called this merhid based on formal parameter center
  * Parameters: Point p. 
  * Return: void
  */ 

  public void setCenter( Point center)
  {
    this.center = center;
  }

}
