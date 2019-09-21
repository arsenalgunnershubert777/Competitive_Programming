package Data_Structures_and_Algorithms;
//not my original code

class TernarySearchTree {
    TSTNode root;

    public void addKey(String key) {
        if(root == null) {
            root = new TSTNode(key.charAt(0));
        }

        TSTNode currNode = root;
        int currChar = 0;
        while(currChar < key.length()) {
            if(currNode.getNodeValue() < key.charAt(currChar)) {
                if(currNode.loChild == null) {
                    currNode.loChild = new TSTNode(key.charAt(currChar));
                }
                currNode = currNode.loChild;
            } else if(currNode.getNodeValue() > key.charAt(currChar)) {
                if(currNode.hiChild == null) {
                    currNode.hiChild = new TSTNode(key.charAt(currChar));
                }
                currNode = currNode.hiChild;
            } else {
                ++currChar;
                if(currChar == key.length()) break;
                if(currNode.equalChild == null) {
                    currNode.equalChild = new TSTNode(key.charAt(currChar));
                }
                currNode = currNode.equalChild;
            }
        }

        currNode.setIsKey(true);
    }

    public String toString() {
        if(root == null) return "";
        return root.toString();
    }
}

class TSTNode {
    public TSTNode loChild;
    public TSTNode equalChild;
    public TSTNode hiChild;
    char nodeValue;
    boolean isKey;

    public TSTNode(char value) {
        this.nodeValue = value;
    }

    public boolean getIsKey() {
        return isKey;
    }

    public void setIsKey(boolean newValue) {
        isKey = newValue;
    }

    public char getNodeValue() {
        return nodeValue;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String prefix) {
        String str = "";
        if(isKey) {
            str += "\"" + (prefix+nodeValue) + "\" ";
        }

        if(loChild != null)
            str += loChild.toString(prefix);
        if(equalChild != null)
            str += equalChild.toString(prefix + nodeValue);
        if(hiChild != null)
            str += hiChild.toString(prefix);

        return str;
    }
}