package club.acidity.antigamingchair.check.checks;

import club.acidity.antigamingchair.AntiGamingChair;
import club.acidity.antigamingchair.check.AbstractCheck;
import club.acidity.antigamingchair.data.PlayerData;
import club.acidity.antigamingchair.event.PlayerUpdateRotationEvent;

public abstract class RotationCheck extends AbstractCheck<PlayerUpdateRotationEvent> {
    public RotationCheck(final AntiGamingChair plugin, final PlayerData playerData) {
        super(plugin, playerData, PlayerUpdateRotationEvent.class);
    }
}
