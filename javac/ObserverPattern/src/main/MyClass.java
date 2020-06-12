package main;

import java.util.Observable;

public class MyClass extends Observable {
    private String puju;

    @Override
    public void notifyObservers(Object arg) {
        String str = (String) arg;
        if(str.equals(puju)) {
            return;
        }
        puju = str;
        setChanged();
        super.notifyObservers(arg);
        clearChanged();
    }
}
