package club.acidity.antigamingchair.packet;

import club.acidity.antigamingchair.AntiGamingChair;
import club.acidity.antigamingchair.event.PlayerUpdatePositionEvent;
import club.acidity.antigamingchair.event.PlayerUpdateRotationEvent;
import club.minemen.spigot.handler.MovementHandler;
import net.minecraft.server.v1_8_R3.PacketPlayInFlying;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class CustomMoveHandler implements MovementHandler {
    private final AntiGamingChair plugin;

    public CustomMoveHandler(final AntiGamingChair plugin) {
        this.plugin = plugin;
    }

    public void handleUpdateLocation(final Player arg0, final Location arg1, final Location arg2, final PacketPlayInFlying arg3) {
        final PlayerUpdatePositionEvent event = new PlayerUpdatePositionEvent(arg0, arg2, arg2);
        if (!event.isCancelled()) {
            Bukkit.getPluginManager().callEvent(event);
        }
    }

    public void handleUpdateRotation(final Player arg0, final Location arg1, final Location arg2, final PacketPlayInFlying arg3) {
        final PlayerUpdateRotationEvent event = new PlayerUpdateRotationEvent(arg0, arg2, arg2);
        if (!event.isCancelled()) {
            Bukkit.getPluginManager().callEvent(event);
        }
    }
}
