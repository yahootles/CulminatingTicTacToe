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
        //create scanner
        Scanner kinput = new Scanner(System.in);

        //declare variables
        int winner = 0;
        String[][] gameboard = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
        getGameboardString(gameboard);

        System.out.println("Welcome to Tic Tac Toe! Here is the board!");
    }

    public static String getGameboardString(String[][] board) {
        String output = "";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                output += board[i][j] + " ";
            }
            
            output += "   ";
            
            for (int k = 6; k > 0; k-=2){
                int num = ((k%3)+1) + i*3;
                output += num+" ";
            }
            
            output += "\n";
        }
        
        System.out.println(output);

        return output;
    }
}
