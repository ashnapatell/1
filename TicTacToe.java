import java.util.Scanner;
public class TicTacToe {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("player 1 Name: ");
        String player1 = in.nextLine();
        System.out.print("player 2 Name: ");
        String player2 = in.nextLine();

        char[][] gameboard = new char[3][3];
        for (int r = 0; r < 3; r++){
            for (int c = 0; c < 3; c++){
                gameboard[r][c] = '-';
            }
        }
        boolean player1Turn = true;
        boolean gameEnded = false;
        while(!gameEnded){
            drawBoard(gameboard);
            char symbol = ' ';
            if (player1Turn){
                symbol = 'x';
            } else {
                symbol = 'o';
            }
            if (player1Turn){
                System.out.println(player1 + "'s turn(x)");
            } else {
                System.out.println(player2 + "'s turn(o)");
            }
            int row = 0;
            int col = 0;
            while(true){
                System.out.print("enter a row (0,1,2): ");
                row = in.nextInt();
                System.out.print("enter a column (0,1,2): ");
                col = in.nextInt();
                if (row < 0 || row > 2 || col < 0 || col > 2){
                    System.out.println("out of bounds");
                } else {
                    if (gameboard[row][col] != '-'){
                        System.out.println("someone has already made a move there");
                    } else {
                        break;
                    }
                }
            }
            gameboard[row][col] = symbol;
            if (hasWon(gameboard) == 'x'){
                System.out.println(player1 + " has won");
                gameEnded = true;
            } else {
                if (hasWon(gameboard) == 'o'){
                    System.out.println(player2 + " has won");
                    gameEnded = true;
                } else {
                    if (hasTied(gameboard)){
                        System.out.println("it's a tie");
                        gameEnded = true;
                    } else {
                        player1Turn = !player1Turn;
                    }
                }
            }  
        }
        drawBoard(gameboard);

        }
        
    public static void drawBoard(char[][] gameboard){
        for (int r = 0; r < 3; r++){
            for (int c = 0; c < 3; c++){
                System.out.print(gameboard[r][c]);
            }
            System.out.println();
    }
}
    public static char hasWon(char[][] gameboard){
        for (int r = 0; r < 3; r++){
            if (gameboard[r][0] == gameboard[r][1] && gameboard[r][1] == gameboard[r][2] && gameboard[r][0] != '-'){
                return gameboard[r][0];
            }
        }
        for (int c = 0; c < 3; c++){
            if (gameboard[0][c] == gameboard[1][c] && gameboard[1][c] == gameboard[2][c] && gameboard[0][c] != '-'){
                return gameboard[0][c];
            }
        }
        if (gameboard[0][0] == gameboard[1][1] && gameboard[1][1] == gameboard[2][2] && gameboard[0][0] != '-'){
            return gameboard[0][0];
        }
        if (gameboard[2][0] == gameboard[1][1] && gameboard[1][1] == gameboard[0][2] && gameboard[2][0] != '-'){
            return gameboard[2][0];
        }
        return '-';
}
    public static boolean hasTied(char[][] gameboard){
        for (int r = 0; r < 3; r++){
            for (int c = 0; c < 3; c++){
                if (gameboard[r][c] == '-'){
                    return false;
                }
            }
        }
        return true;
    }
}

