import java.awt.*;
import objectdraw.*;

public class Mickey extends WindowController
{
  private Text instr1, instr2, instr3;
  private FilledOval leftEar, rightEar, face;
  private static final int INSTR1_X = 50;
  private static final int INSTR1_Y = 50;
  private static final int INSTR2_X = INSTR1_X;
  private static final int INSTR2_Y = INSTR1_Y + 20;
  private static final int INSTR3_X = INSTR1_X;
  private static final int INSTR3_Y = INSTR2_Y + 20;
  private static final int FACE_RADIUS = 50;
  private static final int EAR_RADIUS = 30;
  private static final int EAR_OFFSET = 50; // Center of each ear is this
                                            // offset up and over (x and y)
                                            // from center of face.
  private static final int FACE_DIAMETER = 100;
  private static final int EAR_DIAMETER = 60;  

  private int counter_for_click = 0;   // the counter for making sure only one Mickey generated under MouseClick

  private boolean facegrabbed, leftEargrabbed, rightEargrabbed;
  private Location lastPoint;  // store the lastpoint for MouseDrag
  private Location originalPoint; // store the original point which creates the Mickey in order to locate the position under rotation



  private boolean check_grabbed; // boolean variable to check whether Mick is grabbed
  private boolean check_dragged;
  private boolean facedrew, lefteardew, righteardrew;
  private boolean check_onMouseClick;
 //orientation, up =0; right = 1; down = 2; left =3

  private int up= 0;  //set default up is 0
  private int right= 10;   // orientation is not right. set = 10
  private int left= 10;  // orientation is not left. set = 10
  private int down = 10;    // orientaiton is not down. set =10


  //Define timer
  private Timer myTimer;

  //intructions
  private Text instructions1;  
  private Text instructions2;
  private Text instructions3;  

  private double elapsedMilliseconds;

 
  //private Timer timer;
  private static final int FLIP_PRESS_THRESHOLD = 500; // Half of a second


 
  public void begin() 
  {

	// generate 3 text obejcts
	instructions1 = new Text("Click to display a Mickey silhouete centered at the mouse click.",INSTR1_X,INSTR1_Y, canvas);
	instructions2 = new Text("Mouse press in any part of the image and drag to move image around.",INSTR2_X,INSTR2_Y, canvas);
	instructions3 = new Text("Mouse click in any part of the image with a mouse press for more than 0.5 seconds to turn image.",INSTR3_X,INSTR3_Y, canvas);

	myTimer = new Timer();
 
  }

    
  public void onMouseClick( Location point )

 {

	check_onMouseClick = true;
	if(counter_for_click == 0){

	instructions1.hide(); 
	instructions2.hide();
	instructions3.hide();
   
	// draw the Mickey
	face = new FilledOval (point.getX()-EAR_OFFSET, point.getY()-EAR_OFFSET, FACE_DIAMETER, FACE_DIAMETER, canvas);
	leftEar  = new FilledOval (point.getX()-EAR_OFFSET-EAR_RADIUS, point.getY()-EAR_OFFSET-EAR_RADIUS, EAR_DIAMETER, EAR_DIAMETER, canvas );
	rightEar = new FilledOval (point.getX()+EAR_OFFSET-EAR_RADIUS, point.getY()-EAR_OFFSET-EAR_RADIUS, EAR_DIAMETER, EAR_DIAMETER, canvas );

	facedrew = true;
	leftEargrabbed = true;
	righteardrew = true;
	

 	originalPoint = point;  // save the point which creates Mickey for later flipping

	// reset the orientation everytime Mcikey created
	up = 0; 
	right= 10; 
        left= 10; 
        down = 10; 

	++counter_for_click; // increment the counter for click	
  }
 }


  
  public void onMousePress( Location point ) 
 {

	check_dragged = false;

	lastPoint = point; // save the point for drag
	
	if (check_onMouseClick) {
	
	// check whether the Mickey is grabbed
	facegrabbed = face.contains (point);  
	leftEargrabbed = leftEar.contains (point);
	rightEargrabbed = rightEar.contains (point);
	
	
	
	if(facegrabbed || leftEargrabbed || rightEargrabbed ){
	   
		check_grabbed = true;  // set boolean contant to true if Mickey is grabbed
		myTimer.reset();    // start the timer
	}
   	
	else{
		check_grabbed = false; // set boolean contant to false if Mickey is not grabbed
   	}


      }//end of outer if
	else{
		check_onMouseClick = false;
   	}

 }//end of onMousePress


