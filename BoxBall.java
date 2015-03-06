import java.awt.*;
import java.awt.geom.*;
/**
 * Write a description of class BoxBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxBall
{
    
    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    //Posiciones de limites
    private final int limitDown;
    private final int limitUp;
    private final int limitLeft;
    private final int limitRight;
    private Canvas canvas;
    private boolean xMovement;
    private boolean yMovement; // initial downward speed
    
    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int limitDown,int limitUp, int limitRight, int limitLeft, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        this.limitDown = limitDown;
        this.limitUp = limitUp;
        this.limitRight = limitRight;
        this.limitLeft = limitLeft;
        canvas = drawingCanvas;
        xMovement = true;
        yMovement = true;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        if(xMovement){
            xPosition += 1;
        }
        else{
            xPosition -= 1;
        }
        if(yMovement){
            yPosition += 1;
        }
        else{
            yPosition -= 1;
        }
        
       

        // check if it has hit the ground
        if(yPosition >= (limitDown - diameter)) {
            yPosition = (int)(limitDown - diameter);
            yMovement = !yMovement;
            
        }
        if(yPosition <= (limitUp)){
            yPosition = (int)(limitUp);
            yMovement = !yMovement;
        }
        if(xPosition >= (limitRight - diameter)) {
            xPosition = (int)(limitRight - diameter);
            xMovement = !xMovement;
            
        }
        if(xPosition <= (limitLeft)){
            xPosition = (int)(limitLeft);
            xMovement = !xMovement;
        }

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
    
}
