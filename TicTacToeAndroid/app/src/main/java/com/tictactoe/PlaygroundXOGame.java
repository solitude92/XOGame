package com.tictactoe;

/**
 * Game board logic for Tic Tac Toe
 */
public class PlaygroundXOGame {
    public static String[] playGround = {"_ ", "_ ", "_ ", "_ ", "_ ", "_ ", "_ ", "_ ", "_ "};

    public static boolean isEmpty(int num) {
        return playGround[num].equals("_ ");
    }
    
    public static boolean insert(int num, Player player) {
        if (isEmpty(num)) {
            playGround[num] = player.type.type;
            return true;
        }
        return false;
    }

    public static boolean isFull() {
        for (int i = 0; i < playGround.length; i++) {
            if (isEmpty(i))
                return false;
        }
        return true;
    }

    public static void reset() {
        for (int i = 0; i < 9; i++) {
            playGround[i] = "_ ";
        }
    }

    public static boolean winner(Player player) {
        if (isWin(player, 0, 1, 2) || isWin(player, 0, 3, 6)
                || isWin(player, 1, 4, 7) || isWin(player, 2, 5, 8)
                || isWin(player, 0, 4, 8) || isWin(player, 2, 4, 6)
                || isWin(player, 3, 4, 5) || isWin(player, 6, 7, 8)) {
            return true;
        }
        return false;
    }

    public static boolean isWin(Player player, int a, int b, int c) {
        return playGround[a].equals(player.type.type)
                && playGround[b].equals(player.type.type)
                && playGround[c].equals(player.type.type);
    }
    
    public static String getCell(int index) {
        return playGround[index];
    }
}
