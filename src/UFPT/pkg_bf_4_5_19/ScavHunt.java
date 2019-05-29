package UFPT.pkg_bf_4_5_19;
//spoj.com/problems/SCAVHUNT/
import java.util.*;
public class ScavHunt {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int numroutes = sc.nextInt();

        for (int i = 0; i < numroutes; i++) {
            HashMap<String, String> map = new HashMap<>();
            HashMap<String, String> backwardsMap = new HashMap<>();
            HashSet<String> set = new HashSet<>();
            int numSteps = sc.nextInt();
            String root = "";
            for (int j = 0; j < numSteps - 1;j++) {
                String input1 = sc.next();
                String input2 = sc.next();

                map.put(input1, input2);
                backwardsMap.put(input2, input1);
                set.add(input1);
                set.add(input2);
            }

            for (String s: set) {
                if (backwardsMap.get(s) == null) {
                    root = s;
                }
            }
            System.out.println("Scenario #" + (i + 1) +  ":");
            System.out.println(root);
            for (int j = 0; j < numSteps -1;j++) {
                String p = map.get(root);
                System.out.println(p);
                root = p;
            }
            System.out.println();



        }





    }
}
