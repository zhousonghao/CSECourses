/* 
 * Name: Songhao Zhou 
 * Login: cs11wJC
 * Date: 2/27/2014
 * File: Runner.java 
 * Responsible for construction of the runner and has the reactTo method which
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
 * Name: Runner
 * Purpose:  Responsible for construction of the runner and has the reactTo 
 * method which implement the move when it is called. 
 */

public class Runner extends Critter implements ActionListener
{
  //declare the chaser as a FilledOval
  private FilledOval runner;
  private static final double WIDTH = 15;
  private static final double HEIGHT = 15;
  private double move_in_x =0;
  private double move_in_y =0;
  private DrawingCanvas canvas;

  private static final int TWO = 2;  

  //declare the random generator
  private RandomDoubleGenerator randDouble_x;
  private RandomDoubleGenerator randDouble_y;

  //set the random generator conditions
  private static final double RAN_BEGIN = 100;
  private static final double RAN_END = 400;

  //booleans to check for state
  private boolean cleared;
  private boolean stop_button_clicked;


  /* 
  * Name: Runner
  * Purpose: it is the constructor that creates a FilledOval each time chaser 
  * is created. Then set its color to magenta. and then create 2 random
  * double generator
  */

  public Runner(Location loc , DrawingCanvas canvas) 
  {
    //save its center loc and canvas to its parent critter
    super(loc ,canvas);

    //save canvas
    this.canvas = canvas;

    runner = new FilledOval(loc.getX()-WIDTH/TWO, loc.getY()-HEIGHT/TWO, WIDTH, 
                            HEIGHT, canvas);

    //set color
    runner.setColor(Color.magenta);

    //construct new random generator
    randDouble_x = new RandomDoubleGenerator(RAN_BEGIN, 
                                             RAN_END);

    randDouble_y = new RandomDoubleGenerator(RAN_BEGIN, 
                                             RAN_END);
  }



  /* 
  * Name: reactTo
  * Purpose: This method taks charge of movement that current critter needs to
  * take and then move to that corresponding direction. When the critter goes
  * off the canvas, it will be moved to a position which is generated by random
  * generator
  * Parameters: Critter other, we need this method to determine the action
  * based on which typr is other critter
  * Return: void
  */

  public void reactTo(Critter other) 
  {
    if (other == null)
        return; 

    synchronized(this)
    {
      //if statement to check if the critter is within the bound
      if ( this.runner.getX()+WIDTH <= canvas.getWidth() &&  
           this.runner.getX() >= 0 && 
           this.runner.getY()+WIDTH <= canvas.getHeight() && 
           this.runner.getY() >= 0 )
      { 
        //in case other is on the right side of the critter, move opposite
        if(other.getLoc().getX()- this.getLoc().getX() >= 0) 
        {
          move_in_x = -1;
        }  

        //in case other is on the left side of the critter, move opposite
        else if(other.getLoc().getX()- this.getLoc().getX() < 0)
        {
          move_in_x = 1;
        }

        //in case other is on the upper side of the critter, move opposite
        if(other.getLoc().getY()- this.getLoc().getY() >= 0)
        {
          move_in_y = -1;
        }


        //in case other is on the lower side of the critter, move opposite
        else if(other.getLoc().getY()- this.getLoc().getY() < 0)
        {
          move_in_y = 1;
        }

        //move the critter
        this.runner.move( move_in_x, move_in_y);

        //move the critter
        Location this_new_loc = new Location (this.getLoc().getX()+move_in_x, 
                                              this.getLoc().getY()+move_in_y);

        //update the center location
        this.setLoc(this_new_loc);
      }

      //in the case where the critter goes off the bound
      else
      {
        double x = randDouble_x.nextValue();
        double y = randDouble_y.nextValue();
     
        //move the critter
        this.runner.moveTo(x, y);

        //move the critter
        Location this_new_loc2 = new Location (x+WIDTH/TWO, y+WIDTH/TWO);

        //update the center location
        this.setLoc(this_new_loc2); 
      }
    
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
    if(evt.getActionCommand() .equals( "Clear") && cleared == false)
    {
      runner.removeFromCanvas();
      cleared = true;
    }

  }//end of action performed

}//end of class
