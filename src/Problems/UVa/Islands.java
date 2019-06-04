package Problems.UVa;
import java.util.*;
import java.io.*;
public class Islands {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s="";
        while ((s = input.readLine()) != null) {
            String[] strs = s.trim().split("\\s+");

            int height = Integer.parseInt(strs[0]);
            int width = Integer.parseInt(strs[1]);



            Character[][] map = new Character[width][height];
            int numLand = 0;
            ArrayList<int[]> landlist = new ArrayList<>();

            for (int i = 0; i < height; i++) {
                s = input.readLine();
                for (int j = 0; j < width; j++) {
                    char grid = s.charAt(j);
                    map[j][i] = grid;
                    if (grid == 'L') {
                        numLand++;
                        int [] pair = {j,i};
                        landlist.add(pair);
                    }

                }
            }

            if (numLand == 0) {
                System.out.println(0);
            }
            else if (numLand == 1) {
                System.out.println(1);
            }
            else {
                while (landlist.size() > 0) {
                    int[] island = landlist.remove(0);
                    int j = island[0];
                    int i = island[1];
                    if (i + 1 < height) {
                        if (map[j][i + 1] == 'C') {
                            map[j][i + 1] = 'L';
                            int[] array = {j, i + 1};
                            landlist.add(array);
                        }
                    }

                    //check south

                    if (j + 1 < width) {
                        if (map[j + 1][i] == 'C') {
                            map[j + 1][i] = 'L';
                            int[] array = {j + 1, i};
                            landlist.add(array);
                        }
                    }
                    //check east

                    if (i - 1 >= 0) {
                        if (map[j][i - 1] == 'C') {
                            map[j][i - 1] = 'L';
                            int[] array = {j, i - 1};
                            landlist.add(array);
                        }
                    }
                    //check north

                    if (j - 1 >= 0) {
                        if (map[j - 1][i] == 'C') {
                            map[j - 1][i] = 'L';
                            int[] array = {j - 1, i};
                            landlist.add(array);
                        }
                    }
                    //check west
                }

                int numIslands = 0;
                for (int a = 0; a < height; a++) {
                    for (int b = 0; b < width; b++) {
                        char grid = map[b][a];
                        if (grid == 'L') {
                            int[] array = {b, a};
                            landlist.add(array);
                            while (landlist.size() > 0) {
                                int[] island = landlist.remove(0);
                                int j = island[0];
                                int i = island[1];
                                if (i + 1 < height) {
                                    if (map[j][i + 1] == 'L') {
                                        map[j][i + 1] = 'D';
                                        int[] array2 = {j, i + 1};
                                        landlist.add(array2);
                                    }
                                }

                                //check south

                                if (j + 1 < width) {
                                    if (map[j + 1][i] == 'L') {
                                        map[j + 1][i] = 'D';
                                        int[] array2 = {j + 1, i};
                                        landlist.add(array2);
                                    }
                                }
                                //check east

                                if (i - 1 >= 0) {
                                    if (map[j][i - 1] == 'L') {
                                        map[j][i - 1] = 'D';
                                        int[] array2 = {j, i - 1};
                                        landlist.add(array2);
                                    }
                                }
                                //check north

                                if (j - 1 >= 0) {
                                    if (map[j - 1][i] == 'L') {
                                        map[j - 1][i] = 'D';
                                        int[] array2 = {j - 1, i};
                                        landlist.add(array2);
                                    }
                                }
                                //check west
                            }
                            numIslands++;

                        }

                    }
                }
                System.out.println(numIslands);
            }




        }
    }
}
