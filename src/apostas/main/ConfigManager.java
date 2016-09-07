package apostas.main;

import java.util.List;

public class ConfigManager {
	
	public static String getString(String text) {
		return Main.getPlugin().getConfig().getString(text).replace("&", "§");
	}
	
	public static Integer getInt(String text) {
		return Main.getPlugin().getConfig().getInt(text);
	}
	
	public static List<String> getList(String text) {
		return Main.getPlugin().getConfig().getStringList(text);
	}
	
	public static void setConfig(String text, String c) {
		Main.getPlugin().getConfig().set(text, c);
		Main.getPlugin().saveConfig();
	}

}
