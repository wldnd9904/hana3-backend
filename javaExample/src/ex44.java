class People {
    void think() {
        System.out.println("생각한다.");
    }
}

class Man extends People {
    @Override
    void think() {
        System.out.println("남자가 생각한다.");
    }

    void shave() {
        System.out.println("면도한다.");
    }
}

class Woman extends People {
    @Override
    void think() {
        System.out.println("여자가 생각한다.");
    }

    void makeup() {
        System.out.println("화장한다.");
    }
}

public class ex44 {
    public static void main(String[] args) {
        People people = new Woman();
        people.think();
        myFunc(people);
    }

    static void myFunc(People p) {
        if (p instanceof Man) {
            ((Man) p).shave();
        }
        if (p instanceof Woman) {
            ((Woman) p).makeup();
        }
    }

}
