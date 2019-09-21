package Problems.SPOJ;

//https://www.spoj.com/problems/EZDIJKST/
import java.io.*;
import Tools.Reader;
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

