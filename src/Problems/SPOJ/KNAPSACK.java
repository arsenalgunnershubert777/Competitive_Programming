package Problems.SPOJ;

import java.io.DataInputStream;
import java.io.InputStream;

class Reader{
    final private int BUFFER_SIZE = 1 << 16;

    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader(InputStream in){
        din = new DataInputStream(in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public int nextInt() throws Exception{
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = c == '-';
        if (neg) c = read();
        do
        {
            ret = ret * 10 + c - '0';
            c = read();
        } while (c > ' ');
        if (neg) return -ret;
        return ret;
    }

    public String readLine() throws Exception
    {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1)
        {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }


    //reads in the next string
    public String next() throws Exception
    {
        StringBuilder ret = new StringBuilder();
        byte c = read();
        while (c <= ' ') c = read();
        do
        {
            ret = ret.append((char)c);
            c = read();
        } while (c > ' ');
        return ret.toString();
    }

    private void fillBuffer() throws Exception{
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) buffer[0] = -1;
    }

    private byte read() throws Exception{
        if (bufferPointer == bytesRead) fillBuffer();
        return buffer[bufferPointer++];
    }
}

public class KNAPSACK {

    public static int max(int a, int b) {
        return a >= b ? a : b;
    }
    public static void main(String[] args) throws Exception {
        Reader in = new Reader(System.in);
        int maxWeight = in.nextInt();
        int numItems = in.nextInt();

        int[] weights = new int[numItems+1];
        int[] values= new int[numItems+1];
        int[][] dp = new int[numItems+1][maxWeight+1];
        for (int i = 1;i <= numItems; i++) {
            weights[i] = in.nextInt();
            values[i] = in.nextInt();
        }

        for (int i = 0; i <= numItems; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if (weights[i] <= j) {
                    dp[i][j] = max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }

        }
        System.out.println(dp[numItems][maxWeight]);
    }
}
