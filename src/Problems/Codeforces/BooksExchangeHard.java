package Problems.Codeforces;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.*;

public class BooksExchangeHard {
    public static void main(String[] args) throws Exception {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        Reader in = new Reader(System.in);
        int numQ = in.nextInt();
        for (int i = 0; i < numQ; i++) {
            int nums = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums; j++) {
                list.add(in.nextInt());
            }

            ArrayList<Integer> toPrint = returnDays(list);
            for (int j = 0; j < toPrint.size();j++) {
                System.out.print(toPrint.get(j) + " ");
            }
            System.out.println();

        }

    }
    static ArrayList<Integer> returnDays(ArrayList<Integer> permSeq) {
        ArrayList<Integer> returnList = new ArrayList<>();
        for (int i = 0; i < permSeq.size(); i++) {
            returnList.add(0);
        }
        for (int i = 0; i < permSeq.size(); i++) {

            if (returnList.get(i) == 0) {
                HashSet<Integer> set = new HashSet<>();
                int start = i+1;
                set.add(start);
                int next = permSeq.get(start-1);
                set.add(next);
                int count = 1;
                while (next != start) {

                    next = permSeq.get(next-1);
                    count++;
                    set.add(next);

                }
                for (int j : set) {
                    returnList.set(j-1, count);
                }

            }
        }
        return returnList;
    }
}
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