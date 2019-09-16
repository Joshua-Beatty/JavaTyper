import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends Actor
{
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Asteroid() {
        setImage("asteroid.jpg");
        setLocation(600, 400);
    }
    
    
    public void act() 
    {
        setLocation(this.getX(),this.getY() + 1);
        Greenfoot.delay(1);
    }    
}
