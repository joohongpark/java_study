package main;

public class mainClass {

	public static void main(String[] args) {
		// 다음과 같은 로컬변수 (혹은 지역변수라고도 함)는 반드시 스택영역에 적재된다.
		// Block {} 으로 정의되는 공간 안에서 [자료형] [변수명] 으로 작성.
		// Block (local)을 벗어나면 그 밖에선 접근하지 못함.
		{
			int i;
			String str;
			Myclass obj; // 이런 거도 스택에 올라간다.
		}
		

	}

}
