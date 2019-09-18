import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    String button;
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        button = "start.png";
        GreenfootImage start = new GreenfootImage;
        drawImage(start, 3, 3);
    }
    
    /*
    public void act()
    {
       click();
    }
        
    public void started()
    {
    removeObjects(getObjects(TitleScreen.class));
}
*/
}
