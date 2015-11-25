/* 
 * Name: Songhao Zhou
 * Login: CS11WJC
 * Date: 2/4/2014 
 * File: AnimalSpeak.java 
 * Purpose: AnimalSpeak is basically a controller of the program and it 
 * determines whether the user has the right click of the animal which 
 * sound has provided in the question. 
 */ 

import objectdraw.*;
import java.awt.*;

/* 
 * Name: AnimalSpeak
 * Purpose: In this class, it generally creates the 9 animals on the screen
 * and show them but hide the animals' hightlight when the user first started
 * the program
 */
public class AnimalSpeak extends WindowController
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

//define a constant
private static final int PROMTP_Y_OFFSET = 20;
private static final int WRONG_PROMTP_Y_OFFSET = 40;
private static final int CORRECT_PROMTP_Y_OFFSET = 40;


//set a constant 
private static final int COUNT_OF_ANIMAL_START_FROM_0 = 8;

//initialization of corresponding animal cards
private AnimalCard card_puppy;
private AnimalCard card_kitty;
private AnimalCard card_duck;
private AnimalCard card_lion;
private AnimalCard card_cow;
private AnimalCard card_lamb;
//extra animals
private AnimalCard card_triton;
private AnimalCard card_caonima;
private AnimalCard card_kabishou;


//variable of animal for switch statement;
private AnimalCard animal;
private AnimalCard last_animal;


// test object
private Text prompt, correct_prompt, wrong_prompt;


//random integer
private RandomIntGenerator randInt;

//boolean
private boolean clicked;

//counter
private int counter_4_click = 0;

//initialization of each animal's starting point
private Location PUPPY_LOCATION = new Location (203,1); 
//set puppy's starting location
private Location KITTY_LOCATION = new Location (1,1); 
//set kitty's starting location
private Location DUCK_LOCATION = new Location (102,1); 
//set duck's starting location
private Location LION_LOCATION = new Location (1,102);  
//set lion's starting location
private Location COW_LOCATION = new Location (102,102);  
//set cow's starting location
private Location LAMB_LOCATION = new Location (203,102);  
//set cow's starting location

//extra animals' location
private Location TRITON_LOCATION = new Location (1, 203);  
//set cow's starting location
private Location CAONIMA_LOCATION = new Location (102,203);  
//set cow's starting location
private Location KABISHOU_LOCATION = new Location (203,203);  
//set cow's starting location

//private static final int PIC_OFFSET = 100;
private static final double PIC_WIDTH = 100;
private static final double PIC_HEIGHT = 100;



public void begin(){
   //constuctor for 6 default animals
   card_puppy = new Puppy( getImage("puppy.jpg"), PUPPY_LOCATION , canvas);
   card_kitty = new Kitty( getImage("kitty.jpg"), KITTY_LOCATION , canvas);
   card_duck = new Duck( getImage("duck.jpg"), DUCK_LOCATION , canvas);
   card_lion = new Lion( getImage("lion.jpg"), LION_LOCATION , canvas);
   card_cow = new Cow( getImage("cow.jpg"), COW_LOCATION , canvas);
   card_lamb = new Lamb( getImage("lamb.jpg"), LAMB_LOCATION , canvas);

   //3 extra animals' constructor
   card_triton = new Triton( getImage("triton.jpg"), TRITON_LOCATION , canvas);
   card_caonima = new Caonima(getImage("caonima.jpg"),CAONIMA_LOCATION,canvas);
   card_kabishou = new Kabishou( getImage("kabishou.jpg"),
                                 KABISHOU_LOCATION , canvas);


   //constructor for random interger
   randInt = new RandomIntGenerator(0,COUNT_OF_ANIMAL_START_FROM_0);

   //generator for the question prompt, correct and wrong prompt
   prompt = new Text(" ", 0, 0, canvas);
   correct_prompt = new Text (" ", 0, 0, canvas);
   wrong_prompt = new Text (" ", 0, 0, canvas);

	
   //hide the default black highlight of each dedault animal
   card_puppy.hideHighlight();
   card_kitty.hideHighlight();
   card_duck.hideHighlight();
   card_lion.hideHighlight();
   card_cow.hideHighlight();
   card_lamb.hideHighlight();
	
   //hide the default black highlight of each dedault animal
   card_triton.hideHighlight();
   card_caonima.hideHighlight();
   card_kabishou.hideHighlight();

	
   this.pickAnAnimal(); // call the pickAnAnimal for the first time

}//end of begin

