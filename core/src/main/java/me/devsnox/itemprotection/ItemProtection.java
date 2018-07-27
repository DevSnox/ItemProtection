package me.devsnox.itemprotection;

import me.devsnox.itemprotection.api.ItemProtectionAPI;
import me.devsnox.itemprotection.api.ItemProtectionFactory;
import me.devsnox.itemprotection.api.SimpleItemProtection;
import me.devsnox.itemprotection.protection.ProtectionLoader;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemProtection extends JavaPlugin {

    private ProtectionLoader protectionLoader;

    @Override
    public void onEnable() {
        this.protectionLoader = new ProtectionLoader(getDataFolder());
        new ItemProtectionAPI(this);
        ItemProtectionFactory.INSTANCE.setItemProtection(new SimpleItemProtection());
        
    }

    public ProtectionLoader getProtectionLoader() {
        return this.protectionLoader;
    }
}
