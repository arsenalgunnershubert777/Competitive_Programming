package UFPT.pkg_5_29_19;

//https://www.spoj.com/problems/EZDIJKST/
import java.io.*;
public class EZDIJKST {


    public static int minVert(int[] dist, boolean[] set) {
        int min = Integer.MAX_VALUE;
        int minID = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!set[i] && dist[i] < min) {
                min = dist[i];
                minID = i;
            }
        }
        return minID;
    }

    public static int runDjikstra(int[][] graph, int source, int destination) {
        int[] dist = new int[graph.length];
        boolean[] set = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            set[i] = false;
        }

        dist[source] = 0;

        for (int i = 0; i < graph.length - 1; i++) {
            int minID = minVert(dist, set);
            if (minID == -1) {
                break;
            }
            set[minID] = true;
            if (minID == destination) {
                return dist[minID];
            }
            for (int j = 0; j < graph.length; j++) {
                if (!set[j] && graph[minID][j] != 0 && dist[minID] != Integer.MAX_VALUE && (dist[minID]  + graph[minID][j] < dist[j])) {
                    dist[j] = dist[minID] + graph[minID][j];
                }
            }



        }
        return dist[destination];


    }
    public static void main(String[] args) throws Exception {

        Reader in = new Reader(System.in);

        int numTests = in.nextInt();
        int[] toPrint = new int[numTests];

        for ( int i = 0; i < numTests; i++) {
            int numV = in.nextInt();
            int numE = in.nextInt();
            int[][] graph = new int[numV][numV];
            for (int j = 0; j < numE; j++) {
                int from = in.nextInt() -1;
                int to = in.nextInt()-1;
                int weight = in.nextInt();
                graph[from][to] = weight;
            }
            int source = in.nextInt()-1;
            int dest = in.nextInt()-1;

            toPrint[i] = runDjikstra(graph, source, dest);
        }
        for (int i = 0; i < numTests; i++) {
            if (toPrint[i] == Integer.MAX_VALUE) {
                System.out.println("NO");

            }
            else {
                System.out.println(toPrint[i]);
            }
        }
        //get input into
        //number of vertices
        //graph
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