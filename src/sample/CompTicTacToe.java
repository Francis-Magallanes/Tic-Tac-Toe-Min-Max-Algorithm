package sample;

import static java.lang.Double.*;

public class CompTicTacToe {

    private Character board[][];

    private final Character compMove = 'x';
    private final Character humanMove = 'o';


    private Controller.Move compNextMove;

    CompTicTacToe(){
            board = new Character[3][3];
            compNextMove = new Controller.Move();
    }

    public Controller.Move findNextMove(Character currentBoard[][]){
        Double moveVal = 0.0 ;
        Double bestVal = Double.NEGATIVE_INFINITY;

        //this the minimax of the game;

        //transfer first the board in the object
        transferBoardStatus(currentBoard);

        for (int i = 0; i<3; i++)
        {
            for (int j = 0; j<3; j++)
            {
                if (board[i][j]=='-')
                {

                    board[i][j] = compMove;


                    moveVal = minimax(false,NEGATIVE_INFINITY,POSITIVE_INFINITY);


                    board[i][j] = '-';

                    if (moveVal > bestVal)
                    {
                        compNextMove.row = i;
                        compNextMove.column = j;
                        bestVal = moveVal;
                    }
                }
            }
        }


        return compNextMove;
    }

    private Double minimax(Boolean isCompMove, Double alpha, Double beta){
        // parameters alpha and beta are for the prunning
        //isCompMove:True - the computer will make the move


        if(isWinner() || !isMovesLeft()){
            return evaluateBoard();
        }
        else {

            Double compEval, humanEval;
            Double maxComp = Double.NEGATIVE_INFINITY;
            Double minHuman = Double.POSITIVE_INFINITY;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (board[i][j] == '-') {

                       if(isCompMove){
                           board[i][j] = compMove;
                           compEval = minimax(false, alpha,beta);
                           maxComp = max(maxComp,compEval);
                           alpha = max (alpha,compEval);

                           if (beta<=alpha){
                               board[i][j] = '-';
                               break;
                           }

                       }
                       else{
                           board[i][j] = humanMove;
                           humanEval = minimax(true,alpha,beta);
                           minHuman = min(minHuman,humanEval);
                           beta = min(beta,humanEval);

                           if (beta<=alpha) {
                               board[i][j] = '-';
                               break;
                           }
                       }

                       board[i][j] = '-';
                    }

                }

            }


            if(isCompMove){
                return maxComp;
            }
            else{
                return minHuman;
            }
        }
    }

    private Double evaluateBoard(){
        /*
        this will help in evaluating whether the comp is winning or not

         */

        // Checking for Rows for X or O victory.
        for (int row = 0; row<3; row++)
        {
            if (board[row][0] == board[row][1] && board [row][1] == board[row][2] && board[row][0] != '-')
            {
                if (board[row][1] == compMove)
                    return 10.0;
                else if (board[row][1] == humanMove)
                    return 0.0;
            }
        }

        // Checking for Columns for X or O victory.
        for (int col = 0; col<3; col++)
        {
            if (board[0][col]==board[1][col] &&
                    board[1][col]==board[2][col] && board[0][col] != '-')
            {
                if (board[1][col]== compMove)
                    return 10.0;

                else if (board[1][col]== humanMove)
                    return 0.0;
            }
        }

        // Checking for Diagonals for X or O victory.
        if (board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[0][0] != '-')
        {
            if (board[1][1]== compMove)
                return 10.0;
            else if (board[1][1]== humanMove)
                return 0.0;
        }

        if (board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[0][2] != '-')
        {
            if (board[1][1]== compMove)
                return 10.0;
            else if (board[1][1]== humanMove){
                return 0.0;
            }

        }

        // Else if none of them have won then return 0
        return 5.0;

    }

    private boolean isWinner(){
        //this will evaluate the board whether there is a winner or not
        // Checking for Rows for X or O victory.
        for (int row = 0; row<3; row++)
        {
            if (board[row][0] == board[row][1] && board [row][1] == board[row][2] && board[row][0] != '-')
            {
               return true;
            }
        }

        // Checking for Columns for X or O victory.
        for (int col = 0; col<3; col++)
        {
            if (board[0][col]==board[1][col] &&
                    board[1][col]==board[2][col] && board[0][col] != '-')
            {
               return true;
            }
        }

        // Checking for Diagonals for X or O victory.
        if (board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[1][1] != '-')
        {
            return true;
        }

        if (board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[1][1] != '-')
        {
            return true;
        }


        return false;
    }

    private boolean isMovesLeft() {
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++)
            {
                if ( board[i][j] == '-' ) return true;
            }

        }

        return false;
    }

    private void transferBoardStatus(Character boardCurrent[][]){

        //this help in the minimax checking

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                board[i][j] = boardCurrent[i][j];

            }

        }
    }

    private void printBoard(){

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                System.out.print(board[i][j]+ " + ");

            }
            System.out.println();

        }

        System.out.println("_________________________");
        System.out.println();
    }
}
