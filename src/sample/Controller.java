package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


import java.io.File;
import java.io.IOException;

import static java.lang.Math.min;
import static java.lang.StrictMath.max;

public class Controller {

    public static class Move{
        int row;
        int column;
    }

    @FXML ImageView board00;
    @FXML ImageView board01;
    @FXML ImageView board02;

    @FXML ImageView board10;
    @FXML ImageView board11;
    @FXML ImageView board12;

    @FXML ImageView board20;
    @FXML ImageView board21;
    @FXML ImageView board22;

    @FXML ImageView currentPlyerIndicator;

    @FXML AnchorPane startPane;
    @FXML AnchorPane gamePane;


    Character playerTurn;

    Image putImage;
    Character board[][];
    private final Character compMove = 'x';
    private final Character humanMove = 'o';

    CompTicTacToe computer;



    @FXML
    public void initializeTheGame (ActionEvent event) throws IOException {

        computer = new CompTicTacToe();

        playerTurn = humanMove;
        putImage = new Image(new File("src/sample/assets/nought.png").toURI().toString());
        currentPlyerIndicator.setImage(putImage);

        board = new Character[3][3];
        for(int i = 0; i<3;i++){
            for(int j=0; j<3;j++){
                board[i][j] = '-';
            }
        }

        startPane.setVisible(false);
        startPane.setDisable(true);
        gamePane.setVisible(true);
    }

    @FXML
    public void Board00Pressed (MouseEvent event) throws  IOException{
        if(!board00.isDisabled()){
            board00.setImage(putImage);
            board[0][0] = humanMove;
            changePlayer();
        }
       board00.setDisable(true);

        if (checkWinCondition()){
            ((Node)(event.getSource())).getScene().getWindow().hide();
            return;
        }
        if(!isMovesLeft()){
            new Alert(Alert.AlertType.INFORMATION, "The Game is Draw").showAndWait();
        }
        moveComp(findBestMove(),event);
    }

    @FXML
    public void Board01Pressed (MouseEvent event) throws  IOException{
        if(!board01.isDisabled()){
            board01.setImage(putImage);
            board[0][1] = humanMove;
            changePlayer();
        }
        board01.setDisable(true);

        if (checkWinCondition()){
            ((Node)(event.getSource())).getScene().getWindow().hide();
            return;
        }

        if(!isMovesLeft()){
            new Alert(Alert.AlertType.INFORMATION, "The Game is Draw").showAndWait();
        }
        moveComp(findBestMove(),event);
    }

    @FXML
    public void Board02Pressed (MouseEvent event) throws  IOException{
        if(!board02.isDisabled()){
            board02.setImage(putImage);
            board[0][2] = humanMove;
            changePlayer();
        }
        board02.setDisable(true);
        if (checkWinCondition()){
            ((Node)(event.getSource())).getScene().getWindow().hide();
            return;
        }

        if(!isMovesLeft()){
            new Alert(Alert.AlertType.INFORMATION, "The Game is Draw").showAndWait();
        }
        moveComp(findBestMove(),event);
    }

    @FXML
    public void Board10Pressed (MouseEvent event) throws  IOException{
        if(!board10.isDisabled()){
            board10.setImage(putImage);
            board[1][0] = humanMove;
            changePlayer();
        }
        board10.setDisable(true);

        if (checkWinCondition()){
            ((Node)(event.getSource())).getScene().getWindow().hide();
            return;
        }
        if(!isMovesLeft()){
            new Alert(Alert.AlertType.INFORMATION, "The Game is Draw").showAndWait();
        }
        moveComp(findBestMove(),event);
    }

    @FXML
    public void Board11Pressed (MouseEvent event) throws  IOException{
        if(!board11.isDisabled()){
            board11.setImage(putImage);
            board[1][1] = humanMove;
            changePlayer();
        }
        board11.setDisable(true);

        if (checkWinCondition()){
            ((Node)(event.getSource())).getScene().getWindow().hide();
            return;
        }
        if(!isMovesLeft()){
            new Alert(Alert.AlertType.INFORMATION, "The Game is Draw").showAndWait();
        }
        moveComp(findBestMove(),event);
    }

    @FXML
    public void Board12Pressed (MouseEvent event) throws  IOException{
        if(!board12.isDisabled()){
            board12.setImage(putImage);
            board[1][2] = humanMove;
            changePlayer();
        }
        board12.setDisable(true);

        if (checkWinCondition()){
            ((Node)(event.getSource())).getScene().getWindow().hide();
            return;
        }
        if(!isMovesLeft()){
            new Alert(Alert.AlertType.INFORMATION, "The Game is Draw").showAndWait();
        }
        moveComp(findBestMove(),event);
    }

    @FXML
    public void Board20Pressed (MouseEvent event) throws  IOException{
        if(!board20.isDisabled()){
            board20.setImage(putImage);
            board[2][0] = humanMove;
            changePlayer();
        }
        board20.setDisable(true);
        if (checkWinCondition()){
            ((Node)(event.getSource())).getScene().getWindow().hide();
            return;
        }
        if(!isMovesLeft()){
            new Alert(Alert.AlertType.INFORMATION, "The Game is Draw").showAndWait();
        }
        moveComp(findBestMove(),event);
    }

