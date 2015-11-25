/* 
 * Name: Songhao Zhou 
 * Login: cs11wJC
 * Date: 2/27/2014
 * File: CrittersSimulator.java 
 * Responsible for calculating the closest critter in the arraylist and once 
 * it has the index that points to those two critters it will then call the 
 * reactTo method that in each critter class.
 */ 

import objectdraw.*;
import java.awt.*;
import objectdraw.*;
import java.awt.*;
import java.lang.Math;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;



/* 
 * Name: CrittersSimulator
 * Purpose: it is mainly an activeobject which has a run method which runs all
 * the time at which it finds the closest critters and then call the reactTo 
 * method
 */

public class CrittersSimulator extends ActiveObject
{
  //declare constants 
  private static final int DELAY = 50;
  private static final int TWO = 2;  

  //declare a critters arraylist in order to store the arraylist that passed 
  private ArrayList<Critter> critters;

  //decalre the variables to find the min distance
  private double min_distance;
  private double temp_distance;
  private int temp_i;
  private int temp_j;
  private int min_i;
  private int min_j;

  //the boolean to check whether stop button has been clicked 
  private static boolean stop_button_clicked;
  private boolean check_stopclick;



  /* 
  * Name: CrittersSimulator
  * Purpose: it is the constructor which store the critters arraylsit and then
  * set the min_distance to the max value
  * Parameters: ArrayList<Critter> critters, in order to check which 2 critters
  * are the closest
  * Return: void
  */

  public CrittersSimulator( ArrayList<Critter> critters ) 
  {
    this.critters = critters;
    min_distance = Double.MAX_VALUE;

    start(); //start the animation 
  }



  /* 
  * Name: setboolean
  * Purpose: This method is for updating the status of stop button which need
  * to be checked to determine whether run method should be in action
  * Parameters: boolean boovalue, update the stop button status
  * Return: void
  */

  public static void setboolean (boolean boovalue)
  {
    stop_button_clicked = boovalue;
  }



  /* 
  * Name: run() 
  * Purpose: Responsible for calculating the closest critter in the arraylist
  * and once it has the index that points to those two critters it will then
  * call the reactTo method that in each critter class.
  * Parameters: none
  * Return: void 
  */

  public void run()
  {
    while(true) 
    {
      //set the pause time
      pause(DELAY);
  
      //check if the size of critters is > 2 and stop button status
      if(critters.size() >= TWO && !stop_button_clicked )
      {
        //the first loop to go through the arraylist
        for( int i =0; i < critters.size() ; i++ )
        {
          //the second loop to go through the arraylist
          for( int j=0; j < critters.size() ; j++ )
          {
            //skip the case where i = j (itself)
            if( i == j )
            continue;
 
            //skip the case where two objects are chasers
            if( critters.get(i).getClass().getName().equals("Chaser") &&
                critters.get(j).getClass().getName().equals("Chaser") )
            continue;

            //calculate for the distance 
            else         
            {
              temp_distance = (critters.get(i).getLoc()).distanceTo(
                               critters.get(j).getLoc());
              temp_i = i;
              temp_j = j;
             
              //update the closest distance and save the index
              if(temp_distance < min_distance)
              {
                min_distance = temp_distance;
                min_i = i;
                min_j = j;
              }

            }

          }// end of for loop j
 
          //reset the min_distance
          min_distance = Double.MAX_VALUE;
        
          //not calling reactTo if two objects are chasers
          if( critters.get(i).getClass().getName().equals("Chaser") && 
              critters.get(min_j).getClass().getName().equals("Chaser") )
            continue;

          else
            critters.get(i).reactTo(critters.get(min_j));
    
        }//end of i for loop

      }//end of if check
  
    }//end of whiile true
  
  }//end of run 

}//end of class
