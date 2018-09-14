
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class DrawToScreen extends JPanel{
    public static final int BOX_WIDTH = 1024;
    public static final int BOX_HEIGHT = 768;


    public DrawToScreen(){
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
    }

    //Your code here, if you want to define additional methods.
    public void printTarget(Graphics g, int x, int y) {
        //Your code here: feel free to remove what is below
        g.setColor(Color.RED);
        g.fillOval(x,y,125,125);

        g.setColor(Color.WHITE);
        g.fillOval(x +13,y + 13,100,100);

        g.setColor(Color.RED);
        g.fillOval(x +25,y +25,75,75);

        g.setColor(Color.WHITE);
        g.fillOval(x + 38,y + 38,50,50);

        g.setColor(Color.RED);
        g.fillOval(x +50 ,y + 50,25,25);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);

        for(int i = 1; i < 6; i++) {
            for(int j = 1; j < 6; j++) {
                printTarget(g,(i-1)*150, (j-1)*150);
            }
        }
    }

    public static void main(String args[]){
        JFrame frame = new JFrame("DrawToScreen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new DrawToScreen());
        frame.pack();
        frame.setVisible(true);
    }
}