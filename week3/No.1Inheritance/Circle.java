public class Circle {

    private double radius;
    private String color;

    // Default constructor
    public Circle() {
        radius = 1.0;
        color = "red";
    }

    // Constructor radius saja
    public Circle(double radius) {
        this.radius = radius;
        this.color = "red";
    }

    // Constructor radius dan color
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    // Getter radius
    public double getRadius() {
        return radius;
    }

    // Setter radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Getter color
    public String getColor() {
        return color;
    }

    // Setter color
    public void setColor(String color) {
        this.color = color;
    }

    // Luas lingkaran
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color + "]";
    }
}