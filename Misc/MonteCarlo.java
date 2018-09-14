
import java.util.Random;
import java.util.ArrayList;

class Circle{
    double centerX;
    double centerY;
    double radius;
    public Circle(double x, double y, double r){
        this.centerX = x;
        this.centerY = y;
        this.radius = r;
    }
}
public class MonteCarlo{
    static Random rand = new Random();
    public static void main(String[] args){
        ArrayList<Circle> circs = new ArrayList<Circle>();
        circs.add(new Circle(1, 1, 1));
        circs.add(new Circle(5, 5, 1));
        circs.add(new Circle(7,7,1));
        System.out.println("Estimated area:");
        System.out.println(estimateArea(circs, 100000000));
    }
    private static double sample(double min, double max){
        return min + (max - min) * rand.nextDouble();
    }
    private static boolean isIn(double x, double y, Circle c){
        double dist = Math.sqrt(Math.pow(x - c.centerX, 2) + Math.pow(y - c.centerY, 2));
        return dist <= c.radius;
    }
    public static double estimateArea(ArrayList<Circle> circles, int numSamples){
        //YOUR CODE HERE
        //make a box around all circles
        double boxMinX = circles.get(0).centerX - circles.get(0).radius;
        double boxMaxX = circles.get(0).centerX + circles.get(0).radius;
        double boxMinY = circles.get(0).centerY - circles.get(0).radius;
        double boxMaxY = circles.get(0).centerY + circles.get(0).radius;
        for(int i = 0; i < circles.size(); i++) {
            if(circles.get(i).centerX - circles.get(i).radius < boxMinX) {
                boxMinX = circles.get(i).centerX - circles.get(i).radius;
            }
            if(circles.get(i).centerX + circles.get(i).radius > boxMaxX) {
                boxMaxX = circles.get(i).centerX + circles.get(i).radius;
            }
            if(circles.get(i).centerY - circles.get(i).radius < boxMinY) {
                boxMinY = circles.get(i).centerY - circles.get(i).radius;
            }
            if(circles.get(i).centerY + circles.get(i).radius > boxMaxY) {
                boxMaxY = circles.get(i).centerY + circles.get(i).radius;
            }
        }
        //now that we have the dimensions of the box, we can start throwing darts.
        double in = 0;
        for(int i = 0; i < numSamples; i++) {
            double dartX = sample(boxMinX, boxMaxX);
            double dartY = sample(boxMinY, boxMaxY);
            boolean captured = false;
            for (Circle c : circles) {
                if (isIn(dartX, dartY, c)) {
                    captured = true;
                }
            }
            if(captured) {
                in++;
            }
        }
        return (in/numSamples * ((boxMaxX - boxMinX) * (boxMaxY - boxMinY)));
    }
}