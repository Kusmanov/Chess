public class Rook extends ChessPiece {
    public Rook(String color) {
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
                for (int i = 1; i <= 7; i++) {
                    if (line == toLine) {
                        if (column + i == toColumn) {
                            for (int j = 1; j < i; j++) {
                                if (chessBoard.board[line][column + j] != null) {
                                    isWayOpen = false;
                                }
                            }
                            isWayOpen = isWayOpen(chessBoard, toLine, toColumn, isWayOpen);
                            return isWayOpen;
                        }
                        if (column - i == toColumn) {
                            for (int j = 1; j < i; j++) {
                                if (chessBoard.board[line][column - j] != null) {
                                    isWayOpen = false;
                                }
                            }
                            isWayOpen = isWayOpen(chessBoard, toLine, toColumn, isWayOpen);
                            return isWayOpen;
                        }
                    }
                    if (column == toColumn) {
                        if (line + i == toLine) {
                            for (int j = 1; j < i; j++) {
                                if (chessBoard.board[line + j][column] != null) {
                                    isWayOpen = false;
                                }
                            }
                            isWayOpen = isWayOpen(chessBoard, toLine, toColumn, isWayOpen);
                            return isWayOpen;
                        }
                        if (line - i == toLine) {
                            for (int j = 1; j < i; j++) {
                                if (chessBoard.board[line - j][column] != null) {
                                    isWayOpen = false;
                                }
                            }
                            isWayOpen = isWayOpen(chessBoard, toLine, toColumn, isWayOpen);
                            return isWayOpen;
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
        return "R";
    }
}
