package threed;

public class Point3D {
    int x, y, z;

    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Point3D() {
        this(0, 0, 0);
    }

    @Override
    public boolean equals(Object obj) {
        boolean isobj = obj instanceof Point3D;
        boolean a = ((Point3D)obj).x == this.x;
        boolean b = ((Point3D)obj).y == this.y;
        boolean c = ((Point3D)obj).z == this.z;
        return a&&b&&c&&isobj;
    }

    @Override
    public String toString() {
        return "["+x+","+y+","+z+"]";
    }
}