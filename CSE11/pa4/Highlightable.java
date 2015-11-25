/* 
 * Name: Songhao Zhou
 * Login: CS11WJC
 * Date: 2/4/2014 
 * File: Highlightable.java 
 * Purpose: declare the Highlightable iterface
 */ 
import java.awt.Color; 
public interface Highlightable 
{ 
  public void showHighlight( Color color ); 
  public void hideHighlight(); 
  public Color getHighlightColor(); 
}
