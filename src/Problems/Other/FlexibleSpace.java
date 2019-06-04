package Problems.Other;
import java.util.*;
import java.io.*;
public class FlexibleSpace {
    public static void main(String[] args) throws IOException {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        String a=r.readLine();
        String []sinfo=a.split(" ");
        int len=Integer.parseInt(sinfo[0]);
        int numP=Integer.parseInt(sinfo[1]);
        int[] placeH=new int[numP+2];
        placeH[0]=0;
        placeH[placeH.length-1]=len;
        a=r.readLine();
        sinfo=a.split(" ");
        for(int z=1; z<=numP; z++){
            placeH[z]=Integer.parseInt(sinfo[z-1]);

        }
//y=left z=right
        TreeSet<Integer> hs=new TreeSet<Integer>();
        for(int y=0; y<numP+2; y++){
            for(int z=y+1; z<numP+2; z++){
                hs.add(placeH[z]-placeH[y]);
            }
        }
        String st="";
        for(int s: hs){
            st=st+s+" ";
        }
        st=st.substring(0,st.length()-1);
        System.out.println(st);
    }
}