import java.util.LinkedList;

public class PiecesHandler {
    public static LinkedList<Piece> ps = new LinkedList<>();
    public static LinkedList<Piece> create(LinkedList<Piece> ps){

        Rook brook=new Rook(0,0,false,ps);
        Knight bknight=new Knight(1,0,false,ps);
        Bishop bbishop=new Bishop(2,0,false,ps);
        Queen bqueen=new Queen(3,0,false, ps);
        King bking=new King( 4,0,false, ps);
        Bishop bbishop1=new Bishop(5,0,false,ps);
        Knight bknight1=new Knight(6,0,false,ps);
        Rook brook1=new Rook(7,0,false,ps);
        Pawn bpawn=new Pawn(0,1,false,ps);
        Pawn bpawn1=new Pawn(1,1,false,ps);
        Pawn bpawn2=new Pawn(2,1,false,ps);
        Pawn bpawn3=new Pawn(3,1,false,ps);
        Pawn bpawn4=new Pawn(4,1,false,ps);
        Pawn bpawn5=new Pawn(5,1,false,ps);
        Pawn bpawn6=new Pawn(6,1,false,ps);
        Pawn bpawn7=new Pawn(7,1,false,ps);

        Rook wrook=new Rook(0,7,true,ps);
        Knight wknight=new Knight(1,7,true,ps);
        Bishop wbishop=new Bishop(2,7,true,ps);
        Queen wqueen=new Queen(3,7,true, ps);
        King wking=new King( 4,7,true, ps);
        Bishop wbishop2=new Bishop(5,7,true,ps);
        Knight wknight2=new Knight(6,7,true,ps);
        Rook wrook2=new Rook(7,7,true,ps);
        Pawn wpawn=new Pawn(0,6,true,ps);
        Pawn wpawn1=new Pawn(1,6,true,ps);
        Pawn wpawn2=new Pawn(2,6,true,ps);
        Pawn wpawn3=new Pawn(3,6,true,ps);
        Pawn wpawn4=new Pawn(4,6,true,ps);
        Pawn wpawn5=new Pawn(5,6,true,ps);
        Pawn wpawn6=new Pawn(6,6,true,ps);
        Pawn wpawn7=new Pawn(7,6,true,ps);

        return ps;
    }
    public static LinkedList<Piece> createReversed(LinkedList<Piece> ps){

        Rook wrook=new Rook(0,0,true,ps);
        Knight wknight=new Knight(1,0,true,ps);
        Bishop wbishop=new Bishop(2,0,true,ps);
        Queen wqueen=new Queen(3,0,true, ps);
        King wking=new King( 4,0,true, ps);
        Bishop wbishop2=new Bishop(5,0,true,ps);
        Knight wknight2=new Knight(6,0,true,ps);
        Rook wrook2=new Rook(7,0,true,ps);
        Pawn wpawn=new Pawn(0,1,true,ps);
        Pawn wpawn1=new Pawn(1,1,true,ps);
        Pawn wpawn2=new Pawn(2,1,true,ps);
        Pawn wpawn3=new Pawn(3,1,true,ps);
        Pawn wpawn4=new Pawn(4,1,true,ps);
        Pawn wpawn5=new Pawn(5,1,true,ps);
        Pawn wpawn6=new Pawn(6,1,true,ps);
        Pawn wpawn7=new Pawn(7,1,true,ps);

        Rook brook=new Rook(0,7,false,ps);
        Knight bknight=new Knight(1,7,false,ps);
        Bishop bbishop=new Bishop(2,7,false,ps);
        Queen bqueen=new Queen(3,7,false, ps);
        King bking=new King( 4,7,false, ps);
        Bishop bbishop1=new Bishop(5,7,false,ps);
        Knight bknight1=new Knight(6,7,false,ps);
        Rook brook1=new Rook(7,7,false,ps);
        Pawn bpawn=new Pawn(0,6,false,ps);
        Pawn bpawn1=new Pawn(1,6,false,ps);
        Pawn bpawn2=new Pawn(2,6,false,ps);
        Pawn bpawn3=new Pawn(3,6,false,ps);
        Pawn bpawn4=new Pawn(4,6,false,ps);
        Pawn bpawn5=new Pawn(5,6,false,ps);
        Pawn bpawn6=new Pawn(6,6,false,ps);
        Pawn bpawn7=new Pawn(7,6,false,ps);

        return ps;
    }
}
