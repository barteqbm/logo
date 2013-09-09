package pl.edu.agh.student.jfik.math;

public class Triangle {
	private Vector2[] vertexVectors = { new Vector2(0.0, 10.0), new Vector2(-5.0,-5.0), new Vector2(5.0, -5.0) };
	private Vector2[] vertexes = new Vector2[3];
	
	private Vector2 direction = new Vector2(0.0, 1.0);
	private Vector2 position;
	
	public Triangle(Vector2 position) {
		setPosition(position);
	}
	
	public void setPosition(final Vector2 vec) {
		position = vec;		
		for(int i = 0; i < vertexes.length; i++) {
			vertexes[i] = Vector2.translate(position, vertexVectors[i]);	
		}
	}
	
	public Vector2 position() {
		return position;
	}
	
	public Vector2 direction() {
		return direction;
	}
	
	public Vector2[] vertexes() {
		return vertexes;
	}
	
	public void translate(final Vector2 vec) {
		position.translate(vec);
		
		for(int i = 0; i < vertexes.length; i++) {
			vertexes[i] = Vector2.translate(vec, vertexes[i]);
		}
	}
	
	public static Triangle translate(final Triangle triangle, final Vector2 vec) {
		Triangle t = new Triangle(triangle.position);
		t.translate(vec);
		return t;
	}
	
	public void rotate(final Matrix2x2 rotataionMatrix){
		direction.rotate(rotataionMatrix);
		
		for(Vector2 v : vertexVectors) {
			v.rotate(rotataionMatrix);
		}
		
		setPosition(position);
	}
	
	public static Triangle rotate(final Triangle triangle, final Matrix2x2 rotataionMatrix) {
		Triangle t = new Triangle(triangle.position);
		t.rotate(rotataionMatrix);
		return t;
	}
	
}
