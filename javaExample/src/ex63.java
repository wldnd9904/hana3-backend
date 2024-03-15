import java.security.Key;

// 제네릭
// JDK 1.5부터
class Keyboard1 {
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}

class Keyboard2<MyType> {
    private MyType object;

    public MyType getObject() {
        return object;
    }

    public void setObject(MyType object) {
        this.object = object;
    }

}

public class ex63 {
    public static void main(String[] args) {
        Keyboard1 k1 = new Keyboard1();
        k1.setObject("키보드1");
        String str = (String) k1.getObject();
        Keyboard2<Keyboard1> k2 = new Keyboard2<>();
//        k2.setObject("키보드2"); // 에러
        k2.setObject(new Keyboard1());
    }
}
