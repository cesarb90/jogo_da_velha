package TicTacToe;
public class Pieces {
    private char player;

    public Pieces(char player) {
        this.player = player;
    }

    public char getPlayer() {
        return player;
    }

    public boolean play(Board board, int row, int col) {
        if (board.isValidMove(row, col)) {
            board.makeMove(row, col, player);
            return true;
        } else {
            return false;
        }
    }
}
