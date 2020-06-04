package dto;

public class Batter extends Human {
    private int batCount;
    private int hit; // 안타
    private double hitAverage; // 타율

    public Batter(String name, int number, int age, double height, int batCount, int hit, double hitAverage) {
        super(name, number, age, height);
        this.batCount = batCount;
        this.hit = hit;
        this.hitAverage = hitAverage;
    }

    public int getBatCount() {
        return batCount;
    }

    public int getHit() {
        return hit;
    }

    public double getHitAverage() {
        return hitAverage;
    }

    public void setBatCount(int batCount) {
        this.batCount = batCount;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public void setHitAverage(double hitAverage) {
        this.hitAverage = hitAverage;
    }

    @Override
    public String toString() {
        return super.toString() + ", batCount : " + batCount + ", hit : " + hit + ", hitAverage : " + hitAverage;
    }
}
