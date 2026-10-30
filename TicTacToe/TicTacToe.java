package com.TicTacToe;


import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== TIC TAC TOE GAME =====");

        initializeBoard();

        while (true) {

            displayBoard();

            System.out.println("Player " + currentPlayer + " turn");

            System.out.print("Enter row (0-2): ");
            int row = sc.nextInt();

            System.out.print("Enter column (0-2): ");
            int col = sc.nextInt();

            // Check valid position
            if (row < 0 || row > 2 ||
                col < 0 || col > 2 ||
                board[row][col] != ' ') {

                System.out.println("Invalid move! Try again.");
                continue;
            }

            board[row][col] = currentPlayer;

            // Check winner
            if (checkWinner()) {
                displayBoard();
                System.out.println("Player " + currentPlayer + " Wins!");
                break;
            }

            // Check draw
            if (checkDraw()) {
                displayBoard();
                System.out.println("Game Draw!");
                break;
            }

            // Switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        sc.close();
    }

    // Initialize board
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Display board
    static void displayBoard() {

        System.out.println();

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j] + " ");

                if (j < 2) {
                    System.out.print("|");
                }
            }

            System.out.println();

            if (i < 2) {
                System.out.println("---+---+---");
            }
        }

        System.out.println();
    }

    // Check winner
    static boolean checkWinner() {

        // Check rows and columns
        for (int i = 0; i < 3; i++) {

            if (board[i][0] == currentPlayer &&
                board[i][1] == currentPlayer &&
                board[i][2] == currentPlayer) {
                return true;
            }

            if (board[0][i] == currentPlayer &&
                board[1][i] == currentPlayer &&
                board[2][i] == currentPlayer) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][2] == currentPlayer) {
            return true;
        }

        if (board[0][2] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }

    // Check draw
    static boolean checkDraw() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }
}