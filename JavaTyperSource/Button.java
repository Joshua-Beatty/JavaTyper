import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Button class creates a button to press that starts the game
 * 
 * @author Derek Xu
 * @version 9/20/19
 */
public class Button extends Actor
{
    GreenfootImage image = getImage(); //pulls current button image
    
    int w, h;
    /**
     * Act - When button is clicked, switch to MyWorld which is the main game
     * Button also has animation, when hovered and pressed on, images change
     */
    public void act() 
    {

        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MyWorld());
        }
        if (Greenfoot.mouseMoved(this))
            setImage("start2.png");
            //image.scale(image.getWidth() - 200, image.getHeight() - 200);
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
            setImage("start.png");
        if (Greenfoot.mousePressed(this))
            setImage("start1.png");
    }    
}
