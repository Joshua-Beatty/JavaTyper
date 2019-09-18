import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

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
    
    private ArrayList<Asteroid> astArray = new ArrayList<Asteroid>();
    private KeyboardInput ki = new KeyboardInput(this);
    private ArrayList<String> possibleWords = Sheet.main("syntax.txt");
    private int possibleWordIndex = 0;
    private GunGun mainGun = new GunGun();
    
    public int randomNumbers(int min, int max) {
        return (int)((Math.random() * ((max - min) + 1)) + min);
    }
    
    public void act() {
        
        if(randomNumbers(1, 100) % 100 == 0) {       
            addAst(possibleWords.get(possibleWordIndex));
            ki.addWord(possibleWords.get(possibleWordIndex));
            if(possibleWordIndex < (possibleWords.size() - 1))
                possibleWordIndex++;
        }
        if(randomNumbers(1, 200) % 200 == 0) {
            displayAstArray();
        }
            
    }
    
    public Asteroid getAstByWord(String s) {
        for(Asteroid astItem : astArray) {
            System.out.println(astItem.word);
            if(astItem.word.equals(s)) {
                return astItem;
            }
        }
        System.out.println("returned null ast");
        return null;
    }
    
    public void addAst(String s) {
        int randStartCoor = randomNumbers(0, 1200);
        Asteroid aster = new Asteroid(this, s);
        astArray.add(aster);
        getWorld().addObject(aster, randStartCoor, 0);
    }
    
    
    public void addedToWorld(World world) {        
        world.addObject(ki, 0, 0);
        world.addObject(mainGun, 0, 0);
    }
    
    public void textCorrect(String s) {
        Asteroid deleteAst = getAstByWord(s);        
        if(deleteAst != null) {
            ki.removeWord(deleteAst.word);

            mainGun.destroyAsteroid(deleteAst);
            getWorld().removeObject(deleteAst);
        }
        astArray.remove(deleteAst);
        
    }
    
    public void displayAstArray() {
        System.out.println("--astArray--");
        for(Asteroid astItem: astArray) {
            System.out.println(astItem.word);
        }
        System.out.println("------------");
    }
    
    public void textIncorrect() {
        System.out.println("InCorrect");
    
    }
    
    public void astReachedBottom(Asteroid bottomAst) {
        ki.removeWord(bottomAst.word);
        astArray.remove(bottomAst);
        
    }
    
}
