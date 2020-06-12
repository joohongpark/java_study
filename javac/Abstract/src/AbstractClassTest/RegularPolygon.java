package AbstractClassTest;

public abstract class RegularPolygon { // 정다각형
    protected double angle; // 내각
    protected double sideLength; // 변
    public abstract double area(); // 넓이 - 다각형의 쉐입에 따라 달라짐.

    public RegularPolygon(int angle, int sideLength) {
        this.angle = angle;
        this.sideLength = sideLength;
    }
}
