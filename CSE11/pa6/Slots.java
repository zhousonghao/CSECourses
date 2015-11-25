/* 
 * Name: Songhao Zhou 
 * Login: cs11wJC
 * Date: 2/20/2014
 * File: Slots.java 
 * This file is designed to be the controller of the slotwheels, which is 
 * mainly in charge of creating new slotwheels and pass through the
 * parameters
 */ 
import objectdraw.*;
import java.awt.*;
import java.lang.Math;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/* 
 * Name: Slots
 * Purpose: This class contructs the slotwheels and pass the location that 
 * will be need for the contructor in slotwheel.java. Also, it adds
 * slot wheels to the action listener. 
 */
public class Slots extends WindowController implements ActionListener
{
  //given values
  private static final int NUM_OF_IMAGES = 8; 
  private static final double IMAGE_WIDTH = 110; 
  private static final double IMAGE_HEIGHT = 145; 
  private static final double WHEELS_Y_OFFSET = 5; 
  private static final double SPACE_BETWEEN_WHEELS = 5; 
  private static final int WHEEL_1_TICKS = 22; 
  private static final int WHEEL_2_TICKS = WHEEL_1_TICKS + 6; 
  private static final int WHEEL_3_TICKS = WHEEL_2_TICKS + 6; 
  private static final int WHEEL_1_DELAY = 100; 
  private static final int WHEEL_2_DELAY = WHEEL_1_DELAY + 25; 
  private static final int WHEEL_3_DELAY = WHEEL_2_DELAY + 25; 

  //GUI stuff
  private JLabel north_theme;
  private JButton click_to_spin;

  //constants
  private static final int FONT_SIZE = 24;
  private static final int THREE = 3;
  private static final int TWO = 2;
  private static final double HALF = 0.5;

  //location
  private Location first_slot_loc;
  private Location second_slot_loc;
  private Location third_slot_loc;

  //slot wheels
  private SlotWheel wheel1;
  private SlotWheel wheel2;
  private SlotWheel wheel3;

  //boolean variable
  private boolean clicked;

  //extra credit
  private VisibleImage win_image;
  private static final double WIN_IMAGE_X = 90;
  private static final double WIN_IMAGE_Y = 155;
  private static final double WIN_IMAGE_WIDTH = 320;
  private static final double WIN_IMAGE_HEIGHT = 225;  	
  private static final int ONE = 1;
  private static final int FIELD_COLOMS = 7;


  /* 
  * Name: begin()
  * Purpose: In the begin, it computes the location that needed to be
  * passed and contruct the new slotwheels and add them to the action
  * listeners
  * Parameters: none
  * Return: void
  */
  public void begin()
  {
    double coord_x1, coord_y1;

    //declare the image array
    Image[] slots_card = new Image[ NUM_OF_IMAGES ];

    //create the jpanel and buttons; set the layout
    JPanel northPanel = new JPanel();
    northPanel.setLayout( new GridLayout( TWO, ONE ) );
    JPanel north_theme_panel = new JPanel();      
    JPanel north_track_panel = new JPanel();  

    JTextField spin_field = new JTextField(FIELD_COLOMS);
    spin_field.setEditable(false);
    
    JTextField wins_field = new JTextField(FIELD_COLOMS);
    wins_field.setEditable(false);
 
    JTextField mymoney_field = new JTextField("My money",
    FIELD_COLOMS);
    wins_field.setEditable(false);

    JTextField bank_field = new JTextField("type deposit",
    FIELD_COLOMS);

    
    north_theme = new JLabel( "SUN VAS GODAS" );
    north_theme.setFont(new Font("sansserif", Font.BOLD, FONT_SIZE));
 
    JComboBox betChoice = new JComboBox();
    betChoice.addItem ( "$1" ); 
    betChoice.addItem ( "$3" );
    betChoice.addItem ( "$5" );
    betChoice.setSelectedItem( "$3" );
 
    north_theme_panel.add(north_theme);
    north_track_panel.add(spin_field);
    north_track_panel.add(wins_field);
    north_track_panel.add(mymoney_field); 
    north_track_panel.add(bank_field);    
    north_track_panel.add(betChoice);    

    northPanel.add(north_theme_panel);
    northPanel.add(north_track_panel);    

    JPanel southPanel = new JPanel();
    click_to_spin = new JButton("Click to Spin");
    southPanel.add(click_to_spin);
  
    //add to the container
    Container contentPane = getContentPane();
    contentPane.add(northPanel, BorderLayout.NORTH);
   	
    contentPane.add(southPanel, BorderLayout.SOUTH);	
    contentPane.validate();
	
    //create new image for win 
    win_image = new VisibleImage (getImage("win_image.jpg") , WIN_IMAGE_X,
    WIN_IMAGE_Y, canvas);

    win_image.hide();


    //assign pics array
    slots_card[0] = getImage("sungod.jpg");
    slots_card[1] = getImage("sungod-bear.jpg");
    slots_card[2] = getImage("bear.jpg");
    slots_card[3] = getImage("bear-triton.jpg");
    slots_card[4] = getImage("triton.jpg");
    slots_card[5] = getImage("triton-library.jpg");
    slots_card[6] = getImage("library.jpg");
    slots_card[7] = getImage("library-sungod.jpg");

    //compute fot the coordinate of x1 and y1
    coord_x1 = HALF *(canvas.getWidth() - IMAGE_WIDTH * THREE - 
    SPACE_BETWEEN_WHEELS * TWO);

    coord_y1 = WHEELS_Y_OFFSET;

    //initialize the new location for the 3 wheels
    first_slot_loc = new Location (coord_x1, coord_y1);

    second_slot_loc = new Location (coord_x1 + IMAGE_WIDTH + 
    SPACE_BETWEEN_WHEELS, coord_y1);

    third_slot_loc = new Location (coord_x1 + TWO*IMAGE_WIDTH + 
    TWO*SPACE_BETWEEN_WHEELS, coord_y1);


    //construction of sloswheels
    wheel1 = new SlotWheel(	slots_card, WHEEL_1_TICKS, WHEEL_1_DELAY, 
    first_slot_loc, canvas, null, null, 1, null, null, null, null, null,
    null);

    wheel2 = new SlotWheel(	slots_card, WHEEL_2_TICKS, WHEEL_2_DELAY, 
    second_slot_loc, canvas, null, null, 2, null, null, null, null, null,
    null);

    wheel3 = new SlotWheel(	slots_card, WHEEL_3_TICKS, WHEEL_3_DELAY, 
    third_slot_loc, canvas, wheel1, wheel2, 3, win_image, spin_field,
    wins_field, bank_field, betChoice, mymoney_field);

    //add 3 wheels as listener of button spin
    click_to_spin.addActionListener( wheel1 );
    click_to_spin.addActionListener( wheel2 );
    click_to_spin.addActionListener( wheel3 );
    betChoice.addActionListener ( wheel1 );
    betChoice.addActionListener ( wheel2 );
    betChoice.addActionListener ( wheel3 );

    click_to_spin.addActionListener( this );

  }//end of begin



  //ActionListener
  /* 
  * Name: actionPerformed 
  * Purpose: respond to the situation where click to spin has pressed
  * Parameters: ActionEvent evt. we need this parameter in order to
  * determine if button has been clicked
  * Return: void 
  */
  public void actionPerformed( ActionEvent evt )
  {
    //check if event source is clickto spin
    if(evt.getSource() == click_to_spin)
    {
      clicked = true;
    }
    else 
      clicked = false;

  }

}//end of class
