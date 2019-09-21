import greenfoot.*;  

/**
 * Asteroid class contains instructions for asteroid movements, rate of falling, rate of spinning, size, and word selection.
 * 
 * @author Vikas Ummadisetty
 * @version 9/20/19
 */
public class Asteroid extends Actor
{
    public String word;
    public boolean laserTarget = false;
    public boolean alive = true;
    private int bottomThreshold = 700;
    private Game gameController;
    private AsteroidText displayText;
    private int rspeed = 10;
    /** 
     * Constructor for Asteroid Class
     * Sets local member variables and speed and size of asteroids
     * Assigns asteroids words
     */
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
    /**
     * Overloading method if Game Controller is not provided
     */
    public Asteroid(String s) {
        int size = (int) (Math.random() * 125 + 100);
        GreenfootImage sprite = new GreenfootImage("asteroid.png");
        rspeed = (int)( Math.random() * 12 + 1);
        sprite.scale(size, size);
        setImage(sprite);
        word = s;
    }
    /**
     * Add asteroid text to world at asteroid's current location
     */
    public void addedToWorld(World world) {
        world.addObject(displayText, this.getX(), this.getY());
    }
    
    /**
     * Moves asteroid towards bottom. If the asteroid reaches bottom, it is removed and lives are deducted.
     * If hit by a laser, it is removed and points are gained.
     */
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
    /**
     * Drops asteroid at a particular speed and rotates it at particular speed
     * @param speed of asteroid falling 
     */
    public void drop(int speed) {
        setRotation(getRotation() + rspeed);
        setLocation(this.getX(),this.getY() + 1);
        if(displayText.getWorld() != null ){
            displayText.setLocation(displayText.getX(), displayText.getY() + 1);
        }
    }
    /**
     * Checks if asteroid reaches bottom
     * @return true or false to whether asteroid hits bottom
     */
    public boolean reachedBottom() {
        if(this.getY() > bottomThreshold)
            return true;   
        return false;
    }
    
    /**
     * Checks if asteroid is hit by laser
     * @return GunLaser object which hit asteroid
     */
    public Actor hitByLaser() {
        Actor lazer = getOneIntersectingObject(GunLaser.class);
        return lazer;
    }
    
}
