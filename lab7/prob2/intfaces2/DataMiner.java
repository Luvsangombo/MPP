package lesson5.lecture.intfaces2;

import java.util.ArrayList;
import java.util.List;

public class DataMiner {
	List<ClosedCurve> objects = new ArrayList<>();
	public static void main(String[] args) {
		DataMiner dm = new DataMiner();
		dm.objects.add(new Rectangle(5,7));
		dm.objects.add(new Rectangle(2,9));
		dm.objects.add(new Circle(6));
		dm.objects.add(new EQTriangle(3));
		dm.objects.add(new Ellipse(4,5));
		dm.objects.add(new Ellipse(3,2));
		System.out.println(dm.computeAveragePerimeter());
	}
	
	//OO (good) way of performing computation
	public double computeAveragePerimeter() {
		if(objects == null || objects.isEmpty()) return 0.0;
		double sum = 0.0;
        for (ClosedCurve object : objects) {
            sum += object.computePerimeter();
        }
		return sum/objects.size();
	}

}
