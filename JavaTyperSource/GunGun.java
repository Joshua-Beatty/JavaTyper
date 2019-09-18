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
    World wd;
    public GunGun(){
    }
    public void addedToWorld(World world){
        setLocation(world.getBackground().getWidth() / 2, world.getBackground().getHeight()- 100);
        world.addObject(new GunBase(), getX(), getY() + 50);
        wd = world;
        setRotation(-90);
    }
    public void act() 
    {
    }    
    //Call this method to shoot a laser at a specific asteroid
    public void destroyAsteroid(Asteroid ast){
        pointTo(ast.getX(), ast.getY());
        createLaseer(getRotation());
    }
    
    public void pointTo(int x, int y) {
        int dx = x - getX(); 
        int dy = y - getY(); 
        double rotation = Math.atan2(dy, dx); 
        rotation = Math.toDegrees(rotation); 
        setRotation( (int)rotation); 
    } 
    
    public void createLaseer(int rotation){
        wd.addObject(new GunLaser(rotation), getX(), getY());
    }
}
