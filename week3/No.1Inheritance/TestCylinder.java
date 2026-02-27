public class TestCylinder { // save as "TestCylinder.java" 
public static void main(String[] args) {

// Declare and allocate a new instance of cylinder
// with default color, radius, and height 
Cylinder c1 = new Cylinder(); 
System.out.println("Cylinder : c1"
+ "\nradius = " + c1.getRadius()
+ "\nheight = " + c1.getHeight()
+ "\nbase area = " + c1.getArea()
+ "\nvolume = " + c1.getVolume()
+ "\ncolor = " + c1.getColor());

// Declare and allocate a new instance of cylinder
// specifying height, with default color and radius 
Cylinder c2 = new Cylinder(10.0); 
System.out.println("\nCylinder : c2"
+ "\nradius = " + c2.getRadius()
+ "\nheight = " + c2.getHeight()
+ "\nbase area = " + c2.getArea()
+ "\nvolume = " + c2.getVolume()
+ "\ncolor = " + c2.getColor());

// Declare and allocate a new instance of cylinder
// specifying radius and height, with default color 
Cylinder c3 = new Cylinder(2.0, 10.0); 
System.out.println("\nCylinder : c3 "
+ "\nradius = " + c3.getRadius()
+ "\nheight = " + c3.getHeight()
+ "\nbase area = " + c3.getArea()
+ "\nvolume = " + c3.getVolume()
+ "\ncolor = " + c3.getColor());
}
}
