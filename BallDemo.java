import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numOfBalls)
    {
        int ground = 400;   // position of the ground line
        BouncingBall[] balls = new BouncingBall[numOfBalls];//Array de bolas
        Random rnd = new Random();
        for(int i = 0; i<balls.length; i++){
            //Inicializamos las bolas
            balls[i] = new BouncingBall(rnd.nextInt(250), rnd.nextInt(400), rnd.nextInt(60)+1, Color.BLUE, ground, myCanvas);
        }

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        //Show the balls
        for(int i = 0; i<balls.length; i++){
            balls[i].draw();
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);  // small delay
            for(int i = 0; i<balls.length; i++){
                balls[i].move();
            }
            
            // stop once ball has travelled a certain distance on x axis
            for(int i = 0; i<balls.length; i++){
                if(balls[i].getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
}
