package Problems.Kattis;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.*;
import Tools.Reader;

//https://open.kattis.com/problems/bing
public class BingItOn {
    public static void main(String[] args) throws Exception {
        Reader in = new Reader(System.in);
        TrieMod trie = new TrieMod();
        int n = in.nextInt();
        for (int i = 0;i < n; i++) {
            String word = in.next();
            trie.addKey(word);
            System.out.println(trie.numPrev(word));
        }
    }

}


class TrieMod {
    TrieNodeMod root;

    public TrieMod() {
        root = new TrieNodeMod();
    }

    public void addKey(String key) {
        TrieNodeMod currNode = root;
        for(int currChar = 0; currChar < key.length(); ++currChar) {
            currNode = currNode.getNext(key.charAt(currChar));
        }
        if (currNode.isKey) {
            currNode.incrementOccurrences();
        }
        else {
            currNode.setIsKey(true);
        }

    }

    public int numPrev(String key) {
        TrieNodeMod currNode = root;
        for(int currChar = 0; currChar < key.length(); ++currChar) {
            currNode = currNode.getNext(key.charAt(currChar));
        }

        Queue<TrieNodeMod> queue = new ArrayDeque<>();
        int numPrev = 0;
        queue.add(currNode);
        while (!queue.isEmpty()) {
            TrieNodeMod currentNode = queue.poll();
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

class TrieNodeMod {
    TrieNodeMod[] nextPtrs;
    boolean isKey;
    char alphabetStart = 'a';
    int alphabetLength = 26;
    int numOccurrences;

    public TrieNodeMod() {
        nextPtrs = new TrieNodeMod[alphabetLength];
        isKey = false;
        numOccurrences = 1;
    }

    public int getNumOccurrences() {
        return numOccurrences;
    }

    public void incrementOccurrences() {
        numOccurrences++;
    }

    public TrieNodeMod getNext(char nextChar) {
        if(nextPtrs[nextChar-alphabetStart] == null) {
            nextPtrs[nextChar-alphabetStart ] = new TrieNodeMod();
        }

        return nextPtrs[nextChar-alphabetStart ];
    }

    public TrieNodeMod checkNext(int nextInt) {
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
                str += nextPtrs[i].toString(prefix + (char)(alphabetStart+i));
            }
        }
        return str;
    }
}
