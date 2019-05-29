package UFPT.pkg_bf_4_5_19;
import java.util.*;
public class Left_Right {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String directions = sc.next();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> toPrint = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(i+1);
        }
        int lastBound = num -1;
        int rightBound = num -2;
        int count = num - 2;
        while (count >= 0) {

            char c = directions.charAt(count);
            if (c == 'R') {

                toPrint.add(list.get(lastBound));

                lastBound = rightBound;
                rightBound--;
                count--;
            }
            else {

                int numL = 0;
                int tempCount = count;
                while (tempCount >= 0 && directions.charAt(tempCount) != 'R') {
                    numL++;
                    tempCount--;
                    rightBound--;
                }
                count = tempCount;



                for (int i = numL; i > 0; i--) {

                    toPrint.add(list.get(lastBound - i));

                }



            }
        }
        toPrint.add(list.get(lastBound));

        for (int i = toPrint.size() - 1; i >=0; i--) {
            System.out.println(toPrint.get(i));
        }
    }
}
