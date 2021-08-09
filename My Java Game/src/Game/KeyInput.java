package Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLOutput;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean keyDown[] = new boolean[4];

    Game game;

    public KeyInput(Handler handler, Game game){
        this.handler = handler;
        this.game = game;

        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
    }

    // Key pressed method
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i ++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player){
                //key events for Player 1
                if(key == KeyEvent.VK_W) { tempObject.setVelY(-10); keyDown[0] = true; }
                if(key == KeyEvent.VK_S) { tempObject.setVelY(10); keyDown[1] = true; }
                if(key == KeyEvent.VK_A) { tempObject.setVelX(-10); keyDown[2] = true; }
                if(key == KeyEvent.VK_D) { tempObject.setVelX(10); keyDown[3] = true; }
            }

            if(tempObject.getId() == ID.Player2){
                //key events for Player 2
                if(key == KeyEvent.VK_UP) tempObject.setVelY(-10);
                if(key == KeyEvent.VK_DOWN) tempObject.setVelY(10);
                if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-10);
                if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(10);
            }

            if (key == KeyEvent.VK_P){
                if(game.gameState == Game.STATE.Game){
                    if(Game.paused) Game.paused = false;
                    else Game.paused = true;
                }
            }
            if (key == KeyEvent.VK_ESCAPE) System.exit(1);
        }

    }

    // Key released method
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i ++){
            GameObject tempObject = handler.object.get(i);

        if(tempObject.getId() == ID.Player){
            //key events for Player 1
            if(key == KeyEvent.VK_W) keyDown[0] = false;
            if(key == KeyEvent.VK_S) keyDown[1] = false;
            if(key == KeyEvent.VK_A) keyDown[2] = false;
            if(key == KeyEvent.VK_D) keyDown[3] = false;

            // Vertical movement
            if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
            if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
        }

        if(tempObject.getId() == ID.Player2){
            //key events for Player 2
            if(key == KeyEvent.VK_UP) tempObject.setVelY(0);
            if(key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
            if(key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
            if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
        }


        }
    }
}
