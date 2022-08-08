public class Pawn extends ChessPiece{

    public Pawn(String color) {
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
                if (column == toColumn) {
                    if (getColor().equals("White")) {
                        if (line == 1 && line + 2 == toLine) {
                            if (chessBoard.board[line + 1][column] != null) {
                                isWayOpen = false;
                            }
                            isWayOpen = isWayOpen(chessBoard, toLine, toColumn, isWayOpen);
                            return isWayOpen;
                        }
                        if (line != 0 && line + 1 == toLine) {
                            isWayOpen = isWayOpen(chessBoard, toLine, toColumn, isWayOpen);
                            return isWayOpen;
                        }
                    }
                    if (getColor().equals("Black")) {
                        if (line == 6 && line - 2 == toLine) {
                            if (chessBoard.board[line - 1][column] != null) {
                                isWayOpen = false;
                            }
                            isWayOpen = isWayOpen(chessBoard, toLine, toColumn, isWayOpen);
                            return isWayOpen;
                        }
                        if (line != 7 && line - 1 == toLine) {
                            isWayOpen = isWayOpen(chessBoard, toLine, toColumn, isWayOpen);
                            return isWayOpen;
                        }
                    }
                } else {
                    if ((line + 1 == toLine && column - 1 == toColumn)
                            || (line + 1 == toLine && column + 1 == toColumn)
                            && chessBoard.board[toLine][toColumn] != null) {
                        if (!chessBoard.board[toLine][toColumn].getColor().equals(color)) {
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

    @Override
    String getSymbol() {
        return "P";
    }
}
