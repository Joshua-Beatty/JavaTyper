import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;


/**
 * Game class controls all aspects of the game, including asteroid generation, keyboard input, and laser animations
 * 
 * @author Vikas Ummadisetty
 * @version 9/20/19
 */
public class Game extends Actor
{
    private ArrayList<Asteroid> astArray = new ArrayList<Asteroid>();
    private KeyboardInput ki = new KeyboardInput(this);
    private ArrayList<String> possibleWords = Sheet.main("syntax.txt");
    private int possibleWordIndex = 0;
    private GunGun mainGun = new GunGun();
    private int astSpawnCounter = 0;
    private int score = 0;
    private int life = 3;
    private text scoreText;
    private text lifeText;
    
    /**
     * Constructor for game class. Creates life & score texts as well as shuffles possibleWords arrayList
     */
    public Game() {
        Collections.shuffle(possibleWords);
        scoreText = new text("Score: " + score);
        lifeText = new text("Life: " + life);
    }
    
    /**
     * Generates random numbers
     * @param minimum and maximum random numbers
     * @return randomly generated number in range
     */
    public int randomNumbers(int min, int max) {
        return (int)((Math.random() * ((max - min) + 1)) + min);
    }
    
    /**
     * Act method: updates text, spawns asteroids, updates asteroid arrayList index, and sets title screen functions
     */
    public void act() {
        scoreText.setText("Score: " + score);
        lifeText.setText("Life: " + life);
        if(astSpawnCounter > 400) {       
            addAst(possibleWords.get(possibleWordIndex));
            ki.addWord(possibleWords.get(possibleWordIndex));
            astSpawnCounter = 1;
            if(possibleWordIndex < (possibleWords.size() - 1)) {
                possibleWordIndex++;
            }
            else {
                Collections.shuffle(possibleWords);
                possibleWordIndex = 0;
            }
        }
        astSpawnCounter = astSpawnCounter + randomNumbers(1, 5);     
        if(life == 0){
            Greenfoot.setWorld(new Title(score));
        }
    }
    /**
     * Gets asteroid object by name
     * @param string name of word asteroid refers to
     * @return Asteroid object with name specified
     */
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
    
    /**
     * Creates asteroid and adds to world at random x coordinate
     * @param string word of asteroid
     */
    public void addAst(String s) {
        int randStartCoor = randomNumbers(200, 1000);
        Asteroid aster = new Asteroid(this, s);
        astArray.add(aster);
        getWorld().addObject(aster, randStartCoor, 0);
    }
    
    /**
     * When object is initialized, adds objects to world
     * @param World the Game controller lives in
     */
    public void addedToWorld(World world) {        
        world.addObject(ki, 0, 0);
        world.addObject(mainGun, 0, 0);
        world.addObject(scoreText, 90, 20);
        world.addObject(lifeText, 70, 70);
    }
    
    /**
     * Executes when user correctly types word. Deletes asteroid, increments score, removes words, and destroys asteroid with laser
     * @param string what user types correctly
     */
    public void textCorrect(String s) {
        Asteroid deleteAst = getAstByWord(s);        
        if(deleteAst != null) {
            score++;
            ki.removeWord(deleteAst.word);
            mainGun.destroyAsteroid(deleteAst);
            deleteAst.laserTarget = true;
            //getWorld().removeObject(deleteAst);
        }
        astArray.remove(deleteAst);
    }
    
    /**
     * Displays asteroid array to console for debugging purposes
     */
    public void displayAstArray() {
        System.out.println("--astArray--");
        for(Asteroid astItem: astArray) {
            System.out.println(astItem.word);
        }
        System.out.println("------------");
    }
    
    /**
     * Executes if user types word incorrectly
     */
    public void textIncorrect() {
        System.out.println("InCorrect");
    
    }
    
    /**
     * Executes if asteroid reaches bottom. When asteroid reaches bottom, removes asteroid from world and ArrayList, and decrements life number
     * @param Asteroid object bottomAst which touched the bottom
     */
    public void astReachedBottom(Asteroid bottomAst) {
        ki.removeWord(bottomAst.word);
        astArray.remove(bottomAst);
        life--;
    }
    
}
