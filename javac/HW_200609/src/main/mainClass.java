package main;

import threed.Point3D;

public class mainClass {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(new Point(50,20));
        System.out.println(r.calcArea());
        System.out.println(r.isSquare());
        Point3D p1 = new Point3D(1,2,3);
        Point3D p2 = new Point3D(1,2,3);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println("p1==p2?"+(p1==p2));
        System.out.println("p1.equals(p2)?"+(p1.equals(p2)));
    }
}
