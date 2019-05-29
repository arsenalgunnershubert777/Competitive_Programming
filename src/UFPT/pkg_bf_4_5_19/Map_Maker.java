package UFPT.pkg_bf_4_5_19;
//https://odzkskevi.qnssl.com/7cdc67e1e228c49001e13cf6068d0cbd?v=1536807595
import java.util.*;
import java.io.*;
public class Map_Maker {
    public static void main(String[] args) throws java.io.IOException {
        HashMap<String, int[]> map = new HashMap<>();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();
        String[] strs2 = s.trim().split("\\s+");
        int numArrays = Integer.parseInt(strs2[0]);
        int numReferences = Integer.parseInt(strs2[1]);
        for (int i = 0; i < numArrays; i++) {
            String r = input.readLine();
            String[] strs = r.trim().split("\\s+");
            String name = strs[0];
            int baseAddress = Integer.parseInt(strs[1]);
            int byteSize = Integer.parseInt(strs[2]);
            int numDimensions = Integer.parseInt(strs[3]);
            int[][] dimensionArray = new int[numDimensions][2];
            for (int j = 0; j < numDimensions;j++) {
                dimensionArray[j][0] = Integer.parseInt(strs[2*j+4]);
                dimensionArray[j][1] = Integer.parseInt(strs[2*j+5]);
            }
            int[] constants = new int[numDimensions + 1];
            constants[numDimensions] = byteSize;
            for (int j = numDimensions - 1; j > 0; j--) {
                constants[j] = constants[j+1]*(dimensionArray[j][1]-dimensionArray[j][0]+1);
            }
            constants[0] = baseAddress;
            for (int j =1; j <= numDimensions; j++) {
                constants[0] = constants[0]- constants[j]*dimensionArray[j-1][0];
            }
            map.put(name, constants);


            /*int[] testinput = new int[2];
            testinput[0] = 2;
            testinput[1] = 4;

            int output = constants[0];
            for (int j = 1; j <= numDimensions; j++) {
                output += constants[j]*testinput[j-1];
            }
            System.out.println(output);*/

        }
        for (int i =0; i<numReferences; i++) {
            String r = input.readLine();
            String[] strs = r.trim().split("\\s+");
            String name = strs[0];
            System.out.print(name+ "[");
            int output = map.get(name)[0];
            for (int j = 1; j < strs.length;j++) {
                if (j != strs.length - 1)
                    System.out.print(strs[j] + ", ");
                else
                    System.out.print(strs[j] + "] = ");
                output+= map.get(name)[j] * (Integer.parseInt(strs[j]));
            }
            System.out.println(output);


        }
    }
}
