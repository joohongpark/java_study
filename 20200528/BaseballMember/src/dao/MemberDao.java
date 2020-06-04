package dao;

import dto.Batter;
import dto.Human;
import dto.Pitcher;

public class MemberDao {
    // 담아둘 배열 필요함.
    private Human[] MemberArray = new Human[0];
    private int size = 0;

    public int length() {
        return size;
    }

    public void insert(Human human) {
        Human[] MemberArray_Extend = new Human[size + 1];
        for (int i = 0; i < size; i++) {
            MemberArray_Extend[i] = MemberArray[i];
        }
        MemberArray_Extend[size] = human;
        MemberArray = MemberArray_Extend;
        size++;
    }

    public Boolean delete(int idx) {
        boolean returnValue = true;
        if(size > 0) {
            Human[] MemberArray_Reduction = new Human[size - 1];
            for (int i = 0; i < idx; i++) {
                MemberArray_Reduction[i] = MemberArray[i];
            }
            for (int i = idx + 1; i < size; i++) {
                MemberArray_Reduction[i - 1] = MemberArray[i];
            }
            MemberArray = MemberArray_Reduction;
            size--;
        } else {
            returnValue = false;
        }
        return returnValue;
    }

    public Human select(int idx) {
        return MemberArray[idx];
    }

    public void update(int idx, Human human) {
        MemberArray[idx] = human;
    }

    public void all() { // 모든 선수 명단 출력
        for(Human obj : MemberArray) {
            if(obj instanceof Pitcher) {
                System.out.println(((Pitcher)obj).toString());
            } else if(obj instanceof Batter) {
                System.out.println(((Batter)obj).toString());
            } else {
                System.out.println(obj.toString());
            }
        }
    }

    public int searchByNumber(int number) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if(MemberArray[i].getNumber() == number) {
                index = i;
                break;
            }
        }
        return index;
    }
}
