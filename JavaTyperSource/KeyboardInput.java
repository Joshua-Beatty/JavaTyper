import greenfoot.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Write a description of class KeyboardInput here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeyboardInput extends Actor
{
    // instance variables - replace the example below with your own
    private String rawInput = "";
    private String text = "";
    private String keyPressed = "";
    private Pattern possibleKeys = Pattern.compile("^[a-zA-Z.,;()\"]$");
    private GreenfootImage background;
    private TypedText TypedTextActor = new TypedText();
    /**
     * Constructor for objects of class KeyboardInput
     */
    public KeyboardInput()
    {
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
        System.out.println(text);
        if(text.length() > 4)  {
            displayWhiteRed(text, 4);
        } else {
            displayWhiteRed(text, text.length());
        }
    }
    public void entered(String input){
    
    }
    public void addedToWorld(World world){
        background = world.getBackground();
        world.addObject(TypedTextActor, 0, 700);
    }
    public void displayWhiteRed(String textToDisplay, int  WhiteCharacters){
        int fontSize = 50;
        GreenfootImage whiteText = new GreenfootImage(textToDisplay.substring(0, WhiteCharacters), fontSize, Color.WHITE, Color.WHITE, Color.BLACK);
        GreenfootImage redText = new GreenfootImage(textToDisplay.substring(WhiteCharacters, textToDisplay.length()), fontSize, Color.RED, Color.WHITE, Color.BLACK);
        GreenfootImage finalImage = new GreenfootImage(redText.getWidth()+whiteText.getWidth(),whiteText.getHeight());
        finalImage.drawImage(whiteText, 0, 0);
        finalImage.drawImage(redText, whiteText.getWidth(), 0);
        
        TypedTextActor.setImage(finalImage);
    }
}
