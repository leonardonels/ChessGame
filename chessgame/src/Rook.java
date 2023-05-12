import java.util.LinkedList;

public class Rook extends Piece{
    public Rook(int xp, int yp, boolean isWhite, LinkedList<Piece> ps) {
        super(xp, yp, isWhite, "Rook", ps);
    }

    public void castling(int xp, int yp){
        if(Main.debugMode)System.out.println("Rook castling "+this.xp+" "+this.yp+" : "+xp+" "+yp);
        this.xp=xp;
        this.yp=yp;
        x=xp*64;
        y=yp*64;
        return;
    }
    @Override
    public void move(int xp,int yp){
        if(Main.debugMode)System.out.println("Rook "+this.xp+" "+this.yp+" : "+xp+" "+yp);

        if(rookMovementCheck(xp, yp)){
            x=this.xp*64;
            y=this.yp*64;
            return;
        }
        if(Math.abs(xp-this.xp)!=0&&Math.abs(yp-this.yp)!=0){
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
        castle=true;
        this.xp=xp;
        this.yp=yp;
        x=xp*64;
        y=yp*64;
    }
}
