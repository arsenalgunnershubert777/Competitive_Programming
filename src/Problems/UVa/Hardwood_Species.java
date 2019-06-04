package Problems.UVa;
//https://odzkskevi.qnssl.com/c2a5d1f6632365c813fede3a4fb19c00?v=1537021976
import java.util.*;
public class Hardwood_Species {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        sc.nextLine();
        sc.nextLine();

        for (int i = 0; i < numCases;i++) {
            HashMap<String, Integer> hashmap = new HashMap<>();
            int numTrees = 0;

            while (sc.hasNextLine()) {
                String tree = sc.nextLine();
                if (tree.equals(""))
                    break;
                else if (!hashmap.containsKey(tree)) {
                    hashmap.put(tree, 1);
                }
                else {
                    int nextInput = hashmap.get(tree);
                    nextInput++;
                    hashmap.put(tree, nextInput);
                }
                numTrees++;
            }
            TreeMap<String,Integer> treemap = new TreeMap<>(hashmap);
            for (String s : treemap.keySet()) {
                float printout = (float) treemap.get(s);
                printout = 100*printout/numTrees;
                System.out.print(s);
                System.out.printf(" %.4f", printout);
                System.out.println();
            }
            if (i != numCases - 1)
                System.out.println();
    }

    }
}
