package ch14;

@FunctionalInterface
interface MyFunction {
    void myMethod();    // public abstract void myMethod();
}

class LamdaEx2 {
    public static void main(String[] args) {
        MyFunction f = ()->{}; // MyFuction f = (MyFuction)(()->{});
        Object obj = (MyFunction)(()->{}); // Object타입으로 형변환이 생략됨
        String str = ((Object) (MyFunction) (() -> {})).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);

//        System.out.println(()->{}); // 에러. 람다식은 Object 타입으로 형변환 안됨.
        System.out.println((MyFunction)(()->{}));
//        System.out.println((MyFunction)(()->{}).toString());
        System.out.println(((Object)(MyFunction)(()->{})).toString());
    }
}

// 실행결과
//ch14.LamdaEx2$$Lambda$14/0x0000000800066840@7a79be86
//ch14.LamdaEx2$$Lambda$15/0x0000000800066c40@34ce8af7
//ch14.LamdaEx2$$Lambda$16/0x0000000800066040@6e8dacdf
//ch14.LamdaEx2$$Lambda$17/0x0000000800066440@880ec60
//ch14.LamdaEx2$$Lambda$18/0x0000000800065840@7f63425a

/* 컴파일러가 람다식의 타입을 만들어내는 형식
    '외부클래스이름$$Lamda$번호'
    일반적인 익명 객체라면, 객체의 타입은
    '외부클래스이름$번호' 와 같은 형식이다.
 */