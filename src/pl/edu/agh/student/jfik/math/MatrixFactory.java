package pl.edu.agh.student.jfik.math;

public class MatrixFactory {

	public static Matrix2x2 createRotationMatrix(final double rotation) {
		double alpha = Math.toRadians(rotation);
		double c = Math.cos(alpha);
		double s = Math.sin(alpha);
		
		Matrix2x2 matrix = new Matrix2x2();
		
		matrix.data[0][0] = c;
		matrix.data[0][1] = -s;
		matrix.data[1][0] = s;
		matrix.data[1][1] = c;
		
		return matrix;
	}
	
}
