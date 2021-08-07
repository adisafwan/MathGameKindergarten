package Game;

import java.awt.*;

public class FastEnemy extends GameObject{

    private Handler handler;

    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 9;
        velY = 9;

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT - 64) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.create();
        g.fillRect(x, y, 32, 32);
    }
}
