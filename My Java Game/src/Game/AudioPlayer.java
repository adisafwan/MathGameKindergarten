package Game;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import java.util.HashMap;
import java.util.Map;

public class AudioPlayer {

    public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
    public static Map<String, Music> musicMap = new HashMap<String, Music>();

    public static void load(){

        try {
            soundMap.put("menu_sound", new Sound("res/Mouse Click - Sound Effect (HD).ogg"));
            musicMap.put("music", new Music("res/Tetris 99 - Main Theme.ogg"));
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }

    public static Music getMusic(String key){
        return musicMap.get(key);
    }

    public static Sound getSound(String key){
        return soundMap.get(key);
    }



}
