/* 
 * Name: Songhao Zhou 
 * Login: cs11wJC
 * Date: 2/27/2014
 * File: CritterController.java 
 * Responsible for contructing the chaser,runner and random.
 * it also add all three classes to be listeners to the 6 buttons, which
 * are start, stop, clear, chaser, runner and random. 
 * Besides those GUI stuff, the constructor also responsible for the 
 * layouts of the canvas.
 */ 

import objectdraw.*;
import java.awt.*;
import java.lang.Math;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;



/* 
 * Name: CrittersController
 * Purpose: it acts like a brain of the rest of its components. it sets
 * all the layouts, button, panels, create arraylists and then pass 
 * necessary booleans to the corresponding method
 */

public class CrittersController extends WindowController 
implements ActionListener,MouseListener,MouseMotionListener
{
  //initialize constants
  private static final int ONE = 1;
  private static final int TWO = 2;
  private static final int THREE = 3;

  //declare the GUI buttons, panels, and labels
  private JButton start_Button, stop_Button, clear_Button;
  private JButton chaser_Button, runner_Button, random_Button;
  
  private boolean chaser_button_clicked;
  private boolean runner_button_clicked;
  private boolean random_button_clicked;

  private JLabel north_label;
  private JLabel south_label;

  //initialize the boolean flag check
  private boolean stop_button_clicked; 

  //declare the arraylist of critters
  private ArrayList<Critter> critters;



  /* 
  * Name: begin()
  * Purpose: In the begin, it sets the names of each button then set the 
  * panels that contains those buttons and finaly set the layout of each
  * panel in the canvas container. Also, we add the buttons listeners in
  * order to be able to respond to the actionperform actions
  * Parameters: none
  * Return: void
  */

  public void begin()
  {
    //buttons
    start_Button = new JButton( "Start" );
    stop_Button = new JButton( "Stop" );
    clear_Button = new JButton( "Clear"); 
    chaser_Button = new JButton("Chaser");
    runner_Button = new JButton("Runner");
    random_Button = new JButton("Random");
  
    //panels
    JPanel north_panel = new JPanel(new GridLayout( ONE, TWO ));
    JPanel south_panel = new JPanel(); 
    south_panel.setLayout (new GridLayout( TWO, ONE ));

    JPanel north_text_Panel = new JPanel();
    JPanel north_button_Panel = new JPanel(new GridLayout( ONE, THREE ));    
    JPanel south_text_Panel = new JPanel();
    JPanel south_button_Panel = new JPanel(new GridLayout( ONE, THREE ));
    
    //labels
    north_label = new JLabel( "Please add two or more critters." );
    south_label = new JLabel( "Select which critter to place" );
    
    //add to panel south
    south_text_Panel.add(south_label);
    south_button_Panel.add(chaser_Button);
    south_button_Panel.add(runner_Button);
    south_button_Panel.add(random_Button);

    south_panel.add(south_text_Panel);
    south_panel.add(south_button_Panel);

    //add to pane north
    north_text_Panel.add(north_label);
    north_button_Panel.add(start_Button);
    north_button_Panel.add(stop_Button);
    north_button_Panel.add(clear_Button); 
  
    north_panel.add(north_text_Panel);
    north_panel.add(north_button_Panel);     

    //container
    Container contentPane = getContentPane();
    contentPane.add(north_panel, BorderLayout.NORTH);
   	
    contentPane.add(south_panel, BorderLayout.SOUTH);	
    contentPane.validate();

    //add mouse action events
    canvas.addMouseListener ( this );
    canvas.addMouseMotionListener ( this );	

    start_Button.addActionListener( this );
    stop_Button.addActionListener( this );
    clear_Button.addActionListener( this );
    chaser_Button.addActionListener( this );
    runner_Button.addActionListener( this );	
    random_Button.addActionListener( this );	

    //create a new arraylist of critters 
    critters = new ArrayList<Critter>(); 

    //pass the critter arraylist to the critterssimulator
    CrittersSimulator simulator = new CrittersSimulator(critters);
    
  }
  


  /* 
  * Name: mouseClicked 
  * Purpose: In mouseClciked, we need to flags(booleans) to determine which
  * critter button has user click. And to create a new critter base on 
  * which critter user has selected
  * Parameters: MouseEvent evt, this parameter is used to determine the 
  * location that mouse is clicked at.
  * Return: void. 
  */

  public void mouseClicked( MouseEvent evt ) 
  {
    // declare every critter type 	
    Chaser chaser;
    Runner runner;
    Random random;
 
    //declare a local loc to pass the location
    Location loc;

    // in case the chaser button is clicked, then created a chaser
    if(chaser_button_clicked && !runner_button_clicked &&
      !random_button_clicked )
    {
      //set new location and create a new chaser
      loc = new Location(evt.getX(), evt.getY());
      chaser = new Chaser( loc, canvas);
      
      //add chaser to the arraylist 
      critters.add(chaser);

      //set stop_button_clicked to be false if arraylist size is > 2
      if(critters.size() >= TWO )
      {
        north_label.setText("Simulation is running.");
        stop_button_clicked = false; 
        CrittersSimulator.setboolean(stop_button_clicked);
      }

      //add buttons to the listener
      start_Button.addActionListener( chaser );
      stop_Button.addActionListener( chaser );
      clear_Button.addActionListener( chaser );
    }

    // in case the runner button is clicked, then created a runner
    if(runner_button_clicked && !chaser_button_clicked && 
       !random_button_clicked )
    {
      //set new location and create a new runner
      loc = new Location(evt.getX(), evt.getY());
      runner = new Runner( loc, canvas);

      //add runner to the arraylist 
      critters.add(runner);

      //set stop_button_clicked to be false if arraylist size is > 2
      if(critters.size() >= TWO )
      {
        north_label.setText("Simulation is running.");
        stop_button_clicked = false;   
        CrittersSimulator.setboolean(stop_button_clicked);  
      }	

      //add buttons to the listener
      start_Button.addActionListener( runner );
      stop_Button.addActionListener( runner );
      clear_Button.addActionListener( runner );	
    }
 
    // in case the random button is clicked, then created a runner
    if(random_button_clicked && !chaser_button_clicked &&
       !runner_button_clicked )
    {
      //set new location and create a new random
      loc = new Location(evt.getX(), evt.getY());
      random = new Random( loc, canvas); 

      //add random to the arraylist 
      critters.add(random);	

      //set stop_button_clicked to be false if arraylist size is > 2
      if(critters.size() >= TWO )
      {
        north_label.setText("Simulation is running.");
        stop_button_clicked = false;    
        CrittersSimulator.setboolean(stop_button_clicked);
      }

      //add buttons to the listener
      start_Button.addActionListener( random );
      stop_Button.addActionListener( random );
      clear_Button.addActionListener( random );	
    }

  }//end of mouseClicked



  /* 
  * Name: actionPerformed 
  * Purpose: respond to the situation where click on criiter has pressed
  * if one criiter button is clicked then set rest of 2 critter buttons
  * to false in order to avoid the situation where one mouseclick creates
  * multiple critters
  * Parameters: ActionEvent evt. we need this parameter in order to
  * determine which button has been clicked
  * Return: void 
  */

  public void actionPerformed( ActionEvent evt )
  {

   //in case the chaser button is clicked
   if(evt.getSource() == chaser_Button)
   {
     //set text label on south
     south_label.setText( "Click on canvas to place a Chaser");
    
     //set booleans for each critter button
     chaser_button_clicked = true;
     random_button_clicked = false;
     runner_button_clicked = false;

   }

   else if(evt.getSource() == runner_Button)
   {
     //set text label on south
     south_label.setText( "Click on canvas to place a Runner");

     //set booleans for each critter button
     runner_button_clicked = true;
     random_button_clicked = false;
     chaser_button_clicked = false;

   }

   else if(evt.getSource() == random_Button)
   {
     //set text label on south
     south_label.setText( "Click on canvas to place a Random");

     //set booleans for each critter button
     random_button_clicked = true;
     runner_button_clicked = false;
     chaser_button_clicked = false;
   }

   else	if(evt.getSource() == clear_Button)
   {	
     //set text label on north
     north_label.setText("Add more critters.");     
      
     //clear the arraylist
     critters.clear();
   }


   else	if(evt.getSource() == stop_Button)
   {	
     //set boolean of stop_button_clicked to true
     stop_button_clicked = true;

     //call the method in criitersimulator in order to pass the boolean
     CrittersSimulator.setboolean(stop_button_clicked);

     //set text label on north
     north_label.setText("Simulation is stopped.");
   }

   else	if(evt.getSource() == start_Button)
   {	
     //set boolean of stop_button_clicked to false
     stop_button_clicked = false; 

     //call the method in criitersimulator in order to pass the boolean
     CrittersSimulator.setboolean(stop_button_clicked);

     //set text label on north
     north_label.setText("Simulation is running.");
   }

  }//end of actionPerformed

  //MouseListener
  public void mouseEntered( MouseEvent evt ) { }
  public void mouseExited( MouseEvent evt ) { }
  public void mouseMoved( MouseEvent evt ) { }
  public void mouseReleased( MouseEvent evt ) { }

  // MouseMotionListener
  public void mousePressed( MouseEvent evt ) { }
  public void mouseDragged( MouseEvent evt ) { }

}//end of class
