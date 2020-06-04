package main;

import dao.*;
import dto.*;
import useful.*;

import java.util.Scanner;

public class mainClass {
    public static int mainMenuSelect;
    public static Scanner scan = new Scanner(System.in);
    public static MemberDao data = new MemberDao();

    public static void main(String[] args) {
        data.insert(new Batter("박주홍", 7, 27, 184, 30, 1, 0.23));
        data.insert(new Batter("배현식", 8, 27, 180, 20, 2, 0.13));
        data.insert(new Batter("박주홍", 9, 27, 184, 30, 1, 0.23));
        data.insert(new Batter("배현식", 10, 27, 180, 20, 2, 0.13));
        data.delete(1);
        data.update(2, new Batter("민성환", 11, 28, 179, 40, 2, 0.90));
        data.insert(new Pitcher("푸주홍", 13, 28, 187, 10, 3, 0.50));
        mainLoop();
        /*
        data.insert(new Batter("박주홍", 7, 27, 184, 30, 1, 0.23));
        data.insert(new Batter("배현식", 8, 27, 180, 20, 2, 0.13));
        data.insert(new Batter("박주홍", 9, 27, 184, 30, 1, 0.23));
        data.insert(new Batter("배현식", 10, 27, 180, 20, 2, 0.13));
        data.delete(1);
        data.update(2, new Batter("민성환", 11, 28, 179, 40, 2, 0.90));
        data.insert(new Pitcher("푸주홍", 13, 28, 187, 10, 3, 0.50));
        data.all();
         */

        scan.close();
    }
    public static void mainMenu() {
        System.out.println("=========선수 실적 관리 프로그램===========");
        selectMenu();
    }
    public static void selectMenu() {
        System.out.println("1. 선수 리스트 보기");
        System.out.println("2. 선수 정보 변경");
        System.out.println("3. 선수 정보 삭제");
        System.out.println("4. 선수 정보 추가");
        System.out.println("그 외 키 -> 프로그램 종료");
    }
    public static void viewPlayerList() {
        int subMenuSelect;
        System.out.println("선수 리스트 출력 기준을 정해주십시오.");
        System.out.println("1. 전체 선수");
        System.out.println("2. 타자만");
        System.out.println("3. 투수만");
        subMenuSelect = GetInteger.consoleGetNumber(scan);
        switch (subMenuSelect) {
            case 1:
                data.all();
                break;
            case 2:
                for (int i = 0; i < data.length(); i++) {
                    if(data.select(i) instanceof Batter) {
                        System.out.println(data.select(i).toString());
                    }
                }
                break;
            case 3:
                for (int i = 0; i < data.length(); i++) {
                    if(data.select(i) instanceof Pitcher) {
                        System.out.println(data.select(i).toString());
                    }
                }
                break;
        }
    }
    public static Human addPlayer() {
        Human human;
        int playerType;
        String name;
        int number;
        int age;
        double height;

        System.out.println("추가하고자 하는 선수가 투수이면 1, 타자이면 2를 기입해 주세요.");
        playerType = GetInteger.consoleGetNumber(scan, 1, 2);
        System.out.println("이름을 기입해 주세요.");
        name = scan.next();
        System.out.println("선수 번호를 기입해 주세요.");
        number = GetInteger.consoleGetNumber(scan);
        System.out.println("나이를 기입해 주세요.");
        age = GetInteger.consoleGetNumber(scan);
        System.out.println("키를 기입해 주세요.");
        height = scan.nextFloat(); // 소수받는거도 별도로 처리해야할듯
        if(playerType == 1) { // Pitcher
            int win;
            int lose;
            double defence;
            System.out.println("이긴 횟수를 기입해 주세요.");
            win = GetInteger.consoleGetNumber(scan);
            System.out.println("진 횟수를 기입해 주세요.");
            lose = GetInteger.consoleGetNumber(scan);
            System.out.println("방어율을 기입해 주세요.");
            defence = scan.nextFloat(); // 소수받는거도 별도로 처리해야할듯
            human = new Pitcher(name, number, age, height, win, lose, defence);
        } else { // Batter
            int batCount;
            int hit; // 안타
            double hitAverage; // 타율
            System.out.println("타수 수를 기입해 주세요.");
            batCount = GetInteger.consoleGetNumber(scan);
            System.out.println("안타 횟수를 기입해 주세요.");
            hit = GetInteger.consoleGetNumber(scan);
            System.out.println("타율을 기입해 주세요.");
            hitAverage = scan.nextFloat(); // 소수받는거도 별도로 처리해야할듯
            human = new Pitcher(name, number, age, height, batCount, hit, hitAverage);
        }
        return human;
    }
    public static void deletePlayer() {
        int number;
        System.out.println("선수 번호를 기입해 주세요.");
        number = GetInteger.consoleGetNumber(scan);
        number = data.searchByNumber(number);
        if(number != -1) {
            System.out.println("다음 선수가 삭제되었습니다.");
            System.out.println(data.select(number).toString());
            data.delete(number);
        } else {
            System.out.println("해당 선수 번호가 존재하지 않습니다.");
        }
    }
    public static void modifyPlayer() {
        int number;
        Human human;
        System.out.println("선수 번호를 기입해 주세요.");
        number = GetInteger.consoleGetNumber(scan);
        number = data.searchByNumber(number);
        if(number != -1) {
            human = addPlayer();
            data.update(number, human);
        } else {
            System.out.println("해당 선수 번호가 존재하지 않습니다.");
        }
    }
    public static void mainLoop() {
        boolean loop = true;
        while(loop) {
            mainMenu();
            mainMenuSelect = GetInteger.consoleGetNumber(scan);
            switch (mainMenuSelect) {
                case 1:
                    viewPlayerList();
                    break;
                case 2:
                    modifyPlayer();
                    break;
                case 3:
                    deletePlayer();
                    break;
                case 4:
                    data.insert(addPlayer());
                    break;
                default:
                    System.out.println("프로그램 종료");
                    loop = false;
                    break;
            }
        }
    }
}
