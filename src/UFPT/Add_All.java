package UFPT;
//https://odzkskevi.qnssl.com/cd5694d5c85f39f2036f7473917563e5?v=1537177338
import java.util.*;
public class Add_All {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int input = sc.nextInt();
            int totalCost = 0;
            if (input == 0)
                break;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < input; i++) {
                queue.add(sc.nextInt());
            }
            while (queue.size() > 1) {
                int cost = queue.poll() + queue.poll();
                queue.add(cost);
                totalCost += cost;
            }
            System.out.println(totalCost);

        }
    }
}
