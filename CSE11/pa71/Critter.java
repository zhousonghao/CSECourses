/* 
 * Name: Songhao Zhou 
 * Login: cs11wJC
 * Date: 2/27/2014
 * File: Critter.java 
 * it is the parent of the three critters which inherits all its methods
 */ 

import objectdraw.*;
import objectdraw.*;
import java.awt.*;
import java.lang.Math;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;



/* 
 * Name: Critter
 * Purpose:  store the updated loc and provide seLoc and getLoc methods
 */

public abstract class Critter 
{
  //declare protected pt
  protected Location pt;
  protected DrawingCanvas canvas;



  /* 
  * Name: Critter
  * Purpose: save the orginal center pt when each critter is created
  */

  public Critter(Location loc, DrawingCanvas canvas)
  {
    pt = loc;
    this.canvas = canvas;

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

  public abstract void reactTo(Critter other); 
 


  /* 
  * Name: getLoc
  * Purpose: return the critter center location when called
  * Parameters: None
  * Return: Location
  */

  public Location getLoc()
  {
    return pt;
  }



  /* 
  * Name: getLoc
  * Purpose: update the center of critter
  * Parameters: Location loc, this parameter is used to update the center loc
  * Return: Void
  */
 public void setLoc(Location loc)
  {
    pt = loc; //reset the pt
  }

}//end of class
