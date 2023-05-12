import java.util.LinkedList;

public class Bishop extends Piece{
    public Bishop(int xp, int yp, boolean isWhite, LinkedList<Piece> ps) {
        super(xp, yp, isWhite, "Bishop", ps);
    }

    @Override
    public void move(int xp,int yp){
        if(Main.debugMode)System.out.println("Bishop "+this.xp+" "+this.yp+" : "+xp+" "+yp);

        if(bishopMovementCheck(xp, yp)){
            x=this.xp*64;
            y=this.yp*64;
            return;
        }
        if(Math.abs(xp-this.xp)!=Math.abs(yp-this.yp)){
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
