package club.acidity.antigamingchair.util.api;

import club.acidity.antigamingchair.AntiGamingChair;
import club.acidity.antigamingchair.client.ClientType;
import club.acidity.antigamingchair.data.PlayerData;
import org.bukkit.entity.Player;

public final class AGCAPI {
    public static boolean isCheatBreaker(final Player player) {
        final PlayerData playerData = AntiGamingChair.getInstance().getPlayerDataManager().getPlayerData(player);
        return playerData != null && playerData.getClient() == ClientType.CHEAT_BREAKER;
    }

    public static int getPing(final Player player) {
        final PlayerData playerData = AntiGamingChair.getInstance().getPlayerDataManager().getPlayerData(player);
        if (playerData != null) {
            return (int) playerData.getPing();
        }
        return 0;
    }

}
