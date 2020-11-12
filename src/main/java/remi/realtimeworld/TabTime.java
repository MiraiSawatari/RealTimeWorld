package remi.realtimeworld;

import net.minecraft.server.v1_15_R1.ChatComponentText;
import net.minecraft.server.v1_15_R1.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.TimeZone;

public class TabTime {

    public static void set() {

            String tz = RealTimeWorld.config.getString("TimeZone","Asia/Tokyo");
            Calendar cal = Calendar.getInstance();
            TimeZone tzn = TimeZone.getTimeZone(tz);
            cal.setTimeZone(tzn);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minute = cal.get(Calendar.MINUTE);
            String msg = RealTimeWorld.config.getString("msg","§a%year%§7/§a%month%§7/§a%day% §a%hour%§7:§a%min%");
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.setPlayerListHeaderFooter("\n","\n"+msg.replace("%hour%",Integer.toString(hour)).replace("%min%",String.format("%02d", minute)).replace("%day%",Integer.toString(day)).replace("%month%",Integer.toString(month+1)).replace("%year%",Integer.toString(year))+"\n");
            }


    }
}
