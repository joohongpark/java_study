package main;

public class Rectangle extends Shape {
    int width;
    int height;
    Rectangle(Point p) {
        super(p);
        width = Math.abs(this.p.x);
        height = Math.abs(this.p.y);
    }
    @Override
    double calcArea() {
        return width * height;
    }
    boolean isSquare() {
        return width == height;
    }
}
