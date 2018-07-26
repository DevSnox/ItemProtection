package me.devsnox.itemprotection.api;

import de.tr7zw.itemnbtapi.NBTItem;
import me.devsnox.itemprotection.ItemProtection;
import me.devsnox.itemprotection.protection.ProtectionLoader;
import org.bukkit.inventory.ItemStack;

public class ItemProtectionAPI {

    private static ItemProtectionAPI instance;

    private ProtectionLoader protectionLoader;

    public ItemProtectionAPI(ItemProtection itemProtection) {
        this.protectionLoader = itemProtection.getProtectionLoader();
        instance = this;
    }

    public ItemStack addProtection(ItemStack itemStack) {
        return this.protectionLoader.addProtection(itemStack);
    }

    public void validate(ItemStack itemStack) {
        this.protectionLoader.validate(this.getID(itemStack));
    }

    public boolean alreadyUsed(ItemStack itemStack) {
        return this.protectionLoader.checkProtection(this.getID(itemStack));
    }

    private int getID(ItemStack itemStack) {
        NBTItem nbtItem = new NBTItem(itemStack);

        if (nbtItem.hasKey("protectionId")) {
            return nbtItem.getInteger("protectionId");
        } else {
            return 0;
        }
    }

    public static boolean isLoaded() {
        return instance != null;
    }

    public static ItemProtectionAPI getInstance() {
        return instance;
    }
}
