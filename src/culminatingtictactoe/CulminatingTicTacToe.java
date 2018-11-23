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
        int input = 0;
        int numEntered = 0;
        String[][] gameboard = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
        String output = "";

        System.out.println("Welcome to Tic Tac Toe! Here is the board!");
        output = getGameboardString(gameboard);
        System.out.println(output);

//        gameboard = updateBoard(gameboard, 3, kinput, P1);
        while (winner == 0) {
            System.out.println("Player 1's turn. Please enter a number from 1-9. The numbers correspond to position on the board.");
            input = getInput(kinput);
            gameboard = updateBoard(gameboard, input, kinput, P1);
            output = getGameboardString(gameboard);
            numEntered++;
            System.out.println(output);

            if(numEntered>=9){
                winner = 3;
            }
            
            System.out.println("Player 2's turn. Please enter a number from 1-9. The numbers correspond to position on the board.");
            input = getInput(kinput);
            gameboard = updateBoard(gameboard, input, kinput, P2);
            output = getGameboardString(gameboard);
            numEntered++;
            System.out.println(output);
            

//            System.exit(0);
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
                valid = true;
            } catch (Exception e) {
                System.out.println("That is not valid input. Please enter an integer from 1 to 9.");
            }
        }

        return input;
    }

    /**
     * Method used to update the board
     * @param gameboard - the board you wish to use
     * @param placement - which position the user wants to put their marker in
     * @param scan - scanner in case something is already in the position
     * @param character - the letter being used as a marker
     * @return - updated gameboard
     */
    public static String[][] updateBoard(String[][] gameboard, int placement, Scanner scan, String character) {
        int num = 0;
        int j = 0;
        boolean worked = false;

        //loops through until the player enters a 
        while (!worked) {
            try {
                for (int i = 0; i < 3; i++) {
                    for (int k = 6; k > 0; k -= 2) {
                        //each time the loop runs it increases by 1
                        num = ((k % 3) + 1) + i * 3;
                        //number between 0 and 2, which is used to place the string in the 2d array
                        j = (k % 3);

                        //check to see if it is the right position
                        if (placement == num) {
                            //check to see if neither player has placed something in this slot
                            if (gameboard[i][j].equals("-")) {
                                gameboard[i][j] = character;
                                worked = true;
                            } else {
                                //make them input another number
                                throw new Exception();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("There is already something there. Please enter a different integer between 1 and 9:");
                placement = getInput(scan);
            }
        }
        return gameboard;
    }
    
    public static int checkWinner(String[][] gameboard){
        
        return 0;
    }
}
