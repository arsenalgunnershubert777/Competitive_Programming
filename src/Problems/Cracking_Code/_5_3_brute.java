package Problems.Cracking_Code;
import java.util.*;
import Tools.Reader;
public class _5_3_brute {

    public static void main(String[] args) throws Exception {
        Reader in = new Reader(System.in);
        int input = in.nextInt();
        System.out.println(longestSequence(input));

    }
    //O(n) time and O(n) space
    //Flip Bit to Win
    /*You have an integer and you can flip exactly one bit from a 0 to 1. Write code to find the length of the longest sequence of 1s you can create*/
    static int longestSequence(int n) {
        /*if (n == -1) {
            return Integer.BYTES*8;
        }*/
        ArrayList<Integer> sequences = getAlternatingSequences(n);
        return findLongestSequence(sequences);

    }

    static ArrayList<Integer> getAlternatingSequences(int n) {
        ArrayList<Integer> sequences = new ArrayList<Integer>();
        int finding = 0;
        int counter = 0;
        for (int i = 0; i < Integer.BYTES*8;i++) {
            if ((n&1) != finding) {
                finding = n&1;
                sequences.add(counter);
                counter = 0;
            }
            counter++;
            n=n>>>1;


        }
        sequences.add(counter);
        return sequences;

    }

    static int findLongestSequence(ArrayList<Integer> sequences) {
        int maxSequenceSize = 1;
        for (int i = 0; i < sequences.size(); i=i+2) {
            int zeroSize = sequences.get(i);
            int leftSide = i - 1 < 0 ? 0 : sequences.get(i-1);
            int rightSide = i + 1 >= sequences.size() ? 0 : sequences.get(i+1);

            int sequenceSize = 0;
            if (zeroSize == 0) {
                sequenceSize = Math.max(leftSide,rightSide);
            }
            else if (zeroSize == 1) {
                sequenceSize = 1 + leftSide + rightSide;
            }
            else if (zeroSize > 1) {
                sequenceSize = 1+ Math.max(leftSide, rightSide);
            }
            maxSequenceSize = Math.max(maxSequenceSize,sequenceSize);
        }
        return maxSequenceSize;

    }
}
