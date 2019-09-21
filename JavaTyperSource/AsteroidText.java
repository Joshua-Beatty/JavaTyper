import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * AsteroidText displays the text in a readable format to move with the asteroids. 
 * 
 * @author Vikas Ummadisetty
 * @version 9/20/19
 */
public class AsteroidText extends Actor
{    
    private String word;
    /**
     * Constructor for AsteroidText which sets word member variable and sets image for displaying text
     */
    AsteroidText(String s) {
        word = s;
        GreenfootImage textDisplay = new GreenfootImage(word, 50, Color.WHITE, Color.BLACK, Color.BLACK);
        setImage(textDisplay);
    }
    
    /**
     * Does not do anything in act. All movements are in Asteroid class
     */
    public void act() 
    {
       
    }    
}
