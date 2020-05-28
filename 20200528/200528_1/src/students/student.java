package students;

public class student {
    final private int studentNumberMax;
    private int studentNumber;
    private int [] studentScore[];
    private String[] studentName;
    student() {
        this.studentNumberMax = 0;
    }
    public student(int studentNumber) {
        this.studentNumberMax = studentNumber;
        this.studentNumber = 0;
        studentName = new String[studentNumber];
        studentScore = new int[studentNumber][3];
    }
    public void studentAdd(String name, int KoreanScore, int MathScore, int EnglishScore) {
        if(studentNumberMax > studentNumber) {
            studentName[studentNumber] = name;
            studentScore[studentNumber][0] = KoreanScore;
            studentScore[studentNumber][1] = MathScore;
            studentScore[studentNumber][2] = EnglishScore;
            studentNumber++;
        } else {
            System.out.println("[Error]메모리 할당량 초과!");
        }
    }
    public void studentDelete(int index) {
        for (int i = index + 1; i < studentNumber; i++) {
            studentName[i - 1] = studentName[i];
            studentScore[i - 1][0] = studentScore[i][0];
            studentScore[i - 1][1] = studentScore[i][1];
            studentScore[i - 1][2] = studentScore[i][2];
        }
        studentNumber--;
    }
    public void studentPrint() {
        System.out.println("======================");
        System.out.println("| 학생명\t국어\t수학\t영어\t |");
        System.out.println("======================");
        for (int i = 0; i < studentNumber; i++) {
            System.out.printf("| %s\t%d\t%d\t%d\t |\n", studentName[i], studentScore[i][0], studentScore[i][1], studentScore[i][2]);
        }
        System.out.println("======================");
    }
    public int[] studentSearchByName(String name) {
        int count = 0;
        int[] indexArray;
        for (int i = 0; i < studentNumber; i++) {
            if(name.equals(studentName[i])) {
                count++;
            }
        }
        indexArray = new int[count];
        for (int i = 0; i < studentNumber; i++) {
            if (name.equals(studentName[i])) {
                indexArray[count - 1] = i;
                count--;
            }
        }
        return indexArray;
    }
    public int[] studentSearchByField(int Score, int Field) {
        int count = 0;
        int[] indexArray;
        for (int i = 0; i < studentNumber; i++) {
            if(studentScore[i][Field] == Score) {
                count++;
            }
        }
        indexArray = new int[count];
        for (int i = 0; i < studentNumber; i++) {
            if (studentScore[i][Field] == Score) {
                indexArray[count - 1] = i;
                count--;
            }
        }
        return indexArray;
    }
    public void studentSelectedPrint(int idx) {
        System.out.println("======================");
        System.out.println("| 학생명\t국어\t수학\t영어\t |");
        System.out.println("======================");
        studentSelectedPrintByLine(idx);
        System.out.println("======================");
    }
    public void studentSelectedPrintByArray(int[] arr) {
        System.out.println("======================");
        System.out.println("| 학생명\t국어\t수학\t영어\t |");
        System.out.println("======================");
        for(int iter : arr) {
            studentSelectedPrintByLine(iter);
        }
        System.out.println("======================");
    }
    public void studentSelectedPrintByLine(int idx) {
        System.out.printf("| %s\t%d\t%d\t%d\t |\n", studentName[idx], studentScore[idx][0], studentScore[idx][1], studentScore[idx][2]);
    }
    public void studentModifyByIndex(int idx, String name, int KoreanScore, int MathScore, int EnglishScore) {
        studentName[idx] = name;
        studentScore[idx][0] = KoreanScore;
        studentScore[idx][1] = MathScore;
        studentScore[idx][2] = EnglishScore;
    }
    public void studentSelectedWholeAverage() {
        double averageKoreanScore = 0;
        double averageMathScore = 0;
        double averageEnglishScore = 0;
        for (int i = 0; i < studentNumber; i++) {
            averageKoreanScore += studentScore[i][0];
            averageMathScore += studentScore[i][1];
            averageEnglishScore += studentScore[i][2];
        }
        averageKoreanScore /= studentNumber;
        averageMathScore /= studentNumber;
        averageEnglishScore /= studentNumber;
        System.out.println("==============================");
        System.out.println("| 평균\t국어\t\t수학\t\t영어\t |");
        System.out.println("==============================");
        System.out.printf("| 전체\t%.01f\t%.01f\t%.01f |\n", averageKoreanScore, averageMathScore, averageEnglishScore);
        System.out.println("==============================");
    }
    public int[] SelectionSort(int[] arr, boolean isAscend) {
        int[] returnIndex = new int[arr.length];
        int tmp, tmp1, idx;
        for (int i = 0; i < arr.length; i++) {
            returnIndex[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            idx = i;
            for (int j = i; j < arr.length; j++) {
                if( isAscend ? (arr[j] <= arr[idx]) : (arr[j] >= arr[idx])) {
                    tmp = arr[j];
                    tmp1 = returnIndex[j];
                    arr[j] = arr[idx];
                    returnIndex[j] = returnIndex[idx];
                    arr[idx] = tmp;
                    returnIndex[idx] = tmp1;
                }
            }
        }
        return returnIndex;
    }
    public void SelectionSortByField(int field, boolean isAscend) {
        int[] arrTemp = new int[studentNumber];
        for (int i = 0; i < studentNumber; i++) {
            arrTemp[i] = studentScore[i][field];
        }
        int[] tmp =  SelectionSort(arrTemp, isAscend);
        System.out.println("======================");
        System.out.println("| 학생명\t국어\t수학\t영어\t |");
        System.out.println("======================");
        for (int i : tmp) {
            studentSelectedPrintByLine(i);
        }
        System.out.println("======================");
    }
    public int getStudentNumber() {
        return studentNumber;
    }
}
