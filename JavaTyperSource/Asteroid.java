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
    public boolean laserTarget = false;
    public boolean alive = true;
    private int bottomThreshold = 700;
    private Game gameController;
    private AsteroidText displayText;
    private int rspeed = 10;
    
    public Asteroid(Game controller, String s) {
        int size = (int)( Math.random() * 125 + 100);
        GreenfootImage sprite = new GreenfootImage("asteroid.png");
        sprite.scale(size, size);
        setImage(sprite);
        rspeed = (int)( Math.random() * 12 + 1);
        word = s;
        gameController = controller;
        displayText = new AsteroidText(word);
        
    }
    public Asteroid(String s) {
        int size = (int) (Math.random() * 125 + 100);
        GreenfootImage sprite = new GreenfootImage("asteroid.png");
        rspeed = (int)( Math.random() * 12 + 1);
        sprite.scale(size, size);
        setImage(sprite);
        word = s;
    }
    
    public void addedToWorld(World world) {
        world.addObject(displayText, this.getX(), this.getY());
    }
    
    public void act() 
    {
        drop(1);
        if(reachedBottom()) {
            gameController.astReachedBottom(this);
            getWorld().removeObject(displayText);
            getWorld().removeObject(this);
        }
        else if(hitByLaser() != null && laserTarget) {
            getWorld().removeObject(hitByLaser());
            getWorld().removeObject(displayText);
            getWorld().removeObject(this);
        }
    }    
    
    public void drop(int speed) {
        setRotation(getRotation() + rspeed);
        setLocation(this.getX(),this.getY() + 1);
        if(displayText.getWorld() != null ){
            displayText.setLocation(displayText.getX(), displayText.getY() + 1);
        }
    }
    
    public boolean reachedBottom() {
        if(this.getY() > bottomThreshold)
            return true;   
        return false;
    }
    
    public Actor hitByLaser() {
        Actor lazer = getOneIntersectingObject(GunLaser.class);
        return lazer;
        
    }
    
}
