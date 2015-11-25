/* 
 * Name: Songhao Zhou
 * Login: CS11WJC
 * Date: 2/4/2014 
 * File: Kabishou.java 
 * Purpose: Kabishou.java is the class that define for contruction of visible
 * image of Kabishou and all the methods that declared in the interfaces
 */ 
import objectdraw.*;
import java.awt.*;

/* 
 * Name: Kabishou
 * Purpose: In Kabishou class. In this constructor,
 * the program creates a visible image Kabishou and 2 framed rec that 
 * surround the Kabishou visible image and provides all the methods that
 * are declared in the interfacesThis is the constructor for the 
 */
public class Kabishou implements AnimalCard 
{ 
private static String KABISHOU_SPEAK = "ZZzzzzz";	
private VisibleImage kabishou;
private FramedRect  kabishou_border1, kabishou_border2; 
private static final int FRAMED_REC_WIDTH = 100;
private static final int FRAMED_REC_HEIGHT = 100;
private static final int BORDER_OFFSET = 1;
private static final int FRAME_OFFSET = 3;

/* 
 * Name: Kabishou
 * Purpose: This is the constructor for the Kabishou class. 
 * In this constructor,the program creates a visible image 
 * Kabishou and 2 framed rec that surround the Kabishou visible image
 * Parameters: Image pic, Location origin , DrawingCanvas canvas
 * Return: void
 */
public Kabishou(Image pic, Location origin , DrawingCanvas canvas) {
	
	kabishou = new VisibleImage (pic , origin.getX(), 
					origin.getY(), canvas);

	kabishou_border1 = new FramedRect ( origin.getX(), origin.getY(), 
					  FRAMED_REC_WIDTH-BORDER_OFFSET,
				FRAMED_REC_HEIGHT-BORDER_OFFSET, canvas);

	kabishou_border2 = new FramedRect ( origin.getX()+BORDER_OFFSET, 
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
	
	return kabishou.contains(pt);

}

/* 
 * Name: speak
 * Purpose: This method is for return what sound current animal makes while
 * controller called this method
 * Parameters: void
 * Return: CAONIMA_SPEAK, a string
 */
public String speak(){

	return KABISHOU_SPEAK;

}

/* 
 * Name: hideHighlight
 * Purpose: This method is for hide 2 framed rects' highlight that created 
 * along with the animal visibleimage
 * Parameters: none
 * Return: void
 */
public void hideHighlight(){

	kabishou_border1.hide();
	kabishou_border2.hide();

}

/* 
 * Name: showHighlight
 * Purpose: This method is to set the 2 framed rects' color and make them 
 * visible to the user when this method is called from the controller
 * Parameters: Color color 
 * Return: void
 */
public void showHighlight( Color color ){

	kabishou_border1.setColor(color);
	kabishou_border2.setColor(color);

	kabishou_border1.show();
	kabishou_border2.show();
	
	
}

/* 
 * Name: show
 * Purpose: This method is for show 2 framed rects that created along with the 
 * animal visibleimage
 * Parameters: none
 * Return: void
 */
public void show(){

	kabishou.show();

}

/* 
 * Name: hide
 * Purpose: This method is for hide 2 framed rects that created along with the 
 * animal visibleimage
 * Parameters: none
 * Return: void
 */
public void hide(){

	kabishou.hide();	

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

	return kabishou_border1.getColor();

}


/* 
 * Name: isHidden
 * Purpose: This method is to determien whether the visible images is hiden
 * then it will return boolean value
 * Parameters: none
 * Return: caonima.isHidden(), a boolean variable
 */
public boolean isHidden(){

	return kabishou.isHidden();

}

} // end of class kabishou



