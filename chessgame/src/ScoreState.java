import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreState extends JFrame implements State, ActionListener {
    public ChessGame chessGame;
    public JButton newGameButton;
    public JButton exitButton;
    public JButton optionButtonA;
    public JButton optionButtonB;
    public ScoreState(ChessGame chessGame){
        this.chessGame=chessGame;
    }
    @Override
    public JFrame create() {

        newGameButton = new JButton("NEW GAME");
        newGameButton.setBounds(128,322,256,50);
        newGameButton.addActionListener(this);

        optionButtonA =new JButton();
        optionButtonA.setBounds(128,382,128,50);
        optionButtonA.addActionListener(this);
        optionButtonA.setText("REVERSE BOARD");

        optionButtonB =new JButton();
        optionButtonB.setBounds(256,382,128,50);
        optionButtonB.addActionListener(this);
        optionButtonB.setText("CHANGE COLOR");

        exitButton = new JButton("EXIT GAME");
        exitButton.setBounds(128,442,256,50);
        exitButton.addActionListener(this);

        JLabel label = new JLabel("WHITE WINS!");
        if(chessGame.whiteWins&&!chessGame.blackWins) {
            label.setText("WHITE WINS!");
        } else if (chessGame.blackWins&&!chessGame.whiteWins) {
            label.setText("BLACK WINS!");
        }else{
            label.setText("DRAW!");
        }
        label.setBackground(Color.white);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("MV Boli", Font.PLAIN, 32));
        label.setOpaque(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(0,0,512,322);
        panel.setLayout(new BorderLayout());
        panel.add(label);

        JPanel buttons = new JPanel();
        buttons.setBackground(Color.white);
        buttons.setBounds(0,332, 512, (512-322));
        buttons.setLayout(null);
        buttons.add(newGameButton);
        buttons.add(optionButtonA);
        buttons.add(optionButtonB);
        buttons.add(exitButton);

        JFrame frame = new JFrame();
        frame.setBounds(256, 128, 512, 512);
        frame.setResizable(false);
        frame.setUndecorated(true);

        frame.add(panel);
        frame.add(buttons);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        return frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newGameButton){
            System.out.println("newGameButton");
            chessGame.newGame();
        }
        if(e.getSource()== optionButtonA){
            chessGame.altBoard=!chessGame.altBoard;
            if(Main.debugMode)System.out.println("optionButtonA "+chessGame.altBoard);
        }
        if(e.getSource()== optionButtonB){
            if(chessGame.getBoardName().equals("classic")){
                chessGame.chessBoard=new DesertBoard();
            } else if (chessGame.getBoardName().equals("desert")) {
                chessGame.chessBoard=new ChessClassic();
            }
            if(Main.debugMode)System.out.println("optionButtonB "+chessGame.getBoardName());
        }
        if(e.getSource()==exitButton){
            if(Main.debugMode)System.out.println("exitButton");
            System.exit(0);
        }
    }
}
