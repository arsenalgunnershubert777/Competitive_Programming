package Data_Structures_and_Algorithms;
//not my original code
public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addKey(String key) {
        TrieNode currNode = root;
        for(int currChar = 0; currChar < key.length(); ++currChar) {
            currNode = currNode.getNext(key.charAt(currChar));
        }

        currNode.setIsKey(true);
    }

    public String toString() {
        return root.toString();
    }
}

class TrieNode {
    TrieNode[] nextPtrs;
    boolean isKey;
    char alphabetStart = 'a';
    int alphabetLength = 26;

    public TrieNode() {
        nextPtrs = new TrieNode[alphabetLength];
        isKey = false;
    }

    public TrieNode getNext(char nextChar) {
        if(nextPtrs[nextChar-alphabetStart] == null) {
            nextPtrs[nextChar-alphabetStart ] = new TrieNode();
        }
        return nextPtrs[nextChar-alphabetStart ];
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