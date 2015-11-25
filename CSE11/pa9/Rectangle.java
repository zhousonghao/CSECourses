/* 
 * Name: Songhao Zhou 
 * Login: cs11wjc
 * Date: 3/11/2014 
 * File: Rectangle.java 
 * This java file is designed to includes all the necessay methods 
 * for Rectangle
 */ 

import java.awt.*; 
import objectdraw.*; 



/* 
 * Name: Rectangle 
 * Purpose: Provide 4 different kinds of constructor; also setter, 
 * getter methods
 */

public class Rectangle extends ARectangle 
{
  private int width; 
  private int height; 



  /* 
  * Name: Rectangle()
  * Purpose: This is a no-arg constructor and its purpose is to call its super
  * and set its width and height to be 0
  * Parameters: None. 
  * Return: no return type
  */ 
 
  public Rectangle()
  {
    super();
    this.setWidth(0);
    this.setHeight(0);
  } 



  /* 
  * Name: Rectangle(int x, int y, int width, int height)
  * Purpose: This is a constructor takes int x, int y, int width, int height
  * in order to change the width and height
  * Parameters: None. 
  * Return: no return type
  */ 

  public Rectangle(int x, int y, int width, int height)
  {
    //call the super to store the name 
    super("Rectangle", x, y);
  
    this.setWidth(width);
    this.setHeight(height);

  } 



  /* 
  * Name: Rectangle(Point upperLeft, int width, int height)
  * Purpose: This is a constructor takes Point upperLeft, int width, int height
  * in order to change the upperleft point width and height
  * Parameters: None. 
  * Return: no return type
  */ 

  public Rectangle(Point upperLeft, int width, int height)
  {

    super("Rectangle", upperLeft);

    this.setWidth(width);
    this.setHeight(height);

  } 



  /* 
  * Name: Rectangle(Rectangle r)
  * Purpose: This is a copy constructor takes a CSE11_Line line which contains
  * the width and height that need to be copied over
  * Parameters: None. 
  * Return: no return type
  */ 

  public Rectangle(Rectangle r)
  {
    super(r);

    this.setWidth( r.getWidth() );
    this.setHeight( r.getHeight() );

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
    return super.toString() + " Width: " +width +" Height: " + height;
 

  } // super.toString() + width + height 
 


  /* 
  * Name: equals( Object o )
  * Purpose: This method serves a purpose to equality between two classes 
  * including its class and the contents that they contained
  * upperleft
  * Parameters: None. 
  * Return: boolean
  */ 

  @Override 
  public boolean equals(Object o)
  {
   if( o == null)
     return false;
 
   else if( this.getClass() != o.getClass())
     return false;

   else if( ((Rectangle)this).getWidth() == ((Rectangle)o).getWidth() && 
            ((Rectangle)this).getHeight() == ((Rectangle)o).getHeight() && 
            super.equals(o) )
     return true;

   else
     return false;

  } // super.equals() + width + height 
 


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
                                         this.getWidth() , this.getHeight(), 
                                         canvas);
      //check if c is null
      if(c != null)
        rect.setColor(c);
    
      else
        rect.setColor(Color.black);
 
    }

    else 
    {
      FramedRect rect = new FramedRect( (double)(this.getUpperLeft().getX()), 
                                        (double)(this.getUpperLeft().getY()), 
                                         this.getWidth() , this.getHeight(), 
                                         canvas);
      //check if c is null
      if(c != null)
        rect.setColor(c);
    
      else
        rect.setColor(Color.black);

    }

  }



  /* 
  * Name: getWidth()
  * Purpose: This method serves a purpose that return an int (width value)
  * Parameters: None. 
  * Return: int
  */ 

  public int getWidth()
  {
    return this.width;
  }



  /* 
  * Name: getHeight()
  * Purpose: This method serves a purpose that return an int (height value)
  * Parameters: None. 
  * Return: int
  */ 

  public int getHeight()
  {
    return this.height;
  }



  /* 
  * Name: setWidth( int w ) 
  * Purpose: This method serves a purpose to set the width value when
  * an object has called this merhid based on formal parameter w
  * Parameters: int x 
  * Return: void
  */ 

  private void setWidth( int w ) 
  {
    this.width = w;
  }



  /* 
  * Name: setHeight( int h ) 
  * Purpose: This method serves a purpose to set the height value when
  * an object has called this merhid based on formal parameter h
  * Parameters: int x 
  * Return: void
  */ 

  private void setHeight( int h ) 
  {
    this.height = h;
  }

  
}//end of class
