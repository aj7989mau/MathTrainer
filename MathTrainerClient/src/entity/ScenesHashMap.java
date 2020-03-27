package entity;


import javafx.scene.Scene;

import java.util.HashMap;

public class ScenesHashMap {
    private HashMap<ScenesEnum, Scene> scenes = new HashMap<>();

    public synchronized void put(ScenesEnum name, Scene scene){
        scenes.put(name, scene);
    }

    public synchronized Scene get(ScenesEnum name){ return scenes.get(name); }
}
