import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ChessGame {
    public State state;
    public StartState startState;
    public GameState gameState;
    public ScoreState scoreState;
    public JFrame frame;
    public boolean whiteWins=false;
    public boolean blackWins=false;
    public boolean altBoard=false;
    public ChessBoard chessBoard;
    public String getBoardName(){
        return chessBoard.getBoardName();
    }
    public JPanel getBoard(LinkedList<Piece> ps, Image[] imgs){
        JPanel pn = chessBoard.create(ps, imgs);
        return pn;
    }
    public void setState(State state){
        this.state=state;
    }
    public void setFrame(){
        frame=state.create();
    }
    public void setInvisible(){
        frame.setVisible(false);
    }
    public void newGame(){
        gameState = new GameState(this);
        scoreState=new ScoreState(this);
        whiteWins=false;
        blackWins=false;
        setState(gameState);
        setInvisible();
        setFrame();
    }
    public ChessGame() {
        startState = new StartState(this);
        gameState = new GameState(this);
        scoreState = new ScoreState(this);
        if(chessBoard==null){
            chessBoard=new ChessClassic();
        }
        state = startState;
        setFrame();
    }
}
