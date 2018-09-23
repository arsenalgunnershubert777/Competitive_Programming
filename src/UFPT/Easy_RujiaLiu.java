package UFPT;
//https://odzkskevi.qnssl.com/99af2b82730eca86a4ae9275bbb111c5?v=1537041049
import java.util.*;
import java.io.*;

public class Easy_RujiaLiu {
    public static void main(String[] args) throws java.io.IOException{

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s=input.readLine()) != null) {

            String[] strs2 = s.trim().split("\\s+");
            int size = Integer.parseInt(strs2[0]);
            int numQ = Integer.parseInt(strs2[1]);


            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();


            String line = input.readLine();
            String[] strs = line.trim().split("\\s+");
            for (int i = 1; i <= size; i++) {
                int in = Integer.parseInt(strs[i-1]);

                if (!map.containsKey(in)) {

                    ArrayList<Integer> list = new ArrayList<>();
                    map.put(in, list);
                }
                map.get(in).add(i);

            }
            for (int i = 0; i < numQ; i++) {
                String line2 = input.readLine();
                String[] strs3 = line2.trim().split("\\s+");
                int instance = Integer.parseInt(strs3[0]);
                int numToFind = Integer.parseInt(strs3[1]);

                if (map.containsKey(numToFind) && map.get(numToFind).size() >= instance) {

                    System.out.println(map.get(numToFind).get(instance -1));


                }
                else {
                    System.out.println(0);
                }

            }
        }
    }

}
