package ch11;

import java.util.ArrayList;
import java.util.Collections;

class ArrayListEx1 {
    public static void main(String[] args) {
        // ArrayList는 순서 O, 중복 O
        ArrayList list1 = new ArrayList(10);
        list1.add(new Integer(5));
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));

        //subList(int fromindex, int toindex) fromindex~toindex 범위에 있는 객체를 반환(toindex는 불포함)
        ArrayList list2 = new ArrayList(list1.subList(1, 4));
        print(list1, list2);
        //list1:[5, 4, 2, 0, 1, 3]
        //list2:[4, 2, 0]

        Collections.sort(list1);    // 정렬
        Collections.sort(list2);
        print(list1, list2);
        //list1:[0, 1, 2, 3, 4, 5]
        //list2:[0, 2, 4]

        System.out.println("list1.containsAll(list2):" + list1.containsAll(list2));
        //list1.containsAll(list2):true     list2객체들이 list1에 포함 여부 boolean

        list2.add("B");
        list2.add("C");
        list2.add(3, "A");
        print(list1, list2);
        //list1:[0, 1, 2, 3, 4, 5]
        //list2:[0, 2, 4, A, B, C]

        list2.set(3, "AA"); // set은 변경
        print(list1, list2);
        //list1:[0, 1, 2, 3, 4, 5]
        //list2:[0, 2, 4, AA, B, C]

        // list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
        // boolean retialAll(Collection c) 지정된 Collection에서 포함된 객체만을 남기고 다른 객체들은 삭제한다. 변화가 있으면 true
        System.out.println("list1.retainALl(list2):" + list1.retainAll(list2));
        //list1.retainALl(list2):true

        print(list1, list2);
        //list1:[0, 2, 4]
        //list2:[0, 2, 4, AA, B, C]

        // list2에서 list1에 포함된 객체들을 삭제한다.
        /** 거꾸로 끝에서부터 반복시킨 이유
         * i를 0부터 증가시켜서 삭제할경우,
         * 한 요소가 삭제될 때마다 빈 공간을 채우기 위해 나머지 요소들이 자리이동을 한다.
         * 올바른 결과를 얻을 수 없다.
         * 거꾸로 i를 감소시켜가면서 삭제를 해야, 자리이동이 발생해도
         * 영향을 받지 않고 작업이 가능하다.
         */

        for (int i = list1.size()-1; i >= 0 ; i--) {
            if (list1.contains(list2.get(i)))   // list1에 list2가 포함되어 있으면 true
                list2.remove(i);
        }
        print(list1, list2);
        //list1:[0, 2, 4]
        //list2:[AA, B, C]
    }
    static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);
        System.out.println();
    }
}