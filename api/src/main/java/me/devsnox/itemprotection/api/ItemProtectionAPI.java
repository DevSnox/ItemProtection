package me.devsnox.itemprotection.api;

import org.bukkit.inventory.ItemStack;

public class ItemProtectionAPI {

    private static ItemProtectionAPI instance;

    public ItemStack addProtection(ItemStack itemStack) { return null; }

    public void validate(ItemStack itemStack) { }

    public boolean alreadyUsed(ItemStack itemStack) { return false; }

    public static boolean isLoaded() { return instance != null; }

    public static ItemProtectionAPI getInstance() { return instance;
    }
}
