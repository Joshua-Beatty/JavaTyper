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
    public int randomNumbers(int min, int max) {
        return (int)((Math.random() * ((max - min) + 1)) + min);
    }
    
    public void act() {
        
        if(randomNumbers(1, 100) % 100 == 0) {       
            addAst(possibleWords.get(possibleWordIndex));
            ki.addWord(possibleWords.get(possibleWordIndex));
        }
        if(randomNumbers(1, 200) % 200 == 0) {
            displayAstArray();
        }
        if(possibleWordIndex < 8)
            possibleWordIndex++;
    }
    
    public Asteroid getAstByWord(String s) {
        for(Asteroid astItem: astArray) {
            if(astItem.word == s) {
                return astItem;
            }
        }
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
    }
    
    public void textCorrect(String s) {
        System.out.println("Correct");
        Asteroid deleteAst = getAstByWord(s);
        System.out.println(deleteAst.word);

        if(deleteAst != null) {
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
        astArray.remove(bottomAst);
        
    }
    
}
