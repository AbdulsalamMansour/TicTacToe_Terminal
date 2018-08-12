package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        String[] users = setUsers();
        int moves = 0;
        String board[][] = generateInitialBoard();

        int MatchResult = isOver(board, moves);
        int errorCode;


        while (!((MatchResult == 0) || (MatchResult == 1) || (MatchResult == 2))) {
            show(board);
            errorCode = -1;


            System.out.println();

            if (moves % 2 == 0) {


                while (errorCode != 0) {

                    try {
                        Scanner userInput = new Scanner(System.in);
                        System.out.print(users[0] + ", please insert the location: ");
                        errorCode = insertMove(board, "X", userInput.nextInt());
                        System.out.println();

                        if (errorCode == 1)
                            System.out.println("worng input Format");
                        else if (errorCode == 2)
                            System.out.println("this location is pre-occupied");
                    } catch (Exception e) {

                        System.out.println("print a number between 1 and 9");
                    }

                }

            } else {
                while (errorCode != 0) {

                    try {
                        Scanner userInput = new Scanner(System.in);
                        System.out.print(users[1] + ", please insert the location: ");
                        errorCode = insertMove(board, "O", userInput.nextInt());
                        System.out.println();

                        if (errorCode == 1)
                            System.out.println("worng input Format");
                        else if (errorCode == 2)
                            System.out.println("this location is pre-occupied");
                    } catch (Exception e) {
                        System.out.println("enter a number between 1 and 9");
                    }

                }
            }
            moves++;

            MatchResult = isOver(board, moves);


        }

        show(board);

        if (MatchResult == 1)
            System.out.println(users[0] + " won !");
        else if (MatchResult == 2)
            System.out.println(users[1] + " won !");
        else
            System.out.println("draw");


    }

    //method to create the empty board

    private static String[][] generateInitialBoard() {

        String[][] board = new String[3][3];

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                board[i][j] = " ";

            }

        }

        return board;

    }


    //method to show the board
    private static void show(String board[][]) {

        System.out.println("---------------------------------------------\n");


        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {


                System.out.print("[  ");

                System.out.print(board[i][j]);

                System.out.print("  ]");

                System.out.print("\t");

            }
            System.out.println();
            System.out.println();

        }

        System.out.println("---------------------------------------------");

    }

    //method to insert a value into the board
    //return value 1 means wrong input format
    //return value 2 means an occupied cell
    //retuen value 0 means valid insertion


    private static int insertMove(String[][] gameBoard, String input, int location) {


        int row, column;

        switch (location) {

            case 1:
                row = 0;
                column = 0;
                break;

            case 2:
                row = 0;
                column = 1;
                break;

            case 3:
                row = 0;
                column = 2;
                break;

            case 4:
                row = 1;
                column = 0;
                break;

            case 5:
                row = 1;
                column = 1;
                break;

            case 6:
                row = 1;
                column = 2;
                break;

            case 7:
                row = 2;
                column = 0;
                break;

            case 8:
                row = 2;
                column = 1;
                break;

            case 9:
                row = 2;
                column = 2;
                break;


            default:
                return 1;
        }


        input = input.toUpperCase();

        if (!(input.equals("O") || input.equals("X")))
            return 1;

        if (!(gameBoard[row][column].equals(" ")))
            return 2;

        gameBoard[row][column] = input;
        return 0;

    }

    //this function gets user names from console

    private static String[] setUsers() {
        String users[] = new String[2];

        System.out.println("Insert User names, user 1 gets \"X\" and user 2 gets \"O\" ");
        System.out.print("User 1 name: ");
        Scanner scanner = new Scanner(System.in);
        users[0] = scanner.next();
        System.out.println();
        System.out.print("User 2 name: ");
        users[1] = scanner.next();
        System.out.println();

        return users;
    }


    //0 value means draw
    //1 value means X won
    //2 value means O won
    //4 value means unexpected error

    private static int isOver(String[][] gameBoard, int moves) {

        //First Row
        if ((gameBoard[0][0].equals(gameBoard[0][1])) && (gameBoard[0][1].equals(gameBoard[0][2]))) {
            if (gameBoard[0][0].equals("X"))
                return 1;
            else if (gameBoard[0][0].equals("O"))
                return 2;
        }

        //Second Row
        if ((gameBoard[1][0].equals(gameBoard[1][1])) && (gameBoard[1][1].equals(gameBoard[1][2]))) {
            if (gameBoard[1][0].equals("X"))
                return 1;
            else if (gameBoard[1][0].equals("O"))
                return 2;
        }

        //Third Row
        if ((gameBoard[2][0].equals(gameBoard[2][1])) && (gameBoard[2][1].equals(gameBoard[2][2]))) {
            if (gameBoard[2][0].equals("X"))
                return 1;
            else if (gameBoard[2][0].equals("O"))
                return 2;
        }

        //First column
        if ((gameBoard[0][0].equals(gameBoard[1][0])) && (gameBoard[1][0].equals(gameBoard[2][0]))) {
            if (gameBoard[0][0].equals("X"))
                return 1;
            else if (gameBoard[0][0].equals("O"))
                return 2;
        }

        //Second Column
        if ((gameBoard[0][1].equals(gameBoard[1][1])) && (gameBoard[1][1].equals(gameBoard[2][1]))) {
            if (gameBoard[0][1].equals("X"))
                return 1;
            else if (gameBoard[0][1].equals("O"))
                return 2;
        }

        //third column
        if ((gameBoard[0][2].equals(gameBoard[1][2])) && (gameBoard[1][2].equals(gameBoard[2][2]))) {
            if (gameBoard[0][2].equals("X"))
                return 1;
            else if (gameBoard[0][2].equals("O"))
                return 2;
        }

        //left Diagonal

        if ((gameBoard[0][0].equals(gameBoard[1][1])) && (gameBoard[1][1].equals(gameBoard[2][2]))) {
            if (gameBoard[0][0].equals("X"))
                return 1;
            else if (gameBoard[0][0].equals("O"))
                return 2;
        }

        //right Diagonal
        if ((gameBoard[0][2].equals(gameBoard[1][1])) && (gameBoard[1][1].equals(gameBoard[2][0]))) {
            if (gameBoard[0][2].equals("X"))
                return 1;
            else if (gameBoard[0][2].equals("O"))
                return 2;
        }

        if (moves == 9)
            return 0;


        return 4;

    }


}
