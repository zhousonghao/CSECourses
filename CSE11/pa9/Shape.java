/* 
 * Name: Songhao Zhou 
 * Login: cs11wjc
 * Date: 3/11/2014 
 * File: Shape.java 
 * This java file is designed as a superclass of other instance of shapes. In
 * this abstract class shape's duty is to hold the name of its subclasses
 */ 

import java.awt.*; 
import objectdraw.*; 



/* 
 * Name: Shape 
 * Purpose: Provide 2 different kinds of constructor and setter, getter methods
 */

public abstract class Shape 
{
  private String name; 


  
  /* 
  * Name: Shape()
  * Purpose: This is a no-arg constructor and its purpose is to get the name
  * of the class that called this constructor
  * Parameters: None. 
  * Return: no return type
  */ 

  public Shape() 
  {
    this.setName (this.getClass().getName());

  } 



  /* 
  * Name: Shape( String name )
  * Purpose: This is a constructor and its purpose is to get the name
  * of the class that called this constructor with a String name passed in
  * Parameters: String name 
  * Return: no return type
  */ 

  public Shape( String name )
  {
    this.setName (name);

  } 



  /* 
  * Name: getName()
  * Purpose: This is a getter and its purpose is to get the name
  * of the class from instance variable name
  * Parameters: None 
  * Return: String
  */ 

  public String getName()
  { 
    return this.getClass().getName();
  } 
 


  /* 
  * Name: setName( String name ) 
  * Purpose: This is a setter and its purpose is to set the name
  * of the class from a String name that is passed in
  * Parameters: String name 
  * Return: Void
  */ 

  private void setName( String name ) 
  { 
    this.name = name;
  } 



  /* Copy this as is in your Shape.java */ 
  /* 
  * Name: equals( Object o )
  * Purpose: This method serves a purpose to check if the @override methods 
  * have written properly
  * Parameters: Object o. 
  * Return: boolean
  */ 
  @Override 
  public boolean equals( Object o ) 
  { 
  String s = "\n**********************************************************\n" 
  + "This should never print. If it does print, then\n" 
  + "you did not override equals() properly in class " 
  + this.getClass().getName() + "\n" 
  + "**********************************************************\n"; 
  System.out.println( s ); 
  return this == o; 
  } 
 


  /* 
  * Name: move( int xDelta, int yDelta )
  * Purpose: move the point (no body, since it's abstract)
  * Parameters: int xDelta, int yDelta 
  * Return: Void
  */ 

  public abstract void move( int xDelta, int yDelta ); 



  /* 
  * Name: draw( DrawingCanvas canvas, Color c, boolean fill )
  * Purpose: draw the object base on its shape (no body, since it's abstract)
  * Parameters: DrawingCanvas canvas, Color c, boolean fill
  * Return: Void
  */ 

  public abstract void draw( DrawingCanvas canvas, Color c, boolean fill );

}//end of class
