import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends Actor
{
    /**
     * Act - do whatever the Game wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int randomNumbers(int min, int max) {
        return (int)((Math.random() * ((max - min) + 1)) + min);
    }
    
    public void act() {
        
    }
    
    public void addedToWorld(World world) {
        int randStartCoor = randomNumbers(0, 1200);
        System.out.println("lol");
        Asteroid ast = new Asteroid();
        world.addObject(ast, randStartCoor, 0);
        Greenfoot.delay(20);
    }
    
    public void textCorrect(String s) {
        
    }
    
    public void textIncorrect() {
    
        }
    
}
