package ch09;

class EqualsEx1 {
    public static void main(String[] args) {
        Value v1 = new Value(10);
        Value v2 = new Value(10);

        //equals는 주소값으로 비교하기 때문에 결과는 false
        if (v1.equals(v2))
            System.out.println("v1과 v2는 같습니다.");
        else
            System.out.println("v1과 v2는 다릅니다.");

        v2 = v1;    // v2에 v1이 참조하고 있는 인스턴스의 주소값이 저장

        // v2도 v1과 같은 주소값이므로 결과는 true
        if (v1.equals(v2))
            System.out.println("v1과 v2는 같습니다.");
        else
            System.out.println("v1과 v2는 다릅니다.");
    }
}
/*
equals 메서드는 두 참조변수에 저장된 값(주소값)이 같은지를 판단
-> 값을 비교하기 위해서는 오버라이딩해야 한다.
 */
class Value {
    int value;
    Value(int value) {
        this.value = value;
    }
}

//실행결과
//v1과 v2는 다릅니다.
//v1과 v2는 같습니다.