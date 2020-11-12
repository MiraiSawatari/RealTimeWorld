package remi.realtimeworld;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class RealTimeWorld extends JavaPlugin {
    public static FileConfiguration config;
    public static RealTimeWorld instance;
    private SyncTimeTask SyncTimeTask;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = this.getConfig();
        instance = this;
        startAsyncTask();

    }
    protected void syncTime() {
        timeSetter setter = new timeSetter();
        timeGetter getter = new timeGetter();

        String tzn = config.getString("TimeZone","Asia/Tokyo");
        int time = getter.getMinecraftTimeFromTime(tzn);
        setter.set(time);

    }

    private void startAsyncTask() {
        if ( SyncTimeTask != null ) {
            SyncTimeTask.cancel();
            SyncTimeTask = null;
        }
        int it = config.getInt("Interval",60);
        int it2 = config.getInt("TabInterval",20);
        SyncTimeTask = new SyncTimeTask();
        SyncTimeTask.runTaskTimerAsynchronously(this, 0, it);
    }

}