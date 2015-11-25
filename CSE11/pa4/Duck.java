/* 
 * Name: Songhao Zhou
 * Login: CS11WJC
 * Date: 2/4/2014 
 * File: Duck.java 
 * Purpose: Duck.java is the class that define for contruction of visible
 * image of Duck and all the methods that declared in the interfaces
 */ 
import objectdraw.*;
import java.awt.*;

/* 
 * Name: Duck
 * Purpose: In Duck class. In this constructor,
 * the program creates a visible image Duck and 2 framed rec that 
 * surround the Duck visible image and provides all the methods that
 * are declared in the interfacesThis is the constructor for the 
 */
public class Duck implements AnimalCard 
{ 
private static String DUCK_SPEAK = "Quack";	
private VisibleImage duck;
private FramedRect  duck_border1, duck_border2; 
private static final int FRAMED_REC_WIDTH = 100;
private static final int FRAMED_REC_HEIGHT = 100;
private static final int BORDER_OFFSET = 1;
private static final int FRAME_OFFSET = 3;

/* 
 * Name: Duck
 * Purpose: This is the constructor for the Duck class. In this constructor,
 * the program creates a visible image Duck and 2 framed rec that 
 * surround the Duck visible image
 * Parameters: Image pic, Location origin , DrawingCanvas canvas
 * Return: void
 */
public Duck(Image pic, Location origin , DrawingCanvas canvas) {
	
	duck = new VisibleImage (pic , origin.getX(), origin.getY(), canvas);

	duck_border1 = new FramedRect ( origin.getX(), origin.getY(),
			 		FRAMED_REC_WIDTH-BORDER_OFFSET,
				 FRAMED_REC_HEIGHT-BORDER_OFFSET, canvas);
	
	duck_border2 = new FramedRect ( origin.getX()+BORDER_OFFSET, 
		origin.getY()+BORDER_OFFSET, FRAMED_REC_WIDTH-FRAME_OFFSET, 
				FRAMED_REC_HEIGHT-FRAME_OFFSET, canvas);

} // end of constructor



/* 
 * Name: contains
 * Purpose: This method is to check if the formal parameter that passed from 
 * the controller is contained in the visibleimage and it will return
 * a boolean value
 * Parameters: Location pt 
 * Return: caonima.contains(pt)
 */
public boolean contains(Location pt){
	
	return duck.contains(pt);

}

/* 
 * Name: speak
 * Purpose: This method is for return what sound current animal makes while
 * controller called this method
 * Parameters: void
 * Return: CAONIMA_SPEAK, a string
 */
public String speak(){

	return DUCK_SPEAK;

}

/* 
 * Name: hideHighlight
 * Purpose: This method is for hide 2 framed rects' highlight that created 
 * along with the animal visibleimage
 * Parameters: none
 * Return: void
 */
public void hideHighlight(){

	duck_border1.hide();
	duck_border2.hide();
}

/* 
 * Name: showHighlight
 * Purpose: This method is to set the 2 framed rects' color and make them 
 * visible to the user when this method is called from the controller
 * Parameters: Color color 
 * Return: void
 */
public void showHighlight( Color color ){

	duck_border1.setColor( color);
	duck_border2.setColor( color);

	duck_border1.show();
	duck_border2.show();
}

/* 
 * Name: show
 * Purpose: This method is for show 2 framed rects that created along with the 
 * animal visibleimage
 * Parameters: none
 * Return: void
 */
public void show(){

	duck.show();

}

/* 
 * Name: hide
 * Purpose: This method is for hide 2 framed rects that created along with the 
 * animal visibleimage
 * Parameters: none
 * Return: void
 */
public void hide(){

	duck.hide();	

}

/* 
 * Name: equals
 * Purpose: This method is make to check if two object belong to the same class
 * ans return a boolean value when called from controller
 * Parameters: Object o
 * Return:  (this.getClass()) .equals( o.getClass()) , a boolean value
 */
@Override
public boolean equals(Object o){

	return ( (this.getClass()) .equals( o.getClass()) );	

}

/* 
 * Name: getHighlightColor
 * Purpose: This method is to get the 2 framed rects' color and return their 
 * color to the controller when this method is called from the controller
 * Parameters: none
 * Return: caonima_border1.getColor(), a color
 */
public Color getHighlightColor(){

	return	duck_border1.getColor();

}

/* 
 * Name: isHidden
 * Purpose: This method is to determien whether the visible images is hiden
 * then it will return boolean value
 * Parameters: none
 * Return: caonima.isHidden(), a boolean variable
 */
public boolean isHidden(){

	return duck.isHidden();

}

} // end of class duck
