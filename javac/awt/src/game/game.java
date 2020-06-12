package game;

public class game {
    private static int win = 0;
    private static int lose = 0;
    private static int tie = 0;

    public static void play(int randNum, int select) {
        // 랜덤변수와 입력값을 비교해야함.
        // 0 : 가위 1 : 바위 2 : 보
        if(select == 0) {
            if(randNum == 0)        tie++;
            else if(randNum == 1)   lose++;
            else                    win++;
        } else if(select == 1) {
            if(randNum == 0)        win++;
            else if(randNum == 1)   tie++;
            else                    lose++;
        } else if(select == 2) {
            if(randNum == 0)        lose++;
            else if(randNum == 1)   win++;
            else                    tie++;
        }
    }

    public static int rand() {
        return (int) (Math.random() * 3);
    }

    public static int getWin() {
        return win;
    }

    public static int getLose() {
        return lose;
    }

    public static int getTie() {
        return tie;
    }

    public static String getScore() {
        return "Win : " + win + " Lose : " + lose + " Tie : " + tie;
    }

    public static String convertToString(int num) {
        switch (num) {
            case 0:
                return ("Scissor");
            case 1:
                return ("rock");
            case 2:
                return ("paper");
            default:
                return "";
        }
    }
}
