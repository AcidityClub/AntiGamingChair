package club.acidity.antigamingchair.check.impl.inventory;

import club.acidity.antigamingchair.AntiGamingChair;
import club.acidity.antigamingchair.check.checks.PacketCheck;
import club.acidity.antigamingchair.data.PlayerData;
import club.acidity.antigamingchair.event.player.PlayerAlertEvent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayInWindowClick;
import org.bukkit.entity.Player;

public class InventoryA extends PacketCheck {
    public InventoryA(final AntiGamingChair plugin, final PlayerData playerData) {
        super(plugin, playerData);
    }

    @Override
    public void handleCheck(final Player player, final Packet packet) {
        if (!this.playerData.isInventoryOpen() && packet instanceof PacketPlayInWindowClick && ((PacketPlayInWindowClick) packet).a() == 0) {
            this.alert(PlayerAlertEvent.AlertType.EXPERIMENTAL, player, "failed Inventory Check A (Experimental).");
        }
    }
}
