import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    GreenfootImage image = getImage();
    
    int w, h;
    
    public Button() {
        //image.scale(image.getWidth() - 700, image.getHeight() - 700);
        //setImage(image);
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        /*w = image.getWidth();
        h = image.getHeight();
        if (w > 100 && h > 100) {
           //GreenfootImage image = getImage();
           //int percent = 99;
           image.scale(w * 99/100, h * 99/100);
           //Greenfoot.delay(1);
           //setImage(image);
        }
        if (image.getWidth() < 310 && image.getHeight() < 310) {
           int percent = 101;
           image.scale(image.getWidth()*percent/100, image.getHeight()*percent/100);
           Greenfoot.delay(1);
           setImage(image);
        }*/

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
