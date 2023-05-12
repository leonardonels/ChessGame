import java.util.LinkedList;

public abstract class Piece {
    int xp;
    int yp;
    int x;
    int y;
    boolean castle=true;
    boolean isWhite;
    static LinkedList<Piece> ps;
    String name;
    public Piece(int xp, int yp, boolean isWhite,String n, LinkedList<Piece> ps) {
        this.xp = xp;
        this.yp = yp;
        x=xp*64;
        y=yp*64;
        this.isWhite = isWhite;
        this.ps=ps;
        name=n;
        ps.add(this);
    }
    public abstract void move(int xp,int yp);
    public boolean draw(){
        int kings=0;
        for(Piece p : ps){
            if (p.name=="King"){kings++;}
        }
        if(ps.size()==2&&kings==2){
            return true;
        }
        return false;
    }
    public Piece checkmate(){
        int kings=0;
        for(Piece p : ps){
            if (p.name=="King"){kings++;}
        }
        if(kings!=2){
            for(Piece p : ps){
                if(p.name=="King"){
                    return p;
                }
            }
        }
        return null;
    }
    public boolean bishopMovementCheck(int xp, int yp){
        int xdif=xp-this.xp;
        int ydif=yp-this.yp;

        if(xdif==ydif&&xdif>0){
            //down-right
            for(int i=1; i<xdif; i++){
                if(PieceHelper.getPiece((xp-i)*64, (yp-i)*64, ps)!=null){
                    return true;
                }
            }
        }
        if(xdif==ydif&&xdif<0){
            //up-left
            for(int i=-1; i>xdif; i--){
                if(PieceHelper.getPiece((xp-i)*64, (yp-i)*64, ps)!=null){
                    return true;
                }
            }
        }
        if(xdif+ydif==0&&xdif>0){
            //up-right : ydif<0
            for(int i=1; i<xdif; i++){
                if(PieceHelper.getPiece((xp-i)*64, (yp-(i*(-1)))*64, ps)!=null){
                    return true;
                }
            }
        }
        if(xdif!=ydif&&xdif+ydif==0&&xdif<0){
            //down-left : ydif>0
            for(int i=-1; i>xdif; i--){
                if(PieceHelper.getPiece((xp-i)*64, (yp-(i*(-1)))*64, ps)!=null){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean rookMovementCheck(int xp, int yp){
        int xdif=xp-this.xp;
        int ydif=yp-this.yp;
        if (xdif>0&&ydif==0){
            for(int i=1; i<xdif; i++){
                if(PieceHelper.getPiece((xp-i)*64, yp*64, ps)!=null){
                    return true;
                }
            }
        }
        if(xdif<0&&ydif==0){
            for(int i=-1; i>xdif; i--){
                if(PieceHelper.getPiece((xp-i)*64, yp*64, ps)!=null){
                    return true;
                }
            }
        }
        if (xdif==0&&ydif>0){
            for(int i=1; i<ydif; i++){
                if(PieceHelper.getPiece(xp*64, (yp-i)*64, ps)!=null){
                    return true;
                }
            }
        }
        if(xdif==0&&ydif<0){
            for(int i=-1; i>ydif; i--){
                if(PieceHelper.getPiece(xp*64, (yp-i)*64, ps)!=null){
                    return true;
                }
            }
        }
        return false;
    }
    public void kill(LinkedList<Piece> ps){
        ps.remove(this);
        GameState.resetMoves();
    }
    public void resetPosition(int xp, int yp){
        xp=this.xp;
        yp=this.yp;
        x=xp*64;
        y=yp*64;
    }
}