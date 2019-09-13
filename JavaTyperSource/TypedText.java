import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TypedText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TypedText extends Actor
{
    /**
     * Act - do whatever the TypedText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int offset = 50;
    public TypedText(){
    }
    public void act() 
    {
        setLocation((int)(getImage().getWidth() * .5) + offset, getY());
    }    
}
