import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartState extends JFrame implements State, ActionListener {
    public JButton startButton;
    public JButton optionButtonA;
    public JButton optionButtonB;
    public JButton exitButton;
    public ChessGame chessGame;
    public StartState(ChessGame chessGame){
        this.chessGame=chessGame;
    }
    @Override
    public JFrame create() {
        ImageIcon logo = new ImageIcon("chessLogo.jpg");

        JLabel label=new JLabel();
        label.setText("ChessGame");
        label.setIcon(logo);
        label.setBackground(Color.white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setIconTextGap(5);
        label.setFont(new Font("MV Boli", Font.PLAIN, 32));
        label.setOpaque(true);

        startButton=new JButton();
        startButton.setBounds(128,322,256,50);
        startButton.addActionListener(this);
        startButton.setText("START");

        optionButtonA =new JButton();
        optionButtonA.setBounds(128,382,128,50);
        optionButtonA.addActionListener(this);
        optionButtonA.setText("REVERSE BOARD");

        optionButtonB =new JButton();
        optionButtonB.setBounds(256,382,128,50);
        optionButtonB.addActionListener(this);
        optionButtonB.setText("CHANGE COLOR");

        exitButton=new JButton();
        exitButton.setBounds(128,442,256,50);
        exitButton.addActionListener(this);
        exitButton.setText("EXIT GAME");

        JPanel startButtonPanel=new JPanel();
        startButtonPanel.setBackground(Color.white);
        startButtonPanel.setBounds(0,322,512,(512-332));
        startButtonPanel.setLayout(null);
        startButtonPanel.add(startButton);
        startButtonPanel.add(optionButtonA);
        startButtonPanel.add(optionButtonB);
        startButtonPanel.add(exitButton);

        JPanel startMenuPanel=new JPanel();
        startMenuPanel.setBackground(Color.white);
        startMenuPanel.setLayout(new BorderLayout());
        startMenuPanel.add(label);
        startMenuPanel.setBounds(0,0,512,332);

        JFrame frame = new JFrame("Chess");
        frame.setBounds(256, 128, 512, 512);
        frame.setResizable(false);
        frame.setUndecorated(true);

        frame.add(startMenuPanel);
        frame.add(startButtonPanel);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

        return frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startButton){
            if(Main.debugMode)System.out.println("startButton");
            chessGame.setInvisible();
            chessGame.setState(chessGame.gameState);
            chessGame.setFrame();
        }
        if(e.getSource()== optionButtonA){
            chessGame.altBoard=!chessGame.altBoard;
            if(Main.debugMode)System.out.println("optionButtonA "+chessGame.altBoard);
        }
        if(e.getSource()== optionButtonB){
            if(chessGame.getBoardName()=="classic"){
                chessGame.chessBoard=new DesertBoard();
            } else if (chessGame.getBoardName()=="desert") {
                chessGame.chessBoard=new ChessClassic();
            }
            if(Main.debugMode)System.out.println("optionButtonB "+chessGame.getBoardName());

        }
        if(e.getSource()==exitButton){
            if(Main.debugMode)System.out.println("exitButton");
            if(Main.debugMode)System.exit(0);
        }
    }
}
