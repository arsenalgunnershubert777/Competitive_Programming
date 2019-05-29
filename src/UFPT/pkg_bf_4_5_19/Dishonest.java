package UFPT.pkg_bf_4_5_19;
        import java.util.*;
public class Dishonest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numItems = sc.nextInt();
        int k = sc.nextInt();
        int[][] array = new int[numItems][2];
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for (int i = 0; i < numItems; i++) {
            array[i][0] = sc.nextInt();
        }
        for (int i = 0; i < numItems; i++) {
            array[i][1] = sc.nextInt();
            int diff = array[i][0] - array[i][1];
            if (!map.containsKey(diff)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(diff, list);
            }
            else {
                map.get(diff).add(i);
            }

        }


        int count = 0;
        int sum = 0;
        boolean[] visited = new boolean[numItems];
        for (int i : map.keySet()) {
            if (i <= 0 || count < k) {
                for (int j = 0; j < map.get(i).size(); j++) {
                    if (i > 0 && count == k) {
                        break;
                    }
                    sum += array[map.get(i).get(j)][0];
                    visited[map.get(i).get(j)] = true;
                    count++;

                }
            }
        }
        for (int i = 0; i < numItems; i++) {
            if (!visited[i]) {
                sum += array[i][1];
            }
        }
        System.out.println(sum);
    }
}
