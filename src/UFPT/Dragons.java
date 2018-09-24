package UFPT;
import java.util.*;
public class Dragons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int health = sc.nextInt();
        int numDragons = sc.nextInt();

        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < numDragons; i++) {
            int[] arrays = new int[2];
            arrays[0] = sc.nextInt();
            arrays[1] = sc.nextInt();
            map.put(i, arrays);
        }
        boolean isRemoving = true;
        while (isRemoving && map.size() > 0) {
            isRemoving = false;
            for (int i = 0; i < numDragons; i++) {
                if (map.containsKey(i)) {
                    if (map.get(i)[0] < health) {
                        health += map.get(i)[1];
                        map.remove(i);
                        isRemoving = true;
                    }
                }

            }
        }
        System.out.println(map.size() == 0 ? "YES" : "NO");


    }
}
