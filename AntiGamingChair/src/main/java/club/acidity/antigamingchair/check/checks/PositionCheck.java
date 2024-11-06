package club.acidity.antigamingchair.check.checks;

import club.acidity.antigamingchair.AntiGamingChair;
import club.acidity.antigamingchair.check.AbstractCheck;
import club.acidity.antigamingchair.data.PlayerData;
import club.acidity.antigamingchair.event.PlayerUpdatePositionEvent;

public abstract class PositionCheck extends AbstractCheck<PlayerUpdatePositionEvent> {
    public PositionCheck(final AntiGamingChair plugin, final PlayerData playerData) {
        super(plugin, playerData, PlayerUpdatePositionEvent.class);
    }
}
