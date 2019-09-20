import greenfoot.*;
import java.util.ArrayList;
/**
 * The KeyboardInput Class takes into user input and displays it
 * It then checks it against a list of words displaying it in different colors
 * It also calls a specific fuction in a nother calss passing along the word that was entered
 * 
 * @author Josh Beatty 
 * @version 2019-09-18
 */
public class KeyboardInput extends Actor
{
    public String text = "";
    private String rawInput = "";
    private String keyPressed = "";
    private GreenfootImage background;
    private TypedText TypedTextActor = new TypedText();
    private ArrayList<String> availableWords = new ArrayList<String>();
    private Game gameController;
    
    /**
     * Base constructor used for testing 
     */
    public KeyboardInput()
    {
    }
    /**
     * Constructor for live game, allows the calling of functions in the gameController class
     */
    public KeyboardInput(Game gController)
    {
        gameController = gController;
    }
    
    /**
     * When added to the world save the background world and add a text object to the world.
     */
    public void addedToWorld(World world){
        background = world.getBackground();
        world.addObject(TypedTextActor, 0, 700);
        
        /*
        availableWords.add("help");
        availableWords.add("hello");
        availableWords.add("how");
        availableWords.add("bello");
        //*/
    }
    
    /**
     * Every frame save the input and add it to the text variable if it is a valid character
     * it also displays text based on how much of it is correct
     */
    public void act(){
        rawInput = Greenfoot.getKey();
        if(rawInput != null){
            if(rawInput.length() == 1){
                if(Character.isLetter(rawInput.charAt(0)) || Character.isDigit(rawInput.charAt(0))){
                    text = text + rawInput;
                } else if ( "[]-+_=/?.,;()\"!@#$%^&*'".contains(rawInput)){
                    text = text + rawInput;
                }
                
            }
            if(rawInput == "space"){
                text = text + " ";
            }
            if(rawInput == "enter"){
                entered(text);
                text = "";
            }
            if(rawInput == "backspace"){
                if(0 != text.length()){
                    text = text.substring(0, text.length() - 1);
                } else {
                    text = "";
                }
            }
        }
        if(textFinalCorrect(text)){
            displayCorrectText(text);
        } else {
            displayWhiteRed(text, checktext(text));
        }
    }
    
    /**
     * This function calls the game controller class based on if the input matches the list
     *  @param input the text to be checked against the list and passed to the game controller class
     */
    public void entered(String input){
        if(textFinalCorrect(text)){
            gameController.textCorrect(text);
        } else {
            gameController.textIncorrect();
        }
    }
    
    /**
     * Called to add a word to the arraylist
     * @param input the string to be added to the arraylist
     */
    public void addWord(String input){
        availableWords.add(input);
    }
    
    /**
     * Called to remove a word from the arraylist
     * @param input the word to be removed
     */
    public void removeWord(String input){
        int indexOfWord = availableWords.indexOf(input);
        if(indexOfWord != -1){
            availableWords.remove(indexOfWord);
        }
    }
    
    /**
     * displays text based on how much of the text is correct
     * @param textToDisplay the text to display
     * @param WhiteCharacters an int number for the number of white characters to display as opposed to red
     */
    private void displayWhiteRed(String textToDisplay, int  WhiteCharacters){
        int fontSize = 50;
        GreenfootImage whiteText = new GreenfootImage(textToDisplay.substring(0, WhiteCharacters), fontSize, Color.WHITE, Color.BLACK, Color.WHITE);
        GreenfootImage redText = new GreenfootImage(textToDisplay.substring(WhiteCharacters, textToDisplay.length()), fontSize, Color.RED, Color.BLACK, Color.WHITE);
        GreenfootImage finalImage = new GreenfootImage(redText.getWidth()+whiteText.getWidth(),whiteText.getHeight());
        finalImage.drawImage(whiteText, 0, 0);
        finalImage.drawImage(redText, whiteText.getWidth(), 0);
        
        TypedTextActor.setImage(finalImage);
    }
    
    /**
     * Called when the text is correct to display green text
     * @param textToDisplay the text to display in green
     */
    private void displayCorrectText(String textToDisplay){
        int fontSize = 50;
        GreenfootImage finalImage = new GreenfootImage(textToDisplay, fontSize, Color.GREEN, Color.BLACK, Color.WHITE);
              
        TypedTextActor.setImage(finalImage);
    }
    
    /**
     * Checks how much of the typed text is correct
     * @param text the text to be checked against the arrayList
     * @return the number of correct characters
     */
    private int checktext(String text){
        int correctCharacters = 0;
        for(int i = 1; i < text.length() + 1; i++){
            if(availableWords.size() != 0){
                for (int j = 0; j < availableWords.size(); j++){
                    if(availableWords.get(j).contains(text.substring(0,i))){
                        correctCharacters = i;
                    }
                }
            }
        }
        return correctCharacters;
    }
    /**
     * Checks if the text exactly matches a string in the arraylist
     * @param text the text to be checked
     * @return a boolean if the text is correct
     */
    private boolean textFinalCorrect(String text){
        boolean textCorrect = false; 
        for(int i = 1; i < text.length() + 1; i++){
            if(availableWords.size() != 0){
                for (int j = 0; j < availableWords.size(); j++){
                    if(availableWords.get(j).equals(text)){
                        textCorrect = true;
                    }
                }
            }
        }
        return textCorrect;
    }
}
