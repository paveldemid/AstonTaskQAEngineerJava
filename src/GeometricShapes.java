
public interface GeometricShapes {

    // Дефолтный метод для периметра, который будет переопределяться в классах
    default double perimeter() {
        return 0;
    }

    double square();

    default void displayInfo() {
        System.out.println("Тип: " + getType() +
                ", Цвет заливки: " + getBackgroundColor() +
                ", Цвет границы: " + getBorderColor() +
                ", Периметр: " + perimeter() +
                ", Площадь: " + square());
    }

    String getType();

    String getBackgroundColor();

    String getBorderColor();
}

class Circle implements GeometricShapes {
    private String type;
    private String backgroundColor;
    private String borderColor;
    private double radius;

    public Circle(String type, String backgroundColor, String borderColor, double radius) {
        this.type = type;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double square() {
        return Math.PI * (radius * radius);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Rectangle implements GeometricShapes {

    private String type;
    private String backgroundColor;
    private String borderColor;
    private double length_a;
    private double length_b;

    public Rectangle(String type, String backgroundColor, String borderColor, double length_a, double length_b) {
        this.type = type;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.length_a = length_a;
        this.length_b = length_b;
    }

    @Override
    public double perimeter() {
        return 2 * (length_a + length_b);
    }

    @Override
    public double square() {
        return length_a * length_b;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Triangle implements GeometricShapes {
    private String type;
    private String backgroundColor;
    private String borderColor;
    private double length_a;

    private double length_b;

    private double length_c;

    public Triangle(String type, String backgroundColor, String borderColor, double length_a, double length_b, double length_c) {
        this.type = type;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.length_a = length_a;
        this.length_b = length_b;
        this.length_c = length_c;
    }

    @Override
    public double perimeter() {
        return length_a + length_b + length_c;
    }

    @Override
    public double square() {
        double p = perimeter() / 2; // Полупериметр
        return Math.sqrt(p * (p - length_a) * (p - length_b) - (p - length_c));
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}