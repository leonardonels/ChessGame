import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

public class GameState extends JFrame implements State{
    public Piece selectedPiece = null;

    public static  LinkedList<Piece> ps=new LinkedList<>();
    public Image[] imgs = Icons.scan();
    public ChessGame chessGame;
    public static int moves=0; //50-moves rule
    public GameState(ChessGame chessGame){
        this.chessGame=chessGame;
        ps=new LinkedList<>();
        moves=0;
    }
    public static void addMove(){
        moves++;
    }
    public static void resetMoves(){
        moves=-1;
    }
    @Override
    public JFrame create() {

        JFrame frame = new JFrame("Chess");
        frame.setBounds(256, 128, 512, 512);
        frame.setResizable(false);
        frame.setUndecorated(true);

        JPanel pn;
        if(!chessGame.altBoard) {
            ps = PiecesHandler.create(ps);
        }else{
            ps = PiecesHandler.createReversed(ps);
        }
        pn = chessGame.getBoard(ps, imgs);
        frame.add(pn);

        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedPiece != null) {
                    selectedPiece.x = e.getX() - 32;
                    selectedPiece.y = e.getY() - 32;
                    frame.repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectedPiece = PieceHelper.getPiece(e.getX(), e.getY(), ps);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(selectedPiece.xp==e.getX()/64&&selectedPiece.yp==e.getY()/64){
                    selectedPiece.resetPosition(e.getX(), e.getY());
                }else {
                    selectedPiece.move(e.getX() / 64, e.getY() / 64);
                    if (selectedPiece.checkmate() != null) {
                        if (selectedPiece.checkmate().isWhite) {
                            chessGame.whiteWins = true;
                        } else {
                            chessGame.blackWins = true;
                        }
                        if(Main.debugMode)System.out.println("CHECKMATE!");
                        chessGame.setInvisible();
                        chessGame.setState(chessGame.scoreState);
                        chessGame.setFrame();
                    }
                    if(selectedPiece.draw()){
                        if(Main.debugMode)System.out.println("DRAW!");
                        chessGame.setInvisible();
                        chessGame.setState(chessGame.scoreState);
                        chessGame.setFrame();
                    }
                    addMove();
                    if(moves>=50){
                        chessGame.setState(chessGame.scoreState);
                        chessGame.setInvisible();
                        chessGame.setFrame();
                    }
                }
                frame.repaint();
                if(Main.debugMode)System.out.println("total consecutive moves without capturing: "+moves);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

        return frame;
    }
}
