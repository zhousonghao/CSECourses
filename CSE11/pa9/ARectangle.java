/* 
 * Name: Songhao Zhou 
 * Login: cs11wjc
 * Date: 3/11/2014 
 * File: ARectangle.java 
 * This java file is designed to function as a superclass of square 
 * and rectangle
 */ 

import java.awt.*; 
import objectdraw.*; 



/* 
 * Name: ARectangle 
 * Purpose: Provide 4 different kinds of constructor; also setter, 
 * getter methods
 */

public abstract class ARectangle extends Shape 
{
  private Point upperLeft; // Upper left corner - 
                           // Common to all rectangular shapes 



  /* 
  * Name: ARectangle()
  * Purpose: This is a no-arg constructor and its purpose is to call its super
  * and set its Upperleft corner to be (0,0)
  * Parameters: None. 
  * Return: no return type
  */ 
 
  public ARectangle() 
  {
    super();
    this.setUpperLeft( new Point(0,0) );
  } 



  /* 
  * Name:  ARectangle( String name, int x, int y )
  * Purpose: This is a constructor takes a String name 
  * and int x,y in order to createa new Point based on x and y
  * Parameters: None. 
  * Return: no return type
  */ 

  public ARectangle( String name, int x, int y )
  {
    super(name);
    this.setUpperLeft ( new Point(x,y) );   
  } 



  /* 
  * Name:  ARectangle( String name, Point upperLeft )
  * Purpose: This is a constructor takes a String name 
  * and Point upperleft in order to createa new Point based upperleft
  * Parameters: None. 
  * Return: no return type
  */ 

  public ARectangle( String name, Point upperLeft )
  {
    super(name);
    this.setUpperLeft( new Point(upperLeft) );
  } 



  /* 
  * Name:  ARectangle( ARectangle r ) 
  * Purpose: This is a copy constructor takes a ARectangle r which contains
  * the upperleft corner that need to be copied over
  * Parameters: None. 
  * Return: no return type
  */ 

  public ARectangle( ARectangle r ) 
  {
    this.setUpperLeft( new Point(r.getUpperLeft()) );
  } 



  /* 
  * Name:  move( int xDelta, int yDelta )
  * Purpose: This method serves a purpose that move the upperleftp point based
  * on the xDelta and yDelta
  * Parameters: None. 
  * Return: void
  */ 

  public void move( int xDelta, int yDelta )
  {

    this.setUpperLeft( new Point(this.getUpperLeft().getX()+xDelta,
                       this.getUpperLeft().getY()+yDelta) );

  } 
 


  /* 
  * Name: getUpperLeft()
  * Purpose: This method serves a purpose that return a Point upperleft when
  * an object has called this merhid
  * Parameters: None. 
  * Return: Point
  */ 

  public Point getUpperLeft() 
  {
    return this.upperLeft;
  }



  /* 
  * Name:  setUpperLeft( Point p )
  * Purpose: This method serves a purpose to set the  Point upperleft when
  * an object has called this merhid based on formal parameter p
  * Parameters: Point p. 
  * Return: void
  */ 

  private void setUpperLeft( Point p )
  {
    this.upperLeft = p;
  }



  /* 
  * Name:  toString()
  * Purpose: This method serves a purpose to print out the Point value of 
  * upperleft
  * Parameters: None. 
  * Return: string
  */ 

  @Override 
  public String toString()
  {
    String s;

    s = super.getName() + ": Upper Left Corner: " + upperLeft.toString(); 

    return s; 

  } // getName() + upperLeft 
 


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
  
   //check equality of class
   else if( this.getClass() != o.getClass())
     return false;

   //check the equality of upperleft  
   else if( ((ARectangle)this).getUpperLeft() .equals(
            ((ARectangle)o).getUpperLeft()) )
     return true;

   else
     return false;

  } // std checks + upperLeft 
 


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
