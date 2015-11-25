/* 
 * Name: Songhao Zhou
 * Login: CS11WJC
 * Date: 2/4/2014 
 * File: Lion.java 
 * Purpose: Lion.java is the class that define for contruction of visible
 * image of Lion and all the methods that declared in the interfaces
 */
import objectdraw.*;
import java.awt.*;

/* 
 * Name: Lion
 * Purpose: In Lion class. In this constructor,
 * the program creates a visible image Lion and 2 framed rec that 
 * surround the Lion visible image and provides all the methods that
 * are declared in the interfacesThis is the constructor for the 
 */
public class Lion implements AnimalCard 
{ 
private static String LION_SPEAK = "Roar";	
private VisibleImage lion;
private FramedRect  lion_border1, lion_border2; 
private static final int FRAMED_REC_WIDTH = 100;
private static final int FRAMED_REC_HEIGHT = 100;
private static final int BORDER_OFFSET = 1;
private static final int FRAME_OFFSET = 3;

/* 
 * Name: Lion
 * Purpose: This is the constructor for the Lion class. In this constructor,
 * the program creates a visible image Lion and 2 framed rec that 
 * surround the Lion visible image
 * Parameters: Image pic, Location origin , DrawingCanvas canvas
 * Return: void
 */
public Lion(Image pic, Location origin , DrawingCanvas canvas) {
	
	lion = new VisibleImage (pic , origin.getX(), origin.getY(), canvas);

	lion_border1 = new FramedRect ( origin.getX(), origin.getY(), 
					FRAMED_REC_WIDTH-BORDER_OFFSET, 
				FRAMED_REC_HEIGHT-BORDER_OFFSET, canvas);

	lion_border2 = new FramedRect ( origin.getX()+BORDER_OFFSET, 
					origin.getY()+BORDER_OFFSET, 
					FRAMED_REC_WIDTH-FRAME_OFFSET, 
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
	
	return lion.contains(pt);

}

/* 
 * Name: speak
 * Purpose: This method is for return what sound current animal makes while
 * controller called this method
 * Parameters: void
 * Return: CAONIMA_SPEAK, a string
 */
public String speak(){

	return LION_SPEAK;

}

/* 
 * Name: hideHighlight
 * Purpose: This method is for hide 2 framed rects' highlight that created 
 * along with the animal visibleimage
 * Parameters: none
 * Return: void
 */
public void hideHighlight(){

	lion_border1.hide();
	lion_border2.hide();

}

/* 
 * Name: showHighlight
 * Purpose: This method is to set the 2 framed rects' color and make them 
 * visible to the user when this method is called from the controller
 * Parameters: Color color 
 * Return: void
 */
public void showHighlight( Color color ){

	lion_border1.setColor( color);
	lion_border2.setColor( color);

	lion_border1.show();
	lion_border2.show();
	
}

/* 
 * Name: show
 * Purpose: This method is for show 2 framed rects that created along with the 
 * animal visibleimage
 * Parameters: none
 * Return: void
 */
public void show(){

	lion.show();

}

/* 
 * Name: hide
 * Purpose: This method is for hide 2 framed rects that created along with the 
 * animal visibleimage
 * Parameters: none
 * Return: void
 */
public void hide(){

	lion.hide();	

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

	return (( this.getClass()) .equals( o.getClass()) );

}

/* 
 * Name: getHighlightColor
 * Purpose: This method is to get the 2 framed rects' color and return their 
 * color to the controller when this method is called from the controller
 * Parameters: none
 * Return: caonima_border1.getColor(), a color
 */
public Color getHighlightColor(){

	return lion_border1.getColor();

}

/* 
 * Name: isHidden
 * Purpose: This method is to determien whether the visible images is hiden
 * then it will return boolean value
 * Parameters: none
 * Return: caonima.isHidden(), a boolean variable
 */
public boolean isHidden(){

	return lion.isHidden();

}

} // end of class lion
