/* 
 * Name: Songhao Zhou 
 * Login: cs11wJC
 * Date: 2/20/2014
 * File: SlotWheel.java 
 * Responsible for contructing the slotwheels and respond to the "click to
 * spin". After user clicked the button, the images will then set to a new
 * picture in each wheels. They will keep spinning until ticks is out.
 */ 
import objectdraw.*;
import java.awt.*;
import java.lang.Math;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/* 
 * Name: SlotWheel 
 * Purpose: this class is mainly for construction and actionPerformed,
 * getWheelIndex methods that implement the active object method. 
 */
public class SlotWheel extends ActiveObject implements ActionListener
{

  private FramedRect slotWheelBorder;	
  private RandomDoubleGenerator randDouble;
	
  private VisibleImage slotWheel;	

  private static final double WHEEL_INDEX_END = 1;
  private static final double WHEEL_INDEX_BEGIN = 0;

  //counter
  private int counter;

  //returned index
  private int returned_index;

  //image []
  private Image[] pics;

  //Given values
  private static final int NUM_OF_IMAGES = 8; 
  private static final double IMAGE_WIDTH = 110; 
  private static final double IMAGE_HEIGHT = 145; 
  private static final double WHEELS_Y_OFFSET = 5; 
  private static final double SPACE_BETWEEN_WHEELS = 5; 
  

  //varaibles to store the passed values
  private int saved_ticks;
  private int ticks;
  private int saved_delay;

  //boolean variables
  private boolean clicked = false;
  //private boolean win_prompt_showed;

  //slotwheels
  private SlotWheel wheel1;
  private SlotWheel wheel2;

  //extrea credit variables
  private int index;
  private VisibleImage win_image;
  private DrawingCanvas canvas;
  private double win_prompt_x, win_prompt_y;
  private static final double ONE_THIRD = 1/3;
  private static final double THREE = 3;
  private static final int TWO = 2;
  private static final double ANNOUCE_WIN_PROMPT_X = 160;
  private static final double ANNOUCE_WIN_PROMPT_Y = 175;
  private static final double QUARTER = 0.25;
  private static final double HALF = 0.5;
  private static final double THREE_QUARTER = 0.75;
  private static final int FOUR = 4;
  private static final int FIVE = 5;
  private static final int SIX = 6;
  private static final int EIGHT = 8;
  private static final int SEVEN = 7;
  private static final double PAYOFF_RATIO = 15;  
  private JTextField spin_field;
  private JTextField wins_field;
  private int spin_field_counter;
  private int wins_field_counter;
  private JTextField bank_field;
  private JComboBox betChoice;
  private JTextField mymoney_field; 

  private double bet_amount;
  private double deposit;
  private double gamble_amount;

  private boolean won;
  
   
  /* 
  * Name: SlotWheel 
  * Purpose: This is the constructor of the slotwheel. It constructs the 
  * random double generator, slotwheel, and slotwheel border.
  * Parameters: Image[] pics (image array), int ticks(given ticks), 
  * int delay(given pause time), Location location(starting postion),
  * DrawingCanvas canvas, SlotWheel wheel1, SlotWheel wheel2, int index,
  * VisibleImage win_image, JTextField spin_field ,JTextField wins_field,
  * JTextField bank_field, JComboBox betChoice
  */
  public SlotWheel(Image[] pics, int ticks, int delay, Location location,
  DrawingCanvas canvas, SlotWheel wheel1, SlotWheel wheel2, int index,
  VisibleImage win_image, JTextField spin_field ,JTextField wins_field,
  JTextField bank_field, JComboBox betChoice, JTextField mymoney_field)
  {
    //save passed parameters
    this.pics = pics;
    this.canvas = canvas;
    this.win_image = win_image;
    
    this.spin_field = spin_field;
    this.wins_field = wins_field;
    this.mymoney_field = mymoney_field;
    this.bank_field = bank_field;
    this.betChoice = betChoice;
    
    this.ticks = ticks;
    saved_ticks = ticks;
    saved_delay = delay;

    //test extracredit
    this.wheel1 = wheel1;
    this.wheel2 = wheel2;
    this.index = index;
  
    //set textfiled
    if(index ==3)
    {
      spin_field.setText("spins = " +spin_field_counter);
      wins_field.setText("wins = " +wins_field_counter);    
    }
    //construction of random generator, slotwheel and slotwheelborder
    randDouble = new RandomDoubleGenerator(WHEEL_INDEX_BEGIN, 
    WHEEL_INDEX_END);
   
    slotWheel = new VisibleImage (pics[getWheelIndex()] , location.getX(),
    location.getY(), IMAGE_WIDTH, IMAGE_HEIGHT, canvas);

    slotWheelBorder = new FramedRect (location.getX(), location.getY(), 
    IMAGE_WIDTH, IMAGE_HEIGHT, canvas);

    //set the win prompt location
    win_prompt_x = ANNOUCE_WIN_PROMPT_X;
    win_prompt_y = ANNOUCE_WIN_PROMPT_Y;
  
    start(); // start the animation

  }

