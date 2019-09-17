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
    
    public String word;
    private int bottomThreshold = 500;
    private Game gameController;
    
    public Asteroid(Game controller, String s) {
        setImage("asteroid.jpg");
        word = s;
        gameController = controller;
    }
    public Asteroid(String s) {
        setImage("asteroid.jpg");
        word = s;
    }
    
    
    public void act() 
    {
        drop(1);
        if(reachedBottom()) {
            gameController.astReachedBottom(this);
            getWorld().removeObject(this);
        }
    }    
    
    public void drop(int speed) {
        setLocation(this.getX(),this.getY() + 1);
    }
    
    public boolean reachedBottom() {
        if(this.getY() > bottomThreshold)
            return true;   
        return false;
    }
    
}