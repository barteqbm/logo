package pl.edu.agh.student.jfik.math;

public class Matrix2x2 {
	public Double data[][] = {{0.0, 0.0}, {0.0, 0.0}};

	Matrix2x2() {
		
	}
	
	public Vector2 multiply(final Vector2 vec) {
		double x = data[0][0] * vec.getX() + data[0][1] * vec.getY();
		double y = data[1][0] * vec.getX() + data[1][1] * vec.getY();
		
		return new Vector2(x, y);
	}
}