  /* 
  * Name: actionPerformed 
  * Purpose: This method handles the situation when user has clicked the 
  * button.
  * Parameters: ActionEvent evt. We use this parameter to determine
  * whether user has clicked the spin button
  * Return: void 
  */
  public void actionPerformed( ActionEvent evt ) 
  {
    //check if user has clicked the button

    if (evt.getActionCommand() .equals("Click to Spin"))
    {
      saved_ticks = this.ticks;
  
      //reset the wheelindex. (new image)   
      returned_index = this.getWheelIndex();
      slotWheel.setImage(pics[returned_index]);

      //set the clicked boolean to true
      clicked = true;
              

      if( index == 3 && win_image.isHidden() == false)
      {  
        wins_field.setText("wins = " +wins_field_counter);    				         
	win_image.hide();
      }

      if( index == 3 )
      {

      Object newLevel = betChoice.getSelectedItem();
 
      if ( newLevel.equals( "$1" )) 
      {
        gamble_amount = 1;
      } 
      else if ( newLevel.equals( "$3" )) 
      {
        gamble_amount = THREE;
      } 
      else if ( newLevel.equals( "$5")) 
      {
        gamble_amount = FIVE;
      } 
      else
      {
        gamble_amount = THREE;
      }

      try
      {
	deposit = Integer.parseInt(bank_field.getText());
      }
      catch (NumberFormatException e)
      {
        System.out.println("Catch method for Extra Credit");
      }
        
      mymoney_field.setText("money = "+deposit);    				         

        //System.out.println(+deposit);

      spin_field_counter++;
      spin_field.setText("spins = " +spin_field_counter);        
      }

    }

    else
      clicked = false;

  }

  /* 
  * Name: getWheelIndex() 
  * Purpose: This method randomly generates a double number between 0~1
  * if the number is between 0 and 0.25, method return 0; if it is between 
  * 0.25 and 0.5, method return 2; if it is between 
  * 0.5 and 0.75, method return 4; if it is between 
  * 0.75 and 1, method return 6
  * Parameters: none
  * Return: int 
  */
  public int getWheelIndex()
  {
    double i;
    i = randDouble.nextValue();

    if( 0 <= i && i <= QUARTER)
    {
      return 0;
    }

    else if( QUARTER < i && i <= HALF)
    {
      return TWO;
    }

    else if( HALF < i && i <= THREE_QUARTER)
    {
      return FOUR;
    }

    else if( THREE_QUARTER < i && i <= 1)
    {
      return SIX;
    }

    else
      return 0;
	
  }

  /* 
  * Name: run() 
  * Purpose: This method handles the part where program let the images to 
  * spin when user has clicked the spin button. In order to do that, this
  * method keeps tracking how many ticks has left and keep changing the 
  * picture as long as tick is not out.
  * Parameters: none
  * Return: void 
  */
  public void run()
  {
    while (true)
    {
      //check if still have ticks left and button has been clicked
      if(saved_ticks > 0 && clicked == true)
      {
        if ( (returned_index % EIGHT )< SEVEN)
        {
        //increment the index and set new image
        returned_index ++;	
        slotWheel.setImage(pics[returned_index]);

	  synchronized(this)
	  {
	    saved_ticks --; //decrement the ticks
          }
        }
	  //wrao the index back to 0 when index hits 7
        else if (returned_index == SEVEN)
        {
          returned_index = 0;
          slotWheel.setImage(pics[returned_index]);	
       	  synchronized(this)
	  {	
            saved_ticks --; //decrement the ticks
	  }
        }  


      }
    
      else if ( index == 3 && clicked)
      {
	//check if 3 wheels are identical
        if( wheel1.slotWheel.getImage() .equals
              (wheel2.slotWheel.getImage()) && 
              (wheel1.slotWheel.getImage()) 
              .equals( this.slotWheel.getImage() ) )
	{
	  win_image.show();
	  wins_field_counter ++;

          deposit = deposit + PAYOFF_RATIO*gamble_amount;
          won = true;		
     
	  clicked = false;   				
	}
      } 

      //////saved_delay
      pause(saved_delay);

    }//end of while true

  }//end of run

}//end of class






