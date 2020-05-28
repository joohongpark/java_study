package main;

import java.util.Scanner;

import students.student;

public class mainClass {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*
         * 학생 성적 관리
         * 메뉴
         * 학생 정보 추가
         * 학생 정보 삭제
         * 학생 정보 검색
         * 학생 정보 수정
         * 학생 정보 모두 출력
         * 과목의 총점
         * 과목의 평균
         * 성적순으로 정렬
         */
        Scanner scan = new Scanner(System.in);
        int studentNumber;
        int tmp;
        int[] idxArr;
        boolean mainLoop = true;
        System.out.println("[학생 성적 관리 프로그램]");
        System.out.print("입력할 학생 수를 먼저 입력하세요 >> ");
        studentNumber = scan.nextInt();
        student sObj = new student(studentNumber);
        while(mainLoop) {
            mainMenuPrint();
            studentNumber = getNumber(scan);
            switch(studentNumber) {
                case 1:
                    addStudent(sObj, scan);
                    break;
                case 2:
                    tmp = getRangeNumber(scan, sObj.getStudentNumber());
                    sObj.studentDelete(tmp);
                    break;
                case 3:
                    idxArr = searchMenu(scan, sObj);
                    sObj.studentSelectedPrintByArray(idxArr);
                    break;
                case 4:
                    tmp = getRangeNumber(scan, sObj.getStudentNumber());
                    modStudent(tmp, sObj, scan);
                    break;
                case 5:
                    sObj.studentPrint();
                    break;
                case 6:
                    break;
                case 7:
                    sObj.studentSelectedWholeAverage();
                    break;
                case 8:
                    sortMenu(scan, sObj);
                    break;
                default:
                    mainLoop = false;
                    break;
            }
        }
        scan.close();
    }
    static void addStudent(student sObj, Scanner scan) {
        String Name = "";
        int KoreanScore = 0;
        int MathScore = 0;
        int EnglishScore = 0;
        System.out.println("학생명을 입력하세요 >> ");
        Name = scan.next();
        System.out.println("국어 점수를 입력하세요 >> ");
        KoreanScore = getNumber(scan);
        System.out.println("수학 점수를 입력하세요 >> ");
        MathScore = getNumber(scan);
        System.out.println("영어 점수를 입력하세요 >> ");
        EnglishScore = getNumber(scan);
        sObj.studentAdd(Name,KoreanScore, MathScore, EnglishScore);
    }
    static void modStudent(int idx, student sObj, Scanner scan) {
        String Name = "";
        int KoreanScore = 0;
        int MathScore = 0;
        int EnglishScore = 0;
        System.out.println("학생명을 입력하세요 >> ");
        Name = scan.next();
        System.out.println("국어 점수를 입력하세요 >> ");
        KoreanScore = getNumber(scan);
        System.out.println("수학 점수를 입력하세요 >> ");
        MathScore = getNumber(scan);
        System.out.println("영어 점수를 입력하세요 >> ");
        EnglishScore = getNumber(scan);
        sObj.studentModifyByIndex(idx, Name,KoreanScore, MathScore, EnglishScore);
    }

    static void mainMenuPrint() {
        System.out.println("1. 학생 정보 추가");
        System.out.println("2. 학생 정보 삭제");
        System.out.println("3. 학생 정보 검색");
        System.out.println("4. 학생 정보 수정");
        System.out.println("5. 학생 정보 모두 출력");
        System.out.println("6. 과목의 총점");
        System.out.println("7. 과목의 평균");
        System.out.println("8. 정렬");
        System.out.println();
        System.out.print(">> ");
    }
    static int getNumber(Scanner scan) {
        boolean isNumber = false;
        String str = "";
        while(!isNumber) {
            str = scan.next();
            isNumber = isNumber(str);
            if(!isNumber) {
                System.out.println("[error] 올바른 숫자를 입력해 주세요!");
            }
        }
        return Integer.parseInt(str);
    }
    static boolean isNumber(String str) {
        boolean result = true;
        for (int i = 0; i < str.length(); i++) {
            if( ('0' > str.charAt(i)) || ('9') < str.charAt(i) ) {
                result = false;
                break;
            }
        }
        return result;
    }
    static int getRangeNumber(Scanner scan, int max) {
        int tmp = 0;
        boolean loop = true;
        while(loop) {
            System.out.print("순번을 입력하세요 >> ");
            tmp = getNumber(scan) - 1;
            System.out.println(tmp);
            if (tmp >= 0 && tmp <= max) {
                loop = false;
            } else {
                System.out.println("잘못된 순번을 입력하셨습니다.");
            }
        }
        return tmp;
    }
    static int[] searchMenu(Scanner scan, student sObj) {
        int selectSearch;
        int[] array;
        String nameField;
        int searchField;
        System.out.println("무슨 정보를 토대로 검색하시겠습니까?");
        System.out.println("1. 학생 이름");
        System.out.println("2. 국어 점수");
        System.out.println("3. 수학 점수");
        System.out.println("4. 영어 점수");
        System.out.print(">> ");
        selectSearch = getRangeNumber(scan, 4);
        switch (selectSearch) {
            case 0:
                System.out.print("이름을 입력하세요 >> ");
                nameField = scan.next();
                array = sObj.studentSearchByName(nameField);
                break;
            case 1:
                System.out.print("국어 점수를 입력하세요 >> ");
                searchField = getNumber(scan);
                array = sObj.studentSearchByField(searchField, 0);
                break;
            case 2:
                System.out.print("수학 점수를 입력하세요 >> ");
                searchField = getNumber(scan);
                array = sObj.studentSearchByField(searchField, 1);
                break;
            case 3:
                System.out.print("영어 점수를 입력하세요 >> ");
                searchField = getNumber(scan);
                array = sObj.studentSearchByField(searchField, 2);
                break;
            default:
                array = new int[0];
                break;
        }
        return array;
    }
    static void sortMenu(Scanner scan, student sObj) {
        int select;
        System.out.println("무슨 정보를 토대로 정렬하시겠습니까?");
        System.out.println("1. 국어 점수");
        System.out.println("2. 수학 점수");
        System.out.println("3. 영어 점수");
        System.out.print(">> ");
        select = getRangeNumber(scan, 3);
        sObj.SelectionSortByField(select, true);
    }
}
