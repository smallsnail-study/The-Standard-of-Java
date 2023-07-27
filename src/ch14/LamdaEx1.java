package ch14;

@FunctionalInterface // 컴파일러가 함수형 인터페이스를 올바르게 정의하였는지 확인해준다.
interface MyFunction {
    void run(); // public abstract void run();
}

class LamdaEx1 {
    static void execute(MyFunction f) { // 매개변수의 타입이 MyFuction인 메서드
        f.run();
    }

    static MyFunction getMyFunction() { // 반환 타입이 MyFuction인 메서드
        MyFunction f = () -> System.out.println("f3.run()");
        return f;
    }

    public static void main(String[] args) {
        // 람다식으로 MyFuction의 run()을 구현
        MyFunction f1 = () -> System.out.println("f1.run");

        MyFunction f2 = new MyFunction(){ // 익명클래스로 run()을 구현
            public void run() { // public을 반드시 붙여야 함
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute(()-> System.out.println("run()"));
    }
}

// 실행결과
//f1.run
//f2.run()
//f3.run()
//f1.run
//run()