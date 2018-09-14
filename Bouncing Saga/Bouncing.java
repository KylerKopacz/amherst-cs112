
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

public class Bouncing extends JPanel{
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;
    public static final int FPS = 60;
    public static final int RADIUS = 50;
    double positionX;
    double positionY;
    double positionA;
    double positionB;
    double vortexX;
    double vortexY;

    //Note: The following are not used yet, you should use them in writing your code.
    double velocityX;
    double velocityY;
    double velocityA;
    double velocityB;
    double vortexVeloX;
    double vortexVeloY;

    double accelerationX;
    double accelerationY;

    double vortexAccX;
    double vortexAccY;

    class Runner implements Runnable{
        public Runner()
        {
            //Feel free to change these default values
            positionX = 275;
            positionY = HEIGHT - 275;
            velocityX = 100;
            velocityY = 100;
            accelerationY = 1000;

            //your code here for adding the second sphere
            positionA = 200;
            positionB = 200;
            velocityA = 100;
            velocityB = 100;

            //vortex stuff
            vortexX = WIDTH/2;
            vortexY = HEIGHT/2;
            vortexAccX = 1000;
            vortexAccY = 1000;
            vortexVeloX = 250;
            vortexVeloY = 250;

        }
        public void run()
        {
            while(true){
                //your code here
                //Implement Movement here
                if(positionY < vortexY) {
                    velocityY = velocityY + (vortexAccY*(1.0/FPS));
                } else {
                    velocityY = velocityY + (-vortexAccY*(1.0/FPS));
                }
                if(positionX < vortexX) {
                    velocityX = velocityX + (vortexAccX*(1.0/FPS));
                } else {
                    velocityX = velocityX + (-vortexAccX*(1.0/FPS));

                }
                positionX += velocityX / (double)FPS;
                positionY += velocityY / (double)FPS;

                //Movement for the second sphere
                if(positionB < vortexY) {
                    velocityB = velocityB + (vortexAccY*(1.0/FPS));
                } else {
                    velocityB = velocityB + (-vortexAccY*(1.0/FPS));
                }
                if(positionA < vortexX) {
                    velocityA = velocityA + (vortexAccX*(1.0/FPS));
                } else {
                    velocityA = velocityA + (-vortexAccX*(1.0/FPS));

                }
                positionA += velocityA / (double)FPS;
                positionB += velocityB / (double)FPS;

                //movement of the vortex
                vortexX += vortexVeloX / (double)FPS;
                vortexY += vortexVeloY / (double)FPS;

                //Implement bouncing here
                if(positionX >= (WIDTH-RADIUS)) {
                    velocityX = -velocityX;
                }
                if(positionX <= 0) {
                    velocityX = -velocityX;
                }
                if(positionY >= (HEIGHT-RADIUS)) {
                    positionY = HEIGHT - RADIUS;
                    velocityY = -velocityY;
                }
                if(positionY <= 0) {
                    velocityY = -velocityY;
                }

                //this is the bouncing for the second sphere
                if(positionA >= (WIDTH-RADIUS)) {
                    velocityA = -velocityA;
                }
                if(positionA <= 0) {
                    velocityA = -velocityA;
                }
                if(positionB >= (HEIGHT-RADIUS)) {
                    positionB = HEIGHT - RADIUS;
                    velocityB = -velocityB;
                }
                if(positionB <= 0) {
                    velocityB = -velocityB;
                }

                //this is the bouncing for the vortex
                if(vortexX >= (WIDTH-RADIUS)) {
                    vortexVeloX = -vortexVeloX;
                }
                if(vortexX <= 0) {
                    vortexVeloX = -vortexVeloX;
                }
                if(vortexY >= (HEIGHT-RADIUS)) {
                    vortexY = HEIGHT - RADIUS;
                    vortexVeloY = -vortexVeloY;
                }
                if(vortexY <= 0) {
                    vortexVeloY = -vortexVeloY;
                }

                //don't mess too much with the rest of this method
                repaint();
                try{
                    Thread.sleep(1000/FPS);
                }
                catch(InterruptedException e){}
            }
        }
    }

    public Bouncing(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        Thread mainThread = new Thread(new Runner());
        mainThread.start();
    }
    public static void main(String[] args){
        JFrame frame = new JFrame("Physics!!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Bouncing world = new Bouncing();
        frame.setContentPane(world);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        //The cannon you see is actually *not* a photograph of a real cannon.
        //this is where the cannon was, rest in peace

        //this is where the sphere is drawn. As a bonus make it draw something else
        // (e.g., your object from the previous lab).
        g.setColor(Color.RED);
        g.fillOval((int)positionX, (int)positionY, RADIUS, RADIUS);

        //your code here for drawing the second sphere
        g.setColor(Color.GREEN);
        g.fillOval((int)positionA, (int)positionB, RADIUS, RADIUS);

        //this draws the vortex
        g.setColor(Color.PINK);
        g.fillOval((int)vortexX,(int)vortexY, RADIUS, RADIUS);
    }
}