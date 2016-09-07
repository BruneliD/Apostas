package apostas.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ApostasCmds extends ConfigManager implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cTem que ser jogador para executar este comando!");
			return true;
		}

		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("apostar")) {
			spawnarVillager(p.getLocation());
			return true;
		}

		return false;
	}

	@SuppressWarnings("deprecation")
	public static void spawnarVillager(Location local) {
		Villager v = (Villager) Bukkit.getServer().getWorld(local.getWorld().getName()).spawnEntity(local,
				EntityType.VILLAGER);
		v.setCanPickupItems(false);
		v.setAdult();
		v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 9999999, 255));
		v.setHealth(20);
		v.setCustomName("§e§lAPOSTAS");
		v.setProfession(Profession.LIBRARIAN);

	}
	
	

}
