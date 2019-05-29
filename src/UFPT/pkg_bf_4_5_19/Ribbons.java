package UFPT.pkg_bf_4_5_19;
import java.util.*;
public class Ribbons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTurns = sc.nextInt();
        String one = sc.next();
        String two = sc.next();
        String three = sc.next();
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        int finalMax = 0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < one.length(); i++) {
            int max;
            char c = one.charAt(i);
            if (!map1.containsKey(c)) {
                map1.put(c, 1);
                max = 1;

            }
            else {
                int temp = map1.get(c);
                map1.put(c, temp+1);
                max = temp+1;
            }
            if (max > max1) {
                max1 = max;
            }

        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < two.length(); i++) {
            int max;
            char c = two.charAt(i);
            if (!map2.containsKey(c)) {
                map2.put(c, 1);
                max = 1;

            }
            else {
                int temp = map2.get(c);
                map2.put(c, temp+1);
                max = temp+1;
            }
            if (max > max2) {
                max2 = max;
            }

        }

        HashMap<Character, Integer> map3 = new HashMap<>();
        for (int i = 0; i < three.length(); i++) {
            int max;
            char c = three.charAt(i);
            if (!map3.containsKey(c)) {
                map3.put(c, 1);
                max = 1;

            }
            else {
                int temp = map3.get(c);
                map3.put(c, temp+1);
                max = temp+1;
            }
            if (max > max3) {
                max3 = max;
            }

        }


        int length = one.length();
        for (int i = 0; i < numTurns; i++) {
            if (max1 != length && (length - max1 >= numTurns -i))
                max1++;
            else if (max1 == length)
                max1--;
            if (max2 != length && length - max2 >= numTurns -i)
                max2++;
            else if (max2== length)
                max2--;
            if (max3 != length && length - max3 >= numTurns -i)
                max3++;
            else if (max3 == length)
                max3--;

        }
        LinkedList<Integer> list = new LinkedList<>();
        list.add(max1);
        list.add(max2);
        list.add(max3);
        Collections.sort(list);



        if (list.get(2) > list.get(1)) {
            if (max1 == list.get(2)) {
                System.out.println("Kuro");

            }
            else if (max2 == list.get(2)) {
                System.out.println("Shiro");
            }
            else if (max3 == list.get(2)) {
                System.out.println("Katie");
            }
        }

        else {

            System.out.println("Draw");
        }


    }
}
