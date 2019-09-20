import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The text method is just a class to display text as an actor
 * 
 * @author Josh Beatty
 * @version 2019-09-18
 */
public class text extends Actor
{
    /**
     * This constructor just creates an image of the text and displays it
     */
    public text(String textToDisplay){
    
        GreenfootImage scoreImage = new GreenfootImage(textToDisplay, 50, Color.WHITE, Color.BLACK, Color.WHITE);
        setImage(scoreImage);
    }
    /**
     * The setText functino generate a new image and displays it of the passes text
     * @param textToDisplay the text to display
     */
    public void setText(String textToDisplay){
    
        GreenfootImage scoreImage = new GreenfootImage(textToDisplay, 50, Color.WHITE, Color.BLACK, Color.WHITE);
        setImage(scoreImage);
    
    }
}
