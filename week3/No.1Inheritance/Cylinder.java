public class Cylinder extends Circle {

    private double height;

    // Constructor default
    public Cylinder() {
        super();
        this.height = 1.0;
    }

    // Constructor tinggi saja
    public Cylinder(double height) {
        super();
        this.height = height;
    }

    // Constructor radius & height
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    // Constructor lengkap (opsional tapi bagus)
    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Override getArea() → luas permukaan tabung
    @Override
    public double getArea() {
        return 2 * Math.PI * getRadius() * height
                + 2 * super.getArea();
    }

    // Perbaikan getVolume()
    public double getVolume() {
        return super.getArea() * height;
    }

    @Override
    public String toString() {
        return "Cylinder: subclass of "
                + super.toString()
                + ", height=" + height;
    }
}