/* 
 * Name: pickAnAnimal 
 * Purpose: pickAnAnimal is served to randomly pick a animal out of 9 animals
 * by using a switch statement. After a animal is selected, it will set the 
 * question prompt, where 20 pixels above the bottom of the canvas.
 * according to the sound that this animal makes.
 * Parameters: None. 
 * Return: void
 */
public void pickAnAnimal(){

	double prompt_x , prompt_y;

	//declare an local variable as the random generated integer
	int x = randInt.nextValue();

	//switch statement
	switch(x){

	case(ZERO) : animal = card_puppy;
	break;
	
	case(ONE) : animal = card_kitty;
	break;

	case(TWO) : animal = card_duck;
	break;

	case(THREE) : animal = card_lion;
	break;

	case(FOUR) : animal = card_cow;
	break;

	case(FIVE) : animal = card_lamb;
	break;

	case(SIX) : animal = card_triton;
	break;

	case(SEVEN) : animal = card_caonima;
	break;

	case(EIGHT) : animal = card_kabishou;
	break;

	}//end of switch

	// store the last assigned animal card
	last_animal = animal;

	//set the tet content
	prompt.setText ("Which animal says " + animal.speak() + "?");
	
	//determine the x coordinate of text prompt
	prompt_x = (canvas.getWidth() - prompt.getWidth())/TWO; 
	
	//determient the y coordinate of text promt
	prompt_y = (canvas.getHeight() - PROMTP_Y_OFFSET); 
	
 	//move to the location where in the middle from 20 pixels
	 //from the bottom of canvas
	prompt.moveTo(prompt_x , prompt_y);

}//end of pickAnAnimal


/* 
 * Name: onMouseClick 
 * Purpose: Under onMouseClick, it recievesa a location formal parameter
 * point to determine whether user has clicked the correct animal that 
 * is asked for. If the click is right, set the border of that very animal
 * to gree and set it to red if not.
 * Parameters: Location point 
 * Purpose: oint is userd to checked whether user has the right click
 * Return: void
 */

