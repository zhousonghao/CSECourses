/* 
 * Name: Songhao Zhou 
 * Login: cs11wjc
 * Date: 3/11/2014 
 * File: Square.java 
 * This java file is designed to includes all the necessay methods 
 * for Square
 */ 

import java.awt.*; 
import objectdraw.*;



/* 
 * Name: Square 
 * Purpose: Provide 4 different kinds of constructor; also setter, 
 * getter methods
 */
 
public class Square extends ARectangle 
{
  private int side; 



  /* 
  * Name: Square()
  * Purpose: This is a no-arg constructor and its purpose is to call its super
  * and set its side to be 0
  * Parameters: None. 
  * Return: no return type
  */ 
 
  public Square()
  {
    super();
    this.setSide(0);

  } 



  /* 
  * Name: Square( int x, int y, int side )
  * Purpose: This is a constructor takes int x, int y, int side
  * in order to change the side and upperleft corner
  * Parameters: None. 
  * Return: no return type
  */ 

  public Square( int x, int y, int side )
  {
    super("Square", x, y);
    this.setSide(side);
  } 



  /* 
  * Name: Square( Point upperLeft, int side )
  * Purpose: This is a constructor takes  Point upperLeft, int side
  * in order to change the upperleft point and side
  * Parameters: None. 
  * Return: no return type
  */ 

  public Square( Point upperLeft, int side )
  {
    super("Square", upperLeft);

    this.setSide(side);
  } 



  /* 
  * Name: Square( Square r )
  * Purpose: This is a copy constructor takes a Square r which contains
  * the side and upperleft corner that need to be copied over
  * Parameters: None. 
  * Return: no return type
  */ 

  public Square( Square r )
  {
    super("Square", r.getUpperLeft() );

    this.setSide(r.getSide());

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
    return super.toString() + " Sides: " + side;

  } // super.toString() + side 



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

    else if( ((Square)this).getSide() == ((Square)o).getSide() && 
             super.equals(o) )
      return true;

    else
      return false;


  } // super.equals() + side
  


  /* 
  * Name: draw( DrawingCanvas canvas, Color c, boolean fill )
  * Purpose: This method serves a purpose to draw the object based on the 
  * Color c, boolean fill that get passed in
  * Parameters: None. 
  * Return: void
  */ 

  public void draw( DrawingCanvas canvas, Color c, boolean fill )
  {
    if(fill)
    {
      FilledRect rect = new FilledRect( (double)(this.getUpperLeft().getX()), 
                                        (double)(this.getUpperLeft().getY()), 
                                         this.getSide() , this.getSide(), 
                                         canvas);
      //check if color is null
      if(c != null)
        rect.setColor(c);
    
      else
        rect.setColor(Color.black);

    }

    else 
    {
      FramedRect rect = new FramedRect( (double)(this.getUpperLeft().getX()), 
                                        (double)(this.getUpperLeft().getY()), 
                                         this.getSide() , this.getSide(), 
                                         canvas);
      //check if color is null
      if(c != null)
        rect.setColor(c);
    
      else
        rect.setColor(Color.black);

    } 

  }



  /* 
  * Name: getSide()
  * Purpose: This method serves a purpose that return an int (side value)
  * Parameters: None. 
  * Return: int
  */ 

  public int getSide()
  {
    return this.side;
  }



  /* 
  * Name: setSide( int side ) 
  * Purpose: This method serves a purpose to set the side value when
  * an object has called this merhid based on formal parameter side
  * Parameters: int x 
  * Return: void
  */ 

  private void setSide( int side ) 
  {
    this.side = side;
  }
 

}
