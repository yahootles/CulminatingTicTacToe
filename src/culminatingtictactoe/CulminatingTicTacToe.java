/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package culminatingtictactoe;

/**
 *
 * @author antho6229
 */
import java.util.Scanner;

public class CulminatingTicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //constants
        final String P1 = "X";
        final String P2 = "O";

        //create scanner
        Scanner kinput = new Scanner(System.in);

        //declare variables
        int winner = 0;
        String[][] gameboard = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
        String output = "";

        System.out.println("Welcome to Tic Tac Toe! Here is the board!");
        output = getGameboardString(gameboard);
        System.out.println(output);

        gameboard = updateBoard(gameboard, 3, kinput, P1);

        output = getGameboardString(gameboard);
        System.out.println(output);
        while (winner == 0) {
            System.exit(0);
        }
    }

    /**
     *
     * @param board - the 2d array of strings that gets translated to a useable
     * string output
     * @return - A string that can be used for output
     */
    public static String getGameboardString(String[][] board) {
        String output = "";

        //lops throughto add elements of the board to the output string
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                output += board[i][j] + " ";
            }

            //adds space between actual boards and grid of numbers
            output += "   ";

            //fills board of numbers with 1 through 9
            for (int k = 6; k > 0; k -= 2) {
                int num = ((k % 3) + 1) + i * 3;
                output += num + " ";
            }
            //new line
            output += "\n";
        }

        return output;
    }

    /**
     * Tries to get an integer entered by user between 1 and 9 inclusive
     *
     * @param scan - Scanner used for getting input
     * @return - integer that was input by user
     */
    public static int getInput(Scanner scan) {
        int input = 0;
        boolean valid = false;

        //loops until a valid input is entered
        while (!valid) {
            try {
                input = scan.nextInt();

                if (input < 1 || input > 9) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("That is not valid input. Please enter an integer from 1 to 9.");
            }
        }

        return input;
    }

    public static String[][] updateBoard(String[][] gameboard, int placement, Scanner scan, String character) {
        int num = 0;
        int j = 0;
        try {
            for (int i = 0; i < 3; i++) {
                for (int k = 6; k > 0; k -= 2) {
                    num = ((k % 3) + 1) + i * 3;
                    j = (k % 3);

                    if (placement == num) {
                        if (gameboard[i][j].equals("-")) {
                            gameboard[i][j] = character;
                        } else {
                            System.out.println("There is already something there. Please enter a different number:");
                            throw new Exception();
                        }
                    }
                }
            }
        } catch (Exception e) {

        }
        return gameboard;
    }
}
