public class King extends ChessPiece {
    public King(String color) {
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
                if ((line - 1 == toLine && column + 1 == toColumn)
                        || (line + 1 == toLine && column - 1 == toColumn)
                        || (line + 1 == toLine && column + 1 == toColumn)
                        || (line - 1 == toLine && column - 1 == toColumn)) {
                    isWayOpen = isWayOpen(chessBoard, toLine, toColumn, isWayOpen);
                    return isWayOpen;
                }
                if (line == toLine
                        && (column + 1 == toColumn || column - 1 == toColumn)) {
                    isWayOpen = isWayOpen(chessBoard, toLine, toColumn, isWayOpen);
                    return isWayOpen;
                }
                if (column == toColumn
                        && (line + 1 == toLine || line - 1 == toLine)) {
                    isWayOpen = isWayOpen(chessBoard, toLine, toColumn, isWayOpen);
                    return isWayOpen;
                }
            }
        }
        return false;
    }

    @Override
    String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (line >= 0 && line <= 7 && column >= 0 && column <= 7) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            return true;
                        }
                    }
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
}
