package club.acidity.antigamingchair.commands.subcommands;

import club.acidity.antigamingchair.AntiGamingChair;
import club.acidity.antigamingchair.data.PlayerData;
import club.acidity.antigamingchair.util.CC;
import java.beans.ConstructorProperties;

import club.acidity.antigamingchair.util.StringUtil;
import org.bukkit.entity.Player;

public class WatchCommand implements SubCommand {
   private final AntiGamingChair plugin;

   public void execute(Player player, Player target, String[] args) {
      if(target == null) {
         player.sendMessage(String.format(StringUtil.PLAYER_NOT_FOUND, new Object[]{args[1]}));
      } else {
         PlayerData targetData = this.plugin.getPlayerDataManager().getPlayerData(target);
         targetData.togglePlayerWatching(player);
         player.sendMessage(targetData.isPlayerWatching(player)?CC.L_PURPLE + "You are now watching " + CC.D_PURPLE + target.getName():CC.L_PURPLE + "You are no longer watching " + CC.D_PURPLE + target.getName());
      }

   }

   @ConstructorProperties({"plugin"})
   public WatchCommand(AntiGamingChair plugin) {
      this.plugin = plugin;
   }
}
