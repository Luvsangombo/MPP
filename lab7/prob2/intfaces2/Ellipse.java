package lesson5.lecture.intfaces2;

public class Ellipse implements ClosedCurve{
    public double semiAxis;
    public double elateral;
    public Ellipse(double semiAxis, double elateral) {
        this.semiAxis = semiAxis;
        this.elateral = elateral;
    }
    @Override
    public double computePerimeter() {
        return 4*semiAxis*elateral;
    }
}
