package Game;

import java.util.Random;

public class Spawn {

    private  Handler handler;
    private HUD hud;
    private Random r = new Random();

    private int scoreDefault = 0;

    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }

    public void tick(){
        scoreDefault++;

        if(scoreDefault >= 250){
            scoreDefault = 0;
            hud.setLevel(hud.getLevel() + 1);
            handler.addObject(new Enemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.Enemy, handler));

            if(hud.getLevel() >= 5){
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.FastEnemy, handler));
            }

        }
    }

}
