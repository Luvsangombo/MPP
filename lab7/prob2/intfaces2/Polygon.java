package lesson5.lecture.intfaces2;
interface Polygon extends ClosedCurve {


    default double computePerimeter() {
        double[] side = getLengths();
        double sum = 0;
        for (double v : side) {
            sum += v;
        }
        return sum;
    }


    public double[] getLengths();


}
