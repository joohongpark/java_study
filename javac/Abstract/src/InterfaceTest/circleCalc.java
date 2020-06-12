package InterfaceTest;

public class circleCalc implements circle {
    @Override
    public double area(int r) {
        return r*r*circle.PI;
    }
}
