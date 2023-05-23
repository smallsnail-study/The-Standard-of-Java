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
}

class CardToString {
    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card();

        // Object클래스로부터 상속받은 toString()을 오버라이딩하지 않고 호출
        //-> Object클래스의 toString()이 호출된다. -> 클래스이름@해시코드
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        // 실행결과
        // ch09.Card@6a5fc7f7
        // ch09.Card@3b6eb2ec
    }
}
