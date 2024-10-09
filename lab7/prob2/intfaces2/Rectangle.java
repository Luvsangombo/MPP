package lesson5.lecture.intfaces2;

public class Rectangle implements Polygon {
	private double length, width;
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}


	@Override
	public double[] getLengths() {
		double[] sides = new double[4];
		sides[0] = length;
		sides[1] = width;
		sides[2] = length;
		sides[3] = width;
		return sides;
	}


	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
}
