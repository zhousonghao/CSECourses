/* 
 * Name: Songhao Zhou 
 * Login: cs11wJC
 * Date: 3/4/2014
 * File: Rational.java 
 * The main purpose of this file is to suppor basic alogorith operations
 * on the rational numbers
 */ 

import java.lang.*;



/* 
 * Name: Rational 
 * Purpose: Provides 4 different kinds of constructors, and other basic
 * math operations like add, subtract, multiply, dicision... 
 */

public class Rational 
{
	//declare the only two instance variables that we need to keep track of
  private int numerator, denominator;



  /* 
  * Name: Rational()
  * Purpose: take non argument and set numerator to 0 and denominator to 1
	* it's a constructor
  * Parameters:  None. 
  * Return: no return
  */
 
  public Rational()
  {
 		this.setNumerator(0); 
		this.setDenominator (1);
  }



  /* 
  * Name: Rational( int num)
  * Purpose: take 2 arguments and set numerator to num and denominator to 0
	* it's a constructor
  * Parameters:  int num
  * Return: no return
  */

  public Rational( int num)
  {
 		this.setNumerator(num); 
		this.setDenominator (1);
  }



  /* 
  * Name: Rational( int num, int denom)
  * Purpose: take 2 arguments and set numerator to num and denominator 
	* to denom it's a constructor
  * Parameters: int num, int denom
  * Return: no return
  */

  public Rational( int num, int denom)
  {
 		this.setNumerator(num); 
		this.setDenominator (denom);

		this.reduce();	  
  }



  /* 
  * Name: Rational( Rational r )
  * Purpose: take an Rational argument and set numerator to its num and
	* denominator to its denom; it's a copy constructor
  * Parameters:  Rational r
  * Return: no return
  */

	public Rational( Rational r ) 
  {
		r.reduce();

    this.setNumerator ( r.getNumerator() );
    this.setDenominator ( r.getDenominator() );
  }



  /* 
  * Name: getNumerator ()
  * Purpose: takes no argument; return the instance variable numerator 
  * Parameters: None
  * Return: return an integer, numerator
  */

	private int getNumerator()
  {
    return this.numerator;
  } 



  /* 
  * Name: getDenominator ()
  * Purpose: takes no argument; return the instance variable denominator 
  * Parameters: None
  * Return: return an integer, denominator
  */

	private int getDenominator() 
  {
    return this.denominator;		
  }



  /* 
  * Name: setNumerator ()
  * Purpose: takes int num; set the instance variable numerator to num 
  * Parameters: int num
  * Return: Void
  */

	private void setNumerator( int num ) 
  {
		this.numerator = num;
  }



  /* 
  * Name: setDenominator ()
  * Purpose: takes int denom; set the instance variable numerator to denom 
  * Parameters: int denom
  * Return: Void
  */

	private void setDenominator( int denom ) 
	{
		if(denom == 0)
		{
			throw new IllegalArgumentException();
		}	
    else
      this.denominator = denom;
	
	}




  /* 
  * Name: gcd (int x, int y)
  * Purpose: takes int x and y; 
  * and find the greatest common denominator 
  * Parameters: int x, int y, find the gcd based on those 2 integers
  * Return: int, the gcd
  */

	private int gcd( int x, int y ) 
  {
	  if ( y == 0)
			return x;
 		else 
			return gcd(y, x%y);

	}



  /* 
  * Name: reduce ()
  * Purpose: takes no arguments; 
	* reduce the numerator and denominator by dividing their gcd and then
  * move the sign to the top
  * Parameters: None
  * Return: Void
  */

	private void reduce() 
  {
		//call the gcd
		int gcd = this.gcd(Math.abs(this.getNumerator()),
							Math.abs(this.getDenominator()));

		int num = this.getNumerator()/gcd;
		int denom = this.getDenominator()/gcd;

		//move the sign onto the numerators
		num = num * ( denom / Math.abs(denom)  );
		denom = Math.abs(denom);

		//set the numerator and denominator
		this.setNumerator(num);
		this.setDenominator(denom);

	}

	

  /* 
  * Name: add ()
  * Purpose: takes Rational r; 
	* add the numerator and denominator of that Rational object r to the 
  * one that called this method
  * Parameters: Rational r
  * Return: Rational object
  */

	public Rational add( Rational r ) 
  { 
		//addition on the numerator
    int num = (this.getNumerator()) * (r.getDenominator()) + 
							(this.getDenominator()) * (r.getNumerator());
    
		//addition of the denominator
    int denom = (this.getDenominator()) * (r.getDenominator());

		return new Rational( num,  denom);

  }



  /* 
  * Name: subtract ()
  * Purpose: takes Rational r; 
	* subtract the numerator and denominator of that Rational object r to the 
  * one that called this method
  * Parameters: Rational r
  * Return: Rational object
  */

	public Rational subtract( Rational r ) 
	{
		//subtract the numerator
    int num = this.getNumerator() * (r.getDenominator()) - 
 							(this.getDenominator()) * (r.getNumerator());

		//subtract the denominator
		int denom = (this.getDenominator()) * (r.getDenominator());

		return new Rational( num,  denom);

	}



  /* 
  * Name: multiply ()
  * Purpose: takes Rational r; 
	* multiply the numerator and denominator of that Rational object r to the 
  * one that called this method
  * Parameters: Rational r
  * Return: Rational object
  */

