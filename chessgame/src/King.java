import java.util.LinkedList;

public class King extends Piece{
    public King(int xp, int yp, boolean isWhite, LinkedList<Piece> ps) {
        super(xp, yp, isWhite, "King", ps);

    }

    @Override
    public void move(int xp,int yp) {
        if (Main.debugMode) System.out.println("king " + this.xp + " " + this.yp + " : " + xp + " " + yp);

        if (!castle && (Math.abs(xp - this.xp) > 1 || Math.abs(yp - this.yp) > 1)) {
            xp = this.xp;
            yp = this.yp;
            x = xp * 64;
            y = yp * 64;
            return;
        }
        if (!castle && PieceHelper.getPiece(xp, yp, ps) != null && (Math.abs(xp - this.xp) == 1 || Math.abs(yp - this.yp) == 1)) {
            if (PieceHelper.getPiece(xp * 64, yp * 64, ps).isWhite != isWhite) {
                PieceHelper.getPiece(xp * 64, yp * 64, ps).kill(ps);
                castle = false;
            } else {
                x = this.xp * 64;
                y = this.yp * 64;
                return;
            }
            this.xp = xp;
            this.yp = yp;
            x = this.xp * 64;
            y = this.yp * 64;
            return;
        }
        if (castle && !rookMovementCheck(xp, yp) && (this.yp == 0 || this.yp == 7) && PieceHelper.getPiece(xp * 64, yp * 64, ps) instanceof Rook && PieceHelper.getPiece(xp * 64, yp * 64, ps).castle && (PieceHelper.getPiece(xp * 64, yp * 64, ps).yp == 0 || PieceHelper.getPiece(xp * 64, yp * 64, ps).yp == 7)) {
            castle = false;
            ((Rook) PieceHelper.getPiece(xp * 64, yp * 64, ps)).castling(this.xp, this.yp);
            this.xp = xp;
            this.yp = yp;
            x = this.xp * 64;
            y = this.yp * 64;
        }
        if (castle && (Math.abs(xp - this.xp) > 1 || Math.abs(yp - this.yp) > 1)) {
            xp = this.xp;
            yp = this.yp;
            x = xp * 64;
            y = yp * 64;
            return;
        }
        if (castle && PieceHelper.getPiece(xp * 64, yp * 64, ps) != null) {
            if (PieceHelper.getPiece(xp * 64, yp * 64, ps).isWhite != isWhite) {
                PieceHelper.getPiece(xp * 64, yp * 64, ps).kill(ps);
            } else {
                x = this.xp * 64;
                y = this.yp * 64;
                return;
            }
        }
        castle = false;
        this.xp = xp;
        this.yp = yp;
        x = xp * 64;
        y = yp * 64;

    }
}