    @FXML
    public void Board21Pressed (MouseEvent event) throws  IOException{
        if(!board21.isDisabled()){
            board21.setImage(putImage);
            board[2][1] = humanMove;
            changePlayer();
        }
        board21.setDisable(true);
        if (checkWinCondition()){
            ((Node)(event.getSource())).getScene().getWindow().hide();
            return;
        }
        if(!isMovesLeft()){
            new Alert(Alert.AlertType.INFORMATION, "The Game is Draw").showAndWait();
        }
        moveComp(findBestMove(),event);
    }

    @FXML
    public void Board22Pressed (MouseEvent event) throws  IOException{
        if(!board22.isDisabled()){
            board22.setImage(putImage);
            board[2][2] = humanMove;
            changePlayer();
        }
        board22.setDisable(true);

        if (checkWinCondition()){
            ((Node)(event.getSource())).getScene().getWindow().hide();
            return;
        }
        if(!isMovesLeft()){
            new Alert(Alert.AlertType.INFORMATION, "The Game is Draw").showAndWait();
        }
        moveComp(findBestMove(),event);
    }

    @FXML
    public void exitAction(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    private void changePlayer(){
        if(playerTurn == 'x'){
            putImage = new Image(new File("src/sample/assets/nought.png").toURI().toString());
            currentPlyerIndicator.setImage(putImage);
            playerTurn = 'o';
        }
        else{
            putImage = new Image(new File("src/sample/assets/cross.png").toURI().toString());
            currentPlyerIndicator.setImage(putImage);
            playerTurn = 'x';
        }

    }

    private boolean checkWinCondition()
    {
        //loops through rows checking if win-condition exists
        for (int r = 0; r < 3; r++) {
            if (board[r][0] == board[r][1] && board[r][1] == board[r][2] && board[r][0] != '-') {
                new Alert(Alert.AlertType.INFORMATION, board[r][0] + ", have won the game. The game will exit").showAndWait();
                return true;
            }
        }
        //loops through columns checking if win-condition exists
        for (int c = 0; c < 3; c++) {
            if (board[0][c] == board[1][c] && board[1][c] == board[2][c] && board[0][c] != '-' ){
                new Alert(Alert.AlertType.INFORMATION, board[0][c] + ", have won the game. The game will exit").showAndWait();
                return  true;
            }
        }

        //checks diagonals for win-condition
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-' )
        {
            new Alert(Alert.AlertType.INFORMATION, board[0][0] + ", have won the game. The game will exit").showAndWait();
            return true;
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-'){
            new Alert(Alert.AlertType.INFORMATION, board[0][2] + ", have won the game. The game will exit").showAndWait();
            return true;
        }

        return false;
    }

    //minimax algorithm implementation
    private boolean isMovesLeft()
    {

        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++)
            {
                if ( board[i][j] == '-' ) return true;
            }

        }

        return false;
    }


    private Move findBestMove(){
        return computer.findNextMove(board);
    }


    private void moveComp(Move computerMoves, Event event){

        if(computerMoves.row == 0){
             if(computerMoves.column == 0){
                 board[0][0] = compMove;
                 board00.setImage(putImage);
                 changePlayer();
                 board00.setDisable(true);
             }
             else if(computerMoves.column == 1){
                 board[0][1] = compMove;
                 board01.setImage(putImage);
                 changePlayer();
                 board01.setDisable(true);
             }
             else{
                 board[0][2] = compMove;
                 board02.setImage(putImage);
                 changePlayer();
                 board02.setDisable(true);
             }
        }

        else if(computerMoves.row == 1){
            if(computerMoves.column == 0){
                board[1][0] = compMove;
                board10.setImage(putImage);
                changePlayer();
                board00.setDisable(true);
            }
            else if(computerMoves.column == 1){
                board[1][1] = compMove;
                board11.setImage(putImage);
                changePlayer();
                board11.setDisable(true);
            }
            else{
                board[1][2] = compMove;
                board12.setImage(putImage);
                changePlayer();
                board12.setDisable(true);
            }
        }

        if(computerMoves.row == 2){
            if(computerMoves.column == 0){
                board[2][0] = compMove;
                board20.setImage(putImage);
                changePlayer();
                board20.setDisable(true);
            }
            else if(computerMoves.column == 1){
                board[2][1] = compMove;
                board21.setImage(putImage);
                changePlayer();
                board21.setDisable(true);
            }
            else{
                board[2][2] = compMove;
                board22.setImage(putImage);
                changePlayer();
                board22.setDisable(true);
            }
        }
        if (checkWinCondition()){
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        if(!isMovesLeft()){
            new Alert(Alert.AlertType.INFORMATION, "The Game is Draw").showAndWait();
        }
        printBoard();
    }

    private void printBoard(){

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                System.out.print(board[i][j]+ " + ");

            }
            System.out.println();

        }
    }
}
