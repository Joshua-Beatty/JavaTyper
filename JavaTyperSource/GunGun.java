import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GunGun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GunGun extends Actor
{
    /**
     * Act - do whatever the GunGun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GunGun(){
    
    
    }
    public void addedToWorld(World world){
        setLocation(world.getBackground().getWidth() / 2, world.getBackground().getHeight()- 100);
        world.addObject(new GunBase(), getX(), getY() + 50);
    }
    public void act() 
    {
        //pointTo( 0, 0);
    }    
    public void destroyAsteroid(Asteroid ast){
        pointTo( ast.getX(), ast.getY());
    
    }
    public void pointTo(int x, int y) {
        int dx = x - getX(); 
        int dy = y - getY(); 
        double rotation = Math.atan2(dy, dx); 
        rotation = Math.toDegrees(rotation); 
        setRotation( (int)rotation + 90); 
    } 
}
