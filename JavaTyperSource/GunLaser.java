import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GunLaser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GunLaser extends Actor
{
    /**
     * Act - do whatever the GunLaser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 30;
    public GunLaser(int rotation){
        setRotation(rotation);
    }
    public void act() 
    {
        move(speed);
    }    
}
