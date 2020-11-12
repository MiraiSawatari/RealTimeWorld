package remi.realtimeworld;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Arrays;
import java.util.List;

public class timeSetter {
    public static void set(int mctime) {
        FileConfiguration conf = RealTimeWorld.instance.getConfig();
        String ignores = conf.getString("IgnoreWorlds","");
        List<String> ignoreWorlds = Arrays.asList(ignores.split(","));
        for (World world : Bukkit.getWorlds()) {
            if (!ignores.contains(world.getName())) {
                long days = world.getFullTime() / 24000;
                long time = days * 24000 + mctime;
                world.setFullTime(time);
            }
        }
    }
}
