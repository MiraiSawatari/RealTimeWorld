package remi.realtimeworld;

import org.bukkit.scheduler.BukkitRunnable;


public class SyncTimeTask extends BukkitRunnable {


    @Override
    public void run() {


        new BukkitRunnable() {
            public void run() {
                RealTimeWorld.instance.syncTime();
            }
        }.runTask(RealTimeWorld.instance);
    }
}