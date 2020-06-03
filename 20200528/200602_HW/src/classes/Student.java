package classes;

public class Student {
    public String name;
    public int ban;
    public int no;
    public int kor;
    public int eng;
    public int math;
    public int getTotal(int... target) {
        int sum = 0;
        for(int i : target) {
            sum += i;
        }
        return sum;
    }
    public double getAverage() {
        double sum = getTotal(kor, eng, math);
        sum /= 3;
        return sum;
    }
}
