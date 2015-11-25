/* 
 * Name: Songhao Zhou 
 * Login: cs11wJC
 * Date: 2/27/2014
 * File: Chaser.java 
 * Responsible for construction of the chaser and has the reactTo method which
 * implement the move when it is called
 */ 

import objectdraw.*;
import java.awt.*;
import java.lang.Math;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;



/* 
 * Name: Chaser
 * Purpose:  Responsible for construction of the chaser and has the reactTo 
 * method which implement the move when it is called. 
 */

public class Chaser extends Critter implements ActionListener
{
  //declare the chaser as a FilledRect
  private FilledRect chaser;
  private static final double WIDTH = 15;
  private static final double HEIGHT = 15;
  private double move_in_x =0;
  private double move_in_y =0;
 
  private static final int TWO = 2;  

  private double check_distance;

  //the booleans to check states
  private boolean cleared;
  private boolean stop_button_clicked;



  /* 
  * Name: Chaser
  * Purpose: it is the constructor that creates a FilledRect each time chaser 
  * is created. Then set its color to cyan
  */

  public Chaser(Location loc , DrawingCanvas canvas) 
  {
    //save its center loc and canvas to its parent critter
    super(loc ,canvas);
 
    chaser = new FilledRect(loc.getX()-WIDTH/TWO, loc.getY()-HEIGHT/TWO, WIDTH, 
                            HEIGHT, canvas);
    //set color
    chaser.setColor(Color.cyan);
  }



  /* 
  * Name: reactTo
  * Purpose: This method taks charge of movement that current critter needs to
  * take and then move to that corresponding direction
  * Parameters: Critter other, we need this method to determine the action
  * based on which typr is other critter
  * Return: void
  */
  public void reactTo(Critter other) 
  { 
    //check the null situation
    if (other == null) 
        return; 

    synchronized(this)
    { 
      //in case other is on the right side of the critter, move along
      if(other.getLoc().getX() - this.getLoc().getX() >= 0) 
      {
        move_in_x = 1;
      }  
  
      //in case other is on the left side of the critter, move along
      else if(other.getLoc().getX()- this.getLoc().getX() < 0)
      {
        move_in_x = -1;
      }


      //in case other is on the upper side of the critter, move along
      if(other.getLoc().getY()- this.getLoc().getY() >= 0)
      {
        move_in_y = 1;
      }

      //in case other is on the lower side of the critter, move along
      else if(other.getLoc().getY()- this.getLoc().getY() < 0)
      {
        move_in_y = -1;
      }


      //move the critter
      this.chaser.move( move_in_x, move_in_y);

      //create a center location
      Location this_new_loc = new Location (this.getLoc().getX()+move_in_x, 
                                            this.getLoc().getY()+move_in_y);
      //update the center location
      this.setLoc(this_new_loc);

     }

  }//end of reactTo



  /* 
  * Name: actionPerformed 
  * Purpose: Once the clear button is clicked the remove the critter from 
  * canvas
  * Parameters: ActionEvent evt. we need this parameter in order to
  * determine which button has been clicked
  * Return: void 
  */

  public void actionPerformed( ActionEvent evt ) 
  {
    //check if clear button is clicked
    if(evt.getActionCommand() .equals( "Clear") && cleared == false)
    {
      chaser.removeFromCanvas();
      cleared = true;
    }

  }

}//end of class
