import greenfoot.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    private Pattern possibleKeys = Pattern.compile("^[a-zA-Z.,;()\"1-90!@#$%^&*']$");
    private GreenfootImage background;
    private TypedText TypedTextActor = new TypedText();
    private Pattern textChecker = Pattern.compile("^$");
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
            Matcher m = possibleKeys.matcher(rawInput);  
            if(m.matches()){
                    text = text + rawInput;
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
        availableWords.remove(availableWords.indexOf(input));
    }
    
    private void displayWhiteRed(String textToDisplay, int  WhiteCharacters){
        int fontSize = 50;
        GreenfootImage whiteText = new GreenfootImage(textToDisplay.substring(0, WhiteCharacters), fontSize, Color.WHITE, Color.WHITE, Color.BLACK);
        GreenfootImage redText = new GreenfootImage(textToDisplay.substring(WhiteCharacters, textToDisplay.length()), fontSize, Color.RED, Color.WHITE, Color.BLACK);
        GreenfootImage finalImage = new GreenfootImage(redText.getWidth()+whiteText.getWidth(),whiteText.getHeight());
        finalImage.drawImage(whiteText, 0, 0);
        finalImage.drawImage(redText, whiteText.getWidth(), 0);
        
        TypedTextActor.setImage(finalImage);
    }
    private void displayCorrectText(String textToDisplay){
        int fontSize = 50;
        GreenfootImage finalImage = new GreenfootImage(textToDisplay, fontSize, Color.GREEN, Color.WHITE, Color.BLACK);
              
        TypedTextActor.setImage(finalImage);
    }
    
    private int checktext(String text){
        int correctCharacters = 0;
        text = text.replace('(', '~');
        text = text.replace(')', '`');
        for(int i = 1; i < text.length() + 1; i++){
            textChecker = Pattern.compile("^"+text.substring(0,i)+"");
            if(availableWords.size() != 0){
                for (int j = 0; j < availableWords.size(); j++){
                    Matcher m = textChecker.matcher(availableWords.get(j)); 
                    if(m.find()){
                        correctCharacters = i;
                    }
                }
            }
        }
        return correctCharacters;
    }
    private boolean textFinalCorrect(String text){
        boolean textCorrect = false; 
        text = text.replace('(', '~');
        text = text.replace(')', '`');
        for(int i = 1; i < text.length() + 1; i++){
            textChecker = Pattern.compile("^"+text+"$");
            if(availableWords.size() != 0){
                for (int j = 0; j < availableWords.size(); j++){
                    Matcher m = textChecker.matcher(availableWords.get(j)); 
                    if(m.matches()){
                        textCorrect = true;
                    }
                }
            }
        }
        return textCorrect;
    }
}
