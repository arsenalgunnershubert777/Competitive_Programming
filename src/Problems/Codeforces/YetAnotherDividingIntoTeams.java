package Problems.Codeforces;
import java.util.*;
//http://codeforces.com/problemset/problem/1249/A
public class YetAnotherDividingIntoTeams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numQ = sc.nextInt();
        for (int i = 0; i < numQ; i++) {
            int nums = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums; j++) {
                list.add(sc.nextInt());
            }
            System.out.println(divideTeams(list));

        }
    }
    static int divideTeams(ArrayList<Integer> list) {
        if (list.size() == 1) {
            return 1;
        }

        Collections.sort(list);
        int diff = -1;
        for (int i = 1; i < list.size(); i++) {
            diff = list.get(i) - list.get(i-1);
            if (diff == 1) {
                return 2;
            }
        }
        return 1;
    }
}
