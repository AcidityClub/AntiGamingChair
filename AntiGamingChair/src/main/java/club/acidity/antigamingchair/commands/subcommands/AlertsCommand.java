package club.acidity.antigamingchair.commands.subcommands;

import club.acidity.antigamingchair.AntiGamingChair;
import java.beans.ConstructorProperties;
import club.acidity.antigamingchair.util.CC;
import org.bukkit.entity.Player;

public class AlertsCommand implements SubCommand {
   private final AntiGamingChair plugin;

   public void execute(Player player, Player target, String[] args) {
      this.plugin.getAlertsManager().toggleAlerts(player);
      player.sendMessage(this.plugin.getAlertsManager().hasAlertsToggled(player)? CC.GREEN + "Subscribed to AGC alerts.":CC.RED + "Unsubscribed from AGC alerts.");
   }

   @ConstructorProperties({"plugin"})
   public AlertsCommand(AntiGamingChair plugin) {
      this.plugin = plugin;
   }
}
