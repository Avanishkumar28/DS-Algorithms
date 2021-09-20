package algo.leetcode;

/**
1275. Find Winner on a Tic Tac Toe Game
        Tic-tac-toe is played by two players A and B on a 3 x 3 grid.

        Here are the rules of Tic-Tac-Toe:

        Players take turns placing characters into empty squares (" ").
        The first player A always places "X" characters, while the second player B always places "O" characters.
        "X" and "O" characters are always placed into empty squares, never on filled ones.
        The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
        The game also ends if all squares are non-empty.
        No more moves can be played if the game is over.
Constraints:
        1 <= moves.length <= 9
        moves[i].length == 2
        0 <= moves[i][j] <= 2
        There are no repeated elements on moves.
        moves follow the rules of tic tac toe.
**/

public class TicTacToe {

    public static String tictactoe(int[][] moves) {
        if(moves.length<5)
            return "Pending";

        int[][] board = new int[3][3];
        for(int i = 0; i<moves.length; i++){
            int player = 0;
            int x = moves[i][0];
            int y = moves[i][1];
            if(i%2 == 0){
                //Player A
                player = 1;
                board[x][y] = player;
            }else{
                //Player B
                player = 2;
                board[x][y] = player;
            }
            //check for winner
            if(4 <= i && isWinner(board, player)){
                return player == 1 ? "A" : "B";
            }
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }

    private static boolean isWinner(int[][] board, int player){
        //check for row
        if(board[0][0] == player && board[0][1] == player && board[0][2] == player) return true;
        if(board[1][0] == player && board[1][1] == player && board[1][2] == player) return true;
        if(board[2][0] == player && board[2][1] == player && board[2][2] == player) return true;
        //check for col
        if(board[0][0] == player && board[1][0] == player && board[2][0] == player) return true;
        if(board[0][1] == player && board[1][1] == player && board[2][1] == player) return true;
        if(board[0][2] == player && board[1][2] == player && board[2][2] == player) return true;
        //check Diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;

        return false;
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{{0,0},{2,0},{1,1},{2,1},{2,2}};
        int[][] test2 = new int[][]{{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
        int[][] test3 = new int[][]{{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}};
        int[][] test4 = new int[][]{{0,0},{1,1}};

        System.out.println(test1); //"A"
        System.out.println(test2); //"B"
        System.out.println(test3); //"Draw"
        System.out.println(test4); //"Pending"

    }
}
