package club.acidity.antigamingchair.check.impl.aimassist;

import club.acidity.antigamingchair.AntiGamingChair;
import club.acidity.antigamingchair.check.checks.RotationCheck;
import club.acidity.antigamingchair.data.PlayerData;
import club.acidity.antigamingchair.event.PlayerUpdateRotationEvent;
import club.acidity.antigamingchair.event.player.PlayerAlertEvent;
import club.acidity.antigamingchair.util.MathUtil;
import org.bukkit.entity.Player;

public class AimAssistC extends RotationCheck {
    public AimAssistC(final AntiGamingChair plugin, final PlayerData playerData) {
        super(plugin, playerData);
    }

    @Override
    public void handleCheck(final Player player, final PlayerUpdateRotationEvent event) {
        if (System.currentTimeMillis() - this.playerData.getLastAttackPacket() >= 10000L) {
            return;
        }
        final double diff = MathUtil.getDistanceBetweenAngles(event.getTo().getYaw(), event.getFrom().getYaw());
        double vl = this.playerData.getCheckVl(this);
        if (event.getFrom().getPitch() == event.getTo().getPitch() && diff >= 3.0 && event.getFrom().getPitch() != 90.0f && event.getTo().getPitch() != 90.0f) {
            if ((vl += 0.9) >= 5.0) {
                this.alert(PlayerAlertEvent.AlertType.EXPERIMENTAL, player, String.format("failed Aim Assist Check C (Experimental). YD %.1f. VL %.1f.", diff, vl));
            }
        } else {
            vl -= 1.6;
        }
        this.playerData.setCheckVl(vl, this);
    }
}
