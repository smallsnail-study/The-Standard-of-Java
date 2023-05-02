package ch09;

class Person {
    long id;

    public boolean equals(Object obj) {
        if (obj instanceof Person)
            // obj가 Object타입이므로 id값을 참조하기 위해서는 Person타입으로 형변환 필요
            return id == ((Person)obj).id;
        else    // 타입이 Person이 아니면 값을 비교할 필요도 없다.
            return false;
    }

    Person(long id) {
        this.id = id;
    }
}

class EqualsEx2 {
    public static void main(String[] args) {
        Person p1 = new Person(8011081111222L);
        Person p2 = new Person(8011081111222L);

        if (p1==p2)
            System.out.println("p1과 p2는 같은 사람입니다.");
        else
            System.out.println("p1과 p2는 다른 사람입니다.");
        if (p1.equals(p2))  // id == ((Person)obj).id
            System.out.println("p1과 p2는 같은 사람입니다.");
        else
            System.out.println("p1과 p2는 다른 사람입니다.");
    }
}

//실행결과
//p1과 p2는 다른 사람입니다.
//p1과 p2는 같은 사람입니다.