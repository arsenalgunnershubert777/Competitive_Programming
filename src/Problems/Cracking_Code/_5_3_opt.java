package Problems.Cracking_Code;
import Tools.Reader;
public class _5_3_opt {
    //O(n) time and O(1) space, n is length of the integer sequence
    //Flip Bit to Win
    /*You have an integer and you can flip exactly one bit from a 0 to 1. Write code to find the length of the longest sequence of 1s you can create*/
    public static void main(String[] args) throws Exception{
        Reader in = new Reader(System.in);
        int input = in.nextInt();
        System.out.println(flipBit(input));
    }

    static int flipBit(int n) {
        if (n == -1) {
            return Integer.BYTES*8;
        }
        int curr = 0;
        int prev = 0;
        int maxLength = 1;
        while (n != 0) {
            if ((n&1)==1) {
                curr++;
            }
            else if ((n&1)==0) {
                prev = (n&2)==0 ? 0 : curr;
                curr = 0;
            }
            maxLength = Math.max(prev+curr+1,maxLength);
            n=n>>>1;
        }
        return maxLength;
    }
}
