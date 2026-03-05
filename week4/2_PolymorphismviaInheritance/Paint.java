//******************************************************
// Paint.java
//
// Represents a type of paint that has a fixed area
// covered by a gallon.
//******************************************************

public class Paint {

    private double coverage;

    public Paint(double c){
        coverage = c;
    }

    public double amount(Shape s){
        System.out.println("Computing amount for " + s);
        return s.area() / coverage;
    }
}