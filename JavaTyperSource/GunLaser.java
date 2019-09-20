import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The gunLaser Class just moevs itself foward
 * Its main purpose is to allow for itself to be created to collide with an asteroid
 *
 * @author Josh Beatty
 * @version 2019-09-18
 */
public class GunLaser extends Actor
{
    private int speed = 30;
    /**
     * When created set its rotation to the passed parameter
     */
    public GunLaser(int rotation){
        setRotation(rotation);
    }
    /**
     * Move foward at the set frame
     */
    public void act() 
    {
        move(speed);
    }    
}
