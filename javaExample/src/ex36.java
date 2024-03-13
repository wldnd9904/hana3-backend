//코드 중복 줄이기:
//0. 반복문이나 배열/리스트 사용
//1. 함수로 재사용
//2. 클래스(필드+함수)로 재사용
//3. 클래스 상속
//4. 추상화 클래스나 인터페이스

class Animal {
    int age = 1;

    void eat() {
        System.out.println("먹는다.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("짖는다.");
    }
}

class Cat extends Animal {
    void grooming() {
        System.out.println("손질한다.");
    }
}

public class ex36 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.age);
        dog.eat();
        dog.bark();
        Cat cat = new Cat();
        System.out.println(cat.age);
        cat.eat();
        cat.grooming();
    }
}
