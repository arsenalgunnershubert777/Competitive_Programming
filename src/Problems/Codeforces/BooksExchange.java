package Problems.Codeforces;

import java.util.*;

public class BooksExchange {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int numQ = sc.nextInt();
        for (int i = 0; i < numQ; i++) {
            int nums = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums; j++) {
                list.add(sc.nextInt());
            }
            results.add(returnDays(list));

        }
        for (int i = 0; i < results.size(); i++) {
            ArrayList<Integer> toPrint = results.get(i);
            for (int j = 0; j < toPrint.size();j++) {
                System.out.print(toPrint.get(j) + " ");
            }

            System.out.println();
        }
    }
    static ArrayList<Integer> returnDays(ArrayList<Integer> permSeq) {
        ArrayList<Integer> returnList = new ArrayList<>();
        for (int i = 0; i < permSeq.size(); i++) {
            returnList.add(0);
        }
        for (int i = 0; i < permSeq.size(); i++) {
            //System.out.println("iiii" + i);
            if (returnList.get(i) == 0) {
                HashSet<Integer> set = new HashSet<>();
                int start = i+1;
                set.add(start);
                int next = permSeq.get(start-1);
                set.add(next);
                int count = 1;
                while (next != start) {
                    //System.out.println("start" + start);
                    //System.out.println("next" + next);
                    next = permSeq.get(next-1);
                    count++;
                    set.add(next);

                }
                for (int j : set) {
                    returnList.set(j-1, count);
                }

            }
        }
        return returnList;
    }
}