  public void onMouseRelease( Location point )
{
	elapsedMilliseconds = myTimer.elapsedMilliseconds();

// check the pararmeter when Mickey is facing up; if ture, let it facing right
 if ( elapsedMilliseconds > FLIP_PRESS_THRESHOLD && up == 0 && right != 1 && down == 10 && left == 10 && check_grabbed == true && check_dragged == false ){
    
   // Make Mickey facing right
   leftEar.move((originalPoint.getX()+EAR_OFFSET-EAR_RADIUS) - (originalPoint.getX()-EAR_OFFSET-EAR_RADIUS) , (originalPoint.getY()+EAR_OFFSET-EAR_RADIUS) - (originalPoint.getY()-EAR_OFFSET-EAR_RADIUS));
      

   // set Mickey to Red
   face.setColor(Color.red); 
   leftEar.setColor(Color.red);
   rightEar.setColor(Color.red);

   up = 10;  //not facing up
   right = 1; // is facing right
   down = 10; // not facing down
   left = 10; //not facing left
  } 


// check the pararmeter when Mickey is facing right; if ture, let it facing down

 else if( elapsedMilliseconds > FLIP_PRESS_THRESHOLD && down != 2 && right ==1 && up == 10 && left == 10  && check_grabbed == true && check_dragged == false){

 //set Mickey facing down
   rightEar.move((originalPoint.getX()-EAR_OFFSET-EAR_RADIUS) - (originalPoint.getX()+EAR_OFFSET-EAR_RADIUS), (originalPoint.getY()+EAR_OFFSET-EAR_RADIUS) - (originalPoint.getY()-EAR_OFFSET-EAR_RADIUS));
	
 // set Mickey to green
   face.setColor(Color.green);
   leftEar.setColor(Color.green);
   rightEar.setColor(Color.green);

   down = 2; //is facing down
   up = 10; // not facing up
   right = 10; // not facing right
   left = 10; // not facing left
  }


//check the pararmeter when Mickey is facing down; if ture, let it facing left

 else if ( elapsedMilliseconds > FLIP_PRESS_THRESHOLD && left != 3 && down == 2 && right ==10 && up == 10 && check_grabbed == true && check_dragged == false){

  // set Mickey facing left
  leftEar.move((originalPoint.getX()-EAR_OFFSET-EAR_RADIUS) - (originalPoint.getX()+EAR_OFFSET-EAR_RADIUS), (originalPoint.getY()-EAR_OFFSET-EAR_RADIUS) - (originalPoint.getY()+EAR_OFFSET-EAR_RADIUS));
 
  //set Mickey to blue
  face.setColor(Color.blue);
  leftEar.setColor(Color.blue);
  rightEar.setColor(Color.blue);

  up = 10; // not faicng up
  right = 10; // not facing right
  down = 10; //not facing down
  left = 3; // is facing left
 } 



//check the pararmeter when Mickey is facing left; if ture, let it facing up

 else if ( elapsedMilliseconds > FLIP_PRESS_THRESHOLD &&  up != 0 && left == 3 && down == 10 && right == 10 && check_grabbed == true && check_dragged == false){	
				
  //set Mickey facing up
  rightEar.move((originalPoint.getX()+EAR_OFFSET-EAR_RADIUS) - (originalPoint.getX()-EAR_OFFSET-EAR_RADIUS), (originalPoint.getY()-EAR_OFFSET-EAR_RADIUS) - (originalPoint.getY()+EAR_OFFSET-EAR_RADIUS));

  //set Mickey to blue
  face.setColor(Color.blue);
  leftEar.setColor(Color.blue);
  rightEar.setColor(Color.blue);

  right = 10; //not facing right
  left = 10; //not faicng left
  down = 10; // not facing down
  up   = 0;  // is facing up


  //reset color to default back when Mcikey is faicng up
  face.setColor(Color.black);
  leftEar.setColor(Color.black);
  rightEar.setColor(Color.black);

  } //end of else-if	

} // end of release


  public void onMouseDrag( Location point ) 
 {
	//check if Mickey is grabbed. if ture, move
	if( facegrabbed || leftEargrabbed || rightEargrabbed )
	{
		check_dragged = true;

		face.move(point.getX()-lastPoint.getX(), point.getY()-lastPoint.getY());
                leftEar.move(point.getX()-lastPoint.getX(), point.getY()-lastPoint.getY());
		rightEar.move(point.getX()-lastPoint.getX(), point.getY()-lastPoint.getY());
		
		lastPoint = point; //change the lastpoint to current one
	}

	else check_dragged = false;
 }



  public void onMouseExit( Location point ) {

 	//hide the instructions

	if ( check_onMouseClick){
	face.hide();
	leftEar.hide();
	rightEar.hide();
	counter_for_click = 0; // reset the counter for click
	}

 }
 


  public void onMouseEnter( Location point ) {

	
	counter_for_click = 0;// reset the counter for click
		
	// show the instructions again
	instructions1.show();
	instructions2.show();
	instructions3.show();

 }

 

/*
  public void onMouseEnter( Location point ) {...}
  public void turn() {...}*/
}//end of class


