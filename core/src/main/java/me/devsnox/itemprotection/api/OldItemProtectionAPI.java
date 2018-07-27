package me.devsnox.itemprotection.api;

import de.tr7zw.itemnbtapi.NBTItem;
import me.devsnox.itemprotection.ItemProtection;
import me.devsnox.itemprotection.protection.ProtectionLoader;
import org.bukkit.inventory.ItemStack;

@Deprecated
public class OldItemProtectionAPI
{
    private static OldItemProtectionAPI instance;
    private final ProtectionLoader protectionLoader;
    
    public OldItemProtectionAPI(ItemProtection itemProtection)
    {
        this.protectionLoader = itemProtection.getProtectionLoader();
        instance = this;
    }
    
    public static boolean isLoaded()
    {
        return instance != null;
    }
    
    public static OldItemProtectionAPI getInstance()
    {
        return instance;
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
}
