package Game;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class Windows extends Canvas {

    @Serial
    private static final long serialVersionUID = -240840600533728354L;

    ImageIcon imageIcon = new ImageIcon("C:\\Users\\User\\Pictures\\space");
    JLabel label = new JLabel(imageIcon);

    public Windows(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();



    }
}
