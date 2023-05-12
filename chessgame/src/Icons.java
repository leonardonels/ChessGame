import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Icons {

    public static Image imgs[] = new Image[12];
    public static Image[] scan(){
        try {
            BufferedImage all = ImageIO.read(new File("chess.png"));

            int ind = 0;
            for (int y = 0; y < 400; y += 200) {
                for (int x = 0; x < 1200; x += 200) {
                    imgs[ind] = all.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                    ind++;
                }
            }
            return imgs;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
