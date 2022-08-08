import java.io.IOException;

public class Horse extends ChessPiece{

    public Horse(String color) {
        super(color);
    }

    @Override
    String getColor() {
        return color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean isWayOpen = true;
        if (line >= 0 && line <= 7 && column >= 0 && column <= 7) {
            if (toLine >= 0 && toLine <= 7 && toColumn >= 0 && toColumn <= 7) {
                if ((line - 2 == toLine && column + 1 == toColumn)
                        || (line - 1 == toLine && column + 2 == toColumn)
                        || (line + 1 == toLine && column + 2 == toColumn)
                        || (line + 2 == toLine && column + 1 == toColumn)
                        || (line + 2 == toLine && column - 1 == toColumn)
                        || (line + 1 == toLine && column - 2 == toColumn)
                        || (line - 1 == toLine && column - 2 == toColumn)
                        || (line - 2 == toLine && column - 1 == toColumn)) {
                    isWayOpen = isWayOpen(chessBoard, toLine, toColumn, isWayOpen);
                    return isWayOpen;
                }
            }
        }
        return false;
    }

    private boolean isWayOpen(ChessBoard chessBoard, int toLine, int toColumn, boolean isWayOpen) {
        if (chessBoard.board[toLine][toColumn] != null) {
            if (color.equals(chessBoard.board[toLine][toColumn].getColor())) {
                isWayOpen = false;
            }
        }
        return isWayOpen;
    }

    @Override
    String getSymbol() {
        return "H";
    }
}
