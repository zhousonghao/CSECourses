/* 
 * Name: Songhao Zhou
 * Login: CS11WJC
 * Date: 2/4/2014 
 * File: AnimalCard.java 
 * Purpose: declare the AnimalCard iterface
 */ 
interface AnimalCard extends Speakable, Highlightable, Hideable
{ 
	@Override 
 	public abstract boolean equals(Object o);
 
 	public abstract boolean isHidden();	
	
} 
