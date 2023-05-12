import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public interface ChessBoard {
    public abstract String getBoardName();
    public abstract JPanel create(LinkedList<Piece> ps, Image[] imgs);
}
