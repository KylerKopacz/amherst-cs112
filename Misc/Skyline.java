
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.geom.Line2D;
import java.util.Random;
import java.awt.geom.Rectangle2D;

public class Skyline extends JPanel{
    public static final int WIDTH=1024;
    public static final int HEIGHT=768;
    public static void main(String[] args){
        JFrame frame = new JFrame("Skyline");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Skyline());
        frame.pack();
        frame.setVisible(true);
    }
    public Skyline(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public int nextHorizon(int starting) {
        Random r = new Random();
        int start = r.nextInt(2);
        if(start == 0) {
            return starting + r.nextInt(6);
        } else {
            return starting - r.nextInt(6);
        }
    }

    public int addOrSub() {
        Random r = new Random();
        return r.nextInt(2);
    }

    @Override
    public void paintComponent(Graphics gOri){
        Graphics2D g = (Graphics2D) gOri;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint sunSet= new GradientPaint(0, 0, Color.BLACK, 0, HEIGHT, new Color(55, 0, 0));
        g.setPaint(sunSet);
        g.fill(new Rectangle2D.Double(0, 0, WIDTH, HEIGHT));

        //randomizer
        Random rand = new Random();

        //stars and star cluster
        int center;
        if(addOrSub() == 0) {
            center = WIDTH/2 + rand.nextInt(100);
        } else {
            center = WIDTH/2 - rand.nextInt(100);
        }

        //stars and star cluster
        g.setPaint(Color.WHITE);
        for(int i = 0; i < 100; i++) {
            g.fill(new Rectangle2D.Double(rand.nextInt(WIDTH),rand.nextInt(HEIGHT),1,1));
            g.fill(new Rectangle2D.Double(Math.floor(center + (rand.nextGaussian() * 20)), Math.floor(HEIGHT/2 + (rand.nextGaussian() * 20)),1, 1));
        }

        //the horizon
        int height = nextHorizon(100);
        int maxHeight = 0;
        g.setPaint(Color.DARK_GRAY);
        for(int i = 0; i < WIDTH; i++) {
            g.fill(new Rectangle2D.Double(i, HEIGHT - height,1, HEIGHT));
            height = nextHorizon(height);
            if(height > maxHeight) {
                maxHeight = height;
            }
        }

    }
}