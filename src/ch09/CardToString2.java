package ch09;

class Card {
    String kind;
    int number;

    Card() {
        this("SPADE", 1);
    }

    Card(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    public String toString() {
        /**
         * String 클래스의 toString()은 문자열을 반환하도록 오버라이딩 되어 있다.
         * Object 클래스에 정의된 toString()의 접근 제어자가 public이므로 오버라이딩 할 때의 접근제어자도 public으로 설정
         * Card 인스턴스의 kind와 number을 문자열로 반환한다.
         */
        return "kind : " + kind + ", number : " + number;
    }
}

class CardToString2 {
    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card("HEART", 10);
        System.out.println(c1.toString());
        System.out.println(c2.toString());

        // 실행결과
        // kind : SPADE, number : 1
        // kind : HEART, number : 10
    }
}
