package ch11;

import java.util.ArrayList;
import java.util.List;

class ArrayListEx2 {
    public static void main(String[] args) {
        final int LIMIT = 10;   // 자르고자 하는 글자의 개수를 지정한다.
        String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
        int length = source.length();   // 43

        List list = new ArrayList(length / LIMIT + 10); // 크기를 약간 여유 있게 잡는다. (14)

        for (int i = 0; i < length; i += LIMIT) {   // i < 43 일 때 반복(i=0,10,20,30,40)
            if (i + LIMIT < length) // 43보다 작으면,
                list.add(source.substring(i, i + LIMIT));   // (1,10),(10,20),(20,30),(30,40),(40,50)
            else  // i=40
                list.add(source.substring(i));    // fromindex만 지정하고 toindex를 지정하지 않으면 from부터 String의 끝까지
        }

        for (int i = 0; i < list.size(); i++) { // i < 5
            System.out.println(list.get(i));
        }

    }
}
/*
0123456789
abcdefghij
ABCDEFGHIJ
!@#$%^&*()
ZZZ
 */

/*
 * list.add(source.substring(0, 10));
 * System.out.println(list.get(0));
 * list.add(source.substring(10, 20));
 * System.out.println(list.get(1));
 * list.add(source.substring(20, 30));
 * System.out.println(list.get(2));
 * list.add(source.substring(30, 40));
 * System.out.println(list.get(3));
 * list.add(source.substring(40));
 * System.out.println(list.get(4));
 * System.out.println(list.size()); // 5
 */
/*
i=0, list.add(source.substring(0, 10)) -> 0123456789 -> list의 0번째 index에 저장
i=10, list.add(source.substring(10, 20)) -> abcdefghij -> list의 1번째 index에 저장
i=20, list.add(source.substring(20, 30)) -> ABCDEFGHIJ -> list의 2번째 index에 저장
i=30, list.add(source.substring(30, 40)) ->!@#$%^&*()  -> list의 3번째 index에 저장
i=40, list.add(source.substring(40)) -> ZZZ -> list의 4번째 index에 저장
*/