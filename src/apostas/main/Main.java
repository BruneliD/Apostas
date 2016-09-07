package apostas.main;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin
{
	public static Plugin plugin;
	 public static Economy economy = null;
	//...
	 
	 private boolean setupEconomy()
	    {
	        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
	        if (economyProvider != null) {
	            economy = economyProvider.getProvider();
	        }

	        return (economy != null);
	    }
	
	public void onEnable() {
		plugin = this;
		setupEconomy();
		getServer().getConsoleSender().sendMessage(" ");
		getServer().getConsoleSender().sendMessage("§7====================");
		getServer().getConsoleSender().sendMessage("§a§l[APOSTAS] §a Plugin habilitado com sucesso!");
		try{
			saveDefaultConfig();
			getServer().getConsoleSender().sendMessage("§a§l[APOSTAS] §aConfig foi carregada!");
		}catch(Exception e) {
			getServer().getConsoleSender().sendMessage("§a§l[APOSTAS] §cConfig nao foi carregada!");
		}
		getServer().getConsoleSender().sendMessage("§7====================");
		getServer().getConsoleSender().sendMessage(" ");
		events();
		commands();
		
	}
	
	public void onDisable() {
	}
	
	public void events() {
		getServer().getPluginManager().registerEvents(new ApostasListener(), this);
	}
	
	public void commands() {
		getCommand("apostar").setExecutor(new ApostasCmds());
	}
	
	public static Plugin getPlugin() {
		return plugin;
	}
	

	
	
}
