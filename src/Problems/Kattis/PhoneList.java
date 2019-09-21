package Problems.Kattis;


import java.util.Queue;
import java.util.ArrayDeque;
import Tools.Reader;
import java.util.*;
public class PhoneList {
    public static void main(String [] args) throws Exception {
        Reader in = new Reader(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {

            TrieNum trie = new TrieNum();
            int m = in.nextInt();
            boolean consistent = true;
            ArrayList<String> nums = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                nums.add(in.next());
                if (!trie.addKey(nums.get(j))) {
                    consistent = false;
                }

            }
            TrieNum trieBack = new TrieNum();
            for (int j = m-1; j >= 0; j--) {

                if (!trieBack.addKey(nums.get(j))) {
                    consistent = false;
                }

            }
            System.out.println(consistent ? "YES" : "NO");
        }
    }
}

class TrieNum {
    TrieNodeNum root;

    public TrieNum() {
        root = new TrieNodeNum();
    }

    public boolean addKey(String key) {

        TrieNodeNum currNode = root;

        for(int currChar = 0; currChar < key.length(); ++currChar) {
            currNode = currNode.getNext(key.charAt(currChar));
            if (currNode.isKey) {
                return false;
            }
        }
        currNode.setIsKey(true);
        return true;


    }

    public int numPrev(String key) {
        TrieNodeNum currNode = root;
        for(int currChar = 0; currChar < key.length(); ++currChar) {
            currNode = currNode.getNext(key.charAt(currChar));
        }

        Queue<TrieNodeNum> queue = new ArrayDeque<>();
        int numPrev = 0;
        queue.add(currNode);
        while (!queue.isEmpty()) {
            TrieNodeNum currentNode = queue.poll();
            if (currentNode.isKey) {
                numPrev += currentNode.getNumOccurrences();
            };
            for (int i = 0; i < 26; i++) {
                if (currentNode.checkNext(i) != null) {
                    queue.add(currentNode.checkNext(i));

                }
            }
        }
        return numPrev -1 ;


    }

    public String toString() {
        return root.toString();
    }
}

class TrieNodeNum {
    TrieNodeNum[] nextPtrs;
    boolean isKey;
    char numStart = '0';
    int numLength = 10;
    int numOccurrences;

    public TrieNodeNum() {
        nextPtrs = new TrieNodeNum[numLength];
        isKey = false;
        numOccurrences = 1;
    }

    public int getNumOccurrences() {
        return numOccurrences;
    }

    public void incrementOccurrences() {
        numOccurrences++;
    }

    public TrieNodeNum getNext(char nextChar) {
        if(nextPtrs[nextChar-numStart] == null) {
            nextPtrs[nextChar-numStart ] = new TrieNodeNum();
        }

        return nextPtrs[nextChar-numStart ];
    }

    public TrieNodeNum checkNext(int nextInt) {
        if(nextPtrs[nextInt] == null) {
            return null;
        }
        else {
            return nextPtrs[nextInt];
        }
    }

    public boolean getIsKey() {
        return isKey;
    }

    public void setIsKey(boolean newValue) {
        isKey = newValue;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String prefix) {
        String str = "";
        if(isKey) {
            str += "\"" + prefix + "\" ";
        }
        for(int i = 0; i < nextPtrs.length; ++i) {
            if(nextPtrs[i] != null) {
                str += nextPtrs[i].toString(prefix + (char)(numStart+i));
            }
        }
        return str;
    }
}