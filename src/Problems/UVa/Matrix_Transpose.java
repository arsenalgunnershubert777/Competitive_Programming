package Problems.UVa;
//https://odzkskevi.qnssl.com/88a91ccfcc319b6445cff84659610e4a?v=1537247204
import java.util.*;
public class Matrix_Transpose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {


            int m = sc.nextInt();
            int n = sc.nextInt();


            TreeMap<Integer, LinkedList<Integer>> mapValues = new TreeMap<Integer, LinkedList<Integer>>();
            TreeMap<Integer, LinkedList<Integer>> mapIndices = new TreeMap<Integer, LinkedList<Integer>>();


            for (int i = 1; i <= m; i++) {

                int numValues = sc.nextInt();
                if (numValues != 0) {
                    TreeSet<Integer> rowsAfterTranspose = new TreeSet<>();
                    for (int j = 0; j < numValues; j++) {
                        int columnIndices = sc.nextInt();

                        rowsAfterTranspose.add(columnIndices);
                        if (!mapIndices.containsKey(columnIndices)) {
                            LinkedList<Integer> list = new LinkedList<Integer>();
                            LinkedList<Integer> list2 = new LinkedList<Integer>();
                            mapValues.put(columnIndices, list);
                            mapIndices.put(columnIndices, list2);
                        }
                    }
                    for (int j : rowsAfterTranspose) {


                        int rowValues = sc.nextInt();

                        mapValues.get(j).add(rowValues);
                        mapIndices.get(j).add(i);

                    }

                }


            }
            System.out.println(n + " " + m);
            for (int i = 1; i <= n; i++) {
                if (mapIndices.containsKey(i)) {

                    System.out.print(mapIndices.get(i).size() + " ");
                    int counter = 1;
                    int mapSize = mapIndices.get(i).size();
                    for (int j : mapIndices.get(i)) {
                        if (counter == mapIndices.get(i).size()) {
                            System.out.print(j);
                        }
                        else {
                            System.out.print(j + " ");
                        }
                        counter++;


                    }
                    System.out.println();
                    counter = 1;
                    for (int j : mapValues.get(i)) {
                        if (counter == mapValues.get(i).size()) {
                            System.out.print(j);
                        }
                        else {
                        System.out.print(j + " ");
                        }
                        counter++;
                    }

                    System.out.println();


                } else {

                    System.out.println("0");

                    System.out.println();


                }
            }

        }







    }
}
