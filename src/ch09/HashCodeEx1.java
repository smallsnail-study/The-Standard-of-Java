package ch09;

class HashCodeEx1 {
    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = new String("abc");

        System.out.println(str1.equals(str2));
        // true
        // String 클래스는 내용을 비교하도록 overriding 되어 있다.

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        // 96354
        // String 클래스는 내용이 같으면, 동일한 해시코드를 반환하도록 hashCode()가 overriding 되어 있다.
        // -> 문자열 내용이 같은 String이 hashCode()룰 호출하면 항상 동일한 해시코드값을 얻는다.

        System.out.println(System.identityHashCode(str1));
        // 1435804085
        System.out.println(System.identityHashCode(str2));
        // 1784662007
        // System.identityHashCode(Object obj)는 객체의 주소값으로 해시코드를 생성한다.
        // -> 모든 객체에 대해 항상 다른 해시코드값을 반환할 것을 보장한다. 호출결과는 실행할 때마다 달라질 수 있다.
    }
}
