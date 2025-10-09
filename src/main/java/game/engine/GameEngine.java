/************************************************************
 * File:       GameEngine.java
 * Author(s):  CJ Remillard (cjRem44x on Github)
 ************************************************************/
package main.java.game.engine;

public class GameEngine
{
    public boolean isGameRunning;

    public void start()
    {
        isGameRunning = true;
    }

    public void loop()
    {
        while (isGameRunning)
        {
            // loop code...
            System.out.println("[LOG] looping engine...");
            isGameRunning = false;

            // give break to CPU and create 1 ms step
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("[LOG] Game program is terminating!");
    }
}
