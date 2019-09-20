import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Typed text actor is an empyt class used to display text
 * 
 * @author Josh Beatty
 * @version 2019-09-18
 */
public class TypedText extends Actor
{
    private int offset = 50;
    
    /**
     * Sets its position based of teh screen size
     */
    public void act() 
    {
        setLocation((int)(getImage().getWidth() * .5) + offset, getY());
    }    
}
