import java.util.*;

import javax.security.auth.Subject;

class SubjectEntity {

    private int numberstate;
    private List<ObserverEntity> ls = new ArrayList<ObserverEntity>();

    public void registerObserver(ObserverEntity e) {
        ls.add(e);
    }

    public void unRegisterObserver(ObserverEntity e) {
        ls.remove(e);
    }

    public void notifyAllObservers() {
        for (ObserverEntity o : ls) {
            o.update();
        }
    }

    public int getNumberstate() {
        return numberstate;
    }

    public void setNumberstate(int numberstate) {
        this.numberstate = numberstate;
        notifyAllObservers();
    }
}

abstract class ObserverEntity {

    SubjectEntity se;

    abstract public void update();
}

class BinaryObserverEntity extends ObserverEntity {

    public BinaryObserverEntity(SubjectEntity s) {
        se = s;
    }

    public void update() {
        System.out.println("Representing number: " + se.getNumberstate() + " to binary "
                + Integer.toBinaryString(se.getNumberstate()));
    }

}

public class obs {

    public static void main(String[] args) {
        SubjectEntity se = new SubjectEntity();
        ObserverEntity o1 = new BinaryObserverEntity(se);
        se.registerObserver(o1);
        se.setNumberstate(12);
    }
}

// add hexObserverEntity and octalObserverEntity on your own
// implementation of news agency - newsContent and date
// morningNewsBulletin(7-12 in morning) and eveningNewsBullentin(5-10 in
// evening) instead
// of binary and hex