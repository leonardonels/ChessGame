import java.util.LinkedList;

public class Pawn extends Piece{
    public Pawn(int xp, int yp, boolean isWhite, LinkedList<Piece> ps) {
        super(xp, yp, isWhite, "Pawn", ps);
    }
    boolean start=true;
    int starty=this.yp;
    @Override
    public void move(int xp,int yp){
        if(Main.debugMode)System.out.println("Pawn "+this.xp+" "+this.yp+" : "+xp+" "+yp);

        if(starty<4&&yp-this.yp<0||starty>=4&&yp-this.yp>0){
            xp=this.xp;
            yp=this.yp;
            x=xp*64;
            y=yp*64;
            return;
        }
        if(Math.abs(xp-this.xp)==1&&Math.abs(yp-this.yp)==1){
            if(PieceHelper.getPiece(xp*64, yp*64, ps)!=null){
                if(PieceHelper.getPiece(xp*64,yp*64, ps).isWhite!=isWhite){
                    PieceHelper.getPiece(xp*64, yp*64, ps).kill(ps);
                }else{
                    x=this.xp*64;
                    y=this.yp*64;
                    return;
                }
                this.xp=xp;
                this.yp=yp;
                x=xp*64;
                y=yp*64;
                return;
            }
        }
        if(start) {
            if (Math.abs(xp - this.xp) == 0 && Math.abs(yp - this.yp) == 2) {
                if (starty < 4 && PieceHelper.getPiece(xp * 64, (yp - 1) * 64, ps) == null || starty >= 4 && PieceHelper.getPiece(xp * 64, (yp + 1) * 64, ps) == null) {
                    if (PieceHelper.getPiece(xp * 64, yp * 64, ps) != null) {
                        x = this.xp * 64;
                        y = this.yp * 64;
                        return;
                    } else {
                        start = false;
                        this.xp = xp;
                        this.yp = yp;
                        x = xp * 64;
                        y = yp * 64;
                        return;
                    }
                }else{
                    x = this.xp * 64;
                    y = this.yp * 64;
                    return;
                }
            }
        }
        if (Math.abs(xp - this.xp) == 0 && Math.abs(yp - this.yp) == 1) {
            if (PieceHelper.getPiece(xp * 64, yp * 64, ps) != null) {
                x = this.xp * 64;
                y = this.yp * 64;
                return;
            } else {
                start=false;
                this.xp = xp;
                this.yp = yp;
                x = xp * 64;
                y = yp * 64;
                return;
            }
        }else{
            x = this.xp * 64;
            y = this.yp * 64;
            return;
        }
    }
}
