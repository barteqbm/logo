/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

/**
 *
 * @author Bartek
 */
public class UnitVector2 {
    
    public UnitVector2( ) {
        x = 0.0f;
        y = 1.0f;
    }
    
    public void rotate(double degrees) {
        alpha = (alpha + Math.toRadians(degrees));// % (2.0 * Math.PI);
                        
        x = Math.cos(alpha);
        y = Math.sin(alpha);
    }    
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    private double x;
    private double y;
    private double alpha = Math.toRadians(90.0);
}
