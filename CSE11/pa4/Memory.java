/* 
 * Name: Songhao Zhou
 * Login: CS11WJC
 * Date: 2/4/2014 
 * File: Memory.java 
 * Purpose: Memory.java is a game which let user click on the blank tile and 
 * then the progra will show a pictue of a animal, then useris able to click
 * another blank tile and a second animal will show Then program will compare
 * those 2 pictures. if they are the same then it will set to color green.
 * if they do not match, then those 2 will be set into color red. And not 
 * match pictures will be turned back to black tile at the next click
 */
import objectdraw.*;
import java.awt.*;

/* 
 * Name: Memory
 * Purpose: this class is the implement of the game Memory that decribed above
 * and this class extend WindowController, thus, it inherits all the 
 * methods that belonged to WindowController 
 */
public class Memory extends WindowController
{
// declare the case number
private static final int ZERO = 0;
private static final int ONE = 1;
private static final int TWO = 2;
private static final int THREE = 3;
private static final int FOUR = 4;
private static final int FIVE = 5;
private static final int SIX = 6;
private static final int SEVEN = 7;
private static final int EIGHT = 8;
private static final int NINE = 9;
private static final int TEN = 10;
private static final int ELEVEN = 11;
private static final int TWELVE = 12;
private static final int THIRTEEN = 13;
private static final int FOURTEEN = 14;
private static final int FIFTEEN = 15;
private static final int SIXTEEN = 16;
private static final int SEVENTEEN = 17;

//declare the starting location of each FramedRect
private Location FRAMED_REC1_LOC = new Location (5,5); 
private Location FRAMED_REC2_LOC = new Location (110,5);  
private Location FRAMED_REC3_LOC = new Location (215,5);  
private Location FRAMED_REC4_LOC = new Location (5,110); 
private Location FRAMED_REC5_LOC = new Location (110,110);  
private Location FRAMED_REC6_LOC = new Location (215,110); 
private Location FRAMED_REC7_LOC = new Location (5,215); 
private Location FRAMED_REC8_LOC = new Location (110,215);  
private Location FRAMED_REC9_LOC = new Location (215,215);  
private Location FRAMED_REC10_LOC = new Location (5,320); 
private Location FRAMED_REC11_LOC = new Location (110,320);  
private Location FRAMED_REC12_LOC = new Location (215,320); 
private Location FRAMED_REC13_LOC = new Location (5,425); 
private Location FRAMED_REC14_LOC = new Location (110,425);  
private Location FRAMED_REC15_LOC = new Location (215,425);  
private Location FRAMED_REC16_LOC = new Location (5,530); 
private Location FRAMED_REC17_LOC = new Location (110,530);  
private Location FRAMED_REC18_LOC = new Location (215,530); 

//declare each FramedRect
private FramedRect framed_rec1;
private FramedRect framed_rec2;
private FramedRect framed_rec3;
private FramedRect framed_rec4;
private FramedRect framed_rec5;
private FramedRect framed_rec6;
private FramedRect framed_rec7;
private FramedRect framed_rec8;
private FramedRect framed_rec9;
private FramedRect framed_rec10;
private FramedRect framed_rec11;
private FramedRect framed_rec12;
private FramedRect framed_rec13;
private FramedRect framed_rec14;
private FramedRect framed_rec15;
private FramedRect framed_rec16;
private FramedRect framed_rec17;
private FramedRect framed_rec18;

//declare the constant that need for FramedRect allocation
private static final double PIC_WIDTH = 99;
private static final double PIC_HEIGHT = 99;

// parameter for animalcard
private AnimalCard animal;
private AnimalCard reference_animal1;
private AnimalCard reference_animal2;
private AnimalCard reference_animal3;

//the Text
private Text prompt;

//Text location offset and constant that is used
private static final int PROMTP_Y_OFFSET = 20;


//counter
private int onMouseClick_counter;

//declare animals
private AnimalCard card_puppy1, card_puppy2;
private AnimalCard card_kitty1, card_kitty2;
private AnimalCard card_duck1, card_duck2;
private AnimalCard card_lion1, card_lion2;
private AnimalCard card_cow1, card_cow2;
private AnimalCard card_lamb1, card_lamb2;
private AnimalCard card_triton1, card_triton2;
private AnimalCard card_caonima1, card_caonima2;
private AnimalCard card_kabishou1, card_kabishou2;

//random count
private RandomIntGenerator randInt_assignloc;

//constant that used by random count
private static final int COUNT_OF_ASSIGNLOC = 17;

//variable to store the referece 
private Location pt;
private Location pt1, pt2, pt3, pt4, pt5, pt6, pt7, pt8, pt9, pt10, 
pt11, pt12, pt13, pt14, pt15, pt16, pt17, pt18;

//counter to make sure each animal is picked 2 times
private int counter_puppy_assign_animal, counter_puppy_assign_loc;
private int counter_kitty_assign_animal, counter_kitty_assign_loc;
private int counter_duck_assign_animal, counter_duck_assign_loc;
private int counter_lion_assign_animal, counter_lion_assign_loc;
private int counter_cow_assign_animal, counter_cow_assign_loc;
private int counter_lamb_assign_animal, counter_lamb_assign_loc;

//boolean variables to check if loc is taken
private boolean loc1 = true;
private boolean loc2 = true;
private boolean loc3 = true;
private boolean loc4 = true;
private boolean loc5 = true;
private boolean loc6 = true;
private boolean loc7 = true;
private boolean loc8 = true;
private boolean loc9 = true;
private boolean loc10 = true;
private boolean loc11 = true;
private boolean loc12 = true;
private boolean loc13 = true;
private boolean loc14 = true;
private boolean loc15 = true;
private boolean loc16 = true;
private boolean loc17 = true;
private boolean loc18 = true;

//boolean to checked if reference has created
private boolean reference1_wrong_created;
private boolean reference2_wrong_created;
private boolean is_hidden;


/* 
 * Name: begin
 * Purpose: In this method, it generally creates the 18 
 * framed rects on the screen
 * but hide the animals andanimals' hightlight when the user first started
 * the program Also, under this method it generates the random position and 
 * assign to each of the 18 animals
 */
public void begin(){

  //construction of random integer
  randInt_assignloc = new RandomIntGenerator(0,COUNT_OF_ASSIGNLOC);

  //construction of Text
  prompt = new Text(" ", 0, 0, canvas);

  //construction of framed rectangles
  framed_rec1 = new FramedRect(FRAMED_REC1_LOC, PIC_WIDTH, PIC_HEIGHT, canvas);
  framed_rec2 = new FramedRect(FRAMED_REC2_LOC, PIC_WIDTH, PIC_HEIGHT, canvas);
  framed_rec3 = new FramedRect(FRAMED_REC3_LOC, PIC_WIDTH, PIC_HEIGHT, canvas);
  framed_rec4 = new FramedRect(FRAMED_REC4_LOC, PIC_WIDTH, PIC_HEIGHT, canvas);
  framed_rec5 = new FramedRect(FRAMED_REC5_LOC, PIC_WIDTH, PIC_HEIGHT, canvas);
  framed_rec6 = new FramedRect(FRAMED_REC6_LOC, PIC_WIDTH, PIC_HEIGHT, canvas);
  framed_rec7 = new FramedRect(FRAMED_REC7_LOC, PIC_WIDTH, PIC_HEIGHT, canvas);
  framed_rec8 = new FramedRect(FRAMED_REC8_LOC, PIC_WIDTH, PIC_HEIGHT, canvas);
  framed_rec9 = new FramedRect(FRAMED_REC9_LOC, PIC_WIDTH, PIC_HEIGHT, canvas);
  framed_rec10 = new FramedRect(FRAMED_REC10_LOC, PIC_WIDTH,
				 PIC_HEIGHT, canvas);
  framed_rec11 = new FramedRect(FRAMED_REC11_LOC, 
				PIC_WIDTH, PIC_HEIGHT, canvas);
  framed_rec12 = new FramedRect(FRAMED_REC12_LOC, PIC_WIDTH, 
					PIC_HEIGHT, canvas);
  framed_rec13 = new FramedRect(FRAMED_REC13_LOC, PIC_WIDTH, 
					PIC_HEIGHT, canvas);
  framed_rec14 = new FramedRect(FRAMED_REC14_LOC, PIC_WIDTH,
					 PIC_HEIGHT, canvas);
  framed_rec15 = new FramedRect(FRAMED_REC15_LOC, PIC_WIDTH,
					 PIC_HEIGHT, canvas);
  framed_rec16 = new FramedRect(FRAMED_REC16_LOC, PIC_WIDTH, 
					PIC_HEIGHT, canvas);
  framed_rec17 = new FramedRect(FRAMED_REC17_LOC, PIC_WIDTH,
					 PIC_HEIGHT, canvas);
  framed_rec18 = new FramedRect(FRAMED_REC18_LOC, PIC_WIDTH,
					 PIC_HEIGHT, canvas);


//construction of animals
//the while loop is to check the pt that returned by the method	assignloc
//is unique, if not, then keeps calling the assignloc method until it 
//gets a different hit. After recieved a unique hit
//the program will then contruct the one of 18 animals 
//at corresponding randomly selected positions

  //2 kitties
  this.assignloc();
  card_kitty1 = new Kitty(getImage("kitty.jpg"), pt, canvas);
  card_kitty1.hideHighlight();
  card_kitty1.hide();
  pt1 = pt;
	
  while( pt == pt1){ 
  this.assignloc();
  }
  card_kitty2 = new Kitty(getImage("kitty.jpg"), pt, canvas);
  card_kitty2.hideHighlight();	
  card_kitty2.hide();
  pt2 = pt;
	
  //2 ducks
  while( pt == pt1 || pt == pt2){
  this.assignloc();
  }
  card_duck1 = new Duck(getImage("duck.jpg"), pt, canvas);
  card_duck1.hideHighlight();
  card_duck1.hide();
  pt3 = pt;

  while( pt == pt1 || pt == pt2 || pt == pt3){	
  this.assignloc();
  }
  card_duck2 = new Duck(getImage("duck.jpg"), pt, canvas);
  card_duck2.hideHighlight();
  card_duck2.hide();	
  pt4 = pt;

  //2 lions
  while( pt == pt1 || pt == pt2 || pt == pt3 || pt == pt4){	
  this.assignloc();
  }
  card_lion1 = new Lion(getImage("lion.jpg"), pt, canvas);
  card_lion1.hideHighlight();
  card_lion1.hide();
  pt5 = pt;

  while( pt == pt1 || pt == pt2 || pt == pt3 || pt == pt4 || pt == pt5){	  this.assignloc();
  }
  card_lion2 = new Lion(getImage("lion.jpg"), pt, canvas);
  card_lion2.hideHighlight();
  card_lion2.hide();
  pt6 = pt;	

  //2 cows
  while( pt == pt1 || pt == pt2 || pt == pt3 || pt == pt4 || pt == pt5 || 
	pt == pt6){		
  this.assignloc();
  }
  card_cow1 = new Cow(getImage("cow.jpg"), pt, canvas);
  card_cow1.hideHighlight();
  card_cow1.hide();
  pt7 = pt;

  while( pt == pt1 || pt == pt2 || pt == pt3 || pt == pt4 || pt == pt5 ||
	 pt == pt6 || pt ==pt7){		
  this.assignloc();
  }
  card_cow2 = new Cow(getImage("cow.jpg"), pt, canvas);
  card_cow2.hideHighlight();
  card_cow2.hide();
  pt8 = pt;

  //2 lambs
  while( pt == pt1 || pt == pt2 || pt == pt3 || pt == pt4 || pt == pt5 ||
	 pt == pt6 || pt ==pt7 || pt ==pt8){		
  this.assignloc();
  }
  card_lamb1 = new Lamb(getImage("lamb.jpg"), pt, canvas);
  card_lamb1.hideHighlight();
  card_lamb1.hide();
  pt9 = pt;

  while( pt == pt1 || pt == pt2 || pt == pt3 || pt == pt4 || pt == pt5 ||
	 pt == pt6 || pt ==pt7 || pt ==pt8 || pt==pt9){			
  this.assignloc();
  }
  card_lamb2 = new Lamb(getImage("lamb.jpg"), pt, canvas);
  card_lamb2.hideHighlight();
  card_lamb2.hide();
  pt10 = pt;

  //2 puppies
  while( pt == pt1 || pt == pt2 || pt == pt3 || pt == pt4 || pt == pt5 ||
	       pt == pt6 || pt ==pt7 || pt ==pt8 || pt==pt9 || pt==pt10){	
  this.assignloc();
  }
  card_puppy1 = new Puppy(getImage("puppy.jpg"), pt, canvas);
  card_puppy1.hideHighlight();
  card_puppy1.hide();
  pt11 = pt;
	
  while( pt == pt1 || pt == pt2 || pt == pt3 || pt == pt4 || pt == pt5 ||
	 pt == pt6 || pt ==pt7 || pt ==pt8 || pt==pt9 || pt==pt10 ||
	 pt==pt11){			
  this.assignloc();
  }
  card_puppy2 = new Puppy(getImage("puppy.jpg"), pt, canvas);
  card_puppy2.hideHighlight();	
  card_puppy2.hide();
  pt12 = pt;
	
  //2 tritons
  while( pt == pt1 || pt == pt2 || pt == pt3 || pt == pt4 || pt == pt5 ||
	 pt == pt6 || pt ==pt7 || pt ==pt8 || pt==pt9 || pt==pt10 || pt==pt11
	 || pt==pt12){			
  this.assignloc();
  }
  card_triton1 = new Triton(getImage("triton.jpg"), pt, canvas);
  card_triton1.hideHighlight();	
  card_triton1.hide();
  pt13 = pt;

  while( pt == pt1 || pt == pt2 || pt == pt3 || pt == pt4 || pt == pt5 ||
	 pt == pt6 || pt ==pt7 || pt ==pt8 || pt==pt9 || pt==pt10 || pt==pt11 
	 || pt==pt12 || pt == pt13 ){			
  this.assignloc();
  }
  card_triton2 = new Triton(getImage("triton.jpg"), pt, canvas);
  card_triton2.hideHighlight();	
  card_triton2.hide();
  pt14 = pt;

  //2 caonimas
  while( pt == pt1 || pt == pt2 || pt == pt3 || pt == pt4 || pt == pt5 ||
	 pt == pt6 || pt ==pt7 || pt ==pt8 || pt==pt9 || pt==pt10 ||
	 pt==pt11 || pt==pt12 || pt == pt13 || pt == pt14){			
  this.assignloc();
  }
  card_caonima1 = new Caonima(getImage("caonima.jpg"), pt, canvas);
  card_caonima1.hideHighlight();	
  card_caonima1.hide();
  pt15 = pt;

  while( pt == pt1 || pt == pt2 || pt == pt3 || pt == pt4 || pt == pt5 ||
	 pt == pt6 || pt ==pt7 || pt ==pt8 || pt==pt9 || pt==pt10 || pt==pt11
	 || pt==pt12 || pt == pt13 || pt == pt14 || pt==pt15){			
  this.assignloc();
  }
  card_caonima2 = new Caonima(getImage("caonima.jpg"), pt, canvas);
  card_caonima2.hideHighlight();	
  card_caonima2.hide();
  pt16 = pt;

  //2 kabishous
  while( pt == pt1 || pt == pt2 || pt == pt3 || pt == pt4 || pt == pt5 ||
	 pt == pt6 || pt ==pt7 || pt ==pt8 || pt==pt9 || pt==pt10 || pt==pt11
	 || pt==pt12 || pt == pt13 || pt == pt14 || pt==pt15 || pt==pt16 ){	
  this.assignloc();
  }
  card_kabishou1 = new Kabishou(getImage("kabishou.jpg"), pt, canvas);
  card_kabishou1.hideHighlight();	
  card_kabishou1.hide();
  pt17 = pt;

  while( pt == pt1 || pt == pt2 || pt == pt3 || pt == pt4 || pt == pt5 ||
	 pt == pt6 || pt ==pt7 || pt ==pt8 || pt==pt9 || pt==pt10 || pt==pt11
	 || pt==pt12 || pt == pt13 || pt == pt14 || pt==pt15 || pt==pt16 ||
	 pt==pt17){			
  this.assignloc();
  }
  card_kabishou2 = new Kabishou(getImage("kabishou.jpg"), pt, canvas);
  card_kabishou2.hideHighlight();	
  card_kabishou2.hide();

} //end of begin

/* 
 * Name: assignloc
 * Purpose: This method is to assign one of the 18 starting points'
 * of framed rects to the pt by using a swtich statement which has 
 * 18 cases this method will be called util all 18 positions have
 * all assigned and 18 boolean variabls (loc1 ~ loc18) is false
 * Parameters: none
 * Return: return pt, a Location
 */
public Location assignloc(){
	
  if(loc1 || loc2 || loc3 ||loc4 || loc5 || loc6 || loc7 || loc8 || loc9 ||
     loc10 || loc11 || loc12 || loc13|| loc14|| loc15|| loc16|| loc17|| loc18){

	int x = randInt_assignloc.nextValue();	

	switch(x){

	case(ZERO) :	if(loc1 == true){
			 pt = FRAMED_REC1_LOC;	
		         loc1 = false;
			}
	break;
	
	case(ONE) :	if(loc2 == true){
			 pt = FRAMED_REC2_LOC;
		         loc2 = false;	
			}
	break;

	case(TWO) : 	if(loc3 == true){
			 pt = FRAMED_REC3_LOC;
		         loc3 = false;
			}
	break;

	case(THREE) :	if(loc4 == true){
			 pt = FRAMED_REC4_LOC;
		         loc4 = false;
			}
	break;

	case(FOUR) : 	if(loc5 == true){
			 pt = FRAMED_REC5_LOC;
		         loc5 = false;
			}
	break;

	case(FIVE) : 	if(loc6 == true){
			 pt = FRAMED_REC6_LOC;
		         loc6 = false;
			}
	break;

	case(SIX) : 	if(loc7 == true){
			 pt = FRAMED_REC7_LOC;
		         loc7 = false;
			}
	break;
	
	case(SEVEN) : 	if(loc8 == true){
			 pt = FRAMED_REC8_LOC;
		         loc8 = false;
			}
	break;

	case(EIGHT) : 	if(loc9 == true){
			 pt = FRAMED_REC9_LOC;
		         loc9 = false;
			}
	break;

	case(NINE) : 	if(loc10 == true){
			 pt = FRAMED_REC10_LOC;
		         loc10 = false;
			}
	break;

	case(TEN) : 	if(loc11 == true){
			 pt = FRAMED_REC11_LOC;
		         loc11 = false;
			}
	break;

	case(ELEVEN) : 	if(loc12 == true){
			 pt = FRAMED_REC12_LOC;
		         loc12 = false;
			}
	break;

	case(TWELVE) : 	if(loc13 == true){
			 pt = FRAMED_REC13_LOC;
		         loc13 = false;
			}
	break;

	case(THIRTEEN) : if(loc14 == true){
			 pt = FRAMED_REC14_LOC;
		         loc14 = false;
			}
	break;

	case(FOURTEEN) : if(loc15 == true){
			 pt = FRAMED_REC15_LOC;
		         loc15 = false;
			}
	break;

	case(FIFTEEN) : if(loc16 == true){
			 pt = FRAMED_REC16_LOC;
		         loc16 = false;
			}

	break;

	case(SIXTEEN) : if(loc17 == true){
			 pt = FRAMED_REC17_LOC;
		         loc17 = false;
			}
	break;

	case(SEVENTEEN) : if(loc18 == true){
			 pt = FRAMED_REC18_LOC;
		         loc18 = false;
			}
	break;

		}//end of switch		
	}//end of while

	return pt;

}//end of assignloc

/* 
 * Name: pickAnAnimal
 * Purpose: This method is to assign one of the 18 animals to
 * the animalcard class animal which is determined by the 
 * onMouseClick_pt that forward by the onMouseClick method.
 * if the onMouseClick contains any one of the 18 animals,
 * then assign to the variable animal
 * Parameters: none
 * Return: void
 */
public void pickAnAnimal( Location onMouseClick_pt ){

	if( card_kitty1.contains(onMouseClick_pt)){
		animal = card_kitty1;
	}
	else if (card_kitty2.contains(onMouseClick_pt)){
		animal = card_kitty2;		
	}
	else if (card_puppy1.contains(onMouseClick_pt)){
		animal = card_puppy1;		
	}
	else if (card_puppy2.contains(onMouseClick_pt)){
		animal = card_puppy2;		
	}
	else if (card_duck1.contains(onMouseClick_pt)){
		animal = card_duck1;				
	}
	else if (card_duck2.contains(onMouseClick_pt)){
		animal = card_duck2;				
	}
	else if (card_lion1.contains(onMouseClick_pt)){
		animal = card_lion1;				
	}
	else if (card_lion2.contains(onMouseClick_pt)){
		animal = card_lion2;				
	}
	else if (card_cow1.contains(onMouseClick_pt)){
		animal = card_cow1;				
	}
	else if (card_cow2.contains(onMouseClick_pt)){
		animal = card_cow2;				
	}
	else if (card_lamb1.contains(onMouseClick_pt)){
		animal = card_lamb1;				
	}
	else if (card_lamb2.contains(onMouseClick_pt)){
		animal = card_lamb2;				
	}
	else if (card_triton1.contains(onMouseClick_pt)){
		animal = card_triton1;				
	}
	else if (card_triton2.contains(onMouseClick_pt)){
		animal = card_triton2;				
	}
	else if (card_caonima1.contains(onMouseClick_pt)){
		animal = card_caonima1;				
	}
	else if (card_caonima2.contains(onMouseClick_pt)){
		animal = card_caonima2;				
	}
	else if (card_kabishou1.contains(onMouseClick_pt)){
		animal = card_kabishou1;				
	}
	else if (card_kabishou2.contains(onMouseClick_pt)){
		animal = card_kabishou2;				
	}

}//end of pickananimal


/* 
 * Name: onMouseClick
 * Purpose: This is the main logic method under which a counter is used
 *and divided the cases into 3 big cases
 * then under each big case includes other small cases that might happen.
 * Basically, the main purpose of this method is to make sure that if user
 * has two mathched hits then keep them on the canvas, highlighted as gree; 
 * And if user has two NOT match hits, then highlighted them as red and 
 * hide them at the next click. Continuing this process util 
 * all tiles are showed.
 * Parameters: Location point
 * Return: void
 */
public void  onMouseClick( Location point ){

double prompt_x , prompt_y;

// this if statement is to make sure the mouseclick is on one of the 18 animals
if( card_kitty1.contains(point) || card_kitty2.contains(point) ||
	card_puppy1.contains(point) || card_puppy2.contains(point) ||
    	card_duck1.contains(point) || card_duck2.contains(point) ||
	card_lion1.contains(point) || card_lion2.contains(point) || 
    	card_cow1.contains(point) || card_cow2.contains(point) || 
	card_lamb1.contains(point) || card_lamb2.contains(point) ||
   	card_triton1.contains(point) || card_triton2.contains(point) ||
	card_caonima1.contains(point) || card_caonima2.contains(point) ||
    	card_kabishou1.contains(point) || card_kabishou2.contains(point) ) {

// increase the counter everytime mouse has clicked on the animal visibleimage
onMouseClick_counter++; 

// call pickAnAnimal method to determine which animal has been clicked on
this.pickAnAnimal (point);
	
// first click and the visible image that clicked on is not green(showed)
  if( onMouseClick_counter == 1 && animal.getHighlightColor() != Color.green ){

	
  // save the current animal in reference_animal1
  reference_animal1 = animal; 	
  reference_animal1.show();
  reference1_wrong_created = false;
  }
		// first click and click is on a flipped image
  else if (onMouseClick_counter == 1 && animal.getHighlightColor() ==
	   Color.green){

	   onMouseClick_counter = 0;

  }

  //in the case the second click and the click is not on a flipped image
  //set the reference1_wrong_created and reference2_wrong_created to be false
  //and assign the animal variable to be reference_animal2
  //show that animal
  if( onMouseClick_counter == 2 && animal.getHighlightColor() != Color.green ){
	
        reference1_wrong_created = false;		
	reference_animal2 = animal;
	reference_animal2.show();
	reference2_wrong_created = false;
	
  // under the second click 
  //in the case of the second click is the same as the first click
  //then set onMouseClick_counter back to 1 which indicates that 
  //the the program will assume the only assume the first animal
  //has picked and start to pick second animal
  if( reference_animal1.equals(reference_animal2) && 
      reference_animal1 == reference_animal2) {
	
	onMouseClick_counter = 1;

	}

  //under the second click 
  //in the case of the second click is a coorect match of click 1
  //then set those two picked animals' hightlight to green
  //at the mean time,show the sound that matched animal speak
  else if(reference_animal1.equals(reference_animal2) && 
	  reference_animal1 != reference_animal2 ) {
			
	reference_animal1.showHighlight(Color.green); 
	reference_animal2.showHighlight(Color.green);
		
	prompt.setText (reference_animal1.speak());
	prompt_x = (canvas.getWidth() - prompt.getWidth())/TWO;  
	//determine the x coordinate of text prompt
	
	prompt_y = (canvas.getHeight() - prompt.getHeight() - PROMTP_Y_OFFSET); 	//determient the y coordinate of text promt

	prompt.moveTo(prompt_x , prompt_y); 
	//move to the location where in the middle from 20 pixels
	//from the bottom of canvas

	onMouseClick_counter = 0;
	}	

  //in case of the second click is NOT MATCH of the first click	
  //set both flipped animals' highlight to red
  //and set 2 boolean variables relatest to them as true	
  else if (reference_animal1.equals(reference_animal2) == false ){
	
	reference_animal1.showHighlight(Color.red); 
	reference_animal2.showHighlight(Color.red);
	reference1_wrong_created = true;
	reference2_wrong_created = true;
				
	}

} // end of if (counter == 2, animal.getHighlightColor() != Color.green)

  //if the second click is on a green then set counter back to 1
  //which means that repick an animal
  else if( onMouseClick_counter == 2 && animal.getHighlightColor() ==
	   Color.green ){

	onMouseClick_counter = 1;

	}


//under the third click, and the click of this animals' color is not green
//nor the method that determine whether the image is hidden returns 
//as true (indeed the image is a hidden one)	
if( onMouseClick_counter == 3 && animal.getHighlightColor() != Color.green 
    && animal.isHidden() == true){		

        //store the current animal as reference_animal3
	//show this animal
	reference_animal3 = animal;
	reference_animal3.show();
	
	//hide the 1st and 2nd reference animal
	//and it's highlight
	reference_animal2.hide();
	reference_animal2.hideHighlight();	
	reference_animal1.hide();
	reference_animal1.hideHighlight();
	
	//switch reference_animal3 into reference_animal1     
	reference_animal1 = reference_animal3;			
	onMouseClick_counter = 1;

	//set 2 booleans which stand for whether
	//false match has been made to false
	//(back to default, hidden)
	reference1_wrong_created = false;
	reference2_wrong_created = false;
								
}	

//under the thrid click, if the clicked animal's color is red instead of red
//and it is the same as reference1 animal
//(in the case user click on the 1st NOT match animal)
if( onMouseClick_counter == 3 && animal.getHighlightColor() != Color.green 
    && animal.getHighlightColor() == Color.red && animal == reference_animal1){

	//hide the reference_animal2 and its highlight
	reference_animal2.hide();
	reference_animal2.hideHighlight();
	//hide reference_animal1's highlight
	reference_animal1.hideHighlight();
	
	//store reference_animal1 as reference_animal1
	//essentially it doesn't change
	reference_animal1 = reference_animal1;

	//set counter back to 1
	//pick 2nd animal
	onMouseClick_counter = 1;
}

//under the thrid click, if the clicked animal's color is red instead of red
//and it is the same as reference1 animal
//(in the case user click on the 2nd NOT match animal)
if( onMouseClick_counter == 3 && animal.getHighlightColor() != Color.green
    && animal.getHighlightColor() == Color.red && animal == reference_animal2){

	//hide the reference_animal2 and its highlight	
	reference_animal2.hideHighlight();

	//hide the reference_animal1 and its highlight
	reference_animal1.hide();
	reference_animal1.hideHighlight();

	//store reference_animal2 as reference_animal1
	reference_animal1 = reference_animal2;

	//set counter back to 1
	//pick 2nd animal
	onMouseClick_counter = 1;
}


//under the thrid click, if the clicked animal's color is green instead of red
//(in the case user click on the already matched animals)
if( onMouseClick_counter == 3 && animal.getHighlightColor() == Color.green
    && animal.getHighlightColor() != Color.red ){

	//hide the 1st,2nd reference_animal and its highlight		
	reference_animal2.hide();
	reference_animal2.hideHighlight();
	reference_animal1.hide();
	reference_animal1.hideHighlight();

	//set counter back to 0 
	//pick 1st animal again
	onMouseClick_counter = 0;

}


}//end of big if

//handles if the click happens at the blank part of the canvas and two
//NOT MATCH are present
//check 2 booleans that determines if 2 NOT match
//images are present. if they are, then hide both of
//them and set counter back to 0.
else if ( reference1_wrong_created && reference2_wrong_created ) {
		
	reference_animal1.hide();
	reference_animal1.hideHighlight();
	reference_animal2.hide();
	reference_animal2.hideHighlight();
	
	//set counter back to 0 
	//pick 1st animal again
	onMouseClick_counter = 0;
}

}//end of onMouseClick

}// end of class 
