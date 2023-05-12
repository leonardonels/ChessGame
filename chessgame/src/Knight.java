import java.util.LinkedList;

public class Knight extends Piece{
    public Knight(int xp, int yp, boolean isWhite, LinkedList<Piece> ps) {
        super(xp, yp, isWhite, "Knight", ps);
    }

    @Override
    public void move(int xp,int yp){
        if(Main.debugMode)System.out.println("Knight "+this.xp+" "+this.yp+" : "+xp+" "+yp);

        if(!(Math.abs(xp-this.xp)==2&&Math.abs(yp-this.yp)==1||Math.abs(xp-this.xp)==1&&Math.abs(yp-this.yp)==2)) {
            xp=this.xp;
            yp=this.yp;
            x=xp*64;
            y=yp*64;
            return;

        }

        if(PieceHelper.getPiece(xp*64, yp*64, ps)!=null){
            if(PieceHelper.getPiece(xp*64, yp*64, ps).isWhite!=isWhite){
                PieceHelper.getPiece(xp*64, yp*64, ps).kill(ps);

            }else{
                x=this.xp*64;
                y=this.yp*64;
                return;
            }
        }
        this.xp=xp;
        this.yp=yp;
        x=xp*64;
        y=yp*64;
    }
}