public void  onMouseClick( Location point ){

	double correct_prompt_x, correct_prompt_y;
	double wrong_prompt_x, wrong_prompt_y;
	
	//check if animal is equal to null. if it is, then hide the last
	//animal's highlight, the corrected and wrong prompt that has showed
	if(  animal == null){

	last_animal.hideHighlight();
	
	correct_prompt.hide(); // hide the correct prompt
	wrong_prompt.hide(); // hide the wrong prompt
	
	//call the pickAnAnimal method to assign a animal
	this.pickAnAnimal(); 

	}

	//In the cae if animal doesn't equal to null but current animal
	//contains the point which is refered by the onMouseClick method,
	//then the program will hide the wrong prompt but show the right
	//prompt, and move the prompt to the appropriate position
	else if(animal.contains(point) && animal != null){

	wrong_prompt.hide(); // hide the wrong prompt
	correct_prompt.show();	// show the correct prompt
	
	//set the content for correct prompt
	correct_prompt.setText("CORRECT! -- Click mouse to restart.");
	correct_prompt.setColor(Color.green); // set coorect prompt to green

	//calculate the position and locating for the rompt
	correct_prompt_x = (canvas.getWidth() - correct_prompt.getWidth())/TWO;
	correct_prompt_y = (canvas.getHeight() - CORRECT_PROMTP_Y_OFFSET);
	correct_prompt.moveTo( correct_prompt_x, correct_prompt_y );

	// set the correct click to green highlight
	last_animal.showHighlight(Color.green); 
	
	// in case of puupy is the selected animal, hide the wrong highlights
	if(last_animal == card_puppy){

		card_kitty.hideHighlight();
		card_duck.hideHighlight();
		card_lion.hideHighlight();
		card_cow.hideHighlight();
		card_lamb.hideHighlight();
		card_triton.hideHighlight();
		card_caonima.hideHighlight();
		card_kabishou.hideHighlight();

		}

	// in case of kitty is the selected animal, hide the wrong highlights
	if(last_animal == card_kitty){

		card_puppy.hideHighlight();
		card_duck.hideHighlight();
		card_lion.hideHighlight();
		card_cow.hideHighlight();
		card_lamb.hideHighlight();
		card_triton.hideHighlight();
		card_caonima.hideHighlight();
		card_kabishou.hideHighlight();

		}

	// in case of duck is the selected animal, hide the wrong highlights
	if(last_animal == card_duck){

		card_kitty.hideHighlight();
		card_puppy.hideHighlight();
		card_lion.hideHighlight();
		card_cow.hideHighlight();
		card_lamb.hideHighlight();
		card_triton.hideHighlight();
		card_caonima.hideHighlight();
		card_kabishou.hideHighlight();

		}
	// in case of lion is the selected animal, hide the wrong highlights
	if(last_animal == card_lion){

		card_duck.hideHighlight();
		card_kitty.hideHighlight();
		card_puppy.hideHighlight();
		card_cow.hideHighlight();
		card_lamb.hideHighlight();
		card_triton.hideHighlight();
		card_caonima.hideHighlight();
		card_kabishou.hideHighlight();
		}

	// in case of cow is the selected animal, hide the wrong highlights
	if(last_animal == card_cow){

		card_lion.hideHighlight();
		card_duck.hideHighlight();
		card_kitty.hideHighlight();
		card_puppy.hideHighlight();
		card_lamb.hideHighlight();
		card_triton.hideHighlight();
		card_caonima.hideHighlight();
		card_kabishou.hideHighlight();
	
		}

	// in case of lamb is the selected animal, hide the wrong highlights
	if(last_animal == card_lamb){

		card_cow.hideHighlight();
		card_lion.hideHighlight();
		card_duck.hideHighlight();
		card_kitty.hideHighlight();
		card_puppy.hideHighlight();
		card_triton.hideHighlight();
		card_caonima.hideHighlight();
		card_kabishou.hideHighlight();

		}

	// in case of triton is the selected animal, hide the wrong highlights
	if(last_animal == card_triton){
		
		card_lamb.hideHighlight();
		card_cow.hideHighlight();
		card_lion.hideHighlight();
		card_duck.hideHighlight();
		card_kitty.hideHighlight();
		card_puppy.hideHighlight();
		card_caonima.hideHighlight();
		card_kabishou.hideHighlight();

		}

	// in case of caonima is the selected animal, hide the wrong highlights
	if(last_animal == card_caonima){
		
		card_lamb.hideHighlight();
		card_cow.hideHighlight();
		card_lion.hideHighlight();
		card_duck.hideHighlight();
		card_kitty.hideHighlight();
		card_puppy.hideHighlight();
		card_kabishou.hideHighlight();
		card_triton.hideHighlight();

		}

	// in case of kabishou is the selected animal, hide the wrong highlights
	if(last_animal == card_kabishou){

		card_lamb.hideHighlight();
		card_cow.hideHighlight();
		card_lion.hideHighlight();
		card_duck.hideHighlight();
		card_kitty.hideHighlight();
		card_puppy.hideHighlight();
		card_caonima.hideHighlight();
		card_triton.hideHighlight();

		}
	
	//set animal to null after having a right hit
	animal = null;

	}

	// in case the click is the WRONG one
	else if (animal.contains(point) == false && animal != null ){

		correct_prompt.hide();	
		wrong_prompt.show();
		//set content for the wrong prompt
		wrong_prompt.setText("WRONG - Try Again!");
		wrong_prompt.setColor(Color.red);
	
	// calculate position and locating for the wrong prompt	
	wrong_prompt_x = (canvas.getWidth() - wrong_prompt.getWidth())/TWO;
	wrong_prompt_y = (canvas.getHeight() - WRONG_PROMTP_Y_OFFSET);

	wrong_prompt.moveTo( wrong_prompt_x, wrong_prompt_y );
		

	// in case of pupy hightlight puppy as red and high all other highlight
	if( card_puppy.contains(point) ){
			
		card_puppy.showHighlight(Color.red);
		card_kitty.hideHighlight();
		card_duck.hideHighlight();
		card_lion.hideHighlight();
		card_cow.hideHighlight();
		card_lamb.hideHighlight();
		card_triton.hideHighlight();
		card_caonima.hideHighlight();
		card_kabishou.hideHighlight();	
	
		}
	
	//in case of kitty hightlight kitty as red and high all other highlight
	else if( card_kitty.contains(point) ){
				
		card_kitty.showHighlight(Color.red);
		card_puppy.hideHighlight();
		card_duck.hideHighlight();
		card_lion.hideHighlight();
		card_cow.hideHighlight();
		card_lamb.hideHighlight();
		card_triton.hideHighlight();
		card_caonima.hideHighlight();
		card_kabishou.hideHighlight();
	
		}

	//in case of duck hightlight duck as red and high all other highlight
	else if( card_duck.contains(point) ){
			
		card_duck.showHighlight(Color.red);
		card_kitty.hideHighlight();
		card_puppy.hideHighlight();
		card_lion.hideHighlight();
		card_cow.hideHighlight();
		card_lamb.hideHighlight();
		card_triton.hideHighlight();
		card_caonima.hideHighlight();
		card_kabishou.hideHighlight();	
	
		}
			
	//in case of lion hightlight lion as red and high all other highlight
	else if( card_lion.contains(point) ){
			
		card_lion.showHighlight(Color.red);
		card_duck.hideHighlight();
		card_kitty.hideHighlight();
		card_puppy.hideHighlight();
		card_cow.hideHighlight();
		card_lamb.hideHighlight();
		card_triton.hideHighlight();
		card_caonima.hideHighlight();
		card_kabishou.hideHighlight();			
	
		}

	//in case of cow hightlight cow as red and high all other highlight
	else if( card_cow.contains(point) ){
			
		card_cow.showHighlight(Color.red);
		card_lion.hideHighlight();
		card_duck.hideHighlight();
		card_kitty.hideHighlight();
		card_puppy.hideHighlight();
		card_lamb.hideHighlight();
		card_triton.hideHighlight();
		card_caonima.hideHighlight();
		card_kabishou.hideHighlight();
	
		}

	// in case of lamb hightlight lamb as red and high all other highlight	
	else if( card_lamb.contains(point) ){
			
		card_lamb.showHighlight(Color.red);
		card_cow.hideHighlight();
		card_lion.hideHighlight();
		card_duck.hideHighlight();
		card_kitty.hideHighlight();
		card_puppy.hideHighlight();
		card_triton.hideHighlight();
		card_caonima.hideHighlight();
		card_kabishou.hideHighlight();			
	
		}

	// in case of triton hightlight triton as red 
	// and high all other highlight			
	else if( card_triton.contains(point) ){
			
		card_triton.showHighlight(Color.red);
		card_cow.hideHighlight();
		card_lion.hideHighlight();
		card_duck.hideHighlight();
		card_kitty.hideHighlight();
		card_puppy.hideHighlight();
		card_lamb.hideHighlight();
		card_caonima.hideHighlight();
		card_kabishou.hideHighlight();			
	
		}


	// in case of caonima hightlight caonima as red
	// and high all other highlight			
	else if( card_caonima.contains(point) ){
			
		card_caonima.showHighlight(Color.red);
		card_cow.hideHighlight();
		card_lion.hideHighlight();
		card_duck.hideHighlight();
		card_kitty.hideHighlight();
		card_puppy.hideHighlight();
		card_lamb.hideHighlight();
		card_kabishou.hideHighlight();
		card_triton.hideHighlight();		
	
		}

	// in case of kabishou hightlight kabishou as red
	// and high all other highlight			
	else if( card_kabishou.contains(point) ){
			
		card_kabishou.showHighlight(Color.red);
		card_cow.hideHighlight();
		card_lion.hideHighlight();
		card_duck.hideHighlight();
		card_kitty.hideHighlight();
		card_puppy.hideHighlight();
		card_lamb.hideHighlight();
		card_triton.hideHighlight();
		card_caonima.hideHighlight();	
	
		}
		
	// in case of clicked the blank area on the canvas
	// hide the wrong prompt while hide all 9 animals' highlights
	else {
		wrong_prompt.hide();	

   		card_puppy.hideHighlight();
	   	card_kitty.hideHighlight();
	  	card_duck.hideHighlight();
	    	card_lion.hideHighlight();
	        card_cow.hideHighlight();
		card_lamb.hideHighlight();
	  	card_triton.hideHighlight();
		card_caonima.hideHighlight();
		card_kabishou.hideHighlight();
		    
	      }

	}//end of large else if

}//end of OnMouseClick

} // end of class AnimalSpeak

