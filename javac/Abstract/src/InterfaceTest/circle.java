package InterfaceTest;

public interface circle extends constantField {
    double area(int r);
    default double roundDefault(int r) {
        return 2 * PI * r;
    }
    static double roundStatic(int r) {
        return 2 * PI * r;
    }
}
interface constantField {
    // 다음과 같이 필드도 선언 가능하다. 다음과 같이 선언하면 자동적으로 public static final 키워드가 붙은 효과를 가진다.
    double PI = 3.141592;
}