import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AsteroidText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroidText extends Actor
{
    /**
     * Act - do whatever the AsteroidText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private String word;
    
    
    AsteroidText(String s) {
        word = s;
        GreenfootImage textDisplay = new GreenfootImage(word, 50, Color.WHITE, Color.BLACK, Color.BLACK);
        setImage(textDisplay);
    }
    
    public void act() 
    {
       
    }    
}
