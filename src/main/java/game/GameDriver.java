/************************************************************
 * File:       GameDriver.java
 * Author(s):  CJ Remillard (cjRem44x on Github)
 ************************************************************/
package main.java.game;

import main.java.game.engine.*;

public class GameDriver
{
    private GameEngine engine;

    public GameDriver()
    {
        engine = new GameEngine();
        engine.start();
        engine.loop();
    }
}
