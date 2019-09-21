import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title creates the primary background image for the game.
 * 
 * @author Derek Xu
 * @version 9/20/19
 */
public class Title extends World
{

    /**
     * Constructor for objects of class Title.
     * Sets dimensions 1200 x 800
     */
    public Title()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        prepare();
    }
    
    /**
     * Constructor for objects of class Title.
     * Sets dimensions 1200 x 800 and holds the player's score as an object
     */    
    public Title(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        prepare();
        
        addObject(new text("Score: " + score), 600, 750);
    }
    /**
     * Prepare method places buttons and title text in specific areas
     * Places button at 600, 550 and text at 600, 200
     */
    private void prepare() {
        Start start = new Start();
        addObject(start, 600, 200);
        
        Button button = new Button();
        addObject(button, 600, 550);
    }
}
