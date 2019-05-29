package UFPT.pkg_bf_4_5_19;

import java.util.*;
public class Paint {
    public static void main(String[] args) {
        //try to fill with lowest cost all first, then slowly change digits if possible
        Scanner sc = new Scanner(System.in);
        int numLiters = sc.nextInt();

        TreeMap<Integer,Integer> map = new TreeMap<>();

        for (int i = 0; i < 9 ;i++) {

            int cost =sc.nextInt();

            map.put(cost, i+1);


        }





        Integer[] array = new Integer[map.keySet().size()];
        array = map.keySet().toArray(array);

        int numBaseFills = numLiters/array[0];
        numLiters -= (numBaseFills*array[0]);

        if (numBaseFills > 0) {

            int[] finalProduct = new int[numBaseFills];
            Arrays.fill(finalProduct, map.get(array[0]));
            int tracker = 0;
            while (true) {
                int maxIndex = 0;
                if (numLiters > 0 && array.length > 1 && tracker < finalProduct.length) {

                    for (int i = 1; i < array.length; i++) {
                        if (array[i] - array[0] <= numLiters) {

                            if (map.get(array[i]) > map.get(array[maxIndex]))
                                maxIndex = i;
                        }
                        else {
                            break;
                        }
                    }
                    if (maxIndex == 0)
                        break;
                    else {
                        numBaseFills = numLiters/(array[maxIndex] - array[0]);
                        numLiters -= (array[maxIndex] - array[0])*numBaseFills;
                        int numToFill = map.get(array[maxIndex]);
                        for (int i = tracker; i < tracker + numBaseFills; i++) {
                            finalProduct[i] = numToFill;
                        }
                        tracker+=numBaseFills;
                    }
                }
                else {
                    break;
                }
            }
            for (int i = 0; i < finalProduct.length; i++) {
                System.out.print(finalProduct[i]);
            }


        }
        else
            System.out.print("-1");

        System.out.println();
    }
}
