import java.util.LinkedList;

public class PieceHelper {
    public static Piece getPiece(int x, int y, LinkedList<Piece> ps) {
        int xp = x / 64;
        int yp = y / 64;
        for (Piece p : ps) {
            if (p.xp == xp && p.yp == yp) {
                return p;
            }
        }
        return null;
    }
}
