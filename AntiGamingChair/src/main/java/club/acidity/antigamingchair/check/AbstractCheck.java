package club.acidity.antigamingchair.check;

import club.acidity.antigamingchair.AntiGamingChair;
import club.acidity.antigamingchair.data.PlayerData;
import club.acidity.antigamingchair.event.player.PlayerAlertEvent;
import club.acidity.antigamingchair.event.player.PlayerBanEvent;
import club.acidity.antigamingchair.event.player.PlayerBanWaveEvent;
import org.bukkit.entity.Player;

public abstract class AbstractCheck<T> implements ICheck<T> {
    protected final AntiGamingChair plugin;
    protected final PlayerData playerData;
    private final Class clazz;

    public AbstractCheck(final AntiGamingChair plugin, final PlayerData playerData, final Class clazz) {
        this.plugin = plugin;
        this.playerData = playerData;
        this.clazz = clazz;
    }

    @Override
    public Class getType() {
        return this.clazz;
    }

    protected boolean alert(final PlayerAlertEvent.AlertType alertType, final Player player, final String message) {
        final PlayerAlertEvent event = new PlayerAlertEvent(alertType, player, message);
        this.plugin.getServer().getPluginManager().callEvent(event);
        if (!event.isCancelled()) {
            this.playerData.addViolation(this);
            return true;
        }
        return false;
    }

    protected boolean banWave(final Player player, final String message) {
        this.playerData.setBanWave(true);
        final PlayerBanWaveEvent event = new PlayerBanWaveEvent(player, message);
        this.plugin.getServer().getPluginManager().callEvent(event);
        return !event.isCancelled();
    }

    protected boolean ban(final Player player, final String message) {
        this.playerData.setBanning(true);
        final PlayerBanEvent event = new PlayerBanEvent(player, message);
        this.plugin.getServer().getPluginManager().callEvent(event);
        return !event.isCancelled();
    }

    public AntiGamingChair getPlugin() {
        return this.plugin;
    }

    public PlayerData getPlayerData() {
        return this.playerData;
    }

    public Class getClazz() {
        return this.clazz;
    }
}
