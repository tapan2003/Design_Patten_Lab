interface State {
    public void handleState();
}

class State1 implements State {
    public void handleState() {
        System.out.println("Handling State1 - You may go to State2");
    }
}

class State2 implements State {
    public void handleState() {
        System.out.println("Handling State2 - You may go to State3");
    }
}

class State3 implements State {
    public void handleState() {
        System.out.println("Handling State3 - You may go to State1");
    }
}

class Context {
    State st;

    public Context(State s) {
        st = s;
    }

    public void setState(State s) {
        st = s;
    }

    public State getState() {
        return st;
    }

    public void performAction() {
        st.handleState();
    }
}

public class state_pattern {
    public static void main(String[] args) {

        State s1 = new State1();
        State s2 = new State2();
        State s3 = new State3();

        Context c1 = new Context(s2);
        c1.performAction();

        c1.setState(s3);
        c1.performAction();

    }
}