	public Rational multiply( Rational r ) 
	{
		//multiply the numerator
    int num = (this.getNumerator()) * (r.getNumerator());

		//multiply the denominator
		int denom = (this.getDenominator()) * (r.getDenominator());

		return new Rational( num,  denom);

	}



  /* 
  * Name: divide ()
  * Purpose: takes Rational r; 
	* divide the numerator and denominator of that Rational object r to the 
  * one that called this method
  * Parameters: Rational r
  * Return: Rational object
  */

	public Rational divide( Rational r )
	{
		//divide the numerator
		int num = (this.getNumerator()) * (r.getDenominator());

		//divide the denominator
		int denom = (this.getDenominator()) * (r.getNumerator());

		return new Rational( num,  denom);

	}



  /* 
  * Name: toString ()
  * Purpose: print out the numerator and denominator when an Rational
  * object has called this method
  * Parameters: None
  * Return: string
  */

	public String toString() 
	{
		String s;
		
		//the case the denominator is 1, set string just to numerator
    if( this.getDenominator() == 1)
			s = "" + this.getNumerator();
		
		//the case the numerator is 1, set string just to 0
		else if ( this.getNumerator() == 0)
			s = "0";

		//else return the whole rational number
		else 
			s = this.getNumerator() + "/" + this.getDenominator();

		return s;
	}



  /* 
  * Name: toFloat ()
  * Purpose: return a float division of the result when an Rational
  * object has called this method
  * Parameters: None
  * Return: float
  */

	public float toFloat() 
	{

		float i = (float)this.getNumerator() / this.getDenominator();

		return i;

	}



  /* 
  * Name: equals ()
  * Purpose: to check if 2 object are the same type; if they are then check
  * if their contents are the same return the flag
  * Parameters: Object obj
  * Return: boolean
  */

	public boolean equals( Object obj ) 
	{
		// check the case if obj is null or two classes are different
		if(obj == null || obj.getClass() != this.getClass() ) 
			return false;

		//check if 2 objects' num and denom are not the same
		else if (	this.getNumerator() != ((Rational)obj).getNumerator() ||
			 				this.getDenominator() != ((Rational)obj).getDenominator() )
			return false;

		// the case if 2 objects' num and denom are  the same
		else 
			return true;

	}



  /* 
  * Name: hashCode ()
  * Purpose: generate a hashcode based on the toSting() then return it 
  * Parameters: None
  * Return: int
  */

	public int hashCode() 
	{
		return this.toString().hashCode();
	}



  /* 
  * Name: reciprocal ()
  * Purpose: flip the num and denom when an Rational object calls 
  * this method
  * Parameters: None
  * Return: Rational object
  */

	public Rational reciprocal() 
	{
		//check corner cases
		if(this.getNumerator() == 0)
			throw new UnsupportedOperationException();
		
		else if(this.getDenominator() == 0)
			throw new IllegalArgumentException();			
	
	  else
		{
			int num = this.getDenominator();
			int denom = this.getNumerator();

			//reduce!!
			Rational r = new Rational( num,  denom);
			r.reduce();

			//get the reduced num and denom
			num = r.getNumerator();
			denom = r.getDenominator();
			
			//System.out.println("num:"+num+"denom"+denom);

			return new Rational( num,  denom);				
		}

	}//end of reciprocal



  /* 
  * Name: floor ()
  * Purpose: round down the result (num/denom)
  * Parameters: None
  * Return: Rational object
  */

	public Rational floor()
	{
		//check the corner cases
		if(this.getDenominator() == 0)
			throw new IllegalArgumentException();

		else if(this.getNumerator() == 0)
			return new Rational(0);

		//at the case result is greater than zero
		else if( ((double)this.getNumerator()/(double)this.getDenominator()) 
							> 0 )
		{
			
			return new Rational(this.getNumerator()/ this.getDenominator(), 1);		
		}

		//case where result is negative number
		else 
		{
			//save the result in a double
			double result_double = (double)this.getNumerator() / 
														 (double)this.getDenominator();

			//cast into an int and save into another viarable
			int result_int = (int)result_double;

			//check if int result is the same as double result
			if(result_double != result_int)
			{
				//decrement answer by 1 if not equal
				int final_num = (this.getNumerator()/this.getDenominator()) - 1;

				return new Rational( final_num, 1);				
			}

			else
				//return the int result if equal
				return new Rational(this.getNumerator()/ this.getDenominator(), 1);					
		}						
	
	}//end of floor



  /* 
  * Name: ceiling ()
  * Purpose: round up the result (num/denom)
  * Parameters: None
  * Return: Rational object
  */
 
  public Rational ceiling()
	{
		//check corner cases
		if(this.getDenominator() == 0)
			throw new IllegalArgumentException();

		else if(this.getNumerator() == 0)
			return new Rational(0);

		//in the case greater than 0
		else if ( ((double)this.getNumerator()/(double)this.getDenominator()) 
							> 0  )
		{
			//save the result in a double			
			double result_double = (double)this.getNumerator() / 
														 (double)this.getDenominator();

			//cast into an int and save into another viarable
			int result_int = (int)result_double;
	
			//if not euqal the increment int result by 1
			if(result_double != result_int)
			{
				++result_int;

				return new Rational( result_int, 1);				
			}

			//simply return the int result if euqal
			else
			{
				return new Rational( result_int, 1);				
			}
		}

		//in the case less than 0
		else
		{
			double result_double = (double)this.getNumerator() / 
														 (double)this.getDenominator();

			int result_int = (int)result_double;
	
				return new Rational( result_int, 1);				

		}

	}//end if ceiling
  
}//end of class

