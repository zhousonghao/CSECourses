/* 
 * Name: Songhao Zhou 
 * Login: cs11wjc
 * Date: 3/11/2014 
 * File: Triangle.java 
 * This java file is designed to includes all the necessay methods 
 * for Triangle
 */ 

import java.awt.*; 
import objectdraw.*; 
public class Triangle extends Shape 
{
  private Point p1; 
  private Point p2; 
  private Point p3; 



  /* 
  * Name: Triangle()
  * Purpose: This is a no-arg constructor and its purpose is to call its super
  * and set its p1,p2,p3 to be (0,0)
  * Parameters: None. 
  * Return: no return type
  */ 
 
  public Triangle()
  {
    super();
    this.setP1( new Point(0, 0) );
    this.setP2( new Point(0, 0) );
    this.setP3( new Point(0, 0) );

  } 



  /* 
  * Name: Triangle( Point p1, Point p2, Point p3 )
  * Purpose: This is a constructor takes Point p1, Point p2, Point p3
  * in order to change its all three points
  * Parameters: None. 
  * Return: no return type
  */ 

  public Triangle( Point p1, Point p2, Point p3 ) 
  {
    this.setP1( new Point(p1) );
    this.setP2( new Point(p2) );
    this.setP3( new Point(p3) );

  } 



  /* 
  * Name: Triangle( Triangle tri )
  * Purpose: This is a copy constructor takes a Triangle( Triangle tri )
  * which contains all three points that need to be copied over
  * Parameters: None. 
  * Return: no return type
  */ 

  public Triangle( Triangle tri )
  {
    this.setP1( new Point(tri.getP1()) );
    this.setP2( new Point(tri.getP2()) );
    this.setP3( new Point(tri.getP3()) );

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
    this.setP1( new Point(this.getP1().getX()+xDelta, this.getP1().getY()+
                          yDelta) );
    this.setP2( new Point(this.getP2().getX()+xDelta, this.getP2().getY()+
                          yDelta) );
    this.setP3( new Point(this.getP3().getX()+xDelta, this.getP3().getY()+
                          yDelta) );

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

    s = "Triangle: " + p1.toString() + ", " + p2.toString() + ", " + 
        p3.toString();

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

    else if( ((Triangle)this).getP1() .equals( ((Triangle)o).getP1()) && 
             ((Triangle)this).getP2() .equals( ((Triangle)o).getP2()) && 
             ((Triangle)this).getP3().equals( ((Triangle)o).getP3()) )
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
    if(c != null)
    {
      Line line1 = new Line( this.getP1().getX(), this.getP1().getY(), 
                             this.getP2().getX(), this.getP2().getY(), canvas);
      Line line2 = new Line( this.getP2().getX(), this.getP2().getY(), 
                             this.getP3().getX(), this.getP3().getY(), canvas);
      Line line3 = new Line( this.getP3().getX(), this.getP3().getY(), 
                             this.getP1().getX(), this.getP1().getY(), canvas);

      line1.setColor(c);
      line2.setColor(c);
      line3.setColor(c);
    }

    else
    {
      Line line1 = new Line( this.getP1().getX(), this.getP1().getY(), 
                             this.getP2().getX(), this.getP2().getY(), canvas);
      Line line2 = new Line( this.getP2().getX(), this.getP2().getY(), 
                             this.getP3().getX(), this.getP3().getY(), canvas);
      Line line3 = new Line( this.getP3().getX(), this.getP3().getY(), 
                             this.getP1().getX(), this.getP1().getY(), canvas);

      line1.setColor(Color.black);
      line2.setColor(Color.black);
      line3.setColor(Color.black);
  
    }


  }



  /* 
  * Name: getP1()
  * Purpose: This method serves a purpose that return an point (p1 value)
  * Parameters: None. 
  * Return: Point
  */ 

  public Point getP1()
  {
    return this.p1;
  }



  /* 
  * Name: getP2()
  * Purpose: This method serves a purpose that return an point (p2 value)
  * Parameters: None. 
  * Return: Point
  */ 

  public Point getP2()
  {
    return this.p2;
  }



  /* 
  * Name: getP3()
  * Purpose: This method serves a purpose that return an point (p3 value)
  * Parameters: None. 
  * Return: Point
  */ 

  public Point getP3()
  {
    return this.p3;
  }



  /* 
  * Name: setP1( Point p1 )
  * Purpose: This method serves a purpose to set the p1 value when
  * an object has called this merhid based on formal parameter p1
  * Parameters: point x 
  * Return: void
  */ 

  private void setP1( Point p1 ) 
  {
    this.p1 = p1;
  }



  /* 
  * Name: setP2( Point p2 )
  * Purpose: This method serves a purpose to set the p2 value when
  * an object has called this merhid based on formal parameter p2
  * Parameters: int x 
  * Return: void
  */ 

  private void setP2( Point p2 ) 
  {
    this.p2 = p2;
  }



  /* 
  * Name: setP3( Point p3 )
  * Purpose: This method serves a purpose to set the p3 value when
  * an object has called this merhid based on formal parameter p3
  * Parameters: int x 
  * Return: void
  */ 

  private void setP3( Point p3 ) 
  {
    this.p3 = p3;
  }

}//end of class
