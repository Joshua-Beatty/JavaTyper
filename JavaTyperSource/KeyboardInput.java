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
    public String rawInput = "";
    public String text = "";
    private String keyPressed = "";
    Pattern possibleKeys = Pattern.compile("^[a-zA-Z.,;()\"]$");
    GreenfootImage background;
    TypedText TypedTextActor= new TypedText();
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
            displayWhiteRed(text, text.length()-3);
        } else {
            displayWhiteRed(text, 0);
        }
    }
    public void entered(String input){
    
    }
    public void addedToWorld(World world){
        background = world.getBackground();
        world.addObject(TypedTextActor, 600, 700);
    }
    public void displayWhiteRed(String textToDisplay, int  WhiteCharacters){
        GreenfootImage whiteText = new GreenfootImage(textToDisplay.substring(0, WhiteCharacters), 100, Color.WHITE, Color.WHITE, Color.BLACK);
        GreenfootImage redText = new GreenfootImage(textToDisplay.substring(WhiteCharacters, textToDisplay.length()), 100, Color.RED, Color.WHITE, Color.BLACK);
        //GreenfootImage(
        TypedTextActor.setImage(whiteText);
    }
}
