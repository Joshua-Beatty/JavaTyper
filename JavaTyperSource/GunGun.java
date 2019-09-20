import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GunGun here.
 * 
 * @author Josh Beatty
 * @version 2019-09-18
 */
public class GunGun extends Actor
{
    World wd;
    /**
     * WHen added to world set is location and create a gunbase object
     */
    public void addedToWorld(World world){
        setLocation(world.getBackground().getWidth() / 2, world.getBackground().getHeight()- 100);
        world.addObject(new GunBase(), getX(), getY() + 50);
        wd = world;
        setRotation(-90);
    }
    /**
     * When called it points at the passed object and shoots a laser at it
     */
    //Call this method to shoot a laser at a specific asteroid
    public void destroyAsteroid(Asteroid ast){
        pointTo(ast.getX(), ast.getY());
        createLaser(getRotation());
    }
    /**
     * When called point towards the specified point
     */
    public void pointTo(int x, int y) {
        int dx = x - getX(); 
        int dy = y - getY(); 
        double rotation = Math.atan2(dy, dx); 
        rotation = Math.toDegrees(rotation); 
        setRotation( (int)rotation); 
    } 
    /**
     *  When called shoot a laser at the passed rotaion
     */
    public void createLaser(int rotation){
        wd.addObject(new GunLaser(rotation), getX(), getY());
    }
}
