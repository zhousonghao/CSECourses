/* 
 * Name: Songhao Zhou 
 * Login: cs11wJC
 * Date: 2/20/2014
 * File: ReverseRecurse.java 
 * Responsible for constructing the array while contains 2 reverse 
 * method which does recursion on the input array and then flip
 * them in reverse order and print out.
 */ 

import java.util.*;

/* 
 * Name: ReverseRecurse 
 * Purpose: this class is mainly serving the purpose for creating a user
 * specified array and provide 2 method which are designed to reverse the 
 * order of user-specified array 
 */
public class ReverseRecurse{

private int[] myArray, fixed_my_array; //initialization of array
private static final int TWO = 2;

  /* 
  * Name: initArray()
  * Purpose: Take input from the user and check the whether the first 
  * input, which is to specify the size of the array, is valid and then
  * keep reading the nextInt and built the array.
  * Parameters: None. 
  * Return: This method returns an integer array which will be passed
  * on to print method when it called to print the array out.
  */
  public int[] initArray() 
  {
  int input_int;
  int array_size = 0;

  //counter for the default count; real counter for actual count
  int counter = 0, real_counter = 0; 

  
  System.out.printf( "Maximum number of integers you wish to enter? ");
  Scanner in = new Scanner( System.in ); 

  /* this if statement is to check whether the first integer that user
     has typed in is valid ( the int to specify the size of array).if
     it is not valid the exit the program */
  if( in.hasNextInt() )
  {
    array_size = in.nextInt();

    // the while loop will keep asking for a valid input of array size
    while( array_size <=0 )
    {
      System.out.println("You must enter a value > 0; Try again.\n");
      System.out.printf("Maximum number of integers you wish to enter? ");
      array_size = in.nextInt();    
    } 

  }//end of if
  else
    System.exit(1);

  System.out.printf( "\nEnter up to %d integers %n", array_size );

  //construction of myArray
  myArray = new int[array_size];

  // the for loop is keeping scan each number into the array while method 
  // "hasNextInt()" returned a true value
  for( counter=0; counter < array_size  ; counter++ )
  {    
    if(in.hasNextInt())
    {
      myArray[counter] = in.nextInt();
      real_counter ++;
    }
  }

  // this if statement is designed to handle the situation which the
  // number that user typed in to construct the array is actually less
  // the the size user has specified before.
  if( real_counter < array_size )
  {    
    fixed_my_array = new int[real_counter];
    //array_size = real_counter;
    System.arraycopy( myArray, 0, fixed_my_array, 0, real_counter);
 
    //assign the new modified array
    myArray = fixed_my_array;
  } 

  return myArray;

  }//end of initArray

 
  /* 
  * Name: printArray 
  * Purpose: This method is in charge of printing out all elements in
  * the array.
  * Parameters: int[] array. This method takes int[] array in order
  * to print out the elemnts in the array
  * Return: void
  */	
  public void printArray( int[] array ) 
  {
    int i;

    //check if the length of array is 0. If so, print out empty array
    if(array.length == 0)
    {
      System.out.println("Empty Array");
    }

    else 
    // if array is not empty print out all the elements of the array
    {
      for( i=0; i < array.length ; i++ )
      {
        System.out.printf("%d ",array[i]);
      }
      
      System.out.println("");
	
    }

  }//end of printArray 
 

  /* 
  * Name: reverse 
  * Purpose: This method is designed to reverse the order the array that 
  * user has typed in by comparing the low and high index in that array.
  * since low index can never exceed the high index thus when 
  * Parameters: int[] array. This method takes int[] array in order
  * to print out the elemnts in the array
  * Return: void
  */	
  public void reverse( int[] originalArray, int low, int high )
  {
    int temp;
	
    if( high > low && high != low && originalArray!= null )
    {

      temp = originalArray[low];
      originalArray[low] = originalArray[high];
      originalArray[high] = temp;

      high--;
      low++;
	
      reverse(originalArray, low, high );
    }  

  }//end of reverse void 


  /* 
  * Name: reverse
  * Purpose: This second reverse method is designed to flip the order that
  * user has entered in a different fashion. In this method, it will create
  * a new array which copys the original array that passed in. Then the
  * method will truncate the left and right side of that array and store
  * the middle part into a 3rd array (temp_array in my case). Then the
  * method will call it self and repeat it form truncating and storing.
  * After it truncated down to only 1 or 0 left, then it will return
  * that very value and shove it back into the copy_array which has left
  * and right end swapped already. It will keep shove it back in ultill 
  * it fills the whole_copy_array.
  * Parameters: int[] originalArray , this method takes originalArray 
  * in order to make a copy and do the rest of swap.
  * Return: int[], return a integer array that has swapped
  */
  public int[] reverse( int[] originalArray ) 
  {
    int number;

    // declare 2 arrays. copyArray is for copy the original array
    // tempArray is for store fot the temp (after truncating)
    int[] copyArray, tempArray; 

    //handle the null situation
    if(originalArray == null)
      return originalArray;

    //store array length to variable length
    number = originalArray.length;
  
    //initialize array
    copyArray = new int[number];

    /*in case of the BASE CASE, number is greater than 1 and array is not
    null*/
    if( number > 1 && originalArray != null)
    {
      //swap the head and end
      copyArray[0] = originalArray[number-1];
      copyArray[number-1] = originalArray[0];

      //change of size by 2 when creating new array
      number = number - TWO;

      //initialize new array
      tempArray = new int[number];

      //copy the middle part of original array
      System.arraycopy( originalArray, 1, tempArray, 0, number);
 
      //use the recursive call of the reverse
      tempArray = reverse(tempArray);

      //after it reaches the base case, shove the temp array back into
      //the last copyarray that has been truncated
      System.arraycopy( tempArray, 0, copyArray, 1, number);
	
      //return the copyarray that has been filled by temp array
      return copyArray;

    }

    //return the last original array when BAE CASE reched
    else 
      return originalArray;

  }//end of reverse

} // end of class
