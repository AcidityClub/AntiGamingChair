package club.acidity.antigamingchair.check.impl.badpackets;

import club.acidity.antigamingchair.AntiGamingChair;
import club.acidity.antigamingchair.check.checks.PacketCheck;
import club.acidity.antigamingchair.data.PlayerData;
import club.acidity.antigamingchair.event.player.PlayerAlertEvent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayInFlying;
import org.bukkit.entity.Player;

public class BadPacketsA extends PacketCheck {
    private int streak;

    public BadPacketsA(final AntiGamingChair plugin, final PlayerData playerData) {
        super(plugin, playerData);
    }

    @Override
    public void handleCheck(final Player player, final Packet packet) {
        if (player.getVehicle() == null && packet instanceof PacketPlayInFlying) {
            if (((PacketPlayInFlying) packet).g()) {
                this.streak = 0;
            } else if (++this.streak > 20 && this.alert(PlayerAlertEvent.AlertType.RELEASE, player, "failed Bad Packets Check A.") && !this.playerData.isBanning()) {
                this.ban(player, "Bad Packets Check A");
            }
        }
    }
}
