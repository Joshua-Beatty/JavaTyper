import greenfoot.*;
import java.util.ArrayList;
/**
 * Write a description of class KeyboardInput here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * Constructor for objects of class KeyboardInput
     */
    public KeyboardInput()
    {
    }
    public KeyboardInput(Game gController)
    {
        gameController = gController;
    }
    
    public void addedToWorld(World world){
        background = world.getBackground();
        world.addObject(TypedTextActor, 0, 700);
        
        //*
        availableWords.add("help");
        availableWords.add("hello");
        availableWords.add("how");
        availableWords.add("bello");
        //*/
    }
    
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
    
    public void entered(String input){
        if(textFinalCorrect(text)){
            gameController.textCorrect(text);
        } else {
            gameController.textIncorrect();
        }
    }
    
    public void addWord(String input){
        availableWords.add(input);
    }
    
    public void removeWord(String input){
        int indexOfWord = availableWords.indexOf(input);
        if(indexOfWord != -1){
            availableWords.remove(indexOfWord);
        }
    }
    
    private void displayWhiteRed(String textToDisplay, int  WhiteCharacters){
        int fontSize = 50;
        GreenfootImage whiteText = new GreenfootImage(textToDisplay.substring(0, WhiteCharacters), fontSize, Color.WHITE, Color.BLACK, Color.WHITE);
        GreenfootImage redText = new GreenfootImage(textToDisplay.substring(WhiteCharacters, textToDisplay.length()), fontSize, Color.RED, Color.BLACK, Color.WHITE);
        GreenfootImage finalImage = new GreenfootImage(redText.getWidth()+whiteText.getWidth(),whiteText.getHeight());
        finalImage.drawImage(whiteText, 0, 0);
        finalImage.drawImage(redText, whiteText.getWidth(), 0);
        
        TypedTextActor.setImage(finalImage);
    }
    private void displayCorrectText(String textToDisplay){
        int fontSize = 50;
        GreenfootImage finalImage = new GreenfootImage(textToDisplay, fontSize, Color.GREEN, Color.BLACK, Color.WHITE);
              
        TypedTextActor.setImage(finalImage);
    }
    
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