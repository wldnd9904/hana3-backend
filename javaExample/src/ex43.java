class Parent {
    String name = "Parent";

    Parent() {
    }

    Parent(String name) {
        this.name = name;
    }

    void parentMethod() {
        System.out.println("Parent: " + this.name);
    }
}

class Child extends Parent {
    String name = "Child";

    Child() {
    }

    Child(String name) {
        super(name + "'s parent");
        this.name = name;
    }

    void childMethod() {
        System.out.println("Child: " + this.name);
    }
}

public class ex43 {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.parentMethod();
        System.out.println(parent.name);

        Child child = new Child();
        child.childMethod();
        System.out.println(child.name);

        System.out.println();

        //업캐스팅
        Parent parent2 = new Child("gd");
        parent2.parentMethod();
        System.out.println(parent2.name);

        //다운캐스팅
        Child child2 = (Child) parent2;
        child2.childMethod();
        System.out.println(((Parent) child2).name);
        System.out.println(child2.name);


    }
}
