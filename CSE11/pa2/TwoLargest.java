import java.util.*;
import java.lang.Math.*;

public final class TwoLargest{

public static void main(String [] args) 
{
int first_number ;
int current_number;  // variable to track the cuurent number scanned
int number;
int largest_number; 
int second_largest_number;

Scanner input = new Scanner (System.in);  // construct a new scanner to read the input integers
System.out.println("Enter a series of integers; EOF to Quit.");
	

//store the first reading of integer as the largest and set second largest as the same (to initialize the variable)
if( input.hasNext() ){

 	largest_number	= input.nextInt();
	second_largest_number = largest_number;   // assign the largest number so far to the second largest number
 	//System.out.format("%d%n",largest_number); (test)

}
	else {
		System.out.println("No numbers entered."); // if there's no input, print out "no numbers entered"
		largest_number = 0;   //reset largest number value
		second_largest_number = 0;  // reset second largest number value
		System.exit(0);
	}


//check and store the second reading of integer
if (input.hasNext() ){

	current_number = input.nextInt(); // store the second reading of integer into current number 
	

	//check if current number is larger or euqal to largest number so far
	if (current_number >= largest_number){

		second_largest_number = largest_number;  // move the largest number to second largest numebr (if true)
		largest_number = current_number; 	// set current number to the largest number (if true)
		
	
	}
	else{

		second_largest_number = current_number;  //set the current number to the second largest number (if false)
		//System.out.format("%d%n",second_largest_number);

	}


} 

// if there's no input of second integer, print out the only and the largest number so far
else{
	System.out.println("");
	System.out.format("Largest distinct number entered was %d%n",largest_number);
	second_largest_number = 0;
	System.exit(0);
}


// if there's more input, stay in the while loop
while( input.hasNext() ){

 	current_number = input.nextInt();  // store the next input in current number

	//System.out.format("%d%n",current_number); (test)
	//System.out.format("%d%n",largest_number); (test)

	//check current number conditions
	if(current_number > largest_number){
	
	second_largest_number = largest_number;  //if current number is larger than the largest number so far, move the current largest number into second largest number (if true)
	
	largest_number = current_number; // set current number as the largest number (if true)

	//System.out.format("%d%n",largest_number);(test)

	}

	// if current number is equal to the largest number so far, nothing changes
	else if (current_number == largest_number){

	largest_number = current_number; // reset the largest number (actually nothing changes)

	}

	// if current number is not smaller than the second largest number, replace the second largesr number with current number
	else if(current_number >= second_largest_number) {
	
	second_largest_number = current_number;
	//System.out.format("%d%n",second_largest_number);


	}

	//System.out.format("%d%n",second_largest_number);


}

//check if the same integers has entered couple times. if true, only print out the largest number

if(largest_number == second_largest_number ){

	System.out.format("Largest distinct number entered was %d%n",largest_number);
	System.exit(0);

}

//print out the final result if there's no corner case
else{
	System.out.println("");

	System.out.format("Largest distinct number entered was %d%n",largest_number);

	System.out.format("Second largest distinct number entered was %d%n",second_largest_number);
}



 }//end of main
}// end of class

