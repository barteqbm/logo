package pl.edu.agh.student.jfik.math;

public class Vector2 {
	private double x;
	private double y;
	
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double length() {
		return Math.sqrt(x*x + y*y);
	}
	
	public void normalize() {
		double length = length();
		x /= length;
		y /= length;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void multiply(double a) {
		x *= a;
		y *= a;
	}
	
	public void translate(Vector2 vector) {
		x += vector.x;
		y += vector.y;
	}
	
	public void rotate(Matrix2x2 rotationMatrix) {
		Vector2 vec = rotationMatrix.multiply(this);
		this.x = vec.x;
		this.y = vec.y;
	}
	
	public static Vector2 multiply(Vector2 vec, double a) {
		Vector2 v = new Vector2(vec.x, vec.y);
		v.multiply(a);
		return v;
	}
	
	public static Vector2 translate(final Vector2 v1, final Vector2 v2) {
		return new Vector2(v1.x + v2.x, v1.y + v2.y);
	}
	
	public static Vector2 rotate(final Vector2 vec, final Matrix2x2 rotationMatrix) {
		return rotationMatrix.multiply(vec);
	}
}
