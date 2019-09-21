import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Vikas Ummadisetty
 * @version 9/20/19
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld. Creates world as 1200x800 and instantiates Game object
     */
    public MyWorld()
    {    
        super(600*2, 400*2, 1); 
        Game game = new Game();
        addObject(game, 0, 0);
    }
}
