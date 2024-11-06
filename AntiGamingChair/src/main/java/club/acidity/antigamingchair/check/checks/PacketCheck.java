package club.acidity.antigamingchair.check.checks;

import club.acidity.antigamingchair.AntiGamingChair;
import club.acidity.antigamingchair.check.AbstractCheck;
import club.acidity.antigamingchair.data.PlayerData;
import net.minecraft.server.v1_8_R3.Packet;

public abstract class PacketCheck extends AbstractCheck<Packet> {
    public PacketCheck(final AntiGamingChair plugin, final PlayerData playerData) {
        super(plugin, playerData, Packet.class);
    }
}
