package UFPT.pkg_bf_4_5_19;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
import java.util.*;
public class Stock_Time {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stockArray = new int[n];
        for (int i = 0; i < n; i++) {
            stockArray[i] = sc.nextInt();
        }
        int count = 0;
        ArrayList<Integer> buySell = new ArrayList<>();
        boolean buying = true;
        boolean done = false;
        while (!done) {
            if (buying) {
                if (count + 1 < n) {
                    int curr = stockArray[count];
                    int next = stockArray[count + 1];
                    if (curr < next) {
                        buySell.add(stockArray[count]);
                        buying = false;
                    }
                    count++;
                }
                else {
                    done = true;
                }
            }
            else if (!buying) {
                if (count + 1 < n) {
                    int curr = stockArray[count];
                    int next = stockArray[count + 1];
                    if (curr > next) {
                        buySell.add(stockArray[count]);
                        buying = true;
                    }
                    count++;
                }
                else {
                    buySell.add(stockArray[count]);
                    done = true;
                }
            }

        }
        int maxProfit = 0;
        for (int i = 0; i < buySell.size()/2; i++) {
            maxProfit += buySell.get(2*i + 1) - buySell.get(2*i);
        }
        System.out.println(maxProfit);

    }
}
