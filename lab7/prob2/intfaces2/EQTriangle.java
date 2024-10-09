package lesson5.lecture.intfaces2;

public class EQTriangle implements Polygon{
    public double side;
    public EQTriangle(double side){
        this.side = side;
    }
    @Override
    public double[] getLengths() {
        double[] arr = new double[3];
        for(int i=0;i<3;i++) {
            arr[i] = side;
        }
        return arr;
    }
}
