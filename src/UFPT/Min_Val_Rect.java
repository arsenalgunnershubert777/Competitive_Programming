package UFPT;
import java.util.*;
import java.io.*;
public class Min_Val_Rect {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int numTests = Integer.parseInt(sc.readLine());

        for (int i = 0;i < numTests; i++) {
            int numSticks = Integer.parseInt(sc.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();
            String s = "";
            s = sc.readLine();
            String[] strs = s.trim().split("\\s+");
            boolean foundCase = false;

            PriorityQueue<Integer> availSticks = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0; j < numSticks;j ++) {

                int stick = Integer.parseInt(strs[j]);
                if (!map.containsKey(stick)) {
                    map.put(stick, 1);
                }
                else {
                    int num = map.get(stick) + 1;
                    map.put(stick,num);
                    if (num ==4) {
                        System.out.println(stick + " " + stick + " " + stick + " " + stick);
                        foundCase = true;
                        break;

                    }
                    else if (num == 2) {
                        availSticks.add(stick);
                    }

                }
            }



            if (!foundCase) {
                int num1 = availSticks.poll();
                int num2 = availSticks.peek();
                float minRatio  =  ((float) num1)/( (float) num2);
                int[] result = {num1, num2};
                int size = availSticks.size();
                for (int j = 1; j < size; j++) {
                    num1 = availSticks.poll();
                    num2 = availSticks.peek();
                    float ratio =  ((float) num1)/( (float) num2);

                    if (ratio < minRatio) {
                        minRatio = ratio;
                        result[0] = num1;
                        result[1] = num2;
                    }
                    else if (minRatio < ((float)num2)/(num2 -1))
                        break;


                }
                System.out.println(result[0] + " " + result[0] + " " + result[1] + " " + result[1]);
            }



        }
    }
}
