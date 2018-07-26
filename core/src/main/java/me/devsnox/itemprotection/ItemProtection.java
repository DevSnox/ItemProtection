package me.devsnox.itemprotection;

import me.devsnox.itemprotection.api.ItemProtectionAPI;
import me.devsnox.itemprotection.protection.ProtectionLoader;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemProtection extends JavaPlugin {

    private ProtectionLoader protectionLoader;

    @Override
    public void onEnable() {
        this.protectionLoader = new ProtectionLoader(this);
        new ItemProtectionAPI(this);
    }

    public ProtectionLoader getProtectionLoader() {
        return protectionLoader;
    }
}
