package UFPT.pkg_bf_4_5_19;

import java.util.*;

public class EightQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char [][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String s = sc.next();
            for (int j = 0; j < 8; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        boolean b = true;
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == '*') {
                    b=check(i,j, board);
                    //System.out.println("b: " + b);
                    count++;
                    if (!b) {
                        break;
                    }
                }
            }
            if (!b)
                break;
        }
        if (count != 8) {
            b= false;
        }
        //System.out.println(b);
        System.out.println(b ? "valid" : "invalid");
    }
    static boolean check(int i, int j, char[][] board) {
        //up and down
        for (int x = 0; x < 8; x++) {
            if (x != i) {
                if (board[x][j] == '*')
                    return false;
            }
        }
        for (int y = 0; y < 8; y++) {
            if (y != j) {
                if (board[i][y] == '*')
                    return false;
            }
        }
        //left and right
        int x = i;
        int y=j;

        while ( x < 8 && y < 8) {
            if (!(x == i && y ==j)) {
                if (board[x][y] == '*') {
                    return false;

                }
            }
            x++;
            y++;
        }
        //System.out.println( "i: " + i + " j: " + j);
        x = i;
        y = j;
        while ( x >= 0 && y < 8) {
            if (!(x == i && y ==j)) {
                if (board[x][y] == '*') {
                    return false;

                }
            }
            x--;
            y++;
        }
        x = i;
        y = j;
        while ( x >= 0 && y >= 0) {
            if (!(x == i && y ==j)) {
                if (board[x][y] == '*') {
                    return false;

                }
            }
            x--;
            y--;
        }

        x = i;
        y = j;
        while ( x <8 && y >= 0) {
            if (!(x == i && y ==j)) {
                if (board[x][y] == '*') {
                    return false;

                }
            }
            x++;
            y--;
        }
        return true;


        //diagonals1
        //diagonals2
    }
}