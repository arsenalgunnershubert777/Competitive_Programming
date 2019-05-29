package UFPT.pkg_bf_4_5_19;
//https://odzkskevi.qnssl.com/609a8b2bc816678626beda0c559bed61?v=1537089400
import java.util.*;
public class Lemmings_Battle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
        for (int i = 0; i < numTests; i++) {

            int numFields = sc.nextInt();
            int numGreen = sc.nextInt();
            int numBlue = sc.nextInt();
            PriorityQueue<Integer> greenArmy = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> blueArmy = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0; j <numGreen;j++) {
                greenArmy.add(sc.nextInt());
            }
            for (int j =0; j < numBlue;j++) {
                blueArmy.add(sc.nextInt());
            }

            int[] battleFieldResult = new int[numFields];
            while (true) {
                int numBattles= 0;
                for (int j = 0; j < numFields; j++) {
                    if (greenArmy.size() > 0 && blueArmy.size() > 0) {

                        battleFieldResult[j] = greenArmy.poll() - blueArmy.poll();
                        numBattles++;
                    } else
                        break;
                }
                for (int j = 0; j < numBattles; j++) {
                    if (battleFieldResult[j] > 0) {
                        greenArmy.add(battleFieldResult[j]);
                    } else if (battleFieldResult[j] < 0) {
                        blueArmy.add(battleFieldResult[j] * -1);
                    }
                }
                if (greenArmy.size() == 0 || blueArmy.size() == 0) {
                   if (greenArmy.size() == 0 && blueArmy.size() == 0) {
                       System.out.println("green and blue died");
                       if (i != numTests - 1)
                           System.out.println();
                       break;
                   }
                   else if (greenArmy.size() > 0) {
                       System.out.println("green wins");

                       while (greenArmy.size() > 0) {
                           System.out.println(greenArmy.poll());
                       }
                       if (i != numTests - 1)
                           System.out.println();
                       break;
                   }
                   else {
                       System.out.println("blue wins");

                       while (blueArmy.size() > 0) {
                           System.out.println(blueArmy.poll());
                       }
                       if (i != numTests - 1)
                           System.out.println();
                       break;

                   }
                }

            }

        }







    }
}
